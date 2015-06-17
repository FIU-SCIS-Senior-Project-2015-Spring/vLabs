package edu.fiu.cis.acrl.mentorscheduler.server;

import java.util.Calendar;

public class MentoringSchedule {
	
	private String id;
	private String mentorUsername;
	private String studentUsername;
	private String courseId;
	private Calendar startTime;
	private Calendar endTime;
	private boolean active;
	
	public MentoringSchedule(
			String id,
			String mentorUsername,
			String studentUsername,
			String courseId,
			Calendar startTime,
			Calendar endTime,
			boolean active) {
		
		this.id = id;
		this.mentorUsername = mentorUsername;
		this.studentUsername = studentUsername;
		this.courseId = courseId;
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
	
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}
	public String getStudentUsername() {
		return studentUsername;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseId() {
		return courseId;
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
		"studentUsername: " + studentUsername + " " +
		"courseId: " + courseId + " " +
		"startTime: " + startTime.getTime() + " " +
		"endTime: " + endTime.getTime() + " " +
		"active: " + active;
		
	}

}
