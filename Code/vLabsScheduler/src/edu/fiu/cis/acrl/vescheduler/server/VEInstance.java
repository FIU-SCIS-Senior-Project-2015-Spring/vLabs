package edu.fiu.cis.acrl.vescheduler.server;

import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VirtualEnvironmentType;

public class VEInstance {

	public enum VEInsStatusType { 
		NOT_PROVISIONED,
		PROVISIONING_AND_STARTING,
		RUNNING,
		PAUSING,
		PAUSED,
		STARTING,
		DESTROYED
		};

	private String id;
	private String username;
	private VirtualEnvironmentType veType;
	private int storageId;
	private int kserverId;
	private int firstPort;
	private int numPorts;
	private int firstMac;
	private int numMacs;
	private boolean store;
	private boolean active;
	private VEInsStatusType status;

	public VEInstance(
			String id, 
			String username,
			VirtualEnvironmentType veType, 
			int storageId,
			int kserverId,
			int firstPort, 
			int numPorts, 
			int firstMac, 
			int numMacs, 
			boolean store, 
			boolean active,
			VEInsStatusType status) {
	
		this.id = id;
		this.username = username;
		this.veType = veType;
		this.storageId = storageId;
		this.kserverId = kserverId;
		this.firstPort = firstPort;
		this.numPorts = numPorts;
		this.firstMac = firstMac;
		this.numMacs = numMacs;
		this.store = store;
		this.active = active;
		this.status = status;
		
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void setVeType(VirtualEnvironmentType veType) {
		this.veType = veType;
	}

	public VirtualEnvironmentType getVeType() {
		return veType;
	}

	public void setFirstPort(int firstPort) {
		this.firstPort = firstPort;
	}
	public int getFirstPort() {
		return firstPort;
	}
	
	public void setNumPorts(int numPorts) {
		this.numPorts = numPorts;
	}
	public int getNumPorts() {
		return numPorts;
	}
	
	public void setStore(boolean store) {
		this.store = store;
	}
	public boolean isStore() {
		return store;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}

	public void setFirstMac(int firstMac) {
		this.firstMac = firstMac;
	}

	public int getFirstMac() {
		return firstMac;
	}

	public void setMacNums(int macNums) {
		this.numMacs = macNums;
	}

	public int getNumMacs() {
		return numMacs;
	}

	public void setStatus(VEInsStatusType status) {
		this.status = status;
	}

	public VEInsStatusType getStatus() {
		return status;
	}

	public void setStatus(String statusString) {

		this.status = getStatus(statusString);
		
	}

	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public int getStorageId() {
		return storageId;
	}

	public void setKserverId(int kserverId) {
		this.kserverId = kserverId;
	}
	public int getKserverId() {
		return kserverId;
	}

	static public VEInsStatusType getStatus(String statusString) {
		
		VEInsStatusType status = null;
		
		if (statusString.equals("NOT_PROVISIONED"))
			status = VEInsStatusType.NOT_PROVISIONED;
		else if (statusString.equals("PROVISIONING_AND_STARTING"))
			status = VEInsStatusType.PROVISIONING_AND_STARTING;
		else if (statusString.equals("RUNNING"))
			status = VEInsStatusType.RUNNING;
		else if (statusString.equals("PAUSING"))
			status = VEInsStatusType.PAUSING;
		else if (statusString.equals("PAUSED"))
			status = VEInsStatusType.PAUSED;
		else if (statusString.equals("STARTING"))
			status = VEInsStatusType.STARTING;
		else if (statusString.equals("DESTROYED"))
			status = VEInsStatusType.DESTROYED;

		return status;
		
	}
	
	public String toString() {
		
		return "The ve instance is " +
				"\n\tid: " + id +
				"\n\tusername: " + username +
				"\n\tveType: " + veType.getVEName() +
				"\n\tstorageId: " + storageId +
				"\n\tkserverId: " + kserverId +
				"\n\tfirstPort: " + firstPort +
				"\n\tnumPorts: " + numPorts +
				"\n\tfirstMac: " + firstMac +
				"\n\tnumMacs: " + numMacs +
				"\n\tstore: " + store +
				"\n\tactive: " + active +
				"\n\tstatus: " + status;
		
	}

}
