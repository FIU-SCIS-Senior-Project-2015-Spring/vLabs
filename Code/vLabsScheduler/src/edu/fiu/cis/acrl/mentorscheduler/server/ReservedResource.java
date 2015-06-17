package edu.fiu.cis.acrl.mentorscheduler.server;

import java.util.Calendar;

public class ReservedResource {

	private String courseId;
	private Calendar startTime;
	private Calendar endTime;
	private int quota;
	private boolean cancel;

	public ReservedResource(
			String courseId,
			Calendar startTime,
			Calendar endTime,
			int quota,
			boolean cancel) {
		
		this.courseId = courseId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.quota = quota;
		this.cancel = cancel;

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
	
	public void setQuota(int quota) {
		this.quota = quota;
	}
	public int getQuota() {
		return quota;
	}
	
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	public boolean isCancel() {
		return cancel;
	}

}
