import sys
import re
import os
import subprocess

from vmxutil import vmx

if len(sys.argv) != 6 :
    print "Usage: %s <qcow2_file> <username> <ve_type> <id_number> <RDP_port>" % sys.argv[0]
    sys.exit(1)

qcow2_file = sys.argv[1]
username = sys.argv[2]
ve_type = sys.argv[3]
id_num = sys.argv[4]
rdp_port = sys.argv[5]

m = re.search(str(id_num) + '/(\S+)-', qcow2_file)
if m:
    os_type = m.group(1)
else:
    sys.exit(1)

print os_type

vm_name = username + ve_type + str(rdp_port) + os_type

print 'VM Name is ' + vm_name


