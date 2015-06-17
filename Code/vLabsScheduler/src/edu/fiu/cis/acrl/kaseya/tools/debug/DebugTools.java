package edu.fiu.cis.acrl.kaseya.tools.debug;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.fiu.cis.acrl.kaseya.tools.Settings;

public class DebugTools {

	static public void println(int debugLevel, String message) {
		
		if (Settings.instance().getDebugLevel() >= debugLevel) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			System.out.println("[T: " + Thread.currentThread().getId() + " D: " + debugLevel + " at: " + sdf.format(Calendar.getInstance().getTime()) + "] " + message);
		}
	}
}
