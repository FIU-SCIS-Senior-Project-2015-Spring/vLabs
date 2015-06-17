package edu.fiu.cis.acrl.vescheduler.server.tools;

import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private int debugLevel;
  
    /**
     * Read settings from configuration file
     */
    private Settings(String configFile) throws SettingsException {

		Properties settings = new Properties();
		
		// try to find the configuration file
		try {
		    InputStream is = this.getClass().getClassLoader().getResourceAsStream(configFile);
		    settings.load(is);
		} catch (Exception e) {
		    throw new SettingsException("Could not find " + configFile + " file");
		}
	
		debugLevel = Integer.valueOf(settings.getProperty("debug_level")).intValue();

    }

	/**
	 * A handle to the unique Singleton instance.
	 */
	static private Settings _instance = null;
	
	/**
	 * @return The unique instance of this class.
	 */
	static public Settings instance() {
		
		if(null == _instance) {
		
			try {
				
				_instance = new Settings("vescheduler.conf");
			
			}
			catch (Exception e) {
				
				e.printStackTrace();
				
			}
				
		}
	    
		return _instance;
	   
	}

    public int getDebugLevel() { return debugLevel; }
    
    public String toString() {
    	
    	return 
    		"debugLevel: " + getDebugLevel();
    	
    }
}
