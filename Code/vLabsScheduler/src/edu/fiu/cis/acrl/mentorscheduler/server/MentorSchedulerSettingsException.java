package edu.fiu.cis.acrl.mentorscheduler.server;

public class MentorSchedulerSettingsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MentorSchedulerSettingsException(String msg) {
    	
    	super(msg);
        
    }
        
    public MentorSchedulerSettingsException(String key, String value) {
    	
    	this(key, value, null);
       
    }
        
    public MentorSchedulerSettingsException(String key, String value, String expected) {
    	
    	super(key + " has incorrect value: " + value + ". " + (expected != null ? 
    			("Expected: " + expected) : ""));
    
    }

}
