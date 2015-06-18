

#
# Configuration data
#

# VMX Representation template
COMMON_PARAMS = """#!/usr/bin/vmware                 
config.version = "8"
virtualHW.version = "4"

priority.grabbed = "normal"
priority.ungrabbed = "normal"

powerType.powerOff = "hard"
powerType.powerOn = "hard"
powerType.suspend = "hard"
powerType.reset = "hard"

tools.syncTime = "FALSE"

floppy0.present = "FALSE" """


# MAP_IP = { "64.77.83.39": "00:50:56:13:13:39",
#            "64.77.83.40": "00:50:56:13:13:40",
#            "64.77.83.41": "00:50:56:13:13:41",
#            "64.77.83.42": "00:50:56:13:13:42",
#            "64.77.83.43": "00:50:56:13:13:43",
#            "64.77.83.44": "00:50:56:13:13:44",
#            "64.77.83.45": "00:50:56:13:13:45",
#            "64.77.83.46": "00:50:56:13:13:46" }


#
# VM types
#
VM_TYPES = [ "xp", "w2k3" ]


"""
Exception for incorrect VM types
"""
class VMTypeError(Exception):

    def __init__(self, vm_type):
        self.vm_type = vm_type

    def __str__(self):
        return "Wrong VM type: %s" % self.vm_type


"""
Exception for incorrect IP address
"""
class IPError(Exception):

    def __init__(self, ip):
        self.ip = ip

    def __str__(self):
        return "Wrong IP address: %s" % self.ip




"""
Defines a VM through a VMWare VMX file
"""

class VM:
    newWin=-1		
    def __init__(self, vm_type, router, instance, memsize=1024, ncpus=1, mac_address=None, mac2_address=None, instance_name="", checkpointed=False):
        """Initialize params"""
        self.newWin=1 # instance_name.find("K2_3")

	if vm_type in VM_TYPES:
            self.vm_type = vm_type
        else:
            raise VMTypeError(vm_type)

        self.checkpointed = checkpointed

        # deployment number depends on the ip
        #self.deployment_n = self.__calculate_deployment_n()
        
        # vlab uses vmnet20 for router 1, vmnet21 for router 2, etcetera 
        self.deployment_n = router + 19
        self.instance = instance

        self.mac_address = mac_address
        self.mac2_address = mac2_address

        self.params = {}

        self.params["common"] = COMMON_PARAMS
        self.params["numvcpus"] = self.__qt(ncpus)
        self.params["memsize"] = self.__qt(memsize)

        vmnet = "-vmnet" + str(self.deployment_n)

        if self.vm_type == "w2k3":
            # self.params["displayName"] = self.__qt(instance_name + vmnet + "-" + vm_type)
            	self.params["displayName"] = self.__qt(instance_name + "-" + vm_type)
		if self.newWin != -1 :
            		self.params["guestOS"] = self.__qt("winnetenterprise-64")
        
		else:
	
			self.params["guestOS"] = self.__qt("winnetenterprise")
        else:
            # self.params["displayName"] = self.__qt(instance_name + vmnet + "-" + vm_type + \
            self.params["displayName"] = self.__qt(instance_name + "-" + vm_type + \
                                                       str(instance))
            self.params["guestOS"] = self.__qt("winxppro")

    def __qt(self, text):
        """Return the passed text, quoted"""
        return "\"%s\"" % text

    def __get_val(self, value, dict):
        """Print a params value"""
        return "%s = %s" % (value, dict[value])

    def __disk_params(self):
        """Print the disk description"""
        disk_params = {}

        if self.vm_type == "w2k3":
            disk_params["scsi0.present"] = self.__qt("TRUE")
            disk_params["scsi0.virtualDev"] = self.__qt("lsilogic")
            disk_params["scsi0:0.present"] = self.__qt("TRUE")
            disk_params["scsi0:0.fileName"] = self.__qt(self.vm_type + "-000001.vmdk")
            disk_params["scsi0:0.writeThrough"] = self.__qt("TRUE")
            disk_params["scsi0:0.redo"] = self.__qt("")
        else:
		if self.newWin != -1 :
            		disk_params["scsi0.present"] = self.__qt("TRUE") # required to solve ethernet bug in winxp
            		disk_params["scsi0:0.present"] = self.__qt("TRUE")
            		disk_params["scsi0:0.fileName"] = self.__qt("xp1-000001.vmdk")
            		disk_params["scsi0:0.writeThrough"] = self.__qt("TRUE")
            		disk_params["scsi0:0.redo"] = self.__qt("")
		        disk_params["scsi0.virtualDev"] = self.__qt("lsilogic")
 

		else:
            		disk_params["scsi0.present"] = self.__qt("TRUE") # required to solve ethernet bug in winxp
            		disk_params["ide0:0.present"] = self.__qt("TRUE")
            		disk_params["ide0:0.fileName"] = self.__qt("xp1-000001.vmdk")
            		disk_params["ide0:0.writeThrough"] = self.__qt("TRUE")
            		disk_params["ide0:0.redo"] = self.__qt("")

        return self.__format_dict(disk_params)

        
    def __nic_params(self):
        """Print the values for ethernet cards"""

        nic_params = {}

        nic_params.update(self.__private_nic("Ethernet0"))

        return self.__format_dict(nic_params)

    def __nic2_params(self):
        """Print the values for ethernet cards"""

        nic2_params = {}

        nic2_params.update(self.__private_nic2("Ethernet1"))

        return self.__format_dict(nic2_params)


    def __private_nic(self, nic_name):
        """Generate a private nic. Assign it a MAC address if it was passed in the constructor"""

        nic_params = {}
        nic_params[nic_name + ".present"] = self.__qt("TRUE")
        nic_params[nic_name + ".connectionType"] = self.__qt("custom")
        nic_params[nic_name + ".vnet"] = self.__qt("/dev/vmnet" + str(self.deployment_n))
        if self.mac_address:
            nic_params[nic_name + ".address"] = self.__qt(self.mac_address)
        nic_params[nic_name + ".addressType"] = self.__qt("static")
	if self.newWin != -1 :
		nic_params[nic_name + ".virtualDev"] = "e1000"
        return nic_params


    def __private_nic2(self, nic2_name):
        """Generate a private nic. Assign it a MAC address if it was passed in the constructor"""

        nic2_params = {}
        nic2_params[nic2_name + ".present"] = self.__qt("TRUE")
        nic2_params[nic2_name + ".connectionType"] = self.__qt("custom")
        nic2_params[nic2_name + ".vnet"] = self.__qt("/dev/vmnet" + str(self.deployment_n))
        if self.mac2_address:
            nic2_params[nic2_name + ".address"] = self.__qt(self.mac2_address)
        nic2_params[nic2_name + ".addressType"] = self.__qt("static")
	if self.newWin != -1 :
		nic2_params[nic2_name + ".virtualDev"] = "e1000"
       		
	 
	return nic2_params


    def __format_dict(self, dict):
        """Format a dictionary to be printed in the vmx file"""
        x = []
        for k in dict.keys():
            x.append(self.__get_val(k, dict))
            
        return "\n".join(x)


    def get_vmx(self):
        """Return a string with the vmx configuration"""

	
        strs = []
        strs.append(self.params["common"])
        strs.append(self.__disk_params())
        strs.append(self.__get_val("numvcpus", self.params))
        strs.append(self.__get_val("memsize", self.params))
        strs.append(self.__get_val("displayName", self.params))
        strs.append(self.__get_val("guestOS", self.params))
        if self.mac_address:
            strs.append(self.__nic_params())
        if self.mac2_address:
            strs.append(self.__nic2_params())
        if self.checkpointed:
            # if self.vm_type == "w2k3":
            #     strs.append("checkpoint.vmState = \"w2k3-Snapshot1.vmsn\"")
            # else:
            #     strs.append("checkpoint.vmState = \"xp1-Snapshot1.vmsn\"")
            # strs.append("checkpoint.vmState.readOnly = \"TRUE\"")
        # else: 
            if self.vm_type == "w2k3":
                strs.append("checkpoint.vmState = \"w2k3.vmss\"")
            else:
                strs.append("checkpoint.vmState = \"xp1.vmss\"")
            # strs.append("checkpoint.vmState.readOnly = \"FALSE\"")

        strs.append("")
        
        return "\n\n".join(strs)
        
    def print_vmx(self):
        """Print the vmx configuration file based on the defined params"""
        print self.get_vmx()
        

        
