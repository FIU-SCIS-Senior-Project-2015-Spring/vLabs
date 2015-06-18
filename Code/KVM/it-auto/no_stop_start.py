#!/usr/bin/python

import sys
import os.path
import re
import subprocess
import time

getstop_cmd = "ps -eo pid,args | grep vmx | grep stop | sed -e 's/^[ \t]*//' | cut -d' ' -f1"
cmd = getstop_cmd
subprocess.call([cmd], shell=True)
print "Command: " + cmd
stop_counter = 0
for process_id in os.popen(cmd).readlines():
    stop_counter = stop_counter + 1
    process_id = process_id[:-1]                       # strip '\n' 
    print "stop_counter: %d process_id: %s" % (stop_counter, process_id)

getstart_cmd = "ps -eo pid,args | grep vmx | grep start | sed -e 's/^[ \t]*//' | cut -d' ' -f1"
cmd = getstart_cmd
subprocess.call([cmd], shell=True)
print "Command: " + cmd
start_counter = 0
for process_id in os.popen(cmd).readlines():
    start_counter = start_counter + 1
    process_id = process_id[:-1]                       # strip '\n' 
    print "start_counter: %d process_id: %s" % (start_counter, process_id)

ret_val = 0
if stop_counter > 1 or start_counter > 1:
    ret_val = -1

print "ret_val: %d" % ret_val
sys.exit(ret_val)
