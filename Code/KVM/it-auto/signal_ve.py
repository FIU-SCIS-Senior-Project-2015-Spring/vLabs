#!/usr/bin/python

import sys
import os.path
import re
import subprocess
import time

from storages import *

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
# HOME = os.environ["HOME"]+"/exams"

if (len(sys.argv) != 6):
    print "Usage: %s <username> <ve_type> <first_port> <storage_id> <signal>" % sys.argv[0]
    sys.exit(1)

username = sys.argv[1]
ve_type = sys.argv[2]
first_port = int(sys.argv[3])
storage_id = sys.argv[4]
signal = sys.argv[5]

if not STORAGES.has_key(storage_id):
    print "Invalid host id: %s" % storage_id
    sys.exit(1)

ASSIGNED = os.path.join(STORAGES[storage_id], "assigned")
TEMPLATES = os.path.join(STORAGES[storage_id], "templates")
PROVISIONED = os.path.join(STORAGES[storage_id], "provisioned")

print "ASSIGNED: " + ASSIGNED
unique_instance_name = "%s-%s-%d" % (username, ve_type, first_port)
print "unique_instance_name: " + unique_instance_name
ve_assigned_dir = os.path.join(ASSIGNED, unique_instance_name)
print "ve_assigned_dir: " + ve_assigned_dir
ve_provisioned_dir = os.readlink(ve_assigned_dir)
print "ve_provisioned_dir: " + ve_provisioned_dir

for i in [1,2]:
    if i == 1:
        match_str = unique_instance_name
    elif i == 2:
        match_str = ve_provisioned_dir[6:]

    print "i: %d and match_str: %s" % (i, match_str)

    getstop_cmd = "ps -eo pid,args | grep vmx | grep %s | sed -e 's/^[ \t]*//' | cut -d' ' -f1" % match_str
    cmd = getstop_cmd
    # subprocess.call([cmd], shell=True)
    print "Command: " + cmd
    for file in os.popen(cmd).readlines():
        file = file[:-1]                       # strip '\n' 
        print "file: " + file

        signal_cmd = "kill -%s %s" % (signal, file)
        cmd = signal_cmd
        print "Command: " + cmd
        subprocess.call([cmd], shell=True)

