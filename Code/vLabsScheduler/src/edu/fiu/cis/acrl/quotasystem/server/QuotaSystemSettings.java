package edu.fiu.cis.acrl.quotasystem.server;

import java.util.Properties;
import java.io.InputStream;


public class QuotaSystemSettings {

	// VirtualLabs settings
	private String virtualLabsEPR;
	
    // database settings
    private String dbUser;
    private String dbPassword;
    private String dbHost;
    private String dbName;
    private int debugLevel;
  
    /**
     * Read settings from configuration file
     */
    private QuotaSystemSettings(String configFile) throws QuotaSystemSettingsException {

		Properties settings = new Properties();
		
		// try to find the configuration file
		try {
		    InputStream is = this.getClass().getClassLoader().getResourceAsStream(configFile);
		    settings.load(is);
		} catch (Exception e) {
		    throw new QuotaSystemSettingsException("Could not find " + configFile + " file");
		}
	
		virtualLabsEPR = settings.getProperty("virtuallabs_epr");

		dbUser = settings.getProperty("quotasystem_db_user");
		dbPassword = settings.getProperty("quotasystem_db_password");
		dbHost = settings.getProperty("quotasystem_db_host");
		dbName = settings.getProperty("quotasystem_db_name");
		debugLevel = Integer.valueOf(settings.getProperty("debug_level")).intValue();

    }

	/**
	 * A handle to the unique Singleton instance.
	 */
	static private QuotaSystemSettings _instance = null;
	
	/**
	 * @return The unique instance of this class.
	 */
	static public QuotaSystemSettings instance() {
		
		if(null == _instance) {
		
			try {
				
				_instance = new QuotaSystemSettings("quotasystem.conf");
			
			}
			catch (Exception e) {
				
				e.printStackTrace();
				
			}
				
		}
	    
		return _instance;
	   
	}

	static public QuotaSystemSettings instance(String path) {
		
		if(null == _instance) {
		
			try {
				
				_instance = new QuotaSystemSettings(path);
			
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
	public String getVirtualLabsEPR() { return virtualLabsEPR; }
    
	public String toString() {
		
		return
			"\n" +
			"virtualLabsEPR: " + virtualLabsEPR + "\n" +
			"dbUser: " + dbUser + "\n" +
			"dbPassword: " + dbPassword + "\n" + 
			"dbHost: " + dbHost + "\n" +
			"dbName: " +dbName;
	
	}

}


