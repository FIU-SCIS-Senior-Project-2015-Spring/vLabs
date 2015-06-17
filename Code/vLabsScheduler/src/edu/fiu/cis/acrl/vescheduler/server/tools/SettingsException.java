package edu.fiu.cis.acrl.vescheduler.server.tools;

public class SettingsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SettingsException(String msg) {
    	
    	super(msg);
        
    }
        
    public SettingsException(String key, String value) {
    	
    	this(key, value, null);
       
    }
        
    public SettingsException(String key, String value, String expected) {
    	
    	super(key + " has incorrect value: " + value + ". " + (expected != null ? 
    			("Expected: " + expected) : ""));
    
    }

}
