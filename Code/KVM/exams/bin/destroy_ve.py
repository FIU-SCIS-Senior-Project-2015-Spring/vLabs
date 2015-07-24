#!/usr/bin/python

import libvirt
import sys
import os.path
import re
import subprocess
import time
import shutil

from storages import *

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

# VMNAT = "/home/sadjadi-vmstorage/sadjadi-vms/it-auto/vmnat.sh"
VMNAT = os.environ["VMNAT"]

# FIXME: this information already exists in start_ve
ROUTER_IPS = ["192.168.122.101", "192.168.122.102", "192.168.122.103", "192.168.122.104","192.168.122.105","192.168.122.106","192.168.122.107","192.168.122.108"]
RPORT_START=1024

TEMPLATES = os.path.join(HOME, "templates")
PROVISIONED = os.path.join(HOME, "provisioned")
#ASSIGNED = os.path.join(HOME, "assigned")

if (len(sys.argv) != 7):
    print "Usage: %s <username> <ve_type> <first_port> <num_ports> <router_id> <host_id>" % sys.argv[0]
    sys.exit(1)

username = sys.argv[1]
ve_type = sys.argv[2]
first_port = int(sys.argv[3])
num_ports = int(sys.argv[4])
router_id = int(sys.argv[5])
host_id = sys.argv[6]

if not STORAGES.has_key(host_id):
    print "Invalid host id: %s" % host_id
    sys.exit(1)

ASSIGNED = os.path.join(STORAGES[host_id], "assigned")

router_ip = ROUTER_IPS[router_id-1]

unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)

# drop all rules from the firewall
vmnat_cmd = "sudo %s del %d %s %d %d" % (VMNAT, first_port, router_ip, RPORT_START, num_ports)
subprocess.call([vmnat_cmd],shell=True)

assigned_dir = ASSIGNED + "/%s" % unique_instance_name
provisioned_dir = os.readlink(assigned_dir);
print "provisioned_dir is %s" % provisioned_dir

# find all directories that start with ve_type-username
# match_str = "%s-%s-%s" % (ve_type, username, router_id)
# match_str = username
match_str = unique_instance_name
exams = filter(lambda x: re.match(match_str, x), os.listdir(ASSIGNED))
full_paths = map(lambda x: os.path.join(ASSIGNED, x), exams)

# Get all ve directories that have started
# started_exams = filter(lambda x: os.path.exists(os.path.join(x,".started")) , full_paths)
started_exams = full_paths
print "started_exams: %s" % started_exams 

# for each exam
for e in started_exams:
    # get all vm dirs
    vm_dirs = filter(os.path.isdir, map(lambda x: os.path.join(e,x), os.listdir(e)))

    # get the vmx files in each directory
   # vmx_files = []
   # for d in vm_dirs:
   #     f = filter(lambda x: re.match(r'[^.]+\.vmx$', x), os.listdir(d))
   #     vmx_files.append(os.path.join(d, f[0]))

    # get the domain name
    conn = libvirt.open("qemu:///system")
    i = 0
    
    while i < 5:
        try:
            dom_name = "%s-%s-%d" % (username, ve_type, first_port + i)
            dom = conn.lookupByName(dom_name)
            dom.destroy()

            while dom.isActive():
                if not dom.isActive():
                    break
            dom.undefine()
        except:
            print "Exception"
        i = i + 1
    try:
        router_name = "Router%d"% router_id
        dom = conn.lookupByName(router_name)
        dom.destroy()
        while dom.isActive():
            if not dom.isActive():
                break
        dom.undefine()
    except:
        print "Exception"
    # stop and unregister the vms
    #for vmx in vmx_files:

    #    powermode = "soft"
    #    if os.path.basename(vmx) == "kaseya.vmx":
    #        powermode = "trysoft"
        
        # stop_cmd = "vmware-cmd %s stop %s &" % (vmx,powermode)
    #    stop_cmd = "vmware-cmd %s suspend %s" % (vmx,powermode)

    #    print stop_cmd
    #    subprocess.call([stop_cmd],shell=True)

        # unregister_cmd = "vmware-cmd -s unregister %s &" % vmx
    #    unregister_cmd = "vmware-cmd -s unregister %s" % vmx

        # print unregister_cmd
    #    subprocess.call([unregister_cmd],shell=True)


    # mark the exam as stopped
    # os.rename(os.path.join(e,".started"), os.path.join(e,".stopped"))

os.remove(assigned_dir);
shutil.rmtree(provisioned_dir);
