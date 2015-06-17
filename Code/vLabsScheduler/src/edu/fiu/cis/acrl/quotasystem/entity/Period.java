package edu.fiu.cis.acrl.quotasystem.entity;

import java.sql.Timestamp;

import edu.fiu.cis.acrl.tools.debug.DebugTools;

public class Period implements Comparable<Period>{

	// Debug level for this class
	private static int DEBUG_LEVEL = 4;
	
	private int periodNumber;
	private int quotaInPeriod;
	private int currentQuota;
	private UserAssignedQuota userAssignedQuota;
	private Timestamp startTime;
	private Timestamp endTime;


	public Period(int pn, UserAssignedQuota uaq){
		periodNumber = pn;
		userAssignedQuota = uaq;
		quotaInPeriod = uaq.getAvailableQuotaInPeriod(periodNumber);
		currentQuota = quotaInPeriod;
		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Period ] Created new Period with quota: "+currentQuota);
	}

	public int getPeriodNumber(){
		return periodNumber;
	}

	public UserAssignedQuota getUserAssignedQuota(){
		return userAssignedQuota;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(long start) {
		startTime = new Timestamp(start);
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(long end) {
		endTime = new Timestamp(end);
	}

	public int getCurrentQuota() {
		return currentQuota;
	}

	public void setCurrentQuota(int currentQuota) {
		this.currentQuota = currentQuota;
	}

	public double getQuotaInPeriod() {
		return quotaInPeriod;
	}

	public void setQuotaInPeriod(int quotaInPeriod) {
		this.quotaInPeriod = quotaInPeriod;
	}

	/**
	 * Function used to sort the Periods.
	 * The periods are sorted by 3 criteria with different priorities:
	 * 1. the one to the closest end date goes first
	 * 2. the one with less quota available goes first
	 * 3. the one with higher minimum quota goes first
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Period o) {
		long endDate1 = userAssignedQuota.getPolicyPeriodEndDate(periodNumber).getTime();
		long endDate2 = o.getUserAssignedQuota().getPolicyPeriodEndDate(o.getPeriodNumber()).getTime();

		long startDate1 = userAssignedQuota.getPolicyPeriodStartDate(periodNumber).getTime();
		long startDate2 = userAssignedQuota.getPolicyPeriodStartDate(o.getPeriodNumber()).getTime();

		double minQuota1 = userAssignedQuota.getMinQuotaInPeriod();
		double minQuota2 = o.userAssignedQuota.getMinQuotaInPeriod();

		if(endDate1 == endDate2){
			if(startDate1 == startDate2){
				if(minQuota1 == minQuota2)
					return 0;
				else if(minQuota1 < minQuota2)
					return 1;
				else
					return -1;
			}
			else if(startDate1 < startDate2)
				return 1;
			else
				return -1;
		}
		else if(endDate1 > endDate2)
			return 1;
		else
			return -1;
	}

	public String toString(){
		return "UAQ_ID: "+userAssignedQuota.getId()+" , PERIOD_NO: "+periodNumber+" , USED_QUOTA: "+
		(quotaInPeriod-currentQuota)+" , START_TIME: "+startTime.toString()+" , END_TIME: "+endTime.toString();
	}
}
