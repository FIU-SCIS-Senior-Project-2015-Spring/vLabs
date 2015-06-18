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
getstate_cmd = "vmware-cmd %s getstate" % vmx_file
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


counter = 0
reg = False
while reg == False: # and counter < 10:
    counter = counter + 1
    cmd = register_cmd
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)

    cmd = getstate_cmd
    print "Command: " + cmd
    # subprocess.call([cmd], shell=True)
    i = 0
    for file in os.popen(cmd).readlines():
        i = i+1
        print "%d: %s" % (i, file)
        if file.find('getstate') != -1:
            print "Registered! :)"
            reg = True
        else:
            print "Still not registered! :("
            reg = False

counter = 0
on = False
while on == False: # and counter < 10:
    counter = counter + 1
    cmd = start_cmd
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)

    cmd = getstate_cmd
    print "Command: " + cmd
    # subprocess.call([cmd], shell=True)
    i = 0
    for file in os.popen(cmd).readlines():
        i = i+1
        print "%d: %s" % (i, file)
        if file.find('on') != -1:
            print "Running! :)"
            on = True
        else:
            print "Still not running! :("
            on = False

    if on == False:
        if counter % 3 == 1:
            cmd = force_discard_cmd
        if counter % 3 == 2:
            cmd = force_resume_cmd
        if counter % 3 == 0:
            cmd = force_discard_cmd

        print "Command: " + cmd
        subprocess.call([cmd], shell=True)

