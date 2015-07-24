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

f = filter(lambda x: re.match('.*snap.*qcow2$', x), os.listdir(vm_abs_dir))
qcow2_file = os.path.join(vm_abs_dir, f[0])
print "The qcow2 file is: " + qcow2_file

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


# get the xml file
xml_file = dom_name + ".xml"
xml_file = os.path.join(vm_abs_dir, xml_file)

cmd = "virsh --connect qemu:///system dumpxml %s > %s" % (dom_name, xml_file)
print "Command: " + cmd
subprocess.call([cmd], shell=True)



print "--------------------------------------"
print "Stopping..."
stop_vm_cmd = "stop_vm.py %s %s" % (qcow2_file, dom_name)
cmd = stop_vm_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

print "--------------------------------------"
print "Removing..."
# shutil.rmtree(vm_abs_dir)
# remove all files, except for the *.vmx
vm_files = os.listdir(vm_abs_dir)

for vm_file in vm_files:

    vm_file_path = os.path.join(vm_abs_dir, vm_file)
    if not re.search('xml', vm_file):
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

    if re.search('snap', vm_file):
        print "copying " + vm_file_path + " to " + vm_abs_dir
        shutil.copy(vm_file_path, vm_abs_dir)
    else:
        # Create a link to the flat file in the template
        print "creating a symbolic link from " + vm_file_path + " to " + vm_abs_dir
        os.symlink(vm_file_path, os.path.join(vm_abs_dir, vm_file))

print "--------------------------------------"
print "Starting..."
start_vm_cmd = "start_vm.py %s" % xml_file
cmd = start_vm_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = "rm %s" % xml_file
print "Command: " + cmd
subprocess.call([cmd], shell=True)

