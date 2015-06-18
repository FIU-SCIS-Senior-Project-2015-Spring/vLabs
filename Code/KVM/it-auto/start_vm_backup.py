#!/usr/bin/python

import sys
import re
import os
import subprocess

from vmxutil import vmx

if len(sys.argv) != 2 :
    print "Usage: %s <vmx_file>" % sys.argv[0]
    sys.exit(1)

vmx_file = sys.argv[1]

# globals

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

force_resume_file = os.path.join(HOME, "input/force-resume.input")
force_discard_file = os.path.join(HOME, "input/force-discard.input")

# start it
register_cmd = "vmware-cmd -s register %s" % vmx_file
start_cmd = "vmware-cmd %s start soft" % vmx_file
force_resume_cmd = "vmware-cmd %s answer < %s" % (vmx_file,force_resume_file)
force_discard_cmd = "vmware-cmd %s answer < %s" % (vmx_file,force_discard_file)

cmd = register_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = start_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = force_discard_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = start_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = force_resume_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = start_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = force_discard_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

cmd = start_cmd
print "Command: " + cmd
subprocess.call([cmd], shell=True)

