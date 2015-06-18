#!/usr/bin/python

import sys
import re
import os
import subprocess
import time

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

# stop it
suspend_cmd = "vmware-cmd %s suspend soft" % vmx_file
getstate_cmd = "vmware-cmd %s getstate" % vmx_file
unregister_cmd = "vmware-cmd -s unregister %s" % vmx_file
reset_cmd = "vmware-cmd %s reset hard" % vmx_file
stop_cmd = "vmware-cmd %s stop hard" % vmx_file
start_cmd = "vmware-cmd %s start" % vmx_file

print "First, trying to suspend..."
counter = 0
suspended = False
while suspended == False: # and counter < 10:
    counter = counter + 1
    print "counter: %d" % counter

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
        if file.find('suspended') != -1: 
            print "Suspended! :)"
            suspended = True
        else:
            print "Still not suspended! :("
            suspended = False
            if counter > 3:
                if counter % 2 == 0:
                    cmd = reset_cmd
                    print "Command: " + cmd
                    subprocess.call([cmd], shell=True)
                elif counter % 2 == 1:
                    cmd = stop_cmd
                    print "Command: " + cmd
                    subprocess.call([cmd], shell=True)
                    cmd = start_cmd
                    print "Command: " + cmd
                    subprocess.call([cmd], shell=True)
                if counter == 4:
                    wait = 40
                elif counter == 5:
                    wait = 80
                elif counter == 6:
                    wait = 120
                else:
                    print "Was not able to suspend..."
                    sys.exit(-1)
                print "Sleepting for %d seconds..." % wait
                time.sleep(wait)
    if i == 0:
        print "Not registered!"
        suspended = True

print "Second, trying to unregister..."
counter = 0
reg = True
while suspended == True and reg == True: # and counter < 10:
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

