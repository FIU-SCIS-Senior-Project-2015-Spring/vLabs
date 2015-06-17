package edu.fiu.cis.acrl.mentorscheduler.server.debug;

import java.util.Calendar;

import edu.fiu.cis.acrl.mentorscheduler.server.MentorSchedulerSettings;

public class DebugTools {

	static public void println(int debugLevel, String message) {
		
		if (MentorSchedulerSettings.instance().getDebugLevel() >= debugLevel) 
			System.out.println("[Debug Level " + debugLevel + " at: " + Calendar.getInstance().getTime() + "] " + message);
		
	}
}
