package edu.fiu.cis.acrl.mentorscheduler.server;

public class MentorCourse {

	private String mentorUsername;
	private String courseId;
	private boolean active;

	public MentorCourse(
			String mentorUsername,
			String courseId,
			boolean active) {
		
		this.mentorUsername = mentorUsername;
		this.courseId = courseId;
		this.active = active;
		
	}
	
	public void setMentorUsername(String mentorUsername) {
		this.mentorUsername = mentorUsername;
	}
	public String getMentorUsername() {
		return mentorUsername;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseId() {
		return courseId;
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
		"mentorUsername: " + mentorUsername + " " +
		"courseId: " + courseId;

	}
	
}
