package edu.fiu.cis.acrl.kaseya.tools;

import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private String kaseyaWSEPR;
    
    private String kaseyaHostAddress;
    private String kaseyaMasterUsername;
    private String kaseyaMasterPassword;
 
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
		
		} 
		catch (Exception e) {
		
			throw new SettingsException("Could not find " + configFile + " file");
		
		}
	
		this.kaseyaWSEPR = settings.getProperty("kaseya_ws_epr");
		
		this.kaseyaHostAddress = settings.getProperty("kaseya_host_address");
		this.kaseyaMasterUsername = settings.getProperty("kaseya_master_username");
		this.kaseyaMasterPassword = settings.getProperty("kaseya_master_password");
		
		this.debugLevel = Integer.valueOf(settings.getProperty("debug_level")).intValue();

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
				
				_instance = new Settings("kaseyawsclient.conf");
			
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

	public void setKaseyaHostAddress(String kaseyaHostAddress) {
		this.kaseyaHostAddress = kaseyaHostAddress;
	}

	public String getKaseyaHostAddress() {
		return kaseyaHostAddress;
	}

	public void setKaseyaMasterUsername(String kaseyaMasterUsername) {
		this.kaseyaMasterUsername = kaseyaMasterUsername;
	}

	public String getKaseyaMasterUsername() {
		return kaseyaMasterUsername;
	}

	public void setKaseyaMasterPassword(String kaseyaMasterPassword) {
		this.kaseyaMasterPassword = kaseyaMasterPassword;
	}

	public String getKaseyaMasterPassword() {
		return kaseyaMasterPassword;
	}

	public void setKaseyaWSEPR(String kaseyaWSEPR) {
		this.kaseyaWSEPR = kaseyaWSEPR;
	}

	public String getKaseyaWSEPR() {
		return kaseyaWSEPR;
	}
}
