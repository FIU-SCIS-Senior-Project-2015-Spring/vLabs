package edu.fiu.cis.acrl.quotasystem.server;

import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import edu.fiu.cis.acrl.quotasystem.entity.Period;
import edu.fiu.cis.acrl.quotasystem.entity.ResourceReservation;
import edu.fiu.cis.acrl.quotasystem.entity.UsedQuota;
import edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota;
import edu.fiu.cis.acrl.quotasystem.server.db.QuotaSystemDB;
import edu.fiu.cis.acrl.quotasystem.server.translators.CourseTranslator;
import edu.fiu.cis.acrl.quotasystem.server.translators.CreditTypeTranslator;
import edu.fiu.cis.acrl.quotasystem.server.translators.PolicyTranslator;
import edu.fiu.cis.acrl.quotasystem.server.translators.QuotaAssignmentTranslator;
import edu.fiu.cis.acrl.quotasystem.server.translators.UserTranslator;
import edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse;
import edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse;
import edu.fiu.cis.acrl.quotasystem.ws.Appointment;
import edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest;
import edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse;
import edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse;
import edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse;
import edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest;
import edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse;
import edu.fiu.cis.acrl.quotasystem.ws.Course;
import edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.CreditType;
import edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault;
import edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse;
import edu.fiu.cis.acrl.quotasystem.ws.Enrollment;
import edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest;
import edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest;
import edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest;
import edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest;
import edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest;
import edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse;
import edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse;
import edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault;
import edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse;
import edu.fiu.cis.acrl.quotasystem.ws.Policy;
import edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.PolicyType;
import edu.fiu.cis.acrl.quotasystem.ws.QuotaAssignment;
import edu.fiu.cis.acrl.quotasystem.ws.QuotaSummary;
import edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse;
import edu.fiu.cis.acrl.quotasystem.ws.User;
import edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault;
import edu.fiu.cis.acrl.tools.debug.DebugTools;
import edu.fiu.cis.acrl.tools.timezone.TimeZoneTools;

public class QuotaSystem {

	// Debug level for this class
	private static int DEBUG_LEVEL = 1;
	
	/**
	 * A handle to the unique Singleton instance.
	 */
	static private QuotaSystem _instance = null;

	/**
	 * @return The unique instance of this class.
	 */
	static public QuotaSystem instance() {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - instance] Inside!");

		if (null == _instance) {
			_instance = new QuotaSystem();
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - instance] Ready to get out!");

		return _instance;

	}

	private QuotaSystemDB quotasystemDB;

	private QuotaSystemSettings settings;

	private ResourceReservation resourceReservation;

	/**
	 * Constructor is protected
	 *
	 */
	protected QuotaSystem() {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Constructor] Inside!");

		this.quotasystemDB = new QuotaSystemDB();

		settings = QuotaSystemSettings.instance();

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem] Settings!" + settings);

		quotasystemDB.connect(
				settings.getDbUser(),
				settings.getDbPassword(),
				settings.getDbHost(),
				settings.getDbName());

		try {
			resourceReservation = new ResourceReservation(settings.getVirtualLabsEPR());

		} catch (Exception e) {
			e.printStackTrace();
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Constructor] Ready to get out!");

	}

	// Static Variables
	// Do not change the order of this variables, in case you add or remove you
	// need to make the proper changes on the addQuota and removeQuota methods

	public static String[] POLICIES = { "FIXED", "GRADUAL", "MINMAX","NOEXPIRATION" };

	public edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse scheduleAppointments(
			edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest scheduleAppointmentsRequest) {

		ScheduleAppointmentsResponse response = new ScheduleAppointmentsResponse();

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] scheduleAppointments inside!");
		Appointment[] appointments = scheduleAppointmentsRequest.getAppointment();

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] appointments requested: ");
		for(int i = 0; i < appointments.length ; i++){
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] "+
					i+" appointment "+appointments[i].getId()+": "+appointments[i].getAvailabilityStatus() +
					"\n\t affiliationId: " + appointments[i].getAffiliationId() +
					"\n\t course: " + appointments[i].getCourse() +
					"\n\t startTime: " + appointments[i].getStartTime().getTime() +
					"\n\t endTime: " + appointments[i].getEndTime().getTime() +
					"\n\t resource: " + appointments[i].getResource());
		}

		ArrayList<Appointment> resultingAppointments = new ArrayList<Appointment>();

		//validate the request
		if(appointments == null){
			response.setAppointment(new Appointment[] {});
			return response;
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] processing a list of "+appointments.length+" appointments");
		for(Appointment app : appointments){

			//obtain user scheduling the appointment
			String username = app.getUsername();
			edu.fiu.cis.acrl.quotasystem.entity.UserProfile user = quotasystemDB.getUserByUsername(username);
			if(user == null){
				app.setAvailabilityStatus("UNAVAILABLE");
				continue;
			}else{
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] user: "+user.toString());
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] startdate: "+ app.getStartTime().getTime().toString());
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] enddate: "+ app.getEndTime().getTime().toString());
				/*TimeZone timeZone = resourceReservation.getUserTimeZoneId(user);
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] new timezone: "+timeZone.toString());
				app.setStartTime(TimeZoneTools.changeTimeZone(app.getStartTime(), timeZone));
				app.setEndTime(TimeZoneTools.changeTimeZone(app.getEndTime(), timeZone));*/
			}

			//obtain the data from the appointment
			String affiliationId = app.getAffiliationId();
			String appointmentId = app.getId();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] " +
					"\n\t app.getStartTime().getTime(): " + app.getStartTime().getTime() +
					"\n\t app.getEndTime().getTime(): " + app.getEndTime().getTime() );
			
			
			long startTime = app.getStartTime().getTimeInMillis();
			long endTime = app.getEndTime().getTimeInMillis();

			//DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] startdate with new timezone"+ app.getStartTime().getTime().toString());
			//DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] enddate with new timezone"+ app.getEndTime().getTime().toString());

			String courseName = app.getCourse();
			String resource = app.getResource();

			long startTimeInMins = startTime / 60000;
			long endTimeInMins = endTime / 60000;

			edu.fiu.cis.acrl.quotasystem.entity.Course course = quotasystemDB.getCourseByFullName(courseName);

			if(course == null){
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] Course does not exist");
				app.setAvailabilityStatus("UNAVAILABLE");
				continue;
			}
			List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypesList = quotasystemDB.getCreditTypesByCourseAndResource(course.getId(), resource);
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypeIterator = creditTypesList.iterator();

			if(creditTypesList.isEmpty()){
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] No Credit Types exist");
				app.setAvailabilityStatus("UNAVAILABLE");
				continue;
			}

			//get all the user assigned quota for that course, user, and resource.
			ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> userAssignedQuotaList = new ArrayList<UserAssignedQuota>();
			while(creditTypeIterator.hasNext()){
				List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> temp = quotasystemDB.getUserAssignedQuota(creditTypeIterator.next().getId(), user.getId());
				Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> itr = temp.iterator();
				while(itr.hasNext())
					userAssignedQuotaList.add(itr.next());
			}

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Checking if the obtained UserAssignedQuota can satisfy the range requested.");

			//the arraylist that will contain the periods used for this appointment
			ArrayList<Period> quotaPeriods = new ArrayList<Period>();
			//Have an arraylist for all the periods that are actually used to schedule the appointment
			ArrayList<Period> usedPeriods = new ArrayList<Period>();

			//check if the user assigned quota obtained covers the requested range
			if( ! requestRangeCovered(userAssignedQuotaList, startTime, endTime)){
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Couldn't satisfy the request with the available UserAssignedQuota");
				app.setAvailabilityStatus("UNAVAILABLE");
			}
			else{
				//get all the periods inside the range for all the userAssignedQuota obtained
				for( edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota userAssignedQuota : userAssignedQuotaList){
					ArrayList<Integer> periods = userAssignedQuota.getPolicyPeriodNumbersBetweenDates(startTime, endTime);
					for( Integer periodNumber : periods){
						Period p = new Period(periodNumber,userAssignedQuota);
						quotaPeriods.add(p);
					}
				}

				//sort the periods obtained
				quotaPeriods = sortUserAssignedQuotaList(quotaPeriods);

				long leftLimit = startTimeInMins;
				long goal = endTimeInMins;

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Starting algorithm with: leftLimit = "+leftLimit+", goal = "+goal);

				//swipe trough the periods arraylist from left to right (filling holes) to use quota as efficiently as possible (GREEDY)
				for(int i = 0 ; i < quotaPeriods.size() ; i++){

					Period p = quotaPeriods.get(i);

					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Available quota on period "+p.getPeriodNumber()+": "+p.getCurrentQuota());

					if(p.getCurrentQuota() == 0)
						continue;
					//DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - isQuotaAvailable] INFO: UAQ = "+p.getUserAssignedQuota().getId()+", PERIOD = "+p.getPeriodNumber()+", AVAILABLE = "+p.getQuotaAvailable()+", START = "+p.getUserAssignedQuota().getCreditType().getPolicy().getPeriodStartDate(p.getPeriodNumber()).toString()+", END = "+p.getUserAssignedQuota().getCreditType().getPolicy().getPeriodEndDate(p.getPeriodNumber()).toString());

					long pStartTimeInMins = p.getUserAssignedQuota().getPolicyPeriodStartDate(p.getPeriodNumber()).getTime() / 60000;
					long pEndTimeInMins = p.getUserAssignedQuota().getPolicyPeriodEndDate(p.getPeriodNumber()).getTime() / 60000;


					//there is a hole before me :(
					if (pStartTimeInMins > leftLimit){
						//***** stuff added for display pursposes
						Timestamp ts1 = new Timestamp(leftLimit * 60000);
						Timestamp ts2 = new Timestamp(pStartTimeInMins * 60000);
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Hole found from : "+ts1.toString()+" to : "+ts2.toString());
						//attempt to fill the hole!
						for(int j = i ; j < quotaPeriods.size() ; j++){

							Period p2 = quotaPeriods.get(j);

							long p2StartTimeInMins = p2.getUserAssignedQuota().getPolicyPeriodStartDate(p2.getPeriodNumber()).getTime() / 60000;
							long p2EndTimeInMins = p2.getUserAssignedQuota().getPolicyPeriodEndDate(p2.getPeriodNumber()).getTime() / 60000;
							//get the next Period with a different userAssignedQuota
							if(p.getUserAssignedQuota().compareTo(p2.getUserAssignedQuota()) != 0){
								//check if i can help fill this hole
								if(p2StartTimeInMins <= leftLimit && p2EndTimeInMins > leftLimit){
									//check if we don't have enough quota to reach the end of this period
									if(leftLimit + p2.getCurrentQuota() < p2EndTimeInMins){
										//if we dont have enough quota to fill the hole
										if(leftLimit + p2.getCurrentQuota() < pStartTimeInMins){
											//fill whatever we can from the hole and keep going
											Period temp = new Period(p2.getPeriodNumber(),p2.getUserAssignedQuota());
											temp.setStartTime(leftLimit * 60000);
											temp.setEndTime((leftLimit + p2.getCurrentQuota()) * 60000);
											leftLimit += p2.getCurrentQuota();
											p2.setCurrentQuota(0);
											temp.setCurrentQuota(p2.getCurrentQuota());
											usedPeriods.add(temp);
										}
										//else, if we do
										else{
											//fill the entire hole and remove the quota
											Period temp = new Period(p2.getPeriodNumber(),p2.getUserAssignedQuota());
											temp.setStartTime(leftLimit * 60000);
											temp.setEndTime(pStartTimeInMins * 60000);
											p2.setCurrentQuota(Math.round(p2.getCurrentQuota() - (pStartTimeInMins - leftLimit)));
											leftLimit = pStartTimeInMins;
											temp.setCurrentQuota(p2.getCurrentQuota());
											usedPeriods.add(temp);
											break;
										}
									}
									//we have enough quota to reach or pass the end of this period,
									//but we can only use quota until the end of the period
									else{
										//if we can fill the hole before the end of the period
										if(p2EndTimeInMins >= pStartTimeInMins){
											Period temp = new Period(p2.getPeriodNumber(),p2.getUserAssignedQuota());
											temp.setStartTime(leftLimit * 60000);
											temp.setEndTime(pStartTimeInMins * 60000);
											p2.setCurrentQuota(Math.round(p2.getCurrentQuota() - (pStartTimeInMins - leftLimit)));
											leftLimit = pStartTimeInMins;
											temp.setCurrentQuota(p2.getCurrentQuota());
											usedPeriods.add(temp);
											DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Using "+(pStartTimeInMins - leftLimit)+" quota from period "+p.getPeriodNumber()+" of UserAssignedQuota "+p.getUserAssignedQuota().getId()+", hole filled!");
											break;
										}
										//if we can't fill the hole before the end of the period
										else{
											DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Using "+(p2EndTimeInMins - leftLimit)+" quota from period "+p.getPeriodNumber()+" of UserAssignedQuota "+p.getUserAssignedQuota().getId());
											Period temp = new Period(p2.getPeriodNumber(),p2.getUserAssignedQuota());
											temp.setStartTime(leftLimit * 60000);
											temp.setEndTime(p2EndTimeInMins * 60000);
											p2.setCurrentQuota(Math.round(p2.getCurrentQuota() - (p2EndTimeInMins - leftLimit)));
											leftLimit = p2EndTimeInMins;
											temp.setCurrentQuota(p2.getCurrentQuota());
											usedPeriods.add(temp);
										}
									}
								}
							}
						}
						//the hole could not be filled
						//quota cannot be assigned for this request
						if(leftLimit < pStartTimeInMins){
							DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] The hole could not be filled");
							app.setAvailabilityStatus("SUGGESTION");
							//break;
							//instead of breaking lets set the left limit to the start time
							leftLimit = pStartTimeInMins;
						}
					}
					//if there are no holes behind
					if(pStartTimeInMins <= leftLimit && pEndTimeInMins > leftLimit){
						//check if we don't have enough quota to reach the end of this period
						if(leftLimit + p.getCurrentQuota() < pEndTimeInMins){
							//check whether we reached the goal
							if(leftLimit + p.getCurrentQuota() >= goal){
								Period temp = new Period(p.getPeriodNumber(),p.getUserAssignedQuota());
								temp.setStartTime(leftLimit * 60000);
								temp.setEndTime(goal * 60000);
								p.setCurrentQuota(Math.round(p.getCurrentQuota() - (goal - leftLimit)));
								DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Using "+(goal - leftLimit)+" quota from period "+p.getPeriodNumber()+" of UserAssignedQuota "+p.getUserAssignedQuota().getId()+", we've got all the necessary quota now...");
								leftLimit = goal;
								temp.setCurrentQuota(p.getCurrentQuota());
								usedPeriods.add(temp);
								if(!app.getAvailabilityStatus().equals("SUGGESTION"))
									app.setAvailabilityStatus("AVAILABLE");
								DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] There is enough Quota available to complete this request!!");
								break;
							}
							//if we haven't reached the goal
							else{
								Period temp = new Period(p.getPeriodNumber(),p.getUserAssignedQuota());
								temp.setStartTime(leftLimit * 60000);
								temp.setEndTime((leftLimit + p.getCurrentQuota()) * 60000);
								DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Using "+p.getCurrentQuota()+" quota from period "+p.getPeriodNumber()+" of UserAssignedQuota "+p.getUserAssignedQuota().getId());
								leftLimit += p.getCurrentQuota();
								p.setCurrentQuota(0);
								temp.setCurrentQuota(p.getCurrentQuota());
								usedPeriods.add(temp);
							}
						}
						//if we do have enough quota to reach the end of this period,
						//but we can only use quota until the end of the period
						else{
							//if we can reach the goal before the end of the period
							if(pEndTimeInMins >= goal){
								Period temp = new Period(p.getPeriodNumber(),p.getUserAssignedQuota());
								temp.setStartTime(leftLimit * 60000);
								temp.setEndTime(goal * 60000);
								p.setCurrentQuota(Math.round(p.getCurrentQuota() - (goal - leftLimit)));
								DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Using "+(goal - leftLimit)+" quota from period "+p.getPeriodNumber()+" of UserAssignedQuota "+p.getUserAssignedQuota().getId()+", we've got all the necessary quota now...");
								leftLimit = goal;
								temp.setCurrentQuota(p.getCurrentQuota());
								usedPeriods.add(temp);
								if(!app.getAvailabilityStatus().equals("SUGGESTION"))
									app.setAvailabilityStatus("AVAILABLE");
								DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] There is enough Quota available to complete this request!!");
								break;
							}
							//if we can't reach the goal before the end of the period
							else{
								Period temp = new Period(p.getPeriodNumber(),p.getUserAssignedQuota());
								temp.setStartTime(leftLimit * 60000);
								temp.setEndTime(pEndTimeInMins * 60000);
								DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Using "+(pEndTimeInMins - leftLimit)+" quota from period "+p.getPeriodNumber()+" of UserAssignedQuota "+p.getUserAssignedQuota().getId());
								p.setCurrentQuota(Math.round(p.getCurrentQuota() - (pEndTimeInMins - leftLimit)));
								leftLimit = pEndTimeInMins;
								temp.setCurrentQuota(p.getCurrentQuota());
								usedPeriods.add(temp);
							}
						}
					}
					//the space where i can put my quota has already been filled
					else{
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] No need to use quota from period "+p.getPeriodNumber()+" of UserAssignedQuota "+p.getUserAssignedQuota().getId()+", all the quota for this time range was satisfied");
					}
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppoinment "+appointmentId+"] Left limit is now: "+leftLimit);
				}

				//didn't have enough quota to reach the goal
				if(leftLimit < goal){
					DebugTools.println(DEBUG_LEVEL, "[[QuotaSystem - scheduleAppoinment "+appointmentId+"] Not enough quota to finish the request.");
					app.setAvailabilityStatus("SUGGESTION");
				}
			}

			//if the appointment is available, allocate the quota for the user
			if(app.getAvailabilityStatus().equalsIgnoreCase("AVAILABLE")){
				for(Period period : usedPeriods){
					DebugTools.println(DEBUG_LEVEL, "[[QuotaSystem - scheduleAppoinment "+appointmentId+"] Creating new used quota: "+period);
					int quota = (int) (period.getQuotaInPeriod() - period.getCurrentQuota());
					Calendar start = Calendar.getInstance();
					start.setTimeInMillis(period.getStartTime().getTime());
					Calendar end = Calendar.getInstance();
					end.setTimeInMillis(period.getEndTime().getTime());
					quotasystemDB.allocateQuota(period.getPeriodNumber(), quota, appointmentId, affiliationId, period.getUserAssignedQuota().getId(), start, end, false);
				}
				resultingAppointments.add(app);
			}
			else if(app.getAvailabilityStatus().equalsIgnoreCase("SUGGESTION")){
				for(Period period : usedPeriods){
					Appointment temp = app;
					Calendar start = Calendar.getInstance();
					start.setTimeInMillis(period.getStartTime().getTime());
					Calendar end = Calendar.getInstance();
					end.setTimeInMillis(period.getEndTime().getTime());
					temp.setStartTime(start);
					temp.setEndTime(end);
					resultingAppointments.add(temp);
				}
			}
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] appointments requested: ");
		for(int i = 0; i < appointments.length ; i++){
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] "+i+" appointment "+appointments[i].getId()+": "+appointments[i].getAvailabilityStatus());
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] resultingAppointments response: ");
		for(int i = 0; i < resultingAppointments.size() ; i++){
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] "+i+" resultingAppointments "+resultingAppointments.get(i).getId()+": "+resultingAppointments.get(i).getAvailabilityStatus());
		}
		//for(int i = 0; i < appointments.length ; i++){
		//	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] Appointment "+appointments[i].getId()+": "+appointments[i].getAvailabilityStatus());
		//}
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] " +
				"resultingAppointments.size(): " + resultingAppointments.size());
		Appointment[] result = new Appointment[resultingAppointments.size()];
		for(int i = 0 ; i < result.length ; i++){
			result[i] = resultingAppointments.get(i);
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] Appointment "+result[i].getId()+": "+result[i].getAvailabilityStatus());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - scheduleAppointments] scheduleAppointments ready to go out!");

		response.setAppointment(result);
		//response.setAppointment(appointments);

		return response;
	}

	//TODO: FIND A PLACE FOR THESE FUNCTIONS!!!
	//************************************************************************************************************************
	//************************************************************************************************************************
	//************************************************************************************************************************

	private boolean requestRangeCovered(
			ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> userAssignedQuotaList,
			long rangeStartTime, long rangeEndTime) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - requestRangeCovered] Inside!");

		boolean retVal = true;
		
		userAssignedQuotaList = sortByPolicyStartDate(userAssignedQuotaList);
		
		// TODO: I tried to fix it, but this is still not correct!
		long start = userAssignedQuotaList.get(0).getStartDate().getTime();
		long end = userAssignedQuotaList.get(userAssignedQuotaList.size()-1).getPolicyEndDate().getTime();
		for (UserAssignedQuota userAssignedQuota: userAssignedQuotaList) {
			if (start > userAssignedQuota.getStartDate().getTime())
				start = userAssignedQuota.getStartDate().getTime();
			if (end < userAssignedQuota.getPolicyEndDate().getTime())
				end = userAssignedQuota.getPolicyEndDate().getTime();
			
		}
		Date reqStartDate = new Date(rangeStartTime);
		Date reqEndDate   = new Date(rangeEndTime);
		Date startDate    = new Date(start);
		Date endDate      = new Date(end);
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - requestRangeCovered] " +
				"\n\t Requested startDate : " + reqStartDate +
				"\n\t Requested endDate   : " + reqEndDate   +
				"\n\t User quota startDate: " + startDate    +
				"\n\t User quota endDate  : " + endDate   
				);
		
		if(start >= rangeEndTime || end <= rangeStartTime) 
			retVal = false;
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - requestRangeCovered] " +
				"retVal: " + retVal);

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - requestRangeCovered] Inside!");

		return retVal;

		//return isRangeCovered(userAssignedQuotaList,rangeStartTime,rangeEndTime);
	}

	private boolean isRangeCovered(ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> userAssignedQuotaList,
			long rangeStartTime, long rangeEndTime){
		if(userAssignedQuotaList.isEmpty())
			return false;
		else{
			long startTime = userAssignedQuotaList.get(0).getStartDate().getTime();
			long endTime = userAssignedQuotaList.get(0).getPolicyEndDate().getTime();

			int currentIndex = 1;
			for( ; currentIndex < userAssignedQuotaList.size() ; currentIndex++){
				long tempStartTime = userAssignedQuotaList.get(currentIndex).getStartDate().getTime();
				long tempEndTime = userAssignedQuotaList.get(currentIndex).getPolicyEndDate().getTime();

				if(tempStartTime <= endTime){
					if(tempEndTime > endTime){
						endTime = tempEndTime;
					}
				}
				else
					break;
			}
			if(startTime <= rangeStartTime && endTime >= rangeEndTime)
				return true;
			else{
				if(userAssignedQuotaList.size() == 1)
					return false;
				ArrayList<UserAssignedQuota> newList =  (ArrayList<UserAssignedQuota>) userAssignedQuotaList.subList(currentIndex, userAssignedQuotaList.size());
				return isRangeCovered(newList,rangeStartTime,rangeEndTime);
			}
		}

	}

	private ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> sortByPolicyStartDate(
			ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> userAssignedQuotaList){

		int listSize = userAssignedQuotaList.size();
		for(int i = 0 ; i < listSize ; i++){
			for(int j = listSize-2 ; j >= i ; j--){
				long startDateRight = userAssignedQuotaList.get(j+1).getPolicyEndDate().getTime();
				long startDateLeft = userAssignedQuotaList.get(j).getPolicyEndDate().getTime();

				if(startDateRight < startDateLeft){
					userAssignedQuotaList.add(j, userAssignedQuotaList.remove(j+1));
				}
			}
		}

		return userAssignedQuotaList;
	}

	public ArrayList<Period> sortUserAssignedQuotaList(
		   ArrayList<Period> list){

		if(list.size() == 1){
			return list;
		}
		ArrayList<Period> result = new ArrayList<Period>();
		ArrayList<Period> left = new ArrayList<Period>();
		ArrayList<Period> right = new ArrayList<Period>();

		int mid = list.size() / 2;

		for(int i = 0 ; i < mid ; i++){
			left.add(list.get(i));
		}
		for(int i = mid ; i < list.size() ; i++){
			right.add(list.get(i));
		}

		left = sortUserAssignedQuotaList(left);
		right = sortUserAssignedQuotaList(right);
		result = mergeUserAssignedQuotaLists(left, right);

		return result;
	}

	private ArrayList<Period> mergeUserAssignedQuotaLists(
			ArrayList<Period> left,
			ArrayList<Period> right) {
		ArrayList<Period> result = new ArrayList<Period>();

		while( left.size() > 0 || right.size() > 0){
			if ( left.size() > 0 && right.size() > 0 ){
				if( left.get(0).compareTo(right.get(0)) < 0 ){
					result.add(left.get(0));
					left.remove(0);
				}else{
					result.add(right.get(0));
					right.remove(0);
				}
			}
			else if ( left.size() > 0){
				result.addAll(left);
				break;
			}
			else if ( right.size() > 0){
				result.addAll(right);
				break;
			}
		}
		return result;
	}
	//************************************************************************************************************************
	//************************************************************************************************************************
	//************************************************************************************************************************

    public edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse modifyAppointment(
    		edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest modifyAppointmentRequest){

    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] Inside!");
    	edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse response = new edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse();

    	String appointmentId = modifyAppointmentRequest.getAppointment().getId();
    	//cancel the previous appointment to get the real ammount of quota available for the modification
    	edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest cancelAppointmentRequest = new edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest();
    	cancelAppointmentRequest.setAppointmentId(appointmentId);

    	edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse cancelAppointmentResponse = cancelAppointment(cancelAppointmentRequest);

    	if(cancelAppointmentResponse != null && cancelAppointmentResponse.getSuccess()){

    		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] Cancelled previous appointment!");
    		//attempt to schedule the new times
    		edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest scheduleAppointmentRequest = new edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest();

    		//check if the appointment is ongoing and set start time to now if it is
    		Appointment app = modifyAppointmentRequest.getAppointment();
    		Calendar realStart = app.getStartTime();
    		Calendar now = Calendar.getInstance();

    		if( now.compareTo(realStart) > 0)
    			app.setStartTime(now);

    		Appointment[] requestAppointments = {app};
    		scheduleAppointmentRequest.setAppointment(requestAppointments);

    		edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse scheduleAppointmentsResponse = scheduleAppointments(scheduleAppointmentRequest);

    		//check if the status of the response equals AVAILABLE
    		Appointment[] responseAppointments = scheduleAppointmentsResponse.getAppointment();
    		if(responseAppointments[0].getAvailabilityStatus().equals("AVAILABLE")){

    			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] User has enough quota for the new appointment schedule");
    			response.setSuccess(true);
    			response.setReason("Success");
    		}
    		else{

    			//couldnt schedule the new appointment's times
    			//reset the cancelled values to their original status

    			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] User DOES NOT have enough quota for the new appointment schedule");
    			quotasystemDB.restoreAppointment(modifyAppointmentRequest.getAppointment().getId());

    			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] Returned appointment to old schedule");
    			response.setSuccess(false);
    			response.setReason("User doesn't have enough Quota to reschedule on the desired period");
    		}
    	}
    	else{
    		response.setSuccess(false);
    		response.setReason("Couldn't cancel the previous times set for the Appointment.");
    	}

    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] Ready to go out!");

    	return response;
    }

	public edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse cancelAppointment(
			edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest cancelAppointmentRequest) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Inside!");

		edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse response = new edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse();

		String appointmentId = cancelAppointmentRequest.getAppointmentId();
		boolean success = true;

		ArrayList<UsedQuota> usedQuota = (ArrayList<UsedQuota>) quotasystemDB.getUsedQuotaByAppointmentId(appointmentId);
		Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] "+now.toString());

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Processing a list of "+usedQuota.size()+" used quota");
		for(UsedQuota uq : usedQuota){
			//if this appointment has not yet started we can cancel it
			if( uq.getStartTime().after(now)){
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Appointment has not yet started!");
				try{
					success = success && quotasystemDB.cancelAppointmentById(uq.getId());
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Appointment cancelled!");
				}
				catch(Exception e){
					response.setSuccess(false);
					response.setReason(e.getMessage());
				}
			}
			//if this appointment is ongoing
			else if ( uq.getEndTime().after(now)){
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Appointment is ongoing!");
				//need to cancel this appointment and make a new one with 'now' as end date
				int quota = (int) (( now.getTime() / 60000 ) - ( uq.getStartTime().getTime() / 60000 ));
				Calendar start = Calendar.getInstance();
				start.setTimeInMillis(uq.getStartTime().getTime());
				Calendar end = Calendar.getInstance();
				end.setTimeInMillis(now.getTime());
				try{
					success = success && quotasystemDB.cancelAppointmentById(uq.getId());
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Appointment cancelled!");
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] UAQ: "+uq.getUserAssignedQuota());
					quotasystemDB.allocateQuota(uq.getPeriodNumber(), quota, appointmentId, uq.getAffiliationId(), uq.getUserAssignedQuota().getId(), start, end, false);
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] new appointment created!!");
				}
				catch(Exception e){
					success = false;
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Error "+e.getMessage());
					e.printStackTrace();
					response.setReason(e.getMessage());
				}
			}
			//else, it has already passed, dont need to cancel
		}

		response.setSuccess(success);
		if(success)
			response.setReason("Success");
		else
			response.setReason("Failure");

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAppointment] Ready to get out! ");

		return response;
	}

    public edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse cancelAllAppointments(
    		edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest cancelAllAppointmentsRequest){

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAllAppointments] Inside! ");

    	edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse response = new edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse();

    	String affiliationId = cancelAllAppointmentsRequest.getAffiliationId();
		boolean success = true;

		ArrayList<UsedQuota> usedQuota = (ArrayList<UsedQuota>) quotasystemDB.getUsedQuotaByAffiliationId(affiliationId);
		Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());

		for(UsedQuota uq : usedQuota){
			//if this appointment has not yet started we can cancel it
			if( uq.getStartTime().after(now)){
				try{
					success = success && quotasystemDB.cancelAppointmentById(uq.getId());
				}
				catch(Exception e){
					response.setSuccess(false);
					response.setReason(e.getMessage());
				}
			}
			//if this appointment is ongoing
			else if ( uq.getEndTime().after(now)){
				//need to cancel this appointment and make a new one with 'now' as end date
				int quota = (int) (( now.getTime() / 60000 ) - ( uq.getStartTime().getTime() / 60000 ));
				Calendar start = Calendar.getInstance();
				start.setTimeInMillis(uq.getStartTime().getTime());
				Calendar end = Calendar.getInstance();
				end.setTimeInMillis(now.getTime());
				try{
					success = success && quotasystemDB.cancelAppointmentById(uq.getId());
					quotasystemDB.allocateQuota(uq.getPeriodNumber(), quota, uq.getAppointmentId(), affiliationId, uq.getUserAssignedQuota().getId(), start, end, false);
				}
				catch(Exception e){
					response.setSuccess(false);
					response.setReason(e.getMessage());
				}
			}
			//else, it has already passed, dont need to cancel
		}

		response.setSuccess(success);
		if(success)
			response.setReason("Success");
		else
			response.setReason("Failure");

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - cancelAllAppointments] Ready to get out! ");

		return response;
    }


    public edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse doesUserHaveAvailableQuota(
    		edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest doesUserHaveAvailableQuotaRequest){
    	edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse response = new edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse();


    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] doesUserHaveAvailableQuota Inside!");

    	String username = doesUserHaveAvailableQuotaRequest.getUsername();
    	String coursename = doesUserHaveAvailableQuotaRequest.getCourse();

    	edu.fiu.cis.acrl.quotasystem.entity.Course course = quotasystemDB.getCourseByFullName(coursename);
    	edu.fiu.cis.acrl.quotasystem.entity.UserProfile user = quotasystemDB.getUserByUsername(username);

    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] got course: "+course);
    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - modifyAppointment] got user: "+user);

    	if(course != null && user != null){
    		List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypesList = course.getCreditTypes();
    		Iterator<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypeIterator = creditTypesList.iterator();

    		//get all the user assigned quota for that course and user and check if the user has any quota
    		while(creditTypeIterator.hasNext()){
    			List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> temp = quotasystemDB.getUserAssignedQuota(creditTypeIterator.next().getId(), user.getId());

    			Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> itr = temp.iterator();
    			while(itr.hasNext()){
    				if(itr.next().getRemainingQuota() > 0){
    					response.setQuotaIsAvailable(true);
    					return response;
    				}
    			}
    		}
    	}
    	response.setQuotaIsAvailable(false);
    	return response;
    }


	public edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse getCurrentPeriodQuotaSummary(
			edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest getCurrentPeriodQuotaSummaryRequest) {

		GetCurrentPeriodQuotaSummaryResponse response = new GetCurrentPeriodQuotaSummaryResponse();

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryRequest Inside!");

		//Course id is optional  in the request so when it is sent only that course should be considered
		// for the response, otherwise all courses should be taken into consideration
		int[] courses = null;
		int courseId = getCurrentPeriodQuotaSummaryRequest.getCourseId();

		if(courseId>0){
			courses = new int[1];
			courses[0]= courseId;
		}else{
			List<edu.fiu.cis.acrl.quotasystem.entity.Course> coursesList = quotasystemDB.getCourses();
			if(coursesList.size()>0){
				courses = new int[coursesList.size()];
				int i = 0;
				for(edu.fiu.cis.acrl.quotasystem.entity.Course course:coursesList){
					courses[i++]= course.getId();
				}
			}else{
				return response;
			}
		}

		//Get credit types assigned to the courses
		List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes =
			quotasystemDB.getCreditTypesByCourse(courses);

		Iterator<edu.fiu.cis.acrl.quotasystem.entity.CreditType> itrCreditType =
			creditTypes.iterator();

		while(itrCreditType.hasNext()){

			int totalAvailableQuota = 0;
			int totalUsedQuota = 0;
			int totalToExpireQuota =0;
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType= itrCreditType.next();
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] "+creditType.toString());

			courses = new int[1];
			courses[0]= creditType.getCourse().getId();
			//Get users enrolled in these courses
			List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> users =
				quotasystemDB.getUsersByCourse(courses);


			Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> itrUsers =
				users.iterator();

			while(itrUsers.hasNext()){
				int available = 0;
				int used = 0;
				int toExpire =0;

				edu.fiu.cis.acrl.quotasystem.entity.UserProfile user= itrUsers.next();
				List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuotas =
					quotasystemDB.getUserAssignedQuota(creditType.getId(), user.getId());

				Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> itrAssignedQuota =
					assignedQuotas.iterator();
				DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] assigned quotas total "+assignedQuotas.size()+ " for user "+user.getUsername()+" and credit type "+creditType.getName());
				while(itrAssignedQuota.hasNext()){
					edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota assignedQuota =
						itrAssignedQuota.next();
					int currentPeriod = assignedQuota.getCurrentPeriodNumber();
					used += assignedQuota.getUsedQuotaInPeriod(currentPeriod);
					int toExp = assignedQuota.getToExpireQuotaInPeriod(currentPeriod);
					toExpire += toExp;
					available += assignedQuota.getAvailableQuotaInCurrentPeriod()-toExp;
					DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] available: "+available+ "-used: "+used+" -toexpire: "+toExpire);


				}
				DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] available: "+available+ "-used: "+used+" -toexpire: "+toExpire);

				totalUsedQuota += used;
				totalAvailableQuota += available;
				totalToExpireQuota += toExpire;

			}

			QuotaSummary quotaSummary = new QuotaSummary();
			quotaSummary.setQuotaUsed(totalUsedQuota);
			quotaSummary.setQuotaAvailable(totalAvailableQuota);
			quotaSummary.setQuotaExpired(totalToExpireQuota);
			CreditType axisCreditType = CreditTypeTranslator.toAxisRepresentation(creditType);
			quotaSummary.setCreditType(axisCreditType);
			response.addQuotaSummary(quotaSummary);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! CreditType: "+creditType.getName()+" Available: "+totalAvailableQuota+", Used: "+totalUsedQuota+", Expired:"+totalToExpireQuota);
		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryRequest out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse getCurrentPeriodQuotaSummaryByCreditType(
			edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest getCurrentPeriodQuotaSummaryByCreditTypeRequest)
			throws CreditTypeNotFoundFault {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryByCreditType Inside!");
		GetCurrentPeriodQuotaSummaryByCreditTypeResponse response = new GetCurrentPeriodQuotaSummaryByCreditTypeResponse();
		int creditTypeId = getCurrentPeriodQuotaSummaryByCreditTypeRequest.getCreditTypeId();
		edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = quotasystemDB.getCreditTypeById(creditTypeId);

		int[] courses = new int[1];
		int courseId = creditType.getCourse().getId();
		courses[0]= courseId;

		List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> users =
			quotasystemDB.getUsersByCourse(courses);

		Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> itrUsers =
			users.iterator();

		while(itrUsers.hasNext()){

			int availableQuota = 0;
			int totalUsedQuota = 0;
			int toExpireQuota =0;


			edu.fiu.cis.acrl.quotasystem.entity.UserProfile user= itrUsers.next();

			List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuotas =
				quotasystemDB.getUserAssignedQuota(creditType.getId(), user.getId());

			Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> itrAssignedQuota =
				assignedQuotas.iterator();

			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] assigned quotas total "+assignedQuotas.size());
			while(itrAssignedQuota.hasNext()){
				edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota assignedQuota =
					itrAssignedQuota.next();
				int currentPeriod = assignedQuota.getCurrentPeriodNumber();
				totalUsedQuota += assignedQuota.getUsedQuotaInPeriod(currentPeriod);
				int toExp = assignedQuota.getToExpireQuotaInPeriod(currentPeriod);
				toExpireQuota += toExp;
				availableQuota += assignedQuota.getAvailableQuotaInCurrentPeriod()-toExp;

			}

			QuotaSummary quotaSummary = new QuotaSummary();
			quotaSummary.setQuotaUsed(totalUsedQuota);
			quotaSummary.setQuotaAvailable(availableQuota);
			quotaSummary.setQuotaExpired(toExpireQuota);
			User axisUser = UserTranslator.toAxisRepresentation(user);
			quotaSummary.setUser(axisUser);
			response.addQuotaSummary(quotaSummary);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! User: "+user.getUsername()+" Available: "+availableQuota+", Used: "+totalUsedQuota+", Expired:"+toExpireQuota);
		}
		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryByCreditType out!");
		return response;
	}

	public GetCurrentPeriodQuotaSummaryByUserResponse getCurrentPeriodQuotaSummaryByUser(
			GetCurrentPeriodQuotaSummaryByUserRequest getCurrentPeriodQuotaSummaryByUserRequest){

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryByUser Inside!");
		GetCurrentPeriodQuotaSummaryByUserResponse response = new GetCurrentPeriodQuotaSummaryByUserResponse();
		int userId = getCurrentPeriodQuotaSummaryByUserRequest.getUserId();

		int[] courseIds = quotasystemDB.getCourseIdsByUserId(userId);

		if( courseIds.length == 0 )
			return null;

		List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes =
			quotasystemDB.getCreditTypesByCourse(courseIds);

		for(edu.fiu.cis.acrl.quotasystem.entity.CreditType ct : creditTypes){
			int availableQuota = 0;
			int totalUsedQuota = 0;
			int toExpireQuota =0;

			List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuotas =
				quotasystemDB.getUserAssignedQuota(ct.getId(), userId);

			for(edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota uaq : assignedQuotas){
				int currentPeriod = uaq.getCurrentPeriodNumber();
				totalUsedQuota += uaq.getUsedQuotaInPeriod(currentPeriod);
				int toExp = uaq.getToExpireQuotaInPeriod(currentPeriod);
				toExpireQuota += toExp;
				availableQuota += uaq.getAvailableQuotaInCurrentPeriod()-toExp;
			}
			QuotaSummary quotaSummary = new QuotaSummary();
			quotaSummary.setQuotaUsed(totalUsedQuota);
			quotaSummary.setQuotaAvailable(availableQuota);
			quotaSummary.setQuotaExpired(toExpireQuota);

			CreditType axisCreditType = CreditTypeTranslator.toAxisRepresentation(ct);
			quotaSummary.setCreditType(axisCreditType);

			response.addQuotaSummary(quotaSummary);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! Available: "+availableQuota+", Used: "+totalUsedQuota+", Expired:"+toExpireQuota);

		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryByUser out!");
		return response;
	}

	public GetCurrentPeriodQuotaSummaryByUserAndCourseResponse getCurrentPeriodQuotaSummaryByUserAndCourse(
			GetCurrentPeriodQuotaSummaryByUserAndCourseRequest getCurrentPeriodQuotaSummaryByUserAndCourseRequest){

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryByUserAndCourse Inside!");
		GetCurrentPeriodQuotaSummaryByUserAndCourseResponse response = new GetCurrentPeriodQuotaSummaryByUserAndCourseResponse();
		int userId = getCurrentPeriodQuotaSummaryByUserAndCourseRequest.getUserId();
		int courseId = getCurrentPeriodQuotaSummaryByUserAndCourseRequest.getCourseId();

		edu.fiu.cis.acrl.quotasystem.entity.UserProfile user = quotasystemDB.getUserById(userId);

		int[] courseIds = {courseId};

		List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes =
			quotasystemDB.getCreditTypesByCourse(courseIds);

		for(edu.fiu.cis.acrl.quotasystem.entity.CreditType ct : creditTypes){
			int availableQuota = 0;
			int totalUsedQuota = 0;
			int toExpireQuota =0;

			List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuotas =
				quotasystemDB.getUserAssignedQuota(ct.getId(), user.getId());

			for(edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota uaq : assignedQuotas){
				int currentPeriod = uaq.getCurrentPeriodNumber();
				totalUsedQuota += uaq.getUsedQuotaInPeriod(currentPeriod);
				int toExp = uaq.getToExpireQuotaInPeriod(currentPeriod);
				toExpireQuota += toExp;
				availableQuota += uaq.getAvailableQuotaInCurrentPeriod()-toExp;
			}
			QuotaSummary quotaSummary = new QuotaSummary();
			quotaSummary.setQuotaUsed(totalUsedQuota);
			quotaSummary.setQuotaAvailable(availableQuota);
			quotaSummary.setQuotaExpired(toExpireQuota);

			CreditType axisCreditType = CreditTypeTranslator.toAxisRepresentation(ct);
			quotaSummary.setCreditType(axisCreditType);

			response.addQuotaSummary(quotaSummary);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! Available: "+availableQuota+", Used: "+totalUsedQuota+", Expired:"+toExpireQuota);

		}
		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCurrentPeriodQuotaSummaryByUserAndCourse out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse getHistoricQuotaSummaryPerPeriods(
			edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest getHistoricQuotaSummaryPerPeriodsRequest)
			throws CreditTypeNotFoundFault, UserNotFoundFault, InvalidDataFault {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryPerPeriods Inside!");
		GetHistoricQuotaSummaryPerPeriodsResponse response = new GetHistoricQuotaSummaryPerPeriodsResponse();



		int userId = getHistoricQuotaSummaryPerPeriodsRequest.getUserId();
		int creditTypeId = getHistoricQuotaSummaryPerPeriodsRequest.getCreditTypeId();
		String timeZoneId = getHistoricQuotaSummaryPerPeriodsRequest.getTimeZoneId();

		//Get request timezone
		String timeZoneIdInJava = TimeZoneTools.getTimeZoneIdInJava(timeZoneId);
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneIdInJava);


		edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType =
			quotasystemDB.getCreditTypeById(creditTypeId);

		List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> users =
			new ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserProfile>();

		List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuotas = null;
		boolean periodLabel = true; //true when absolute or relative with only one assignedQuota, false otherwise
		boolean absolute = creditType.getPolicy().getAbsolute();
		
		//User parameter is optional in this request so we  will query the database for
		//a specific user if userId was sent in the request, otherwise we query for all
		//users in the course assigned to the credit type sent in the request
		if(userId>0){
			edu.fiu.cis.acrl.quotasystem.entity.UserProfile user = quotasystemDB.getUserById(userId);
			assignedQuotas = quotasystemDB.getUserAssignedQuota(creditType.getId(), user.getId());
			if(!absolute && assignedQuotas.size()>1)
				periodLabel = false;
				
			users.add(user);
			
		}else{
			int[] courses = new int[1];
			int courseId = creditType.getCourse().getId();
			courses[0]= courseId;
			users = quotasystemDB.getUsersByCourse(courses);
			
			if(!absolute)
				periodLabel = false;
		}

		int numberOfPeriods = creditType.getPolicy().getNumberOfPeriods();
		int periodNo = 1;
		Format formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		while(periodNo<=numberOfPeriods){
			int totalExpiredQuota = 0;
			int totalUsedQuota = 0;
			int totalAvailableQuota = 0;
			
			String label="";
			
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> itrUsers =
				users.iterator();
			
			boolean labeled = false;
			
			while(itrUsers.hasNext()){
				edu.fiu.cis.acrl.quotasystem.entity.UserProfile user= itrUsers.next();
				assignedQuotas = quotasystemDB.getUserAssignedQuota(creditType.getId(), user.getId());

				Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> itrAssignedQuota =
					assignedQuotas.iterator();

				while(itrAssignedQuota.hasNext()){
					edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota assignedQuota =
						itrAssignedQuota.next();
					int currentPeriodNumber = assignedQuota.getCurrentPeriodNumber();
					int available = 0; //Available
					int used = 0; //Used/Being Used/Reserved
					int expired = 0; //Expired/To Expire
					
					//Past periods
					if(periodNo < currentPeriodNumber){
						used = assignedQuota.getUsedQuotaPerPeriod(periodNo);
						expired = assignedQuota.getExpiredQuotaPerPeriod(periodNo);
						
					//Current Period
					}else if(periodNo == currentPeriodNumber){
						used = assignedQuota.getUsedQuotaPerPeriod(periodNo);
						expired = assignedQuota.getToExpireQuotaInPeriod(periodNo);
						available = assignedQuota.getAvailableQuotaPerPeriod(periodNo);
						
					//Future Periods
					}else if(periodNo > currentPeriodNumber){
						used = assignedQuota.getUsedQuotaPerPeriod(periodNo);
						available = assignedQuota.getAvailableQuotaPerPeriod(periodNo);
						
					}
					
					totalAvailableQuota += available;
					totalUsedQuota += used;
					totalExpiredQuota += expired;
					
					if(!labeled){
						Calendar endDate = Calendar.getInstance();
						endDate.setTime(assignedQuota.getPolicyPeriodEndDate(periodNo));
						endDate.add(Calendar.MINUTE, -1);

						Calendar startDate = Calendar.getInstance();
						startDate.setTime(assignedQuota.getPolicyPeriodStartDate(periodNo));

						startDate =  TimeZoneTools.changeTimeZoneTo(startDate, timeZone);
						endDate = TimeZoneTools.changeTimeZoneTo(endDate, timeZone);

						if(periodLabel){
							label = formatter.format(startDate.getTime())+" - "+formatter.format(endDate.getTime());
							
							if(assignedQuota.getCreditType().getPolicy().getPolicyType().equalsIgnoreCase("NOEXPIRATION"))
								label=formatter.format(startDate.getTime())+" - &infin;";
						}else{
							label = ""+periodNo;
						}
						labeled = true;
					}


				}
			}

			QuotaSummary quotaSummary = new QuotaSummary();
			quotaSummary.setQuotaUsed(totalUsedQuota);
			quotaSummary.setQuotaExpired(totalExpiredQuota);
			quotaSummary.setQuotaAvailable(totalAvailableQuota);
			quotaSummary.setLabel(label);
			CreditType axisCreditType = CreditTypeTranslator.toAxisRepresentation(creditType);
			quotaSummary.setCreditType(axisCreditType);
			quotaSummary.setPeriodNumber(periodNo);
			response.addQuotaSummary(quotaSummary);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! PeriodNo: "+periodNo+" Available: "+totalAvailableQuota+", Used: "+totalUsedQuota+", Expired:"+totalExpiredQuota);

			periodNo++;
		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryPerPeriods out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse getCourses() {

		GetCoursesResponse response = new GetCoursesResponse();

		try {

			List<edu.fiu.cis.acrl.quotasystem.entity.Course> courses =
				quotasystemDB.getCourses();
			Course[] coursesResponse = new Course[courses.size()];
			int i = 0;
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.Course> itr = courses
					.iterator();
			while (itr.hasNext()) {
				Course course = CourseTranslator.toAxisRepresentation(itr
						.next());
				coursesResponse[i++] = course;
			}

			response.setCourse(coursesResponse);

		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}

		return response;
	}

    public edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse getPolicyById
    (
    edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest getPolicyByIdRequest
    )
	{
    	GetPolicyByIdResponse response = new GetPolicyByIdResponse();


    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] getPolicyById inside!!");
		try{

			//Get request timezone
			String timeZoneId = getPolicyByIdRequest.getTimeZoneId();
			String timeZoneIdInJava = TimeZoneTools.getTimeZoneIdInJava(timeZoneId);
			TimeZone timeZone = TimeZone.getTimeZone(timeZoneIdInJava);

			edu.fiu.cis.acrl.quotasystem.entity.Policy policy =
				quotasystemDB.getPolicyById(getPolicyByIdRequest.getPolicyId());
			Policy policyResponse = PolicyTranslator.toAxisRepresentation(policy);

			if(policyResponse.getStartDate()!=null){
				policyResponse.setStartDate(TimeZoneTools.changeTimeZoneTo(policyResponse.getStartDate(), timeZone));
			}

			response.setGetPolicyByIdResponse(policyResponse);
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}

    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] getPolicyById out!!");
    	return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse getAssignablePolicies(
			edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest getAssignablePoliciesRequest
	) {
    	DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] getAssignablePolicies inside!");
		GetAssignablePoliciesResponse response = new GetAssignablePoliciesResponse();

		//Get request timezone
		String timeZoneId = getAssignablePoliciesRequest.getTimeZoneId();
		String timeZoneIdInJava = TimeZoneTools.getTimeZoneIdInJava(timeZoneId);
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneIdInJava);

		try {
			List<edu.fiu.cis.acrl.quotasystem.entity.Policy> policies =
				quotasystemDB.getAssignablePolicies();
			int i= 0;
			for(edu.fiu.cis.acrl.quotasystem.entity.Policy dbpolicy:policies){
				Policy policy = PolicyTranslator.toAxisRepresentation(dbpolicy);
				if(policy.getStartDate()!=null)
					policy.setStartDate(TimeZoneTools.changeTimeZoneTo(policy.getStartDate(), timeZone));
				response.addPolicy(policy);
			}

		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] Error " + e.getMessage());
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] getAssignablePolicies out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse enrollUser(
			edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest enrollUserRequest)
			throws CourseNotFoundFault, UserNotFoundFault {
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] enrollUser inside!");
		
		//set response
		EnrollUserResponse response = new EnrollUserResponse();
		response.setSuccess(false);
		response.setReason("User could not be enrolled");

		//Get request values
		int userId = enrollUserRequest.getEnrollUserRequest().getUserId();
		int courseId = enrollUserRequest.getEnrollUserRequest().getCourseId();
		int id = enrollUserRequest.getEnrollUserRequest().getEnrollmentId();

		try{

			if(quotasystemDB.getUserById(userId)==null){
				throw new UserNotFoundFault("User Not Found Fault");
			}
			if(quotasystemDB.getCourseById(courseId)==null){
				throw new CourseNotFoundFault("Course Not Found Fault");
			}

			//apply course pre assignments
			List<edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment> courseAssignments =
				quotasystemDB.getActiveCourseAssignedQuota(courseId);
					
			if(courseAssignments.size()>0){
				QuotaAssignment[] assignments = new QuotaAssignment[courseAssignments.size()];	
				int j = 0;
				for(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment :courseAssignments){
					assignment.setActive(false);
					assignments[j++] = QuotaAssignmentTranslator.toAxisRepresentation(assignment);					
				}
				
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] assignments count for new active enrollment:"+assignments.length);
	
				//set assignQuotaRequest
				AssignQuotaRequest request = new AssignQuotaRequest();
				request.setPayment(false);
				request.setRollback(true);
				request.setUserId(userId);
				request.setAssignment(assignments);
	
				AssignQuotaResponse assignQuotaResponse = this.assignQuota(request);
				QuotaAssignment[] assignmentsResponse = assignQuotaResponse.getAssignment();

				
				boolean allSuccess = true;
				for(QuotaAssignment assignment :assignmentsResponse){
					if(!assignment.getActive()){
						allSuccess = false;
						break;
					}
				}
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] success:"+allSuccess);
				if(allSuccess){
					quotasystemDB.addEnrollment(id, userId, courseId);
					response.setSuccess(true);
					response.setReason("Successful");
				}else{
					response.setReason("Not enough resources to enroll the user");
				}
			}else{
				
				quotasystemDB.addEnrollment(id, userId, courseId);
				response.setSuccess(true);
				response.setReason("Successful");
				
			}


		}catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			response.setReason("Enrollment could not be saved in database");
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			response.setReason("Enrollment could not be saved in database");
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] enrollUser out! ");
		return response;
	}

	public void unenrollUser(
			edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest unenrollUserRequest)
			throws EnrollmentNotFoundFault, CourseNotFoundFault,
			UserNotFoundFault {
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] unenrollUser inside!");
		
		int userId = unenrollUserRequest.getUnenrollUserRequest().getUserId();
		int courseId = unenrollUserRequest.getUnenrollUserRequest().getCourseId();
		int id = unenrollUserRequest.getUnenrollUserRequest().getEnrollmentId();

		List<edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment> courseAssignments =
			quotasystemDB.getActiveCourseAssignedQuota(courseId);
		
		if(courseAssignments.size()>0){

			QuotaAssignment[] assignments = new QuotaAssignment[courseAssignments.size()];
	
			int i = 0;
	
			for(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment :courseAssignments){
				assignment.setActive(false);
				assignments[i++] = QuotaAssignmentTranslator.toAxisRepresentation(assignment);
			}
	
			CancelQuotaAssignmentsRequest cancelQuotaAssignmentsRequest =
				new CancelQuotaAssignmentsRequest();
			cancelQuotaAssignmentsRequest.setAssignment(assignments);
			try {
				cancelQuotaAssignments(cancelQuotaAssignmentsRequest);
			} catch (CreditTypeNotFoundFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidDataFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		quotasystemDB.deleteEnrollment(id);
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] unenrollUser out!");

	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse getCreditTypeById(
			edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest getCreditTypeByIdRequest)
			throws CreditTypeNotFoundFault {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - getCreditTypeById] Inside!");

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - getCreditTypeById] " +
				"\n\t getCreditTypeByIdRequest.getGetCreditTypeByIdRequest(): " + getCreditTypeByIdRequest.getGetCreditTypeByIdRequest());

		GetCreditTypeByIdResponse response = new GetCreditTypeByIdResponse();

		try{
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType =
				quotasystemDB.getCreditTypeById(getCreditTypeByIdRequest.getGetCreditTypeByIdRequest());
			CreditType creditTypeResponse = CreditTypeTranslator.toAxisRepresentation(creditType);

			response.setGetCreditTypeByIdResponse(creditTypeResponse);
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - getCreditTypeById] 1 exception message: " + e.getMessage());
		}catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - getCreditTypeById] 2 exception message: " + e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - getCreditTypeById] Ready to get out!");

		return response;
	}

	public void syncUsersAndCourses(
			edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest syncUsersAndCoursesRequest) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] syncUsersAndCourses Inside!!");


		//Get request data
		User[] users = syncUsersAndCoursesRequest.getUser();
		Course[] courses = syncUsersAndCoursesRequest.getCourse();
		Enrollment[] enrollments = syncUsersAndCoursesRequest.getEnrollment();

		//Add new users or modify existing ones
		try{

			for(int i=0;i<users.length;i++){
				User user= users[i];
				edu.fiu.cis.acrl.quotasystem.entity.UserProfile dbuser=
					quotasystemDB.getUserById(user.getId());
				if(dbuser==null){
					quotasystemDB.addUser(user.getId(), user.getUsername(), user.getEmail());
				}else{
					quotasystemDB.modifyUser(user.getId(), user.getUsername(), user.getEmail());
				}
			}
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}

		//Add new courses or modify existing ones
		try{
			for(int i=0;i<courses.length;i++){
				Course course = courses[i];
				edu.fiu.cis.acrl.quotasystem.entity.Course dbcourse=
					quotasystemDB.getCourseById(course.getId());
				if(dbcourse==null){
					quotasystemDB.addCourse(course.getId(), course.getShortname(), course.getFullname());
				}else{
					quotasystemDB.modifyCourse(course.getId(), course.getShortname(), course.getFullname());
				}
			}
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}

		//Add enrollments if they do not exists or id has changed
		try{
			for(int i=0;i<enrollments.length;i++){
				Enrollment enrollment = enrollments[i];
				edu.fiu.cis.acrl.quotasystem.entity.UserProfile dbuser=
					quotasystemDB.getUserById(enrollment.getUserId());
				edu.fiu.cis.acrl.quotasystem.entity.Course dbcourse=
					quotasystemDB.getCourseById(enrollment.getCourseId());
				//Check that enrollment is valid
				if(dbuser!=null && dbcourse!=null){
					
					edu.fiu.cis.acrl.quotasystem.ws.Enrollment e = 
						new edu.fiu.cis.acrl.quotasystem.ws.Enrollment();
					
					e.setCourseId(enrollment.getCourseId());
					e.setUserId(enrollment.getUserId());
					e.setEnrollmentId(enrollment.getEnrollmentId());
		
					int enrollmentId = quotasystemDB.getEnrollmentId(dbcourse.getId(), dbuser.getId());

					if(enrollmentId==0 ){//This means enrollment does not exist
						edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest request= 
							new edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest();
						request.setEnrollUserRequest(e);
						this.enrollUser(request);

					}else if(enrollmentId!=enrollment.getEnrollmentId()){//This means that the id does not match with the request
						
						edu.fiu.cis.acrl.quotasystem.ws.Enrollment u = 
							new edu.fiu.cis.acrl.quotasystem.ws.Enrollment();
						
						u.setCourseId(enrollment.getCourseId());
						u.setUserId(enrollment.getUserId());
						u.setEnrollmentId(enrollmentId);
						
						edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest request1= 
							new edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest();
						unenrollUser(request1);
						
						edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest request2= 
							new edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest();
						request2.setEnrollUserRequest(e);
						this.enrollUser(request2);
					}
				}

			}
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}


		//Delete enrollments and courses that are not in the request

		try{
			List<edu.fiu.cis.acrl.quotasystem.entity.Course> coursesAfter =
				quotasystemDB.getCourses();
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.Course> itrCourseAfter=
				coursesAfter.iterator();

			while(itrCourseAfter.hasNext()){
				boolean erase = true;
				edu.fiu.cis.acrl.quotasystem.entity.Course courseAfter = itrCourseAfter.next();



				//Delete enrollments that are not in the request
				List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> usersEnrolled =
					courseAfter.getUserProfiles();

				Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> itrUser =
					usersEnrolled.iterator();


				while(itrUser.hasNext()){
					boolean unenroll = true;
					edu.fiu.cis.acrl.quotasystem.entity.UserProfile enrolledUser = itrUser.next();
					for(int i=0;i<enrollments.length;i++){
						Enrollment enrollment = enrollments[i];
						if(enrollment.getCourseId()==courseAfter.getId() &&
								enrollment.getUserId() == enrolledUser.getId()){
							unenroll = false;
							break;
						}

					}
					if(unenroll)
						quotasystemDB.deleteEnrollment(quotasystemDB.getEnrollmentId(courseAfter.getId(), enrolledUser.getId()));
				}

				//Delete courses that are not in the request
				for(int i=0;i<courses.length;i++){
					Course course= courses[i];
					if(courseAfter.getId()==course.getId()){
						erase=false;
						break;
					}
				}

				if(erase) quotasystemDB.deleteCourse(courseAfter.getId());
			}
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}


		//Delete users that are not in the request
		try{
			List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> usersAfter =
				quotasystemDB.getUsers();

			Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> itrUserAfter =
				usersAfter.iterator();

			while(itrUserAfter.hasNext()){
				boolean erase = true;
				edu.fiu.cis.acrl.quotasystem.entity.UserProfile userAfter = itrUserAfter.next();
				for(int i=0;i<users.length;i++){
					User user= users[i];
					if(userAfter.getId()==user.getId()){
						erase=false;
						break;
					}
				}

				if(erase) quotasystemDB.deleteUser(userAfter.getId());
			}
		}catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}


		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] syncUsersAndCourses out!");
	}

	public void modifyPolicy(
			edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest modifyPolicyRequest)
			throws PolicyNotFoundFault, InvalidDataFault, DuplicatePolicyFault {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] modifyPolicy inside!");

		//Get parameters
		String timeZoneId = modifyPolicyRequest.getTimeZoneId();
		Policy p = modifyPolicyRequest.getPolicy();

		//Get request timezone
		String timeZoneIdInJava = TimeZoneTools.getTimeZoneIdInJava(timeZoneId);
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneIdInJava);
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] USER TIMEZONE " + timeZone.getDisplayName());

		try{
			edu.fiu.cis.acrl.quotasystem.entity.Policy policy = quotasystemDB.getPolicyById(p.getId());

			if(policy == null){
				throw new PolicyNotFoundFault("Policy Not Found Fault");
			}else{

				List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes =
					quotasystemDB.getCreditTypesByPolicy(policy.getId());

				if(creditTypes.size()==0){

					PolicyType type = p.getPolicyType();
					int id = p.getId();
					String name = p.getName();
					String description = p.getDescription();
					int quotaInPeriod = p.getQuotaInPeriod();
					boolean absolute = p.getAbsolute();
					boolean active = p.getActive();
					boolean assignable = p.getAssignable();
					int numberOfPeriods = p.getNumberOfPeriods();

					//Optional parameters in request
					int daysInPeriod = p.getDaysInPeriod();
					int minimum = p.getMinimum();
					int maximum = p.getMaximum();
					int daysToRelStart = 0;
					Calendar startDate = null;

					//Get start dae if absolute, or daystoRelStart if relative
					if(absolute){
						startDate = p.getStartDate();
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] BEFORE "+startDate.getTime()+" " + startDate.getTimeZone().getDisplayName());
						startDate = TimeZoneTools.changeTimeZoneFrom(startDate, timeZone);
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] BEFORE "+startDate.getTime()+" " + startDate.getTimeZone().getDisplayName());
					}else{
						daysToRelStart = p.getDaysToRelStart();
					}

					//Set the maximum and minimum for policies that these do not apply
					if(type.getValue().equals(PolicyType._NOEXPIRATION)){
						minimum = 0;
						maximum = quotaInPeriod;
						daysInPeriod = Integer.MAX_VALUE;
						numberOfPeriods = 1;
					}else if(!type.getValue().equals(PolicyType._MINMAX)){
						minimum =quotaInPeriod;
						maximum = quotaInPeriod;
					}
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - instance ] Max: "+maximum+" Min: "+ minimum + " NoPeriods: "+numberOfPeriods + " DaysInPeriod: "+daysInPeriod);
					quotasystemDB.modifyPolicy(id, name, description,
							startDate, daysInPeriod,daysToRelStart,
							numberOfPeriods, active,maximum, minimum,
							quotaInPeriod, absolute,assignable, type.getValue());
				}else{
					throw new InvalidDataFault("Policy is already in use and cannot be modified.");
				}

			}

		}catch(Error e){
			e.printStackTrace();
			throw new InvalidDataFault(e.getMessage());

		}catch(Exception e){
			e.printStackTrace();
			throw new InvalidDataFault(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] modifyPolicy out!");


	}

	public void modifyUser(
			edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest modifyUserRequest)
			throws UserNotFoundFault, InvalidDataFault, DuplicateUserFault {

		int id = modifyUserRequest.getModifyUserRequest().getId();
		String username = modifyUserRequest.getModifyUserRequest().getUsername();
		String email = modifyUserRequest.getModifyUserRequest().getEmail();
		quotasystemDB.modifyUser(id, username, email);

	}

	public void deleteUser(
			edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest deleteUserRequest)
			throws UserNotFoundFault {
		int id = deleteUserRequest.getDeleteUserRequest();
		quotasystemDB.deleteUser(id);

	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse getHistoricQuotaSummary(
			edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest getHistoricQuotaSummaryRequest) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummary inside!");

		GetHistoricQuotaSummaryResponse response = new GetHistoricQuotaSummaryResponse();

		int[] courses = null;

		//Course id is optional  in the request so when it is sent only that course should be considered
		// for the response, otherwise all courses should be taken into consideration
		int courseId = getHistoricQuotaSummaryRequest.getCourseId();
		if(courseId>0){
			courses = new int[1];
			courses[0]= courseId;
		}else{
			List<edu.fiu.cis.acrl.quotasystem.entity.Course> coursesList = quotasystemDB.getCourses();

			if(coursesList.size()>0){
				courses = new int[coursesList.size()];
				int i = 0;
				for(edu.fiu.cis.acrl.quotasystem.entity.Course course:coursesList){
					courses[i++]= course.getId();

				}
			//Return nothing if there are no courses in database
			}else{
				return response;
			}

		}

		//Get credit types assigned for those courses
		List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes =
			quotasystemDB.getCreditTypesByCourse(courses);

		//Get users enrolled in the courses
		List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> users =
			quotasystemDB.getUsersByCourse(courses);

		for(edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType:creditTypes){

			int totalExpiredQuota = 0;
			int totalUsedQuota = 0;
			int totalAvailableQuota = 0;

			for(edu.fiu.cis.acrl.quotasystem.entity.UserProfile user:users){

				List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuotas =
					quotasystemDB.getUserAssignedQuota(creditType.getId(), user.getId());

				Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> itrAssignedQuota =
					assignedQuotas.iterator();
				while(itrAssignedQuota.hasNext()){
					edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota assignedQuota =
						itrAssignedQuota.next();
					int periodNo = 1;

					while(periodNo<= assignedQuota.getCreditType().getPolicy().getNumberOfPeriods()){
						int usedQuota = assignedQuota.getUsedQuotaInPeriod(periodNo);
						int expiredQuota = assignedQuota.getExpiredQuotaInPeriod(periodNo);
						int availableQuota = assignedQuota.getMaxQuotaInPeriod() - usedQuota - expiredQuota;
						totalUsedQuota += usedQuota;
						totalExpiredQuota += expiredQuota;
						totalAvailableQuota += availableQuota;
						periodNo++;
					}

				}

			}

			QuotaSummary quotaSummary = new QuotaSummary();
			quotaSummary.setQuotaUsed(totalUsedQuota);
			quotaSummary.setQuotaExpired(totalExpiredQuota);
			quotaSummary.setQuotaAvailable(totalAvailableQuota);
			CreditType axisCreditType = CreditTypeTranslator.toAxisRepresentation(creditType);
			quotaSummary.setCreditType(axisCreditType);
			response.addQuotaSummary(quotaSummary);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! Available: "+totalAvailableQuota+", Used: "+totalUsedQuota+", Expired:"+totalExpiredQuota);
		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummary out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse getPolicies(
		edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest getPoliciesRequest
	) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getPolicies inside!");
		GetPoliciesResponse response = new GetPoliciesResponse();

		try {

			//Get request timezone
			String timeZoneId = getPoliciesRequest.getTimeZoneId();
			String timeZoneIdInJava = TimeZoneTools.getTimeZoneIdInJava(timeZoneId);
			TimeZone timeZone = TimeZone.getTimeZone(timeZoneIdInJava);
			//DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] Timezone:"+timeZoneIdInJava);


			List<edu.fiu.cis.acrl.quotasystem.entity.Policy> policies = quotasystemDB.getPolicies();
			Policy[] policiesResponse = new Policy[policies.size()];

			int i = 0;
			for(edu.fiu.cis.acrl.quotasystem.entity.Policy dbpolicy:policies){
				//DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton]"+ dbpolicy.toString());
				Policy policy = PolicyTranslator.toAxisRepresentation(dbpolicy);
				if(policy.getStartDate()!=null){
					policy.setStartDate(TimeZoneTools.changeTimeZoneTo(policy.getStartDate(), timeZone));
				}
				policiesResponse[i++] = policy;
			}
			//DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] Size:"+policiesResponse.length);
			response.setPolicy(policiesResponse);

		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getPolicies out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse getUsers(

	) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getUsers inside!");

		GetUsersResponse response = new GetUsersResponse();

		try {
			List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> users =
				quotasystemDB.getUsers();
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> itrUser =
				users.iterator();
			while(itrUser.hasNext()){
				edu.fiu.cis.acrl.quotasystem.entity.UserProfile user =
					itrUser.next();
				User axisUser = UserTranslator.toAxisRepresentation(user);
				response.addUser(axisUser);
				DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] user "+user.getUsername()+" added!");
			}


		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] "+e.getMessage());

		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] "+e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getUsers out!");

		return response;
	}

	public AddCreditTypeResponse addCreditType(
			edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest addCreditTypeRequest)
			throws InvalidDataFault, DuplicateCreditTypeFault {

		AddCreditTypeResponse response = new AddCreditTypeResponse();

		CreditType creditType = addCreditTypeRequest.getAddCreditTypeRequest();

		try {
			if (!quotasystemDB.isCreditTypeAssigned(creditType.getId())) {
				int id = quotasystemDB.addCreditType(creditType.getName(),
						creditType.getResource(), creditType.getCourseId(),
						creditType.getPolicyId(), creditType.getActive(),
						creditType.getAssignable());
				response.setAddCreditTypeResponse(id);
				return response;
			} else {

				throw new InvalidDataFault(
						"Credit type has been assigned already and can't be modified");
			}

		} catch (Exception e) {
			throw new InvalidDataFault(e.getMessage());

		} catch (Error e) {
			throw new DuplicateCreditTypeFault(e.getMessage());
		}

	}

	public void deleteCreditType(
			edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest deleteCreditTypeRequest)
			throws CreditTypeNotFoundFault, InvalidDataFault {

		int creditTypeId = deleteCreditTypeRequest.getDeleteCreditTypeRequest();
		try {

			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = quotasystemDB
					.getCreditTypeById(creditTypeId);
			if (creditType != null) {
				if (!quotasystemDB.isCreditTypeAssigned(creditType.getId())
						|| !creditType.getActive()) {
					quotasystemDB.deleteCreditType(creditTypeId);

				} else {

					throw new InvalidDataFault("Invalid Data Fault.");
				}

			} else {

				throw new CreditTypeNotFoundFault(
						"Credit Type not Found Fault.");

			}

		} catch (Error e) {
			throw new InvalidDataFault("Invalid Data Fault.");
		}

	}

	public void modifyCreditType(
			edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest modifyCreditTypeRequest)
			throws CreditTypeNotFoundFault, InvalidDataFault,
			DuplicateCreditTypeFault {
		CreditType creditTypeReq = modifyCreditTypeRequest
				.getModifyCreditTypeRequest();

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] modifyCreditType inside!");

		try {

			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = quotasystemDB
					.getCreditTypeById(creditTypeReq.getId());

			if (creditType != null) {

				DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] "+creditType.toString());

				if (!quotasystemDB.isCreditTypeAssigned(creditType.getId())
						|| !creditType.getActive()) {

					DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] credit type has not been assigned and is not active");

					quotasystemDB.modifyCreditType(creditTypeReq.getId(),
							creditTypeReq.getName(),
							creditTypeReq.getResource(),
							creditTypeReq.getCourseId(),
							creditTypeReq.getPolicyId(),
							creditTypeReq.getActive(),
							creditTypeReq.getAssignable());

					DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] modifyCreditType out!");
				} else {
					throw new InvalidDataFault("Credit type has been assigned or is active and cannot be modified.");
				}

			} else {

				throw new CreditTypeNotFoundFault(
						"Credit Type not Found Fault.");

			}

		} catch (Error e) {
			throw new InvalidDataFault("Invalid Data Fault. Credit type does not exist");
		}



	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse getCreditTypes() {

		GetCreditTypesResponse response = new GetCreditTypesResponse();

		try {

			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getCreditTypes inside!");

			List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes = quotasystemDB
					.getCreditTypes();
			CreditType[] creditTypesResponse = new CreditType[creditTypes.size()];
			Policy[] policiesResponse = new Policy[creditTypes.size()];

			int i = 0;
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.CreditType> itr = creditTypes
					.iterator();
			while (itr.hasNext()) {
				edu.fiu.cis.acrl.quotasystem.entity.CreditType dbCreditType =
					itr.next();
				CreditType creditType = CreditTypeTranslator
						.toAxisRepresentation(dbCreditType);

				creditTypesResponse[i] = creditType;

				policiesResponse[i] = PolicyTranslator.toAxisRepresentation(dbCreditType.getPolicy());
				i++;

			}

			response.setCreditType(creditTypesResponse);
			response.setPolicy(policiesResponse);

		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			e.printStackTrace();

		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			e.printStackTrace();
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] getCreditTypes out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse getCreditTypesByCourse(
			edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest getCreditTypesByCourseRequest)
			throws CourseNotFoundFault {

		GetCreditTypesByCourseResponse response = new GetCreditTypesByCourseResponse();
		DebugTools.println(DEBUG_LEVEL,
				"[QuotaSystem - Skeleton] getCreditTypesByCourse Inside!");

		try {
			int[] courseIds = getCreditTypesByCourseRequest.getCourseId();

			List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes = quotasystemDB
					.getCreditTypesByCourse(courseIds);
			CreditType[] creditTypesResponse = new CreditType[creditTypes
					.size()];
			int i = 0;
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.CreditType> itr = creditTypes
					.iterator();
			while (itr.hasNext()) {
				CreditType creditType = CreditTypeTranslator
						.toAxisRepresentation(itr.next());
				creditTypesResponse[i++] = creditType;
			}

			response.setCreditType(creditTypesResponse);

		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			e.printStackTrace();

		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			e.printStackTrace();
		}

		DebugTools.println(DEBUG_LEVEL,
				"[QuotaSystem - Skeleton] getCreditTypesByCourse out!");
		return response;
	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse getCreditTypesByPolicy(
			edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest getCreditTypesByPolicyRequest)
			throws PolicyNotFoundFault {
		GetCreditTypesByPolicyResponse response = new GetCreditTypesByPolicyResponse();
		return response;
	}



	public edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse getPolicyByCreditType(
			edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest getPolicyByCreditTypeRequest)
			throws CreditTypeNotFoundFault {
		GetPolicyByCreditTypeResponse response = new GetPolicyByCreditTypeResponse();

		try {

			int creditTypeId = getPolicyByCreditTypeRequest.getCreditTypeId();
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = quotasystemDB
					.getCreditTypeById(creditTypeId);
			edu.fiu.cis.acrl.quotasystem.entity.Policy policy = quotasystemDB
					.getPolicyById(creditType.getId());
			response.setGetPolicyByCreditTypeResponse(PolicyTranslator
					.toAxisRepresentation(policy));
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}

		return response;
	}

	public AddPolicyResponse addPolicy(
			edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest addPolicyRequest)
			throws InvalidDataFault, DuplicatePolicyFault {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] Add Policy Inside!");

		AddPolicyResponse response = new AddPolicyResponse();

		//Get parameters
		String timeZoneId = addPolicyRequest.getTimeZoneId();
		Policy policy = addPolicyRequest.getPolicy();

		//Get request timezone
		String timeZoneIdInJava = TimeZoneTools.getTimeZoneIdInJava(timeZoneId);
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneIdInJava);
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] USER TIMEZONE " + timeZone.getRawOffset());

		PolicyType type = policy.getPolicyType();

		String name = policy.getName();
		String description = policy.getDescription();
		int quotaInPeriod = policy.getQuotaInPeriod();
		boolean absolute = policy.getAbsolute();
		boolean active = policy.getActive();
		boolean assignable = policy.getAssignable();
		int daysInPeriod = policy.getDaysInPeriod();
		int numberOfPeriods = policy.getNumberOfPeriods();

		//Optional parameters
		int daysToRelStart = 0;;
		Calendar startDate = null;

		if(absolute){
			startDate = policy.getStartDate();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] BEFORE " + startDate.getTimeZone().getRawOffset());
			startDate = TimeZoneTools.changeTimeZoneFrom(startDate, timeZone);
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] AFTER " + startDate.getTimeZone().getRawOffset());

		}else{
			daysToRelStart = policy.getDaysToRelStart();
		}


		try{
			int id = 0;

			if(type.getValue().equals(PolicyType._FIXED)){
				id = quotasystemDB.addFixedPolicy(name, description, startDate, daysInPeriod,daysToRelStart, numberOfPeriods, active, quotaInPeriod, absolute, assignable);

			}else if(type.getValue().equals(PolicyType._GRADUAL)){

				id = quotasystemDB.addGradualPolicy(name, description, startDate, daysInPeriod,daysToRelStart, numberOfPeriods, active, quotaInPeriod,absolute, assignable);

			}else if(type.getValue().equals(PolicyType._MINMAX)){
				int minimum = policy.getMinimum();
				int maximum = policy.getMaximum();
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - instance ] Max: "+maximum+" Min: "+ minimum );
				id = quotasystemDB.addMinMaxPolicy(name, description, startDate, daysInPeriod,daysToRelStart, numberOfPeriods, active, maximum, minimum, quotaInPeriod, absolute, assignable);

			}else if(type.getValue().equals(PolicyType._NOEXPIRATION)){
				id = quotasystemDB.addNoExpirationPolicy(name, description, startDate, daysToRelStart, active, quotaInPeriod, absolute, assignable);

			}

			response.setAddPolicyResponse(id);

		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			e.printStackTrace();
			throw new InvalidDataFault("Invalid Data Fault.");

		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			e.printStackTrace();
			throw new DuplicatePolicyFault("Duplicate Policy Fault");
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] Add Policy out!");
		return response;

	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse getAssignableCreditTypes(

	) {
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] getAssignableCreditTypes Inside!");

		GetAssignableCreditTypesResponse response = new GetAssignableCreditTypesResponse();

		try {

			List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes = quotasystemDB
					.getAssignableCreditTypes();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] credit types found: "+creditTypes.size());
			CreditType[] creditTypesResponse = new CreditType[creditTypes.size()];
			Policy[] policiesResponse = new Policy[creditTypes.size()];

			int i = 0;
			Iterator<edu.fiu.cis.acrl.quotasystem.entity.CreditType> itr = creditTypes
					.iterator();
			while (itr.hasNext()) {
				CreditType creditType = CreditTypeTranslator
						.toAxisRepresentation(itr.next());
				creditTypesResponse[i] = creditType;
				int policyId = creditType.getPolicyId();
				edu.fiu.cis.acrl.quotasystem.entity.Policy policy =
					quotasystemDB.getPolicyById(policyId);
				Policy axisPolicy = PolicyTranslator.toAxisRepresentation(policy);
				policiesResponse[i] = axisPolicy;
				i++;
			}

			response.setCreditType(creditTypesResponse);
			response.setPolicy(policiesResponse);

		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] getAssignableCreditTypes out!");
		return response;
	}

	public AssignQuotaResponse assignQuota(
			edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest assignQuotaRequest)
			throws CreditTypeNotFoundFault, UserNotFoundFault, InvalidDataFault {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] assignQuota Inside!");

		//Initialize response
		AssignQuotaResponse response = new AssignQuotaResponse();

		//Get parameters from request
		Boolean rollback = assignQuotaRequest.getRollback();
		int userId = assignQuotaRequest.getUserId();
		boolean payment = assignQuotaRequest.getPayment();
		QuotaAssignment[] assignments = assignQuotaRequest.getAssignment();
		edu.fiu.cis.acrl.quotasystem.entity.UserProfile user= null;

		try {
			user = quotasystemDB.getUserById(userId);
		} catch (Error e) {
			e.printStackTrace();
			throw new InvalidDataFault(e.getMessage());
		}

		if(user==null){
			throw new UserNotFoundFault("User not found fault");
		}

		List<edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment> localAssignments =
			new ArrayList<edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment>();

		//Initialize flags to check success of all assignments and
		//index of first assignment failed
		boolean[] reserveSuccess = new boolean[assignments.length];
		for(int i=0 ; i<reserveSuccess.length ; i++){
			reserveSuccess[i] = false;
		}
		boolean allSuccess = true;

		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] assignments count "+assignments.length);

		//PART 1: Resource Reservation with Virtual labs web service
		//Iterate through assignments to reserve resource in ve scheduler
		for(int i = 0; i<assignments.length; i++){

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] "+assignments[i]);
			
			//Translate assignment for reserve and cancel resource operations
			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment localAssignment =
				QuotaAssignmentTranslator.toLocalRepresentation(assignments[i]);			

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] "+localAssignment);
			
			//Get assignments values
			int creditTypeId = assignments[i].getCreditTypeId();

			//Get credit type and user for database
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = null;

			try {
				creditType = quotasystemDB.getCreditTypeById(creditTypeId);
			} catch (Error e) {
				e.printStackTrace();
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] "+e.getMessage());
			}

			//Return false if credit type is not found in database,
			//if not, continue to reserve resource
			if (creditType == null) {
				localAssignment.setActive(false);
				reserveSuccess[i] = false;
				allSuccess = false;

			}else{
				localAssignment.setCreditType(creditType);
				localAssignment.setActive(resourceReservation.reserveAssignment(localAssignment, 1));
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] reserved :"+localAssignment.isActive());
				if(!localAssignment.isActive()){
					allSuccess = false;
				}
			}
			reserveSuccess[i]=localAssignment.isActive();
			localAssignments.add(localAssignment);
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] allsuccess :"+allSuccess+" and rollback:"+rollback);

		//Check if rollback is true which would cancel all successful reservations
		//when not all reservations were succedsful
		if( !allSuccess && rollback){
			for(int i=0;i<reserveSuccess.length;i++){
				if(reserveSuccess[i]){
					resourceReservation.cancelAssignment(localAssignments.get(i),1);
				}
			}


		//If rollback was false then procees to save successful assignment reservations in the the system
		}else{
			localAssignments = quotasystemDB.addQuotaAssignments(localAssignments, user, payment);

			//Get failed assignments to cancel reservation
			int i = 0;
			for(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment:localAssignments){
				if(!assignment.isActive() && reserveSuccess[i]){
					resourceReservation.cancelAssignment(assignment, 1);
					reserveSuccess[i] = false;
				}
			}
		}


		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] size:"+localAssignments.size());
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] success:"+Arrays.toString(reserveSuccess));

		// Iterate through assignments array
		for (int i =0;i<reserveSuccess.length;i++) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] "+localAssignments.get(i).toString());
			QuotaAssignment axisAssignment = QuotaAssignmentTranslator.toAxisRepresentation(localAssignments.get(i));
			assignments[i] = axisAssignment;
		}
		response.setAssignment(assignments);

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] assignQuota out!");

		return response;

	}

    public CancelQuotaAssignmentsResponse cancelQuotaAssignments
    (
    		CancelQuotaAssignmentsRequest cancelQuotaAssignmentsRequest
    )
	throws CreditTypeNotFoundFault,UserNotFoundFault,InvalidDataFault{

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] cancelQuotaAssignments Inside!");

		//Initialize response
	  	CancelQuotaAssignmentsResponse response = new CancelQuotaAssignmentsResponse();

		QuotaAssignment[] assignments = cancelQuotaAssignmentsRequest.getAssignment();


		for(int i =0; i<assignments.length;i++){

		  	//Get request parameters
		  	int creditTypeId = assignments[i].getCreditTypeId();
		  	String purchaseId = assignments[i].getPurchaseId();

			try{
				edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota u =
					quotasystemDB.getUserAssignedQuotaByPurchaseAndCreditType(
											assignments[i].getPurchaseId(),
											assignments[i].getCreditTypeId());

				float percentageReturned = 0;
				if(u != null){
					float returnableQuota = u.getRemainingQuota();
					percentageReturned =(returnableQuota*100)/u.getInitialQuota();
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] Periods :"+u.getCreditType().getPolicy().getNumberOfPeriods()+" Current Period:"+u.getCurrentPeriodNumber());
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] Returnable quota :"+returnableQuota+" is the "+percentageReturned+"% of "+u.getInitialQuota());
				}
				assignments[i].setPercentageReturned(percentageReturned);

				//Translate assignment for reserve and cancel resource operations
				edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment localAssignment =
					QuotaAssignmentTranslator.toLocalRepresentation(assignments[i]);
				localAssignment.setCreditType(quotasystemDB.getCreditTypeById(creditTypeId));

				//Cancel resource reservation made for this assignment
				resourceReservation.cancelAssignment(localAssignment, 1);

				//Cancel user assigned quota
				quotasystemDB.cancelQuota(creditTypeId, purchaseId);

				assignments[i].setActive(false);

			}catch(Exception e){
				e.printStackTrace();
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] "+e.getMessage());

			}

		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] cancelQuotaAssignments out!");
		response.setAssignment(assignments);
    	return response;
	}



	public void addCourse(
			edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest addCourseRequest)
			throws DuplicateCourseFault, InvalidDataFault {

		Course courseReq = addCourseRequest.getAddCourseRequest();
		edu.fiu.cis.acrl.quotasystem.entity.Course course = null;

		try {
			course = quotasystemDB.getCourseById(courseReq.getId());
		} catch (Error e) {
			throw new InvalidDataFault(e.getMessage());
		}

		if (course == null) {
			try {
				quotasystemDB.addCourse(courseReq.getId(), courseReq.getShortname(),courseReq.getFullname());

			} catch (Error e) {
				throw new InvalidDataFault(e.getMessage());
			}

		} else {
			throw new DuplicateCourseFault("Duplicate Course Fault");
		}

	}

	public void modifyCourse(
			edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest modifyCourseRequest)
			throws DuplicateCourseFault, CourseNotFoundFault, InvalidDataFault {

		Course courseReq = modifyCourseRequest.getModifyCourseRequest();
		edu.fiu.cis.acrl.quotasystem.entity.Course course = null;

		try {
			course = quotasystemDB.getCourseById(courseReq.getId());
		} catch (Error e) {
			throw new InvalidDataFault(e.getMessage());
		}

		if (course != null) {
			try {
				// quotasystemDB.modifyCourse(course.getId(),
				// 		course.getShortname(), course.getFullname());
				quotasystemDB.modifyCourse(courseReq.getId(),
						courseReq.getShortname(), courseReq.getFullname());

			} catch (Error e) {
				throw new InvalidDataFault(e.getMessage());
			}

		} else {
			edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest addCourseRequest =
				new edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest();
			addCourseRequest.setAddCourseRequest(modifyCourseRequest.getModifyCourseRequest());
			addCourse(addCourseRequest);
			// throw new CourseNotFoundFault("Course not Found Fault");
		}

	}

	public void deleteCourse(
			edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest deleteCourseRequest)
			throws CourseNotFoundFault {
		try {
			int courseId = deleteCourseRequest.getDeleteCourseRequest();
			quotasystemDB.deleteCourse(courseId);

		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			throw new CourseNotFoundFault(e.getMessage());
		} catch (Exception e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());

		}

	}

	public void deletePolicy(
			edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest deletePolicyRequest)
			throws PolicyNotFoundFault {

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] deletePolicy Inside!");

			try {
				int policyId = deletePolicyRequest.getDeletePolicyRequest();

				List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes =
					quotasystemDB.getCreditTypesByPolicy(policyId);

				if(creditTypes.size()==0){
					quotasystemDB.deletePolicy(policyId);
				}else{
					throw new PolicyNotFoundFault("Policy is already in use and cannot be deleted.");
				}

			} catch (Error e) {
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
				throw new PolicyNotFoundFault(e.getMessage());
			}

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] deletePolicy out!");

	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse getUsersByCourse(
			edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest getUsersByCourseRequest)
			throws CourseNotFoundFault {

		GetUsersByCourseResponse response = new GetUsersByCourseResponse();
		return response;
	}

	public AssignQuotaToCourseResponse assignQuotaToCourse(
			edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest assignQuotaToCourseRequest)
			throws CreditTypeNotFoundFault, CourseNotFoundFault,
			InvalidDataFault {

		AssignQuotaToCourseResponse response = new AssignQuotaToCourseResponse();

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] assignQuotaToCourse Inside!");

		QuotaAssignment[] assignmentsAxis = assignQuotaToCourseRequest.getAssignment();

		//Initialize list to hold all reserved assignments and assignment translated to local class
		edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[] assignments =
			new edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[assignmentsAxis.length];

		for(int i =0; i<assignmentsAxis.length;i++){
			QuotaAssignment assignment = assignmentsAxis[i];
			int creditTypeId = assignment.getCreditTypeId();

			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment localAssignment =
				QuotaAssignmentTranslator.toLocalRepresentation(assignment);

			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = null;

			try {
				creditType = quotasystemDB.getCreditTypeById(creditTypeId);
				if (creditType == null) {
					throw new CreditTypeNotFoundFault("Credit Type not Found Fault.");

				}else{
					localAssignment.setCreditType(creditType);
				}
			} catch (Error e) {
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
				e.printStackTrace();
				throw new InvalidDataFault("Invalid Data Fault.");
			}
			assignments[i] = localAssignment;
		}

		boolean[] reserveSuccess = new boolean[assignments.length];

		for(int i=0 ; i<reserveSuccess.length ; i++){
			reserveSuccess[i] = false;
		}

		//Initialize flags to check success of all assignments and
		//index of first assignment failed
		boolean allSuccess = true;

		for(int i =0; i<assignments.length;i++){
			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment = assignments[i];
			String purchaseId = assignment.getPurchaseId();

			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignment.getCreditType();

			//Get students enrolled in that class
			List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> students =
				quotasystemDB.getNewStudents(purchaseId, creditType);

			reserveSuccess[i] = resourceReservation.reserveAssignment(assignment, students.size());

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] reserved :"+reserveSuccess[i]);

			if(!reserveSuccess[i]){
				allSuccess = false;
				break;
			}

		}

		//if there are enough resources, proceed to assign quota to all users enrolled in the course
		if(allSuccess){
			for(int i =0; i<assignments.length;i++){
				edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment = assignments[i];

				edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignment.getCreditType();
				float quantity = assignment.getQuantity();
				String purchaseId = assignment.getPurchaseId();

				// If policy is assigned, set the respective start date of first
				// period and end date of last period
				Timestamp startDateTs = new Timestamp(System.currentTimeMillis());
				edu.fiu.cis.acrl.quotasystem.entity.Policy policy = creditType.getPolicy();

				// Get start date in case policy is absolute, or add the
				// daysToRelStartfrom today in case of relative
				if (policy.getAbsolute()) {
					startDateTs = policy.getStartDate();
				} else {
					Calendar startDate = Calendar.getInstance();
					startDate.setTime(startDateTs);
					startDate.add(Calendar.DAY_OF_MONTH, policy.getDaysToRelStart());
					startDateTs.setTime(startDate.getTimeInMillis());
				}


				//Save course assigned quota
				quotasystemDB.assignQuotaToCourse(creditType.getId(), quantity, purchaseId, startDateTs);

				//Get students enrolled in that class
				List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> students =
					quotasystemDB.getNewStudents(purchaseId, creditType);

				//Iterate through students
				for(edu.fiu.cis.acrl.quotasystem.entity.UserProfile student:students){
					try {

						//DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] Credit type: "+creditType.getId());
						//DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] quotaRequestedInMinutes: "+quantity);
						//DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] periodStartDate: "+startDateTs.toString());
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] student: "+student.getUsername());
						quotasystemDB.assignQuota(creditType.getId(), student.getId(), quantity,
								true, startDateTs, purchaseId, false);

					} catch (Error e) {
						DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton]" + e.getMessage());
						e.printStackTrace();
						reserveSuccess[i] = false;
					}
				}
			}
		}else{

			for(int i =0; i<assignments.length;i++){
				if(reserveSuccess[i]){
					//Get students enrolled in that class
					List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> students =
						quotasystemDB.getNewStudents(assignments[i].getPurchaseId(), assignments[i].getCreditType());
					resourceReservation.cancelAssignment(assignments[i], students.size());
				}
			}
		}

		for(int i =0; i<assignmentsAxis.length;i++){
			assignmentsAxis[i].setActive(reserveSuccess[i]);
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] assignQuotaToCourse out");
		response.setAssignment(assignmentsAxis);
		return response;

	}


    public ModifyCourseQuotaResponse modifyCourseQuota
    	(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest modifyCourseQuotaRequest)
		throws CreditTypeNotFoundFault,CourseNotFoundFault,InvalidDataFault{

    	ModifyCourseQuotaResponse response = new ModifyCourseQuotaResponse();

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] modifyCourseQuota Inside!");

		//Get request parameters
		QuotaAssignment[] assignmentsAxis = modifyCourseQuotaRequest.getAssignment();

		//Initialize list to hold all reserved assignments and assignment translated to local class
		edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[] assignments =
			new edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[assignmentsAxis.length];

		boolean[] reserveSuccess = new boolean[assignments.length];

		for(int i=0 ; i<reserveSuccess.length ; i++){
			reserveSuccess[i] = false;
		}

		for(int i =0; i<assignmentsAxis.length;i++){

			QuotaAssignment assignment = assignmentsAxis[i];
			int creditTypeId = assignment.getCreditTypeId();

			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment localAssignment =
				QuotaAssignmentTranslator.toLocalRepresentation(assignment);

			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = null;

			try {
				creditType = quotasystemDB.getCreditTypeById(creditTypeId);
				if (creditType == null) {
					throw new CreditTypeNotFoundFault("Credit Type not Found Fault.");
				}else{
					localAssignment.setCreditType(creditType);
				}
			} catch (Error e) {
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
				e.printStackTrace();
				throw new InvalidDataFault("Invalid Data Fault.");
			}
			assignments[i] = localAssignment;

			//If something was used return the request
			if(quotasystemDB.isQuotaAssignmentUsed(localAssignment)){
				response.setAssignment(assignmentsAxis);
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] already in use... out!");
				return response;
			}
		}

		//Save copy of original assignments
		edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[] assignmentsOriginal =
			new edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[assignmentsAxis.length];
		float[] qtyDiff = new float[assignmentsAxis.length];

		for(int i =0; i<assignmentsAxis.length;i++){
			String purchaseId = assignmentsAxis[i].getPurchaseId();
			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignmentOriginal =
				new edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment();
			//get quantity and credit type in original assignment
			
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] "+purchaseId+"-"+assignmentsAxis[i].getCreditTypeId());
			float qtyOrig = (float)quotasystemDB.getUserAssignedQuotaByPurchaseAndCreditType(purchaseId,assignmentsAxis[i].getCreditTypeId()).getQuantity();
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditTypeOrig =
				quotasystemDB.getCreditTypeById(assignmentsAxis[i].getCreditTypeId());
			assignmentOriginal.setQuantity(qtyOrig);
			assignmentOriginal.setCreditType(creditTypeOrig);
			assignmentsOriginal[i]=assignmentOriginal;
			qtyDiff[i]= assignmentsAxis[i].getQuantity() - assignmentOriginal.getQuantity();
		}

		//Initialize flags to check success of all assignments and
		//index of first assignment failed
		boolean allSuccess = true;

		for(int i =0; i<assignmentsOriginal.length;i++){

			//Get students enrolled in that course
			List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile>students =
				assignmentsOriginal[i].getCreditType().getCourse().getUserProfiles();
//			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignmentsToReserve =
//				QuotaAssignmentTranslator.toLocalRepresentation(assignmentsAxis[i]);

			
			if(qtyDiff[i]>0){
				assignmentsOriginal[i].setQuantity(qtyDiff[i]);
				reserveSuccess[i] = resourceReservation.reserveAssignment(assignmentsOriginal[i], students.size());
				if(!reserveSuccess[i]){
					allSuccess = false;
					break;

				}

			}else if(qtyDiff[i]<0){
				assignmentsOriginal[i].setQuantity(Math.abs(qtyDiff[i]));
				resourceReservation.cancelAssignment(assignmentsOriginal[i], students.size());
				reserveSuccess[i] = true;
			}

		}


		if(allSuccess){

			for(int i=0; i<assignmentsOriginal.length;i++){

				edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignmentsOriginal[i].getCreditType();
				Float quantity = assignmentsAxis[i].getQuantity();
				String purchaseId = assignmentsAxis[i].getPurchaseId();
				

				//If policy is assigned, set the start date of first period and end date of last period
				Timestamp startDateTs = new Timestamp(System.currentTimeMillis());
				edu.fiu.cis.acrl.quotasystem.entity.Policy policy =
					assignmentsOriginal[i].getCreditType().getPolicy();
				if (policy != null) {
					if (policy.getAbsolute()){
						startDateTs = policy.getStartDate();
					}
				}

				//Modify quota in database
				quotasystemDB.modifyCourseQuota(purchaseId, creditType.getId(), quantity, startDateTs);

				try {
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] PurchaseId: "+purchaseId);
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] Credit type: "+creditType.getId());
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] quantity: "+ quantity);
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] periodStartDate: "+startDateTs.toString());
					quotasystemDB.modifyQuota(creditType.getId(), quantity, startDateTs,purchaseId);

				} catch (Error e) {
					DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton]" + e.getMessage());
					e.printStackTrace();

				}

			}

		}else{

			for(int i =0; i<assignmentsOriginal.length;i++){
				edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignmentsToReserve =
					QuotaAssignmentTranslator.toLocalRepresentation(assignmentsAxis[i]);
				assignmentsToReserve.setCreditType(assignmentsOriginal[i].getCreditType());
				assignmentsToReserve.setQuantity(qtyDiff[i]);
				if(reserveSuccess[i]){
					assignmentsToReserve.setQuantity(qtyDiff[i]);
					resourceReservation.cancelAssignment(assignmentsToReserve,
							assignmentsToReserve.getCreditType().getCourse().getUserProfiles().size());

				}
			}
		}

		for(int i =0; i<assignmentsAxis.length;i++){
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] assignment:"+i+" active:"+reserveSuccess[i]);
			assignmentsAxis[i].setActive(reserveSuccess[i]);
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] modifyCourseQuota out!");
		response.setAssignment(assignmentsAxis);
		return response;

	}


    public CancelCourseQuotaResponse cancelCourseQuota
    (
    edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest cancelCourseQuotaRequest
    )
	throws CreditTypeNotFoundFault,CourseNotFoundFault,InvalidDataFault{

    	CancelCourseQuotaResponse response = new CancelCourseQuotaResponse();

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton] cancelCourseQuota Inside!");


		//Get request parameters
		QuotaAssignment[] assignmentsAxis = cancelCourseQuotaRequest.getAssignment();

		//Initialize list to hold all reserved assignments and assignment translated to local class
		edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[] assignments =
			new edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[assignmentsAxis.length];

		boolean[] reserveSuccess = new boolean[assignments.length];

		for(int i=0 ; i<reserveSuccess.length ; i++){
			reserveSuccess[i] = false;
		}

		for(int i =0; i<assignmentsAxis.length;i++){
			QuotaAssignment assignment = assignmentsAxis[i];
			int creditTypeId = assignment.getCreditTypeId();

			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment localAssignment =
				QuotaAssignmentTranslator.toLocalRepresentation(assignment);

			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = null;

			try {
				creditType = quotasystemDB.getCreditTypeById(creditTypeId);
				if (creditType == null) {
					throw new CreditTypeNotFoundFault("Credit Type not Found Fault.");
				}else{
					localAssignment.setCreditType(creditType);
				}
			} catch (Error e) {
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
				e.printStackTrace();
				throw new InvalidDataFault("Invalid Data Fault.");
			}
			assignments[i] = localAssignment;

			//If something was used return the request
			if(quotasystemDB.isQuotaAssignmentUsed(localAssignment)){
				response.setAssignment(assignmentsAxis);
				return response;
			}
		}


		//Save copy of original assignments
		edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[] assignmentsOriginal =
			new edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment[assignmentsAxis.length];

		for(int i =0; i<assignmentsAxis.length;i++){
			String purchaseId = assignmentsAxis[i].getPurchaseId();
			int creditTypeId = assignmentsAxis[i].getCreditTypeId();

			edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignmentOriginal =
				QuotaAssignmentTranslator.toLocalRepresentation(assignmentsAxis[i]);

			//get quantity and credit type in original assignment
			edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota origAssignedQuota=
				quotasystemDB.getUserAssignedQuotaByPurchaseAndCreditType(purchaseId, creditTypeId);

			float qtyOrig = (float)origAssignedQuota.getQuantity();
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditTypeOrig =
				origAssignedQuota.getCreditType();
			assignmentOriginal.setQuantity(qtyOrig);
			assignmentOriginal.setCreditType(creditTypeOrig);
			assignmentsOriginal[i]=assignmentOriginal;
		}


		for(int i =0; i<assignmentsOriginal.length;i++){

			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignmentsOriginal[i].getCreditType();
			Float quantity = assignmentsOriginal[i].getQuantity();
			String purchaseId = assignmentsOriginal[i].getPurchaseId();

			quotasystemDB.cancelCourseQuota(purchaseId, creditType.getId());

			//Get students enrolled in that course
			List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile>students =
				assignmentsOriginal[i].getCreditType().getCourse().getUserProfiles();
				resourceReservation.cancelAssignment(assignmentsOriginal[i], students.size());
				quotasystemDB.cancelQuota(assignmentsOriginal[i].getCreditType().getId(),
						assignmentsOriginal[i].getPurchaseId());
		}

		for(int i =0; i<assignmentsAxis.length;i++){
			assignmentsAxis[i].setActive(false);
		}

		response.setAssignment(assignmentsAxis);
		return response;

	}


	public void addUser(
			edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest addUserRequest)
			throws InvalidDataFault, DuplicateUserFault {

		User newUser = addUserRequest.getAddUserRequest();
		edu.fiu.cis.acrl.quotasystem.entity.UserProfile user = null;

		try {
			user = quotasystemDB.getUserById(newUser.getId());
		} catch (Error e) {

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			throw new InvalidDataFault(e.getMessage());
		}

		if (user == null) {
			try {
				quotasystemDB.addUser(newUser.getId(), newUser.getUsername(),
						newUser.getEmail());

			} catch (Error e) {

				DebugTools.println(DEBUG_LEVEL,
						"[QuotaSystem - Skeleton]" + e.getMessage());
				throw new InvalidDataFault(e.getMessage());
			}

		} else {
			throw new DuplicateUserFault("Duplicate User Fault");
		}

	}

	public edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse getHistoricQuotaSummaryPerUsers(
			edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest getHistoricQuotaSummaryPerUsersRequest)
			throws CreditTypeNotFoundFault, InvalidDataFault {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryPerUsers Inside!");

		GetHistoricQuotaSummaryPerUsersResponse response = new GetHistoricQuotaSummaryPerUsersResponse();
		int periodNo = getHistoricQuotaSummaryPerUsersRequest.getPeriodNumber();
		int creditTypeId = getHistoricQuotaSummaryPerUsersRequest.getCreditTypeId();
		edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType =
			quotasystemDB.getCreditTypeById(creditTypeId);


		int[] courses = new int[1];
		int courseId = creditType.getCourse().getId();
		courses[0]= courseId;
		List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> users =
				quotasystemDB.getUsersByCourse(courses);

		List<Integer> periods = new ArrayList<Integer>();

		if(periodNo>0){
			periods.add(periodNo);

		}else{
			int numberOfPeriods = creditType.getPolicy().getNumberOfPeriods();
			periodNo = 1;
			while(periodNo<=numberOfPeriods){
				periods.add(periodNo++);
			}
		}

		Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> itrUsers =
			users.iterator();
		while(itrUsers.hasNext()){

			int totalExpiredQuota = 0;
			int totalUsedQuota = 0;
			int totalAvailableQuota = 0;
			edu.fiu.cis.acrl.quotasystem.entity.UserProfile user= itrUsers.next();

			List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuotas =
				quotasystemDB.getUserAssignedQuota(creditType.getId(), user.getId());

			Iterator<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> itrAssignedQuota =
				assignedQuotas.iterator();
			while(itrAssignedQuota.hasNext()){
				edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota assignedQuota =
					itrAssignedQuota.next();
				Iterator<Integer> itrPeriods = periods.iterator();
				while(itrPeriods.hasNext()){
					periodNo = itrPeriods.next();
					int usedQuota = assignedQuota.getUsedQuotaInPeriod(periodNo);
					int expiredQuota = assignedQuota.getExpiredQuotaInPeriod(periodNo);
					totalUsedQuota += usedQuota;
					totalExpiredQuota += expiredQuota;
					totalAvailableQuota += assignedQuota.getMaxQuotaInPeriod() - usedQuota - expiredQuota;
				}

			}

			QuotaSummary quotaSummary = new QuotaSummary();
			quotaSummary.setQuotaUsed(totalUsedQuota);
			quotaSummary.setQuotaExpired(totalExpiredQuota);
			quotaSummary.setQuotaAvailable(totalAvailableQuota);
			CreditType axisCreditType = CreditTypeTranslator.toAxisRepresentation(creditType);
			quotaSummary.setCreditType(axisCreditType);
			User axisUser = UserTranslator.toAxisRepresentation(user);
			quotaSummary.setUser(axisUser);
			response.addQuotaSummary(quotaSummary);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! User: "+user.getUsername()+" Available: "+totalAvailableQuota+", Used: "+totalUsedQuota+", Expired:"+totalExpiredQuota);

		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryPerUsers out!");
		return response;
	}


	public GetHistoricQuotaSummaryByUserResponse getHistoricQuotaSummaryByUser(
			GetHistoricQuotaSummaryByUserRequest getHistoricQuotaSummaryByUserRequest)
			throws CourseNotFoundFault,UserNotFoundFault{
		GetHistoricQuotaSummaryByUserResponse response = new GetHistoricQuotaSummaryByUserResponse();

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryByUser inside!");
		//get request
		int userId = getHistoricQuotaSummaryByUserRequest.getUserId();
		int courseId = getHistoricQuotaSummaryByUserRequest.getCourseId();

		edu.fiu.cis.acrl.quotasystem.entity.UserProfile user = null;
		List<edu.fiu.cis.acrl.quotasystem.entity.CreditType> creditTypes =
			new ArrayList<edu.fiu.cis.acrl.quotasystem.entity.CreditType>();


		//validate request
		try{

			user =quotasystemDB.getUserById(userId);
			if(user==null){
				throw new UserNotFoundFault("User Not Found Fault");
			}else{
				user.setUserAssignedQuotas(quotasystemDB.getUserAssignedQuotaByUser(user));

				if(courseId>0){
					edu.fiu.cis.acrl.quotasystem.entity.Course course =
						quotasystemDB.getCourseById(courseId);

					if(course==null){
						throw new CourseNotFoundFault("Course Not Found Fault");
					}else{
						int[] courses = new int[1];
						courses[0]= course.getId();
						creditTypes =quotasystemDB.getCreditTypesByCourse(courses);
					}
				}else{
					int[] courses = quotasystemDB.getCourseIdsByUserId(userId);
					creditTypes = quotasystemDB.getCreditTypesByCourse(courses);
				}
			}
		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			throw new UserNotFoundFault(e.getMessage());
		}


		//calculate data for each credit type
		for(edu.fiu.cis.acrl.quotasystem.entity.CreditType ct:creditTypes){

			QuotaSummary qs = new QuotaSummary();
			List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuota =
				new ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota>();
			assignedQuota= quotasystemDB.getUserAssignedQuota(ct.getId(),user.getId());



			int numberOfPeriods = ct.getPolicy().getNumberOfPeriods();

			int totalExpiredQuota = 0;
			int totalUsedQuota = 0;
			int totalAvailableQuota = 0;

			for(edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota uaq:assignedQuota){
				for(int periodNo =1;periodNo<=numberOfPeriods;periodNo++){
					int usedQuota = uaq.getUsedQuotaInPeriod(periodNo);
					int expiredQuota = uaq.getExpiredQuotaInPeriod(periodNo);
					int availableQuota = uaq.getQuotaInPeriod() - usedQuota - expiredQuota;
					totalUsedQuota += usedQuota;
					totalExpiredQuota += expiredQuota;
					totalAvailableQuota += availableQuota;
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Period("+periodNo+") ] A:" + availableQuota + ", E: "+expiredQuota + ", U: "+ usedQuota);
					}

			}
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Total("+ct.getName()+") ] A:" + totalAvailableQuota + ", E: "+totalExpiredQuota + ", U: "+ totalUsedQuota);

			qs.setCreditType(CreditTypeTranslator.toAxisRepresentation(ct));
			qs.setQuotaExpired(totalExpiredQuota);
			qs.setQuotaUsed(totalUsedQuota);
			qs.setQuotaAvailable(totalAvailableQuota);
			response.addQuotaSummary(qs);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! Available: "+totalAvailableQuota+", Used: "+totalUsedQuota+", Expired:"+totalExpiredQuota);


		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryByUser out!");
		return response;
	}

	public GetHistoricQuotaSummaryByUserAndCreditTypeResponse getHistoricQuotaSummaryByUserAndCreditType(
			GetHistoricQuotaSummaryByUserAndCreditTypeRequest getHistoricQuotaSummaryByUserAndCreditTypeRequest)
			throws CreditTypeNotFoundFault,UserNotFoundFault{
		GetHistoricQuotaSummaryByUserAndCreditTypeResponse response = new GetHistoricQuotaSummaryByUserAndCreditTypeResponse();

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryByUserAndCreditType inside!");

		//get request
		int userId = getHistoricQuotaSummaryByUserAndCreditTypeRequest.getUserId();
		int creditTypeId = getHistoricQuotaSummaryByUserAndCreditTypeRequest.getCreditTypeId();
		String timeZoneId = getHistoricQuotaSummaryByUserAndCreditTypeRequest.getTimeZoneId();

		//Get request timezone
		String timeZoneIdInJava = TimeZoneTools.getTimeZoneIdInJava(timeZoneId);
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneIdInJava);

		edu.fiu.cis.acrl.quotasystem.entity.UserProfile user = null;
		edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = null;

		//validate request
		try{

			user = quotasystemDB.getUserById(userId);

			if(user==null){
				throw new UserNotFoundFault("User Not Found Fault");

			}else{

				creditType = quotasystemDB.getCreditTypeById(creditTypeId);
				if(creditType==null){
					throw new CreditTypeNotFoundFault("Credit Type Not Found Fault");
				}

			}
		} catch (Error e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - Skeleton]" + e.getMessage());
			throw new UserNotFoundFault(e.getMessage());
		}

		List<edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota> assignedQuota =
			quotasystemDB.getUserAssignedQuota(creditTypeId, userId);
		boolean periodLabel = true; //true when absolute or relative with only one assignedQuota, false otherwise
		boolean absolute = creditType.getPolicy().getAbsolute();

		if(!absolute && assignedQuota.size()>1)
			periodLabel = false;
		
		int numberOfPeriods = creditType.getPolicy().getNumberOfPeriods();

		Format formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		for(int periodNo = 1 ; periodNo <= numberOfPeriods ; periodNo++){
			boolean labeled = false;
			int totalExpiredQuota = 0;
			int totalUsedQuota = 0;
			int totalAvailableQuota = 0;
			String label = "";
			QuotaSummary qs = new QuotaSummary();

			for(edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota uaq:assignedQuota){
				int currentPeriodNumber = uaq.getCurrentPeriodNumber();
				int available = 0; //Available
				int used = 0; //Used/Being Used/Reserved
				int expired = 0; //Expired/To Expire
				
				//Past periods
				if(periodNo < currentPeriodNumber){
					used = uaq.getUsedQuotaPerPeriod(periodNo);
					expired = uaq.getExpiredQuotaPerPeriod(periodNo);
					
				//Current Period
				}else if(periodNo == currentPeriodNumber){
					used = uaq.getUsedQuotaPerPeriod(periodNo);
					expired = uaq.getToExpireQuotaInPeriod(periodNo);
					available = uaq.getAvailableQuotaPerPeriod(periodNo);
					
				//Future Periods
				}else if(periodNo > currentPeriodNumber){
					used = uaq.getUsedQuotaPerPeriod(periodNo);
					available = uaq.getAvailableQuotaPerPeriod(periodNo);
					
				}
				
				totalAvailableQuota += available;
				totalUsedQuota += used;
				totalExpiredQuota += expired;
				
				if(!labeled){
					Calendar endDate = Calendar.getInstance();
					endDate.setTime(uaq.getPolicyPeriodEndDate(periodNo));
					endDate.add(Calendar.MINUTE, -1);

					Calendar startDate = Calendar.getInstance();
					startDate.setTime(uaq.getPolicyPeriodStartDate(periodNo));
					startDate =  TimeZoneTools.changeTimeZoneTo(startDate, timeZone);
					endDate = TimeZoneTools.changeTimeZoneTo(endDate, timeZone);

					label = formatter.format(startDate.getTime())+" - "+formatter.format(endDate.getTime());
					if(uaq.getCreditType().getPolicy().getPolicyType().equalsIgnoreCase("NOEXPIRATION"))
						label = formatter.format(startDate.getTime())+" - &infin;";
					labeled = true;
				}

			}

			qs.setCreditType(CreditTypeTranslator.toAxisRepresentation(creditType));
			qs.setQuotaExpired(totalExpiredQuota);
			qs.setQuotaUsed(totalUsedQuota);
			qs.setQuotaAvailable(totalAvailableQuota);
			qs.setPeriodNumber(periodNo);
			qs.setLabel(label);
			response.addQuotaSummary(qs);
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] new quota summary added! Available: "+totalAvailableQuota+", Used: "+totalUsedQuota+", Expired:"+totalExpiredQuota);

		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - Skeleton] getHistoricQuotaSummaryByUserAndCreditType out!");
		return response;
	}

	public GetCreditTypesByUserResponse getCreditTypesByUser(GetCreditTypesByUserRequest getCreditTypesByUserRequest)
		throws UserNotFoundFault {
		GetCreditTypesByUserResponse response = new GetCreditTypesByUserResponse();


		return response;
	}

	/**
	 * Free resources
	 */
	public void shutDown() {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - shutDown] Inside!");

		quotasystemDB.close();

		System.out.println(">> Shutting Down QuotaSystem ...");

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - shutDown] Ready to get out!");

	}

	/**
	 *
	 */
	public void startUp() {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - startUp] Inside!");

		System.out.println(">> Starting QuotaSystem ...");

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - startUp] Ready to get out!");

	}

}