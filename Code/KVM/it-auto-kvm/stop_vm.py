#!/usr/bin/python

import libvirt
import sys
import re
import os
import subprocess

#from vmxutil import vmx

if len(sys.argv) != 3 :
    print "Usage: %s <qcow2_file> <name>" % sys.argv[0]
    sys.exit(1)

qcow2_file = sys.argv[1]
name = sys.argv[2]
restore_file = qcow2_file + ".restore"
conn = libvirt.open("qemu:///system")
# globals

# HOME = "/disk/serval/serval-vm-storage/portal/exams"
HOME = os.environ["HOME"]+"/exams"

try:
    dom = conn.lookupByName(name)
    # command to suspend the virtual machine
    # dom.suspend()
    print "Domain %s has been suspended"% name
    # command to save the current state of the virtual machine
    # the restore_file is in the same location as the qcow2_file
    dom.save(restore_file)
    print "Domain %s has been saved"% name
    # the Virtual Machine is then undefine so that it won't appear in virt-manager
    dom.undefine()
    print "Domain %s has been undefined"% name
except:
    print "Exception"



sys.exit(0)
