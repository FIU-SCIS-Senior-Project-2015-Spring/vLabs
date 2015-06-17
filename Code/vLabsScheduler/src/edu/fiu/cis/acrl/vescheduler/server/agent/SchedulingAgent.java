package edu.fiu.cis.acrl.vescheduler.server.agent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import com.sun.tools.javac.util.List;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

import edu.fiu.cis.acrl.kaseya.client.KaseyaWSClient;
import edu.fiu.cis.acrl.vescheduler.server.Host;
import edu.fiu.cis.acrl.vescheduler.server.VEInsHost;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance;
import edu.fiu.cis.acrl.vescheduler.server.VEInstanceSchedule;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance.VEInsStatusType;
import edu.fiu.cis.acrl.vescheduler.server.VMInstance.VMInsStatusType;
import edu.fiu.cis.acrl.vescheduler.server.WrongCommandStatuCombinationException;
import edu.fiu.cis.acrl.vescheduler.server.db.VESchedulerDB;
import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;

/**
 * This class wakes up periodically and starts/stops the VEs in the queue
 *
 */
public class SchedulingAgent implements Runnable {

	// Debug level for this class
	private static int DEBUG_LEVEL = 4;
	
	private VESchedulerDB veSchDB;
	private int schedulingPeriod;	
	private Calendar nextTaskTime;

    private boolean running;
    
    private boolean firstTime = true;
    private Calendar prevTime;
    
    private SortedMap hostThreads;
	
	/**
	 * Create the agent 
	 * 
	 */
	public SchedulingAgent() {

		veSchDB= VESchedulerDB.instance();
		running = false;
		// this is the interval that this thread wakes up to check if there is anything 
		// there to schedule.
		schedulingPeriod = 1000; // 1 second
		// making sure that the next task time is set to a very far time
		// if there is nothing to be scheduled in the database.
		nextTaskTime = Calendar.getInstance();
		nextTaskTime.add(Calendar.YEAR, 10);
		setNextTaskTime();
		hostThreads = new TreeMap();
	}

	@SuppressWarnings("unchecked")
	public void run() {

		running = true;

		while(running) {

			if (Calendar.getInstance().after(nextTaskTime)) {

				DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent - run] " +
						"nextTaskTime: " + nextTaskTime.getTime());
				DebugTools.println(
						3,
						"[SchedulingAgent - run] >> SchedulingAgent execution: " + 
						Calendar.getInstance().getTime());

				Calendar now = Calendar.getInstance();
				// select the tasks with type='STOP' and start_time in the past
				ArrayList<Integer> taskHostList = veSchDB.getTaskHostList();

				for (int i=0; i< taskHostList.size(); i++) {
					Object key = taskHostList.get(i);
					DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent - run] " +
							"host with task: " + ((Integer) key).intValue());
					if (hostThreads.get(key) == null) {
						Object value = new SchedulingAgent4Host(((Integer) key).intValue());
						hostThreads.put(key, value);
						SchedulingAgent4Host hostThread = (SchedulingAgent4Host) value;
						hostThread.start();
					} else {
						SchedulingAgent4Host hostThread = 
							(SchedulingAgent4Host) hostThreads.get(key);

						boolean waiting = hostThread.isWaiting(); 
						DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent - run] " +
								"host " + ((Integer) key).intValue() + "  " +
								"waiting is " + waiting);
						if (waiting)
							hostThread.notifyThread();					
					}
				}
				
				setNextTaskTime();				
			}

			// Calculate how many seconds to wait until the next scheduling period
			Calendar c = Calendar.getInstance();
			long t = c.getTime().getTime();

			int offset = (int)(t % schedulingPeriod);

			int wait = schedulingPeriod - offset;

			DebugTools.println(DEBUG_LEVEL, "[SchdulingAgent - run] t: " + t + 
					", offset: " + offset + 
					", wait: " + wait);

			try {
				Thread.sleep(wait);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setRunning(boolean running) {
		
		this.running = running;
	
	}

	public void setNextTaskTime() {

	    Calendar tempNextTaskTime = veSchDB.getNextTaskTime();
	    if (tempNextTaskTime != null) {
	    	this.nextTaskTime = tempNextTaskTime;
	    } else {
	    	this.nextTaskTime = Calendar.getInstance();
	    	this.nextTaskTime.add(Calendar.YEAR, 10);
	    }
	 
	    Calendar now = Calendar.getInstance();
	    if (nextTaskTime.before(now)) {
	    	nextTaskTime = now;
	    	nextTaskTime.add(Calendar.SECOND, 10);
	    }
	    
		DebugTools.println(DEBUG_LEVEL, "[SchedulingAgent - setNextTaskTime] " +
				"nextTaskTime: " + nextTaskTime.getTime());
		
	}
}
