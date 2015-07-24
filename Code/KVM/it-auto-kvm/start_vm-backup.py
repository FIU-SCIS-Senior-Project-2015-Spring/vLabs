#!/usr/bin/python

import libvirt
import sys
import re
import os
import os.path
import subprocess

#from vmxutil import vmx

if len(sys.argv) == 2:
    xml_file = sys.argv[1]
    cmd = "virsh --connect qemu:///system create %s" % xml_file
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)

    cmd = "virsh --connect qemu:///system define %s" % xml_file
    print "Command: " + cmd
    subprocess.call([cmd], shell=True)

elif len(sys.argv) == 8:

    qcow2_file = sys.argv[1]
    name = sys.argv[2]
    os_type = sys.argv[3]
    ram = sys.argv[4]
    vcpus = sys.argv[5]
    network = sys.argv[6]
    mac = sys.argv[7]
    
    restore_file = qcow2_file + ".restore"
    conn = libvirt.open("qemu:///system")
    
    start_cmd = None    
    # if the restore_file exists restore the Virtual Machine from the restore_file
    # the restore_file is generated whenever stop_vm.py is called, this implies that the machine has been created before and is now being restarted.
    if(os.path.isfile(restore_file)):

        chown_cmd = "sudo /home/sadjadi-vmstorage/sadjadi-vms/it-auto-kvm/change_owner.sh %s" % restore_file
        retcode = subprocess.call([chown_cmd],shell=True)
        if retcode < 0:
            print >>sys.stderr, "sudo as terminated by signal", -retcode
        else:
            print >>sys.stderr, "sudo returned", retcode
        
 
        restore_file2 = restore_file + "2"
        fin = open(restore_file, "r")
        fout = open(restore_file2, "w")

        replace = "      <source network='%s'/>\n" % network

        for line in fin:
            match = re.match("      \<source network.*", line)
            if match:
                fout.write(replace)
            else:
                fout.write(line)
        fin.close()
        fout.close()
        # conn.restore(restore_file2)           
        restore_cmd = "virsh --connect qemu:///system restore %s" % restore_file2 
        subprocess.call([restore_cmd],shell=True);
        print "Domain %s has been restored"% name       
        # since the VM is suspsended in stop_vm.py before it is saved it must be resumed after it has been restored
        try:
            dom = conn.lookupByName(name)
            dom.resume() 
            print "Domain %s is being resumed"% name
            if dom.isActive():
                os.remove(restore_file) 
                os.remove(restore_file2)   
                print "The restore files have been removed"
            # if the VM is not persistent make it so
            if not dom.isPersistent():
                # first get the xml file from storage by the VM name and store it
                cmd = "virsh --connect qemu:///system dumpxml %s > %s.xml" % (name, name)
                print "Command: " + cmd
                subprocess.call([cmd], shell=True)
                # use the xml file to define, make persistent, the VM
                cmd = "virsh --connect qemu:///system define %s.xml" % name
                print "Command: " + cmd
                subprocess.call([cmd], shell=True)
                # remove the xml file we stored earlier
                cmd = "rm %s.xml" % name
                print "Command: " + cmd
                subprocess.call([cmd], shell=True)
        except:
            print "Exception"
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
        start_cmd = "virt-install --connect qemu:///system --ram %s --network network:%s,mac=%s --name %s --os-type=%s --disk path=%s,device=disk,format=qcow2 --vcpus=%s --accelerate --force --vnc --keymap=en-us --noautoconsole --import" % (ram, network, mac, name, os_type, qcow2_file, vcpus)
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
    mac1 = sys.argv[8]
    mac2 = sys.argv[7]

    restore_file = qcow2_file + ".restore"
    conn = libvirt.open("qemu:///system")

    start_cmd = None    
    # if the restore file exists restore the VM with that name
    if(os.path.isfile(restore_file)):

        chown_cmd = "sudo /home/sadjadi-vmstorage/sadjadi-vms/it-auto-kvm/change_owner.sh %s" % restore_file
        retcode = subprocess.call([chown_cmd],shell=True)
        if retcode < 0:
            print >>sys.stderr, "sudo as terminated by signal", -retcode
        else:
            print >>sys.stderr, "sudo returned", retcode

        restore_file2 = restore_file + "2"
        fin = open(restore_file, "r")
        fout = open(restore_file2, "w")

        replace = "      <source network='%s'/>\n" % network

        for line in fin:
            match = re.match("      \<source network.*", line)
            if match:
                fout.write(replace)
            else:
                fout.write(line)
        fin.close()
        fout.close() 
        # conn.restore(restore_file2)
        restore_cmd = "virsh --connect qemu:///system restore %s" % restore_file2 
        subprocess.call([restore_cmd],shell=True);
        print "Domain %s has been restored"% name
        # since the VM is suspsended before it is saved it must be resumed
        try:
            dom = conn.lookupByName(name)
            dom.resume()
            print "Domain %s is being resumed"% name
            if dom.isActive():
                os.remove(restore_file2)
                os.remove(restore_file)
                print "The restore files have been removed"
            # if the VM is not persistent make it so
            if not dom.isPersistent():
                # first get the xml file from storage by the VM name and store it
                cmd = "virsh --connect qemu:///system dumpxml %s > %s.xml" % (name, name)
                print "Command: " + cmd
                subprocess.call([cmd], shell=True)
                # use the xml file to define, make persistent, the VM
                cmd = "virsh --connect qemu:///system define %s.xml" % name
                print "Command: " + cmd
                subprocess.call([cmd], shell=True)
                # remove the xml file we stored earlier
                cmd = "rm %s.xml" % name
                print "Command: " + cmd
                subprocess.call([cmd], shell=True)
        except:
            print "Exception"
        sys.exit(0)
    else:
        start_cmd = "virt-install --connect qemu:///system --ram %s --network network:%s,mac=%s --network network:%s,mac=%s --name %s --os-type=%s --disk path=%s,device=disk,format=qcow2 --vcpus=%s --accelerate --force --vnc --keymap=en-us --noautoconsole --import" % (ram, network, mac1, network, mac2, name, os_type, qcow2_file, vcpus)
        cmd = start_cmd
        print "Command: " + start_cmd
        subprocess.call([cmd], shell=True)
        sys.exit(0)


else:   
    print "Usage: %s <qcow2_file> <name> <os_type> <ram> <vcpus> <network_name> <mac_address>" % sys.argv[0]
    sys.exit(1)

