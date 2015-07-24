#!/usr/bin/python

import libvirt
import sys
import re
import os
import subprocess

from storages import *

# globals

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

if len(sys.argv) < 7:
    print "Usage: %s <username> <ve_type> <first_port> <storage_id> <vm_dir> <cmd_param1> <cmd_param2>" % sys.argv[0]
    sys.exit(1)

username = sys.argv[1] 
ve_type = sys.argv[2]
first_port = int(sys.argv[3])
storage_id = sys.argv[4]
vm_dir = sys.argv[5]
cmd_param1 = sys.argv[6]
cmd_param2 = ""
if len(sys.argv) > 7:
    cmd_param2 = sys.argv[7]

if not STORAGES.has_key(storage_id):
    print "Invalid storage_id: %s" % storage_id
    sys.exit(1)

ASSIGNED = os.path.join(STORAGES[storage_id], "assigned")

# connect to libvirt's URI
conn = libvirt.open("qemu:///system")

# convert the vm_dir to the correct one
if vm_dir == "w2k3-1":
    vm_dir = "w2k8-1"
if vm_dir == "xp-1":
    vm_dir = "w7-1"
if vm_dir == "xp-2":
    vm_dir = "w7-2"
if vm_dir == "xp-3":
    vm_dir = "w7-3"
if vm_dir == "xp-4":
    vm_dir = "w7-4"

unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)
vm_rel_dir = "%s/%s" % (unique_instance_name, vm_dir)

vm_abs_dir = os.path.join(ASSIGNED, vm_rel_dir)
print "The vm absolute directory is: " + vm_abs_dir

f = filter(lambda x: re.match('.*snap.*qcow2$', x), os.listdir(vm_abs_dir))
qcow2_file = os.path.join(vm_abs_dir, f[0])
print "The qcow2 file is: " + qcow2_file

# the location of where a restore file should be
restore_file = qcow2_file + ".restore"

# getting the domain name
port_offset = -1 
match = re.match(".*w2k8-1.*", vm_abs_dir) or re.match(".*w2k3-1.*", vm_abs_dir)
if match:
    port_offset = 0
match = re.match(".*w7-1.*", vm_abs_dir) or re.match(".*xp-1.*", vm_abs_dir)
if match:
    port_offset = 1
match = re.match(".*w7-2.*", vm_abs_dir) or re.match(".*xp-2.*", vm_abs_dir)
if match:
    port_offset = 2
match = re.match(".*w7-3.*", vm_abs_dir) or re.match(".*xp-3.*", vm_abs_dir)
if match:
    port_offset = 3
match = re.match(".*w7-4.*", vm_abs_dir) or re.match(".*xp-4.*", vm_abs_dir)
if match:
    port_offset = 4

if port_offset == -1:
    sys.exit(port_offset)

dom_name = "%s-%s-%d" % (username, ve_type, first_port + port_offset)

print "The domain name is: " + dom_name

dom = conn.lookupByName(dom_name)
    
i = 0
retVal = -1
if cmd_param1 == 'start':
    if dom.isActive():
        retVal=0
    elif os.path.exists(restore_file):
        conn.restore(restore_file)
        print "Restored %s" % restore_file
        os.remove(restore_file)
        retVal = 0
    else:
        cmd = "virsh --connect qemu:///system start %s" % dom_name
        print "Command: " + cmd
        subprocess.call([cmd], shell=True)
        retVal = 0

elif cmd_param1 == 'stop':
    if not dom.isActive():
        retVal = 0
    else:
        dom.shutdown()
        retVal = 0

elif cmd_param1 == 'suspend':
    if not dom.isActive() and os.path.exists(restore_file):
        retVal = 0
    else:
        dom.save(restore_file)
        retVal = 0

elif cmd_param1 == 'reset':
    dom.shutdown()
    while True:
        if not dom.isActive():
            break
    cmd = "virsh --connect qemu:///system start %s" % dom_name
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)
    retVal = 0

elif cmd_param1 == 'getstate':
    print "getstate"
    if not dom.isActive() and os.path.exists(restore_file) :
        print "suspended"
        retVal = 2
    elif not dom.isActive():
        print "off"
        retVal = 1
    elif dom.isActive():
        print "on"
        retVal = 3

print "retVal: %d" % retVal
sys.exit(retVal)
