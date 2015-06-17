package edu.fiu.cis.acrl.vescheduler.server;

public class Storage {

	private int id;
	private String dirPath;
	private int gbSize;
	private boolean active;
	
	public Storage(
			int id,
			String dirPath,
			int gbSize,
			boolean active){
		
		this.id = id;
		this.dirPath = dirPath;
		this.gbSize = gbSize;
		this.active = active;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
	public String getDirPath() {
		return dirPath;
	}
	
	public void setGbSize(int gbSize) {
		this.gbSize = gbSize;
	}
	public int getGbSize() {
		return gbSize;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	
	public edu.fiu.cis.acrl.vescheduler.ws.Storage getConvertedStorage() {
		
		edu.fiu.cis.acrl.vescheduler.ws.Storage convertedStorage = 
			new edu.fiu.cis.acrl.vescheduler.ws.Storage();
		
		convertedStorage.setId(id);
		convertedStorage.setDirPath(dirPath);
		convertedStorage.setGbSize(gbSize);
		convertedStorage.setActive(active);
		
		return convertedStorage;

	}

	public static Storage getStorage(edu.fiu.cis.acrl.vescheduler.ws.Storage convertedStorage) {

		Storage storage = new Storage(
				convertedStorage.getId(),
				convertedStorage.getDirPath(),
				convertedStorage.getGbSize(),
				convertedStorage.getActive()
				);
		
		return storage;

	}

}
