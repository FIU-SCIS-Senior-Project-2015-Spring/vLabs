package edu.fiu.cis.acrl.vescheduler.client;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import edu.fiu.cis.acrl.vescheduler.server.Host;
import edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse;
import edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest;
import edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse;
import edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.VESchedulerStub;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse;
import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VirtualEnvironmentType;

import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;

import org.apache.axis2.AxisFault;

public class VESchedulerClient {

    private VESchedulerStub stub;

    public VESchedulerClient(String epr) throws AxisFault {
	
    	stub = new VESchedulerStub(epr);	
    
    }

    /**
     * Reads a VE description from an XML file and returns its AXIOM representation
     */
    public static VirtualEnvironmentType readVE(File veFile) throws Exception {
	
    	XMLInputFactory xif= XMLInputFactory.newInstance();
    	XMLStreamReader reader= xif.createXMLStreamReader(new FileInputStream(veFile));
    	return VirtualEnvironmentType.Factory.parse(reader);

    }

    private ScheduleVEResponse scheduleVE(File veFile, String veInsId, Calendar startTime, 
    		Calendar endTime, boolean store) throws Exception {
	
    	ScheduleVERequest request = new ScheduleVERequest();
    	request.setVe(readVE(veFile));
    	request.setVeInsId(veInsId);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	request.setStore(store);
	
    	return stub.scheduleVE(request);
	
    }

    private CancelScheduledVEResponse cancelScheduledVE(String id) throws Exception {
	
    	CancelScheduledVERequest request = new CancelScheduledVERequest();
    	request.setSchId(id);
	
    	return stub.cancelScheduledVE(request);
	
    }

    private ModifyScheduledVEResponse modifyScheduledVE(String id, Calendar startTime, 
    		Calendar endTime) throws Exception {
    	
    	ModifyScheduledVERequest request = new ModifyScheduledVERequest();
    	request.setSchId(id);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.modifyScheduledVE(request);
    	
    }
    
    private GetVEAvailabilityResponse getVEAvailability(File veFile, String id, 
    		Calendar startTime, Calendar endTime) throws Exception {
    	
    	GetVEAvailabilityRequest request = new GetVEAvailabilityRequest();
    	request.setVe(readVE(veFile));
    	request.setVeInsId(id);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.getVEAvailability(request);
    	
    }
    
    private GetVEUnavailabilityResponse getVEUnavailability(File veFile, String id, 
    		Calendar startTime, Calendar endTime) throws Exception {
    	
    	GetVEUnavailabilityRequest request = new GetVEUnavailabilityRequest();
    	request.setVe(readVE(veFile));
    	request.setId(id);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.getVEUnavailability(request);
    	
    }
    
    private GetVEInsScheduleResponse getVESchedule(File veFile, String id, 
    		Calendar startTime, Calendar endTime) throws Exception {
    	
    	GetVEInsScheduleRequest request = new GetVEInsScheduleRequest();
    	request.setVeInsId(id);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.getVEInsSchedule(request);
    	
    }
    
    private SetConfigurationResponse setConfiguration(
    		Calendar userStart, 
    		Calendar userEnd,
    		Calendar adminStart,
    		Calendar adminEnd) 
    	throws Exception {
    	
    	SetConfigurationRequest request = new SetConfigurationRequest();
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(userStart);
    	timePeriod.setEndTime(userEnd);
    	request.setUserTimePeriod(timePeriod);
    	timePeriod = new TimePeriod();
    	timePeriod.setStartTime(adminStart);
    	timePeriod.setEndTime(adminEnd);
    	request.setAdminTimePeriod(timePeriod);
    	
    	return stub.setConfiguration(request);
    }
    
    private GetConfigurationResponse getConfiguration() throws Exception {
    	
    	return stub.getConfiguration();
    	
    }
    
    private GetHostResponse getHost(int hostId) throws Exception {
    	
    	GetHostRequest request = new GetHostRequest();
    	request.setHostId(hostId);
    	
    	return stub.getHost(request);
    	
    }
    
    private GetHostListResponse getHostList(boolean active) throws Exception {
    	
    	GetHostListRequest request = new GetHostListRequest();
    	request.setActive(active);
    	return stub.getHostList(request);
    	
    }
    
    private AddHostResponse addHost(Host host) throws Exception {
    	
    	System.out.println("[AddHost] host name: " + host.getName());
    	
    	AddHostRequest request = new AddHostRequest();
    	request.setHost(host.getConvertedHost());
    	
    	return stub.addHost(request);
    	
    }
    
    private SetHostResponse setHost(Host host) throws Exception {
    	
    	SetHostRequest request = new SetHostRequest();
    	request.setHost(host.getConvertedHost());
    	
    	return stub.setHost(request);
    	
    }
    
    private DelHostResponse delHost(int hostId) throws Exception {
    	
    	DelHostRequest request = new DelHostRequest();
    	request.setHostId(hostId);
    	
    	return stub.delHost(request);
    	
    }
    
    private ScheduleHostMaintenanceResponse 
    	scheduleHostMaintenance(
    		int hosId, 
    		Calendar startTime, 
    		Calendar endTime) throws Exception {
	
    	ScheduleHostMaintenanceRequest request = new ScheduleHostMaintenanceRequest();
    	request.setHostId(hosId);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.scheduleHostMaintenance(request);
	
    }

    private CancelScheduledHostMaintenanceResponse 
    	cancelScheduledHostMaintenance(String id) throws Exception {
	
    	CancelScheduledHostMaintenanceRequest request = 
    		new CancelScheduledHostMaintenanceRequest();
    	request.setSchId(id);
	
    	return stub.cancelScheduledHostMaintenance(request);
	
    }

    private ModifyScheduledHostMaintenanceResponse 
    	modifyScheduledHostMaintenance(
    			String id, 
    			Calendar startTime, 
    			Calendar endTime) throws Exception {
    	
    	ModifyScheduledHostMaintenanceRequest request = 
    		new ModifyScheduledHostMaintenanceRequest();
    	request.setSchId(id);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.modifyScheduledHostMaintenance(request);
    	
    }
    
    private GetHostMaintenanceAvailabilityResponse 
    	getHostMaintenanceAvailability(
    			int hostId, 
    			Calendar startTime, 
    			Calendar endTime) throws Exception {
    	
    	GetHostMaintenanceAvailabilityRequest request = 
    		new GetHostMaintenanceAvailabilityRequest();
    	request.setHostId(hostId);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.getHostMaintenanceAvailability(request);
    	
    }
    
    private GetHostMaintenanceUnavailabilityResponse 
    	getHostMaintenanceUnavailability(
    			int hostId, 
    			Calendar startTime, 
    			Calendar endTime) throws Exception {
    	
    	GetHostMaintenanceUnavailabilityRequest request = 
    		new GetHostMaintenanceUnavailabilityRequest();
    	request.setHostId(hostId);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.getHostMaintenanceUnavailability(request);
    	
    }
    
    private GetHostMaintenanceScheduleResponse 
    	getHostMaintenanceSchedule(
    			int hostId, 
    			Calendar startTime, 
    			Calendar endTime) throws Exception {
    	
    	GetHostMaintenanceScheduleRequest request = 
    		new GetHostMaintenanceScheduleRequest();
    	request.setHostId(hostId);
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(startTime);
    	timePeriod.setEndTime(endTime);
    	request.setTimePeriod(timePeriod);
    	
    	return stub.getHostMaintenanceSchedule(request);
    	
    }
    

    /**********************
     * For testing purposes

     **********************/

    
    private void test() throws Exception {
	
 	    /*
 		start = Calendar.getInstance();
		end = Calendar.getInstance();
		end.add(Calendar.HOUR, 6);
		ModifyScheduledVEResponse resp3 = modifyScheduledVE(resp1.getId(), start, end);
		if (resp3.getSuccess()) 
			System.out.println("modifyScheduledVE is done! id: " + resp3.getId());
		else
			System.out.println("modifySchedule was NOT successful: " + resp3.getMessage());
		
		GetVEAvailabilityResponse resp5 = getVEAvailability(new File("sample.xml"), null, 
				start, end);
		if (resp5.getSuccess()) {
		
			System.out.println("getVEAvailability 2 is done!");
			System.out.println("Availability 2: " + resp5.getAvailabilityRange().length);
		
		}
		else
			System.out.println("getVEAvailability 2 was NOT successful: " + resp5.getMessage());
		
		GetVEUnavailabilityResponse resp6 = getVEUnavailability(new File("sample.xml"), "1", 
				start, end);
		if (resp6.getSuccess()) {
			
			System.out.println("getVEUnavailability 1 is done!");
			System.out.println("Unavailability 1: " + resp6.getUnavailabilityRange().length);
		
		}
		else
			System.out.println("getVEUnavailability 1 was NOT successful: " + resp6.getMessage());
		
		GetVEUnavailabilityResponse resp7 = getVEUnavailability(new File("sample.xml"), null, 
				start, end);
		if (resp7.getSuccess()) {
			
			System.out.println("getVEUnavailability 2 is done!");
			System.out.println("Unavailability 2: " + resp7.getUnavailabilityRange().length);
		
		}
		else
			System.out.println("getVEUnavailability 2 was NOT Successful: " + resp7.getMessage());
		
		GetVEScheduleResponse resp8 = getVESchedule(new File("sample.xml"), 
				resp1.getId(), start, end);
		if (resp8.getSuccess()) {
			
			System.out.println("GetVESchedule is done!");
			System.out.println("ScheduledAppointments: " + resp8.getSchedule().length);
		
		}
		else
			System.out.println("getVESchedule was NOT successful: " + resp8.getMessage());
		
		*/
    	
		GetConfigurationResponse getConfResp = getConfiguration();
		if (getConfResp.getSuccess()) {
		
			System.out.println("Oringinal Configuration: ");
			System.out.println("  User: " + getConfResp.getUserTimePeriod().getStartTime().getTime() +
					" to " + getConfResp.getUserTimePeriod().getEndTime().getTime());
			System.out.println("  Admin: " + getConfResp.getAdminTimePeriod().getStartTime().getTime() +
					" to " + getConfResp.getAdminTimePeriod().getEndTime().getTime());
		
		}		
		else
			System.out.println("getConfiguration was NOT successful: " + getConfResp.getMessage());		

		SetConfigurationResponse setConfResp = 
			setConfiguration(
					new GregorianCalendar(2010,7-1,1), 
					new GregorianCalendar(2010,9-1,1), 
					new GregorianCalendar(2010,6-1,1), 
					new GregorianCalendar(2010,10-1,1));
		if (setConfResp.getSuccess())
			System.out.println("New configuration was set successfully!");
		else
			System.out.println("New configuration was NOT set successfully!");
		
		ScheduleHostMaintenanceResponse schHostMainResp = 
    		scheduleHostMaintenance(
    				1,
    				new GregorianCalendar(2010,8-1,28,8,0,0),
    				new GregorianCalendar(2010,8-1,28,12,0,0));
		if (schHostMainResp.getSuccess())
			System.out.println("First scheduleHostMaintenance is done!");
		else
			System.out.println("First scheduleHostMaintenance was NOT successful: " + 
					schHostMainResp.getMessage());
	
    	ScheduleHostMaintenanceResponse schHostMainResp2 = 
    		scheduleHostMaintenance(
    				2,
    				new GregorianCalendar(2010,8-1,28,8,0,0),
    				new GregorianCalendar(2010,8-1,28,12,0,0));
		if (schHostMainResp2.getSuccess())
			System.out.println("Second scheduleHostMaintenance is done!");
		else
			System.out.println("Second scheduleHostMaintenance was NOT successful: " + 
					schHostMainResp2.getMessage());
	
		ModifyScheduledHostMaintenanceResponse modifySchHostMainResp = 
			modifyScheduledHostMaintenance(
					schHostMainResp2.getSchId(), 
    				new GregorianCalendar(2010,8-1,29,8,0,0),
    				new GregorianCalendar(2010,8-1,29,12,0,0));
		if (modifySchHostMainResp.getSuccess()) 
			System.out.println("modifyScheduledHostMaintenance is done! id: " + 
					modifySchHostMainResp.getSchId());
		else
			System.out.println("modifySchedule was NOT successful: " + 
					modifySchHostMainResp.getMessage());
		
    	ScheduleHostMaintenanceResponse schHostMainResp3 = 
    		scheduleHostMaintenance(
    				2,
    				new GregorianCalendar(2010,8-1,28,6,0,0),
    				new GregorianCalendar(2010,8-1,28,13,0,0));
		if (schHostMainResp3.getSuccess())
			System.out.println("Third scheduleHostMaintenance is done!");
		else
			System.out.println("Third scheduleHostMaintenance was NOT successful: " + 
					schHostMainResp3.getMessage());
	
		CancelScheduledHostMaintenanceResponse cancelSchHostMainResp = 
			cancelScheduledHostMaintenance(schHostMainResp3.getSchId());
		if (cancelSchHostMainResp.getSuccess()) 
			System.out.println("cancelScheduledHostMaintenance is done!");
		else
			System.out.println("cancelScheduledHostMaintenance was NOT successful: " + 
					cancelSchHostMainResp.getMessage());
	
		ScheduleVEResponse schVEResp = scheduleVE(
				new File("sample.xml"), 
				null,
				new GregorianCalendar(2010,8-1,28,8,0,0),
				new GregorianCalendar(2010,8-1,28,12,0,0),
				true);
		if (schVEResp.getSuccess())
			System.out.println("First scheduleVE is done!");
		else
			System.out.println("First scheduleVE was NOT successful: " + 
					schVEResp.getMessage());
	
		ScheduleVEResponse schVEResp2 = scheduleVE(
				new File("sample.xml"), 
				schVEResp.getSchId(),
				new GregorianCalendar(2010,8-1,29,8,0,0),
				new GregorianCalendar(2010,8-1,29,12,0,0),
				true);
			if (schVEResp2.getSuccess())
				System.out.println("First scheduleVE is done!");
			else
				System.out.println("First scheduleVE was NOT successful: " + 
						schVEResp2.getMessage());
			
		ScheduleVEResponse schVEResp3 = scheduleVE(
				new File("sample.xml"), 
				schVEResp.getSchId(),
				new GregorianCalendar(2010,8-1,30,9,0,0),
				new GregorianCalendar(2010,8-1,30,10,0,0),
				true);
			if (schVEResp3.getSuccess())
				System.out.println("First scheduleVE is done!");
			else
				System.out.println("First scheduleVE was NOT successful: " + 
						schVEResp3.getMessage());
			
		GetVEInsScheduleResponse getVEInsSchResp = 
			getVESchedule(
					new File("sample.xml"), 
					schVEResp.getSchId(), 
					new GregorianCalendar(2010,6-1,30,9,0,0),
					new GregorianCalendar(2010,9-1,30,10,0,0));
		if (getVEInsSchResp.getSuccess()) {
			
			System.out.println("GetVESchedule is done!");
			System.out.println("ScheduledAppointments: " + getVEInsSchResp.getSchedule().length);
		
		}
		else
			System.out.println("getVESchedule was NOT successful: " + getVEInsSchResp.getMessage());
		
		CancelScheduledVEResponse cancelSchVEResp = cancelScheduledVE(schVEResp3.getSchId());
		if (cancelSchVEResp.getSuccess()) 
			System.out.println("cancelScheduledVE is done!");
		else
			System.out.println("cancelScheduledVE was NOT successful: " + 
					cancelSchVEResp.getMessage());
	
		GetVEInsScheduleResponse getVEInsSchResp2 = 
			getVESchedule(
					new File("sample.xml"), 
					schVEResp.getSchId(), 
					new GregorianCalendar(2010,6-1,30,9,0,0),
					new GregorianCalendar(2010,9-1,30,10,0,0));
		if (getVEInsSchResp2.getSuccess()) {
			
			System.out.println("GetVESchedule is done!");
			System.out.println("ScheduledAppointments: " + getVEInsSchResp2.getSchedule().length);
		
		}
		else
			System.out.println("getVESchedule was NOT successful: " + getVEInsSchResp2.getMessage());
		
		ScheduleVEResponse schVEResp4 = scheduleVE(
				new File("sample.xml"), 
				null,
				new GregorianCalendar(2010,8-1,28,6,0,0),
				new GregorianCalendar(2010,8-1,28,13,0,0),
				true);
			if (schVEResp4.getSuccess())
				System.out.println("First scheduleVE is done!");
			else
				System.out.println("First scheduleVE was NOT successful: " + 
						schVEResp4.getMessage());
			
		ScheduleVEResponse schVEResp5 = scheduleVE(
				new File("sample.xml"), 
				null,
				new GregorianCalendar(2010,8-1,29,9,0,0),
				new GregorianCalendar(2010,8-1,29,10,0,0),
				true);
			if (schVEResp5.getSuccess())
				System.out.println("First scheduleVE is done!");
			else
				System.out.println("First scheduleVE was NOT successful: " + 
						schVEResp5.getMessage());
			
		GetVEAvailabilityResponse getVEAvailResp = getVEAvailability(
				new File("sample.xml"), 
				null,
				new GregorianCalendar(2010,7-1,15),
				new GregorianCalendar(2010,8-1,15));
		if (getVEAvailResp.getSuccess())
			System.out.println("getVEAvailability 1 is done!");
		else
			System.out.println("getVEAvailability 1 was NOT successful: " + 
					getVEAvailResp.getMessage());
		
		GetHostMaintenanceAvailabilityResponse hostMainAvailResp = 
			getHostMaintenanceAvailability(
					1,
					new GregorianCalendar(2010,6-1,15), 
					new GregorianCalendar(2010,10-1,15));
		if (hostMainAvailResp.getSuccess()) 
			System.out.println("getHostMaintenanceAvailability 1 is done!");				
		else
			System.out.println("getHostMaintenanceAvailability was NOT successful: " + 
					hostMainAvailResp.getMessage());
		
		GetHostMaintenanceAvailabilityResponse hostMainAvailResp2 = 
			getHostMaintenanceAvailability(
					2, 
					new GregorianCalendar(2010,6-1,15), 
					new GregorianCalendar(2010,10-1,15));
		if (hostMainAvailResp2.getSuccess()) 
			System.out.println("getHostMaintenanceAvailability 2 is done!");
		else
			System.out.println("getHostMaintenanceAvailability 2 was NOT successful: " + 
					hostMainAvailResp2.getMessage());
		
		setConfResp = 
			setConfiguration(
					new GregorianCalendar(2010,7-1,1), 
					new GregorianCalendar(2010,8-1,1), 
					new GregorianCalendar(2010,6-1,1), 
					new GregorianCalendar(2010,9-1,1));
		if (setConfResp.getSuccess())
			System.out.println("New configuration was set successfully!");
		else
			System.out.println("New configuration was NOT set successfully!");
		
		GetConfigurationResponse getConfResp2 = getConfiguration();
		if (getConfResp.getSuccess()) {
		
			System.out.println("New Configuration: ");
			System.out.println("  User: " + getConfResp2.getUserTimePeriod().getStartTime().getTime() +
					" to " + getConfResp2.getUserTimePeriod().getEndTime().getTime());
			System.out.println("  Admin: " + getConfResp2.getAdminTimePeriod().getStartTime().getTime() +
					" to " + getConfResp2.getAdminTimePeriod().getEndTime().getTime());
		
		}		
		else
			System.out.println("getConfiguration was NOT successful: " + getConfResp.getMessage());		

		GetVEAvailabilityResponse getVEAvailResp2 = getVEAvailability(
				new File("sample.xml"), 
				null, 
				new GregorianCalendar(2010,6-1,15),
				new GregorianCalendar(2010,8-1,15));
		if (getVEAvailResp2.getSuccess())
			System.out.println("getVEAvailability 2 is done!");
		else
			System.out.println("getVEAvailability 2 was NOT successful: " + 
					getVEAvailResp.getMessage());
		
		GetHostMaintenanceAvailabilityResponse hostMainAvailResp3 = 
			getHostMaintenanceAvailability(
					1,
					new GregorianCalendar(2010,6-1,15), 
					new GregorianCalendar(2010,9-1,15));
		if (hostMainAvailResp3.getSuccess()) 
			System.out.println("getHostMaintenanceAvailability 1 is done!");
		else
			System.out.println("getHostMaintenanceAvailability was NOT successful: " + 
					hostMainAvailResp.getMessage());
		
		GetHostMaintenanceAvailabilityResponse hostMainAvailResp4 = 
			getHostMaintenanceAvailability(
					2, 
					new GregorianCalendar(2010,6-1,15), 
					new GregorianCalendar(2010,9-1,15));
		if (hostMainAvailResp4.getSuccess())
			System.out.println("getHostMaintenanceAvailability 2 is done!");
		else
			System.out.println("getHostMaintenanceAvailability 2 was NOT successful: " + 
					hostMainAvailResp2.getMessage());
		
		int hostId = 1;
		GetHostResponse getHostResp = getHost(hostId);
		if (getHostResp.getSuccess()) 
			System.out.println("Host " + hostId + " exists. Its name is: " + getHostResp.getHost().getName());
		else
			System.out.println("Host " + hostId + " does NOT exist!");
		
		hostId = 3;
		getHostResp = getHost(hostId);
		if (getHostResp.getSuccess()) 
			System.out.println("Host " + hostId + " exists. Its name is: " + getHostResp.getHost().getName());
		else
			System.out.println("Host " + hostId + " does NOT exist!");
		
		GetHostListResponse getHostListResp = getHostList(true);
		if (getHostListResp.getSuccess()) {
			
			System.out.println("Host List: ");
			for (int i=0; i<getHostListResp.getHost().length; i++)
				System.out.println("  Host #" + getHostListResp.getHost()[i].getId() + " " +
						getHostListResp.getHost()[i].getName());
			
		}
		else
			System.out.println("Not host exists!");
		
		Host host = new Host(0, "ita-host.cis.fiu.edu", 22, "portal", "k4se*prt4l",
				8, 10000, 20, true, true);
		AddHostResponse addHostResp = addHost(host);
		if (addHostResp.getSuccess()) 
			System.out.println("New host was added successfully!");
		else
			System.out.println("New host was NOT added!");
		
		host = new Host(0, "ita-host-2.cis.fiu.edu", 22, "portal", "k4se*prt4l",
				8, 10000, 20, true, true);
		AddHostResponse addHostResp2 = addHost(host);
		if (addHostResp2.getSuccess()) 
			System.out.println("New host was added successfully!");
		else
			System.out.println("New host was NOT added!");
		
		host.setId(4);
		host.setUsername("portal2");
		host.setActive(false);
		SetHostResponse setHostResp = setHost(host);
		if (setHostResp.getSuccess()) 
			System.out.println("Host #" + host.getId() + " was modified successfully!");
		else
			System.out.println("Host #" + host.getId() + " was NOT modified successfully!");
		
		hostId = 1;
		DelHostResponse delHostResp = delHost(hostId);
		if (delHostResp.getSuccess())
			System.out.println("Host #" + hostId + " was deleted successfully!");
		else
			System.out.println("Host #" + hostId + " was NOT deleted successfully!");
		
		hostId = 3;
		DelHostResponse delHostResp2 = delHost(hostId);
		if (delHostResp2.getSuccess())
			System.out.println("Host #" + hostId + " was deleted successfully!");
		else
			System.out.println("Host #" + hostId + " was NOT deleted successfully!");
		
		GetHostMaintenanceUnavailabilityResponse hostMainUnavailResp = 
			getHostMaintenanceUnavailability(
					1,
					new GregorianCalendar(2010,6-1,15), 
					new GregorianCalendar(2010,9-1,15));
		if (hostMainUnavailResp.getSuccess())
			System.out.println("getHostMaintenanceUnavailability 1 is done!");
		else
			System.out.println("getHostMaintenanceUnavailability 1 was NOT successful: " + 
					hostMainUnavailResp.getMessage());
		
		GetHostMaintenanceUnavailabilityResponse hostMainUnavailResp2 = 
			getHostMaintenanceUnavailability(
					2,
					new GregorianCalendar(2010,6-1,15), 
					new GregorianCalendar(2010,9-1,15));
		if (hostMainUnavailResp2.getSuccess()) 
			System.out.println("getHostMaintenanceUnavailability 2 is done!");
		else
			System.out.println("getHostMaintenanceUnavailability 2 was NOT Successful: " + 
					hostMainUnavailResp.getMessage());
		
		GetHostMaintenanceScheduleResponse hostMainSchResp = 
			getHostMaintenanceSchedule(
					1, 
					new GregorianCalendar(2010,6-1,15), 
					new GregorianCalendar(2010,9-1,15));
		if (hostMainSchResp.getSuccess()) 
			System.out.println("GetHostMaintenanceSchedule is done!");
		else
			System.out.println("getHostMaintenanceSchedule was NOT successful: " + 
					hostMainSchResp.getMessage());
		
    }


	public static void main(String [] args) {
    	
    	if(args.length != 1) {
    		System.out.println("Usage: ./runclient.sh <port_numver>");
    		System.out.println("  Example: ./runclient.sh 8080");
    		return;
    	} 
    		
    	try {
		
    		String epr = "http://localhost:" + args[0] + "/axis2/services/VEScheduler";
    		VESchedulerClient client = new VESchedulerClient(epr);

    		client.test();
    	}
    	catch(Exception e) {
    		System.out.println("Exception: " + e);
    		System.out.println("Message: " + e.getMessage());
    		e.printStackTrace();
    	}

    }

}
