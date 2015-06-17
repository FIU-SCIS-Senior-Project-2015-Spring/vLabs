package edu.fiu.cis.acrl.vescheduler.server;

public class KServer {

	private int id;
	private String name;
	private int httpPort;
	private String username;
	private String password;
	private int totalCap;
	private int activeCap;
	private boolean active;
	private boolean newAssignment;

	public KServer(int id,	String name, int httpPort, String username, String password,
			int totalCap, int activeCap, boolean active, boolean newAssignment) {
		
		this.id = id;
		this.name = name;
		this.httpPort = httpPort;
		this.username = username;
		this.password = password;
		this.totalCap = totalCap;
		this.activeCap = activeCap;
		this.active = active;
		this.newAssignment = newAssignment;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setHttpPort(int httpPort) {
		this.httpPort = httpPort;
	}
	public int getHttpPort() {
		return httpPort;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setTotalCap(int totalCap) {
		this.totalCap = totalCap;
	}
	public int getTotalCap() {
		return totalCap;
	}
	
	public void setActiveCap(int activeCap) {
		this.activeCap = activeCap;
	}
	public int getActiveCap() {
		return activeCap;
	}
	
	public void setNewAssignment(boolean newAssignment) {
		this.newAssignment = newAssignment;
	}
	public boolean isNewAssignment() {
		return newAssignment;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}

	public edu.fiu.cis.acrl.vescheduler.ws.KServer getConvertedKServer() {
		
		edu.fiu.cis.acrl.vescheduler.ws.KServer convertedKServer = 
			new edu.fiu.cis.acrl.vescheduler.ws.KServer();
		
		convertedKServer.setId(id);
		convertedKServer.setName(name);
		convertedKServer.setHttpPort(httpPort);
		convertedKServer.setUsername(username);
		convertedKServer.setPassword(password);
		convertedKServer.setTotalCap(totalCap);
		convertedKServer.setActiveCap(activeCap);
		convertedKServer.setActive(active);
		convertedKServer.setNewAssignment(newAssignment);
		
		return convertedKServer;

	}

	public static KServer getKServer(edu.fiu.cis.acrl.vescheduler.ws.KServer convertedKServer) {

		KServer kserver = new KServer(
				convertedKServer.getId(),
				convertedKServer.getName(),
				convertedKServer.getHttpPort(),
				convertedKServer.getUsername(),
				convertedKServer.getPassword(),
				convertedKServer.getTotalCap(),
				convertedKServer.getActiveCap(),
				convertedKServer.getActive(),
				convertedKServer.getNewAssignment()
				);
		
		return kserver;

	}

}
