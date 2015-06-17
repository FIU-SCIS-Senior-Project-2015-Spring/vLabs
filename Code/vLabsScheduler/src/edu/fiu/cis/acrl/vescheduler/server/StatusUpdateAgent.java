package edu.fiu.cis.acrl.vescheduler.server;

import java.util.Calendar;
import java.util.Collection;

import edu.fiu.cis.acrl.vescheduler.server.Host;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance;
import edu.fiu.cis.acrl.vescheduler.server.VEInstanceSchedule;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance.VEInsStatusType;
import edu.fiu.cis.acrl.vescheduler.server.db.VESchedulerDB;
import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;

/**
 * This class wakes up periodically and starts/stops the VEs in the queue
 *
 */
public class StatusUpdateAgent implements Runnable {

	private VESchedulerDB veSchDB;
	private int updateInterval;
	
	private boolean running;
	
	/**
	 * Create the agent 
	 */
	public StatusUpdateAgent() {

		veSchDB= VESchedulerDB.instance();
		running = false;
		// this is the interval that this thread wakes up to check 
		// if there is anything needed to be updated.
		// TODO This was annoying, so for now I have put it at 1 hour frequency.
		updateInterval = 10000; // 10 seconds
		
	}

	public void run() {

		running = true;

		while(running) {

			// TODO 
			// This is not optimized and does not scale. 
			// It needs update only those instances that has changed.
			veSchDB.updateVEInstancesStatus();

			try {
				
				Thread.sleep(updateInterval);
			
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			
			}
			
		}

	}


	public void setRunning(boolean running) {
		
		this.running = running;
	
	}

}
