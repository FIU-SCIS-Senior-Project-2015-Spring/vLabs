package edu.fiu.cis.acrl.tools.debug;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.fiu.cis.acrl.quotasystem.server.QuotaSystemSettings;

public class DebugTools {

	static public void println(int debugLevel, String message) {
		
		if (QuotaSystemSettings.instance().getDebugLevel() >= debugLevel) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			System.out.println("[T: " + Thread.currentThread().getId() + " D: " + debugLevel + " at: " + sdf.format(Calendar.getInstance().getTime()) + "] " + message);
		}
	}
}
