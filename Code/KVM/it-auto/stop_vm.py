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

stop_vm_cmd = "stop_vm_1.py %s" % vmx_file
cmd = stop_vm_cmd
print "Command: " + cmd
retcode = subprocess.call([cmd], shell=True)
print "retcode = %d" % retcode

# make sure that the vmx is out of memory
# print "vmx_file: " + vmx_file    
rev = vmx_file[::-1]
# print "rev: " + rev
x = rev.find("/")
# print "x: %d" % x 
rem = rev[x+1:]
# print "rem: " + rem
x = rem.find("/")
# print "x: %d" % x 
rem = rem[x+1:]
# print "rem: " + rem
rem = rem[::-1]
# print "rem: " + rem
real_vmx_file = os.readlink(rem)
# print "real_vmx_file: " + real_vmx_file
rem = real_vmx_file[::-1]
# print "rem: " + rem
x = rem.find("/")
# print "x: %d" % x 
rem = rem[:x]
# print "rem: " + rem
rem = rem[::-1]
# print "rem: " + rem
ve_ins = "/" + rem[:x] 
# print "ve_ins: " + ve_ins

file_name = vmx_file[::-1]
# print "file_name: " + file_name
x = file_name.find("/")
# print "x: %d" % x 
file_name = file_name[:x]
# print "file_name: " + file_name
file_name = file_name[::-1]
# print "file_name: " + file_name

vm_dir = vmx_file[::-1]
# print "vm_dir: " + vm_dir
x = vm_dir.find("/")
# print "x: %d" % x 
vm_dir = vm_dir[x+1:]
# print "vm_dir: " + vm_dir
x = vm_dir.find("/")
# print "x: %d" % x 
vm_dir = vm_dir[:x]
# print "vm_dir: " + vm_dir
vm_dir = vm_dir[::-1]
# print "vm_dir: " + vm_dir

rem = ve_ins + "/" + vm_dir + "/" + file_name 
print "rem: " + rem

getvmx_cmd = "ps -eo args | grep %s | cut -d' ' -f3" % rem
subprocess.call([getvmx_cmd], shell=True)
print "Command: " + getvmx_cmd
retcode1 = 0
done = False
while not done:
    done = True
    for file in os.popen(getvmx_cmd).readlines():
        if file.find("vmx") != -1:
            print "Not done yet! :("
            done = False

            print "file: " + file
            vmx = file[:-1]                       # strip '\n' 
            print "vmx: " + vmx

            start_vm_cmd = "start_vm.py %s" % vmx
            cmd = start_vm_cmd
            print "Command: " + cmd
            subprocess.call([cmd], shell=True)

            stop_vm_1_cmd = "stop_vm_1.py %s" % vmx
            cmd = stop_vm_1_cmd
            print "Command: " + cmd
            retcode1 = retcode1 + subprocess.call([cmd], shell=True)

print "retcode1 = %d" % retcode1

if retcode1 == 0:
    print "It is done! The vm has stopped! :) "
    
sys.exit(retcode1)
