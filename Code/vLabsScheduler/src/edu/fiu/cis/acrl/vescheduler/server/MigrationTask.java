package edu.fiu.cis.acrl.vescheduler.server;

public class MigrationTask {

	private int hostId;
	private String username;
	private String veTypeName;
	private int firstPort;
	private int sourceStorageId;
	private int targetStorateId;

	public MigrationTask(
			int hostId,
			String username,
			String veTypeName,
			int firstPort,
			int sourceStorageId,
			int targetStorageId) {
		this.hostId = hostId;
		this.username = username;
		this.veTypeName = veTypeName;
		this.firstPort = firstPort;
		this.sourceStorageId = sourceStorageId;
		this.targetStorateId = targetStorageId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getHostId() {
		return hostId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setVeTypeName(String veTypeName) {
		this.veTypeName = veTypeName;
	}
	public String getVeTypeName() {
		return veTypeName;
	}
	
	public void setFirstPort(int firstPort) {
		this.firstPort = firstPort;
	}
	public int getFirstPort() {
		return firstPort;
	}
	
	public void setSourceStorageId(int sourceStorageId) {
		this.sourceStorageId = sourceStorageId;
	}
	public int getSourceStorageId() {
		return sourceStorageId;
	}
	
	public void setTargetStorateId(int targetStorateId) {
		this.targetStorateId = targetStorateId;
	}
	public int getTargetStorateId() {
		return targetStorateId;
	}
}
