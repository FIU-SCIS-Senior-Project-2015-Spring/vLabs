package edu.fiu.cis.acrl.vescheduler.server;

import java.util.Calendar;

public class HostMaintenanceSchedule {

	private String id; 
	private int hostId;
	private Calendar startTime;
	private Calendar endTime;
	private boolean active;
	
	public HostMaintenanceSchedule(String id, int hostId, Calendar startTime, 
			Calendar endTime, boolean active) {
	
		this.id = id;
		this.hostId = hostId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.active = active;
		
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
			
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getHostId() {
		return hostId;
	}
	
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	public Calendar getEndTime() {
		return endTime;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}

	}
