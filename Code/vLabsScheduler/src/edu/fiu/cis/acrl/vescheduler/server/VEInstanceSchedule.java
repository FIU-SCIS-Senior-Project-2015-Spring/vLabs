package edu.fiu.cis.acrl.vescheduler.server;

import java.util.Calendar;

public class VEInstanceSchedule {

	private String id;
	private String veInsId;
	private int hostId;
	private Calendar startTime;
	private Calendar endTime;
	private boolean done;
	private boolean active;
	
	public VEInstanceSchedule(
			String id, 
			String veInsId, 
			int hostId,
			Calendar startTime, 
			Calendar endTime, 
			boolean done,
			boolean active) {
		
		this.id = id;
		this.veInsId = veInsId;
		this.hostId = hostId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.done = done;
		this.active = active;
		
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void setVeInsId(String veInsId) {
		this.veInsId = veInsId;
	}

	public String getVeInsId() {
		return veInsId;
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

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean isDone() {
		return done;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public int getHostId() {
		return hostId;
	}

}
