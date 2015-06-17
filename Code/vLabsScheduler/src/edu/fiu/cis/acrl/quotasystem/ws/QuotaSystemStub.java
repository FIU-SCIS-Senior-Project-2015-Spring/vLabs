
/**
 * QuotaSystemStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package edu.fiu.cis.acrl.quotasystem.ws;

        

        /*
        *  QuotaSystemStub java implementation
        */

        
        public class QuotaSystemStub extends org.apache.axis2.client.Stub
        {
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("QuotaSystem" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[47];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "addCreditType"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCurrentPeriodQuotaSummary"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getHistoricQuotaSummaryPerPeriods"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "deleteCreditType"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCurrentPeriodQuotaSummaryByCreditType"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCourses"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getAssignablePolicies"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[6]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "enrollUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[7]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "syncUsersAndCourses"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[8]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "modifyUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[9]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getHistoricQuotaSummaryByUserAndCreditType"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[10]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "cancelQuotaAssignments"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[11]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCreditTypeById"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[12]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "modifyPolicy"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[13]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "deleteUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[14]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "scheduleAppointments"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[15]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "deleteCourse"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[16]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getHistoricQuotaSummary"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[17]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "doesUserHaveAvailableQuota"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[18]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCreditTypesByCourse"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[19]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCurrentPeriodQuotaSummaryByUserAndCourse"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[20]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getPolicies"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[21]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "modifyCreditType"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[22]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCreditTypesByUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[23]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCurrentPeriodQuotaSummaryByUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[24]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "modifyAppointment"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[25]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getUsers"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[26]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getPolicyById"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[27]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "cancelAppointment"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[28]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCreditTypes"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[29]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getCreditTypesByPolicy"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[30]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getPolicyByCreditType"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[31]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "addPolicy"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[32]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "cancelCourseQuota"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[33]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getAssignableCreditTypes"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[34]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "modifyCourseQuota"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[35]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "assignQuota"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[36]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "unenrollUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[37]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "addCourse"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[38]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "cancelAllAppointments"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[39]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "deletePolicy"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[40]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getUsersByCourse"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[41]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "modifyCourse"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[42]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "assignQuotaToCourse"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[43]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "addUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[44]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getHistoricQuotaSummaryPerUsers"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[45]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws", "getHistoricQuotaSummaryByUser"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[46]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCreditTypeError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCreditTypeError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCreditTypeError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateUserError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateUserError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateUserError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicatePolicyError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicatePolicyError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicatePolicyError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCreditTypeError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCreditTypeError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCreditTypeError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicatePolicyError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicatePolicyError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicatePolicyError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","EnrollmentNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","EnrollmentNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","EnrollmentNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCourseError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCourseError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCourseError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","PolicyNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCourseError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCourseError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateCourseError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateUserError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateUserError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","DuplicateUserError"),"edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CreditTypeNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","InvalidDataError"),"edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","CourseNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws","UserNotFoundError"),"edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public QuotaSystemStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public QuotaSystemStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public QuotaSystemStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost:8080/axis2/services/QuotaSystem/" );
                
    }

    /**
     * Default Constructor
     */
    public QuotaSystemStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost:8080/axis2/services/QuotaSystem/" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public QuotaSystemStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#addCreditType
                     * @param addCreditTypeRequest580
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse addCreditType(

                            edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest addCreditTypeRequest580)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("addCreditType");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addCreditTypeRequest580,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addCreditType")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startaddCreditType
                    * @param addCreditTypeRequest580
                
                */
                public  void startaddCreditType(

                 edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest addCreditTypeRequest580,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("addCreditType");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addCreditTypeRequest580,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addCreditType")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultaddCreditType(
                                        (edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErroraddCreditType(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErroraddCreditType((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault){
														callback.receiveErroraddCreditType((edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErroraddCreditType(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddCreditType(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddCreditType(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddCreditType(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddCreditType(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddCreditType(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddCreditType(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddCreditType(f);
                                            }
									    } else {
										    callback.receiveErroraddCreditType(f);
									    }
									} else {
									    callback.receiveErroraddCreditType(f);
									}
								} else {
								    callback.receiveErroraddCreditType(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErroraddCreditType(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCurrentPeriodQuotaSummary
                     * @param getCurrentPeriodQuotaSummaryRequest582
                    
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse getCurrentPeriodQuotaSummary(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest getCurrentPeriodQuotaSummaryRequest582)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummary");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryRequest582,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummary")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCurrentPeriodQuotaSummary
                    * @param getCurrentPeriodQuotaSummaryRequest582
                
                */
                public  void startgetCurrentPeriodQuotaSummary(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest getCurrentPeriodQuotaSummaryRequest582,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummary");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryRequest582,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummary")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCurrentPeriodQuotaSummary(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCurrentPeriodQuotaSummary(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetCurrentPeriodQuotaSummary(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
                                            }
									    } else {
										    callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
									    }
									} else {
									    callback.receiveErrorgetCurrentPeriodQuotaSummary(f);
									}
								} else {
								    callback.receiveErrorgetCurrentPeriodQuotaSummary(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCurrentPeriodQuotaSummary(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getHistoricQuotaSummaryPerPeriods
                     * @param getHistoricQuotaSummaryPerPeriodsRequest584
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse getHistoricQuotaSummaryPerPeriods(

                            edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest getHistoricQuotaSummaryPerPeriodsRequest584)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("getHistoricQuotaSummaryPerPeriods");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryPerPeriodsRequest584,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryPerPeriods")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetHistoricQuotaSummaryPerPeriods
                    * @param getHistoricQuotaSummaryPerPeriodsRequest584
                
                */
                public  void startgetHistoricQuotaSummaryPerPeriods(

                 edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest getHistoricQuotaSummaryPerPeriodsRequest584,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
             _operationClient.getOptions().setAction("getHistoricQuotaSummaryPerPeriods");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryPerPeriodsRequest584,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryPerPeriods")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricQuotaSummaryPerPeriods(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorgetHistoricQuotaSummaryPerPeriods((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorgetHistoricQuotaSummaryPerPeriods((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorgetHistoricQuotaSummaryPerPeriods((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(f);
									}
								} else {
								    callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricQuotaSummaryPerPeriods(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[2].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[2].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#deleteCreditType
                     * @param deleteCreditTypeRequest586
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  void deleteCreditType(

                            edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest deleteCreditTypeRequest586)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("deleteCreditType");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deleteCreditTypeRequest586,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deleteCreditType")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startdeleteCreditType
                    * @param deleteCreditTypeRequest586
                
                */
                public  void startdeleteCreditType(

                 edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest deleteCreditTypeRequest586,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
             _operationClient.getOptions().setAction("deleteCreditType");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deleteCreditTypeRequest586,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deleteCreditType")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[3].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[3].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCurrentPeriodQuotaSummaryByCreditType
                     * @param getCurrentPeriodQuotaSummaryByCreditTypeRequest588
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse getCurrentPeriodQuotaSummaryByCreditType(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest getCurrentPeriodQuotaSummaryByCreditTypeRequest588)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummaryByCreditType");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryByCreditTypeRequest588,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummaryByCreditType")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCurrentPeriodQuotaSummaryByCreditType
                    * @param getCurrentPeriodQuotaSummaryByCreditTypeRequest588
                
                */
                public  void startgetCurrentPeriodQuotaSummaryByCreditType(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest getCurrentPeriodQuotaSummaryByCreditTypeRequest588,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
             _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummaryByCreditType");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryByCreditTypeRequest588,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummaryByCreditType")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCurrentPeriodQuotaSummaryByCreditType(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
                                            }
									    } else {
										    callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
									    }
									} else {
									    callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(f);
									}
								} else {
								    callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[4].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[4].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCourses
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse getCourses(

                            )
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("getCourses");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCourses
                */
                public  void startgetCourses(

                 

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
             _operationClient.getOptions().setAction("getCourses");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCourses(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCourses(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetCourses(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCourses(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCourses(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCourses(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCourses(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCourses(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCourses(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCourses(f);
                                            }
									    } else {
										    callback.receiveErrorgetCourses(f);
									    }
									} else {
									    callback.receiveErrorgetCourses(f);
									}
								} else {
								    callback.receiveErrorgetCourses(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCourses(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[5].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[5].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getAssignablePolicies
                     * @param getAssignablePoliciesRequest592
                    
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse getAssignablePolicies(

                            edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest getAssignablePoliciesRequest592)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("getAssignablePolicies");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getAssignablePoliciesRequest592,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getAssignablePolicies")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetAssignablePolicies
                    * @param getAssignablePoliciesRequest592
                
                */
                public  void startgetAssignablePolicies(

                 edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest getAssignablePoliciesRequest592,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
             _operationClient.getOptions().setAction("getAssignablePolicies");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getAssignablePoliciesRequest592,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getAssignablePolicies")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetAssignablePolicies(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetAssignablePolicies(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetAssignablePolicies(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignablePolicies(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignablePolicies(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignablePolicies(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignablePolicies(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignablePolicies(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignablePolicies(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignablePolicies(f);
                                            }
									    } else {
										    callback.receiveErrorgetAssignablePolicies(f);
									    }
									} else {
									    callback.receiveErrorgetAssignablePolicies(f);
									}
								} else {
								    callback.receiveErrorgetAssignablePolicies(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetAssignablePolicies(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[6].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[6].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#enrollUser
                     * @param enrollUserRequest594
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse enrollUser(

                            edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest enrollUserRequest594)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
              _operationClient.getOptions().setAction("enrollUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    enrollUserRequest594,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "enrollUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startenrollUser
                    * @param enrollUserRequest594
                
                */
                public  void startenrollUser(

                 edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest enrollUserRequest594,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
             _operationClient.getOptions().setAction("enrollUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    enrollUserRequest594,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "enrollUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultenrollUser(
                                        (edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorenrollUser(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrorenrollUser((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorenrollUser((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorenrollUser(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorenrollUser(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorenrollUser(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorenrollUser(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorenrollUser(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorenrollUser(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorenrollUser(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorenrollUser(f);
                                            }
									    } else {
										    callback.receiveErrorenrollUser(f);
									    }
									} else {
									    callback.receiveErrorenrollUser(f);
									}
								} else {
								    callback.receiveErrorenrollUser(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorenrollUser(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[7].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[7].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#syncUsersAndCourses
                     * @param syncUsersAndCoursesRequest596
                    
                     */

                    

                            public  void syncUsersAndCourses(

                            edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest syncUsersAndCoursesRequest596)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
              _operationClient.getOptions().setAction("syncUsersAndCourses");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    syncUsersAndCoursesRequest596,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "syncUsersAndCourses")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startsyncUsersAndCourses
                    * @param syncUsersAndCoursesRequest596
                
                */
                public  void startsyncUsersAndCourses(

                 edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest syncUsersAndCoursesRequest596,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
             _operationClient.getOptions().setAction("syncUsersAndCourses");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    syncUsersAndCoursesRequest596,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "syncUsersAndCourses")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[8].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[8].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#modifyUser
                     * @param modifyUserRequest598
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault : 
                     */

                    

                            public  void modifyUser(

                            edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest modifyUserRequest598)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[9].getName());
              _operationClient.getOptions().setAction("modifyUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyUserRequest598,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startmodifyUser
                    * @param modifyUserRequest598
                
                */
                public  void startmodifyUser(

                 edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest modifyUserRequest598,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[9].getName());
             _operationClient.getOptions().setAction("modifyUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyUserRequest598,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[9].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[9].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getHistoricQuotaSummaryByUserAndCreditType
                     * @param getHistoricQuotaSummaryByUserAndCreditTypeRequest600
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse getHistoricQuotaSummaryByUserAndCreditType(

                            edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest getHistoricQuotaSummaryByUserAndCreditTypeRequest600)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[10].getName());
              _operationClient.getOptions().setAction("getHistoricQuotaSummaryByUserAndCreditType");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryByUserAndCreditTypeRequest600,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryByUserAndCreditType")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetHistoricQuotaSummaryByUserAndCreditType
                    * @param getHistoricQuotaSummaryByUserAndCreditTypeRequest600
                
                */
                public  void startgetHistoricQuotaSummaryByUserAndCreditType(

                 edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest getHistoricQuotaSummaryByUserAndCreditTypeRequest600,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[10].getName());
             _operationClient.getOptions().setAction("getHistoricQuotaSummaryByUserAndCreditType");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryByUserAndCreditTypeRequest600,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryByUserAndCreditType")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricQuotaSummaryByUserAndCreditType(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(f);
									}
								} else {
								    callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[10].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[10].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#cancelQuotaAssignments
                     * @param cancelQuotaAssignmentsRequest602
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse cancelQuotaAssignments(

                            edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest cancelQuotaAssignmentsRequest602)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[11].getName());
              _operationClient.getOptions().setAction("cancelQuotaAssignments");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelQuotaAssignmentsRequest602,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelQuotaAssignments")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startcancelQuotaAssignments
                    * @param cancelQuotaAssignmentsRequest602
                
                */
                public  void startcancelQuotaAssignments(

                 edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest cancelQuotaAssignmentsRequest602,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[11].getName());
             _operationClient.getOptions().setAction("cancelQuotaAssignments");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelQuotaAssignmentsRequest602,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelQuotaAssignments")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultcancelQuotaAssignments(
                                        (edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorcancelQuotaAssignments(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorcancelQuotaAssignments((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorcancelQuotaAssignments((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorcancelQuotaAssignments((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorcancelQuotaAssignments(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelQuotaAssignments(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelQuotaAssignments(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelQuotaAssignments(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelQuotaAssignments(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelQuotaAssignments(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelQuotaAssignments(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelQuotaAssignments(f);
                                            }
									    } else {
										    callback.receiveErrorcancelQuotaAssignments(f);
									    }
									} else {
									    callback.receiveErrorcancelQuotaAssignments(f);
									}
								} else {
								    callback.receiveErrorcancelQuotaAssignments(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorcancelQuotaAssignments(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[11].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[11].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCreditTypeById
                     * @param getCreditTypeByIdRequest604
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse getCreditTypeById(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest getCreditTypeByIdRequest604)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[12].getName());
              _operationClient.getOptions().setAction("getCreditTypeById");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypeByIdRequest604,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypeById")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCreditTypeById
                    * @param getCreditTypeByIdRequest604
                
                */
                public  void startgetCreditTypeById(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest getCreditTypeByIdRequest604,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[12].getName());
             _operationClient.getOptions().setAction("getCreditTypeById");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypeByIdRequest604,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypeById")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCreditTypeById(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCreditTypeById(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorgetCreditTypeById((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetCreditTypeById(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypeById(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypeById(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypeById(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypeById(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypeById(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypeById(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypeById(f);
                                            }
									    } else {
										    callback.receiveErrorgetCreditTypeById(f);
									    }
									} else {
									    callback.receiveErrorgetCreditTypeById(f);
									}
								} else {
								    callback.receiveErrorgetCreditTypeById(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCreditTypeById(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[12].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[12].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#modifyPolicy
                     * @param modifyPolicyRequest606
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault : 
                     */

                    

                            public  void modifyPolicy(

                            edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest modifyPolicyRequest606)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[13].getName());
              _operationClient.getOptions().setAction("modifyPolicy");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyPolicyRequest606,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyPolicy")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startmodifyPolicy
                    * @param modifyPolicyRequest606
                
                */
                public  void startmodifyPolicy(

                 edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest modifyPolicyRequest606,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[13].getName());
             _operationClient.getOptions().setAction("modifyPolicy");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyPolicyRequest606,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyPolicy")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[13].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[13].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#deleteUser
                     * @param deleteUserRequest608
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     */

                    

                            public  void deleteUser(

                            edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest deleteUserRequest608)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[14].getName());
              _operationClient.getOptions().setAction("deleteUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deleteUserRequest608,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deleteUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startdeleteUser
                    * @param deleteUserRequest608
                
                */
                public  void startdeleteUser(

                 edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest deleteUserRequest608,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[14].getName());
             _operationClient.getOptions().setAction("deleteUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deleteUserRequest608,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deleteUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[14].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[14].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#scheduleAppointments
                     * @param scheduleAppointmentsRequest610
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse scheduleAppointments(

                            edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest scheduleAppointmentsRequest610)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[15].getName());
              _operationClient.getOptions().setAction("scheduleAppointments");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    scheduleAppointmentsRequest610,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "scheduleAppointments")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startscheduleAppointments
                    * @param scheduleAppointmentsRequest610
                
                */
                public  void startscheduleAppointments(

                 edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest scheduleAppointmentsRequest610,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[15].getName());
             _operationClient.getOptions().setAction("scheduleAppointments");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    scheduleAppointmentsRequest610,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "scheduleAppointments")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultscheduleAppointments(
                                        (edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorscheduleAppointments(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorscheduleAppointments((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorscheduleAppointments((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorscheduleAppointments((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorscheduleAppointments(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorscheduleAppointments(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorscheduleAppointments(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorscheduleAppointments(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorscheduleAppointments(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorscheduleAppointments(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorscheduleAppointments(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorscheduleAppointments(f);
                                            }
									    } else {
										    callback.receiveErrorscheduleAppointments(f);
									    }
									} else {
									    callback.receiveErrorscheduleAppointments(f);
									}
								} else {
								    callback.receiveErrorscheduleAppointments(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorscheduleAppointments(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[15].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[15].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#deleteCourse
                     * @param deleteCourseRequest612
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     */

                    

                            public  void deleteCourse(

                            edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest deleteCourseRequest612)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[16].getName());
              _operationClient.getOptions().setAction("deleteCourse");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deleteCourseRequest612,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deleteCourse")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startdeleteCourse
                    * @param deleteCourseRequest612
                
                */
                public  void startdeleteCourse(

                 edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest deleteCourseRequest612,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[16].getName());
             _operationClient.getOptions().setAction("deleteCourse");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deleteCourseRequest612,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deleteCourse")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[16].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[16].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getHistoricQuotaSummary
                     * @param getHistoricQuotaSummaryRequest614
                    
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse getHistoricQuotaSummary(

                            edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest getHistoricQuotaSummaryRequest614)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[17].getName());
              _operationClient.getOptions().setAction("getHistoricQuotaSummary");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryRequest614,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummary")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetHistoricQuotaSummary
                    * @param getHistoricQuotaSummaryRequest614
                
                */
                public  void startgetHistoricQuotaSummary(

                 edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest getHistoricQuotaSummaryRequest614,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[17].getName());
             _operationClient.getOptions().setAction("getHistoricQuotaSummary");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryRequest614,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummary")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricQuotaSummary(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricQuotaSummary(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetHistoricQuotaSummary(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummary(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummary(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummary(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummary(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummary(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummary(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummary(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricQuotaSummary(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricQuotaSummary(f);
									}
								} else {
								    callback.receiveErrorgetHistoricQuotaSummary(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricQuotaSummary(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[17].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[17].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#doesUserHaveAvailableQuota
                     * @param doesUserHaveAvailableQuotaRequest616
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse doesUserHaveAvailableQuota(

                            edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest doesUserHaveAvailableQuotaRequest616)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[18].getName());
              _operationClient.getOptions().setAction("doesUserHaveAvailableQuota");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    doesUserHaveAvailableQuotaRequest616,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "doesUserHaveAvailableQuota")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startdoesUserHaveAvailableQuota
                    * @param doesUserHaveAvailableQuotaRequest616
                
                */
                public  void startdoesUserHaveAvailableQuota(

                 edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest doesUserHaveAvailableQuotaRequest616,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[18].getName());
             _operationClient.getOptions().setAction("doesUserHaveAvailableQuota");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    doesUserHaveAvailableQuotaRequest616,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "doesUserHaveAvailableQuota")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultdoesUserHaveAvailableQuota(
                                        (edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrordoesUserHaveAvailableQuota(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrordoesUserHaveAvailableQuota((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrordoesUserHaveAvailableQuota((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrordoesUserHaveAvailableQuota(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordoesUserHaveAvailableQuota(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordoesUserHaveAvailableQuota(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordoesUserHaveAvailableQuota(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordoesUserHaveAvailableQuota(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordoesUserHaveAvailableQuota(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordoesUserHaveAvailableQuota(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordoesUserHaveAvailableQuota(f);
                                            }
									    } else {
										    callback.receiveErrordoesUserHaveAvailableQuota(f);
									    }
									} else {
									    callback.receiveErrordoesUserHaveAvailableQuota(f);
									}
								} else {
								    callback.receiveErrordoesUserHaveAvailableQuota(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrordoesUserHaveAvailableQuota(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[18].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[18].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCreditTypesByCourse
                     * @param getCreditTypesByCourseRequest618
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse getCreditTypesByCourse(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest getCreditTypesByCourseRequest618)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[19].getName());
              _operationClient.getOptions().setAction("getCreditTypesByCourse");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypesByCourseRequest618,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypesByCourse")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCreditTypesByCourse
                    * @param getCreditTypesByCourseRequest618
                
                */
                public  void startgetCreditTypesByCourse(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest getCreditTypesByCourseRequest618,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[19].getName());
             _operationClient.getOptions().setAction("getCreditTypesByCourse");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypesByCourseRequest618,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypesByCourse")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCreditTypesByCourse(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCreditTypesByCourse(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrorgetCreditTypesByCourse((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetCreditTypesByCourse(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByCourse(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByCourse(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByCourse(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByCourse(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByCourse(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByCourse(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByCourse(f);
                                            }
									    } else {
										    callback.receiveErrorgetCreditTypesByCourse(f);
									    }
									} else {
									    callback.receiveErrorgetCreditTypesByCourse(f);
									}
								} else {
								    callback.receiveErrorgetCreditTypesByCourse(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCreditTypesByCourse(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[19].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[19].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCurrentPeriodQuotaSummaryByUserAndCourse
                     * @param getCurrentPeriodQuotaSummaryByUserAndCourseRequest620
                    
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse getCurrentPeriodQuotaSummaryByUserAndCourse(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest getCurrentPeriodQuotaSummaryByUserAndCourseRequest620)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[20].getName());
              _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummaryByUserAndCourse");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryByUserAndCourseRequest620,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummaryByUserAndCourse")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCurrentPeriodQuotaSummaryByUserAndCourse
                    * @param getCurrentPeriodQuotaSummaryByUserAndCourseRequest620
                
                */
                public  void startgetCurrentPeriodQuotaSummaryByUserAndCourse(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest getCurrentPeriodQuotaSummaryByUserAndCourseRequest620,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[20].getName());
             _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummaryByUserAndCourse");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryByUserAndCourseRequest620,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummaryByUserAndCourse")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCurrentPeriodQuotaSummaryByUserAndCourse(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
                                            }
									    } else {
										    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
									    }
									} else {
									    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(f);
									}
								} else {
								    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[20].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[20].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getPolicies
                     * @param getPoliciesRequest622
                    
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse getPolicies(

                            edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest getPoliciesRequest622)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[21].getName());
              _operationClient.getOptions().setAction("getPolicies");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPoliciesRequest622,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getPolicies")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetPolicies
                    * @param getPoliciesRequest622
                
                */
                public  void startgetPolicies(

                 edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest getPoliciesRequest622,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[21].getName());
             _operationClient.getOptions().setAction("getPolicies");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPoliciesRequest622,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getPolicies")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetPolicies(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetPolicies(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetPolicies(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicies(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicies(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicies(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicies(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicies(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicies(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicies(f);
                                            }
									    } else {
										    callback.receiveErrorgetPolicies(f);
									    }
									} else {
									    callback.receiveErrorgetPolicies(f);
									}
								} else {
								    callback.receiveErrorgetPolicies(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetPolicies(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[21].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[21].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#modifyCreditType
                     * @param modifyCreditTypeRequest624
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault : 
                     */

                    

                            public  void modifyCreditType(

                            edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest modifyCreditTypeRequest624)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[22].getName());
              _operationClient.getOptions().setAction("modifyCreditType");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyCreditTypeRequest624,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyCreditType")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startmodifyCreditType
                    * @param modifyCreditTypeRequest624
                
                */
                public  void startmodifyCreditType(

                 edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest modifyCreditTypeRequest624,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[22].getName());
             _operationClient.getOptions().setAction("modifyCreditType");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyCreditTypeRequest624,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyCreditType")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[22].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[22].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCreditTypesByUser
                     * @param getCreditTypesByUserRequest626
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse getCreditTypesByUser(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest getCreditTypesByUserRequest626)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[23].getName());
              _operationClient.getOptions().setAction("getCreditTypesByUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypesByUserRequest626,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypesByUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCreditTypesByUser
                    * @param getCreditTypesByUserRequest626
                
                */
                public  void startgetCreditTypesByUser(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest getCreditTypesByUserRequest626,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[23].getName());
             _operationClient.getOptions().setAction("getCreditTypesByUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypesByUserRequest626,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypesByUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCreditTypesByUser(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCreditTypesByUser(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorgetCreditTypesByUser((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetCreditTypesByUser(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByUser(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByUser(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByUser(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByUser(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByUser(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByUser(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByUser(f);
                                            }
									    } else {
										    callback.receiveErrorgetCreditTypesByUser(f);
									    }
									} else {
									    callback.receiveErrorgetCreditTypesByUser(f);
									}
								} else {
								    callback.receiveErrorgetCreditTypesByUser(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCreditTypesByUser(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[23].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[23].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCurrentPeriodQuotaSummaryByUser
                     * @param getCurrentPeriodQuotaSummaryByUserRequest628
                    
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse getCurrentPeriodQuotaSummaryByUser(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest getCurrentPeriodQuotaSummaryByUserRequest628)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[24].getName());
              _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummaryByUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryByUserRequest628,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummaryByUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCurrentPeriodQuotaSummaryByUser
                    * @param getCurrentPeriodQuotaSummaryByUserRequest628
                
                */
                public  void startgetCurrentPeriodQuotaSummaryByUser(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest getCurrentPeriodQuotaSummaryByUserRequest628,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[24].getName());
             _operationClient.getOptions().setAction("getCurrentPeriodQuotaSummaryByUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCurrentPeriodQuotaSummaryByUserRequest628,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCurrentPeriodQuotaSummaryByUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCurrentPeriodQuotaSummaryByUser(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
                                            }
									    } else {
										    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
									    }
									} else {
									    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(f);
									}
								} else {
								    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCurrentPeriodQuotaSummaryByUser(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[24].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[24].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#modifyAppointment
                     * @param modifyAppointmentRequest630
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse modifyAppointment(

                            edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest modifyAppointmentRequest630)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[25].getName());
              _operationClient.getOptions().setAction("modifyAppointment");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyAppointmentRequest630,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyAppointment")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startmodifyAppointment
                    * @param modifyAppointmentRequest630
                
                */
                public  void startmodifyAppointment(

                 edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest modifyAppointmentRequest630,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[25].getName());
             _operationClient.getOptions().setAction("modifyAppointment");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyAppointmentRequest630,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyAppointment")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultmodifyAppointment(
                                        (edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrormodifyAppointment(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrormodifyAppointment((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrormodifyAppointment((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrormodifyAppointment((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrormodifyAppointment(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAppointment(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAppointment(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAppointment(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAppointment(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAppointment(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAppointment(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAppointment(f);
                                            }
									    } else {
										    callback.receiveErrormodifyAppointment(f);
									    }
									} else {
									    callback.receiveErrormodifyAppointment(f);
									}
								} else {
								    callback.receiveErrormodifyAppointment(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrormodifyAppointment(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[25].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[25].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getUsers
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse getUsers(

                            )
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[26].getName());
              _operationClient.getOptions().setAction("getUsers");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetUsers
                */
                public  void startgetUsers(

                 

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[26].getName());
             _operationClient.getOptions().setAction("getUsers");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetUsers(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetUsers(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetUsers(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsers(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsers(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsers(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsers(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsers(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsers(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsers(f);
                                            }
									    } else {
										    callback.receiveErrorgetUsers(f);
									    }
									} else {
									    callback.receiveErrorgetUsers(f);
									}
								} else {
								    callback.receiveErrorgetUsers(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetUsers(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[26].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[26].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getPolicyById
                     * @param getPolicyByIdRequest634
                    
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse getPolicyById(

                            edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest getPolicyByIdRequest634)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[27].getName());
              _operationClient.getOptions().setAction("getPolicyById");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPolicyByIdRequest634,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getPolicyById")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetPolicyById
                    * @param getPolicyByIdRequest634
                
                */
                public  void startgetPolicyById(

                 edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest getPolicyByIdRequest634,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[27].getName());
             _operationClient.getOptions().setAction("getPolicyById");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPolicyByIdRequest634,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getPolicyById")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetPolicyById(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetPolicyById(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetPolicyById(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyById(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyById(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyById(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyById(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyById(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyById(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyById(f);
                                            }
									    } else {
										    callback.receiveErrorgetPolicyById(f);
									    }
									} else {
									    callback.receiveErrorgetPolicyById(f);
									}
								} else {
								    callback.receiveErrorgetPolicyById(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetPolicyById(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[27].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[27].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#cancelAppointment
                     * @param cancelAppointmentRequest636
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse cancelAppointment(

                            edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest cancelAppointmentRequest636)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[28].getName());
              _operationClient.getOptions().setAction("cancelAppointment");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelAppointmentRequest636,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelAppointment")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startcancelAppointment
                    * @param cancelAppointmentRequest636
                
                */
                public  void startcancelAppointment(

                 edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest cancelAppointmentRequest636,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[28].getName());
             _operationClient.getOptions().setAction("cancelAppointment");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelAppointmentRequest636,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelAppointment")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultcancelAppointment(
                                        (edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorcancelAppointment(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorcancelAppointment((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorcancelAppointment(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAppointment(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAppointment(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAppointment(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAppointment(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAppointment(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAppointment(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAppointment(f);
                                            }
									    } else {
										    callback.receiveErrorcancelAppointment(f);
									    }
									} else {
									    callback.receiveErrorcancelAppointment(f);
									}
								} else {
								    callback.receiveErrorcancelAppointment(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorcancelAppointment(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[28].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[28].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCreditTypes
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse getCreditTypes(

                            )
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[29].getName());
              _operationClient.getOptions().setAction("getCreditTypes");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCreditTypes
                */
                public  void startgetCreditTypes(

                 

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[29].getName());
             _operationClient.getOptions().setAction("getCreditTypes");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCreditTypes(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCreditTypes(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetCreditTypes(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypes(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypes(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypes(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypes(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypes(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypes(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypes(f);
                                            }
									    } else {
										    callback.receiveErrorgetCreditTypes(f);
									    }
									} else {
									    callback.receiveErrorgetCreditTypes(f);
									}
								} else {
								    callback.receiveErrorgetCreditTypes(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCreditTypes(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[29].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[29].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getCreditTypesByPolicy
                     * @param getCreditTypesByPolicyRequest640
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse getCreditTypesByPolicy(

                            edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest getCreditTypesByPolicyRequest640)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[30].getName());
              _operationClient.getOptions().setAction("getCreditTypesByPolicy");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypesByPolicyRequest640,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypesByPolicy")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetCreditTypesByPolicy
                    * @param getCreditTypesByPolicyRequest640
                
                */
                public  void startgetCreditTypesByPolicy(

                 edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest getCreditTypesByPolicyRequest640,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[30].getName());
             _operationClient.getOptions().setAction("getCreditTypesByPolicy");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getCreditTypesByPolicyRequest640,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getCreditTypesByPolicy")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetCreditTypesByPolicy(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetCreditTypesByPolicy(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault){
														callback.receiveErrorgetCreditTypesByPolicy((edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetCreditTypesByPolicy(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByPolicy(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByPolicy(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByPolicy(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByPolicy(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByPolicy(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByPolicy(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetCreditTypesByPolicy(f);
                                            }
									    } else {
										    callback.receiveErrorgetCreditTypesByPolicy(f);
									    }
									} else {
									    callback.receiveErrorgetCreditTypesByPolicy(f);
									}
								} else {
								    callback.receiveErrorgetCreditTypesByPolicy(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetCreditTypesByPolicy(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[30].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[30].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getPolicyByCreditType
                     * @param getPolicyByCreditTypeRequest642
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse getPolicyByCreditType(

                            edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest getPolicyByCreditTypeRequest642)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[31].getName());
              _operationClient.getOptions().setAction("getPolicyByCreditType");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPolicyByCreditTypeRequest642,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getPolicyByCreditType")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetPolicyByCreditType
                    * @param getPolicyByCreditTypeRequest642
                
                */
                public  void startgetPolicyByCreditType(

                 edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest getPolicyByCreditTypeRequest642,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[31].getName());
             _operationClient.getOptions().setAction("getPolicyByCreditType");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPolicyByCreditTypeRequest642,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getPolicyByCreditType")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetPolicyByCreditType(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetPolicyByCreditType(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorgetPolicyByCreditType((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetPolicyByCreditType(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyByCreditType(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyByCreditType(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyByCreditType(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyByCreditType(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyByCreditType(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyByCreditType(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPolicyByCreditType(f);
                                            }
									    } else {
										    callback.receiveErrorgetPolicyByCreditType(f);
									    }
									} else {
									    callback.receiveErrorgetPolicyByCreditType(f);
									}
								} else {
								    callback.receiveErrorgetPolicyByCreditType(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetPolicyByCreditType(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[31].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[31].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#addPolicy
                     * @param addPolicyRequest644
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse addPolicy(

                            edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest addPolicyRequest644)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[32].getName());
              _operationClient.getOptions().setAction("addPolicy");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addPolicyRequest644,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addPolicy")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startaddPolicy
                    * @param addPolicyRequest644
                
                */
                public  void startaddPolicy(

                 edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest addPolicyRequest644,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[32].getName());
             _operationClient.getOptions().setAction("addPolicy");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addPolicyRequest644,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addPolicy")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultaddPolicy(
                                        (edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErroraddPolicy(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErroraddPolicy((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault){
														callback.receiveErroraddPolicy((edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErroraddPolicy(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddPolicy(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddPolicy(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddPolicy(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddPolicy(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddPolicy(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddPolicy(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddPolicy(f);
                                            }
									    } else {
										    callback.receiveErroraddPolicy(f);
									    }
									} else {
									    callback.receiveErroraddPolicy(f);
									}
								} else {
								    callback.receiveErroraddPolicy(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErroraddPolicy(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[32].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[32].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#cancelCourseQuota
                     * @param cancelCourseQuotaRequest646
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse cancelCourseQuota(

                            edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest cancelCourseQuotaRequest646)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[33].getName());
              _operationClient.getOptions().setAction("cancelCourseQuota");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelCourseQuotaRequest646,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelCourseQuota")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startcancelCourseQuota
                    * @param cancelCourseQuotaRequest646
                
                */
                public  void startcancelCourseQuota(

                 edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest cancelCourseQuotaRequest646,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[33].getName());
             _operationClient.getOptions().setAction("cancelCourseQuota");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelCourseQuotaRequest646,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelCourseQuota")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultcancelCourseQuota(
                                        (edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorcancelCourseQuota(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorcancelCourseQuota((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrorcancelCourseQuota((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorcancelCourseQuota((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorcancelCourseQuota(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelCourseQuota(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelCourseQuota(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelCourseQuota(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelCourseQuota(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelCourseQuota(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelCourseQuota(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelCourseQuota(f);
                                            }
									    } else {
										    callback.receiveErrorcancelCourseQuota(f);
									    }
									} else {
									    callback.receiveErrorcancelCourseQuota(f);
									}
								} else {
								    callback.receiveErrorcancelCourseQuota(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorcancelCourseQuota(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[33].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[33].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getAssignableCreditTypes
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse getAssignableCreditTypes(

                            )
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[34].getName());
              _operationClient.getOptions().setAction("getAssignableCreditTypes");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetAssignableCreditTypes
                */
                public  void startgetAssignableCreditTypes(

                 

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[34].getName());
             _operationClient.getOptions().setAction("getAssignableCreditTypes");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();
                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetAssignableCreditTypes(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetAssignableCreditTypes(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorgetAssignableCreditTypes(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignableCreditTypes(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignableCreditTypes(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignableCreditTypes(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignableCreditTypes(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignableCreditTypes(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignableCreditTypes(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignableCreditTypes(f);
                                            }
									    } else {
										    callback.receiveErrorgetAssignableCreditTypes(f);
									    }
									} else {
									    callback.receiveErrorgetAssignableCreditTypes(f);
									}
								} else {
								    callback.receiveErrorgetAssignableCreditTypes(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetAssignableCreditTypes(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[34].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[34].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#modifyCourseQuota
                     * @param modifyCourseQuotaRequest650
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse modifyCourseQuota(

                            edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest modifyCourseQuotaRequest650)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[35].getName());
              _operationClient.getOptions().setAction("modifyCourseQuota");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyCourseQuotaRequest650,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyCourseQuota")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startmodifyCourseQuota
                    * @param modifyCourseQuotaRequest650
                
                */
                public  void startmodifyCourseQuota(

                 edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest modifyCourseQuotaRequest650,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[35].getName());
             _operationClient.getOptions().setAction("modifyCourseQuota");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyCourseQuotaRequest650,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyCourseQuota")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultmodifyCourseQuota(
                                        (edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrormodifyCourseQuota(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrormodifyCourseQuota((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrormodifyCourseQuota((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrormodifyCourseQuota((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrormodifyCourseQuota(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyCourseQuota(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyCourseQuota(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyCourseQuota(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyCourseQuota(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyCourseQuota(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyCourseQuota(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyCourseQuota(f);
                                            }
									    } else {
										    callback.receiveErrormodifyCourseQuota(f);
									    }
									} else {
									    callback.receiveErrormodifyCourseQuota(f);
									}
								} else {
								    callback.receiveErrormodifyCourseQuota(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrormodifyCourseQuota(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[35].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[35].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#assignQuota
                     * @param assignQuotaRequest652
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse assignQuota(

                            edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest assignQuotaRequest652)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[36].getName());
              _operationClient.getOptions().setAction("assignQuota");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    assignQuotaRequest652,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "assignQuota")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startassignQuota
                    * @param assignQuotaRequest652
                
                */
                public  void startassignQuota(

                 edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest assignQuotaRequest652,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[36].getName());
             _operationClient.getOptions().setAction("assignQuota");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    assignQuotaRequest652,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "assignQuota")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultassignQuota(
                                        (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorassignQuota(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorassignQuota((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorassignQuota((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorassignQuota((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorassignQuota(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuota(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuota(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuota(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuota(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuota(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuota(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuota(f);
                                            }
									    } else {
										    callback.receiveErrorassignQuota(f);
									    }
									} else {
									    callback.receiveErrorassignQuota(f);
									}
								} else {
								    callback.receiveErrorassignQuota(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorassignQuota(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[36].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[36].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#unenrollUser
                     * @param unenrollUserRequest654
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     */

                    

                            public  void unenrollUser(

                            edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest unenrollUserRequest654)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[37].getName());
              _operationClient.getOptions().setAction("unenrollUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    unenrollUserRequest654,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "unenrollUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startunenrollUser
                    * @param unenrollUserRequest654
                
                */
                public  void startunenrollUser(

                 edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest unenrollUserRequest654,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[37].getName());
             _operationClient.getOptions().setAction("unenrollUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    unenrollUserRequest654,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "unenrollUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[37].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[37].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#addCourse
                     * @param addCourseRequest656
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  void addCourse(

                            edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest addCourseRequest656)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[38].getName());
              _operationClient.getOptions().setAction("addCourse");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addCourseRequest656,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addCourse")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startaddCourse
                    * @param addCourseRequest656
                
                */
                public  void startaddCourse(

                 edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest addCourseRequest656,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[38].getName());
             _operationClient.getOptions().setAction("addCourse");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addCourseRequest656,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addCourse")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[38].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[38].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#cancelAllAppointments
                     * @param cancelAllAppointmentsRequest658
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse cancelAllAppointments(

                            edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest cancelAllAppointmentsRequest658)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[39].getName());
              _operationClient.getOptions().setAction("cancelAllAppointments");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelAllAppointmentsRequest658,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelAllAppointments")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startcancelAllAppointments
                    * @param cancelAllAppointmentsRequest658
                
                */
                public  void startcancelAllAppointments(

                 edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest cancelAllAppointmentsRequest658,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[39].getName());
             _operationClient.getOptions().setAction("cancelAllAppointments");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelAllAppointmentsRequest658,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "cancelAllAppointments")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultcancelAllAppointments(
                                        (edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorcancelAllAppointments(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorcancelAllAppointments((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorcancelAllAppointments(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAllAppointments(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAllAppointments(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAllAppointments(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAllAppointments(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAllAppointments(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAllAppointments(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorcancelAllAppointments(f);
                                            }
									    } else {
										    callback.receiveErrorcancelAllAppointments(f);
									    }
									} else {
									    callback.receiveErrorcancelAllAppointments(f);
									}
								} else {
								    callback.receiveErrorcancelAllAppointments(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorcancelAllAppointments(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[39].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[39].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#deletePolicy
                     * @param deletePolicyRequest660
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault : 
                     */

                    

                            public  void deletePolicy(

                            edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest deletePolicyRequest660)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[40].getName());
              _operationClient.getOptions().setAction("deletePolicy");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deletePolicyRequest660,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deletePolicy")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startdeletePolicy
                    * @param deletePolicyRequest660
                
                */
                public  void startdeletePolicy(

                 edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest deletePolicyRequest660,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[40].getName());
             _operationClient.getOptions().setAction("deletePolicy");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    deletePolicyRequest660,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "deletePolicy")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[40].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[40].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getUsersByCourse
                     * @param getUsersByCourseRequest662
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse getUsersByCourse(

                            edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest getUsersByCourseRequest662)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[41].getName());
              _operationClient.getOptions().setAction("getUsersByCourse");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getUsersByCourseRequest662,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getUsersByCourse")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetUsersByCourse
                    * @param getUsersByCourseRequest662
                
                */
                public  void startgetUsersByCourse(

                 edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest getUsersByCourseRequest662,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[41].getName());
             _operationClient.getOptions().setAction("getUsersByCourse");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getUsersByCourseRequest662,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getUsersByCourse")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetUsersByCourse(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetUsersByCourse(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrorgetUsersByCourse((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetUsersByCourse(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsersByCourse(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsersByCourse(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsersByCourse(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsersByCourse(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsersByCourse(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsersByCourse(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetUsersByCourse(f);
                                            }
									    } else {
										    callback.receiveErrorgetUsersByCourse(f);
									    }
									} else {
									    callback.receiveErrorgetUsersByCourse(f);
									}
								} else {
								    callback.receiveErrorgetUsersByCourse(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetUsersByCourse(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[41].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[41].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#modifyCourse
                     * @param modifyCourseRequest664
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  void modifyCourse(

                            edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest modifyCourseRequest664)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[42].getName());
              _operationClient.getOptions().setAction("modifyCourse");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyCourseRequest664,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyCourse")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startmodifyCourse
                    * @param modifyCourseRequest664
                
                */
                public  void startmodifyCourse(

                 edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest modifyCourseRequest664,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[42].getName());
             _operationClient.getOptions().setAction("modifyCourse");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    modifyCourseRequest664,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "modifyCourse")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[42].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[42].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#assignQuotaToCourse
                     * @param assignQuotaToCourseRequest666
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse assignQuotaToCourse(

                            edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest assignQuotaToCourseRequest666)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[43].getName());
              _operationClient.getOptions().setAction("assignQuotaToCourse");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    assignQuotaToCourseRequest666,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "assignQuotaToCourse")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startassignQuotaToCourse
                    * @param assignQuotaToCourseRequest666
                
                */
                public  void startassignQuotaToCourse(

                 edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest assignQuotaToCourseRequest666,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[43].getName());
             _operationClient.getOptions().setAction("assignQuotaToCourse");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    assignQuotaToCourseRequest666,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "assignQuotaToCourse")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultassignQuotaToCourse(
                                        (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorassignQuotaToCourse(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorassignQuotaToCourse((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrorassignQuotaToCourse((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorassignQuotaToCourse((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorassignQuotaToCourse(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuotaToCourse(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuotaToCourse(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuotaToCourse(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuotaToCourse(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuotaToCourse(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuotaToCourse(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorassignQuotaToCourse(f);
                                            }
									    } else {
										    callback.receiveErrorassignQuotaToCourse(f);
									    }
									} else {
									    callback.receiveErrorassignQuotaToCourse(f);
									}
								} else {
								    callback.receiveErrorassignQuotaToCourse(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorassignQuotaToCourse(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[43].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[43].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#addUser
                     * @param addUserRequest668
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault : 
                     */

                    

                            public  void addUser(

                            edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest addUserRequest668)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[44].getName());
              _operationClient.getOptions().setAction("addUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addUserRequest668,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
                return;
            
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startaddUser
                    * @param addUserRequest668
                
                */
                public  void startaddUser(

                 edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest addUserRequest668,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[44].getName());
             _operationClient.getOptions().setAction("addUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addUserRequest668,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "addUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                            // Nothing to pass as the callback!!!
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[44].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[44].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getHistoricQuotaSummaryPerUsers
                     * @param getHistoricQuotaSummaryPerUsersRequest670
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse getHistoricQuotaSummaryPerUsers(

                            edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest getHistoricQuotaSummaryPerUsersRequest670)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[45].getName());
              _operationClient.getOptions().setAction("getHistoricQuotaSummaryPerUsers");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryPerUsersRequest670,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryPerUsers")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetHistoricQuotaSummaryPerUsers
                    * @param getHistoricQuotaSummaryPerUsersRequest670
                
                */
                public  void startgetHistoricQuotaSummaryPerUsers(

                 edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest getHistoricQuotaSummaryPerUsersRequest670,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[45].getName());
             _operationClient.getOptions().setAction("getHistoricQuotaSummaryPerUsers");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryPerUsersRequest670,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryPerUsers")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricQuotaSummaryPerUsers(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault){
														callback.receiveErrorgetHistoricQuotaSummaryPerUsers((edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault){
														callback.receiveErrorgetHistoricQuotaSummaryPerUsers((edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricQuotaSummaryPerUsers(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricQuotaSummaryPerUsers(f);
									}
								} else {
								    callback.receiveErrorgetHistoricQuotaSummaryPerUsers(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricQuotaSummaryPerUsers(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[45].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[45].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#getHistoricQuotaSummaryByUser
                     * @param getHistoricQuotaSummaryByUserRequest672
                    
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault : 
                     * @throws edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault : 
                     */

                    

                            public  edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse getHistoricQuotaSummaryByUser(

                            edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest getHistoricQuotaSummaryByUserRequest672)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault
                        ,edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[46].getName());
              _operationClient.getOptions().setAction("getHistoricQuotaSummaryByUser");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryByUserRequest672,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryByUser")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex;
                        }
                        
                        if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
                          throw (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see edu.fiu.cis.acrl.quotasystem.ws.QuotaSystem#startgetHistoricQuotaSummaryByUser
                    * @param getHistoricQuotaSummaryByUserRequest672
                
                */
                public  void startgetHistoricQuotaSummaryByUser(

                 edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest getHistoricQuotaSummaryByUserRequest672,

                  final edu.fiu.cis.acrl.quotasystem.ws.QuotaSystemCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[46].getName());
             _operationClient.getOptions().setAction("getHistoricQuotaSummaryByUser");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricQuotaSummaryByUserRequest672,
                                                    optimizeContent(new javax.xml.namespace.QName("http://acrl.cis.fiu.edu/quotasystem/ws",
                                                    "getHistoricQuotaSummaryByUser")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricQuotaSummaryByUser(
                                        (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricQuotaSummaryByUser(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault){
														callback.receiveErrorgetHistoricQuotaSummaryByUser((edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault)ex);
											            return;
										            }
										            
													if (ex instanceof edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault){
														callback.receiveErrorgetHistoricQuotaSummaryByUser((edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricQuotaSummaryByUser(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricQuotaSummaryByUser(f);
									}
								} else {
								    callback.receiveErrorgetHistoricQuotaSummaryByUser(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricQuotaSummaryByUser(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[46].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[46].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://localhost:8080/axis2/services/QuotaSystem/
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.InvalidDataError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.class.equals(type)){
                
                           return edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   