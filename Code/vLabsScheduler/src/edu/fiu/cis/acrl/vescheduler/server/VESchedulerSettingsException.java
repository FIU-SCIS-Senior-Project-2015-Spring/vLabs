package edu.fiu.cis.acrl.vescheduler.server;

public class VESchedulerSettingsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VESchedulerSettingsException(String msg) {
    	
    	super(msg);
        
    }
        
    public VESchedulerSettingsException(String key, String value) {
    	
    	this(key, value, null);
       
    }
        
    public VESchedulerSettingsException(String key, String value, String expected) {
    	
    	super(key + " has incorrect value: " + value + ". " + (expected != null ? 
    			("Expected: " + expected) : ""));
    
    }

}
