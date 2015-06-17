package edu.fiu.cis.acrl.vescheduler.server;

import java.util.Calendar;

import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VirtualEnvironmentType;

public class ReservedResource {

	private VirtualEnvironmentType veType;
	private Calendar startTime;
	private Calendar endTime;
	private int quota;
	private boolean cancel;

	public ReservedResource(
			VirtualEnvironmentType veType,
			Calendar startTime,
			Calendar endTime,
			int quota,
			boolean cancel) {
		
		this.setVeType(veType);
		this.startTime = startTime;
		this.endTime = endTime;
		this.quota = quota;
		this.cancel = cancel;

	}

	public void setVeType(VirtualEnvironmentType veType) {
		this.veType = veType;
	}
	public VirtualEnvironmentType getVeType() {
		return veType;
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
