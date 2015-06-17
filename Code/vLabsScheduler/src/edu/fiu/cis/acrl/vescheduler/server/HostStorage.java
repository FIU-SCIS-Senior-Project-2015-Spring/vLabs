package edu.fiu.cis.acrl.vescheduler.server;

public class HostStorage {

	private int hostId;
	private int storageId;
	private int preference;
	private boolean active;
	
	public HostStorage(
			int hostId,
			int storageId,
			int preference,
			boolean active) {
		
		this.hostId = hostId;
		this.storageId = storageId;
		this.preference = preference;
		this.active = active;
		
	}
	
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getHostId() {
		return hostId;
	}
	
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public int getStorageId() {
		return storageId;
	}
	
	public void setPreference(int preference) {
		this.preference = preference;
	}
	public int getPreference() {
		return preference;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	
	public edu.fiu.cis.acrl.vescheduler.ws.HostStorage getConvertedHostStorage() {
		
		edu.fiu.cis.acrl.vescheduler.ws.HostStorage convertedHostStorage = 
			new edu.fiu.cis.acrl.vescheduler.ws.HostStorage();
		
		convertedHostStorage.setHostId(hostId);
		convertedHostStorage.setStorageId(storageId);
		convertedHostStorage.setPreference(preference);
		convertedHostStorage.setActive(active);
		
		return convertedHostStorage;

	}

	public static HostStorage getHostStorage(edu.fiu.cis.acrl.vescheduler.ws.HostStorage convertedHostStorage) {

		HostStorage hostStorage = new HostStorage(
				convertedHostStorage.getHostId(),
				convertedHostStorage.getStorageId(),
				convertedHostStorage.getPreference(),
				convertedHostStorage.getActive()
				);
		
		return hostStorage;

	}

}
