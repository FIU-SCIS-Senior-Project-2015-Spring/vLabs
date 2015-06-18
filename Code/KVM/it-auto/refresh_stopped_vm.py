#!/usr/bin/python

import sys
import re
import os
import subprocess
import shutil

from storages import *

# globals

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

if len(sys.argv) != 6:
    print "Usage: %s <username> <ve_type> <first_port> <storage_id> <vm_dir>" % sys.argv[0]
    sys.exit(1)

username = sys.argv[1]
ve_type = sys.argv[2]
first_port = int(sys.argv[3])
storage_id = sys.argv[4]
vm_dir = sys.argv[5]

if not STORAGES.has_key(storage_id):
    print "Invalid storage_id: %s" % storage_id
    sys.exit(1)

TEMPLATE_PATH = STORAGES[storage_id] + "/templates/temp-%s" % ve_type

# check if the template directory exists
if not os.path.exists(TEMPLATE_PATH):
    print "Template path %s does not exist" % TEMPLATE_PATH
    sys.exit(2)

print "Template path %s exists: " % TEMPLATE_PATH

ASSIGNED = os.path.join(STORAGES[storage_id], "assigned")

vm_template_dir = os.path.join(TEMPLATE_PATH, vm_dir)
print "The vm template directory is: " + vm_template_dir

unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)
vm_rel_dir = "%s/%s" % (unique_instance_name, vm_dir)

ve_abs_dir = os.path.join(ASSIGNED, unique_instance_name)
print "The ve absoluted directory is: " + ve_abs_dir

vm_abs_dir = os.path.join(ASSIGNED, vm_rel_dir)
print "The vm absolute directory is: " + vm_abs_dir

f = filter(lambda x: re.match(r'[^.]+\.vmx$', x), os.listdir(vm_abs_dir))
vmx_file = os.path.join(vm_abs_dir, f[0])
print "The vmx file is: " + vmx_file

# print "--------------------------------------"
# print "Stopping..."
# stop_vm_cmd = "stop_vm.py %s" % vmx_file
# cmd = stop_vm_cmd
# print "Command: " + cmd
# subprocess.call([cmd], shell=True)

print "--------------------------------------"
print "Removing..."
# shutil.rmtree(vm_abs_dir)
# remove all files, except for the *.vmx
vm_files = os.listdir(vm_abs_dir)

for vm_file in vm_files:

    vm_file_path = os.path.join(vm_abs_dir, vm_file)

    if not re.search('vmx', vm_file):
        print "removing " + vm_file_path
        os.remove(vm_file_path)

print "--------------------------------------"
print "Copying..."
# create the vm directory
# os.mkdir(vm_abs_dir)

# copy all files, except for the *flat.vmdk
vm_files = os.listdir(vm_template_dir)

for vm_file in vm_files:

    vm_file_path = os.path.join(vm_template_dir, vm_file)

    if not re.search('flat', vm_file) and not re.search('Snapshot', vm_file) and not re.search('vmx', vm_file):
        print "copying " + vm_file_path + " to " + vm_abs_dir
        shutil.copy(vm_file_path, vm_abs_dir)
    elif not re.search('vmx', vm_file):
        # Create a link to the flat file in the template
        print "creating a symbolic link from " + vm_file_path + " to " + vm_abs_dir
        os.symlink(vm_file_path, os.path.join(vm_abs_dir, vm_file))

# print "--------------------------------------"
# print "Starting..."
# start_vm_cmd = "start_vm.py %s" % vmx_file
# cmd = start_vm_cmd
# print "Command: " + cmd
# subprocess.call([cmd], shell=True)

