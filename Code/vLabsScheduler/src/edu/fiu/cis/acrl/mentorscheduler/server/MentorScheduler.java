package edu.fiu.cis.acrl.mentorscheduler.server;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import edu.fiu.cis.acrl.mentorscheduler.server.db.MentorSchedulerDB;
import edu.fiu.cis.acrl.mentorscheduler.server.tools.debug.DebugTools;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringScheduleBySchIdRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringScheduleBySchIdResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.ReserveResourceRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.ReserveResourceResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.AddMentorRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.AddMentorResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.AssignMentorToCourseRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.AssignMentorToCourseResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.CancelScheduledMentorUnallocatedWorktimeRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.CancelScheduledMentorUnallocatedWorktimeResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.CancelScheduledMentoringRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.CancelScheduledMentoringResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.DelMentorRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.DelMentorResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetConfigurationResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorListRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorListResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorScheduledUnallocatedWorktimeRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorScheduledUnallocatedWorktimeResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeAvailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeAvailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeUnavailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeUnavailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringAvailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringAvailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringScheduleRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringScheduleResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringUnavailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringUnavailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetRandomMentorRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetRandomMentorResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.ModifyScheduledMentorUnallocatedWorktimeRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.ModifyScheduledMentorUnallocatedWorktimeResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.ModifyScheduledMentoringRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.ModifyScheduledMentoringResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.ScheduleMentorUnallocatedWorktimeRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.ScheduleMentorUnallocatedWorktimeResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.ScheduleMentoringRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.ScheduleMentoringResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.SetConfigurationRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.SetConfigurationResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.SetMentorStatusRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.SetMentorStatusResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.UnassignMentorToCourseRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.UnassignMentorToCourseResponse;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriodTools;
import edu.fiu.cis.acrl.tools.timeperiod.ScheduledEvent;
import edu.fiu.cis.acrl.vescheduler.server.VEInstanceSchedule;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse;

public class MentorScheduler { 

	// Debug level for this class
	private static int DEBUG_LEVEL = 1;
	
	private MentorSchedulerDB mentorSchDB;
	private MentorSchedulerSettings settings;
	private Configuration config;
	
	/**
	 * Constructor is protected
	 * 
	 */
	protected MentorScheduler() {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - Constructor] Inside!");
		
		this.mentorSchDB = new MentorSchedulerDB();
		
		settings= MentorSchedulerSettings.instance();
		    
		DebugTools.println(DEBUG_LEVEL,  "[MentorScheduler] Settings!" + settings.getDbUser() + 
				settings.getDbPassword() + settings.getDbHost() + 
				settings.getDbName());

		mentorSchDB.connect(settings.getDbUser(), settings.getDbPassword(), 
				settings.getDbHost(), settings.getDbName());
		
		config = mentorSchDB.getConfiguration();
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler] Configuration from DB: " + config);

		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - Constructor] Ready to get out!");
		
	}
	
	public void startUp() {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - startUp] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - startUp] Ready to get out!");
		
	}
	
    /**
     * Free resources
     */
    public void shutDown() {
	
    	DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - shutDown] Inside!");
		
    	mentorSchDB.close();
    
    	DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - shutDown] Ready to get out!");
	  
    }

	/**
	 * A handle to the unique Singleton instance.
	 */
	static private MentorScheduler _instance = null;
	
	/**
	 * @return The unique instance of this class.
	 */
	static public MentorScheduler instance() {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - instance] Inside!");
		
		if(null == _instance) {
			_instance = new MentorScheduler();
	    }
	    
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - instance] Ready to get out!");
		
		return _instance;
	   
	}
	
	public ReserveResourceResponse reserveResource(
			ReserveResourceRequest reserveResourceRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - reserveResource] Inside!");
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		
		ReservedResource reservedResource = 
			new ReservedResource(
					reserveResourceRequest.getCourseId(),
					reserveResourceRequest.getTimePeriod().getStartTime(),
					reserveResourceRequest.getTimePeriod().getEndTime(),
					reserveResourceRequest.getQuota(),
					reserveResourceRequest.getCancel());
		
		if (mentorSchDB.reserveResource(reservedResource)) {

			response.setSuccess(true);
			response.setReason("Successful!");
		
		}
		else {
			
			response.setSuccess(false);
			response.setReason("Not Successful!");
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - reserveResource] Ready to get out!");
		
		return response;
		
	}
	
	/**
	 * 
	 * @param userStartTime
	 * @return
	 */
    private Calendar fixUserStartTime(Calendar userStartTime) {
		
    	Calendar fixedStartTime = (Calendar)userStartTime.clone();
    	
    	Configuration config = mentorSchDB.getConfiguration();
    	if (fixedStartTime.compareTo(config.getUserStartTime()) < 0) {
    		
    		fixedStartTime = (Calendar)config.getUserStartTime().clone();
    	
    	}
    		
    	Calendar now = Calendar.getInstance();
    	if (fixedStartTime.compareTo(now) < 0) {
    		
    		fixedStartTime = (Calendar)now.clone();
    	
    	}
    	
    	return fixedStartTime;

    }

    /**
     * 
     * @param userEndTime
     * @return
     */
	private Calendar fixUserEndTime(Calendar userEndTime) {
    
		Calendar fixedEndTime = (Calendar)userEndTime.clone();
    	
    	Configuration config = mentorSchDB.getConfiguration();
    	if (fixedEndTime.compareTo(config.getUserEndTime()) > 0) {
    		
    		fixedEndTime = (Calendar)config.getUserEndTime().clone();
    	
    	}
    		
    	return fixedEndTime;

	}

	/**
	 * 
	 * @param mentorUsername
	 * @param studentUsername
	 * @param courseId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private synchronized boolean isScheduleMentoringRequestValid(
			String mentorUsername,
			String studentUsername,
			String courseId,
			Calendar startTime, 
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentoringRequestValid] Inside!");
		
		boolean retVal = false;
		
		// First, check if the time period is valid and the main parameters are not null
		if ((startTime.compareTo(fixUserStartTime(startTime)) == 0) &&
				(endTime.compareTo(fixUserEndTime(endTime)) == 0) &&
				(endTime.compareTo(startTime) > 0) &&
				(courseId != null) &&
				(studentUsername != null)) {
		
			// Next, check if the mentorUsername is not null
			if ((mentorUsername == null) || (mentorUsername == "")) {
		
				// Next, get all the mentors for this course
				ArrayList<Mentor> mentors = mentorSchDB.getMentorList(courseId);
				
				for (int i=0; i<mentors.size(); i++) {
					
					// Next, check if the mentor is available during the requested time
					ArrayList<TimePeriod> mentorFreetimeList = 
						TimePeriodTools.convertFromEventToTimePeriod(	
								mentorSchDB.getMentorUnallocatedWorktimeSchList(
										mentors.get(i).getUsername(),
										startTime, 
										endTime));
					if (mentorFreetimeList != null) {
						
						if ((mentorFreetimeList.get(0).getStartTime().compareTo(startTime) == 0) &&
							(mentorFreetimeList.get(0).getEndTime().compareTo(endTime) == 0)) {
							
							retVal = true;
							break;
					
						}

					}

				}
				
			}
			else {
				
				// Next, check if the mentor is assigned to this course
				MentorCourse mentorCourse = 
					mentorSchDB.getMentorCourse(
							mentorUsername, 
							courseId);
				if (mentorCourse != null) {
					
					// Next, check if the mentor is available during the requested time
					ArrayList<TimePeriod> mentorFreetimeList =
						TimePeriodTools.convertFromEventToTimePeriod(
								mentorSchDB.getMentorUnallocatedWorktimeSchList(
										mentorUsername, 
										startTime, 
										endTime));
					if (mentorFreetimeList != null) {
						
						if (mentorFreetimeList.size() > 0) {
							
							if ((mentorFreetimeList.get(0).getStartTime().compareTo(startTime) == 0) &&
								(mentorFreetimeList.get(0).getEndTime().compareTo(endTime) == 0))
								retVal = true;
						
						}
					
					}
					
				}
					
			}

		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentoringRequestValid] Ready to get out!");
		
		return retVal;
		
	}

	/**
	 * 
	 * @param studentUsername
	 * @param courseId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private String assignMentor(
			String studentUsername, 
			String courseId,
			Calendar startTime, 
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - assignMentor] Inside!");
		
		String mentorUsername = null;
		// First, get all the mentors for this course
		ArrayList<Mentor> mentors = mentorSchDB.getMentorList(courseId);
		ArrayList<Mentor> availMentors = new ArrayList<Mentor>();
		
		for (int i=0; i<mentors.size(); i++) {
			
			// Next, check if the mentor is available during the requested time
			ArrayList<TimePeriod> mentorFreetimeList =
				TimePeriodTools.convertFromEventToTimePeriod(
						mentorSchDB.getMentorUnallocatedWorktimeSchList(
								mentors.get(i).getUsername(),
								startTime, 
								endTime));
			if (mentorFreetimeList != null) {
				
				if ((mentorFreetimeList.get(0).getStartTime().compareTo(startTime) == 0) &&
					(mentorFreetimeList.get(0).getEndTime().compareTo(endTime) == 0)) 
					availMentors.add(mentors.get(i));
					
			}

		}
		
		if (availMentors.size() > 0) {
			
			Random random = new Random(Calendar.getInstance().getTime().getTime());
			int randNum = random.nextInt() % availMentors.size();
			mentorUsername = availMentors.get(randNum).getUsername();
			
		}
				
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - assignMentor] Ready to get out!");
		
		return mentorUsername;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized ScheduleMentoringResponse scheduleMentoring(
			ScheduleMentoringRequest request) {

		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - scheduleMentoring] Inside!");
		
		ScheduleMentoringResponse response = new ScheduleMentoringResponse();
		
		if (isScheduleMentoringRequestValid(
				request.getMentorUsername(),
				request.getStudentUsername(),
				request.getCourseId(),
				request.getTimePeriod().getStartTime(),
				request.getTimePeriod().getEndTime())) {
			
			String mentorUsername = request.getMentorUsername();
			if ((mentorUsername == null) || (mentorUsername == "")) {
				
				mentorUsername = assignMentor(
						request.getStudentUsername(),
						request.getCourseId(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime());
				
			}
			
			MentoringSchedule mentoringSch = 
				new MentoringSchedule(
						null,
						mentorUsername,
						request.getStudentUsername(),
						request.getCourseId(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime(),
						true);
			
			if (mentorSchDB.remMentorUnallocatedWorktimeSch(
					mentorUsername,
					request.getTimePeriod().getStartTime(),
					request.getTimePeriod().getEndTime())) {
				
				String schId = mentorSchDB.addMentoringSch(mentoringSch);
				mentoringSch = mentorSchDB.getMentoringSch(schId);
				
				response.setId(mentoringSch.getId());
				response.setMentorUsername(mentoringSch.getMentorUsername());
				response.setSuccess(true);
				response.setMessage("Successful!");
			
			}
			else {
				
				response.setSuccess(false);
				response.setMessage("Not Successful! " +
						"Mentor's unallocated worktime could not be removed!");

			}

		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");

		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - scheduleMentoring] Ready to get out!");
		
		return response;
		
	}
	       
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized CancelScheduledMentoringResponse cancelScheduledMentoring(
			CancelScheduledMentoringRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - cancelScheduledMentoring] Inside!");
		
		CancelScheduledMentoringResponse response = new CancelScheduledMentoringResponse();

		MentoringSchedule mentoringSch = mentorSchDB.getMentoringSch(request.getId());
		if (mentoringSch != null) {
			if (mentoringSch.isActive()) {				
	    		Calendar now = Calendar.getInstance();
	    		if (mentoringSch.getStartTime().before(now) && mentoringSch.getEndTime().after(now)) {
					MentorUnallocatedWorktimeSchedule mentorUnallocatedWorktimeSch =
						new MentorUnallocatedWorktimeSchedule(
								null, 
								mentoringSch.getMentorUsername(),
								now,
								mentoringSch.getEndTime(),
								true);
					mentorSchDB.addMentorUnallocatedWorktimeSch(mentorUnallocatedWorktimeSch);				
	    			
	    			mentoringSch.setEndTime(now);
	    			mentorSchDB.setMentoringSch(mentoringSch);
	    			
	        	   	response.setSuccess(true);
	        		response.setMessage("Cancellation was successful!);");
	    		} else if (mentoringSch.getStartTime().after(now) && mentoringSch.getEndTime().after(now)) {	    			
					MentorUnallocatedWorktimeSchedule mentorUnallocatedWorktimeSch =
						new MentorUnallocatedWorktimeSchedule(
								null, 
								mentoringSch.getMentorUsername(),
								mentoringSch.getStartTime(),
								mentoringSch.getEndTime(),
								true);
					mentorSchDB.addMentorUnallocatedWorktimeSch(mentorUnallocatedWorktimeSch);				

	    			mentoringSch.setActive(false);
	    			mentorSchDB.setMentoringSch(mentoringSch);
					
					response.setSuccess(true);
					response.setMessage("Successful!");					
	    		} else {
	        	   	response.setSuccess(false);
	        		response.setMessage("The appointment cannot be cancelled! The appointment was in the past!);");
	    		}    						
			} else {
				response.setSuccess(false);
				response.setMessage("Not Successful! The schedule was already cancelled!");
			}
		} else {
			response.setSuccess(false);
			response.setMessage("Not Successful! The schedule could not be found!");
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - cancelScheduledMentoring] Ready to get out!");
		
		return response;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized ModifyScheduledMentoringResponse modifyScheduledMentoring(
			ModifyScheduledMentoringRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - modifyScheduledMentoring] Inside!");
		
		ModifyScheduledMentoringResponse response = new ModifyScheduledMentoringResponse();

		MentoringSchedule mentoringSch = mentorSchDB.getMentoringSch(request.getId());
		if (mentoringSch != null) {
			
			if (mentoringSch.isActive()) {
				
				CancelScheduledMentoringRequest cancelReq =
					new CancelScheduledMentoringRequest();
				cancelReq.setId(request.getId());
				CancelScheduledMentoringResponse cancelResp =
					cancelScheduledMentoring(cancelReq);
				if (cancelResp.getSuccess()) {
					
					ScheduleMentoringRequest schReq = new ScheduleMentoringRequest();
					schReq.setMentorUsername(mentoringSch.getMentorUsername());
					schReq.setStudentUsername(mentoringSch.getStudentUsername());
					schReq.setCourseId(mentoringSch.getCourseId());
					TimePeriod timePeriod = new TimePeriod();
					timePeriod.setStartTime(request.getTimePeriod().getStartTime());
					timePeriod.setEndTime(request.getTimePeriod().getEndTime());
					schReq.setTimePeriod(timePeriod);
					ScheduleMentoringResponse schResp = 
						scheduleMentoring(schReq);
					
					if (schResp.getSuccess()) {
						
						response.setSuccess(schResp.getSuccess());
						response.setMessage(schResp.getMessage());
						response.setId(schResp.getId());
						response.setMentorUsername(schResp.getMentorUsername());
					
					}
					else {
				
						schReq = new ScheduleMentoringRequest();
						schReq.setMentorUsername(mentoringSch.getMentorUsername());
						schReq.setStudentUsername(mentoringSch.getStudentUsername());
						schReq.setCourseId(mentoringSch.getCourseId());
						timePeriod = new TimePeriod();
						timePeriod.setStartTime(mentoringSch.getStartTime());
						timePeriod.setEndTime(mentoringSch.getEndTime());
						schReq.setTimePeriod(timePeriod);
						schResp = 
							scheduleMentoring(schReq);
						
						if (schResp.getSuccess()) {
							
							response.setSuccess(false);
							response.setMessage("Could not modify the schedule! " +
									"The previous appointment is rescheduled!");
							response.setId(schResp.getId());
							response.setMentorUsername(schResp.getMentorUsername());
						
						}
						else {
							
							response.setSuccess(false);
							response.setMessage("Could not modify the schedule! " +
									"The previous appointment could not be rescheduled either!");
							response.setId(schResp.getId());
							response.setMentorUsername(schResp.getMentorUsername());
													
						}
							
					}
					
				} 
				else {
					
					response.setSuccess(false);
					response.setMessage("Not Successful! Could not cancel the already scheduled appointment!");

				}
				
			}
			else {
				
				response.setSuccess(false);
				response.setMessage("Not Successful! " +
						"The schedule was cancelled already and could not be modified!");

			}
			
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful! The schedule could not be found!");
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - modifyScheduledMentoring] Ready to get out!");
		
		return response;
		
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetMentoringAvailabilityResponse getMentoringAvailability(
			GetMentoringAvailabilityRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringAvailability] Inside!");
		
		GetMentoringAvailabilityResponse response = new GetMentoringAvailabilityResponse();

		Calendar startTime = request.getTimePeriod().getStartTime();
		Calendar endTime = request.getTimePeriod().getEndTime();
		Calendar fixedStartTime = fixUserStartTime(startTime);
		Calendar fixedEndTime = fixUserEndTime(endTime);		
		if (fixedStartTime.compareTo(fixedEndTime) >= 0) {
			
			response.setSuccess(false);
			response.setMessage("Not Successful! The time period requested is wrong!");
			return response;
		}		

		// courseId cannot be null or empty for this function
		if ((request.getCourseId() == null) || (request.getCourseId() == "")) {
			
			response.setSuccess(false);
			response.setMessage("Not Successful! The courseId cannot be null or empty!");
			return response;

		}		

		ArrayList<TimePeriod> availList = new ArrayList<TimePeriod>();
		
		if ((request.getMentorUsername() == null) || (request.getMentorUsername() == "")) {

			// mentorUsername can be null or empty, indicating that any mentor would be fine.
			availList = mentorSchDB.getMentoringUnallocatedWorktimeList(
					request.getCourseId(), 
					fixedStartTime,
					fixedEndTime);
				
		}
		else {

			// In this case, we need to make sure that the mentor is assigned to the course.
			MentorCourse mentorCourse = 
				mentorSchDB.getMentorCourse(
						request.getMentorUsername(), 
						request.getCourseId());
			if (mentorCourse == null) {

				response.setSuccess(false);
				response.setMessage("Not Successful! " + request.getMentorUsername() + " " +
						"is not a mentor for " + request.getCourseId() + "!");
				return response;

			}		

			availList = 
				TimePeriodTools.convertFromEventToTimePeriod(
						mentorSchDB.getMentorUnallocatedWorktimeSchList(
								request.getMentorUsername(), 
								fixedStartTime,
								fixedEndTime));

		}
		
		if (availList != null) {
			
			availList = TimePeriodTools.fixAndSortTimePeriodList(availList);
			
			// Now check if the studentUsername is not null or empty, then the student's schedule
			// must not be in conflict with the reported availability.
			if ((request.getStudentUsername() != null) && (request.getStudentUsername() != "")) {
				
				ArrayList<ScheduledEvent> studentEvent = 
					mentorSchDB.getScheduledMentoringList(
							null, request.getStudentUsername(), 
							null, 
							fixedStartTime, 
							fixedEndTime);
				ArrayList<TimePeriod> studentSch = 
					TimePeriodTools.convertFromEventToTimePeriod(studentEvent);
				
				if (studentSch != null) {
					
					DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringAvailability] " +
							"studentSch.size(): " + studentSch.size());
					
					if (studentSch.size() > 0) {
						
						studentSch = TimePeriodTools.fixAndSortTimePeriodList(studentSch);
						
						DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringAvailability] " +
								"studentSch.size(): " + studentSch.size());
						
						DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringAvailability] " +
								"availList.size(): " + availList.size());
						
						availList = 
							TimePeriodTools.getCommonTimePeriods(
									availList, 
									TimePeriodTools.toggleTimePeriodList(
											studentSch, 
											fixedStartTime, 
											fixedEndTime));

						DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringAvailability] " +
								"availList.size(): " + availList.size());
						
					}
				}
			}
				
			for (int i=0; i<availList.size(); i++)
				response.addAvailabilityRange(availList.get(i));

			response.setSuccess(true);
			response.setMessage("Successful!");

		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful! No availability!");

		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringAvailability] Ready to get out!");
		
		return response;
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetMentoringUnavailabilityResponse getMentoringUnavailability(
			GetMentoringUnavailabilityRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringUnavailability] Inside!");
		
		GetMentoringUnavailabilityResponse response = new GetMentoringUnavailabilityResponse();

		GetMentoringAvailabilityRequest availReq = new GetMentoringAvailabilityRequest();
		availReq.setMentorUsername(request.getMentorUsername());
		availReq.setStudentUsername(request.getStudentUsername());
		availReq.setCourseId(request.getCourseId());
		TimePeriod timePeriod = new TimePeriod();
		timePeriod.setStartTime(request.getTimePeriod().getStartTime());
		timePeriod.setEndTime(request.getTimePeriod().getEndTime());
		availReq.setTimePeriod(timePeriod);

		GetMentoringAvailabilityResponse availResp = 
			getMentoringAvailability(availReq);

		ArrayList<TimePeriod> availList = new ArrayList<TimePeriod>();
		TimePeriod [] availArray = availResp.getAvailabilityRange();
		response.setSuccess(availResp.getSuccess());
		response.setMessage(availResp.getMessage());
		if (availArray != null) {
			
			for (int i=0; i<availArray.length; i++)
				availList.add(availArray[i]);
		
			ArrayList<TimePeriod> unavailList = 
				TimePeriodTools.toggleTimePeriodList(
					availList, 
					request.getTimePeriod().getStartTime(), 
					request.getTimePeriod().getEndTime());
	
			for (int i=0; i<unavailList.size(); i++)
				response.addUnavailabilityRange(unavailList.get(i));
			
		}
		else {
			
			response.addUnavailabilityRange(request.getTimePeriod());

		}
				
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringUnavailability] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetMentoringScheduleResponse getMentoringSchedule(
			GetMentoringScheduleRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringSchedule] Inside!");
		
		GetMentoringScheduleResponse response = new GetMentoringScheduleResponse();

		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringSchedule] " +
				"1) request: \n" +
				"\tusername : " + request.getStudentUsername() + "\n" +
				"\tcourse id : " + request.getCourseId() + "\n" +
				"\tmentor username : " + request.getMentorUsername() + "\n" +
				"\tstart : " + request.getTimePeriod().getStartTime().getTime() + "\n" +
				"\tend : " + request.getTimePeriod().getEndTime().getTime());
		
		Calendar startTime = request.getTimePeriod().getStartTime();
		Calendar endTime = request.getTimePeriod().getEndTime();
		// Calendar fixedStartTime = fixUserStartTime(startTime);
		// Calendar fixedEndTime = fixUserEndTime(endTime);		
		Calendar fixedStartTime = startTime;
		Calendar fixedEndTime = endTime;		
		if (fixedStartTime.compareTo(fixedEndTime) >= 0)
			return null;
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringSchedule] " +
				"2) request: \n" +
				"\tusername : " + request.getStudentUsername() + "\n" +
				"\tcourse id : " + request.getCourseId() + "\n" +
				"\tmentor username : " + request.getMentorUsername() + "\n" +
				"\tstart : " + request.getTimePeriod().getStartTime().getTime() + "\n" +
				"\tend : " + request.getTimePeriod().getEndTime().getTime());
		
		ArrayList<ScheduledEvent> scheduleList = 
			mentorSchDB.getScheduledMentoringList(
					request.getMentorUsername(),
					request.getStudentUsername(),
					request.getCourseId(),
					fixedStartTime,
					fixedEndTime);
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringSchedule] " +
				"request: \n" +
				"\tscheduleList: " + scheduleList);
		
		if (scheduleList != null) {
			
			for (int i=0; i<scheduleList.size(); i++)
				response.addSchedule(scheduleList.get(i));

			response.setSuccess(true);
			response.setMessage("Successful!");

		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");

		}
				
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringSchedule] Ready to get out!");
		
		return response;
	
	}
	
    /**
     * 
     * @param request
     * @return
     */
    public GetMentoringScheduleBySchIdResponse getMentoringScheduleBySchId(
    		GetMentoringScheduleBySchIdRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringScheduleBySchId] Inside!");

    	GetMentoringScheduleBySchIdResponse response = new GetMentoringScheduleBySchIdResponse();

		ScheduledEvent mentoringScheduledEvent = null;
		if ((request.getMentoringSchId() != null) && (request.getMentoringSchId() != "")) {
    		MentoringSchedule mentoringSch = mentorSchDB.getMentoringSch(request.getMentoringSchId());
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(mentoringSch.getStartTime());
			timePeriod.setEndTime(mentoringSch.getEndTime());
			mentoringScheduledEvent = new ScheduledEvent();
			mentoringScheduledEvent.setTimePeriod(timePeriod);
			mentoringScheduledEvent.setSchId(request.getMentoringSchId());
    		response.setSuccess(true);
	    	response.setMessage("Schedule was retrived successfully!");    	
    	} else {
    		response.setSuccess(false);
    		response.setMessage("Parameter mentoringId cannot be null nor empty!");
    	}
		response.setSchedule(mentoringScheduledEvent);
	    	  	
    	DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentoringScheduleBySchId] Ready to get out!");

    	return response;

    }

	/**
	 * 
	 * @return
	 */
	public GetConfigurationResponse getConfiguration() {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getConfiguration] Inside!");
		
		GetConfigurationResponse response = new GetConfigurationResponse();

		Configuration configuration = mentorSchDB.getConfiguration();
		if (configuration != null) {
			 
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(configuration.getUserStartTime());
			timePeriod.setEndTime(configuration.getUserEndTime());
			response.setUserTimePeriod(timePeriod);
			timePeriod = new TimePeriod();
			timePeriod.setStartTime(configuration.getAdminStartTime());
			timePeriod.setEndTime(configuration.getAdminEndTime());
			response.setAdminTimePeriod(timePeriod);
			
			response.setSuccess(true);
			response.setMessage("Successful!");
			
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getConfiguration] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized SetConfigurationResponse setConfiguration(
			SetConfigurationRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - setConfiguration] Inside!");
		
		SetConfigurationResponse response = new SetConfigurationResponse();

		Configuration configuration = new Configuration(
				request.getUserTimePeriod().getStartTime(),
				request.getUserTimePeriod().getEndTime(),
				request.getAdminTimePeriod().getStartTime(),
				request.getAdminTimePeriod().getEndTime());
		
		if (mentorSchDB.setConfiguration(configuration)) {
			
			response.setSuccess(true);
			response.setMessage("Successful!");
			
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - setConfiguration] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetMentorListResponse getMentorList(
			GetMentorListRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorList] Inside!");
		
		GetMentorListResponse response = new GetMentorListResponse();

		String courseId = request.getCourseId();
		
		ArrayList<Mentor> mentorList = null;
		if ((courseId == null) || (courseId == "")) 
			mentorList = mentorSchDB.getMentorList();
		else
			mentorList = mentorSchDB.getMentorList(courseId);
		
		if (mentorList != null) {
			
			for (int i=0; i<mentorList.size(); i++) 
				response.addMentorUsername(mentorList.get(i).getUsername());
			
			response.setSuccess(true);
			response.setMessage("Successful!");

		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");

		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorList] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized SetMentorStatusResponse setMentorStatus(
			SetMentorStatusRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - setMentorStatus] Inside!");
		
		SetMentorStatusResponse response = new SetMentorStatusResponse();

		Mentor mentor = new Mentor(request.getMentorUsername(), request.getActive());
		
		if (mentorSchDB.setMentor(mentor)) {
			
			response.setSuccess(true);
			response.setMessage("Successful!");
			
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - setMentorStatus] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized DelMentorResponse delMentor(
			DelMentorRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - delMentor] Inside!");
		
		DelMentorResponse response = new DelMentorResponse();

		if (mentorSchDB.delMentor(request.getMentorUsername())) {
			
			response.setSuccess(true);
			response.setMessage("Successful!");
			
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - delMentor] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized AddMentorResponse addMentor(
			AddMentorRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - addMentor] Inside!");
		
		AddMentorResponse response = new AddMentorResponse();

		Mentor mentor = new Mentor(request.getMentorUsername(), true);
		
		String retMentor = mentorSchDB.addMentor(mentor);
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - addMentor] retMentor: " + retMentor +
				" mentor.getUsername(): " + mentor.getUsername() + " are equal: " +
				(retMentor.compareTo(mentor.getUsername())));
		
		if (retMentor.compareTo(mentor.getUsername()) == 0) {
			
			response.setSuccess(true);
			response.setMessage("Successful!");

		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");

		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - addMentor] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized AssignMentorToCourseResponse assignMentorToCourse(
			AssignMentorToCourseRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - assignMentorToCourse] Inside!");
		
		AssignMentorToCourseResponse response = new AssignMentorToCourseResponse();

		MentorCourse mentorCourse = mentorSchDB.getMentorCourse(
				request.getMentorUsername(), 
				request.getCourseId());
		if (mentorCourse != null) {
		
			if (mentorCourse.isActive() != request.getFlag()) {
				
				mentorCourse.setActive(request.getFlag());
				mentorSchDB.setMentorCourse(mentorCourse);
				
			}
		
		}
		else {
			
			mentorCourse = new MentorCourse(
					request.getMentorUsername(),
					request.getCourseId(),
					request.getFlag());
			mentorSchDB.addMentorCourse(mentorCourse);
			
		}
				
		response.setSuccess(true);
		response.setMessage("Successful!");

		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - assignMentorToCourse] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized UnassignMentorToCourseResponse unassignMentorToCourse(
			UnassignMentorToCourseRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - unassignMentorToCourse] Inside!");
		
		UnassignMentorToCourseResponse response = new UnassignMentorToCourseResponse();

		MentorCourse mentorCourse = new MentorCourse(
				request.getMentorUsername(),
				request.getCourseId(),
				false);
		
		if (mentorSchDB.delMentorCourse(mentorCourse)) {
			
			response.setSuccess(true);
			response.setMessage("Successful! The mentor is no longer assigned to the course!");
			
		}
		else {

			if (mentorSchDB.setMentorCourse(mentorCourse)) {
				
				response.setSuccess(true);
				response.setMessage("Successful! The mentor's assignemnt to the course is now inactive!");
				
			}
			else {
				
				response.setSuccess(false);
				response.setMessage("Not Successful! The mentor assignment could not be set inactive!");
				
			}
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - unassignMentorToCourse] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param startTime
	 * @return
	 */
    private Calendar fixAdminStartTime(Calendar startTime) {
		
    	Calendar fixedStartTime = (Calendar)startTime.clone();
    	
    	Configuration config = mentorSchDB.getConfiguration();
    	if (fixedStartTime.compareTo(config.getAdminStartTime()) < 0) {
    		
    		fixedStartTime = (Calendar)config.getAdminStartTime().clone();
    	
    	}
    		
    	Calendar now = Calendar.getInstance();
    	if (fixedStartTime.compareTo(now) < 0) {
    		
    		fixedStartTime = (Calendar)now.clone();
    	
    	}
    	
    	return fixedStartTime;

    }

    /**
     * 
     * @param endTime
     * @return
     */
	private Calendar fixAdminEndTime(Calendar endTime) {
    
		Calendar fixedEndTime = (Calendar)endTime.clone();
    	
    	Configuration config = mentorSchDB.getConfiguration();
    	if (fixedEndTime.compareTo(config.getAdminEndTime()) > 0) {
    		
    		fixedEndTime = (Calendar)config.getAdminEndTime().clone();
    	
    	}
    		
    	return fixedEndTime;

	}

	/**
	 * 
	 * @param mentorUsername
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private synchronized boolean isScheduleMentorUnallocatedWorktimeRequestValid(
			String mentorUsername,
			Calendar startTime, 
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentorUnallocatedWorktimeRequestValid] Inside!");
		
		boolean retVal = false;
		
		// First, check if the time period is valid and the main parameters are not null
		if ((startTime.compareTo(fixAdminStartTime(startTime)) == 0) &&
				(endTime.compareTo(fixAdminEndTime(endTime)) == 0) &&
				(endTime.compareTo(startTime) > 0) &&
				(mentorUsername != null)) {
			
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentorUnallocatedWorktimeRequestValid] 1 ");

			// Next, check if the mentor's unallocated worktime is available during the requested time
	    	ArrayList<TimePeriod> mentorAvailableList = 
	    		TimePeriodTools.toggleTimePeriodList(
	    				getMentorUnallocatedWorktimeUnavailabilityList(
							mentorUsername,
							startTime,
							endTime),
						startTime,
						endTime);
	    							
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentorUnallocatedWorktimeRequestValid] 2 ");

			if (mentorAvailableList.size() == 1) {
				
				DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentorUnallocatedWorktimeRequestValid] 3 " +
						" mentorFreetimeList.get(0).getStartTime(): " + mentorAvailableList.get(0).getStartTime().getTime() +
						" mentorFreetimeList.get(0).getEndTime(): " + mentorAvailableList.get(0).getEndTime().getTime() +
						" startTime: " + startTime.getTime() +
						" endTime: " + endTime.getTime());

				if (mentorAvailableList.get(0).getStartTime().equals(startTime) && 
					mentorAvailableList.get(0).getEndTime().equals(endTime)) {
					
					retVal = true;
					DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentorUnallocatedWorktimeRequestValid] 4 ");
			
				}

			}
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentorUnallocatedWorktimeRequestValid] " + retVal);
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - isScheduleMentorUnallocatedWorktimeRequestValid] Ready to get out!");
		
		return retVal;
		
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized ScheduleMentorUnallocatedWorktimeResponse 
	scheduleMentorUnallocatedWorktime(
			ScheduleMentorUnallocatedWorktimeRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - scheduleMentorUnallocatedWorktime] Inside!");
		
		ScheduleMentorUnallocatedWorktimeResponse response = 
			new ScheduleMentorUnallocatedWorktimeResponse();

		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - scheduleMentorUnallocatedWorktime] 1!");

		if (isScheduleMentorUnallocatedWorktimeRequestValid(
				request.getMentorUsername(),
				request.getTimePeriod().getStartTime(),
				request.getTimePeriod().getEndTime())) {
			
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - scheduleMentorUnallocatedWorktime] 2!");

			MentorUnallocatedWorktimeSchedule mentorUnallocatedWorktimeSch =
				new MentorUnallocatedWorktimeSchedule(
						null,
						request.getMentorUsername(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime(),
						true);
			
			String schId = 
				mentorSchDB.addMentorUnallocatedWorktimeSch(mentorUnallocatedWorktimeSch);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - scheduleMentorUnallocatedWorktime] 3! schId: " + schId);

			if ((schId != null) && (schId != "")) {
				
				response.setId(schId);
				response.setSuccess(true);
				response.setMessage("Successful!");
				
			}
			else {
				
				response.setId(schId);
				response.setSuccess(false);
				response.setMessage("Not Successful!");
	
			}
			
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");

		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - scheduleMentorUnallocatedWorktime] Ready to get out!");
		
		return response;
	
	}
	
	public synchronized CancelScheduledMentorUnallocatedWorktimeResponse 
		cancelScheduledMentorUnallocatedWorktime(
			CancelScheduledMentorUnallocatedWorktimeRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - cancelScheduledMentorUnallocatedWorktime] Inside!");
		
		CancelScheduledMentorUnallocatedWorktimeResponse response = 
			new CancelScheduledMentorUnallocatedWorktimeResponse();

		MentorUnallocatedWorktimeSchedule mentorFreeSch =
			mentorSchDB.getMentorUnallocatedWorktimeSch(request.getId());
		
		if (mentorFreeSch != null) {
		
			mentorFreeSch.setActive(false);
			if (mentorSchDB.setMentorUnallocatedWorktimeSch(mentorFreeSch)) {
				
				response.setSuccess(true);
				response.setMessage("Successful!");

			}
			else {
				
				response.setSuccess(false);
				response.setMessage("Not Successful!");

			}

		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful! Could not find the schedule!");

		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - cancelScheduledMentorUnallocatedWorktime] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized ModifyScheduledMentorUnallocatedWorktimeResponse 
	modifyScheduledMentorUnallocatedWorktime(
			ModifyScheduledMentorUnallocatedWorktimeRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - modifyScheduledMentorUnallocatedWorktime] Inside!");
		
		ModifyScheduledMentorUnallocatedWorktimeResponse response = new ModifyScheduledMentorUnallocatedWorktimeResponse();

		MentorUnallocatedWorktimeSchedule mentorFreeSch = 
			mentorSchDB.getMentorUnallocatedWorktimeSch(request.getId());
		
		if (mentorFreeSch != null) {
			
			if (mentorFreeSch.isActive()) {
				
				mentorFreeSch.setActive(false);
				if (mentorSchDB.setMentorUnallocatedWorktimeSch(mentorFreeSch)) {
			
					ScheduleMentorUnallocatedWorktimeRequest schReq = 
						new ScheduleMentorUnallocatedWorktimeRequest();
					schReq.setMentorUsername(mentorFreeSch.getMentorUsername());
					TimePeriod timePeriod = new TimePeriod();
					timePeriod.setStartTime(request.getTimePeriod().getStartTime());
					timePeriod.setEndTime(request.getTimePeriod().getEndTime());
					schReq.setTimePeriod(timePeriod);
					
					ScheduleMentorUnallocatedWorktimeResponse schResp = 
						scheduleMentorUnallocatedWorktime(schReq);
					
					if (schResp.getSuccess()) {
						
						response.setSuccess(schResp.getSuccess());
						response.setMessage(schResp.getMessage());
						response.setId(schResp.getId());
					
					}
					else {
				
						mentorFreeSch.setActive(true);
						if (mentorSchDB.setMentorUnallocatedWorktimeSch(mentorFreeSch)) {
					
							response.setSuccess(false);
							response.setMessage("Not Successful! The new time period is not available!");
						
						}
						else {
							
							response.setSuccess(false);
							response.setMessage("Not Successful! Database is now inconsistent as " +
									"the appointment that was supposed to be modified could not " +
									"be modified and the original one could not be activated " +
									"again! Please inform the developer of this inconsistency!");
							
						}
						
					}
					
				} 
				else {
					
					response.setSuccess(false);
					response.setMessage("Not Successful! Could not cancel the already scheduled appointment!");

				}
				
			}
			else {
				
				response.setSuccess(false);
				response.setMessage("Not Successful! The schedule was cancelled!");

			}
			
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful! The schedule could not be found!");
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - modifyScheduledMentorUnallocatedWorktime] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param mentorUsername
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private ArrayList<TimePeriod> getMentorUnallocatedWorktimeUnavailabilityList(
			String mentorUsername,
			Calendar startTime,
			Calendar endTime) {

		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailabilityList] Inside!");
		
		// check for wrong input parameters!
		if (startTime.compareTo(endTime) >= 0)
			return null;
		
		ArrayList<TimePeriod> unavailList = new ArrayList<TimePeriod>();
		
		if (!mentorSchDB.getMentor(mentorUsername).isActive()) {
		
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(endTime);
			
			unavailList.add(timePeriod);
			
			return unavailList;
			
		}
		
		Calendar fixedStartTime = fixAdminStartTime(startTime);
		Calendar fixedEndTime = fixAdminEndTime(endTime);
		
		if (fixedStartTime.compareTo(fixedEndTime) >= 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(endTime);
			
			unavailList.add(timePeriod);
			
			return unavailList;
			
		}
		
		ArrayList<TimePeriod> mentorUnavailList = 
			TimePeriodTools.convertFromEventToTimePeriod(
					mentorSchDB.getMentorUnallocatedWorktimeSchList(
							mentorUsername, 
							fixedStartTime, 
							fixedEndTime));
		unavailList.addAll(mentorUnavailList);

		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailabilityList] " +
				"mentorUnavailList.size(): " + mentorUnavailList.size());		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailabilityList] " +
				"unavailList.size(): " + unavailList.size());
		
		ArrayList<ScheduledEvent> mentorEventList = 
			mentorSchDB.getScheduledMentoringList(
					mentorUsername, 
					null, 
					null, 
					fixedStartTime, 
					fixedEndTime);
		ArrayList<TimePeriod> mentorSchList =
			TimePeriodTools.convertFromEventToTimePeriod(mentorEventList);
		unavailList.addAll(mentorSchList);
									
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailabilityList] " +
				"mentorScheduledList.size(): " + mentorSchList.size());		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailabilityList] " +
				"unavailList.size(): " + unavailList.size());
		
		unavailList = TimePeriodTools.getCommonTimePeriods(unavailList, unavailList);
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailabilityList] " +
				"unavailList.size(): " + unavailList.size());
		
		if (fixedStartTime.compareTo(startTime) > 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(fixedStartTime);
			
			unavailList.add(0, timePeriod);
				
		}
			
		if (fixedEndTime.compareTo(endTime) < 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(fixedEndTime);
			timePeriod.setEndTime(endTime);
			
			unavailList.add(timePeriod);
				
		}
		
		unavailList = TimePeriodTools.shortenTimePeriodList(unavailList);
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailabilityList] Ready to get out!");
		
		return unavailList;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetMentorUnallocatedWorktimeAvailabilityResponse 
	getMentorUnallocatedWorktimeAvailability(
			GetMentorUnallocatedWorktimeAvailabilityRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeAvailability] Inside!");
		
		GetMentorUnallocatedWorktimeAvailabilityResponse response = new GetMentorUnallocatedWorktimeAvailabilityResponse();

    	ArrayList<TimePeriod> mentorAvailableList = 
    		TimePeriodTools.toggleTimePeriodList(
    				getMentorUnallocatedWorktimeUnavailabilityList(
						request.getMentorUsername(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime()), 
				request.getTimePeriod().getStartTime(), 
				request.getTimePeriod().getEndTime());
			
    	if (mentorAvailableList != null) {
    		
			for (int i = 0; i < mentorAvailableList.size(); i++) 
				response.addAvailabilityRange(mentorAvailableList.get(i));
			
			if (mentorAvailableList.size() == 0) {
				
		    	TimePeriod timePeriod = new TimePeriod();
				timePeriod.setStartTime(request.getTimePeriod().getEndTime());
				timePeriod.setEndTime(request.getTimePeriod().getEndTime());
				response.addAvailabilityRange(timePeriod);
				
			}
			
			response.setSuccess(true);
			response.setMessage("Successful!");

    	}
    	else {
    		
			response.setSuccess(false);
			response.setMessage("Not Successful!");

    	}
    	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeAvailability] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetMentorUnallocatedWorktimeUnavailabilityResponse 
	getMentorUnallocatedWorktimeUnavailability(
			GetMentorUnallocatedWorktimeUnavailabilityRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailability] Inside!");
		
		GetMentorUnallocatedWorktimeUnavailabilityResponse response = new GetMentorUnallocatedWorktimeUnavailabilityResponse();

		ArrayList<TimePeriod> mentorUnavailableList = 
			getMentorUnallocatedWorktimeUnavailabilityList(
						request.getMentorUsername(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime());

		if (mentorUnavailableList != null) {
			
			for (int i = 0; i < mentorUnavailableList.size(); i++) 
				response.addUnavailabilityRange(mentorUnavailableList.get(i));
			
			response.setSuccess(true);
			response.setMessage("Successful!");
	
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");
	
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorUnallocatedWorktimeUnavailability] Ready to get out!");
		
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetMentorScheduledUnallocatedWorktimeResponse 
	getMentorScheduledUnallocatedWorktime(
			GetMentorScheduledUnallocatedWorktimeRequest request) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorScheduledUnallocatedWorktime] Inside!");
		
		GetMentorScheduledUnallocatedWorktimeResponse response = new GetMentorScheduledUnallocatedWorktimeResponse();

		ArrayList<ScheduledEvent> mentorSchUWList = 
			mentorSchDB.getMentorUnallocatedWorktimeSchList(
						request.getMentorUsername(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime());

		if (mentorSchUWList != null) {
			
			for (int i = 0; i < mentorSchUWList.size(); i++) 
				response.addScheduledRange(mentorSchUWList.get(i));
			
			response.setSuccess(true);
			response.setMessage("Successful!");
	
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("Not Successful!");
	
		}

		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getMentorScheduledUnallocatedWorktime] Ready to get out!");
		
		return response;
	
	}
	
	public GetRandomMentorResponse getRandomMentor(
			GetRandomMentorRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getRandomMentor] Inside!");
		
		GetRandomMentorResponse response = new GetRandomMentorResponse();
		
		ArrayList<Mentor> mentorList = mentorSchDB.getMentorList(
				request.getCourseId(), 
				request.getTimePeriod().getStartTime(), 
				request.getTimePeriod().getEndTime());
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		int randomNumber = random.nextInt(mentorList.size());
		String mentorUsername = mentorList.get(randomNumber).getUsername();
		response.setMentorUsername(mentorUsername);
		response.setSuccess(true);
		response.setMessage("Mentor " + mentorUsername + " was selected!");
		
		DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - getRandomMentor] Ready to get out!");
		
		return response;
	}
	
}