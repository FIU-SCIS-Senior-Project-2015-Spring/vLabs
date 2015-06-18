#!/usr/bin/python

import sys
import os.path
import re
import subprocess
import time

from storages import *

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
# HOME = os.environ["HOME"]+"/exams"

VMNAT = "/lclhome/dgonz023/it-auto/vmnat.sh"
#VMNAT = os.environ["VMNAT"]

# FIXME: this information already exists in start_ve
NUM_ROUTERS = 12
ROUTER_IPS = ["192.168.122.%3d" % (101+i) for i in range(NUM_ROUTERS)]

RPORT_START=1024

if (len(sys.argv) != 7):
    print "Usage: %s <username> <ve_type> <first_port> <num_ports> <router_id> <storage_id>" % sys.argv[0]
    sys.exit(1)

username = sys.argv[1]
ve_type = sys.argv[2]
first_port = int(sys.argv[3])
num_ports = int(sys.argv[4])
router_id = int(sys.argv[5])
storage_id = sys.argv[6]

if not STORAGES.has_key(storage_id):
    print "Invalid host id: %s" % storage_id
    sys.exit(1)

ASSIGNED = os.path.join(STORAGES[storage_id], "assigned")
TEMPLATES = os.path.join(STORAGES[storage_id], "templates")
PROVISIONED = os.path.join(STORAGES[storage_id], "provisioned")
ROUTERS = os.path.join(STORAGES[storage_id], "routers")

router_qcow2 = ROUTERS + "/" + ve_type + "/Router" + str(router_id) + "/DSL.qcow2"
print router_qcow2

router_name = "Router" + str(router_id)
restore_router = router_qcow2 + ".restore"

router_ip = ROUTER_IPS[router_id-1]
    
try:
    # drop all rules from the firewall
    vmnat_cmd = "sudo %s del %d %s %d %d" % (VMNAT, first_port, router_ip, RPORT_START, num_ports)
    print "vmnat_cmd: " + vmnat_cmd 
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
    # SMS 6/8/2014
    # stoping the corresponding router
    stop_cmd  = "virsh save %s %s" % (router_name, restore_router)
    cmd = stop_cmd
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)
#    unregister_cmd = "vmware-cmd -s unregister %s" % router_vmx
#    cmd = unregister_cmd
#    print "Command: " + cmd
#    subprocess.call([cmd], shell=True)

    # Get all ve directories that have started
    # started_exams = filter(lambda x: os.path.exists(os.path.join(x,".started")) , full_paths)
    started_exams = full_paths

    port_offset = -1
    # for each exam
    for e in started_exams:
        # get all vm dirs
        vm_dirs = filter(os.path.isdir, map(lambda x: os.path.join(e,x), os.listdir(e)))

        # get the snapshot-qcow2 files in each directory
        qcow2_files = []
        for d in vm_dirs:
            f = filter(lambda x: re.match(r'.*snap.*\.qcow2$', x), os.listdir(d))
            qcow2_files.append(os.path.join(d, f[0]))
        
        qcow2_files.sort()
        # stop and unregister the vms
        for qcow2 in qcow2_files:
            
            port_offset = port_offset + 1
            unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port+port_offset)
#            powermode = "soft"
#            if os.path.basename(vmx) == "kaseya.vmx":
#                powermode = "trysoft"
        
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
      
            # stop_vm_cmd = "stop_vm.py %s &" % vmx
            stop_vm_cmd = "/lclhome/dgonz023/it-auto/stop_vm2.py %s %s" % (qcow2, unique_instance_name)
            print "Command: " + stop_vm_cmd
            subprocess.call([stop_vm_cmd], shell=True)

#            retcode1 = 1
#            while retcode1 != 0:
#                retcode1 = subprocess.call([stop_vm_cmd], shell=True)
#                print "retcode1 = %d" % retcode1


        # mark the exam as stopped
        if os.path.exists(os.path.join(e,".stopped")) == False:
            open(os.path.join(e,".stopped"),"w").close()
        if os.path.exists(os.path.join(e,".started")) == True:
            os.remove(os.path.join(e,".started"))

    # time.sleep(1)

   
# 111 means that this call was successful
print "Successfully reached to the end of this script!"
sys.exit(111) 
