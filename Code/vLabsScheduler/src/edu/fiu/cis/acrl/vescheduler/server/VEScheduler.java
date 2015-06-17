package edu.fiu.cis.acrl.vescheduler.server;

import edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest;
import edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.fiu.cis.acrl.tools.timeperiod.TimePeriodTools;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;
import edu.fiu.cis.acrl.tools.timeperiod.ScheduledEvent;
import edu.fiu.cis.acrl.vescheduler.server.VMInstance.VMInsStatusType;
import edu.fiu.cis.acrl.kaseya.client.KaseyaWSClient;
import edu.fiu.cis.acrl.vescheduler.server.agent.SSHCommand;
import edu.fiu.cis.acrl.vescheduler.server.agent.SchedulingAgent;
import edu.fiu.cis.acrl.vescheduler.server.db.VESchedulerDB;
import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;
import edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest;
import edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse;
import edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest;
import edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse;
import edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest;
import edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse;
import edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest;
import edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse;
import edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest;
import edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse;
import edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest;
import edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest;
import edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse;
import edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest;
import edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse;
import edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest;
import edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse;
import edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest;
import edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse;
import edu.fiu.cis.acrl.vescheduler.ws.VESchedulerStub;
import edu.fiu.cis.acrl.vescheduler.ws.VMInfo;
import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VirtualEnvironmentType;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest;
import edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse;
import edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest;
import edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse;
import edu.fiu.cis.acrl.virtuallabs.server.User;
import edu.fiu.cis.acrl.virtuallabs.server.VirtualLabsSettings;
import edu.fiu.cis.acrl.virtuallabs.server.db.VirtualLabsDB;

public class VEScheduler { // extends VESchedulerSkeleton {

	// Debug level for this class
	private static int DEBUG_LEVEL = 1;
	
	private String configFile = null;
	
	private VirtualLabsDB virtualLabsDB;
	// private VirtualLabsSettings vLabsSettings;

	private VESchedulerDB veSchDB;
	private VESchedulerSettings settings;
	private Configuration config;
    private static SchedulingAgent schedulingAgent;
    private static StatusUpdateAgent statusUpdateAgent;
	
	/**
	 * Constructor is protected
	 * 
	 */
	protected VEScheduler() {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - Constructor] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - Constructor] Ready to get out!");
		
	}
	
	/**
	 * 
	 */
	public void startUp() {
	
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - startUp] Inside!");
		
		virtualLabsDB = VirtualLabsDB.instance();
		
		/*
		virtualLabsDB = new VirtualLabsDB();

		vLabsSettings = VirtualLabsSettings.instance();
			

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - startUp] vLabsSettings!" + vLabsSettings);

		virtualLabsDB.connect(
				vLabsSettings.getDbUser(), 
				vLabsSettings.getDbPassword(), 
				vLabsSettings.getDbHost(), 
				vLabsSettings.getDbName());
		*/
		
		veSchDB = VESchedulerDB.instance();
		
		settings= VESchedulerSettings.instance();
		    
		DebugTools.println(DEBUG_LEVEL,  "[VEScheduler - startUp] Settings!" + 
				settings.getDbUser() + 
				settings.getDbPassword() + 
				settings.getDbHost() + 
				settings.getDbName());

		config = veSchDB.getConfiguration();
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - startUp] Configuration from DB: " +
				"startTime is " + 
				config.getUserStartTime().getTime() + 
				" endTime is " + 
				config.getUserEndTime().getTime() + 
				" active is " + 
				config.isActive());

		if (settings.isSchedulerEnabled()) {

		    schedulingAgent = 
		    	new SchedulingAgent();
		    (new Thread(schedulingAgent)).start();
		    
		    statusUpdateAgent =
		    	new StatusUpdateAgent();
		    (new Thread(statusUpdateAgent)).start();
		
		}

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - startUp] Ready to get out!");
		
	}
	
    /**
     * Free resources
     */
    public void shutDown() {
	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - shutDown] Inside!");
		
    	veSchDB.close();
    
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - shutDown] Ready to get out!");
	  
    }

	/**
	 * A handle to the unique Singleton instance.
	 */
	static private VEScheduler _instance = null;
	
	/**
	 * @return The unique instance of this class.
	 */
	static public VEScheduler instance() {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - instance] Inside!");
		
		if(null == _instance) {
			_instance = new VEScheduler();
	    }
	    
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - instance] Ready to get out!");
		
		return _instance;
	   
	}

	/**
	 * 
	 * @param disableKaseyaAccountRequest
	 * @return
	 */
	public DisableKaseyaAccountResponse disableKaseyaAccount(
			DisableKaseyaAccountRequest disableKaseyaAccountRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - disableKaseyaAccount] Inside!");

		DisableKaseyaAccountResponse response = new DisableKaseyaAccountResponse();

		ArrayList<VEInstance> veInsArray = new ArrayList<VEInstance>();
		
		String username = disableKaseyaAccountRequest.getUsername();
		
		boolean disableAllVeInstances = true;
		
		// First, check if the veInsId is not null nor blank
		if (disableKaseyaAccountRequest.getVeInsId() != null) {
			
			if (disableKaseyaAccountRequest.getVeInsId().length() > 0) {
				
				disableAllVeInstances = false;
				
				VEInstance veIns = veSchDB.getVEInstance(disableKaseyaAccountRequest.getVeInsId());
				
				if (veIns != null) {
					
					veInsArray.add(veIns);
					
				} else {
					
					response.setSuccess(false);
					response.setReason(
							"Not Successful! veIns with id: " + 
							disableKaseyaAccountRequest.getVeInsId() +
							" does not exist!");
					
					return response;

				}
			} 
		}
		
		// Second, if the veInsId is either null or blank, then get all the 
		// user's ve instances
		if (disableAllVeInstances) {
			
			veInsArray = veSchDB.getVEInstances(username);
			
		}
		
		String errorMessage = "";
		
		response.setReason("");
		response.setSuccess(true);
		// Third, for each ve instance, get the Kaseya server and disable the user
		// account on that server
		for (VEInstance veIns : veInsArray) {
			
			// Get the assigned Kaseya server
			KServer kserver = 
				veSchDB.getKServer(
						username,
						veIns.getId());

			if (kserver == null) {
				
				response.setSuccess(false);
				response.setReason(
						response.getReason() + 
						"Not Successful! The user " +
						username + " does not have a veIns with id: " + 
						disableKaseyaAccountRequest.getVeInsId());
				
				continue;

			}
			
			// Delete the user account on the Kaseya server
			KaseyaWSClient kaseyaWSClient = null;
			if (kserver.getUsername().length() == 0) {					
				String promoCode = virtualLabsDB.getPromoCode(veIns.getId());
				Tenant tenant = veSchDB.getTenantByVeInsId(veIns.getId());
				kaseyaWSClient = 
					KaseyaWSClient.instance(
						kserver.getName(), 
						80, 
						tenant.getUsername(), 
						tenant.getPassword(),
						"SHA-256",
						"System",
						"System",
						promoCode);
			} else {
				kaseyaWSClient = 
					KaseyaWSClient.instance(kserver.getName(), kserver.getHttpPort());
			}
			
			String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
			String tempUsername = veInsUsername;
			
			// Get the type of resource
			String resourceType = virtualLabsDB.getResourceTypeFromVeInsId(veIns.getId());
			if (resourceType != null)
				if (resourceType.toUpperCase().equals("CERTIFICATE")) 
					tempUsername += "-ct";
			
			if (!kaseyaWSClient.disableAdmin(tempUsername)) {

				String errMsg = "Error! " +
						"The admin " + tempUsername + 
						" could not be disabled on the Kaseya server " + kserver.getName();
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - disableKaseyaAccount] " + errMsg);
				Exception e =
					new Exception(errMsg);
				e.printStackTrace();

				errorMessage += errMsg + "\n";
				
			}
		}
		
		if (errorMessage.length() > 0) {
		
			response.setSuccess(false);
			response.setReason("Not Successful! " + errorMessage);
		
		} else {

			response.setSuccess(true);
			response.setReason("Successful!");
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - disableKaseyaAccount] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param delKaseyaAccountRequest
	 * @return
	 */
	public DelKaseyaAccountResponse delKaseyaAccount(
			DelKaseyaAccountRequest delKaseyaAccountRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delKaseyaAccount] Inside!");

		DelKaseyaAccountResponse response = new DelKaseyaAccountResponse();

		ArrayList<VEInstance> veInsArray = new ArrayList<VEInstance>();
		
		String username = delKaseyaAccountRequest.getUsername();
		User user = virtualLabsDB.getUser(username);
		
		boolean delAllVeInstances = true;
		
		// First, check if the veInsId is not null nor blank
		if (delKaseyaAccountRequest.getVeInsId() != null) {
			
			if (delKaseyaAccountRequest.getVeInsId().length() > 0) {
				
				delAllVeInstances = false;
				
				VEInstance veIns = veSchDB.getVEInstance(delKaseyaAccountRequest.getVeInsId());
				
				if (veIns != null) {
					
					veInsArray.add(veIns);
					
				} else {
					
					response.setSuccess(false);
					response.setReason(
							"Not Successful! veIns with id: " + 
							delKaseyaAccountRequest.getVeInsId() +
							" does not exist!");
					
					return response;

				}
			} 
		}
		
		// Second, if the veInsId is either null or blank, then get all the 
		// user's ve instances
		if (delAllVeInstances) {
			
			veInsArray = veSchDB.getVEInstances(username);
			
		}
		
		String errorMessage = "";
		
		response.setReason("");
		response.setSuccess(true);
		// Third, for each ve instance, get the Kaseya server and delete the user
		// account on that server
		for (VEInstance veIns : veInsArray) {
			
			// Get the assigned Kaseya server
			KServer kserver = 
				veSchDB.getKServer(
						username,
						veIns.getId());

			if (kserver == null) {
				
				response.setSuccess(false);
				response.setReason(
						response.getReason() + 
						"Not Successful! The user " +
						username + " does not have a veIns with id: " + 
						delKaseyaAccountRequest.getVeInsId());
				
				continue;

			}
			
			// String tempUsername = username;
			
			// Get the type of resource
			// String resourceType = virtualLabsDB.getResourceTypeFromVeInsId(veIns.getId());
			// if (resourceType != null)
			// 	if (resourceType.toUpperCase().equals("CERTIFICATE")) 
			//		tempUsername += "-ct";
			
			// Delete the user account on the Kaseya server
			KaseyaWSClient kaseyaWSClient = null;
			if (kserver.getUsername().length() == 0) {					
				String promoCode = virtualLabsDB.getPromoCode(veIns.getId());
				Tenant tenant = veSchDB.getTenantByVeInsId(veIns.getId());
				kaseyaWSClient = 
					KaseyaWSClient.instance(
						kserver.getName(), 
						80, 
						tenant.getUsername(), 
						tenant.getPassword(),
						"SHA-256",
						"System",
						"System",
						promoCode);
			} else {
				kaseyaWSClient = 
					KaseyaWSClient.instance(kserver.getName(), kserver.getHttpPort());
			}
			
			String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
			if (!kaseyaWSClient.deleteAdmin(veInsUsername, user.getPassword())) {

				String errMsg = "Error! " +
						"The admin " + veInsUsername + 
						" could not be deleted from the Kaseya server " + kserver.getName();
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delKaseyaAccount] " + errMsg);
				Exception e =
					new Exception(errMsg);
				e.printStackTrace();

				errorMessage += errMsg + "\n";
				
			}
		}
		
		if (errorMessage.length() > 0) {
		
			response.setSuccess(false);
			response.setReason("Not Successful! " + errorMessage);
		
		} else {

			response.setSuccess(true);
			response.setReason("Successful!");
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delKaseyaAccount] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param delKaseyaAccountsRequest
	 * @return
	 */
	public DelKaseyaAccountsResponse delKaseyaAccounts(
			DelKaseyaAccountsRequest delKaseyaAccountsRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delKaseyaAccounts] Inside!");

		DelKaseyaAccountsResponse response = new DelKaseyaAccountsResponse();

		response.setSuccess(false);
		response.setReason("Successful!");

		String[] usernames = veSchDB.getUserInGroup(delKaseyaAccountsRequest.getGroupName()); 
		
		String errorMessage = "";
		
		for (String username : usernames) {
			
			DelKaseyaAccountRequest req = new DelKaseyaAccountRequest();
			req.setUsername(username);
			
			DelKaseyaAccountResponse resp = delKaseyaAccount(req);
			
			if (!resp.getSuccess())
				errorMessage += resp.getReason();
			
		}
		
		if (errorMessage.length() > 0) {
		
			response.setSuccess(false);
			response.setReason("Not Successful! " + errorMessage);
		
		} else {

			response.setSuccess(true);
			response.setReason("Successful!");
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delKaseyaAccounts] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param redistributeDevasEvenlyRequest
	 * @return
	 */
	public RedistributeDevasEvenlyResponse redistributeDevasEvenly(
			RedistributeDevasEvenlyRequest redistributeDevasEvenlyRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - redistributeDevasEvenly] Inside!");

		String MIGRATE_VM_SCRIPT = "migrate_vm.py";
		
		RedistributeDevasEvenlyResponse response = new RedistributeDevasEvenlyResponse();
		response.setSuccess(false);
		response.setReason("Not Successful!");

		ArrayList<MigrationTask> migTasks = 
			veSchDB.getMigrationTasks(
					redistributeDevasEvenlyRequest.getGroupName());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - redistributeDevasEvenly] " +
				"Commands to be executed: ");
		for (int i=0; i<migTasks.size(); i++) {
			
			MigrationTask migTask = migTasks.get(i);
			String command = 
				MIGRATE_VM_SCRIPT + " " + 
				migTask.getUsername() + " " +
				migTask.getVeTypeName() + " " +
				migTask.getFirstPort() + " " +
				migTask.getSourceStorageId() + " " +
				migTask.getTargetStorateId() + " " +
				" >> " + "/home/sadjadi-vmstorage/sadjadi-vms/it-auto/" + 
				MIGRATE_VM_SCRIPT + ".log";
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - redistributeDevasEvenly] " +
					"\tHost: " + migTask.getHostId() + " " +
					"Command: " + command);
		}
		for (int i=0; i<migTasks.size(); i++) {
			
			MigrationTask migTask = migTasks.get(i);
			// TODO username needs to be fixed
			String command = 
				MIGRATE_VM_SCRIPT + " " + 
				migTask.getUsername() + " " +
				migTask.getVeTypeName() + " " +
				migTask.getFirstPort() + " " +
				migTask.getSourceStorageId() + " " +
				migTask.getTargetStorateId() + " " +
				" >> " + "/home/sadjadi-vmstorage/sadjadi-vms/it-auto/" + 
				MIGRATE_VM_SCRIPT + ".log";
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - redistributeDevasEvenly] " +
					"\tHost: " + migTask.getHostId() + " " +
					"Command: " + command);
			Host host = veSchDB.getHost(migTask.getHostId());
			SSHCommand cmd = 
				new SSHCommand(
						command, 
						host.getName(), 
						host.getSshPort(), 
						host.getUsername(), 
						host.getPassword(),
						0);
			// (new Thread(cmd)).start();
			int exitCode = cmd.run();
			
			VEInstance veIns = 
				veSchDB.getVEInstance(
						migTask.getUsername(),
						migTask.getVeTypeName(),
						migTask.getFirstPort());
			veIns.setStorageId(migTask.getTargetStorateId());
			veSchDB.setVEInstance(veIns);
			
			VEInsHost veInsHost = 
				new VEInsHost(
						veIns.getId(),
						host.getId());
			veSchDB.addVEInsHost(veInsHost);
			
		}
		response.setSuccess(true);
		response.setReason("Successful!");

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - redistributeDevasEvenly] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param refreshVMRequest
	 * @return
	 */
	public RefreshVMResponse refreshVM(
			RefreshVMRequest refreshVMRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - refreshVM] Inside!");

		String REFRESH_VM_SCRIPT = "refresh_vm.py";
		
		RefreshVMResponse response = new RefreshVMResponse();
		response.setSuccess(false);
		response.setReason("Not Successful!");

		String veInsId = refreshVMRequest.getDevaInsId();
		VEInstance veIns = veSchDB.getVEInstance(veInsId);
		int hostId = veSchDB.getHostIdOfScheduledVEIns(veInsId);
		Host host = veSchDB.getHost(hostId);

		VMInstance vmIns = veSchDB.getVMInstance(veInsId, refreshVMRequest.getVmName());
		
		String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
		String command = 
			REFRESH_VM_SCRIPT + " " + 
			// veIns.getUsername() + " " + 
			veInsUsername + " " +
			veIns.getVeType().getVEName() + " " + 
			veIns.getFirstPort() + " " + 
			veIns.getStorageId() + " " +
			vmIns.getDir();
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - refreshVM] " +
				"command to be executed: " + command);
		SSHCommand cmd = 
			new SSHCommand(
					command, 
					host.getName(), 
					host.getSshPort(), 
					host.getUsername(), 
					host.getPassword(),
					0);
		// (new Thread(cmd)).start();
		int exitCode = cmd.run();
		
		response.setSuccess(true);
		response.setReason("Successful!");

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - refreshVM] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param runVMCmdRequest
	 * @return
	 */
	public RunVMCmdResponse runVMCmd(
			RunVMCmdRequest runVMCmdRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - runVMCmd] Inside!");

		String RUN_VM_CMD_SCRIPT = "run_vm_cmd.py";
		
		RunVMCmdResponse response = new RunVMCmdResponse();
		response.setSuccess(false);
		response.setReason("Not Successful!");

		String veInsId = runVMCmdRequest.getDevaInsId();
		VEInstance veIns = veSchDB.getVEInstance(veInsId);
		int hostId = veSchDB.getHostIdOfScheduledVEIns(veInsId);
		Host host = veSchDB.getHost(hostId);

		VMInstance vmIns = veSchDB.getVMInstance(veInsId, runVMCmdRequest.getVmName());
		
		String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
		String command = 
			RUN_VM_CMD_SCRIPT + " " + 
			// veIns.getUsername() + " " + 
			veInsUsername + " " +
			veIns.getVeType().getVEName() + " " + 
			veIns.getFirstPort() + " " + 
			veIns.getStorageId() + " " +
			vmIns.getDir() + " " +
			runVMCmdRequest.getCmdParam1() + " " +
			runVMCmdRequest.getCmdParam2();
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - runVMCmd] " +
				"command to be executed: " + command);
		SSHCommand cmd = 
			new SSHCommand(
					command, 
					host.getName(), 
					host.getSshPort(), 
					host.getUsername(), 
					host.getPassword(),
					0);
		// (new Thread(cmd)).start();
		int exitCode = cmd.run();
		
		String returnValue = "";
		switch (exitCode) {
		case 1:
			returnValue = "off";
			break;
		case 2:
			returnValue = "suspended";
			break;
		case 3:
			returnValue = "on";
			break;
		default:
			break;				
		}
		response.setReturnValue(returnValue);
		response.setSuccess(true);
		response.setReason("Successful!");

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - runVMCmd] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param destroyDevaInsRequest
	 * @return
	 */
	public DestroyDevaInsResponse destroyDevaIns(
			DestroyDevaInsRequest destroyDevaInsRequest) {
		
		String DESTROY_SCRIPT = "destroy_ve.py";
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - destroyDevaIns] Inside!");

		DestroyDevaInsResponse response = new DestroyDevaInsResponse();
		response.setSuccess(false);
		response.setReason("Not Successful!");

		String veInsId = destroyDevaInsRequest.getDevaInsId();
		VEInstance veIns = veSchDB.getVEInstance(veInsId);

		veSchDB.delVMsByVEInsId(veInsId);
		
		String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
		String command = 
			DESTROY_SCRIPT + " " + 
			// veIns.getUsername() + " " + 
			veInsUsername + " " +
			veIns.getVeType().getVEName() + " " + 
			veIns.getFirstPort() + " " + 
			veIns.getNumPorts() + " " + 
			0 + " " +
			veIns.getStorageId();
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - destroyDevaIns] " +
				"command to be executed: " + command);
		Host host = veSchDB.getHost4Storage(veIns.getStorageId());
		SSHCommand cmd = 
			new SSHCommand(
					command, 
					host.getName(), 
					host.getSshPort(), 
					host.getUsername(), 
					host.getPassword(),
					0);
	    // (new Thread(cmd)).start();
		cmd.run();
		
		veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veInsId);
		DelKaseyaAccountRequest delReq = new DelKaseyaAccountRequest();
		delReq.setUsername(veIns.getUsername());
		delReq.setVeInsId(veInsId);
		DelKaseyaAccountResponse delResp = delKaseyaAccount(delReq);
		if (delResp.getSuccess() == false)
			System.out.println("Error! Kaseya account for username " + veInsUsername + " " +
					"veInsId " + veInsId + " could not be deleted properly!");
		
		int[] hostIds = veSchDB.getVEInsHosts(veInsId);
		if (hostIds != null) {
			for (int i=0; i<hostIds.length; i++) {
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - destroyDevaIns] Ready to get out!" +
						"Deleting ve ins hosts! " +
						"veInsId " + veInsId + " " +
						"hostIds[" + i + "]: " + hostIds[i]);
				veSchDB.delVEInsHost(veInsId, hostIds[i]);				
			}
		} else {
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - destroyDevaIns] Ready to get out!" +
					"No ve ins host to be deleted! " +
					"veInsId " + veInsId);
		}
		
		// veSchDB.delTenant(veInsId);
		veSchDB.disableTenant(veInsId);
		
		veSchDB.delVEInsHost(veInsId);
		
		veSchDB.delHostUsedRoutersByVEInsId(veInsId);
		
		veSchDB.delVEInsSchByVEInsId(veInsId);
		
		veSchDB.delVEIns(veInsId);
		
		veSchDB.delVMsByVEInsId(veInsId);
		
		response.setSuccess(true);
		response.setReason("Successful!");

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - destroyDevaIns] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param getDevaInsInfoRequest
	 * @return
	 */
	public GetDevaInsInfoResponse getDevaInsInfo(
			GetDevaInsInfoRequest getDevaInsInfoRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getDevaInsInfo] Inside!");

		GetDevaInsInfoResponse response = new GetDevaInsInfoResponse();
		response.setSuccess(false);
		response.setReason("Not Successful!");

		VEInstanceSchedule veInsSch = 
			veSchDB.getVEInsCurSch(
					getDevaInsInfoRequest.getVeInsId());
		
		if (veInsSch != null) {
			
			boolean dispatched = false;
			// for (int i=0; i<30; i++) {
				if (veSchDB.isVEInsDispatched(getDevaInsInfoRequest.getVeInsId())) {
					dispatched = true;
					// just give it some time to make sure that all the vms are up and running!
					// if (i > 0)
					// 	try{Thread.sleep(30000);} catch(Exception e) {} // sleep for 10 seconds
					// break;
				} else {
					// try{Thread.sleep(10000);} catch(Exception e) {} // sleep for 10 seconds
				}
			// }
			if (!dispatched) {
				response.setSuccess(false);
				response.setReason("The deva has not been dispatched yet!");				
			} else {
			
				VEInstance veIns = veSchDB.getVEInstance(getDevaInsInfoRequest.getVeInsId());
				Host host = veSchDB.getHost(veInsSch.getHostId());

				KServer kserver = veSchDB.getKServer(veIns.getKserverId());
				edu.fiu.cis.acrl.vescheduler.ws.KServer convertedKServer =
					kserver.getConvertedKServer();
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getDevaInsInfo] " +
						"convertedKServer.getName(): " + convertedKServer.getName());
				convertedKServer.setName(veSchDB.getKServerAkamaiName(convertedKServer.getName()));
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getDevaInsInfo] " +
						"convertedKServer.getName(): " + convertedKServer.getName());
				response.setKserver(convertedKServer);
				
				ArrayList<VMInstance> vmInstances = veSchDB.getVMInstancesByVEInsId(veIns.getId());

				for (int i=0; i<vmInstances.size(); i++) {

					VMInfo vmInfo = new VMInfo();
					vmInfo.setId(vmInstances.get(i).getId());
					vmInfo.setVeInsId(vmInstances.get(i).getVeInsId());
					vmInfo.setName(vmInstances.get(i).getName());
					vmInfo.setDomain(vmInstances.get(i).getDomain());
					vmInfo.setOs(vmInstances.get(i).getOs());
					vmInfo.setInternalAddress(vmInstances.get(i).getInternalAddress());
					// TODO This is with the assumption that all the vm instances of the same
					// ve instance are deployed on the same host.
					vmInfo.setAccessAddress(host.getName());
					vmInfo.setAccessPort(vmInstances.get(i).getAccessPort());
					vmInfo.setMacAddress(vmInstances.get(i).getMacAddress());
					vmInfo.setStatus(VMInstance.convertStatus(vmInstances.get(i).getStatus()));
					vmInfo.setLastCheckin(vmInstances.get(i).getLastCheckin());
					vmInfo.setAppName(vmInstances.get(i).getAppName());
					vmInfo.setAppDir(vmInstances.get(i).getAppDir());

					response.addVmInfo(vmInfo);
				}

				response.setSuccess(true);
				response.setReason("Successful!");
			}
		} else {
			response.setSuccess(false);
			response.setReason("No current schedule for this virtual environment!");
		}

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getDevaInsInfo] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param getEndDate4CurrentDevaInsRequest
	 * @return
	 */
	public GetEndDate4CurrentDevaInsResponse getEndDate4CurrentDevaIns(
			GetEndDate4CurrentDevaInsRequest getEndDate4CurrentDevaInsRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getEndDate4CurrentDevaIns] Inside!");

		GetEndDate4CurrentDevaInsResponse response = new GetEndDate4CurrentDevaInsResponse();
		response.setSuccess(false);
		response.setReason("Not Successful!");

		String veInsId = getEndDate4CurrentDevaInsRequest.getDevaInsId();

		VEInstanceSchedule veInsCurSch = veSchDB.getVEInsCurSch(veInsId);
		
		if (veInsCurSch != null) {
		
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getEndDate4CurrentDevaIns] " +
					"start time: " + veInsCurSch.getStartTime().getTime() + " " +
					"end time: " + veInsCurSch.getEndTime().getTime());

			response.setVeInsSchId(veInsCurSch.getId());
			response.setCurDate(Calendar.getInstance());
			response.setEndDate(veInsCurSch.getEndTime());
			response.setSuccess(true);
			response.setReason("Successful!");

		} else {

			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getEndDate4CurrentDevaIns] " +
					"No current schedule for this ve instance could be found!" );
			
			response.setSuccess(false);
			response.setReason("No current schedule for this ve instance could be found!");

		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getEndDate4CurrentDevaIns] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param getVMInsInfoRequest
	 * @return
	 */
	public GetVMInsInfoResponse getVMInsInfo(
			GetVMInsInfoRequest getVMInsInfoRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVMInsInfo] Inside!");

		GetVMInsInfoResponse response = new GetVMInsInfoResponse();
		response.setSuccess(false);
		response.setReason("Not Successful!");

		String vmInsId = getVMInsInfoRequest.getVmInsId();
		
		if (vmInsId != null) {
			
			VMInstance vmInstance = veSchDB.getVMInstance(vmInsId);
			VEInstance veIns = veSchDB.getVEInstanceByVMInsId(vmInsId);
			VEInstanceSchedule veInsSch = veSchDB.getVEInsCurSch(veIns.getId());
			
			if (veInsSch != null) {
				Host host = veSchDB.getHost(veInsSch.getHostId());

				VMInfo vmInfo = new VMInfo();
				vmInfo.setId(vmInstance.getId());
				vmInfo.setVeInsId(vmInstance.getVeInsId());
				vmInfo.setName(vmInstance.getName());
				vmInfo.setDomain(vmInstance.getDomain());
				vmInfo.setOs(vmInstance.getOs());
				vmInfo.setInternalAddress(vmInstance.getInternalAddress());
				// TODO This is with the assumption that all the vm instances of the same
				// ve instance are deployed on the same host.
				vmInfo.setAccessAddress(host.getName());
				vmInfo.setAccessPort(vmInstance.getAccessPort());
				vmInfo.setMacAddress(vmInstance.getMacAddress());
				vmInfo.setStatus(VMInstance.convertStatus(vmInstance.getStatus()));
				vmInfo.setLastCheckin(vmInstance.getLastCheckin());
				vmInfo.setAppName(vmInstance.getAppName());
				vmInfo.setAppDir(vmInstance.getAppDir());

				response.setVmInfo(vmInfo);
				response.setSuccess(true);
				response.setReason("Successful!");
			} else {
				response.setSuccess(false);
				response.setReason("No current schedule for this virtual machine!");
			}
		} else {
			response.setSuccess(false);
			response.setReason("vmInsId cannot be null!");
		}

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVMInsInfo] Ready to get out!");

		return response;
	}
	
	public ReserveResourceResponse reserveResource(
			ReserveResourceRequest reserveResourceRequest) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - reserveResource] Inside!");

		ReserveResourceResponse response = new ReserveResourceResponse();

		ReservedResource reservedResource = 
			new ReservedResource(
					reserveResourceRequest.getVe(),
					reserveResourceRequest.getTimePeriod().getStartTime(),
					reserveResourceRequest.getTimePeriod().getEndTime(),
					reserveResourceRequest.getQuota(),
					reserveResourceRequest.getCancel());
		
		if (veSchDB.reserveResource(reservedResource)) {

			response.setSuccess(true);
			response.setReason("Successful!");
		
		}
		else {
			
			response.setSuccess(false);
			response.setReason("Not Successful!");
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - reserverResourceRequest] Ready to get out!");

		return response;
		
	}
	
	public CheckinResponse checkin(CheckinRequest request) {

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - checkin] Inside!");
		
		CheckinResponse response = new CheckinResponse();
		
		VMInstance vmIns = veSchDB.getVMInstanceUsingMac(request.getMacAddress());
		
		if (vmIns == null) {
			System.out.println("[VEScheduler - checkin] " +
					"ERROR! " +
					"This mac address " + request.getMacAddress() + " " +
					"could not be found!");
			response.setSuccess(false);
			response.setReason("Not Successful! " +
					"This mac address " + request.getMacAddress() + " " +
					"could not be found!");
		} else if ((vmIns.getStatus() != VMInsStatusType.PROVISIONING_AND_STARTING) &&
			(vmIns.getStatus() != VMInsStatusType.RUNNING                  ) &&
			(vmIns.getStatus() != VMInsStatusType.STARTING                 ) &&
			(vmIns.getStatus() != VMInsStatusType.PAUSING                  )) {
			
			response.setSuccess(false);
			response.setReason("Not Successful!");

			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent - run] " +
				"Error! checkin message should not have received for mac address:" +
				request.getMacAddress());
			try {
				throw new Exception(
					"Error! checkin message should not have received for mac address:" +
					request.getMacAddress());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			if (vmIns.getStatus() == VMInsStatusType.PROVISIONING_AND_STARTING) {
				
				vmIns.setStatus(VMInsStatusType.RUNNING);
				response.setFirstTime(true);

			} else if (vmIns.getStatus() == VMInsStatusType.RUNNING) {
				
				vmIns.setStatus(VMInsStatusType.RUNNING);
				response.setFirstTime(false);
			
			} else if (vmIns.getStatus() == VMInsStatusType.STARTING) {
				
				vmIns.setStatus(VMInsStatusType.RUNNING);
				response.setFirstTime(false);
				
			} else if (vmIns.getStatus() == VMInsStatusType.PAUSING) {
				
				vmIns.setStatus(VMInsStatusType.PAUSING);
				response.setFirstTime(false);
				
			}
			
			vmIns.setLastCheckin(Calendar.getInstance());
			veSchDB.setVMInstance(vmIns);
			
			response.setSuccess(true);
			response.setReason("Successful!");
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - checkin] Ready to get out!");
		
		return response;
	}
	
	public GetVMMacResponse getVMMac(GetVMMacRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVMMac] Inside!");
		
		GetVMMacResponse response = new GetVMMacResponse();
		
		VMInstance vmIns = veSchDB.getVMInstance(request.getVeInsId(), request.getVmName());

		response.setMacAddress(vmIns.getMacAddress());
		
		response.setSuccess(true);
		response.setReason("Successful!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVMMac] Ready to get out!");
		
		return response;
	}
        
	public GetVEMacsResponse getVEMacs(GetVEMacsRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEMacs] Inside!");
		
		GetVEMacsResponse response = new GetVEMacsResponse();
		
		ArrayList<String> veInsMacs = veSchDB.getVEMacs(request.getVeInsId());
		for (String macAddress: veInsMacs) {
			
			response.addMacAddress(macAddress);
			
		}
		
		response.setSuccess(true);
		response.setReason("Successful!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEMacs] Ready to get out!");
		
		return response;
	}
        
	public GetVEInsIdUsingMacResponse getVEInsIdUsingMac(GetVEInsIdUsingMacRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEInsIdUsingMac] Inside!");
		
		GetVEInsIdUsingMacResponse response = new GetVEInsIdUsingMacResponse();
		
		String veInsId = veSchDB.getVEInsIdUsingMac(request.getMacAddress());

		if (veInsId != null) {
			
			response.setVeInsId(veInsId);
			response.setSuccess(true);
			response.setReason("Successful!");
		}
		else {
			
			response.setSuccess(false);
			response.setReason("VE instance could not be found!");

		}

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEInsIdUsingMac] Ready to get out!");
		
		return response;
	}
        
	/**
	 * Fixes the start time for users based on the configuration in the database
	 * and the current time. 
	 * @param userStartTime
	 * @return
	 */
	private Calendar fixUserStartTime(Calendar userStartTime) {
		
		Calendar fixedStartTime = (Calendar)userStartTime.clone();
		
		Configuration config = veSchDB.getConfiguration();
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
	 * Fixes the end time for users based on the configuration in the database. 
	 * @param userEndTime
	 * @return
	 */
	private Calendar fixUserEndTime(Calendar userEndTime) {
	
		Calendar fixedEndTime = (Calendar)userEndTime.clone();
		
		Configuration config = veSchDB.getConfiguration();
		if (fixedEndTime.compareTo(config.getUserEndTime()) > 0) {
			
			fixedEndTime = (Calendar)config.getUserEndTime().clone();
		
		}
			
		return fixedEndTime;
	
	}

	/**
	 * Checks if the requested schedule for VE instance is valid.
	 * @param veType
	 * @param veInsId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private synchronized boolean isScheduleVERequestValid(VirtualEnvironmentType veType,
			String veInsId, Calendar startTime, Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleVERequestValid] Inside!");
		
		boolean retVal = false;
		
		ArrayList<TimePeriod> veAvailableList = TimePeriodTools.toggleTimePeriodList(
				getVEUnavailabilityList(veType, veInsId, startTime, endTime), 
				startTime, endTime);
			
		if (veAvailableList.size() == 1) {
			if ((veAvailableList.get(0).getStartTime().compareTo(startTime) == 0) &&
				(veAvailableList.get(0).getEndTime().compareTo(endTime) == 0))
				retVal = true;
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleVERequestValid] " +
				"veAvailableList.size(): " + veAvailableList.size());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleVERequestValid] " +
				"retVal: " + retVal);
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleVERequestValid] Ready to get out!");
		
		return retVal;
		
	}

	private synchronized boolean isVEResourceAvailable(ScheduleVERequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isVEResourceAvailable] Inside!");

		GetVEAvailabilityRequest req = new GetVEAvailabilityRequest();
	
		req.setVe(request.getVe());
		req.setTimePeriod(request.getTimePeriod());
		req.setVeInsId(request.getVeInsId());
		
		GetVEAvailabilityResponse resp = null;
		try {
			resp = getVEAvailability(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean available = false;
		TimePeriod[] timePeriods = resp.getAvailabilityRange();
		if (timePeriods != null) {
			if (timePeriods.length > 0) {

				Calendar availStart = timePeriods[0].getStartTime();
				Calendar availEnd   = timePeriods[0].getEndTime()  ;
				Calendar appStart   = request.getTimePeriod().getStartTime();
				Calendar appEnd     = request.getTimePeriod().getEndTime()  ; 

				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isVEResourceAvailable] " +
						"availStart.getTime().equals(appStart.getTime()): " + availStart.getTime().equals(appStart.getTime()) + " " +
						"availEnd.getTime().equals(appEnd.getTime()): " + availEnd.getTime().equals(appEnd.getTime()));
				
				if (availStart.getTime().equals(appStart.getTime()) &&
					availEnd.getTime().equals(appEnd.getTime())) {
					available = true;
				}
			}
		}
			
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isVEResourceAvailable] available: " + available);

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isVEResourceAvailable] Ready to get out!");

		return available;
	}

	/**
	 * Schedules a VE instance.
	 * @param request
	 * @return
	 */
	public synchronized ScheduleVEResponse scheduleVE(
			ScheduleVERequest request
			) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - request] veType: " + 
				request.getVe());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - request] id: " + 
				request.getVeInsId());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - request] startTime:  " + 
				request.getTimePeriod().getStartTime().getTime());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - request] endTime: " + 
				request.getTimePeriod().getEndTime().getTime());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - request] store: " + 
				request.getStore());

		VirtualEnvironmentType veType = request.getVe();
		String veInsId = request.getVeInsId();
		Calendar startTime = request.getTimePeriod().getStartTime();
		Calendar endTime = request.getTimePeriod().getEndTime();
		boolean store = request.getStore();
		
		ScheduleVEResponse response = new ScheduleVEResponse();
		
		if (!isScheduleVERequestValid(veType, veInsId, startTime, endTime)) {
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] not a valid request!");
			
			response.setSchId(null);
			response.setSuccess(false);
			response.setMessage("Not Successful! The request for schedule is invalid!");
			
			return response;
			
		}
		
		if (!isVEResourceAvailable(request)) {
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] Resource is not available!");
			
			response.setSchId(null);
			response.setSuccess(false);
			response.setMessage("Not Successful! The resource is not availalbe!");
			
			return response;
			
		}
				
		String veInsSchId = null;
		VEInstance veIns = null;
		Host host = null;
		Storage storage = null;
		String username = request.getUsername();
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] before veInsId is checked!");
		
		if(veInsId == null) {
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] " +
					"veInsId is null!");
			
			// First get the storage that this user has been assigned to
			storage = veSchDB.getStorage(username);
			
			// Check if the user has an assigned storage
			if (storage == null) {	
				
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] " +
					"storage is null!" );

				// Get the storage most eligible for a new assignment. 
				// The most eligible storage is the one that its most preferred host
				// has the least users assigned to it.
				storage = veSchDB.assignStorage();
			
			}
			
	    	// SMS: 2013-04-05
	    	// I assume that the preferred host for a storage is the host that storage is
	    	// on it. In other words, storage_id is equal to host_id. This makes things 
	    	// much simpler as really it does not make sense to run a virtual lab residing
	    	// on the hdd of one host on another host.
			host = veSchDB.getHost(storage.getId());    	
			// Now, get an available host for the requested period. 
			// This function will return the most preferred host for the storage,
			// if the host is available.
			// host = veSchDB.assignHostByStorage(veType, startTime, endTime, storage);

	    	// SMS: 2013-04-05
	    	// I assume that the preferred host for a storage is the host that storage is
	    	// on it. In other words, storage_id is equal to host_id. This makes things 
	    	// much simpler as really it does not make sense to run a virtual lab residing
	    	// on the hdd of one host on another host.

			// If the most preferred host for the most eligible storage is not available,
			// then go with the available host and get its most preferred storage instead.
			// if (host != null)
			// 	storage = veSchDB.assignStorageByHost(host);

			if (host != null && storage != null) {

				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] " +
						"storage and host are both NOT null! " +
						"storage_id: " + storage.getId() + " " +
						"host_id: " + host.getId());

				HostStorage hostStorage = veSchDB.getHostStorage(host.getId(), storage.getId());
				if (hostStorage != null) {
					DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] " +
					"hostStorage is not null!" );

					if (hostStorage.getPreference() <= 0) 
						storage = null;
				} else {	
					storage = null;
				}

				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] " +
						"storage_id: " + storage.getId() + " " +
						"host_id: " + host.getId());

			} 

			if (host == null || storage == null) {

				String exceptionStr = "[VEScheduler - scheduleVE] Not Successful! ";
				if (host == null)
					exceptionStr += "host is null! ";
				if (storage == null)
					exceptionStr += "storage is null! ";

				Exception e = new Exception(exceptionStr);
				e.printStackTrace();

				response.setSchId(null);
				response.setSuccess(false);
				response.setMessage(exceptionStr);

				return response;
			}

			// SMS: 2013-05-04
			// KServer must be based on the promo_code of the course this ve_ins belongs to.
			// This will be overwritten later by VirtualLabs
			KServer kserver = veSchDB.assignKServerByHost(host);
			veIns = veSchDB.creatNewVEIns(
					request.getUsername(),
					storage, 
					kserver,
					veType, 
					// startTime, 
					// endTime, 
					store);
			veInsSchId = veIns.getId();

		} else {
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] veInsId: " + veInsId);
	
			veIns = veSchDB.getVEInstance(veInsId);
			storage = veSchDB.getStorage(veIns.getStorageId());
			// host = veSchDB.assignHostByStorage(storage);
			host = veSchDB.assignHost(veIns, startTime, endTime);
	    	veInsSchId = null;
	    	
		}
		
		if (host == null) {
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] Resource is not available!");
			
			response.setSchId(null);
			response.setSuccess(false);
			response.setMessage("Not Successful! The resource is not availalbe!");
			
			return response;
			
		}
				
		// int routerNum = veSchDB.getRouterNum(host.getId(), veType, startTime, endTime);
    	
		VEInstanceSchedule veInsSch = 
			new VEInstanceSchedule(
					veInsSchId, 
					veIns.getId(), 
					host.getId(), 
					startTime, 
					endTime, 
					false,
					true);
	    veInsSchId = veSchDB.addVEInsSch(veInsSch);
	    	
	    DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] was successful!");
	    
	    response.setSchId(veInsSchId);
	    response.setSuccess(true);
	    response.setMessage("Successfully scheduled!");
	    
    	if (response.getSuccess())
    		schedulingAgent.setNextTaskTime();

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - response] id: " + 
				response.getSchId());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - response] success: " + 
				response.getSuccess());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE - response] message: " + 
				response.getMessage());

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleVE] Ready to get out!"); 
				
		return response;
	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized CancelScheduledVEResponse cancelScheduledVE(
			CancelScheduledVERequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleVE] Inside!");
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleVE - request] id: " + 
				request.getSchId());
		
    	// CancelScheduledVEResponse response = veSchDB.cancelScheduleVE(request);
    	
    	CancelScheduledVEResponse response = new CancelScheduledVEResponse();
	   	response.setSuccess(true);
		response.setMessage("Cancellation was successful!);");
    	
    	VEInstanceSchedule veInsSch = veSchDB.getVEInsSch(request.getSchId());
    	if (veInsSch != null) {
    		
    		Calendar now = Calendar.getInstance();
    		if (veInsSch.getStartTime().before(now) && veInsSch.getEndTime().after(now)) {
    			veInsSch.setEndTime(now);
    			veSchDB.setVEInsSch(veInsSch);
        	   	response.setSuccess(true);
        		response.setMessage("Cancellation was successful!);");
    		} else if (veInsSch.getStartTime().after(now) && veInsSch.getEndTime().after(now)) {
    			veInsSch.setActive(false);    		
    			veSchDB.setVEInsSch(veInsSch);
        	   	response.setSuccess(true);
        		response.setMessage("Cancellation was successful!);");
    		} else {
        	   	response.setSuccess(false);
        		response.setMessage("The appointment cannot be cancelled! The appointment was in the past!);");
    		}    		
    	} else {
    		response.setSuccess(false);
    		response.setMessage("Cancellation was NOT successful!);");
    	}

    	if (response.getSuccess())
    		schedulingAgent.setNextTaskTime();
	    
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleVE - response] success: " + 
				response.getSuccess());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleVE - response] message: " + 
				response.getMessage());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleVE] Ready to get out!");
    	
		return response;

    }
       
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized DelVEInsResponse delVEIns(
			DelVEInsRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delVEIns] Inside!");
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleVE - request] ve_id: " + 
				request.getVeInsId());
		
    	DelVEInsResponse response = new DelVEInsResponse();
    	
    	VEInstance veIns = veSchDB.getVEInstance(request.getVeInsId());
    	if (veIns != null) {
    		
    		veIns.setActive(false);
        	veSchDB.setVEInstance(veIns);
        	
        	schedulingAgent.setNextTaskTime();
    	    
    	    response.setSuccess(true);
    		response.setMessage("VE instance deletion was successful!);");
    		
    	}
    	else {
    		
    		response.setSuccess(false);
    		response.setMessage("VE Instance deletion was NOT successful!);");
    		
    	}
    	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delVEInsVE] Ready to get out!");
    	
		return response;

    }
       
	/**
	 * Warning!
	 * Before calling this method, you need to make sure that there is enough resources
	 * available for the modified appointment
	 * @param request
	 * @return
	 */
    public synchronized ModifyScheduledVEResponse modifyScheduledVE(
    		ModifyScheduledVERequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - modifyScheduleVE] Inside!");
    	
    	ModifyScheduledVEResponse response = new ModifyScheduledVEResponse();
    	
    	VEInstanceSchedule veInsSch = veSchDB.getVEInsSch(request.getSchId());
    	veInsSch.setStartTime(request.getTimePeriod().getStartTime());
    	veInsSch.setEndTime(request.getTimePeriod().getEndTime());
    	veSchDB.setVEInsSch(veInsSch);
    	
		response.setSchId(veInsSch.getId());
		response.setSuccess(true);
    	response.setMessage("Modification was successful!");

    	/*
    	veInsSch.setActive(false);
    	veSchDB.setVEInsSch(veInsSch);

    	VEInstance veIns = veSchDB.getVEInstance(veInsSch.getVeInsId());
    	
    	ScheduleVERequest schReq = new ScheduleVERequest();
    	schReq.setVe(null);
    	schReq.setVeInsId(veIns.getId());
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(request.getTimePeriod().getStartTime());
    	timePeriod.setEndTime(request.getTimePeriod().getEndTime());
    	schReq.setTimePeriod(timePeriod);
    	schReq.setStore(veIns.isStore());
    	
    	ScheduleVEResponse schRes = scheduleVE(schReq);
    	if (!schRes.getSuccess()) {
    		
    		veInsSch.setActive(true);
        	veSchDB.setVEInsSch(veInsSch);	
        	
        	response.setSchId(request.getSchId());
        	response.setSuccess(false);
        	response.setMessage("Modification was NOT successful!");
        		
    	}
    	else {
    	
    		response.setSchId(schRes.getSchId());
    		response.setSuccess(true);
        	response.setMessage("Modification was successful!");
        	
    	}
    	*/
    	
    	if (response.getSuccess())
    		schedulingAgent.setNextTaskTime();

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - modifyScheduleVE] Ready to get out!");
    	
    	return response;

    }

    /**
     * Gets the list of all unavailable periods for a VE type or a VE instance.
     * @param request
     * @return
     */
	private synchronized ArrayList<TimePeriod> getVEUnavailabilityList(
			VirtualEnvironmentType veType,
			String veInsId,
			Calendar startTime,
			Calendar endTime
			) {

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
			"id: " + veInsId);
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
			"startTime: " + startTime.getTime());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
			"endTime:" + endTime.getTime());
		
		// check for wrong input parameters!
		if (startTime.compareTo(endTime) >= 0)
			return null;
		
		ArrayList<TimePeriod> unavailList = new ArrayList<TimePeriod>();
		
		Calendar fixedStartTime = fixUserStartTime(startTime);
		Calendar fixedEndTime = fixUserEndTime(endTime);
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
				"fixedStartTime: " + fixedStartTime.getTime());
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
				"fixedEndTime:" + fixedEndTime.getTime());
			
		if (fixedStartTime.compareTo(fixedEndTime) >= 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(endTime);
			
			unavailList.add(timePeriod);
			
			return unavailList;
			
		}
		
		if (veInsId != null) {
			
			if (veInsId.length() == 0) {
				
				veInsId = null;
				
			}
			
		}
		
		/*
		if (veInsId == null) {
		
			ArrayList<Host> hostList = veSchDB.getHostList();
			for (int i=0; i < hostList.size(); i++) {
				
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
						"hostId: " + hostList.get(i).getId());
					
				ArrayList<TimePeriod> unavailList2 = new ArrayList<TimePeriod>();
				
				ArrayList<ScheduledEvent> hostUnavailEventList = veSchDB.getHostMainSchList(
						hostList.get(i).getId(), fixedStartTime, fixedEndTime);	
				ArrayList<TimePeriod> hostUnavailList = 
					TimePeriodTools.convertFromEventToTimePeriod(
							hostUnavailEventList);
				unavailList2.addAll(hostUnavailList);

				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
						"hostUnavailList size: " + hostUnavailList.size());
					
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
						"total size: " + unavailList2.size());
					
				ArrayList<TimePeriod> filledPeriods = 
					veSchDB.getHostFilledPeriodList(
						hostList.get(i), fixedStartTime, fixedEndTime);
				unavailList2.addAll(filledPeriods);
				
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
						"filledPeriods size: " + filledPeriods.size());
					
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
						"total size: " + unavailList2.size());
					
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
						"unavailList total size 1: " + unavailList.size());
					
				if (i == 0)
					unavailList = unavailList2;
				else
					unavailList = TimePeriodTools.getCommonTimePeriods(unavailList, unavailList2);

				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
						"unavailList total size 2: " + unavailList.size());			
			}											
		} else {
			// TODO we should check all the hosts that this ve ins can be deployed to them.
			VEInstance veIns = veSchDB.getVEInstance(veInsId);
			Storage storage = veSchDB.getStorage(veIns.getStorageId());
			Host host = veSchDB.assignHostByStorage(storage);
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"hostId: " + host.getId());
			
			ArrayList<ScheduledEvent> hostUnavailEventList = veSchDB.getHostMainSchList(
					host.getId(), fixedStartTime, fixedEndTime);
			ArrayList<TimePeriod> hostUnavailList = 
				TimePeriodTools.convertFromEventToTimePeriod(hostUnavailEventList);
			unavailList.addAll(hostUnavailList);

			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList - " +
					"after getHostUnavailibilityList] list size: " + hostUnavailList.size());
			
			ArrayList<TimePeriod> filledPeriods = veSchDB.getHostFilledPeriodList(
					host, fixedStartTime, fixedEndTime);
			unavailList.addAll(filledPeriods);
										
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList - " +
					"after getHostFilledPeriodList] list size: " + filledPeriods.size());
				
			if (filledPeriods.size() > 0)
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList - " +
					"after getHostFilledPeriodList] start: " + 
					filledPeriods.get(0).getStartTime().getTime() + " end: " +
					filledPeriods.get(0).getEndTime().getTime());
				
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList - " +
					"after getHostFilledPeriodList] list total size: " + unavailList.size());
					
			ArrayList<ScheduledEvent> veScheduleEvent = veSchDB.getVEInsScheduleList(
					veIns, fixedStartTime, fixedEndTime);
			ArrayList<TimePeriod> veSchedule =
				TimePeriodTools.convertFromEventToTimePeriod(veScheduleEvent);
			unavailList.addAll(veSchedule);
											
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList - " +
					"after getVEScheduleList] list size: " + veSchedule.size());
					
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList - " +
					"after getVEScheduleList] list total size: " + unavailList.size());
					
			unavailList = TimePeriodTools.fixAndSortTimePeriodList(unavailList);
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList - " +
					"after getCommonPeriods] list total size: " + unavailList.size());
							
		}
		*/
		
		ArrayList<Host> hostList = new ArrayList<Host>();
		
		if (veInsId == null) {	
			hostList = veSchDB.getHostList();
		} else {
			VEInstance veIns = veSchDB.getVEInstance(veInsId);
			Storage storage = veSchDB.getStorage(veIns.getStorageId());
			hostList = veSchDB.getHostList(storage);			
		}

		for (int i=0; i < hostList.size(); i++) {
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"hostId: " + hostList.get(i).getId());
				
			ArrayList<TimePeriod> unavailList2 = new ArrayList<TimePeriod>();
			
			ArrayList<ScheduledEvent> hostUnavailEventList = veSchDB.getHostMainSchList(
					hostList.get(i).getId(), fixedStartTime, fixedEndTime);	
			ArrayList<TimePeriod> hostUnavailList = 
				TimePeriodTools.convertFromEventToTimePeriod(
						hostUnavailEventList);
			unavailList2.addAll(hostUnavailList);

			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"hostUnavailList size: " + hostUnavailList.size());
				
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"total size: " + unavailList2.size());
				
			ArrayList<TimePeriod> filledPeriods = 
				veSchDB.getHostFilledPeriodList(
					hostList.get(i), fixedStartTime, fixedEndTime);
			unavailList2.addAll(filledPeriods);
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"filledPeriods size: " + filledPeriods.size());
				
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"total size: " + unavailList2.size());
				
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"unavailList total size 1: " + unavailList.size());
				
			if (i == 0)
				unavailList = unavailList2;
			else
				unavailList = TimePeriodTools.getCommonTimePeriods(unavailList, unavailList2);

			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] " +
					"unavailList total size 2: " + unavailList.size());			
		}											

			
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
		
		unavailList = TimePeriodTools.fixAndSortTimePeriodList(unavailList);
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailabilityList] Ready to get out!");
		
		return unavailList;

	}

    /**
     * 
     * @param request
     * @return
     */
    public synchronized GetVEAvailabilityResponse getVEAvailability(
    		GetVEAvailabilityRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEAvailability] Inside!");
    	
    	ArrayList<TimePeriod> veAvailableList = TimePeriodTools.toggleTimePeriodList(
				getVEUnavailabilityList(
						request.getVe(),
						request.getVeInsId(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime()), 
				request.getTimePeriod().getStartTime(), 
				request.getTimePeriod().getEndTime());
			
		GetVEAvailabilityResponse response = new GetVEAvailabilityResponse();
			
		for (int i = 0; i < veAvailableList.size(); i++) {
			
			response.addAvailabilityRange(veAvailableList.get(i));
			
		}	
		
		response.setSuccess(true);
		response.setMessage("VE availability list was successfully returned!");
  	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEAvailability] Ready to get out!");
    	
    	return response;

    }
 
    /**
     * 
     * @param request
     * @return
     */
    public GetVEUnavailabilityResponse getVEUnavailability(
    		GetVEUnavailabilityRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailability] Inside!");
    	
    	ArrayList<TimePeriod> veUnavailableList = getVEUnavailabilityList(
						request.getVe(),
						request.getId(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime());
			
		GetVEUnavailabilityResponse response = new GetVEUnavailabilityResponse();
			
		for (int i = 0; i < veUnavailableList.size(); i++) {
			
			response.addUnavailabilityRange(veUnavailableList.get(i));
			
		}	
		
		if (veUnavailableList.size() == 0) {
			
	    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailability] " +
	    			"veUnavailableList.size(): " + veUnavailableList.size());

	    	TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(request.getTimePeriod().getEndTime());
			timePeriod.setEndTime(request.getTimePeriod().getEndTime());
			response.addUnavailabilityRange(timePeriod);
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailability] " +
	    			"timePeriod: " + timePeriod);

		}
		
		response.setSuccess(true);
		response.setMessage("VE unavailability list was successfully returned!");
  	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEUnavailability] Ready to get out!");
    	
    	return response;

    }
    
    /**
     * 
     * @param request
     * @return
     */
    public GetVEInsScheduleResponse getVEInsSchedule(
    		GetVEInsScheduleRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVESchedule] Inside!");

    	GetVEInsScheduleResponse response = new GetVEInsScheduleResponse();

    	ArrayList<ScheduledEvent> veScheduleList = new ArrayList<ScheduledEvent>();
    	
    	if ((request.getVeInsId() != null) && (request.getVeInsId() != "")) {
    		
	    	VEInstance veIns = veSchDB.getVEInstance(request.getVeInsId());
	    	if (veIns != null) {
	    		veScheduleList = veSchDB.getVEInsScheduleList(
	    				veIns, 
	    				request.getTimePeriod().getStartTime(), 
	    				request.getTimePeriod().getEndTime());

	    		response.setSuccess(true);
	    		response.setMessage("List of schedules were retrived successfully!");
	    	} else {

	    		response.setSuccess(false);
	    		response.setMessage("The ve instance for ve ins id " + 
	    				request.getVeInsId() + 
	    				"does not exist!");
	    		
	    	}
    	}
    	else {
    		
    		response.setSuccess(false);
    		response.setMessage("Parameter veInsId cannot be null nor empty!");
    		
    	}
	    	
		for (int i = 0; i < veScheduleList.size(); i++) {
			
			response.addSchedule(veScheduleList.get(i));
			
		}	
  	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVESchedule] Ready to get out!");

    	return response;

    }

    /**
     * 
     * @param request
     * @return
     */
    public GetVEInsCurScheduleResponse getVEInsCurSchedule(
    		GetVEInsCurScheduleRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVESchedule] Inside!");

    	GetVEInsCurScheduleResponse response = new GetVEInsCurScheduleResponse();

    	if ((request.getVeInsId() != null) && (request.getVeInsId() != "")) {
    		
	    	VEInstanceSchedule veInsSch = veSchDB.getVEInsCurSch(request.getVeInsId());
	    	
	    	if (veInsSch != null) {
	    		ScheduledEvent veInsSchEvent = new ScheduledEvent();
	    		veInsSchEvent.setSchId(veInsSch.getId());
	    		TimePeriod timePeriod = new TimePeriod();
	    		timePeriod.setStartTime(veInsSch.getStartTime());
	    		timePeriod.setEndTime(veInsSch.getEndTime());
	    		veInsSchEvent.setTimePeriod(timePeriod);
	    		response.setSchedule(veInsSchEvent);
	    		response.setSuccess(true);
	    		response.setMessage("List of schedules were retrived successfully!");
	    	} else {
	    		response.setSuccess(false);
	    		response.setMessage("No current schedule was found for this ve instance!");
	    	}
    	}
    	else {
    		
    		response.setSuccess(false);
    		response.setMessage("Parameter veInsId cannot be null nor empty!");
    		
    	}
	    	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVESchedule] Ready to get out!");

    	return response;

    }

    /**
     * 
     * @param request
     * @return
     */
    public GetVEInsScheduleBySchIdResponse getVEInsScheduleBySchId(
    		GetVEInsScheduleBySchIdRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEInsScheduleBySchId] Inside!");

    	GetVEInsScheduleBySchIdResponse response = new GetVEInsScheduleBySchIdResponse();

		ScheduledEvent veInsScheduledEvent = null;
		if ((request.getVeInsSchId() != null) && (request.getVeInsSchId() != "")) {
    		VEInstanceSchedule veInsSch = veSchDB.getVEInsSch(request.getVeInsSchId());
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(veInsSch.getStartTime());
			timePeriod.setEndTime(veInsSch.getEndTime());
			veInsScheduledEvent = new ScheduledEvent();
			veInsScheduledEvent.setTimePeriod(timePeriod);
			veInsScheduledEvent.setSchId(request.getVeInsSchId());
    		response.setSuccess(true);
	    	response.setMessage("List of schedules were retrived successfully!");    	
    	} else {
    		response.setSuccess(false);
    		response.setMessage("Parameter veInsId cannot be null nor empty!");
    	}
		response.setSchedule(veInsScheduledEvent);
	    	  	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getVEInsScheduleBySchId] Ready to get out!");

    	return response;

    }

    /**
     * 
     * @return
     */
	public GetConfigurationResponse getConfiguration() {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getConfiguration] Inside!");
		
		GetConfigurationResponse response = new GetConfigurationResponse();
		
		Configuration config = veSchDB.getConfiguration();
		
		TimePeriod userTimePeriod = new TimePeriod();
		userTimePeriod.setStartTime(config.getUserStartTime());
		userTimePeriod.setEndTime(config.getUserEndTime());
		response.setUserTimePeriod(userTimePeriod);
		TimePeriod adminTimePeriod = new TimePeriod();
		adminTimePeriod.setStartTime(config.getAdminStartTime());
		adminTimePeriod.setEndTime(config.getAdminEndTime());
		response.setAdminTimePeriod(adminTimePeriod);
		
		response.setSuccess(true);
		response.setMessage("The configuration was successfully retrieved!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getConfiguration] Ready to get out!");
		
		return response;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized SetConfigurationResponse setConfiguration(SetConfigurationRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "VEScheduler - setConfiguration] Inside!");
		
		SetConfigurationResponse response = new SetConfigurationResponse();
		
		Configuration config = new Configuration(
				request.getUserTimePeriod().getStartTime(), 
				request.getUserTimePeriod().getEndTime(),
				request.getAdminTimePeriod().getStartTime(),
				request.getAdminTimePeriod().getEndTime());
		
		DebugTools.println(DEBUG_LEVEL, "VEScheduler - setConfiguration] config: " +
				"userStart: " + config.getUserStartTime().getTime() + " " +
				"userEnd: " + config.getUserEndTime().getTime() + " " +
				"adminStart: " + config.getAdminStartTime().getTime() + " " +
				"adminEnd: " + config.getAdminEndTime().getTime());
		
		veSchDB.setConfiguration(config);
		
		response.setSuccess(true);
		response.setMessage("The new configuration was set successfully!");
		
		DebugTools.println(DEBUG_LEVEL, "VEScheduler - setConfiguration] Ready to get out!");

		return response;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetHostResponse getHost(GetHostRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHost] Inside!");
		
		GetHostResponse response = new GetHostResponse();
		
		Host host = veSchDB.getHost(request.getHostId());
		if (host != null) {
			
			response.setHost(host.getConvertedHost());
			response.setSuccess(true);
			response.setMessage("The host information was retrieved successfully!");
			
		}
		else {
			
			response.setHost(null);
			response.setSuccess(false);
			response.setMessage("The host does NOT exist!");
			
		}
			
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHost] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetHostUsingNameResponse getHostUsingName(GetHostUsingNameRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostUsingName] Inside!");
		
		GetHostUsingNameResponse response = new GetHostUsingNameResponse();
		
		Host host = veSchDB.getHostUsingName(request.getHostName());
		if (host != null) {
			
			response.setHost(host.getConvertedHost());
			response.setSuccess(true);
			response.setMessage("The host information was retrieved successfully!");
			
		}
		else {
			
			response.setHost(null); 
			response.setSuccess(false);
			response.setMessage("The host does NOT exist!");
			
		}
			
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostUsingName] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @return
	 */
	public GetHostListResponse getHostList(GetHostListRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostList] Inside!");
		
		GetHostListResponse response = new GetHostListResponse();
		
		// TODO newAssignment filled is being assumed as always true!!!
		ArrayList<Host> hostList = veSchDB.getHostList(request.getActive(),true);
		if (hostList != null) {
			
			for (int i=0; i<hostList.size(); i++) 
				response.addHost(hostList.get(i).getConvertedHost());
			
			response.setSuccess(true);
			response.setMessage("The host list information was retrieved successfully!");
		
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("The host list was NOT retrieved successfully!");
		
		}
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostList] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized SetHostResponse setHost(SetHostRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - setHost] Inside!");
		
		SetHostResponse response = new SetHostResponse();
		
		if (veSchDB.setHost(Host.getHost(request.getHost()))) {
			
			response.setSuccess(true);
			response.setMessage("The host information was set successfully!");
				
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("The host information was NOT set!");
				
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - setHost] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized DelHostResponse delHost(DelHostRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delHost] Inside!");
		
		DelHostResponse response = new DelHostResponse();
		
		if (veSchDB.delHost(request.getHostId())) {
			
			response.setSuccess(true);
			response.setMessage("The host was deleted successfully!");
				
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("The host was NOT deleted successfully!");
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delHost] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized AddHostResponse addHost(AddHostRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addHost] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addHost] host name: " +
				request.getHost().getName());
		
		AddHostResponse response = new AddHostResponse();
		
		int id = veSchDB.addHost(Host.getHost(request.getHost()));
		
		if (id > 0) {
			
			response.setSuccess(true);
			response.setMessage("The new host was added successfully!");
				
		}
		else {
			
			response.setSuccess(false);
			response.setMessage("The new host was NOT added successfully!");
				
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addHost] Ready to get out!");
		
		return response;
			
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetStorageResponse getStorage(GetStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getStorage] Inside!");
		
		GetStorageResponse response = new GetStorageResponse();
		
		Storage storage = veSchDB.getStorage(request.getStorageId());
		if (storage != null) {
			response.setStorage(storage.getConvertedStorage());
			response.setSuccess(true);
			response.setMessage("The storage information was retrieved successfully!");
		} else {
			response.setStorage(null);
			response.setSuccess(false);
			response.setMessage("The storage does NOT exist!");
		}
			
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getStorage] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @return
	 */
	public GetStorageListResponse getStorageList(GetStorageListRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getStorageList] Inside!");
		
		GetStorageListResponse response = new GetStorageListResponse();
		
		ArrayList<Storage> storageList = veSchDB.getStorageList(request.getActive());
		if (storageList != null) {
			
			for (int i=0; i<storageList.size(); i++) 
				response.addStorage(storageList.get(i).getConvertedStorage());
			
			response.setSuccess(true);
			response.setMessage("The storage list information was retrieved successfully!");
		} else {
			response.setSuccess(false);
			response.setMessage("The storage list was NOT retrieved successfully!");
		}
				
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getStorageList] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized SetStorageResponse setStorage(SetStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - setStorage] Inside!");
		
		SetStorageResponse response = new SetStorageResponse();
		
		if (veSchDB.setStorage(Storage.getStorage(request.getStorage()))) {
			response.setSuccess(true);
			response.setMessage("The storage information was set successfully!");
		} else {
			response.setSuccess(false);
			response.setMessage("The storage information was NOT set!");		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - setStorage] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized DelStorageResponse delStorage(DelStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delStorage] Inside!");
		
		DelStorageResponse response = new DelStorageResponse();
		
		if (veSchDB.delStorage(request.getStorageId())) {
			response.setSuccess(true);
			response.setMessage("The storage was deleted successfully!");
		} else {
			response.setSuccess(false);
			response.setMessage("The storage was NOT deleted successfully!");		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delStorage] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized AddStorageResponse addStorage(AddStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addStorage] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addStorage] storage dirPath: " +
				request.getStorage().getDirPath());
		
		AddStorageResponse response = new AddStorageResponse();
		
		int id = veSchDB.addStorage(Storage.getStorage(request.getStorage()));
		
		if (id > 0) {
			response.setStorageId(id);
			response.setSuccess(true);
			response.setMessage("The new storage was added successfully!");
		} else {
			response.setStorageId(id);
			response.setSuccess(false);
			response.setMessage("The new storage was NOT added successfully!");
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addStorage] Ready to get out!");
		
		return response;
			
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public GetHostStorageResponse getHostStorage(GetHostStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostStorage] Inside!");
		
		GetHostStorageResponse response = new GetHostStorageResponse();
		
		HostStorage hostStorage = veSchDB.getHostStorage(request.getHostId(), request.getStorageId());
		if (hostStorage != null) {
			response.setHostStorage(hostStorage.getConvertedHostStorage());
			response.setSuccess(true);
			response.setMessage("The hostStorage information was retrieved successfully!");
		} else {
			response.setHostStorage(null);
			response.setSuccess(false);
			response.setMessage("The hostStorage does NOT exist!");
		}
			
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostStorage] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @return
	 */
	public GetHostStorageListResponse getHostStorageList(GetHostStorageListRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostStorageList] Inside!");
		
		GetHostStorageListResponse response = new GetHostStorageListResponse();
		
		ArrayList<HostStorage> hostStorageList = 
			veSchDB.getHostStorageList(
					request.getHostId(),
					request.getStorageId(),
					request.getActive());
		if (hostStorageList != null) {
			
			for (int i=0; i<hostStorageList.size(); i++) 
				response.addHostStorage(hostStorageList.get(i).getConvertedHostStorage());
			
			response.setSuccess(true);
			response.setMessage("The hostStorage list information was retrieved successfully!");
		} else {
			response.setSuccess(false);
			response.setMessage("The hostStorage list was NOT retrieved successfully!");
		}
				
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostStorageList] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized SetHostStorageResponse setHostStorage(SetHostStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - setHostStorage] Inside!");
		
		SetHostStorageResponse response = new SetHostStorageResponse();
		
		if (veSchDB.setHostStorage(HostStorage.getHostStorage(request.getHostStorage()))) {
			response.setSuccess(true);
			response.setMessage("The hostStorage information was set successfully!");
		} else {
			response.setSuccess(false);
			response.setMessage("The hostStorage information was NOT set!");		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - setHostStorage] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized DelHostStorageResponse delHostStorage(DelHostStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delHostStorage] Inside!");
		
		DelHostStorageResponse response = new DelHostStorageResponse();
		
		if (veSchDB.delHostStorage(request.getHostId(), request.getStorageId())) {
			response.setSuccess(true);
			response.setMessage("The hostStorage was deleted successfully!");
		} else {
			response.setSuccess(false);
			response.setMessage("The hostStorage was NOT deleted successfully!");		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delHostStorage] Ready to get out!");
		
		return response;
			
	}
 
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized AddHostStorageResponse addHostStorage(AddHostStorageRequest request) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addHostStorage] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addHostStorage] hostStorage preference: " +
				request.getHostStorage().getPreference());
		
		AddHostStorageResponse response = new AddHostStorageResponse();
		
		boolean retVal = veSchDB.addHostStorage(HostStorage.getHostStorage(request.getHostStorage()));
		
		if (retVal) {
			response.setSuccess(true);
			response.setMessage("The new hostStorage was added successfully!");
		} else {
			response.setSuccess(false);
			response.setMessage("The new hostStorage was NOT added successfully!");
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - addHostStorage] Ready to get out!");
		
		return response;
			
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized ScheduleHostMaintenanceResponse scheduleHostMaintenance(
			ScheduleHostMaintenanceRequest request
			) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance] Inside!");
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance - request] id: " + 
				request.getHostId());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance - request] startTime:  " + 
				request.getTimePeriod().getStartTime().getTime());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance - request] endTime: " + 
				request.getTimePeriod().getEndTime().getTime());

		int hostId = request.getHostId();
		Calendar startTime = request.getTimePeriod().getStartTime();
		Calendar endTime = request.getTimePeriod().getEndTime();
		
		ScheduleHostMaintenanceResponse response = new ScheduleHostMaintenanceResponse();
		
		if (!isScheduleHostMaintenanceRequestValid(hostId, startTime, endTime)) {
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance] not a valid request!");
			
			response.setSchId(null);
			response.setSuccess(false);
			response.setMessage("The request for schedule is invalid!");
			
			return response;
			
		}
		
		HostMaintenanceSchedule hostMainSch = 
			new HostMaintenanceSchedule(
					null,
					hostId,
					startTime,
					endTime,
					true);
		
		String id = veSchDB.addHostMainSch(hostMainSch);
		
		if (id != null) {
			
			response.setSchId(id);
		    response.setSuccess(true);
		    response.setMessage("Successfully scheduled!");

		}
		else {
			
			response.setSchId(id);
		    response.setSuccess(false);
		    response.setMessage("Host maintenance could NOT be scheduled!");
		    
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance - response] id: " + 
				response.getSchId());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance - response] success: " + 
				response.getSuccess());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance - response] message: " + 
				response.getMessage());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - scheduleHostMaintenance] Ready to get out!"); 
				
		return response;
	
	}
	
	/**
	 * 
	 * @param veType
	 * @param veInsId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private boolean isScheduleHostMaintenanceRequestValid(
			int hostId, Calendar startTime, Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleHostMaintenanceRequestValid] Inside!");
		
		boolean retVal = false;
		
		ArrayList<TimePeriod> hostMainAvailableList = TimePeriodTools.toggleTimePeriodList(
    			getHostMaintenanceUnavailabilityList(hostId, startTime, endTime), 
				startTime, endTime);
			
    	if (hostMainAvailableList.size() == 1) {
    		if ((hostMainAvailableList.get(0).getStartTime().compareTo(startTime) == 0) &&
    			(hostMainAvailableList.get(0).getEndTime().compareTo(endTime) == 0))
    			retVal = true;
    	}
    	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleHostMaintenanceRequestValid] " +
    			"hostMainAvailableList.size(): " + hostMainAvailableList.size());
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleHostMaintenanceRequestValid] " +
    			"retVal: " + retVal);
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - isScheduleHostMaintenanceRequestValid] Ready to get out!");
		
		return retVal;
		
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public synchronized CancelScheduledHostMaintenanceResponse 
		cancelScheduledHostMaintenance(CancelScheduledHostMaintenanceRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleHost] Inside!");
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleHost - request] id: " + 
				request.getSchId());
		
    	// CancelScheduledHostResponse response = veSchDB.cancelScheduleHost(request);
    	
    	CancelScheduledHostMaintenanceResponse response = new CancelScheduledHostMaintenanceResponse();
    	
    	HostMaintenanceSchedule hostMainSch = veSchDB.getHostMainSch(request.getSchId());
    	if (hostMainSch != null) {
    		
    		hostMainSch.setActive(false);
        	veSchDB.setHostMainSch(hostMainSch);
        	
        	response.setSuccess(true);
    		response.setMessage("Cancellation was successful!);");
    		
    	}
    	else {
    		
    		response.setSuccess(false);
    		response.setMessage("Cancellation was NOT successful!);");
    		
    	}
    	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleHost - response] success: " + 
				response.getSuccess());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleHost - response] message: " + 
				response.getMessage());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - cancelScheduleHost] Ready to get out!");
    	
		return response;

    }
       
	/**
	 * 
	 * @param request
	 * @return
	 */
    public synchronized ModifyScheduledHostMaintenanceResponse 
    	modifyScheduledHostMaintenance(ModifyScheduledHostMaintenanceRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - modifyScheduleHost] Inside!");
    	
    	ModifyScheduledHostMaintenanceResponse response = 
    		new ModifyScheduledHostMaintenanceResponse();
    	
    	HostMaintenanceSchedule hostMainSch = veSchDB.getHostMainSch(request.getSchId());
    	hostMainSch.setActive(false);
    	veSchDB.setHostMainSch(hostMainSch);
    	
    	HostMaintenanceSchedule newHostMainSch = new HostMaintenanceSchedule(
    			null,
    			hostMainSch.getHostId(),
    			request.getTimePeriod().getStartTime(),
    			request.getTimePeriod().getEndTime(),
    			true);

    	ScheduleHostMaintenanceRequest schReq = new ScheduleHostMaintenanceRequest();
    	schReq.setHostId(newHostMainSch.getHostId());
    	TimePeriod timePeriod = new TimePeriod();
    	timePeriod.setStartTime(request.getTimePeriod().getStartTime());
    	timePeriod.setEndTime(request.getTimePeriod().getEndTime());
    	schReq.setTimePeriod(timePeriod);
    	
    	ScheduleHostMaintenanceResponse schRes = scheduleHostMaintenance(schReq);
    	if (!schRes.getSuccess()) {
    		
    		hostMainSch.setActive(true);
        	veSchDB.setHostMainSch(hostMainSch);
        	
        	response.setSchId(request.getSchId());
        	response.setSuccess(false);
        	response.setMessage("Modification was NOT successful!");
        		
    	}
    	else {
    	
    		response.setSchId(schRes.getSchId());
    		response.setSuccess(true);
        	response.setMessage("Modification was successful!");
        	
    	}
    	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - modifyScheduleHost] Ready to get out!");
    	
    	return response;

    }

    /**
     * Gets the list of all unavailable periods for one or all hosts.
     * @param request
     * @return
     */
	private ArrayList<TimePeriod> getHostMaintenanceUnavailabilityList(
			int hostId,
			Calendar startTime,
			Calendar endTime) {

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] Inside!");
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] " +
			"hostId: " + hostId);
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] " +
			"startTime: " + startTime.getTime());
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] " +
			"endTime:" + endTime.getTime());
		
		// check for wrong input parameters!
		if (startTime.compareTo(endTime) >= 0)
			return null;
		
		ArrayList<TimePeriod> unavailList = new ArrayList<TimePeriod>();
		
		if (!veSchDB.getHost(hostId).isActive()) {
		
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(endTime);
			
			unavailList.add(timePeriod);
			
			return unavailList;
			
		}
		
		Calendar fixedStartTime = fixAdminStartTime(startTime);
		Calendar fixedEndTime = fixAdminEndTime(endTime);
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] " +
				"fixedStartTime: " + fixedStartTime.getTime());
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] " +
				"fixedEndTime:" + fixedEndTime.getTime());
			
		if (fixedStartTime.compareTo(fixedEndTime) >= 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(endTime);
			
			unavailList.add(timePeriod);
			
			return unavailList;
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] " +
				"hostId: " + hostId);
		
		ArrayList<ScheduledEvent> hostUnavailEventList = veSchDB.getHostMainSchList(
				hostId, fixedStartTime, fixedEndTime);	
		ArrayList<TimePeriod> hostUnavailList =
			TimePeriodTools.convertFromEventToTimePeriod(hostUnavailEventList);
		unavailList.addAll(hostUnavailList);

		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList - " +
				"after getHostMainSchList] list size: " + hostUnavailList.size());
		
		ArrayList<TimePeriod> userScheduledList = veSchDB.getHostUserScheduledList(
				hostId, fixedStartTime, fixedEndTime);
		unavailList.addAll(userScheduledList);
									
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList - " +
				"after getHostUserScheduledList] list size: " + userScheduledList.size());
			
		if (userScheduledList.size() > 0)
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList - " +
				"after getHostUserScheduledList] start: " + 
				userScheduledList.get(0).getStartTime().getTime() + " end: " +
				userScheduledList.get(0).getEndTime().getTime());
			
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList - " +
				"after getHostUserScheduledList] list total size: " + unavailList.size());
				
		unavailList = TimePeriodTools.fixAndSortTimePeriodList(unavailList);
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList - " +
				"after getCommonPeriods] list total size: " + unavailList.size());
		
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
		
		unavailList = TimePeriodTools.fixAndSortTimePeriodList(unavailList);
		
		DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostMaintenanceUnavailabilityList] Ready to get out!");
		
		return unavailList;

	}

	/**
	 * 
	 * @param startTime
	 * @return
	 */
    private Calendar fixAdminStartTime(Calendar startTime) {
		
    	Calendar fixedStartTime = (Calendar)startTime.clone();
    	
    	Configuration config = veSchDB.getConfiguration();
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
    	
    	Configuration config = veSchDB.getConfiguration();
    	if (fixedEndTime.compareTo(config.getAdminEndTime()) > 0) {
    		
    		fixedEndTime = (Calendar)config.getAdminEndTime().clone();
    	
    	}
    		
    	return fixedEndTime;

	}

	/**
     * 
     * @param request
     * @return
     */
    public GetHostMaintenanceAvailabilityResponse 
    	getHostMaintenanceAvailability(GetHostMaintenanceAvailabilityRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostAvailability] Inside!");
    	
    	GetHostMaintenanceAvailabilityResponse response = 
    		new GetHostMaintenanceAvailabilityResponse();
		
    	ArrayList<TimePeriod> hostAvailableList = TimePeriodTools.toggleTimePeriodList(
				getHostMaintenanceUnavailabilityList(
						request.getHostId(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime()), 
				request.getTimePeriod().getStartTime(), 
				request.getTimePeriod().getEndTime());
			
		for (int i = 0; i < hostAvailableList.size(); i++) {
			
			response.addAvailabilityRange(hostAvailableList.get(i));
			
		}	
		
		response.setSuccess(true);
		response.setMessage("Host availability list was successfully returned!");
  	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostAvailability] Ready to get out!");
    	
    	return response;

    }
 
    /**
     * 
     * @param request
     * @return
     */
    public GetHostMaintenanceUnavailabilityResponse 
    	getHostMaintenanceUnavailability(GetHostMaintenanceUnavailabilityRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostUnavailability] Inside!");
    	
    	GetHostMaintenanceUnavailabilityResponse response = 
    		new GetHostMaintenanceUnavailabilityResponse();
		
		ArrayList<TimePeriod> hostMaintenanceUnavailableList = 
			getHostMaintenanceUnavailabilityList(
						request.getHostId(),
						request.getTimePeriod().getStartTime(),
						request.getTimePeriod().getEndTime());
			
		for (int i = 0; i < hostMaintenanceUnavailableList.size(); i++) {
			
			response.addUnavailabilityRange(hostMaintenanceUnavailableList.get(i));
			
		}	
		
		if (hostMaintenanceUnavailableList.size() == 0) {
			
	    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostUnavailability] " +
	    			"hostUnavailableList.size(): " + hostMaintenanceUnavailableList.size());

	    	TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(request.getTimePeriod().getEndTime());
			timePeriod.setEndTime(request.getTimePeriod().getEndTime());
			response.addUnavailabilityRange(timePeriod);
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostUnavailability] " +
	    			"timePeriod: " + timePeriod);

		}
		
		response.setSuccess(true);
		response.setMessage("Host unavailability list was successfully returned!");
  	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostUnavailability] Ready to get out!");
    	
    	return response;

    }
    
    /**
     * 
     * @param request
     * @return
     */
    public GetHostMaintenanceScheduleResponse 
    	getHostMaintenanceSchedule(GetHostMaintenanceScheduleRequest request) {

    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostSchedule] Inside!");

    	GetHostMaintenanceScheduleResponse response = 
    		new GetHostMaintenanceScheduleResponse();

    	ArrayList<ScheduledEvent> hostScheduleList = new ArrayList<ScheduledEvent>();
    	
    	Host host = veSchDB.getHost(request.getHostId());
    	
    	if (host != null) {
    		
	    	hostScheduleList = veSchDB.getHostMainSchList(
	    			host.getId(),
	    			request.getTimePeriod().getStartTime(), 
	    			request.getTimePeriod().getEndTime());
	    	
	    	response.setSuccess(true);
	    	response.setMessage("List of schedules were retrieved successfully!");
    	
    	}
    	else {
    		
    		response.setSuccess(false);
    		response.setMessage("Host #" + request.getHostId() + " does not exist!");
    		
    	}
	    	
		for (int i = 0; i < hostScheduleList.size(); i++) {
			
			response.addSchedule(hostScheduleList.get(i));
			
		}	
  	
    	DebugTools.println(DEBUG_LEVEL, "[VEScheduler - getHostSchedule] Ready to get out!");

    	return response;

    }

}