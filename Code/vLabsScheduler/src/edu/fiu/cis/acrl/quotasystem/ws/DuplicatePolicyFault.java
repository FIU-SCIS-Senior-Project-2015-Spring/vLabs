
/**
 * DuplicatePolicyFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package edu.fiu.cis.acrl.quotasystem.ws;

public class DuplicatePolicyFault extends java.lang.Exception{
    
    private edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError faultMessage;

    
        public DuplicatePolicyFault() {
            super("DuplicatePolicyFault");
        }

        public DuplicatePolicyFault(java.lang.String s) {
           super(s);
        }

        public DuplicatePolicyFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public DuplicatePolicyFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError msg){
       faultMessage = msg;
    }
    
    public edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError getFaultMessage(){
       return faultMessage;
    }
}
    