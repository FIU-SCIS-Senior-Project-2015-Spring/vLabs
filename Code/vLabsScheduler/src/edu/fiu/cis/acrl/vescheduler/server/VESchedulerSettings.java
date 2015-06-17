package edu.fiu.cis.acrl.vescheduler.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class VESchedulerSettings {

	// VirtualLabs settings
	private String vLabsEPR;
	
    // database settings
    private String dbUser;
    private String dbPassword;
    private String dbHost;
    private String dbName;
    private int debugLevel;
  
    // public static final int DEFAULT_PERIOD = 1800;
    public static final int DEFAULT_PERIOD = 60;
    
    public static String configFile = null;

    private boolean enabled;
    private int period;

    /**
     * Read settings from configuration file
     */
    private VESchedulerSettings(String configFile) throws VESchedulerSettingsException {

		Properties settings = new Properties();
		
		// try to find the configuration file
		try {
			
			File fileIn  = new File(configFile);
			
			FileInputStream is = new FileInputStream(fileIn);
		    settings.load(is);
		    
			     /*
		    InputStream is = 
		    	this.getClass().getClassLoader().getResourceAsStream(configFile);
		    settings.load(is);
			*/
		    
		} catch (Exception e) {
		
			e.printStackTrace();
			throw new VESchedulerSettingsException("Could not find " + configFile + " file");
		
		}
	
		vLabsEPR = settings.getProperty("vlabs_epr");
		
		dbUser = settings.getProperty("exams_db_user");
		dbPassword = settings.getProperty("exams_db_password");
		dbHost = settings.getProperty("exams_db_host");
		dbName = settings.getProperty("exams_db_name");
		debugLevel = Integer.valueOf(settings.getProperty("debug_level")).intValue();
		enabled = Boolean.valueOf(settings.getProperty("enable_scheduler"));
		period = DEFAULT_PERIOD;
		try {
		
			period = Integer.valueOf(settings.getProperty("scheduler_period"));
		
		}
		catch(Exception e) {
		
			System.err.println("Incorrect period in configuration file. Set to default: " + DEFAULT_PERIOD); 

		}

    }

	/**
	 * A handle to the unique Singleton instance.
	 */
	static private VESchedulerSettings _instance = null;
	
	/**
	 * @return The unique instance of this class.
	 */
	static public VESchedulerSettings instance() {
		
		if(null == _instance) {
		
			try {
	
				if (configFile == null)
					configFile = "vescheduler.conf";
				_instance = new VESchedulerSettings(configFile);
			
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
    public boolean isSchedulerEnabled() { return enabled; }
    public int getPeriod() { return period; }
	public String getVLabsEPR() { return vLabsEPR; }
    
}
