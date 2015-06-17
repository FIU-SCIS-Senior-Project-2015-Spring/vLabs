package edu.fiu.cis.acrl.mentorscheduler.server;

import java.util.Calendar;

public class MentorUnallocatedWorktimeSchedule {

	private String id;
	private String mentorUsername;
	private Calendar startTime;
	private Calendar endTime;
	private boolean active;
	
	public MentorUnallocatedWorktimeSchedule(
			String id,
			String mentorUsername,
			Calendar startTime,
			Calendar endTime,
			boolean active) {
		
		this.id = id;
		this.mentorUsername = mentorUsername;
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
	
	public void setMentorUsername(String mentorUsername) {
		this.mentorUsername = mentorUsername;
	}
	public String getMentorUsername() {
		return mentorUsername;
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

	public String toString() {
		
		return 
			"id: " + id + " " +
			"mentorUsername: " + mentorUsername + " " +
			"startTime: " + startTime.getTime() + " " +
			"endTime: " + endTime.getTime() + " " +
			"active: " + active;

	}
	
}
