package edu.fiu.cis.acrl.vescheduler.server.agent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

import com.kaseya.hosted.webservices.AccountType;
import com.kaseya.hosted.webservices.TrialRequest;
import com.kaseya.hosted.webservices.TrialType;

import edu.fiu.cis.acrl.kaseya.client.KaseyaWSClient;
import edu.fiu.cis.acrl.kaseya.tenant.client.KaseyaTenant;
import edu.fiu.cis.acrl.kaseya.tenant.client.TenantAccount;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;
import edu.fiu.cis.acrl.vescheduler.server.Host;
import edu.fiu.cis.acrl.vescheduler.server.KServer;
import edu.fiu.cis.acrl.vescheduler.server.Tenant;
import edu.fiu.cis.acrl.vescheduler.server.VEInsHost;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance;
import edu.fiu.cis.acrl.vescheduler.server.VEInstanceSchedule;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance.VEInsStatusType;
import edu.fiu.cis.acrl.vescheduler.server.VEScheduler;
import edu.fiu.cis.acrl.vescheduler.server.VESchedulerSettings;
import edu.fiu.cis.acrl.vescheduler.server.VMInstance.VMInsStatusType;
import edu.fiu.cis.acrl.vescheduler.server.WrongCommandStatuCombinationException;
import edu.fiu.cis.acrl.vescheduler.server.agent.SchedulingTask.TaskType;
import edu.fiu.cis.acrl.vescheduler.server.db.VESchedulerDB;
import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;
import edu.fiu.cis.acrl.virtuallabs.server.UserVEInstance;
import edu.fiu.cis.acrl.virtuallabs.server.VirtualLabs;
import edu.fiu.cis.acrl.virtuallabs.server.VirtualLabsSettings;
import edu.fiu.cis.acrl.virtuallabs.server.db.VirtualLabsDB;
import edu.fiu.cis.acrl.virtuallabs.server.User;
import edu.fiu.cis.acrl.virtuallabs.ws.AddInitialTasks4NewVMsRequest;
import edu.fiu.cis.acrl.virtuallabs.ws.AddInitialTasks4NewVMsResponse;
import edu.fiu.cis.acrl.virtuallabs.ws.Appointment;
import edu.fiu.cis.acrl.virtuallabs.ws.DestroyDevaInsRequest;
import edu.fiu.cis.acrl.virtuallabs.ws.DestroyDevaInsResponse;
import edu.fiu.cis.acrl.virtuallabs.ws.ScheduleUserAppointmentsRequest;
import edu.fiu.cis.acrl.virtuallabs.ws.ScheduleUserAppointmentsResponse;
import edu.fiu.cis.acrl.virtuallabs.ws.VirtualLabsStub;

/**
 * This class would be woken up when there is a task assigned its associated 
 * host, while awake starts/stops all the related tasks, and goes back to sleep
 * when there is not more task. 
 * 
 */
public class SchedulingAgent4Host extends Thread { // implements Runnable {

	// Debug level for this class
	private static int DEBUG_LEVEL = -1;
	private static int SPECIAL_DL = -1;
	
	private VESchedulerSettings veSchSettings;

	// private VirtualLabsStub vLabsStub;
	private VirtualLabs vLabsStub;

	private VirtualLabsDB virtualLabsDB;
	private VirtualLabsSettings vLabsSettings;

	private static final String STOP_SCRIPT = "stop_ve.py";
	private static final String START_SCRIPT = "start_ve.py";
	
	private static final String SIGNAL_ALL_SCRIPT = "signal_all_ves.py";
	private static final String SIGNAL_VE_SCRIPT = "signal_ve.py";

	private static final String NO_STOP_START_SCRIPT = "no_stop_start.py";
	private static final String GET_LOAD_AVERAGE_SCRIPT = "get_load_average.py";

	private VESchedulerDB veSchDB;
	// private KaseyaWSClient kaseyaWSClient;
    private boolean running;
    private int hostId;
    
    private boolean waiting;
    // private Object lock;
    // private boolean threadIsRunning;
    
	/**
	 * Create the agent for a particular host
	 * 
	 */
	public SchedulingAgent4Host(int hostId) {

		this.hostId = hostId;
		this.veSchDB= VESchedulerDB.instance();
		
		// Host host = veSchDB.getHost(hostId);
		// this.kaseyaWSClient = KaseyaWSClient.instance();
		this.running = false;
		this.waiting = false;
		// this.lock = new Object();
		// this.threadIsRunning = false;

		this.virtualLabsDB = new VirtualLabsDB();

		vLabsSettings = VirtualLabsSettings.instance();

		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - SchedulingAgent4Host] Settings!" + vLabsSettings);

		virtualLabsDB.connect(
				vLabsSettings.getDbUser(), 
				vLabsSettings.getDbPassword(), 
				vLabsSettings.getDbHost(), 
				vLabsSettings.getDbName());

		veSchSettings = VESchedulerSettings.instance();

		try {

			// vLabsStub = new VirtualLabsStub(veSchSettings.getVLabsEPR());
			vLabsStub = VirtualLabs.instance();
			
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void run() {

		running = true;

		while(running) {
			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - run] " +
					" before calling executeTask()");
			executeTasks();
			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - run] " +
					" after calling executeTask()");
				
		}
		
	}
/*
	private void signalAllVEs(String signal) {
	
		String command = 
			SIGNAL_ALL_SCRIPT + " " + signal; 
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - signalAllVEs] " +
				"command to be executed: " + command);
		Host host = veSchDB.getHost(this.hostId);
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

	}

	private boolean noStopStart() {
		
		String command = 
			NO_STOP_START_SCRIPT; 
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - noStopStart] " +
				"command to be executed: " + command);
		Host host = veSchDB.getHost(this.hostId);
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
		
		boolean retVal = false;
		if (exitCode == 0)
			retVal = true;
		
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - noStopStart] " +
				"command: " + command + "\n" +
				"    exitCode: " + exitCode + "\n" +
				"    retVal: " + retVal);

		return retVal;
		
	}

	private boolean loadIsHigh() {
		
		String command = 
			GET_LOAD_AVERAGE_SCRIPT; 
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - loadIsHigh] " +
				"command to be executed: " + command);
		Host host = veSchDB.getHost(this.hostId);
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
		
		boolean retVal = false;
		if (exitCode > 20)
			retVal = true;
		
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - loadIsHigh] " +
				"command: " + command + "\n" +
				"    exitCode: " + exitCode + "\n" +
				"    retVal: " + retVal);

		return retVal;
		
	}

	private void signalVE(SchedulingTask t, String signal) {

		
		String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(t.getVeInsId());
		String command = 
			SIGNAL_VE_SCRIPT + " " + 
			// t.getUsername() + " " +
			veInsUsername + " " +
			t.getVeType().getVEName() + " " + 
			t.getFirstPort() + " " + 
			t.getStorageHostId() + " " +
			signal;
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - signalVE] " +
				"command to be executed: " + command);
		Host host = veSchDB.getHost(this.hostId);
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

	}
*/		
	private void stopVE(SchedulingTask t) {
		
		String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(t.getVeInsId());
		String command = 
			STOP_SCRIPT + " " + 
			// t.getUsername() + " " + 
			veInsUsername + " " +
			t.getVeType().getVEName() + " " + 
			t.getFirstPort() + " " + 
			t.getNumPorts() + " " + 
			t.getRouterId() + " " +
			t.getStorageHostId();
		DebugTools.println(SPECIAL_DL, "[SchedulingAgent4Host - hostId " + this.hostId + " - stopVE] " +
				"command to be executed: " + command);

		Host host = veSchDB.getHost(t.getHostId());
		int wait = 0;
		SSHCommand cmd = 
			new SSHCommand(
					command, 
					host.getName(), 
					host.getSshPort(), 
					host.getUsername(), 
					host.getPassword(),
					wait);
		// (new Thread(cmd)).start();
		int retCode = 0;
		while (retCode != 111) {
			DebugTools.println(SPECIAL_DL, "[SchedulingAgent4Host - hostId " + this.hostId + " - stopVE] " +
					"command that is going to be dispatched: " + command + " " +
					"on host " + host.getId() + " " +
					"and is in the waiting list for " + wait + " seconds!" +
					" retCode is " + retCode);
			retCode = cmd.run();
		}

	}

	private boolean setRouterId(SchedulingTask t) {
		
		boolean retVal = true;
		
		if (t.getRouterId() == 0) {
			int routerId =
				veSchDB.allocateRouterId(
						t.getVeInsId(),
						t.getHostId(),
						t.getStorageHostId());
			if (routerId > 0) {
				t.setRouterId(routerId);
			} else {
				Exception e =
					new Exception(
							"There is no more router available on host " + t.getHostId() + " " +
							"to be allocated for " + t.getUsername() + " " +
							"ve_ins_id of " + t.getVeInsId() + "\n" +
					"The job will be cancelled!");
				e.printStackTrace();
				String veInsSchId = t.getVeInsSchId();
				VEInstanceSchedule veInsSch = veSchDB.getVEInsSch(veInsSchId);
				veInsSch.setActive(false);
				veSchDB.setVEInsSch(veInsSch);
				
				retVal = false;
			}
		}

		return retVal;
	}
	
	private Host startVE(SchedulingTask t) {
		
		String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(t.getVeInsId());
		String command = 
			START_SCRIPT + " " + 
			// t.getUsername() + " " + 
			veInsUsername + " " +
			t.getVeType().getVEName() + " " + 
			t.getFirstPort() + " " + 
			t.getNumPorts() + " " + 
			t.getFirstMac() + " " + 
			t.getNumMacs() + " " + 
			t.getRouterId() + " " +
			t.getStorageHostId() + " " +
			t.getRegisterAction();

		int wait = 0;
		Host host = veSchDB.getHost(t.getHostId());
		SSHCommand cmd = 
			new SSHCommand(
					command, 
					host.getName(), 
					host.getSshPort(), 
					host.getUsername(), 
					host.getPassword(),
					wait);
		int retCode = 0;
		while (retCode != 111) {
			DebugTools.println(SPECIAL_DL, "[SchedulingAgent4Host - hostId " + this.hostId + " - startVE] " +
					"command that is going to be dispatched: " + command + " " +
					"on host " + host.getId() + " " +
					"and is in the waiting list for " + wait + " seconds!");
			retCode = cmd.run();
		}

		return host;
		
	}
	
	private void refreshStoppedVE(SchedulingTask t) {

		VEInstance veIns = veSchDB.getVEInstance(t.getVeInsId());

		String REFRESH_STOPPED_SCRIPT = "refresh_stopped_ve.py";

		String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(t.getVeInsId());
		String command = 
			REFRESH_STOPPED_SCRIPT + " " + 
			// veIns.getUsername() + " " + 
			veInsUsername + " " +
			veIns.getVeType().getVEName() + " " + 
			veIns.getFirstPort() + " " + 
			veIns.getStorageId();
		DebugTools.println(SPECIAL_DL, "[VEScheduler - hostId " + this.hostId + " - refreshStoppedVE] " +
				"command to be executed: " + command);
		Host host = veSchDB.getHost(t.getHostId());
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

	}	

	private synchronized void executeTasks() {

		Calendar now = Calendar.getInstance();
		DebugTools.println(
				3,
				"[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks]" +
						" >> SchedulingAgent4Host execution: " + 
				now.getTime());

		Collection<SchedulingTask> stopTasks  = null;
		Collection<SchedulingTask> startTasks = null;

		boolean loop = true;
		while (loop) {
			// Remove expired tasks!
			int expiredSchedulesCount = veSchDB.markExpiredSchedulesAsFasleAndDone();
			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
					"Number of expired schedules: " + expiredSchedulesCount);

			// select the tasks with type='STOP' and start_time in the past
			stopTasks = 
				veSchDB.getTasks4Host(
						hostId,
						SchedulingTask.TaskType.STOP, 
						Calendar.getInstance());

			// select the tasks with type='START' and start_time in the past
			startTasks = 
				veSchDB.getTasks4Host(
						hostId,
						SchedulingTask.TaskType.START, 
						Calendar.getInstance());

			if ((stopTasks.size() > 0) || (startTasks.size() > 0))
				waiting = false;
			else 
				waiting = true;

			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
					"stopTasks.size() is " + stopTasks.size() + " " +
					"startTasks.size() is " + startTasks.size() + " " +
					"waiting is " + waiting );

			if (waiting) {
				DebugTools.println(SPECIAL_DL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"The thread serving for host id: " + this.hostId + " " +
						"reports that there is nothing more to be done, so " +
				"it is going to stop running!");
				try { wait(); } catch (Exception e) {}
				// try { this.stop(); } catch (Exception e) {}
				// return;
			} else {
				loop = false;
			}
		}
		
		// Check if there is any stop task.
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
				"stopTasks.size(): " + stopTasks.size());
		boolean contSignalNeeded = false;

		// stop/pause the VMs for that VE
		for (SchedulingTask t : stopTasks) {

			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
					"Task to be executed: " + t);

			VEInstance origVeIns = veSchDB.getVEInstance(t.getVeInsId());
			if ((origVeIns.getStatus() != VEInsStatusType.PROVISIONING_AND_STARTING) &&
					(origVeIns.getStatus() != VEInsStatusType.RUNNING                  ) &&
					(origVeIns.getStatus() != VEInsStatusType.STARTING                 )) {

				DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"The pause/stop command must NOT be issued when the status " +
						"of the ve instance is: " + origVeIns.getStatus());
				Exception e = 
					new WrongCommandStatuCombinationException(
							"The pause/stop command must NOT be issued when the status " +
							"of the ve instance is: " + origVeIns.getStatus());
				e.printStackTrace();

			} else {

				/*
				// If there is, then check if the host is still running old stop/start tasks
				Calendar tempStart = Calendar.getInstance();
				while (!noStopStart()) {

					// If so, wait for 30 seconds and check again until all the stop/start tasks are gone
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
					"There is still stop and/or stop commands running! Waiting for 30 seconds...");
					try { Thread.sleep(30000); } catch (Exception e) {}

				}
				Calendar tempEnd = Calendar.getInstance();
				DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						" noStopStart() took " + ((tempEnd.getTimeInMillis() - tempStart.getTimeInMillis())/1000) +
						" seconds!");

				// Now that there is no more stop/start task
				// Check the load average on the host
				tempStart = Calendar.getInstance();
				// TODO
				signalAllVEs("STOP");
				contSignalNeeded = true;
				while (loadIsHigh()) {

					// If load is high, send a STOP signal to all the vmx processes and wait for 10 seconds
					// signalAllVEs("STOP");
					// contSignalNeeded = true;
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						" The load is too high! Waiting for 10 seconds...");
					try { Thread.sleep(10000); } catch (Exception e) {}

				}
				tempEnd = Calendar.getInstance();
				DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						" loadIsHigh() took " + ((tempEnd.getTimeInMillis() - tempStart.getTimeInMillis())/1000) +
						" seconds!");

				// If load is low (or not high any more), go ahead with stopping the ve instance
				
				if (contSignalNeeded)
					signalVE(t, "CONT");
				 */
				
				stopVE(t);

				veSchDB.setVMInsStatusByVeInsId(t.getVeInsId(), VMInsStatusType.PAUSING);
				veSchDB.setVEInsStatus(t.getVeInsId(), VEInsStatusType.PAUSING);

				VEInstanceSchedule veInsSch = veSchDB.getVEInsSch(t.getVeInsSchId());
				veInsSch.setDone(true);
				veSchDB.setVEInsSch(veInsSch);

				veSchDB.delHostUsedRouters(t.getHostId(), t.getVeInsId(), t.getRouterId());

				VEInstance veIns = veSchDB.getVEInstance(t.getVeInsId());
				KServer kserver = veSchDB.getKServer(veIns.getKserverId());
				// SMS: 11/02/2013
				// I made sure that diableAdmin is back in its place after a test is over!
				// For this, I needed to use the SaaS KServer instead of old kaseya2.cis.fiu.edu.
				// KaseyaWSClient kaseyaWSClient = KaseyaWSClient.instance(kserver.getName(), kserver.getHttpPort());
				Tenant tenant = veSchDB.getTenantByVeInsId(veIns.getId());
				KaseyaWSClient kaseyaWSClient = 
					KaseyaWSClient.instance(
						kserver.getName(), 
						80, 
						tenant.getUsername(), 
						tenant.getPassword(),
						"SHA-256",
						"System",
						"System");
				// SMS: Nov. 16, 2013
				// Fixed the issue for disabling admin
				String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
				DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"disableAdmin(" + veInsUsername + ")!");
				// SMS: Nov. 27, 2013
				// Temporarily commented out until the Web services are stable.
				/*
				if (!kaseyaWSClient.disableAdmin(veInsUsername)) {

					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
					"Error! The certificate admin in Kaseya could not be disabled!");
					Exception e = 
						new Exception(
						"Error! The certificate admin in Kaseya could not be disabled!");
					e.printStackTrace();
				}
				*/
				
				/*
				String resourceType = virtualLabsDB.getResourceTypeFromVeInsId(t.getVeInsId());
				if (resourceType.toUpperCase().equals("CERTIFICATE")) {
					
					if (!kaseyaWSClient.disableAdmin(t.getUsername() + "-ct")) {

						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"Error! The certificate admin in Kaseya could not be disabled!");
						Exception e = 
							new Exception(
							"Error! The certificate admin in Kaseya could not be disabled!");
						e.printStackTrace();
					}
				
				} else {
				
					if (!kaseyaWSClient.disableAdmin(t.getUsername())) {

						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"Error! The admin in Kaseya could not be disabled!");
						Exception e = 
							new Exception(
							"Error! The admin in Kaseya could not be disabled!");
						e.printStackTrace();
					}
				
				}
				*/

				/*
				// Check if a CONT signal is needed
				if (contSignalNeeded) {

					signalAllVEs("CONT"); 
					signalAllVEs("CONT"); 
					signalAllVEs("CONT"); 

				}
				 */

			}
		}


		// Check if there is any start task.
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
				"startTasks.size(): " + startTasks.size());

		// assign an available slot to the VE and start it up
		for (SchedulingTask t : startTasks) {

			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
					"Thread serving host id: " + this.hostId + "\n" +
					"Task to be executed: " + t);

			VEInstance origVeIns = veSchDB.getVEInstance(t.getVeInsId());
			if ((origVeIns.getStatus() != VEInsStatusType.NOT_PROVISIONED) &&
					(origVeIns.getStatus() != VEInsStatusType.PAUSING        ) &&
					(origVeIns.getStatus() != VEInsStatusType.PAUSED         )) {

				DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"The start command must NOT be issued when the status " +
						"of the ve instance is: " + origVeIns.getStatus());
				Exception e =
					new WrongCommandStatuCombinationException(
							"The start command must NOT be issued when the status " +
							"of the ve instance is: " + origVeIns.getStatus());
				e.printStackTrace();

			} else {

				// SMS: 2013-05-04
				// I am assuming no on-premise server no more! ;)
				// Tenant tenant = null;
				
				// TODO
				if (!setRouterId(t))
					continue;

				User user = virtualLabsDB.getUser(t.getUsername());						
				DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"the user is: " + user);
				
				VEInstance veIns = veSchDB.getVEInstance(t.getVeInsId());
				Tenant tenant = veSchDB.getTenantByVeInsId(veIns.getId());
				KServer kserver = veSchDB.getKServer(veIns.getKserverId());
				// SMS: 2013-05-04
				// No more on-premise Kaseya server. We will be using only saas servers.
				// TODO
				// Backup plan! While trying to move to the Kaseya Cloud, we still
				// need to take certificate tests over the on-premise solution.
				// KaseyaWSClient kaseyaWSClient = KaseyaWSClient.instance("kaseya2.cis.fiu.edu", 80);
				// KaseyaWSClient kaseyaWSClient = KaseyaWSClient.instance(kserver.getName(), kserver.getHttpPort());
				
				String resourceType = virtualLabsDB.getResourceTypeFromVeInsId(t.getVeInsId());
				// kserver2 is gone!
				// SMS: Enabling certification test for SD on saas12. 7/22/2012
				// String promoCodeTemp = virtualLabsDB.getPromoCode(veIns.getId());
				// if (resourceType.equals("CERTIFICATE") && (promoCodeTemp.equals("ITS-FW") || promoCodeTemp.equals("FIU-SP12"))) {
				if (resourceType.equals("CERTIFICATE")) {

					// SMS: 2013-05-04
					// No more on-premise Kaseya server. We will be using only saas servers.
					// SMS: Enabling certification test for SD on saas12. 7/22/2012
					if (tenant != null) {
					// if ((tenant != null) && (resourceType.equals("CERTIFICATE"))) {
						
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
								"Refreshing user.getUserName() + -ct: " + user.getUserName() + "-ct" +
								" and user.getPassword(): " + user.getPassword());
						refreshStoppedVE(t);
						AddInitialTasks4NewVMsRequest req = new AddInitialTasks4NewVMsRequest();
						req.setDevaInsId(t.getVeInsId());
						AddInitialTasks4NewVMsResponse resp = null;
						try { resp = vLabsStub.addInitialTasks4NewVMs(req); }
						catch(Exception e) { e.printStackTrace(); }
						if (!resp.getSuccess()) {
							DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
								"Error! The inital tasks for new VMs could not be added!");
							Exception e =
								new Exception(
										"Error! The inital tasks for new VMs could not be added!");
							e.printStackTrace();
						} 

						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
								"Deleting the tenant: " + user.getUserName() + "-ct" +
								" and user.getPassword(): " + user.getPassword());
						// Delete the user account on the Kaseya server
						String promoCode = virtualLabsDB.getPromoCode(veIns.getId());
						KaseyaWSClient kaseyaWSClientTemp = 
							KaseyaWSClient.instance(
									kserver.getName(), 
									80, 
									tenant.getUsername(), 
									tenant.getPassword(),
									"SHA-256",
									"System",
									"System",
									promoCode);
						String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
						if (!kaseyaWSClientTemp.deleteAdmin(veInsUsername, user.getPassword())) {
							String errMsg = "Error! " +
									"The admin " + veInsUsername + 
									" could not be deleted from the Kaseya server " + kserver.getName();
							DebugTools.println(DEBUG_LEVEL, "[VEScheduler - delKaseyaAccount] " + errMsg);
							Exception e =
								new Exception(errMsg);
							e.printStackTrace();
						}

						veSchDB.disableTenant(veIns.getId());
						
						tenant = null;
					}
				}

				// SMS: 2014-04-09
				// This code was moved up here in an attempt to speed up the start process 
				// by first provisioning the vms and then creating the tenant, if need be.
				Host host = startVE(t);
				
				if (origVeIns.getStatus() == VEInsStatusType.NOT_PROVISIONED) {

					veSchDB.setVMInsStatusByVeInsId(t.getVeInsId(), VMInsStatusType.PROVISIONING_AND_STARTING);
					veSchDB.setVEInsStatus(t.getVeInsId(), VEInsStatusType.PROVISIONING_AND_STARTING);

				} else {

					veSchDB.setVMInsStatusByVeInsId(t.getVeInsId(), VMInsStatusType.STARTING);
					veSchDB.setVEInsStatus(t.getVeInsId(), VEInsStatusType.STARTING);

				}

				// Check if this is the first time this ve ins scheduled on this host.
				VEInsHost veInsHost = veSchDB.getVEInsHost(t.getVeInsId(),t.getHostId());
				if (veInsHost == null) {

					// If this is the first time, then add a record to indicate the
					// ve ins has been scheduled on this host to be used for the future.
					// This will help with the register action for future schedules
					// of this ve ins.
					veInsHost = 
						new VEInsHost(
								t.getVeInsId(),
								t.getHostId());
					veSchDB.addVEInsHost(veInsHost);

				}

				if (tenant == null) {

					// String promoCode = "ITS-FW"; // This one is for IT Scholar's Kaseya Fundamentals Workshop
					// String promoCode = "FIU-SP12"; // This one is for CIS 4431 Spring 2012
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"veInsId: " + t.getVeInsId());
					String promoCode = virtualLabsDB.getPromoCode(t.getVeInsId());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"promoCode: " + promoCode);

					Random randomGenerator = new Random();
					randomGenerator.setSeed(Calendar.getInstance().getTimeInMillis());
					int counter = 0;
					// SMS: 4/29/2014 
					// Fixing the bleeding issue regarding more than one thread trying to create tenants.
					while ((tenant = veSchDB.addTempTenant(veIns.getId(), promoCode)) == null) {
						counter++;
						try {
							int randomDelay = randomGenerator.nextInt(5000);
							DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
									"\n\t============================================================================" +
									"\n\tCounter is " + counter + "!" +
									"\tSleeping for " + randomDelay + " miliseconds for another tenant to be created before this one is requested!"
									);
							Thread.sleep(randomDelay);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					};
					/*
					do {
						counter++;
						try {
							int randomDelay = randomGenerator.nextInt(5000);
							DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
									"\n\t============================================================================" +
									"\n\tSleeping for " + randomDelay + " miliseconds for another tenant to be created before this one is requested!" +
									"\n\tCounter is " + counter);
							Thread.sleep(randomDelay);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} while (veSchDB.isAnotherTenantBeingCreated());
					*/

					// SMS: 4/29/2014 
					// Fixing the bleeding issue regarding more than one thread trying to create tenants.
					// tenant = veSchDB.addTempTenant(veIns.getId(), promoCode);
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"Temp tenant was just added: " + tenant.toString());

					if (counter > 1) {
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
								"\n\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
								"\n\tCounter is " + counter + "!" +
								"\tSleeping for another " + 5000 + " miliseconds as there was just one tenant created!"
								);

						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());

					// TODO
					KaseyaTenant kaseyaTenant = KaseyaTenant.instance(null);
					int serviceID = kaseyaTenant.validatePromoCode(promoCode);
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"The serviceID is " + serviceID + " for the promoCode of " + promoCode);
					boolean tenantWasSuccessfullyCreated = false;
					// String orgName = "FIU-" + user.getUserName() + "-myOrg";
					// SMS: Added to support 7.0 on eFront
					String orgName = "";
					if (promoCode.equals("KU-7") || promoCode.equals("KU-7-1D")) {
						orgName = "ITTC-" + veInsUsername;
					} else {
						orgName = "FIU-" + veInsUsername + "-myOrg";
					}
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"orgName is " + orgName + " for the promoCode of " + promoCode);
					// String orgName = "FIU-" + veInsUsername + "-myOrg";
					// End addition
					if (serviceID != -1) {
						String customerName = user.getFirstName() + " " + user.getLastName();

						String state = "State";
						String zipCode = "State";
						String country = "Country";
						String phone = "305-XXX-XXXX";
						// String email = user.getEmailAddress();
						String email = tenant.getUsername();
						String password = user.getPassword();
						// Changed by Masoud Sadjadi on Jan. 21, 2015
						// To support no plaintext password
						if (virtualLabsDB.isNoPlainTextPasswordInEffect4ThisUser(user.getUserName())) {
							DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
									"isNoPlainTextPasswordInEffect4ThisUser(" + user.getUserName() + ") is true!");
							password = kserver.getPassword();

						} else {
							DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
									"isNoPlainTextPasswordInEffect4ThisUser(" + user.getUserName() + ") is false!");
						}
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
								"the password for the tenant to be created will be " + password);
						// String encPassword = "encPassword";
						String language = "en-US";
						AccountType accountType = AccountType.Tenant;
						TrialType trialType = TrialType._TrialMSP;

						TrialRequest tenantAccountReq = new TrialRequest();
						tenantAccountReq.setAccType(accountType);
						// tenantAccountReq.setBackupMembership(true);
						tenantAccountReq.setCountry(country);
						tenantAccountReq.setCustomerName(customerName);
						tenantAccountReq.setEmail(email);
						// tenantAccountReq.setEncPwd(encPassword);
						tenantAccountReq.setLanguage(language);
						tenantAccountReq.setOrganizationName(orgName);
						tenantAccountReq.setPhoneNumber(phone);
						tenantAccountReq.setPromoCode(promoCode);
						tenantAccountReq.setPwd(password);
						// tenantAccountReq.setSecurityMembership(true);
						tenantAccountReq.setState(state);
						tenantAccountReq.setTrial(trialType);
						int trialID = serviceID;
						tenantAccountReq.setTrialID(trialID);
						tenantAccountReq.setUserStateMembership(true);
						tenantAccountReq.setZipCode(zipCode);

						try {
							TenantAccount tenantAccount = kaseyaTenant.creatAccount(tenantAccountReq);
							if (tenantAccount != null) {
								DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
								"Kaseya tenant account was created successfully!");
								tenant.setAccountID(tenantAccount.getAccountID());
								tenant.setAdmins(tenantAccount.getAdmins());
								tenant.setAgents(tenantAccount.getAgents());
								tenant.setCustomerID(tenantAccount.getCustomerID());
								tenant.setEndDate(tenantAccount.getEndDate());
								tenant.setGroup(tenantAccount.getGroup());
								// SMS: Feb. 26, 2015
								// Making sure that the password is set properly
								// whether the no plain text password is enabled for this account or not.
								// tenant.setPassword(tenantAccount.getPassword());
								tenant.setPassword(password);
								tenant.setUrl(tenantAccount.getUrl());
								tenant.setUsername(tenantAccount.getUsername());
								tenant.setKserverId(kserver.getId());
								DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
										tenant.toString());
								// veSchDB.updateTenant(tenant);

								int maxAttempt = 12;
								int delayCounter = 0;
								do {
									delayCounter++;
									try {
										int delay = 10000;
										DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
												"\n\t============================================================================" +
												"\n\tCounter is " + delayCounter + " and maximum number of attempts is set to " + maxAttempt + "!" +
												"\tSleeping for " + delay/1000 + " seconds for the tenant " + tenant.getUsername() + " to be created!"
												);
										Thread.sleep(delay);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} while ((!veSchDB.isTenantCreated(tenant.getUsername())) && (delayCounter < maxAttempt));
								if (veSchDB.isTenantCreated(tenant.getUsername())) {
									tenantWasSuccessfullyCreated = true;
									DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
									"Kaseya tenant account was created!");
								} else {
									// Added by Masoud Sadjadi on Nov. 5, 2014. 
									// Let's assume that the tenant was successfully create! ;)
									tenantWasSuccessfullyCreated = true;
									DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
									"We do NOT know whether the Kaseya tenant account was created successfully or not, "
									+ "but let's assume that it was! ;)");
									veSchDB.addTenantCreated(tenant.getUsername());
								}
							} else {
								DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
								"Kaseya tenant account was NOT created!");
							}
						} catch (Exception e) {

							e.printStackTrace();

						}
					}
					
					if (tenantWasSuccessfullyCreated) {
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"Kaseya tenant account was created successfully ...");
					} else {
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"Kaseya tenant account was NOT created! Giving up on this tenant ...");
						String customerName = user.getFirstName() + " " + user.getLastName();
						tenant.setAccountID(customerName);
						tenant.setAdmins(-1);
						tenant.setAgents(-1);
						tenant.setCustomerID(new BigDecimal(-1));
						tenant.setEndDate(Calendar.getInstance());
						tenant.setGroup(orgName);
						tenant.setPassword("ruined");
						tenant.setUrl(kserver.getName());
						// tenant.setUsername();
						tenant.setKserverId(kserver.getId());
						veSchDB.updateTenant(tenant);
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
						"Kaseya tenant was set as ruined ...");
						tenant = null;
					}
					// kserver2 is gone!
					/*
					String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());

					// veSchDB.setVEInsStatus(t.getVeInsId(), VEInsStatusType.RUNNING);
					// if (!kaseyaWSClient.enableAdmin(user.getUserName(), user.getPassword())) {
					if (!kaseyaWSClient.enableAdmin(veInsUsername, user.getPassword())) {

						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"Warning! The admin in Kaseya could not be enabled! " +
							"This maybe because this is the first time a virtual lab is being scheuduled by " +
							"or mabybe the user account was created before 5/15/2011, " +
							"which was the day multiple Kaseya servers were introduced to the system.");

						if (!kaseyaWSClient.createAdmin(
								// user.getUserName(),
								veInsUsername,
								user.getPassword(),
								user.getEmailAddress(),
								user.getFirstName(),
								user.getLastName())) {
							
						} else {
							DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"Error! The admin in Kaseya could not be enable nor created!");
							Exception e =
								new Exception(
								"Error! The admin in Kaseya could not be enabled nor created!");
							e.printStackTrace();
						}
					} 
					*/
				}

				// SMS: 2014-04-09
				// Trying to speed up the start process by first provisioning the vms 
				// and then creating the tenant, if need be.
				/*
				Host host = startVE(t);
				
				if (origVeIns.getStatus() == VEInsStatusType.NOT_PROVISIONED) {

					veSchDB.setVMInsStatusByVeInsId(t.getVeInsId(), VMInsStatusType.PROVISIONING_AND_STARTING);
					veSchDB.setVEInsStatus(t.getVeInsId(), VEInsStatusType.PROVISIONING_AND_STARTING);

				} else {

					veSchDB.setVMInsStatusByVeInsId(t.getVeInsId(), VMInsStatusType.STARTING);
					veSchDB.setVEInsStatus(t.getVeInsId(), VEInsStatusType.STARTING);

				}

				// Check if this is the first time this ve ins scheduled on this host.
				VEInsHost veInsHost = veSchDB.getVEInsHost(t.getVeInsId(),t.getHostId());
				if (veInsHost == null) {

					// If this is the first time, then add a record to indicate the
					// ve ins has been scheduled on this host to be used for the future.
					// This will help with the register action for future schedules
					// of this ve ins.
					veInsHost = 
						new VEInsHost(
								t.getVeInsId(),
								t.getHostId());
					veSchDB.addVEInsHost(veInsHost);

				}
*/				
				if (tenant != null) {
				
					// tenant = veSchDB.getTenantByVeInsId(tenant.getVeInsId());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"tenant: " + tenant.toString());
					
					KServer ks = veSchDB.getKServer(tenant.getKserverId());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"tenant: " + tenant.toString());
					
					String promoCode = virtualLabsDB.getPromoCode(tenant.getVeInsId());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"ks.getName(): " + ks.getName());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"tenant.getUsername(): " + tenant.getUsername());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"tenant.getPassword(): " + tenant.getPassword());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"ks.getName(): " + ks.getName());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"ks.getName(): " + ks.getName());
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"promoCode: " + promoCode);
					KaseyaWSClient saas = 
						KaseyaWSClient.instance(
								ks.getName(), 
								80, 
								tenant.getUsername(), 
								tenant.getPassword(),
								"SHA-256",
								"System",
								"System",
								promoCode);
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
							"saas.getSysUsername(): " + saas.getSysUsername() + " " +
							"saas.getSysPassword(): " + saas.getSysPassword());

					String veInsUsername = virtualLabsDB.getVeInsUsernameByVeInsId(veIns.getId());
					
					// if (!saas.enableAdmin(user.getUserName(), user.getPassword())) {
					if (!saas.enableAdmin(veInsUsername, user.getPassword())) {

						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"Warning! The admin in Kaseya could not be enabled! " +
							"This maybe because this is the first time a virtual lab is being scheuduled by " +
							"or mabybe the user account was created before 5/15/2011, " +
							"which was the day multiple Kaseya servers were introduced to the system.");

						
						int delay = 2000;
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +	
								"sleeping for " + delay/1000 + " second to avoid overwhelming the kserver!");
						try {
							Thread.sleep(delay);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if (!saas.createAdmin(
								// user.getUserName(),
								veInsUsername,
								user.getPassword(),
								user.getEmailAddress(),
								user.getFirstName(),
								user.getLastName())) {
							
						} else {
							DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - executeTasks] " +
							"Error! The admin in Kaseya could not be enable nor created!");
							Exception e =
								new Exception(
								"Error! The admin in Kaseya could not be enabled nor created!");
							e.printStackTrace();
						}
					} 
				}

				if (tenant != null)
					veSchDB.updateTenant(tenant);
			}
		}
	}

	public synchronized void notifyThread() {
		
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - notifyThread] Inside! " +
				"waiting: " + waiting);
		
		if (waiting) {
			notify();
			DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - notifyThread] notified! ");
		}

		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent4Host - hostId " + this.hostId + " - notifyThread] Ready to get out!");
		
	}
	
	public boolean isWaiting() {
		return waiting;
	}
	
	public void setRunning(boolean running) {
		
		this.running = running;
	
	}
}
