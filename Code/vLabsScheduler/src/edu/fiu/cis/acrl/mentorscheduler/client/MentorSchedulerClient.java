package edu.fiu.cis.acrl.mentorscheduler.client;

//
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.axis2.AxisFault;

import edu.fiu.cis.acrl.mentorscheduler.server.Configuration;
import edu.fiu.cis.acrl.mentorscheduler.server.Mentor;
import edu.fiu.cis.acrl.mentorscheduler.server.MentorCourse;
import edu.fiu.cis.acrl.mentorscheduler.server.MentorSchedulerSettings;
import edu.fiu.cis.acrl.mentorscheduler.server.MentorUnallocatedWorktimeSchedule;
import edu.fiu.cis.acrl.mentorscheduler.server.MentoringSchedule;
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
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeAvailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeAvailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeUnavailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentorUnallocatedWorktimeUnavailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringAvailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringAvailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringUnavailabilityRequest;
import edu.fiu.cis.acrl.mentorscheduler.ws.GetMentoringUnavailabilityResponse;
import edu.fiu.cis.acrl.mentorscheduler.ws.MentorSchedulerStub;
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

public class MentorSchedulerClient {

    private MentorSchedulerStub stub;

    public MentorSchedulerClient(String epr) throws AxisFault {
	
    	stub = new MentorSchedulerStub(epr);	
    
    }
 
    /**********************
     * For testing purposes

     **********************/

    
    private void test() throws Exception {
	
    	////////////////////////////////////////////////////
    	System.out.println("[getConfiguration] begin!");
		GetConfigurationResponse getConfigurationResp = stub.getConfiguration();
		if (getConfigurationResp.getSuccess()) {
			
			System.out.println("Successful!" + getConfigurationResp.getMessage());
			Configuration getConfig = 
				new Configuration(
						getConfigurationResp.getUserTimePeriod().getStartTime(),
						getConfigurationResp.getUserTimePeriod().getEndTime(),
						getConfigurationResp.getAdminTimePeriod().getStartTime(),
						getConfigurationResp.getAdminTimePeriod().getEndTime());
			System.out.println("Configuration: " + getConfig);

		}
		else
			System.out.println("Not Successful!" + getConfigurationResp.getMessage());
    	System.out.println("[getConfiguration] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[setConfiguration] begin!");
		Configuration setConfiguration = 
			new Configuration(
					new GregorianCalendar(2010,7-1,15),
					new GregorianCalendar(2010,8-1,15),
					new GregorianCalendar(2010,6-1,15),
					new GregorianCalendar(2010,9-1,15));
		SetConfigurationRequest confReq =
			new SetConfigurationRequest();
		TimePeriod timePeriod = new TimePeriod();
		timePeriod.setStartTime(setConfiguration.getUserStartTime());
		timePeriod.setEndTime(setConfiguration.getUserEndTime());
		confReq.setUserTimePeriod(timePeriod);
		timePeriod = new TimePeriod();
		timePeriod.setStartTime(setConfiguration.getAdminStartTime());
		timePeriod.setEndTime(setConfiguration.getAdminEndTime());
		confReq.setAdminTimePeriod(timePeriod);
		SetConfigurationResponse setConfigurationResp =
			stub.setConfiguration(confReq);
		if (setConfigurationResp.getSuccess())
			System.out.println("Successful!" + setConfigurationResp.getMessage());
		else
			System.out.println("Not Successful!" + setConfigurationResp.getMessage());
    	System.out.println("[getConfiguration] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getConfiguration] begin!");
    	getConfigurationResp = stub.getConfiguration();
		if (getConfigurationResp.getSuccess()) {
			
			System.out.println("Successful!" + getConfigurationResp.getMessage());
			Configuration getConfig = 
				new Configuration(
						getConfigurationResp.getUserTimePeriod().getStartTime(),
						getConfigurationResp.getUserTimePeriod().getEndTime(),
						getConfigurationResp.getAdminTimePeriod().getStartTime(),
						getConfigurationResp.getAdminTimePeriod().getEndTime());
			System.out.println("Configuration: " + getConfig);

		}
		else
			System.out.println("Not Successful!" + getConfigurationResp.getMessage());
    	System.out.println("[getConfiguration] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	GetMentorListRequest getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 1");
		GetMentorListResponse getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[addMentor] begin!");
    	AddMentorRequest addMentorReq =
    		new AddMentorRequest();
    	addMentorReq.setMentorUsername("mentor2");
    	AddMentorResponse addMentorResp = 
			stub.addMentor(addMentorReq);
		if (addMentorResp.getSuccess())
			System.out.println("Successful!" + addMentorResp.getMessage());
		else
			System.out.println("Not Successful!" + addMentorResp.getMessage());
    	addMentorReq.setMentorUsername("mentor3");
    	addMentorResp = 
			stub.addMentor(addMentorReq);
		if (addMentorResp.getSuccess())
			System.out.println("Successful!" + addMentorResp.getMessage());
		else
			System.out.println("Not Successful!" + addMentorResp.getMessage());
    	addMentorReq.setMentorUsername("mentor4");
    	addMentorResp = 
			stub.addMentor(addMentorReq);
		if (addMentorResp.getSuccess())
			System.out.println("Successful!" + addMentorResp.getMessage());
		else
			System.out.println("Not Successful!" + addMentorResp.getMessage());
    	System.out.println("[addMentor] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId(null);
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[delMentor] begin!");
    	DelMentorRequest delMentorReq =
    		new DelMentorRequest();
    	delMentorReq.setMentorUsername("mentor3");
    	DelMentorResponse delMentorResp = 
			stub.delMentor(delMentorReq);
		if (delMentorResp.getSuccess()) 
			System.out.println("Successful!" + delMentorResp.getMessage());	
		else
			System.out.println("Not Successful!" + delMentorResp.getMessage());
    	System.out.println("[delMentor] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[setMentorStatus] begin!");
    	SetMentorStatusRequest setMentorStatusReq =
    		new SetMentorStatusRequest();
    	setMentorStatusReq.setMentorUsername("mentor2");
    	setMentorStatusReq.setActive(false);
    	SetMentorStatusResponse setMentorStatusResp = 
			stub.setMentorStatus(setMentorStatusReq);
		if (setMentorStatusResp.getSuccess()) 
			System.out.println("Successful!" + setMentorStatusResp.getMessage());	
		else
			System.out.println("Not Successful!" + setMentorStatusResp.getMessage());
    	System.out.println("[setMentorStatus] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId(null);
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

		////////////////////////////////////////////////////
    	System.out.println("[assignMentorToCourse] begin!");
    	AssignMentorToCourseRequest assignMentorToCourseReq =
    		new AssignMentorToCourseRequest();
    	assignMentorToCourseReq.setMentorUsername("mentor");
    	assignMentorToCourseReq.setCourseId("Kaseya 3");
    	AssignMentorToCourseResponse assignMentorToCourseResp = 
			stub.assignMentorToCourse(assignMentorToCourseReq);
		if (assignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + assignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + assignMentorToCourseResp.getMessage());
    	assignMentorToCourseReq.setMentorUsername("mentor");
    	assignMentorToCourseReq.setCourseId("Kaseya 4");
    	assignMentorToCourseResp = 
			stub.assignMentorToCourse(assignMentorToCourseReq);
		if (assignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + assignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + assignMentorToCourseResp.getMessage());
    	assignMentorToCourseReq.setMentorUsername("mentor2");
    	assignMentorToCourseReq.setCourseId("Kaseya 1");
    	assignMentorToCourseResp = 
			stub.assignMentorToCourse(assignMentorToCourseReq);
		if (assignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + assignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + assignMentorToCourseResp.getMessage());
    	assignMentorToCourseReq.setMentorUsername("mentor3");
    	assignMentorToCourseReq.setCourseId("Kaseya 1");
    	assignMentorToCourseResp = 
			stub.assignMentorToCourse(assignMentorToCourseReq);
		if (assignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + assignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + assignMentorToCourseResp.getMessage());
    	assignMentorToCourseReq.setMentorUsername("mentor4");
    	assignMentorToCourseReq.setCourseId("Kaseya 1");
    	assignMentorToCourseResp = 
			stub.assignMentorToCourse(assignMentorToCourseReq);
		if (assignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + assignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + assignMentorToCourseResp.getMessage());
    	assignMentorToCourseReq.setMentorUsername("mentor4");
    	assignMentorToCourseReq.setCourseId("Kaseya 2");
    	assignMentorToCourseResp = 
			stub.assignMentorToCourse(assignMentorToCourseReq);
		if (assignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + assignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + assignMentorToCourseResp.getMessage());
    	System.out.println("[assignMentorToCourse] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 1");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 1:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 2");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 2:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 3");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 3:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 4");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 4:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[unassignMentorToCourse] begin!");
    	UnassignMentorToCourseRequest unassignMentorToCourseReq =
    		new UnassignMentorToCourseRequest();
    	unassignMentorToCourseReq.setMentorUsername("mentor");
    	unassignMentorToCourseReq.setCourseId("Kaseya 1");
    	UnassignMentorToCourseResponse unassignMentorToCourseResp = null;
    	// UnassignMentorToCourseResponse unassignMentorToCourseResp = 
		// 	stub.unassignMentorToCourse(unassignMentorToCourseReq);
		// if (unassignMentorToCourseResp.getSuccess())
		//	System.out.println("Successful!" + unassignMentorToCourseResp.getMessage());
		//else
		//	System.out.println("Not Successful!" + unassignMentorToCourseResp.getMessage());
    	unassignMentorToCourseReq.setMentorUsername("mentor");
    	unassignMentorToCourseReq.setCourseId("Kaseya 2");
    	unassignMentorToCourseResp = 
			stub.unassignMentorToCourse(unassignMentorToCourseReq);
		if (unassignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + unassignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + unassignMentorToCourseResp.getMessage());
    	unassignMentorToCourseReq.setMentorUsername("mentor");
    	unassignMentorToCourseReq.setCourseId("Kaseya 3");
    	unassignMentorToCourseResp = 
			stub.unassignMentorToCourse(unassignMentorToCourseReq);
		if (unassignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + unassignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + unassignMentorToCourseResp.getMessage());
    	unassignMentorToCourseReq.setMentorUsername("mentor4");
    	unassignMentorToCourseReq.setCourseId("Kaseya 2");
    	unassignMentorToCourseResp = 
			stub.unassignMentorToCourse(unassignMentorToCourseReq);
		if (unassignMentorToCourseResp.getSuccess())
			System.out.println("Successful!" + unassignMentorToCourseResp.getMessage());
		else
			System.out.println("Not Successful!" + unassignMentorToCourseResp.getMessage());
    	System.out.println("[unassignMentorToCourse] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 1");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 1:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 2");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 2:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 3");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 3:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentorList] begin!");
    	getMentorListReq =
    		new GetMentorListRequest();
    	getMentorListReq.setCourseId("Kaseya 4");
		getMentorListResp = 
			stub.getMentorList(getMentorListReq);
		if (getMentorListResp.getSuccess()) {
			
			System.out.println("Successful!" + getMentorListResp.getMessage());
			String [] mentorUsernames = 
				getMentorListResp.getMentorUsername();
			System.out.println("Mentors for Kaseya 4:");
			if (mentorUsernames != null)
			for (int i=0; i<mentorUsernames.length; i++)
				System.out.println("	" + mentorUsernames[i]);

		}
		else
			System.out.println("Not Successful!" + getMentorListResp.getMessage());
    	System.out.println("[getMentorList] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentorUnallocatedWorktimeAvailability] begin!");
    	GetMentorUnallocatedWorktimeAvailabilityRequest 
    	getMentorUnallocatedWorktimeAvailabilityReq =
    		new GetMentorUnallocatedWorktimeAvailabilityRequest();
    	getMentorUnallocatedWorktimeAvailabilityReq.setMentorUsername("mentor");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
    	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
    	getMentorUnallocatedWorktimeAvailabilityReq.setTimePeriod(timePeriod);
    	GetMentorUnallocatedWorktimeAvailabilityResponse getMentorUnallocatedWorktimeAvailabilityResp = 
			stub.getMentorUnallocatedWorktimeAvailability(getMentorUnallocatedWorktimeAvailabilityReq);
		if (getMentorUnallocatedWorktimeAvailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentorUnallocatedWorktimeAvailabilityResp.getMessage());
			TimePeriod [] getMentorUnallocatedWorktimeAvailabilityList =
				getMentorUnallocatedWorktimeAvailabilityResp.getAvailabilityRange();
			if (getMentorUnallocatedWorktimeAvailabilityList != null) {
			
				System.out.println("getMentorUnallocatedWorktimeAvailability for mentor is:");
				for (int i=0; i<getMentorUnallocatedWorktimeAvailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentorUnallocatedWorktimeAvailabilityList[i].getStartTime().getTime() + " to " +
							getMentorUnallocatedWorktimeAvailabilityList[i].getEndTime().getTime());
				}
			}
		}
		else
			System.out.println("Not Successful!" + getMentorUnallocatedWorktimeAvailabilityResp.getMessage());
    	System.out.println("[getMentorUnallocatedWorktimeAvailability] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorUnallocatedWorktimeUnavailability] begin!");
    	GetMentorUnallocatedWorktimeUnavailabilityRequest 
    	getMentorUnallocatedWorktimeUnavailabilityReq =
    		new GetMentorUnallocatedWorktimeUnavailabilityRequest();
    	getMentorUnallocatedWorktimeUnavailabilityReq.setMentorUsername("mentor");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
    	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
    	getMentorUnallocatedWorktimeUnavailabilityReq.setTimePeriod(timePeriod);
    	GetMentorUnallocatedWorktimeUnavailabilityResponse getMentorUnallocatedWorktimeUnavailabilityResp = 
			stub.getMentorUnallocatedWorktimeUnavailability(getMentorUnallocatedWorktimeUnavailabilityReq);
		if (getMentorUnallocatedWorktimeUnavailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentorUnallocatedWorktimeUnavailabilityResp.getMessage());
			TimePeriod [] getMentorUnallocatedWorktimeUnavailabilityList =
				getMentorUnallocatedWorktimeUnavailabilityResp.getUnavailabilityRange();
			if (getMentorUnallocatedWorktimeUnavailabilityList != null) {
			
				System.out.println("getMentorUnallocatedWorktimeUnavailability for mentor is:");
				for (int i=0; i<getMentorUnallocatedWorktimeUnavailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentorUnallocatedWorktimeUnavailabilityList[i].getStartTime().getTime() + " to " +
							getMentorUnallocatedWorktimeUnavailabilityList[i].getEndTime().getTime());
				}
			}
		}
		else
			System.out.println("Not Successful!" + getMentorUnallocatedWorktimeUnavailabilityResp.getMessage());
    	System.out.println("[getMentorUnallocatedWorktimeUnavailability] end!");
    	////////////////////////////////////////////////////
	
    	////////////////////////////////////////////////////
    	System.out.println("[scheduleMentorUnallocatedWorktime] begin!");
    	ScheduleMentorUnallocatedWorktimeRequest scheduleMentorUnallocatedWorktimeReq =
    		new ScheduleMentorUnallocatedWorktimeRequest();
    	scheduleMentorUnallocatedWorktimeReq.setMentorUsername("mentor");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,19,8,0));
    	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,19,12,0));
    	scheduleMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	ScheduleMentorUnallocatedWorktimeResponse scheduleMentorUnallocatedWorktimeResp = 
			stub.scheduleMentorUnallocatedWorktime(scheduleMentorUnallocatedWorktimeReq);
		if (scheduleMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
    	scheduleMentorUnallocatedWorktimeReq =
    		new ScheduleMentorUnallocatedWorktimeRequest();
    	scheduleMentorUnallocatedWorktimeReq.setMentorUsername("mentor");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
     			new GregorianCalendar(2010,7-1,18,9,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,18,10,0));
    	scheduleMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	scheduleMentorUnallocatedWorktimeResp = 
			stub.scheduleMentorUnallocatedWorktime(scheduleMentorUnallocatedWorktimeReq);
		if (scheduleMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
    	scheduleMentorUnallocatedWorktimeReq =
    		new ScheduleMentorUnallocatedWorktimeRequest();
    	scheduleMentorUnallocatedWorktimeReq.setMentorUsername("mentor4");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,21,8,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,21,10,0));
    	scheduleMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	scheduleMentorUnallocatedWorktimeResp = 
			stub.scheduleMentorUnallocatedWorktime(scheduleMentorUnallocatedWorktimeReq);
		if (scheduleMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
    	scheduleMentorUnallocatedWorktimeReq =
    		new ScheduleMentorUnallocatedWorktimeRequest();
    	scheduleMentorUnallocatedWorktimeReq.setMentorUsername("mentor4");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,22,8,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,22,10,0));
    	scheduleMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	scheduleMentorUnallocatedWorktimeResp = 
			stub.scheduleMentorUnallocatedWorktime(scheduleMentorUnallocatedWorktimeReq);
		if (scheduleMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
    	scheduleMentorUnallocatedWorktimeReq =
    		new ScheduleMentorUnallocatedWorktimeRequest();
    	scheduleMentorUnallocatedWorktimeReq.setMentorUsername("mentor4");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,19,8,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,19,10,0));
    	scheduleMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	scheduleMentorUnallocatedWorktimeResp = 
			stub.scheduleMentorUnallocatedWorktime(scheduleMentorUnallocatedWorktimeReq);
		if (scheduleMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + scheduleMentorUnallocatedWorktimeResp.getMessage());
    	System.out.println("[scheduleMentorUnallocatedWorktime] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorUnallocatedWorktimeAvailability] begin!");
    	getMentorUnallocatedWorktimeAvailabilityReq =
    		new GetMentorUnallocatedWorktimeAvailabilityRequest();
    	getMentorUnallocatedWorktimeAvailabilityReq.setMentorUsername("mentor4");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
     	getMentorUnallocatedWorktimeAvailabilityReq.setTimePeriod(timePeriod);
    	getMentorUnallocatedWorktimeAvailabilityResp = 
			stub.getMentorUnallocatedWorktimeAvailability(getMentorUnallocatedWorktimeAvailabilityReq);
		if (getMentorUnallocatedWorktimeAvailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentorUnallocatedWorktimeAvailabilityResp.getMessage());
			TimePeriod [] getMentorUnallocatedWorktimeAvailabilityList =
				getMentorUnallocatedWorktimeAvailabilityResp.getAvailabilityRange();
			if (getMentorUnallocatedWorktimeAvailabilityList != null) {
			
				System.out.println("getMentorUnallocatedWorktimeAvailability for mentor is:");
				for (int i=0; i<getMentorUnallocatedWorktimeAvailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentorUnallocatedWorktimeAvailabilityList[i].getStartTime().getTime() + " to " +
							getMentorUnallocatedWorktimeAvailabilityList[i].getEndTime().getTime());
				}
			}
		}
		else
			System.out.println("Not Successful!" + getMentorUnallocatedWorktimeAvailabilityResp.getMessage());
    	System.out.println("[getMentorUnallocatedWorktimeAvailability] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentorUnallocatedWorktimeUnavailability] begin!");
    	getMentorUnallocatedWorktimeUnavailabilityReq =
    		new GetMentorUnallocatedWorktimeUnavailabilityRequest();
    	getMentorUnallocatedWorktimeUnavailabilityReq.setMentorUsername("mentor");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
     	getMentorUnallocatedWorktimeUnavailabilityReq.setTimePeriod(timePeriod);
    	getMentorUnallocatedWorktimeUnavailabilityResp = 
			stub.getMentorUnallocatedWorktimeUnavailability(getMentorUnallocatedWorktimeUnavailabilityReq);
		if (getMentorUnallocatedWorktimeUnavailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentorUnallocatedWorktimeUnavailabilityResp.getMessage());
			TimePeriod [] getMentorUnallocatedWorktimeUnavailabilityList =
				getMentorUnallocatedWorktimeUnavailabilityResp.getUnavailabilityRange();
			if (getMentorUnallocatedWorktimeUnavailabilityList != null) {
			
				System.out.println("getMentorUnallocatedWorktimeUnavailability for mentor is:");
				for (int i=0; i<getMentorUnallocatedWorktimeUnavailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentorUnallocatedWorktimeUnavailabilityList[i].getStartTime().getTime() + " to " +
							getMentorUnallocatedWorktimeUnavailabilityList[i].getEndTime().getTime());
				}
			}
		}
		else
			System.out.println("Not Successful!" + getMentorUnallocatedWorktimeUnavailabilityResp.getMessage());
    	System.out.println("[getMentorUnallocatedWorktimeUnavailability] end!");
    	////////////////////////////////////////////////////
	
    	////////////////////////////////////////////////////
    	System.out.println("[cancelScheduledMentorUnallocatedWorktime] begin!");
    	CancelScheduledMentorUnallocatedWorktimeRequest cancelScheduledMentorUnallocatedWorktimeReq =
    		new CancelScheduledMentorUnallocatedWorktimeRequest();
    	cancelScheduledMentorUnallocatedWorktimeReq.setId("1");    	
    	CancelScheduledMentorUnallocatedWorktimeResponse cancelScheduledMentorUnallocatedWorktimeResp = 
			stub.cancelScheduledMentorUnallocatedWorktime(cancelScheduledMentorUnallocatedWorktimeReq);
		if (cancelScheduledMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + cancelScheduledMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + cancelScheduledMentorUnallocatedWorktimeResp.getMessage());
    	System.out.println("[cancelScheduledMentorUnallocatedWorktime] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[modifyScheduledMentorUnallocatedWorktime] begin!");
    	ModifyScheduledMentorUnallocatedWorktimeRequest modifyScheduledMentorUnallocatedWorktimeReq =
    		new ModifyScheduledMentorUnallocatedWorktimeRequest();
    	modifyScheduledMentorUnallocatedWorktimeReq.setId("2");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,21,8,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,21,12,0));
     	modifyScheduledMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	ModifyScheduledMentorUnallocatedWorktimeResponse modifyScheduledMentorUnallocatedWorktimeResp = 
			stub.modifyScheduledMentorUnallocatedWorktime(modifyScheduledMentorUnallocatedWorktimeReq);
		if (modifyScheduledMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + modifyScheduledMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + modifyScheduledMentorUnallocatedWorktimeResp.getMessage());
    	modifyScheduledMentorUnallocatedWorktimeReq.setId("3");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,14,11,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,14,13,0));
     	modifyScheduledMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	modifyScheduledMentorUnallocatedWorktimeResp = 
			stub.modifyScheduledMentorUnallocatedWorktime(modifyScheduledMentorUnallocatedWorktimeReq);
		if (modifyScheduledMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + modifyScheduledMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + modifyScheduledMentorUnallocatedWorktimeResp.getMessage());
    	modifyScheduledMentorUnallocatedWorktimeReq.setId("4");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,11-1,14,11,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,11-1,14,13,0));
     	modifyScheduledMentorUnallocatedWorktimeReq.setTimePeriod(timePeriod);
    	modifyScheduledMentorUnallocatedWorktimeResp = 
			stub.modifyScheduledMentorUnallocatedWorktime(modifyScheduledMentorUnallocatedWorktimeReq);
		if (modifyScheduledMentorUnallocatedWorktimeResp.getSuccess())
			System.out.println("Successful!" + modifyScheduledMentorUnallocatedWorktimeResp.getMessage());
		else
			System.out.println("Not Successful!" + modifyScheduledMentorUnallocatedWorktimeResp.getMessage());
    	System.out.println("[modifyScheduledMentorUnallocatedWorktime] end!");
    	////////////////////////////////////////////////////		

//////////
 
    	////////////////////////////////////////////////////
    	System.out.println("[getMentoringAvailability] begin (mentor, Kaseya 1, student11)!");
    	GetMentoringAvailabilityRequest 
    	getMentoringAvailabilityReq =
    		new GetMentoringAvailabilityRequest();
    	getMentoringAvailabilityReq.setMentorUsername("mentor");
    	getMentoringAvailabilityReq.setCourseId("Kaseya 1");
    	getMentoringAvailabilityReq.setStudentUsername("student11");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
     	getMentoringAvailabilityReq.setTimePeriod(timePeriod);
    	GetMentoringAvailabilityResponse getMentoringAvailabilityResp = 
			stub.getMentoringAvailability(getMentoringAvailabilityReq);
		if (getMentoringAvailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentoringAvailabilityResp.getMessage());
			TimePeriod [] getMentoringAvailabilityList =
				getMentoringAvailabilityResp.getAvailabilityRange();
			if (getMentoringAvailabilityList != null) {
			
				System.out.println("getMentoringAvailability for mentor is:");
				for (int i=0; i<getMentoringAvailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentoringAvailabilityList[i].getStartTime().getTime() + " to " +
							getMentoringAvailabilityList[i].getEndTime().getTime());
				}
			}
			else
				System.out.println("getMentoringAvailability returned a null list!");

		}
		else
			System.out.println("Not Successful!" + getMentoringAvailabilityResp.getMessage());
    	System.out.println("[getMentoringAvailability] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentoringUnavailability] begin (mentor, Kaseya 1, student11)!");
    	GetMentoringUnavailabilityRequest 
    	getMentoringUnavailabilityReq =
    		new GetMentoringUnavailabilityRequest();
    	getMentoringUnavailabilityReq.setMentorUsername("mentor");
    	getMentoringUnavailabilityReq.setCourseId("Kaseya 1");
    	getMentoringUnavailabilityReq.setStudentUsername("student11");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
     	getMentoringUnavailabilityReq.setTimePeriod(timePeriod);
    	GetMentoringUnavailabilityResponse getMentoringUnavailabilityResp = 
			stub.getMentoringUnavailability(getMentoringUnavailabilityReq);
		if (getMentoringUnavailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentoringUnavailabilityResp.getMessage());
			TimePeriod [] getMentoringUnavailabilityList =
				getMentoringUnavailabilityResp.getUnavailabilityRange();
			if (getMentoringUnavailabilityList != null) {
			
				System.out.println("getMentoringUnavailability for mentor is:");
				for (int i=0; i<getMentoringUnavailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentoringUnavailabilityList[i].getStartTime().getTime() + " to " +
							getMentoringUnavailabilityList[i].getEndTime().getTime());
				}
			}
		}
		else
			System.out.println("Not Successful!" + getMentoringUnavailabilityResp.getMessage());
    	System.out.println("[getMentoringUnavailability] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentoringAvailability] begin (null, Kaseya 1, null)!");
    	getMentoringAvailabilityReq =
    		new GetMentoringAvailabilityRequest();
    	getMentoringAvailabilityReq.setMentorUsername(null);
    	getMentoringAvailabilityReq.setCourseId("Kaseya 1");
    	getMentoringAvailabilityReq.setStudentUsername(null);
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
     	getMentoringAvailabilityReq.setTimePeriod(timePeriod);
    	getMentoringAvailabilityResp = 
			stub.getMentoringAvailability(getMentoringAvailabilityReq);
		if (getMentoringAvailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentoringAvailabilityResp.getMessage());
			TimePeriod [] getMentoringAvailabilityList =
				getMentoringAvailabilityResp.getAvailabilityRange();
			if (getMentoringAvailabilityList != null) {
			
				System.out.println("getMentoringAvailability for mentor is:");
				for (int i=0; i<getMentoringAvailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentoringAvailabilityList[i].getStartTime().getTime() + " to " +
							getMentoringAvailabilityList[i].getEndTime().getTime());
				}
			}
			else
				System.out.println("getMentoringAvailability returned a null list!");

		}
		else
			System.out.println("Not Successful!" + getMentoringAvailabilityResp.getMessage());
    	System.out.println("[getMentoringAvailability] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[getMentoringUnavailability] begin (null, Kaseya 1, null)!");
    	getMentoringUnavailabilityReq =
    		new GetMentoringUnavailabilityRequest();
    	getMentoringUnavailabilityReq.setMentorUsername(null);
    	getMentoringUnavailabilityReq.setCourseId("Kaseya 1");
    	getMentoringUnavailabilityReq.setStudentUsername(null);
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
     	getMentoringUnavailabilityReq.setTimePeriod(timePeriod);
    	getMentoringUnavailabilityResp = 
			stub.getMentoringUnavailability(getMentoringUnavailabilityReq);
		if (getMentoringUnavailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentoringUnavailabilityResp.getMessage());
			TimePeriod [] getMentoringUnavailabilityList =
				getMentoringUnavailabilityResp.getUnavailabilityRange();
			if (getMentoringUnavailabilityList != null) {
			
				System.out.println("getMentoringUnavailability for mentor is:");
				for (int i=0; i<getMentoringUnavailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentoringUnavailabilityList[i].getStartTime().getTime() + " to " +
							getMentoringUnavailabilityList[i].getEndTime().getTime());
				}
			}
		}
		else
			System.out.println("Not Successful!" + getMentoringUnavailabilityResp.getMessage());
    	System.out.println("[getMentoringUnavailability] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[scheduleMentoring] begin!");
    	ScheduleMentoringRequest scheduleMentoringReq =
    		new ScheduleMentoringRequest();
    	scheduleMentoringReq.setMentorUsername("mentor");
    	scheduleMentoringReq.setCourseId("Kaseya 1");
    	scheduleMentoringReq.setStudentUsername("student11");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,19,9,0));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,19,10,0));
     	scheduleMentoringReq.setTimePeriod(timePeriod);
    	ScheduleMentoringResponse scheduleMentoringResp = 
			stub.scheduleMentoring(scheduleMentoringReq);
		if (scheduleMentoringResp.getSuccess())
			System.out.println("Successful!" + scheduleMentoringResp.getMessage());
		else
			System.out.println("Not Successful!" + scheduleMentoringResp.getMessage());
    	System.out.println("[scheduleMentoring] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[getMentoringAvailability] begin student11!");
    	getMentoringAvailabilityReq =
    		new GetMentoringAvailabilityRequest();
    	getMentoringAvailabilityReq.setMentorUsername(null);
    	getMentoringAvailabilityReq.setCourseId("Kaseya 1");
    	getMentoringAvailabilityReq.setStudentUsername("student11");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,1));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,10-1,1));
     	getMentoringAvailabilityReq.setTimePeriod(timePeriod);
    	getMentoringAvailabilityResp = 
			stub.getMentoringAvailability(getMentoringAvailabilityReq);
		if (getMentoringAvailabilityResp.getSuccess()) {
		
			System.out.println("Successful!" + getMentoringAvailabilityResp.getMessage());
			TimePeriod [] getMentoringAvailabilityList =
				getMentoringAvailabilityResp.getAvailabilityRange();
			if (getMentoringAvailabilityList != null) {
			
				System.out.println("getMentoringAvailability for mentor is:");
				for (int i=0; i<getMentoringAvailabilityList.length; i++) {
			
					System.out.println("	" + 
							getMentoringAvailabilityList[i].getStartTime().getTime() + " to " +
							getMentoringAvailabilityList[i].getEndTime().getTime());
				}
			}
			else
				System.out.println("getMentoringAvailability returned a null list!");

		}
		else
			System.out.println("Not Successful!" + getMentoringAvailabilityResp.getMessage());
    	System.out.println("[getMentoringAvailability] end!");
    	////////////////////////////////////////////////////

    	////////////////////////////////////////////////////
    	System.out.println("[cancelScheduledMentoring] begin!");
    	CancelScheduledMentoringRequest cancelScheduledMentoringReq =
    		new CancelScheduledMentoringRequest();
    	cancelScheduledMentoringReq.setId("101");    	
    	CancelScheduledMentoringResponse cancelScheduledMentoringResp = 
			stub.cancelScheduledMentoring(cancelScheduledMentoringReq);
		if (cancelScheduledMentoringResp.getSuccess())
			System.out.println("Successful!" + cancelScheduledMentoringResp.getMessage());
		else
			System.out.println("Not Successful!" + cancelScheduledMentoringResp.getMessage());
    	System.out.println("[cancelScheduledMentoring] end!");
    	////////////////////////////////////////////////////
		
    	////////////////////////////////////////////////////
    	System.out.println("[modifyScheduledMentoring] begin!");
    	ModifyScheduledMentoringRequest modifyScheduledMentoringReq =
    		new ModifyScheduledMentoringRequest();
    	modifyScheduledMentoringReq.setId("102");
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(
    			new GregorianCalendar(2010,7-1,19,9,30));
     	timePeriod.setEndTime(
    			new GregorianCalendar(2010,7-1,19,10,0));
     	modifyScheduledMentoringReq.setTimePeriod(timePeriod);
    	ModifyScheduledMentoringResponse modifyScheduledMentoringResp = 
			stub.modifyScheduledMentoring(modifyScheduledMentoringReq);
		if (modifyScheduledMentoringResp.getSuccess())
			System.out.println("Successful!" + modifyScheduledMentoringResp.getMessage());
		else
			System.out.println("Not Successful!" + modifyScheduledMentoringResp.getMessage());
    	System.out.println("[modifyScheduledMentoring] end!");
    	////////////////////////////////////////////////////		
    }


	public static void main(String [] args) {
    	
    	if(args.length != 1) {
    		System.out.println("Usage: ./runclient.sh <port_numver>");
    		System.out.println("  Example: ./runclient.sh 8080");
    		return;
    	} 
    		
    	try {
		
    		String epr = "http://localhost:" + args[0] + "/axis2/services/MentorScheduler";
    		MentorSchedulerClient client = new MentorSchedulerClient(epr);

    		client.test();
    	}
    	catch(Exception e) {
    		System.out.println("Exception: " + e);
    		System.out.println("Message: " + e.getMessage());
    		e.printStackTrace();
    	}

    }

}
