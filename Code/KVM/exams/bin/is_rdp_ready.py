#!/usr/bin/python

import sys
import re
import os
import subprocess

# globals

if len(sys.argv) <> 3:
    print "Usage: %s <server_name> <server_port>" % sys.argv[0]
    sys.exit(1)

server_name = sys.argv[1]
server_port = sys.argv[2]

nmap_cmp = "doalarm 1 nmap -p %s %s" % (server_port, server_name)
cmd = nmap_cmp
print "Command: " + cmd
# subprocess.call([cmd], shell=True)
i = 0
retVal = -1
for line in os.popen(cmd).readlines():
    i = i+1
    print "Output: %d: %s" % (i, line)
    if 'open' in line:
        retVal = 0
    if 'closed' in line:
        retVal = 1

print "retVal: %d" % retVal
sys.exit(retVal)
