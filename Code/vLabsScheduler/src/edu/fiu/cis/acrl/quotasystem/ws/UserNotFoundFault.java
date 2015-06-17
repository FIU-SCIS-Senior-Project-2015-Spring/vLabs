
/**
 * UserNotFoundFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package edu.fiu.cis.acrl.quotasystem.ws;

public class UserNotFoundFault extends java.lang.Exception{
    
    private edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError faultMessage;

    
        public UserNotFoundFault() {
            super("UserNotFoundFault");
        }

        public UserNotFoundFault(java.lang.String s) {
           super(s);
        }

        public UserNotFoundFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public UserNotFoundFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError msg){
       faultMessage = msg;
    }
    
    public edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError getFaultMessage(){
       return faultMessage;
    }
}
    