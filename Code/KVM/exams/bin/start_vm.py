#!/usr/bin/python

import sys
import re
import os
import os.path
import subprocess

#from vmxutil import vmx

if len(sys.argv) == 8:

    qcow2_file = sys.argv[1]
    name = sys.argv[2]
    os_type = sys.argv[3]
    ram = sys.argv[4]
    vcpus = sys.argv[5]
    network = sys.argv[6]
    mac = sys.argv[7]
    
    restore_file = qcow2_file + ".restore"

    start_cmd = None    

    if(os.path.isfile(restore_file)):
        start_cmd = "virsh --connect qemu:///system restore " + restore_file
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
              
        start_cmd = "virsh --connect qemu:///system resume " + name
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
       
        os.remove(restore_file)
        sys.exit(0)    
    
    else:
        start_cmd = "virt-install --connect qemu:///system --ram %s --network network:%s,mac=%s --name %s --os-type=%s --disk path=%s,device=disk,format=qcow2 --vcpus=%s --accelerate --force  --vnc --noautoconsole --import" % (ram, network, mac, name, os_type, qcow2_file, vcpus)
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
        sys.exit(0)


elif len(sys.argv) == 9:
   
    qcow2_file = sys.argv[1]
    name = sys.argv[2]
    os_type = sys.argv[3]
    ram = sys.argv[4]
    vcpus = sys.argv[5]
    network = sys.argv[6]
    mac1 = sys.argv[7]
    mac2 = sys.argv[8]

    restore_file = qcow2_file + ".restore"

    start_cmd = None

    if(os.path.isfile(restore_file)):
        start_cmd = "virsh restore " + restore_file
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)

        start_cmd = "virsh resume " + name
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)

        os.remove(restore_file)
        sys.exit(0)

    else:
        start_cmd = "virt-install --connect qemu:///system --ram %s --network network:%s,mac=%s --network network:%s,mac=%s --name %s --os-type=%s --disk path=%s,device=disk,format=qcow2 --vcpus=%s --accelerate --force  --vnc --noautoconsole --import" % (ram, network, mac1, network, mac2, name, os_type, qcow2_file, vcpus)
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
        sys.exit(0)


else:   
    print "Usage: %s <qcow2_file> <name> <os_type> <ram> <vcpus> <network_name> <mac_address>" % sys.argv[0]
    sys.exit(1)

