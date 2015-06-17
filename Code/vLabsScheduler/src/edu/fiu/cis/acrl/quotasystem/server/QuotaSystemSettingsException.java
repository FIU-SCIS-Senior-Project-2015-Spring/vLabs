package edu.fiu.cis.acrl.quotasystem.server;

public class QuotaSystemSettingsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuotaSystemSettingsException(String msg) {
    	
    	super(msg);
        
    }
        
    public QuotaSystemSettingsException(String key, String value) {
    	
    	this(key, value, null);
       
    }
        
    public QuotaSystemSettingsException(String key, String value, String expected) {
    	
    	super(key + " has incorrect value: " + value + ". " + (expected != null ? 
    			("Expected: " + expected) : ""));
    
    }

}
