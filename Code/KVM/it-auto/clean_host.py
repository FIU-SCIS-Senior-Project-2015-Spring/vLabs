#!/usr/bin/python

import sys
import re
import os
import subprocess

if len(sys.argv) != 1 :
    print "Usage: %s " % sys.argv[0]
    sys.exit(1)

getstop_cmd = "ps -eo pid,args | grep vmx | grep stop | sed -e 's/^[ \t]*//' | cut -d' ' -f1"
cmd = getstop_cmd
subprocess.call([cmd], shell=True)
print "Command: " + cmd
for file in os.popen(cmd).readlines():
    file = file[:-1]                       # strip '\n' 
    print "file: " + file

    kill_stop_cmd = "kill -9 %s" % file
    cmd = kill_stop_cmd
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)

getstart_cmd = "ps -eo pid,args | grep vmx | grep start | sed -e 's/^[ \t]*//' | cut -d' ' -f1"
cmd = getstart_cmd
subprocess.call([cmd], shell=True)
print "Command: " + cmd
for file in os.popen(cmd).readlines():
    file = file[:-1]                       # strip '\n' 
    print "file: " + file

    kill_start_cmd = "kill -9 %s" % file
    cmd = kill_start_cmd
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)

getvmx_cmd = "ps -eo args | grep xp1 | grep vmx | cut -d' ' -f3"
subprocess.call([getvmx_cmd], shell=True)
print "Command: " + getvmx_cmd
for file in os.popen(getvmx_cmd).readlines():
    if file.find("vmx") != -1:
        print "file: " + file
        vmx = file[:-1]                       # strip '\n' 
        print "vmx: " + vmx

        start_vm_cmd = "start_vm.py %s" % vmx
        cmd = start_vm_cmd
        print "Command: " + cmd
        subprocess.call([cmd], shell=True)

        stop_vm_cmd = "stop_vm.py %s" % vmx
        cmd = stop_vm_cmd
        print "Command: " + cmd
        subprocess.call([cmd], shell=True)

getvmx_cmd = "ps -eo args | grep w2k3 | grep vmx | cut -d' ' -f3"
subprocess.call([getvmx_cmd], shell=True)
print "Command: " + getvmx_cmd
for file in os.popen(getvmx_cmd).readlines():
    if file.find("vmx") != -1:
        print "file: " + file
        vmx = file[:-1]                       # strip '\n' 
        print "vmx: " + vmx

        start_vm_cmd = "start_vm.py %s" % vmx
        cmd = start_vm_cmd
        print "Command: " + cmd
        subprocess.call([cmd], shell=True)

        stop_vm_cmd = "stop_vm.py %s" % vmx
        cmd = stop_vm_cmd
        print "Command: " + cmd
        subprocess.call([cmd], shell=True)


