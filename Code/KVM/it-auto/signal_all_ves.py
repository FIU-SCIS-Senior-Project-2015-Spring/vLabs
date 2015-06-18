#!/usr/bin/python

import sys
import os.path
import re
import subprocess
import time

if (len(sys.argv) != 2):
    print "Usage: %s <signal>" % sys.argv[0]
    sys.exit(1)

signal = sys.argv[1]
print "signal: " + signal

for i in [1,2]:
    if i == 1:
        match_str = "assigned"
    elif i == 2:
        match_str = "provisioned"

    print "i: %d and match_str: %s" % (i, match_str)

    getstop_cmd = "ps -eo pid,args | grep vmx | grep %s | sed -e 's/^[ \t]*//' | cut -d' ' -f1" % match_str
    cmd = getstop_cmd
    # subprocess.call([cmd], shell=True)
    print "Command: " + cmd
    for file in os.popen(cmd).readlines():
        file = file[:-1]                       # strip '\n' 
        print "file: " + file

        signal_cmd = "kill -%s %s" % (signal, file)
        cmd = signal_cmd
        print "Command: " + cmd
        subprocess.call([cmd], shell=True)

