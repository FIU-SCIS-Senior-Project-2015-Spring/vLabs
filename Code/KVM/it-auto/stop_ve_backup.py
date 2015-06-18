#!/usr/bin/python

import sys
import os.path
import re
import subprocess
import time

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

# VMNAT = "/home/sadjadi-vmstorage/sadjadi-vms/it-auto/vmnat.sh"
VMNAT = os.environ["VMNAT"]

HOSTS = {"3": "/home/ita-vm1/vm-storage/portal/exams",
         "4": "/home/serval/serval-vm-storage/portal/exams",
         "5": "/home/vc1/vm-storage/portal/exams",
         "6": "/home/vc2/vm-storage/portal/exams",
         "7": "/home/vc3/vm-storage/portal/exams",
         "1": "/home/sadjadi-vmstorage/sadjadi-vms/nobackup/portal_home/exams"
         }


# FIXME: this information already exists in start_ve
NUM_ROUTERS = 12
ROUTER_IPS = ["172.16.48.%3d" % (100+i) for i in range(NUM_ROUTERS)]

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

if not HOSTS.has_key(host_id):
    print "Invalid host id: %s" % host_id
    sys.exit(1)

ASSIGNED = os.path.join(HOSTS[host_id], "assigned")

router_ip = ROUTER_IPS[router_id-1]
    
try:
    # drop all rules from the firewall
    vmnat_cmd = "sudo %s del %d %s %d %d" % (VMNAT, first_port, router_ip, RPORT_START, num_ports)
    retcode = subprocess.call([vmnat_cmd],shell=True)
    if retcode < 0:
        print >>sys.stderr, "sudo as terminated by signal", -retcode
    else:
        print >>sys.stderr, "sudo returned", retcode
except OSError, e:
    print >>sys.stderr, "sudo execution failed:", e

unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)

# find all directories that start with ve_type-username
# match_str = "%s-%s-%s" % (ve_type, username, router_id)
# match_str = username
match_str = unique_instance_name
exams = filter(lambda x: re.match(match_str, x), os.listdir(ASSIGNED))
full_paths = map(lambda x: os.path.join(ASSIGNED, x), exams)

# just to make sure! ;)
# for reassure in range(1, 2):
if True:

    # Get all ve directories that have started
    # started_exams = filter(lambda x: os.path.exists(os.path.join(x,".started")) , full_paths)
    started_exams = full_paths
 
    # for each exam
    for e in started_exams:
        # get all vm dirs
        vm_dirs = filter(os.path.isdir, map(lambda x: os.path.join(e,x), os.listdir(e)))

        # get the vmx files in each directory
        vmx_files = []
        for d in vm_dirs:
            f = filter(lambda x: re.match(r'[^.]+\.vmx$', x), os.listdir(d))
            vmx_files.append(os.path.join(d, f[0]))

        # stop and unregister the vms
        for vmx in vmx_files:

            powermode = "soft"
            if os.path.basename(vmx) == "kaseya.vmx":
                powermode = "trysoft"
        
            # # stop_cmd = "vmware-cmd %s stop %s &" % (vmx,powermode)
            # stop_cmd = "vmware-cmd %s suspend %s" % (vmx,powermode)
  
            # # print stop_cmd
            # # subprocess.call([stop_cmd],shell=True)

            # # unregister_cmd = "vmware-cmd -s unregister %s &" % vmx
            # unregister_cmd = "vmware-cmd -s unregister %s" % vmx

            # # print unregister_cmd
            # # subprocess.call([unregister_cmd],shell=True)

            # combined_cmd = "(" + stop_cmd + "; sleep 2; " + unregister_cmd + ";) &";
            # print combined_cmd
            # subprocess.call([combined_cmd],shell=True)
      
            stop_vm_cmd = "stop_vm.py %s &" % vmx
            print "Command: " + stop_vm_cmd
            subprocess.call([stop_vm_cmd], shell=True)


        # mark the exam as stopped
        os.rename(os.path.join(e,".started"), os.path.join(e,".stopped"))

    # time.sleep(1)

    
