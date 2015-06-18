#!/usr/bin/python

import sys
import re
import os
import subprocess

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

TEMPLATES = os.path.join(HOME, "templates")
ROUTERS = os.path.join(HOME, "routers")
print "The routers dir is " + ROUTERS 

# for each vm, get the path of the vmx file
vms = filter(os.path.isdir, map(lambda x: os.path.join(ROUTERS,x), os.listdir(ROUTERS)))

# sort the vms so that we always process them in the same order
vms = sorted(vms)

for i in range(len(vms)):

    vm = vms[i]
    
    # get the vmx file
    vmx_file = os.path.join(vm, filter(lambda x: re.match(r'.*\.vmx$',x), os.listdir(vm))[0])
    
    # start it
    start_vm_cmd = "/home/sadjadi-vmstorage/sadjadi-vms/it-auto/start_vm.py %s" % vmx_file
    print "Command: " + start_vm_cmd
    subprocess.call([start_vm_cmd], shell=True)
            
