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
    # if the restore_file exists restore the Virtual Machine from the restore_file
    # the restore_file is generated whenever stop_vm.py is called, this implies that the machine has been created before and is now being restarted.
    if(os.path.isfile(restore_file)):
        start_cmd = "virsh --connect qemu:///system restore " + restore_file
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
              
        # since the VM is suspsended in stop_vm.py before it is saved it must be resumed after it has been restored
        start_cmd = "virsh --connect qemu:///system resume " + name
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
       
        os.remove(restore_file)
        sys.exit(0)    
    
    # if the restore file does not exist the Virtual Machine must be created
    # the parameter ram refers to how much memory will be allocated to the new VM
    # the parameter network refers to the network it will be using, should usually be between Router1-Router8
    # the mac parameter refers to the mac address to be used
    # name is a name given to the Virtual Machine
    # os_type is the type of Operating System the Virtual Machine is running
    # qcow2_file refers to the location of the qcow2 file that will be used to create the Virtual Machine
    # vcpus is the number of virtual cpus assigned to the virtual machine should usuually be one.
    else:
        start_cmd = "virt-install --connect qemu:///system --ram %s --network network:%s,mac=%s --name %s --os-type=%s --disk path=%s,device=disk,format=qcow2 --vcpus=%s --accelerate --force  --vnc --noautoconsole --import" % (ram, network, mac, name, os_type, qcow2_file, vcpus)
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
        sys.exit(0)

# when taking 9 arguments there are two mac addresses instead of one.
# the syntax for this is as follows
# Usage: %s <qcow2_file> <name> <os_type> <ram> <vcpus> <network_name> <mac_address> <mac_address2>
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
        start_cmd = "virt-install --connect qemu:///system --ram %s --network network:%s,mac=%s --network network:%s,mac=%s --name %s --os-type=%s --disk path=%s,device=disk,format=qcow2 --vcpus=%s --accelerate --force  --vnc --noautoconsole --import" % (ram, network, mac1, network, mac2, name, os_type, qcow2_file, vcpus)
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
        sys.exit(0)


else:   
    print "Usage: %s <qcow2_file> <name> <os_type> <ram> <vcpus> <network_name> <mac_address>" % sys.argv[0]
    sys.exit(1)

