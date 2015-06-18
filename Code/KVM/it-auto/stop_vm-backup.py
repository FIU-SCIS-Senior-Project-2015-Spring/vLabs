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
suspend_cmd = "vmware-cmd %s suspend soft" % vmx_file
getstate_cmd = "vmware-cmd %s getstate" % vmx_file
unregister_cmd = "vmware-cmd -s unregister %s" % vmx_file

counter = 0
on = True
while on == True: # and counter < 10:
    counter = counter + 1
    cmd = suspend_cmd
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
            print "Still running! :("
            on = True
        else:
            print "Suspended! :)"
            on = False
    if i == 0:
        print "Not registered!"
        on = False

counter = 0
reg = True
while on == False and reg == True: # and counter < 10:
    counter = counter + 1
    cmd = unregister_cmd
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)

    cmd = getstate_cmd
    print "Command: " + cmd
    # subprocess.call([cmd], shell=True)
    reg = False
    i = 0
    for file in os.popen(cmd).readlines(): 
        i = i+1 
        print "%d: %s" % (i, file)
        if file.find('getstate') != -1: 
            print "Still registered! :("
            reg = True
        else:
            print "Not registered anymore! :)"
            reg = False
    if i == 0:
        print "Not registered!"
        reg = False

