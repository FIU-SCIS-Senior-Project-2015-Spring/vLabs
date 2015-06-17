
/**
 * CourseNotFoundFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package edu.fiu.cis.acrl.quotasystem.ws;

public class CourseNotFoundFault extends java.lang.Exception{
    
    private edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError faultMessage;

    
        public CourseNotFoundFault() {
            super("CourseNotFoundFault");
        }

        public CourseNotFoundFault(java.lang.String s) {
           super(s);
        }

        public CourseNotFoundFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CourseNotFoundFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError msg){
       faultMessage = msg;
    }
    
    public edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError getFaultMessage(){
       return faultMessage;
    }
}
    