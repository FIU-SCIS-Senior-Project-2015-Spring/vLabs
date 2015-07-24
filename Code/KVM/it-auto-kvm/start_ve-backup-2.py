#!/usr/bin/python

import sys
import re
import os
import subprocess
import libvirt

#from vmxutil import vmx
from storages import *

# globals

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
# HOME = os.environ["STORAGES[storage_id]"]+"/exams"

# VMNAT = "/home/sadjadi-vmstorage/sadjadi-vms/it-auto-kvm/vmnat.sh"
VMNAT = os.environ["VMNAT"]

XP_PARAMS = {"memory": 1024, "ncpus": 1}
DC_PARAMS = {"memory": 2048, "ncpus": 1}

NUM_ROUTERS = 12

ROUTER_IPS = ["192.168.122.%3d" % (101+i) for i in range(NUM_ROUTERS)]

RPORT_START=1024

register_action = None
# 0 = needs provisioning, assignment, and registration (First time anywhere)
# 1 means that you only need to register (Has already been provisioned and assigned on another host)
# 2 means that there is no need to register (Has already been provisioned and assigned on this host)


def needs_provision():
    return register_action == "0"

def needs_register():
#    return register_action == "0" or register_action == "1"
# always register
    return register_action == "0" or register_action == "1" or register_action == "2"

def is_checkpointed():
    return register_action == "1" or register_action == "2"


if len(sys.argv) != 10:
    print "Usage: %s <username> <ve_type> <first_port> <num_ports> <first_mac> <num_macs> <router_id> <storage_id> <register_action>" % sys.argv[0]
    sys.exit(1)

username = sys.argv[1]
ve_type = sys.argv[2]
first_port = int(sys.argv[3])
num_ports = int(sys.argv[4])
first_mac = int(sys.argv[5])
num_macs = int(sys.argv[6])
router_id = int(sys.argv[7])
storage_id = sys.argv[8]
register_action = sys.argv[9]

if not STORAGES.has_key(storage_id):
    print "Invalid storage_id: %s" % storage_id
    sys.exit(1)

ASSIGNED = os.path.join(STORAGES[storage_id], "assigned")
TEMPLATES = os.path.join(STORAGES[storage_id], "templates")
PROVISIONED = os.path.join(STORAGES[storage_id], "provisioned")
ROUTERS = os.path.join(STORAGES[storage_id], "routers")
force_resume_file = os.path.join(STORAGES[storage_id], "input/force-resume.input")
force_discard_file = os.path.join(STORAGES[storage_id], "input/force-discard.input")

router_qcow2 = ROUTERS + "/" + ve_type + "/Router" + str(router_id) + "/DSL.qcow2"
router_restore = router_qcow2 +".restore"
print router_qcow2

# the network name is the same as the router name
router_name = "Router" + str(router_id)
network_name = router_name

router_ip = ROUTER_IPS[router_id-1]
vi_dir = PROVISIONED + "/" + ve_type
unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)


# finding and removing all the files ending with LOCK
exam_dir = os.path.join(ASSIGNED, unique_instance_name)
print 'exam_dir is %s ' % exam_dir
#cmd = 'find %s/ -name "*LOCK" -print' % exam_dir         # find is a standard Unix tool
#print cmd

if not os.path.exists(exam_dir):
    register_action = "0"
    print 'exam_dir %s does not exist! Therefore, the register_action is now %s' % (exam_dir, register_action)

#for file in os.popen(cmd).readlines():     # run find command
#    num  = 1
#    name = file[:-1]                       # strip '\n'
#    print name
#    try:
#        os.remove(name)
#    except OSError, e:
#        print >>sys.stderr, "removing a lock file was not successful:", e



#first_time = 1

# if ve_ins_id > 255 or ve_ins_id < 0:
#     raise Exception("index must be between 0 and 63")

# generate the MAC addresses based on the VE instance unique id and the offset
def generate_mac(offset):
    ve_str = "%06X" % (first_mac + offset)
    print "Generated Mac is: 52:54:00:%s:%s:%s" % (ve_str[0:2], ve_str[2:4], ve_str[4:6])
    return "52:54:00:%s:%s:%s" % (ve_str[0:2], ve_str[2:4], ve_str[4:6])


 
# compares two ve directories by their instance number
def cmp(a,b):
    x = a.replace(vi_dir, "", 1)
    y = b.replace(vi_dir, "", 1)
    x = x.replace("/", "", 1)
    y = y.replace("/", "", 1)
    x = int(x)
    y = int(y)
    return x-y


# create a symbolic link
# ve_symlink = "%s-%s-%d-%s" % (ve_type, username, router_id, date)
ve_symlink = "%s" % (unique_instance_name)
# check if the symbolic link exists
#if os.path.exists(os.path.join(ASSIGNED, ve_symlink)):
#    first_time = 0

if needs_provision(): #first_time == 1:
    provision_cmd = "provisioner.py %s %s " % (ve_type, storage_id)
    print provision_cmd
    subprocess.call([provision_cmd], shell=True)
    # get the first provisioned ve that is not used
    # matching_str = "ve%s\\-" % ve_type
    ve_list = map(lambda x: os.path.join(vi_dir, x), os.listdir(vi_dir))
    not_used = filter(lambda x: not os.path.exists(os.path.join(x, ".used")), ve_list)
    print "not_used is: " 
    print not_used
    ve_dir_temp = sorted(not_used, cmp)[0]
    if os.path.exists(os.path.join(ASSIGNED, ve_symlink)) == False:
        print "The assigned directory %s does not exist" % os.path.join(ASSIGNED, ve_symlink)
        os.symlink(ve_dir_temp, os.path.join(ASSIGNED, ve_symlink))
print "() Symlink at " + os.path.join(ASSIGNED, ve_symlink)

ve_dir = os.path.join(ASSIGNED, ve_symlink)
print "ve_dir is " + ve_dir 

# mark it as used by creating a .used file
open(os.path.join(ve_dir,".used"),"w").close()
print "() Create " + os.path.join(ve_dir, ".used")

# mark the ve as started
if os.path.exists(os.path.join(ve_dir,".started")) == False:
    open(os.path.join(ve_dir,".started"),"w").close()
if os.path.exists(os.path.join(ve_dir,".stopped")) == True:
    os.remove(os.path.join(ve_dir,".stopped"))
print "() Create " + os.path.join(ve_dir, ".started")

# for each vm, get the path of the vmx file
vms = filter(os.path.isdir, map(lambda x: os.path.join(ve_dir,x), os.listdir(ve_dir)))

# just to make sure! ;)
# for reassure in range(1, 2):
if True: 
    try:
        # SMS 6/8/2014
        # starting the corresponding router
        if os.path.exists(router_restore):
            try:
              conn = libvirt.open("qemu:///system")
              conn.restore(router_restore)
            except:
              print "The router has already been restored!"
        else :
            register_cmd = "virt-install --connect qemu:///system --ram %d --name %s --os-type=linux --network network:default --network network:%s --network network:%s --network network:%s --disk path=%s,device=disk,format=qcow2 --vcpus=%d --vnc --keymap=en-us --force --accelerate --noautoconsole --import" % (XP_PARAMS["memory"], router_name, network_name, network_name, network_name, router_qcow2, XP_PARAMS["ncpus"])
            cmd = register_cmd
            print "Command: " + cmd
            subprocess.call([cmd], shell=True)
       
        # add rules to the firewall to forward traffic to a given router
        vmnat_cmd = "sudo %s add %d %s %d %d" % (VMNAT, first_port, router_ip, RPORT_START, num_ports)
        print "() Call sudo vmnat.sh add %d %s %d %d" % (first_port, router_ip, RPORT_START, num_ports)
        retcode = subprocess.call([vmnat_cmd],shell=True)
        if retcode < 0:
            print >>sys.stderr, "sudo as terminated by signal", -retcode
        else:
            print >>sys.stderr, "sudo returned", retcode
    except OSError, e:
        print >>sys.stderr, "sudo execution failed:", e
    
    # sort the vms so that we always process them in the same order
    vms = sorted(vms)

    offset_index = -1
    port_offset = -1

    for i in range(len(vms)):

        offset_index = offset_index + 1 
        port_offset = port_offset + 1
        unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port+port_offset)

        vm = vms[i]
    
        # get the snapshot file
        snap_file = os.path.join(vm, filter(lambda x: re.match(r'.*snap.*\.qcow2$',x), os.listdir(vm))[0])
        print "Snap File:" + snap_file


        vm_type = os.path.basename(vm)

        match_w7 = re.match("w7-(\d)", vm_type)

        # generate MAC address based on the ip index, the starting port and an offset
        mac = generate_mac(offset_index)
        print "mac: " + mac

        if match_w7:
            # if there was a match, get the number after w7 
            w7_iteration = int(match_w7.group(1))
            # begin the installation or restart of the VM 
            start_cmd = "start_vm.py %s %s %s %d %d %s %s" %(snap_file, unique_instance_name, "windows", XP_PARAMS["memory"], XP_PARAMS["ncpus"], network_name, mac)
            print start_cmd
            subprocess.call([start_cmd], shell=True)
            print "============="
        else:
            w2k8_match = re.match("w2k8-(\d)", vm_type)
            if w2k8_match:
                w2k8_iteration = int(w2k8_match.group(1))
                offset_index = offset_index + 1 
                mac2 = generate_mac(offset_index)
                print "mac2: " + mac2
            
                start_cmd = "start_vm.py %s %s %s %d %d %s %s %s " %(snap_file, unique_instance_name, "windows", DC_PARAMS["memory"], DC_PARAMS["ncpus"],network_name, mac, mac2)
                print start_cmd
                subprocess.call([start_cmd], shell=True)
                print "============="
            else:
                raise Exception("Incorrect VM type '" + vm_type + "'")
    
    
        # # start it
        # # start_cmd = "vmware-cmd %s start soft &" % vmx_file
        # start_cmd = "vmware-cmd %s start soft" % vmx_file
        # force_resume_cmd = "vmware-cmd %s answer < %s" % (vmx_file,force_resume_file)
        # force_discard_cmd = "vmware-cmd %s answer < %s" % (vmx_file,force_discard_file)
        # # subprocess.call([ start_cmd], shell=True)
        # combined_cmd = "(" + register_cmd + "; sleep 1; " + start_cmd + "; sleep 1; " + force_resume_cmd + "; sleep 1; " + start_cmd + "; sleep 1; " + force_discard_cmd + "; sleep 1; " + start_cmd + ";) &"
        # print combined_cmd
        # subprocess.call([combined_cmd], shell=True)
        # start_vm_cmd = "start_vm.py %s &" % vmx_file
        # subprocess.call([start_vm_cmd], shell=True)
            
# 111 means that this script could successfully reach to its end
sys.exit(111)
