package edu.fiu.cis.acrl.quotasystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;

import edu.fiu.cis.acrl.quotasystem.server.db.QuotaSystemDB;
import edu.fiu.cis.acrl.tools.debug.DebugTools;

public class UserAssignedQuota implements Comparable<UserAssignedQuota>, Serializable {

	// Debug level for this class
	private static int DEBUG_LEVEL = 3;
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Boolean active;

	private String purchaseId;

	private double quantity;

	private Timestamp startDate;

	private Timestamp updateTs;

	private List<UsedQuota> usedQuota;

	private CreditType creditType;

	private UserProfile userProfile;

	public UserAssignedQuota() {
		usedQuota = new ArrayList<UsedQuota>();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getUpdateTs() {
		return this.updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	public List<UsedQuota> getUsedQuotas() {
		return this.usedQuota;
	}

	public void setUsedQuotas(List<UsedQuota> usedQuota) {
		this.usedQuota = usedQuota;
	}

	public CreditType getCreditType() {
		return this.creditType;
	}

	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String toString(){
		return "Id: "+getId();
	}

	/* ---------------------------------------------------------------------------------------------------------------------
	 * 				POLICY RELATED FUNCTIONS
	 *---------------------------------------------------------------------------------------------------------------------
	*/

	public int getCurrentPeriodNumber() {

		int period = 1;// period number starts at 1

		Calendar today = Calendar.getInstance();
		Timestamp startDate = this.startDate;

		if (creditType.getPolicy().getAbsolute()) {
			startDate = creditType.getPolicy().getStartDate();
		}

		int daysInPeriod = creditType.getPolicy().getDaysInPeriod();
		int numberOfPeriods = creditType.getPolicy().getNumberOfPeriods();

		Calendar startDateCal = Calendar.getInstance();
		startDateCal.setTime(startDate);

		//Period is 0 when it has not started yet
		if(today.before(startDateCal)){
			return 0;
		}

		while (period <= numberOfPeriods) {
			startDateCal.add(startDateCal.DATE, daysInPeriod);
			if (today.before(startDateCal)) {
				return period;
			}
			period++;
		}

		// Period is -1 when it is not active anymore
		//period = -1;

		return period;

	}

	/* -------------------------------------------------------------------------------------------------------------------
	 * 		OVERALL POLICY FUNCTIONS
	 */
	public int getInitialQuota() {
		return (int) ( getQuotaInPeriod() * creditType.getPolicy().getNumberOfPeriods() * quantity);
	}

	public int getUsedQuotaTotal() {

		int totalUsedQuota = 0;

		for(edu.fiu.cis.acrl.quotasystem.entity.UsedQuota uq:usedQuota){
			if(!uq.getCancelled())
				totalUsedQuota += uq.getQuota();
		}

		return totalUsedQuota;
	}

	public int getRemainingQuota() {
		int remainingQuota = 0;

		for(int periodNo = 1 ; periodNo <= creditType.getPolicy().getNumberOfPeriods() ; periodNo++){
			remainingQuota += getAvailableQuotaInPeriod(periodNo);
		}

		return remainingQuota;
	}

	/* ------------------------------------------------------------------------------------------------------------------
	 * 		SPECIFIC PERIOD POLICY FUNCTIONS
	 */

	public int getUsedQuotaInPeriod(int periodNumber) {

		int totalUsedQuota = 0;
		//refreshethe used quota

		for(edu.fiu.cis.acrl.quotasystem.entity.UsedQuota uq:usedQuota){
			if (uq.getPeriodNumber() == periodNumber) {
				if(!uq.getCancelled())
					totalUsedQuota += uq.getQuota();
			}
		}
		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - getUseQuotaInPeriod ] period "+periodNumber+": "+totalUsedQuota);

		return totalUsedQuota;
	}

	public int getExpiredQuotaInPeriod(int periodNumber) {
		int totalExpiredQuota = 0;

		// /Check that the period requested is valid
		// If it is the current period the expired or if
		// period number is not within the number of periods of the policy
		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - UserAssignedQuota ]Current Period: "+getCurrentPeriodNumber());
		if (getCurrentPeriodNumber() > periodNumber && periodNumber <= creditType.getPolicy().getNumberOfPeriods()) {
			int minQuotaInPeriod = getMinQuotaInPeriod();
			int usedQuota = getUsedQuotaInPeriod(periodNumber);

			// Expired quota is the difference between the minimum quota
			// and the used quota in the same period
			DebugTools.println(DEBUG_LEVEL,"Minimum: "+minQuotaInPeriod+" Used: "+usedQuota);
			totalExpiredQuota = usedQuota > minQuotaInPeriod ? 0 : minQuotaInPeriod - usedQuota;
		}

		return totalExpiredQuota;
	}

	public int getToExpireQuotaInPeriod(int periodNumber){
		int minQuotaInPeriod = getMinQuotaInPeriod();
		int usedQuota = getUsedQuotaInPeriod(periodNumber);

		//maximum of (minimum to expire per period, (total remaining available quota - 
		//												(maximum allowable quota per period * the number of remaining future periods not including the current period)
		//			  								)
		//			 ) - Being Used
		//return Math.max( minQuotaInPeriod , getRemainingQuota() - (getQuotaInPeriod() * getRemainingPeriods()) );
		
		return usedQuota > minQuotaInPeriod ? 0 : minQuotaInPeriod - usedQuota;
	}

	public int getAvailableQuotaInPeriod(int periodNo){

		int availableQuota = 0;
		int usedQuota = 0;

		if(creditType.getPolicy().getPolicyType().equalsIgnoreCase("MINMAX")){
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - UAQ ] Period Policy was MINMAX");
			for(int i = 1 ; i <= creditType.getPolicy().getNumberOfPeriods() ; i++){
				if(i != periodNo)
					usedQuota += Math.max(getUsedQuotaInPeriod(i), getExpiredQuotaInPeriod(i));
			}
			int usedQuotaInPeriod = getUsedQuotaInPeriod(periodNo);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - UAQ ] Used quota for period: "+usedQuotaInPeriod);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - UAQ ] Used quota for all periods: "+(usedQuota+usedQuotaInPeriod));
			availableQuota = Math.min(getInitialQuota() - usedQuota - usedQuotaInPeriod, getMaxQuotaInPeriod() - usedQuotaInPeriod);
		}
		else{
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - UAQ ] Total quota in period: "+getQuotaInPeriod());
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - UAQ ] Used quota for period: "+getUsedQuotaInPeriod(periodNo));
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - UAQ ] Expired quota for period: "+getExpiredQuotaInPeriod(periodNo));
			availableQuota =  ( getQuotaInPeriod() - getUsedQuotaInPeriod(periodNo) - getExpiredQuotaInPeriod(periodNo) );
		}
		return availableQuota;
	}

	public int getMaxQuotaInPeriod(){
		return 	(int) Math.round(creditType.getPolicy().getMaximum() * quantity);
	}

	public int getMinQuotaInPeriod(){
		return 	(int) Math.round(creditType.getPolicy().getMinimum() * quantity);
	}

	public int getQuotaInPeriod(){
		return 	(int) Math.round(creditType.getPolicy().getQuotaInPeriod() * quantity);
	}

//----------------------------------------------------------------------------------------------------------------------

	public float getAvailableQuotaInCurrentPeriod() {
		return getAvailableQuotaInPeriod(getCurrentPeriodNumber());
	}

	public Timestamp getPolicyEndDate(){
		Timestamp startDateTs = this.startDate;
		Timestamp endDateTs =  new Timestamp(startDateTs.getTime());

		Policy policy = this.getCreditType().getPolicy();

		int noDaysToEnd = policy.getDaysInPeriod()*policy.getNumberOfPeriods();
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(startDateTs);
		endDate.add(Calendar.DAY_OF_MONTH, noDaysToEnd);
		endDateTs.setTime(endDate.getTimeInMillis());

		return endDateTs;
	}

	/*--------------------------------------------------------------------------------------------------------------------
	 * DATE RELATED POLICY FUNCTIONS
	 */
	public Timestamp getPolicyPeriodStartDate(int periodNumber){
		if(periodNumber == 1){
			return getStartDate();
		}
		return getPolicyPeriodEndDate(periodNumber - 1);
	}

	public Timestamp getPolicyPeriodEndDate(int periodNumber){
		Calendar endPeriodDate = Calendar.getInstance();

		Policy policy = this.getCreditType().getPolicy();

		if(policy.getPolicyType().equalsIgnoreCase("NOEXPIRATION"))
			endPeriodDate.setTime(new Timestamp(Long.MAX_VALUE));
		else{
			endPeriodDate.setTime(getStartDate());
			endPeriodDate.add(Calendar.DAY_OF_MONTH, policy.getDaysInPeriod() * periodNumber);
		}
		return new Timestamp(endPeriodDate.getTimeInMillis());
	}

	public ArrayList<Integer> getPolicyPeriodNumbersBetweenDates(long startTime, long endTime){

		DebugTools.println(DEBUG_LEVEL, "[Policy - getPeriodNumbersBetweenDates] Inside!");
		Policy policy = getCreditType().getPolicy();

		Calendar rangeStartDate = Calendar.getInstance();
		rangeStartDate.setTimeInMillis(startTime);

		Calendar rangeEndDate = Calendar.getInstance();
		rangeEndDate.setTimeInMillis(endTime);
		//DebugTools.println(DEBUG_LEVEL, "Dates received: start= "+rangeStartDate.getTime().toString()+", end= "+rangeEndDate.getTime().toString());

		ArrayList<Integer> periods = new ArrayList<Integer>();

		Calendar policyStartDate = Calendar.getInstance();
		policyStartDate.setTimeInMillis(getStartDate().getTime());

		Calendar policyEndDate = Calendar.getInstance();
		policyEndDate.setTimeInMillis(getPolicyEndDate().getTime());
		//DebugTools.println(DEBUG_LEVEL, "Policy Info: "+getId()+", days in period: "+creditType.getPolicy().getDaysInPeriod()+", number of periods: "+creditType.getPolicy().getNumberOfPeriods());
		//DebugTools.println(DEBUG_LEVEL, "Policy dates are start= "+policyStartDate.getTime().toString()+", end= "+policyEndDate.getTime().toString());

		if( !( policyStartDate.after(rangeEndDate) || policyEndDate.before(rangeStartDate))){
			int currentPeriod = 0;

			Calendar currentPeriodStartDate = policyStartDate;

			do{
				currentPeriodStartDate.add(Calendar.DAY_OF_MONTH, policy.getDaysInPeriod());
				currentPeriod++;
			}while(currentPeriodStartDate.before(rangeStartDate));

			periods.add(new Integer(currentPeriod));
			//DebugTools.println(DEBUG_LEVEL, "First Period inside range ["+currentPeriod+"]: start= "+getPolicyPeriodStartDate(currentPeriod).toString()+", end= "+getPolicyPeriodEndDate(currentPeriod).toString());

			while(currentPeriodStartDate.before(rangeEndDate)){
				currentPeriodStartDate.add(Calendar.DAY_OF_MONTH, policy.getDaysInPeriod());
				currentPeriod++;
				periods.add(new Integer(currentPeriod));
			}
		}
		//if(!periods.isEmpty())
			//DebugTools.println(DEBUG_LEVEL, "Days from requested start Date to end of period "+periods.get(0)+": "+(getDaysToEndOfPeriod(periods.get(0), startTime)));

		DebugTools.println(DEBUG_LEVEL, "[Policy - getPeriodNumbersBetweenDates] Finished returning "+periods.size()+" periods:"+periods);


		return periods;
	}

	public long getPolicyDaysToEndOfPeriod(int periodNumber, long date){
		double minsInDate = date / 60000;
		double policyStartDate = getStartDate().getTime() / 60000;
		Policy policy = getCreditType().getPolicy();
		double minsPerPeriod = policy.getDaysInPeriod() * 24 * 60;

		double endOfPeriodDate = policyStartDate + (periodNumber * minsPerPeriod);

		long result = Math.round( (endOfPeriodDate - minsInDate) / 24 / 60);
		return result;
	}

	/* ------------------------------------------------------------------------------------------------------------------------
	 *
	 * FUNCTIONS TO CALCULATE AVAILABLE, USED, AND EXPIRED / TO EXPIRE QUOTA (BASED ON PROFESSOR SADJADI'S SUGGESTIONS)
	 *
	 */

	public int getUsedQuotaPerPeriod(int periodNumber){
		int currentPeriod = getCurrentPeriodNumber();
		//the period has passed (already used)
		if(periodNumber < currentPeriod){
			return getUsedQuotaInPeriod(periodNumber);
		}
		//the period is the current period (being used)
		else if (periodNumber == currentPeriod){
			return getUsedQuotaInPeriod(periodNumber);
		}
		//the period is in the future (reserved quota)
		else{
			return getUsedQuotaInPeriod(periodNumber);
		}
	}

	public int getAvailableQuotaPerPeriod(int periodNumber){
		int currentPeriod = getCurrentPeriodNumber();
		//the period has passed ( unavailable)
		if(periodNumber < currentPeriod){
			return 0;
		}
		//the period is the current period
		else if (periodNumber == currentPeriod){
			return ( getTotalRemainingQuota() / getRemainingPeriods() ) - getUsedQuotaInPeriod(periodNumber) - getMinQuotaInPeriod(); //Math.max(getUsedQuotaInPeriod(periodNumber), getMinQuotaInPeriod());
		}
		//the period is in the future
		else{
			return ( getTotalRemainingQuota() / getRemainingPeriods() ) - getUsedQuotaInPeriod(periodNumber);
		}
	}

	public int getExpiredQuotaPerPeriod(int periodNumber){
		int currentPeriod = getCurrentPeriodNumber();
		int exp = Math.max(getMinQuotaInPeriod(), ( getTotalRemainingQuota() - ( getMaxQuotaInPeriod() * (getRemainingPeriods() - 1) ) ));
		int usedQuota = getUsedQuotaInPeriod(periodNumber);
		//the period has passed (expired)
		if(periodNumber < currentPeriod){
			return exp < usedQuota ? 0 : exp - usedQuota;
		}
		//the period is the current period (to expire)
		else if (periodNumber == currentPeriod){
			return exp < usedQuota ? 0 : exp - usedQuota;
		}
		//the period is in the future ( not expiring)
		else{
			return 0;
		}
	}

	public int getTotalRemainingQuota(){
		int currentPeriod = getCurrentPeriodNumber();
		int usedOrExpiredQuota = 0;
		for(int i = 1 ; i < currentPeriod ; i++){
			usedOrExpiredQuota += Math.max(getUsedQuotaInPeriod(i), getMinQuotaInPeriod());
		}

		return (getQuotaInPeriod() * creditType.getPolicy().getNumberOfPeriods()) - usedOrExpiredQuota;
	}

	public int getRemainingPeriods(){
		int currentPeriod = getCurrentPeriodNumber();
		int totalPeriods = creditType.getPolicy().getNumberOfPeriods();

		return (totalPeriods - currentPeriod + 1);
	}
	/*
	 * --------------------------------------------------------------------------------------------------------------------
	 */

	@Override
	public int compareTo(UserAssignedQuota o) {
		return this.id - o.getId();
	}

}