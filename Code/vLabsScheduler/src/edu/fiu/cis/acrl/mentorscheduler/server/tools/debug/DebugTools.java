package edu.fiu.cis.acrl.mentorscheduler.server.tools.debug;

import java.util.Calendar;

import edu.fiu.cis.acrl.mentorscheduler.server.tools.Settings;

public class DebugTools {

	static public void println(int debugLevel, String message) {
		
		if (Settings.instance().getDebugLevel() >= debugLevel) 
			System.out.println("[Debug Level " + debugLevel + " at: " + Calendar.getInstance().getTime() + "] " + message);
		
	}
}
