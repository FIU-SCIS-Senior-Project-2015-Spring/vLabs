#!/usr/bin/python

import os.path
import os
import re
import subprocess
import sys
import time
import shutil

from storages import *

if len(sys.argv) != 3:
    print "Usage: %s <ve_type> <storage_id>" % sys.argv[0]
    sys.exit(1)

# PORTAL_HOME = "/disk/serval/serval-vm-storage/portal"
# PORTAL_HOME = os.environ["HOME"]

VE_TYPE = sys.argv[1]
storage_id = sys.argv[2]
if not STORAGES.has_key(storage_id):
    print "Invalid storage_id: %s" % storage_id
    sys.exit(1)

ASSIGNED = os.path.join(STORAGES[storage_id], "assigned")

# VE_DIR = PORTAL_HOME + "/exams/provisioned"
VE_DIR = os.path.join(STORAGES[storage_id], "provisioned")
USED_SLOT = ".used"
REQUIRED_SLOTS = 1
TEMPLATE_PATH = os.path.join(STORAGES[storage_id], "templates/temp-%s" % VE_TYPE)

# check if the template directory exists
if not os.path.exists(TEMPLATE_PATH):
    print "Template path %s does not exist" % TEMPLATE_PATH
    sys.exit(2)

print "Template path %s exists: " % TEMPLATE_PATH

# make sure the folder exists, if not create
if not os.path.exists(VE_DIR):
    print "VE folder (%s) doesn't exist. Creating" % VE_DIR
    os.mkdir(VE_DIR)

print "VE folder (%s) is: " % VE_DIR

# list the ve_instance templates for this ve type 
# ve_ins_temps = os.listdir(TEMPLATE_PATH)

# for vit in ve_ins_temps:

#     print "vit is %s" % vit

#     vit_dir = VE_DIR + "/%s/" % VE_TYPE + vit 
if True:
    vit_dir = VE_DIR + "/%s/" % VE_TYPE  
    print "vit_dir is %s" % vit_dir

    # make sure the folder exists, if not create
    if not os.path.exists(vit_dir):
        print "vit folder (%s) doesn't exist. Creating" % vit_dir
        os.makedirs(vit_dir)

    # list directories
    ves = os.listdir(vit_dir)

    # for each of the directories, count how many of them are there, how many of those are used, and what is the largest number
    total_slots = 0
    used_slots = 0
    greatest_num = 0

    for e in ves:
    
        # directories are in the form ven-x, where n is the VE_TYPE and x is the instance number
        match_str = "([0-9]+)"
        match = re.search(match_str, e)
    
        if match:
    
            total_slots += 1

            full_path = os.path.join(vit_dir, e)

            # the slot is used if there is a .used file
            if os.path.exists(os.path.join(full_path, USED_SLOT)):
                used_slots += 1

            n = int(match.group(1))

            if n > greatest_num:
                greatest_num = n 


    print """Total slots: %d
    Used slots: %d
    Greatest: %d""" % (total_slots, used_slots, greatest_num)

    free_slots = total_slots - used_slots 

    # untar templates until the required slots are available
    next_slot = greatest_num + 1
    new_slots = REQUIRED_SLOTS - free_slots

    print "There are %d new slots" % new_slots

    if new_slots > 0:
        for i in range(next_slot, next_slot + new_slots):
            print "creating ve %d" % i

            # create the directory
            dirname = "%d" % i
            newpath = os.path.join(vit_dir, dirname)
            os.mkdir(newpath)
            #print "os.mkdir(%s)" % newpath

            # untar the template into the new directory
            subprocess.call(["date"], shell=True)
            # print "cp -r %s/%s/* %s" % (TEMPLATE_PATH, vit, newpath)
            #print "cp -r %s/* %s &" % (TEMPLATE_PATH, newpath)
            #subprocess.call(["cp -r %s/* %s &" % (TEMPLATE_PATH, newpath)], shell=True)
            # subprocess.call(["cp -r %s/%s/* %s &" % (TEMPLATE_PATH, vit, newpath)], shell=True)
            # subprocess.call(["tar xfz %s -C %s" % (TEMPLATE_PATH, newpath)], shell=True)
            # print "cd %s; touch .used" % newpath
            # subprocess.call(["cd %s; touch .used" % newpath], shell=True)

            #####################################################
            # New functionality: copy all files in the template, 
            # except the flat vmdk file (xxx-flat.vmdk)
            #####################################################

            # get all vms
            temp_vms = os.listdir(TEMPLATE_PATH)

            for vm in temp_vms:

                temp_vm_dir = os.path.join(TEMPLATE_PATH, vm)

                # create the vm directory
                new_vm_dir = os.path.join(newpath, vm)
                os.mkdir(new_vm_dir)
                #print "os.mkdir(%s)" % new_vm_dir

                # copy the snapshot, link the main .qcow2 file
                vm_files = os.listdir(temp_vm_dir)

                for vm_file in vm_files:

                    vm_file_path = os.path.join(temp_vm_dir, vm_file)

                    if re.search('snap', vm_file):
                        shutil.copy(vm_file_path, new_vm_dir)
                        #print "shutils.copy(%s,%s)" % (vm_file_path, new_vm_dir)
                    else:
                        # Create a link to the flat file in the template
                        os.symlink(vm_file_path, os.path.join(new_vm_dir, vm_file))
                        #print "os.symlink(%s, %s)" % (vm_file_path, os.path.join(new_vm_dir, vm_file))




        

        

