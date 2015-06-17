package edu.fiu.cis.acrl.vescheduler.server;

import java.util.Calendar;

public class KServerMaintenanceSchedule {

	private String id; 
	private int kserverId;
	private Calendar startTime;
	private Calendar endTime;
	private boolean active;
	
	public KServerMaintenanceSchedule(String id, int kserverId, Calendar startTime, 
			Calendar endTime, boolean active) {
	
		this.id = id;
		this.kserverId = kserverId;
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
			
	public void setKServerId(int kserverId) {
		this.kserverId = kserverId;
	}
	public int getKServerId() {
		return kserverId;
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
