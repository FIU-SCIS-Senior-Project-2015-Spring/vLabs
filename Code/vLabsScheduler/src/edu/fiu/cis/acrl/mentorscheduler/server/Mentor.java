package edu.fiu.cis.acrl.mentorscheduler.server;


public class Mentor {

	private String username;
	private boolean active;
	
	public Mentor(
			String username,
			boolean active) {
		
		this.username = username;
		this.active = active;
		
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	
	public String toString() {
		
		return 
			"Active: " + active + " " +
			"username: " + username;
		
	}

}
