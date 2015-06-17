package edu.fiu.cis.acrl.vescheduler.server;

import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;

public class Host {

	private int id;
	private String name;
	private int sshPort;
	private String username;
	private String password;
	private int veNumCap;
	private int veFirstFreePort;
	private int vePortNum;
	private boolean active;
	private boolean newAssignment;
	
	public Host(int id,	String name, int sshPort, String username, String password,
			int veNumCap, int veFirstFreePort, int vePortNum, boolean active, 
			boolean newAssignment) {
		
		this.id = id;
		this.name = name;
		this.sshPort = sshPort;
		this.username = username;
		this.password = password;
		this.veNumCap = veNumCap;
		this.veFirstFreePort = veFirstFreePort;
		this.vePortNum = vePortNum;
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
	
	public void setSshPort(int sshPort) {
		this.sshPort = sshPort;
	}
	public int getSshPort() {
		return sshPort;
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
	
	public void setVeNumCap(int veNumCap) {
		this.veNumCap = veNumCap;
	}
	public int getVeNumCap() {
		return veNumCap;
	}
	
	public void setVeFirstFreePort(int veFirstFreePort) {
		this.veFirstFreePort = veFirstFreePort;
	}
	public int getVeFirstFreePort() {
		return veFirstFreePort;
	}
	
	public void setVePortNum(int vePortNum) {
		this.vePortNum = vePortNum;
	}
	public int getVePortNum() {
		return vePortNum;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}

	public void setNewAssignment(boolean newAssignment) {
		this.newAssignment = newAssignment;
	}
	public boolean isNewAssignment() {
		return newAssignment;
	}

	public edu.fiu.cis.acrl.vescheduler.ws.Host getConvertedHost() {
		
		edu.fiu.cis.acrl.vescheduler.ws.Host convertedHost = 
			new edu.fiu.cis.acrl.vescheduler.ws.Host();
		
		convertedHost.setId(id);
		convertedHost.setName(name);
		convertedHost.setSshPort(sshPort);
		convertedHost.setUsername(username);
		convertedHost.setPassword(password);
		convertedHost.setVeNumCap(veNumCap);
		convertedHost.setVeFirstFreePort(veFirstFreePort);
		convertedHost.setVePortNum(vePortNum);
		convertedHost.setActive(active);
		convertedHost.setNewAssignment(newAssignment);
		
		return convertedHost;

	}

	public static Host getHost(edu.fiu.cis.acrl.vescheduler.ws.Host convertedHost) {

		Host host = new Host(
				convertedHost.getId(),
				convertedHost.getName(),
				convertedHost.getSshPort(),
				convertedHost.getUsername(),
				convertedHost.getPassword(),
				convertedHost.getVeNumCap(),
				convertedHost.getVeFirstFreePort(),
				convertedHost.getVePortNum(),
				convertedHost.getActive(),
				convertedHost.getNewAssignment()
				);
		
		return host;

	}
	
    public boolean equals(Object obj) {
       if (!(obj instanceof Host))
            return false;
       
       Host objHost = (Host)obj;
       if (objHost.getName().equals(this.name))
            return true;
       else
    	   return false;
    }

}
