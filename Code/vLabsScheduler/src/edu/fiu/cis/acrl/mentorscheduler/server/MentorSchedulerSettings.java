package edu.fiu.cis.acrl.mentorscheduler.server;

import java.io.InputStream;
import java.util.Properties;

public class MentorSchedulerSettings {

    // database settings
    private String dbUser;
    private String dbPassword;
    private String dbHost;
    private String dbName;
    private int debugLevel;
  
    /**
     * Read settings from configuration file
     */
    private MentorSchedulerSettings(String configFile) throws MentorSchedulerSettingsException {

		Properties settings = new Properties();
		
		// try to find the configuration file
		try {
		    InputStream is = this.getClass().getClassLoader().getResourceAsStream(configFile);
		    settings.load(is);
		} catch (Exception e) {
		    throw new MentorSchedulerSettingsException("Could not find " + configFile + " file");
		}
	
		dbUser = settings.getProperty("exams_db_user");
		dbPassword = settings.getProperty("exams_db_password");
		dbHost = settings.getProperty("exams_db_host");
		dbName = settings.getProperty("exams_db_name");
		debugLevel = Integer.valueOf(settings.getProperty("debug_level")).intValue();

    }

	/**
	 * A handle to the unique Singleton instance.
	 */
	static private MentorSchedulerSettings _instance = null;
	
	/**
	 * @return The unique instance of this class.
	 */
	static public MentorSchedulerSettings instance() {
		
		if(null == _instance) {
		
			try {
				
				_instance = new MentorSchedulerSettings("mentorscheduler.conf");
			
			}
			catch (Exception e) {
				
				e.printStackTrace();
				
			}
				
		}
	    
		return _instance;
	   
	}

    // database settings
    public String getDbUser() { return dbUser; }
    public String getDbPassword() { return dbPassword; }
    public String getDbHost() { return dbHost; }
    public String getDbName() { return dbName; }
    public int getDebugLevel() { return debugLevel; }
    
    public String toString() {
    	
    	return 
    		"dbUser: " + getDbUser() +  " " +
    		"dbPassword: "  + getDbPassword() + " " +
    		"dbHost: " + getDbHost() + " " + 
    		"dbName: " + getDbName() + " " +
    		"debugLevel: " + getDebugLevel();
    	
    }
}
