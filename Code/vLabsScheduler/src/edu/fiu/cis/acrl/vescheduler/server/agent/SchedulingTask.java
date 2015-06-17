package edu.fiu.cis.acrl.vescheduler.server.agent;

import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VirtualEnvironmentType;


public class SchedulingTask {

	public enum TaskType { START, STOP };

	private TaskType type;
	private String veInsId;
	private String veInsSchId;
	private int hostId;
	private String username;
	private VirtualEnvironmentType veType;
	private int firstPort;
	private int numPorts;
	private int firstMac;
	private int numMacs;
	private int routerId;
	// This is the host that stores the vm files
	// TODO: This value will be equal to hostId, as we are still using dolphin and peer1
	private int storageHostId;
	// 0 = needs provisioning, assignment, and registration (First time anywhere)
	// 1 means that you only need to register (Has already been provisioned and assigned on another host)
	// 2 means that there is no need to register (Has already been provisioned and assigned on this host)
	// TODO: We are only using 0 and 2 as we are still using dolphin and peer1
	private int registerAction;

	public SchedulingTask(
			TaskType type,
			String veInsId,
			String veInsSchId,
			int hostId,
			String username,
			VirtualEnvironmentType veType,
			int firstPort,
			int numPorts,
			int firstMac,
			int numMacs,
			int routerId,
			int storageHostId,
			int registerAction) {

		this.type = type;
		this.veInsId = veInsId;
		this.veInsSchId = veInsSchId;
		this.hostId = hostId;
		this.username = username;
		this.veType = veType;
		this.firstPort = firstPort;
		this.numPorts = numPorts;
		this.firstMac = firstMac;
		this.numMacs = numMacs;
		this.routerId = routerId;
		this.storageHostId = storageHostId;
		this.registerAction = registerAction;

	}

	public String toString() {

		return(
				"Task: " + 
				type.toString() + " " + 
				veInsId + " " +
				veInsSchId + " " +
				hostId + " " + 
				username + " " + 
				veType + " " + 
				firstPort + " " + 
				numPorts + " " + 
				firstMac + " " + 
				numMacs + " " + 
				routerId + " " +
				storageHostId + " " + 
				registerAction);
	
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public VirtualEnvironmentType getVeType() {
		return veType;
	}

	public void setVeType(VirtualEnvironmentType veType) {
		this.veType = veType;
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

	public void setFirstMac(int firstMac) {
		this.firstMac = firstMac;
	}

	public int getFirstMac() {
		return firstMac;
	}

	public void setNumMacs(int numMacs) {
		this.numMacs = numMacs;
	}

	public int getNumMacs() {
		return numMacs;
	}

	public void setRouterId(int routerId) {
		this.routerId = routerId;
	}

	public int getRouterId() {
		return routerId;
	}

	public void setVeInsId(String veInsId) {
		this.veInsId = veInsId;
	}

	public String getVeInsId() {
		return veInsId;
	}

	public void setVeInsSchId(String veInsSchId) {
		this.veInsSchId = veInsSchId;
	}

	public String getVeInsSchId() {
		return veInsSchId;
	}

	public void setStorageHostId(int storageHostId) {
		this.storageHostId = storageHostId;
	}

	public int getStorageHostId() {
		return storageHostId;
	}

	public void setRegisterAction(int registerAction) {
		this.registerAction = registerAction;
	}

	public int getRegisterAction() {
		return registerAction;
	}

}
