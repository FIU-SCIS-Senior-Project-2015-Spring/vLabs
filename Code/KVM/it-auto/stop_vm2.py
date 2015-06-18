#!/usr/bin/python

import sys
import re
import os
import subprocess

from vmxutil import vmx

if len(sys.argv) != 3 :
    print "Usage: %s <qcow2_file> <name>" % sys.argv[0]
    sys.exit(1)

qcow2_file = sys.argv[1]
name = sys.argv[2]
restore_file = qcow2_file + ".restore"

# globals

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

stop_vm_cmd = "virsh suspend %s" % name
cmd = stop_vm_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

stop_vm_cmd = "virsh save %s %s" % (name, restore_file)
cmd = stop_vm_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)


sys.exit(0)
