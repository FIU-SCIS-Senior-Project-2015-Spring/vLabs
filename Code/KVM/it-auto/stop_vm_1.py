#!/usr/bin/python

import sys
import re
import os
import subprocess
import time
import random

def isLoadHigh():
    uptime_cmd = "uptime"
    cmd = uptime_cmd
    print "Command: " + cmd
    # subprocess.call([cmd], shell=True)
    for output in os.popen(cmd).readlines():
        print "output: %s" % output
        index = output.find('load average')
        # print "index: %d" % index
        output = output[index+14:]
        # print "output: %s" % output
        index = output.find(',')
        # print "index: %d" % index
        avg1 = float(output[:index])
        # print "avg1: %f" % avg1
        output = output[index+2:]
        # print "output: %s" % output
        index = output.find(',')
        # print "index: %d" % index
        avg5 = float(output[:index])
        # print "avg5: %f" % avg5
        output = output[index+2:]
        # print "output: %s" % output
        avg15 = float(output)
        # print "avg15: %f" % avg15

    get_core_cmd = "grep 'model name' /proc/cpuinfo | wc -l"
    cmd = get_core_cmd
    print "Command: " + cmd
    # subprocess.call([cmd], shell=True)
    for output in os.popen(cmd).readlines():
        # print "output: %s" % output
        cores = int(output)
        print "cores: %d" % cores

    avg1percentage = avg1 * 100 / cores
    # print "avg1/cores: %f" % avg1percentage

    avg5percentage = avg5 * 100 / cores
    # print "avg5/cores: %f" % avg5percentage

    avg15percentage = avg15 * 100 / cores
    # print "avg15/cores: %f" % avg15percentage

    loadavg = int(avg1percentage)
    print "loadavg: %d" % loadavg

    loadHigh = False
    # if loadavg > 40:
    #     loadHigh = True
    print "loadHigh: " + str(loadHigh)

    return loadHigh;


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

    # while isLoadHigh() == True:
    #     wait = random.randint(1, 30)        
    #     print "The host is busy! Wating for %d seconds..." % wait
    #     time.sleep(wait)

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
        elif file.find('off') != -1: 
            print "Off! :)"
            suspended = True
        else:
            print "Still not suspended! :("
            suspended = False
            if counter > 3:
                while isLoadHigh() == True:
                    wait = random.randint(1, 30)        
                    print "The host is busy! Wating for %d seconds..." % wait
                    time.sleep(wait)

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
                    if vmx_file.find('w2k3') != -1:
                        wait = 80
                elif counter == 5:
                    wait = 80
                    if vmx_file.find('w2k3') != -1:
                        wait = 160
                elif counter == 6:
                    wait = 120
                    if vmx_file.find('w2k3') != -1:
                        wait = 320
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

if suspended == True and reg == False:
    sys.exit(0)
else:
    sys.exit(1)
