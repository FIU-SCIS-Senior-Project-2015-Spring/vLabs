package edu.fiu.cis.acrl.vescheduler.server;

import java.util.Calendar;

public class Configuration {

	private int id;
	private Calendar userStartTime;
	private Calendar userEndTime;
	private Calendar adminStartTime;
	private Calendar adminEndTime;
	private boolean active;
	
	public Configuration(int id, 
			Calendar userStartTime, 
			Calendar userEndTime, 
			Calendar adminStartTime, 
			Calendar adminEndTime, 
			boolean active) {
		
		this.id = id;
		this.userStartTime = userStartTime;
		this.userEndTime = userEndTime;
		this.adminStartTime = adminStartTime;
		this.adminEndTime = adminEndTime;
		this.active = active;
		
	}
	
	public Configuration(
			Calendar userStartTime, 
			Calendar userEndTime,
			Calendar adminStartTime, 
			Calendar adminEndTime) { 
		
		this.id = 0;
		this.userStartTime = userStartTime;
		this.userEndTime = userEndTime;
		this.adminStartTime = adminStartTime;
		this.adminEndTime = adminEndTime;
		this.active = true;
		
	}
	
	public Configuration(
			Calendar startTime, 
			Calendar endTime) {
		
		this.id = 0;
		this.userStartTime = startTime;
		this.userEndTime = endTime;
		this.adminStartTime = startTime;
		this.adminEndTime = endTime;
		this.active = true;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setUserStartTime(Calendar userStartTime) {
		this.userStartTime = userStartTime;
	}
	
	public Calendar getUserStartTime() {
		return userStartTime;
	}
	
	public void setUserEndTime(Calendar userEndTime) {
		this.userEndTime = userEndTime;
	}
	
	public Calendar getUserEndTime() {
		return userEndTime;
	}
	
	public void setAdminStartTime(Calendar adminStartTime) {
		this.adminStartTime = adminStartTime;
	}

	public Calendar getAdminStartTime() {
		return adminStartTime;
	}

	public void setAdminEndTime(Calendar adminEndTime) {
		this.adminEndTime = adminEndTime;
	}

	public Calendar getAdminEndTime() {
		return adminEndTime;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

}
