#!/usr/bin/python

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

unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)
vm_rel_dir = "%s/%s" % (unique_instance_name, vm_dir)

vm_abs_dir = os.path.join(ASSIGNED, vm_rel_dir)
print "The vm absolute directory is: " + vm_abs_dir

# get the vmx file
vmx_file = os.path.join(vm_abs_dir, filter(lambda x: re.match(r'.*\.vmx$',x), os.listdir(vm_abs_dir))[0])
print "The vmx file is: " + vmx_file

# change its permissions to be world executable
os.chmod(vmx_file, 0755)
    
vm_cmd = "doalarm 1 vmware-cmd %s %s %s" % (vmx_file, cmd_param1, cmd_param2)
cmd = vm_cmd
print "Command: " + cmd
# subprocess.call([cmd], shell=True)
i = 0
retVal = -1
for file in os.popen(cmd).readlines():
    i = i+1
    print "Output: %d: %s" % (i, file)
    if cmd_param1 == 'start':
        if file.find('on'):
            retVal = 0
    elif cmd_param1 == 'stop':
        if file.find('off'):
            retVal = 0
    elif cmd_param1 == 'suspend':
        if file.find('suspended'):
            retVal = 0
    elif cmd_param1 == 'reset':
        if file.find('on'):
            retVal = 0
    elif cmd_param1 == 'getstate':
        print "getstate"
        if file.find('off') >= 0:
            print "off"
            retVal = 1
        elif file.find('suspended') >= 0:
            print "suspended"
            retVal = 2
        elif file.find('on') >= 0:
            print "on"
            retVal = 3

print "retVal: %d" % retVal
sys.exit(retVal)
