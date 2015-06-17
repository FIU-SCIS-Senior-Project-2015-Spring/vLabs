package edu.fiu.cis.acrl.quotasystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;



public class UsedQuota implements Serializable{
	private static final long serialVersionUID = 1L;


	private Integer id;

	private String appointmentId;

	private String affiliationId;

	private Boolean cancelled;

	private Integer periodNumber;

	private int quota;

	private Timestamp startTime;

	private Timestamp endTime;

	private Timestamp updateTs;


	private UserAssignedQuota userAssignedQuota;

    public UsedQuota() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAffiliationId() {
		return affiliationId;
	}

	public void setAffiliationId(String affiliationId) {
		this.affiliationId = affiliationId;
	}

	public Boolean getCancelled() {
		return this.cancelled;
	}

	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Integer getPeriodNumber() {
		return this.periodNumber;
	}

	public void setPeriodNumber(Integer periodNumber) {
		this.periodNumber = periodNumber;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public Timestamp getUpdateTs() {
		return this.updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	public UserAssignedQuota getUserAssignedQuota() {
		return this.userAssignedQuota;
	}

	public void setUserAssignedQuota(UserAssignedQuota userAssignedQuota) {
		this.userAssignedQuota = userAssignedQuota;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}



}