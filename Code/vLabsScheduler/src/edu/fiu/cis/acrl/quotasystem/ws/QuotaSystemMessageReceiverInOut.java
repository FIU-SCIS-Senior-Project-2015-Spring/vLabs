
/**
 * QuotaSystemMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package edu.fiu.cis.acrl.quotasystem.ws;

        /**
        *  QuotaSystemMessageReceiverInOut message receiver
        */

        public class QuotaSystemMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        QuotaSystemSkeleton skel = (QuotaSystemSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("addCreditType".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse addCreditTypeResponse17 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addCreditTypeResponse17 =
                                                   
                                                   
                                                         skel.addCreditType(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addCreditTypeResponse17, false);
                                    } else 

            if("getCurrentPeriodQuotaSummary".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse getCurrentPeriodQuotaSummaryResponse19 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCurrentPeriodQuotaSummaryResponse19 =
                                                   
                                                   
                                                         skel.getCurrentPeriodQuotaSummary(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCurrentPeriodQuotaSummaryResponse19, false);
                                    } else 

            if("getHistoricQuotaSummaryPerPeriods".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse getHistoricQuotaSummaryPerPeriodsResponse21 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHistoricQuotaSummaryPerPeriodsResponse21 =
                                                   
                                                   
                                                         skel.getHistoricQuotaSummaryPerPeriods(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHistoricQuotaSummaryPerPeriodsResponse21, false);
                                    } else 

            if("deleteCreditType".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.DeleteCreditTypeRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.deleteCreditType(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("getCurrentPeriodQuotaSummaryByCreditType".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse getCurrentPeriodQuotaSummaryByCreditTypeResponse25 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCurrentPeriodQuotaSummaryByCreditTypeResponse25 =
                                                   
                                                   
                                                         skel.getCurrentPeriodQuotaSummaryByCreditType(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCurrentPeriodQuotaSummaryByCreditTypeResponse25, false);
                                    } else 

            if("getCourses".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse getCoursesResponse27 = null;
	                        getCoursesResponse27 =
                                                     
                                                 skel.getCourses()
                                                ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCoursesResponse27, false);
                                    } else 

            if("getAssignablePolicies".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse getAssignablePoliciesResponse29 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getAssignablePoliciesResponse29 =
                                                   
                                                   
                                                         skel.getAssignablePolicies(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getAssignablePoliciesResponse29, false);
                                    } else 

            if("enrollUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse enrollUserResponse31 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.EnrollUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               enrollUserResponse31 =
                                                   
                                                   
                                                         skel.enrollUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), enrollUserResponse31, false);
                                    } else 

            if("syncUsersAndCourses".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.SyncUsersAndCoursesRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.syncUsersAndCourses(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("modifyUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.ModifyUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.modifyUser(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("getHistoricQuotaSummaryByUserAndCreditType".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse getHistoricQuotaSummaryByUserAndCreditTypeResponse37 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHistoricQuotaSummaryByUserAndCreditTypeResponse37 =
                                                   
                                                   
                                                         skel.getHistoricQuotaSummaryByUserAndCreditType(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHistoricQuotaSummaryByUserAndCreditTypeResponse37, false);
                                    } else 

            if("cancelQuotaAssignments".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse cancelQuotaAssignmentsResponse39 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelQuotaAssignmentsResponse39 =
                                                   
                                                   
                                                         skel.cancelQuotaAssignments(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelQuotaAssignmentsResponse39, false);
                                    } else 

            if("getCreditTypeById".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse getCreditTypeByIdResponse41 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCreditTypeByIdResponse41 =
                                                   
                                                   
                                                         skel.getCreditTypeById(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCreditTypeByIdResponse41, false);
                                    } else 

            if("modifyPolicy".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.ModifyPolicyRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.modifyPolicy(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("deleteUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.DeleteUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.deleteUser(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("scheduleAppointments".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse scheduleAppointmentsResponse47 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               scheduleAppointmentsResponse47 =
                                                   
                                                   
                                                         skel.scheduleAppointments(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), scheduleAppointmentsResponse47, false);
                                    } else 

            if("deleteCourse".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.DeleteCourseRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.deleteCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("getHistoricQuotaSummary".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse getHistoricQuotaSummaryResponse51 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHistoricQuotaSummaryResponse51 =
                                                   
                                                   
                                                         skel.getHistoricQuotaSummary(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHistoricQuotaSummaryResponse51, false);
                                    } else 

            if("doesUserHaveAvailableQuota".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse doesUserHaveAvailableQuotaResponse53 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               doesUserHaveAvailableQuotaResponse53 =
                                                   
                                                   
                                                         skel.doesUserHaveAvailableQuota(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), doesUserHaveAvailableQuotaResponse53, false);
                                    } else 

            if("getCreditTypesByCourse".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse getCreditTypesByCourseResponse55 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCreditTypesByCourseResponse55 =
                                                   
                                                   
                                                         skel.getCreditTypesByCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCreditTypesByCourseResponse55, false);
                                    } else 

            if("getCurrentPeriodQuotaSummaryByUserAndCourse".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse getCurrentPeriodQuotaSummaryByUserAndCourseResponse57 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCurrentPeriodQuotaSummaryByUserAndCourseResponse57 =
                                                   
                                                   
                                                         skel.getCurrentPeriodQuotaSummaryByUserAndCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCurrentPeriodQuotaSummaryByUserAndCourseResponse57, false);
                                    } else 

            if("getPolicies".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse getPoliciesResponse59 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getPoliciesResponse59 =
                                                   
                                                   
                                                         skel.getPolicies(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getPoliciesResponse59, false);
                                    } else 

            if("modifyCreditType".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.ModifyCreditTypeRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.modifyCreditType(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("getCreditTypesByUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse getCreditTypesByUserResponse63 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCreditTypesByUserResponse63 =
                                                   
                                                   
                                                         skel.getCreditTypesByUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCreditTypesByUserResponse63, false);
                                    } else 

            if("getCurrentPeriodQuotaSummaryByUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse getCurrentPeriodQuotaSummaryByUserResponse65 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCurrentPeriodQuotaSummaryByUserResponse65 =
                                                   
                                                   
                                                         skel.getCurrentPeriodQuotaSummaryByUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCurrentPeriodQuotaSummaryByUserResponse65, false);
                                    } else 

            if("modifyAppointment".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse modifyAppointmentResponse67 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               modifyAppointmentResponse67 =
                                                   
                                                   
                                                         skel.modifyAppointment(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), modifyAppointmentResponse67, false);
                                    } else 

            if("getUsers".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse getUsersResponse69 = null;
	                        getUsersResponse69 =
                                                     
                                                 skel.getUsers()
                                                ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUsersResponse69, false);
                                    } else 

            if("getPolicyById".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse getPolicyByIdResponse71 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getPolicyByIdResponse71 =
                                                   
                                                   
                                                         skel.getPolicyById(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getPolicyByIdResponse71, false);
                                    } else 

            if("cancelAppointment".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse cancelAppointmentResponse73 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelAppointmentResponse73 =
                                                   
                                                   
                                                         skel.cancelAppointment(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelAppointmentResponse73, false);
                                    } else 

            if("getCreditTypes".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse getCreditTypesResponse75 = null;
	                        getCreditTypesResponse75 =
                                                     
                                                 skel.getCreditTypes()
                                                ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCreditTypesResponse75, false);
                                    } else 

            if("getCreditTypesByPolicy".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse getCreditTypesByPolicyResponse77 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getCreditTypesByPolicyResponse77 =
                                                   
                                                   
                                                         skel.getCreditTypesByPolicy(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCreditTypesByPolicyResponse77, false);
                                    } else 

            if("getPolicyByCreditType".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse getPolicyByCreditTypeResponse79 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getPolicyByCreditTypeResponse79 =
                                                   
                                                   
                                                         skel.getPolicyByCreditType(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getPolicyByCreditTypeResponse79, false);
                                    } else 

            if("addPolicy".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse addPolicyResponse81 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.AddPolicyRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addPolicyResponse81 =
                                                   
                                                   
                                                         skel.addPolicy(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addPolicyResponse81, false);
                                    } else 

            if("cancelCourseQuota".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse cancelCourseQuotaResponse83 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelCourseQuotaResponse83 =
                                                   
                                                   
                                                         skel.cancelCourseQuota(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelCourseQuotaResponse83, false);
                                    } else 

            if("getAssignableCreditTypes".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse getAssignableCreditTypesResponse85 = null;
	                        getAssignableCreditTypesResponse85 =
                                                     
                                                 skel.getAssignableCreditTypes()
                                                ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getAssignableCreditTypesResponse85, false);
                                    } else 

            if("modifyCourseQuota".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse modifyCourseQuotaResponse87 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               modifyCourseQuotaResponse87 =
                                                   
                                                   
                                                         skel.modifyCourseQuota(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), modifyCourseQuotaResponse87, false);
                                    } else 

            if("assignQuota".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse assignQuotaResponse89 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               assignQuotaResponse89 =
                                                   
                                                   
                                                         skel.assignQuota(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), assignQuotaResponse89, false);
                                    } else 

            if("unenrollUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.UnenrollUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.unenrollUser(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("addCourse".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.AddCourseRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.addCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("cancelAllAppointments".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse cancelAllAppointmentsResponse95 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelAllAppointmentsResponse95 =
                                                   
                                                   
                                                         skel.cancelAllAppointments(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelAllAppointmentsResponse95, false);
                                    } else 

            if("deletePolicy".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.DeletePolicyRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.deletePolicy(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("getUsersByCourse".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse getUsersByCourseResponse99 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUsersByCourseResponse99 =
                                                   
                                                   
                                                         skel.getUsersByCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUsersByCourseResponse99, false);
                                    } else 

            if("modifyCourse".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.modifyCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("assignQuotaToCourse".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse assignQuotaToCourseResponse103 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               assignQuotaToCourseResponse103 =
                                                   
                                                   
                                                         skel.assignQuotaToCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), assignQuotaToCourseResponse103, false);
                                    } else 

            if("addUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.AddUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.addUser(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("getHistoricQuotaSummaryPerUsers".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse getHistoricQuotaSummaryPerUsersResponse107 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHistoricQuotaSummaryPerUsersResponse107 =
                                                   
                                                   
                                                         skel.getHistoricQuotaSummaryPerUsers(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHistoricQuotaSummaryPerUsersResponse107, false);
                                    } else 

            if("getHistoricQuotaSummaryByUser".equals(methodName)){
                
                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse getHistoricQuotaSummaryByUserResponse109 = null;
	                        edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHistoricQuotaSummaryByUserResponse109 =
                                                   
                                                   
                                                         skel.getHistoricQuotaSummaryByUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHistoricQuotaSummaryByUserResponse109, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        } catch (DuplicateCourseFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"DuplicateCourseError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (PolicyNotFoundFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"PolicyNotFoundError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (EnrollmentNotFoundFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"EnrollmentNotFoundError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (CreditTypeNotFoundFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"CreditTypeNotFoundError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (CourseNotFoundFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"CourseNotFoundError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (UserNotFoundFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"UserNotFoundError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (InvalidDataFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"InvalidDataError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (DuplicatePolicyFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"DuplicatePolicyError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (DuplicateUserFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"DuplicateUserError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (DuplicateCreditTypeFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"DuplicateCreditTypeError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
        
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
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
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse wrapaddCreditType(){
                                edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse wrapgetCurrentPeriodQuotaSummary(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse wrapgetHistoricQuotaSummaryPerPeriods(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse wrapgetCurrentPeriodQuotaSummaryByCreditType(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse wrapgetCourses(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse wrapgetAssignablePolicies(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse wrapenrollUser(){
                                edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse wrapgetHistoricQuotaSummaryByUserAndCreditType(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse wrapcancelQuotaAssignments(){
                                edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse wrapgetCreditTypeById(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse wrapscheduleAppointments(){
                                edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse wrapgetHistoricQuotaSummary(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse wrapdoesUserHaveAvailableQuota(){
                                edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse wrapgetCreditTypesByCourse(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse wrapgetCurrentPeriodQuotaSummaryByUserAndCourse(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse wrapgetPolicies(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse wrapgetCreditTypesByUser(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse wrapgetCurrentPeriodQuotaSummaryByUser(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse wrapmodifyAppointment(){
                                edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse wrapgetUsers(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse wrapgetPolicyById(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse wrapcancelAppointment(){
                                edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse wrapgetCreditTypes(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse wrapgetCreditTypesByPolicy(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse wrapgetPolicyByCreditType(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse wrapaddPolicy(){
                                edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse wrapcancelCourseQuota(){
                                edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse wrapgetAssignableCreditTypes(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse wrapmodifyCourseQuota(){
                                edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse wrapassignQuota(){
                                edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse wrapcancelAllAppointments(){
                                edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse wrapgetUsersByCourse(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse wrapassignQuotaToCourse(){
                                edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse wrapgetHistoricQuotaSummaryPerUsers(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse wrapgetHistoricQuotaSummaryByUser(){
                                edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse wrappedElement = new edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse();
                                return wrappedElement;
                         }
                    


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

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    