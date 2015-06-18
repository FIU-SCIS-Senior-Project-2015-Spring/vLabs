#!/usr/bin/python

import sys, os, shutil, tarfile, subprocess

if len(sys.argv) != 2:
    print "Usage: %s <ve_number>" % sys.argv[0]
    sys.exit(1)

PORTAL_HOME = "/home/portal"
VE_DIR = PORTAL_HOME + "/exams/provisioned/%s" % sys.argv[1]
print "VE_DIR is: %s" % VE_DIR

# get all vitural instance type directoris
# vit_dirs = filter(os.path.isdir, map(lambda x: os.path.join(VE_DIR,x), os.listdir(VE_DIR)))

# for vit_dir in vit_dirs:
vit_dir = VE_DIR
if True:
 
    # get all stopped exams in the provisioned folder
    all_dirs = filter(os.path.isdir, map(lambda x: os.path.join(vit_dir,x), os.listdir(vit_dir)))
    print "all_dirs are: %s" % all_dirs

    stopped_ves = filter(lambda x: os.path.exists(os.path.join(x,".stopped")), all_dirs)
    print "stopped_ves are: %s" % stopped_ves

    # remove all directories 
    for ve in stopped_ves:
        print "Cleaning:  %s" % ve
    
        # get all vms
        contents = map(lambda x: os.path.join(ve,x), os.listdir(ve))
        vms = filter(lambda x: os.path.isdir(x), contents)

        # remove all directories  
        for vm_dir in vms:
            print "This directory is being removed: %s:" % vm_dir
            # shutil.rmtree(vm_dir)
            rm_cmd = "rm -rf %s &" % vm_dir
            print rm_cmd
            subprocess.call([rm_cmd], shell=True)


        
        os.rename(os.path.join(ve,".stopped"), os.path.join(ve,".clean"))
