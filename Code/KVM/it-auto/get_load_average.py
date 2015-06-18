#!/usr/bin/python

import sys
import os.path
import re
import subprocess
import time

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
    print "avg1: %f" % avg1
    output = output[index+2:]
    # print "output: %s" % output
    index = output.find(',')
    # print "index: %d" % index
    avg5 = float(output[:index])
    print "avg5: %f" % avg5
    output = output[index+2:]
    # print "output: %s" % output
    avg15 = float(output)
    print "avg15: %f" % avg15
   
get_core_cmd = "grep 'model name' /proc/cpuinfo | wc -l"
cmd = get_core_cmd
print "Command: " + cmd
# subprocess.call([cmd], shell=True)
for output in os.popen(cmd).readlines():
    # print "output: %s" % output
    cores = int(output)
    print "cores: %d" % cores

avg1percentage = avg1 * 100 / cores
print "avg1/cores: %f" % avg1percentage 

avg5percentage = avg5 * 100 / cores
print "avg5/cores: %f" % avg5percentage 

avg15percentage = avg15 * 100 / cores
print "avg15/cores: %f" % avg15percentage 

loadavg = int(avg1percentage)
print "loadavg: %d" % loadavg
sys.exit(loadavg)
