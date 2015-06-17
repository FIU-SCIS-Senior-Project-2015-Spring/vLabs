
/**
 * PolicyNotFoundFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package edu.fiu.cis.acrl.quotasystem.ws;

public class PolicyNotFoundFault extends java.lang.Exception{
    
    private edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError faultMessage;

    
        public PolicyNotFoundFault() {
            super("PolicyNotFoundFault");
        }

        public PolicyNotFoundFault(java.lang.String s) {
           super(s);
        }

        public PolicyNotFoundFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public PolicyNotFoundFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError msg){
       faultMessage = msg;
    }
    
    public edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError getFaultMessage(){
       return faultMessage;
    }
}
    