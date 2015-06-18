#!/usr/bin/python

import sys
import os.path
import re
import subprocess
import time

from storages import *

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

TEMPLATES = os.path.join(HOME, "templates")
PROVISIONED = os.path.join(HOME, "provisioned")
#ASSIGNED = os.path.join(HOME, "assigned")

if (len(sys.argv) != 2):
    print "Usage: %s <host_id>" % sys.argv[0]
    sys.exit(1)

host_id = sys.argv[1]

if not STORAGES.has_key(host_id):
    print "Invalid host id: %s" % host_id
    sys.exit(1)

ASSIGNED = os.path.join(STORAGES[host_id], "assigned")

# find all directories that start with ve_type-username
# match_str = "%s-%s-%s" % (ve_type, username, router_id)
# match_str = username
# match_str = unique_instance_name
# exams = filter(lambda x: re.match(match_str, x), os.listdir(ASSIGNED))
exams = os.listdir(ASSIGNED)
# print "exams: %s" % exams
full_paths = map(lambda x: os.path.join(ASSIGNED, x), exams)
# print "full_paths: %s" % full_paths

# Get all ve directories that have stopped
stopped_exams = filter(lambda x: os.path.exists(os.path.join(x,".stopped")) , full_paths)
print "stopped_exams: %s" % stopped_exams

# for each exam
for e in stopped_exams:
    # get all vm dirs
    vm_dirs = filter(os.path.isdir, map(lambda x: os.path.join(e,x), os.listdir(e)))

    # get the vmx files in each directory
    vmx_files = []
    for d in vm_dirs:
        f = filter(lambda x: re.match(r'[^.]+\.vmx$', x), os.listdir(d))
        vmx_files.append(os.path.join(d, f[0]))

    # unregister the vms
    for vmx in vmx_files:

        # unregister_cmd = "vmware-cmd -s unregister %s &" % vmx
        unregister_cmd = "vmware-cmd -s unregister %s" % vmx

        print unregister_cmd
        subprocess.call([unregister_cmd],shell=True)

