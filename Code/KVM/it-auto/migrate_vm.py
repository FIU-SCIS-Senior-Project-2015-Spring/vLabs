#!/usr/bin/python

import os.path
import os
import re
import subprocess
import sys
import time
import shutil

from storages import *

if len(sys.argv) != 6:
    print "Error in input parameters! Please fix and Retry!"
    print "Usage: %s <username> <ve_type> <first_port> <source_storage_id> <target_storage_id>" % sys.argv[0]
    sys.exit(1)

print"Input parameters:"
username = sys.argv[1]
print "    username: %s" % username
ve_type = sys.argv[2]
print "    ve_type: %s" % ve_type
first_port = int(sys.argv[3])
print "    first_port: %d" % first_port
source_storage_id = sys.argv[4]
print "    source_storage_id: %s" % source_storage_id
target_storage_id = sys.argv[5]
print "    target_storage_id: %s" % target_storage_id

if not STORAGES.has_key(source_storage_id):
    print "Error in input parameters! Please fix and Retry!"
    print "Invalid source_storage_id: %s" % source_storage_id
    sys.exit(1)
if not STORAGES.has_key(target_storage_id):
    print "Error in input parameters! Please fix and Retry!"
    print "Invalid target_storage_id: %s" % target_storage_id
    sys.exit(1)

print ""
print "------------------------------------------------------------------------------------"
print "1) Set and check the values of the script variables based on the input parameters..."
print "------------------------------------------------------------------------------------"
unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)
print "    unique_instance_name: " + unique_instance_name
print ""
source_home = STORAGES[source_storage_id]
print "    source_home: " + source_home
if not os.path.exists(source_home):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % source_home
    sys.exit(2)
target_home = STORAGES[target_storage_id]
print "    target_home: " + target_home
if not os.path.exists(target_home):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % target_home
    sys.exit(2)
print ""
source_assigned = os.path.join(source_home, "assigned")
print "    source_assigned: " + source_assigned
if not os.path.exists(source_assigned):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % source_assigned
    sys.exit(2)
target_assigned = os.path.join(target_home, "assigned")
print "    target_assigned: " + target_assigned
if not os.path.exists(target_assigned):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % target_assigned
    sys.exit(2)
print ""
source_assigned_ve_ins = os.path.join(source_assigned, unique_instance_name)
print "    source_assigned_ve_ins: " + source_assigned_ve_ins
if not os.path.exists(source_assigned_ve_ins):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % source_assigned_ve_ins
    sys.exit(2)
target_assigned_ve_ins = os.path.join(target_assigned, unique_instance_name)
print "    target_assigned_ve_ins: " + target_assigned_ve_ins
if os.path.exists(target_assigned_ve_ins):
    print "Error in input parameters! Please fix and Retry!"
    print "%s already exists!" % target_assigned_ve_ins
    sys.exit(2)
print ""
source_provisioned = os.path.join(source_home, "provisioned")
print "    source_provisioned: " + source_provisioned
if not os.path.exists(source_provisioned):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % source_provisioned
    sys.exit(2)
target_provisioned = os.path.join(target_home, "provisioned")
print "    target_provisioned: " + target_provisioned
if not os.path.exists(target_provisioned):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % target_provisioned
    sys.exit(2)
print ""
source_provisioned_ve_type = source_provisioned + "/%s" % ve_type  
print "    source_provisioned_ve_type: " + source_provisioned_ve_type
if not os.path.exists(source_provisioned_ve_type):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % source_provisioned_ve_type
    sys.exit(2)
target_provisioned_ve_type = target_provisioned + "/%s" % ve_type  
print "    target_provisioned_ve_type: " + target_provisioned_ve_type
if not os.path.exists(target_provisioned_ve_type):
    print "%s does not exist! Creating..." % target_provisioned_ve_type
    os.mkdir(target_provisioned_ve_type)
print ""
source_template = source_home + "/templates/temp-%s" % ve_type
print "    source_template: " + source_template
if not os.path.exists(source_template):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % source_template
    sys.exit(2)
target_template = target_home + "/templates/temp-%s" % ve_type
print "    target_template: " + target_template
if not os.path.exists(target_template):
    print "Error in input parameters! Please fix and Retry!"
    print "%s does not exist!" % target_template
    sys.exit(2)
print ""

print ""
print "-------------------------------------------------------"
print "2) Find and remove all the files ending with LOCK..."
print "-------------------------------------------------------"
cmd = 'find %s/ -name "*LOCK" -print' % source_assigned_ve_ins        
counter = 0
print "    Command: " + cmd
for file in os.popen(cmd).readlines():     # run find command 
    name = file[:-1]                       # strip '\n'
    print name
    try:
        counter = counter + 1
        print "        %d: Removing %s" % (counter, name)
        os.remove(name)
    except OSError, e:
        print "    It appears that the ve is running! Please stop the ve before attempt to migrate!"
        print >>sys.stderr, "    removing a lock file was not successful:", e
        sys.exit(2)
if counter == 0:
    print "    There was no lock file to be removed!"

print ""
print "--------------------------------------------------"
print "3) Create target provisioned ve instance folder..."
print "--------------------------------------------------"
print "    Make sure that the target provisioned folder (%s) exists, if not create..." % target_provisioned
if not os.path.exists(target_provisioned):
    print "        Target provisioned folder %s doesn't exist. Creating..." % target_provisioned
    os.mkdir(target_provisioned)

print "    Make sure the target provisioned ve type folder (%s) exists, if not create..." % target_provisioned_ve_type
if not os.path.exists(target_provisioned_ve_type):
    print "        Target provisioned ve type folder (%s) doesn't exist. Creating..." % target_provisioned_ve_type
    os.makedirs(target_provisioned_ve_type)

print "    Find the greatest ve ins folder number..."
# list directories
ves = os.listdir(target_provisioned_ve_type)
# for each of the directories, count how many of them are there, how many of those are used, and what is the largest number
greatest_num = 0
for e in ves:
    # directories are in the form of x, where x is the instance number
    match_str = "([0-9]+)"
    match = re.search(match_str, e)
    if match:
        full_path = os.path.join(target_provisioned_ve_type, e)
        print "        ve ins folder: " + full_path
        n = int(match.group(1))
        if n > greatest_num:
            greatest_num = n 

print ""
print "        greatest_num: %d" % greatest_num
next_slot = greatest_num + 1
print "        next_slot: %d" % next_slot

print ""
source_provisioned_ve_ins = os.readlink(source_assigned_ve_ins)
print "    source_provisioned_ve_ins: "+ source_provisioned_ve_ins
target_provisioned_ve_ins = "%s/%d" % (target_provisioned_ve_type, next_slot)
print "    target_provisioned_ve_ins: "+ target_provisioned_ve_ins

print ""
print "    Create target_provisioned_ve_ins..."
os.mkdir(target_provisioned_ve_ins)

print ""
print "----------------------------------------------"
print "4) Copy files from source to target storage..."
print "----------------------------------------------"
# get all vms
source_vms = os.listdir(source_provisioned_ve_ins)
for vm in source_vms:
    print ""
    source_vm = os.path.join(source_provisioned_ve_ins, vm)
    if not os.path.isdir(source_vm):
        print "    Copy..."
        print "    shutil.copy(%s, %s)" % (source_vm, target_provisioned_ve_ins)
        shutil.copy(source_vm, target_provisioned_ve_ins)
        continue
    print "    source_vm: " + source_vm
    # create the vm folder
    target_vm = os.path.join(target_provisioned_ve_ins, vm)
    print "    target_vm: " + target_vm
    print "    Create " + target_vm
    os.mkdir(target_vm)
    # copy all files, except for the *flat.vmdk
    vm_file_names = os.listdir(source_vm)
    target_temp_vm = os.path.join(target_template, vm)
    for vm_file_name in vm_file_names:
        source_vm_file = os.path.join(source_vm, vm_file_name)
        temp_vm_file = os.path.join(target_temp_vm, vm_file_name)
        if not re.search('flat', vm_file_name) and not re.search('Snapshot', vm_file_name):
            print "    Copy..."
            print "    shutils.copy(%s,%s)" % (source_vm_file, target_vm)
            shutil.copy(source_vm_file, target_vm)
        else:
            print "    Create a link..."
            print "    os.symlink(%s, %s)" % (temp_vm_file, os.path.join(target_vm, vm_file_name))
            os.symlink(temp_vm_file, os.path.join(target_vm, vm_file_name))

print ""
print "-----------------------------------"
print "5) Create target_assigend_ve_ins..."
print "-----------------------------------"
print "    os.symlink(%s, %s)" % (target_provisioned_ve_ins, target_assigned_ve_ins)
os.symlink(target_provisioned_ve_ins, target_assigned_ve_ins)

print ""
print "-------------------------------"
print "6) Destroy the source ve ins..."
print "-------------------------------"
print "    Remove %s ..." % source_assigned_ve_ins
os.remove(source_assigned_ve_ins)
print "    Remove %s ..." % source_provisioned_ve_ins
shutil.rmtree(source_provisioned_ve_ins)

