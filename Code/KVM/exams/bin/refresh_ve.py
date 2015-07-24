#!/usr/bin/python

import sys
import re
import os
import subprocess
import shutil

# globals

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

if len(sys.argv) != 5:
    print "Usage: %s <username> <ve_type> <first_port> <storage_id>" % sys.argv[0]
    sys.exit(1)

username = sys.argv[1]
ve_type = sys.argv[2]
first_port = int(sys.argv[3])
storage_id = sys.argv[4]

VM_DIRS = {
  1: "w2k3-1", 
  2: "xp-1", 
  3: "xp-2", 
  4: "xp-3", 
  5: "xp-4"
}

for i in range(1, 6):
    vm_dir = VM_DIRS[i]
    refresh_vm_cmd = "refresh_vm.py %s %s %s %s %s " % (username, ve_type, first_port, storage_id, vm_dir)
    print "Command: " + refresh_vm_cmd
    subprocess.call([refresh_vm_cmd], shell=True)

