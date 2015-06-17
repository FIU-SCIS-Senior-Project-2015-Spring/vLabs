
/**
 * VESchedulerMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */
        package edu.fiu.cis.acrl.vescheduler.ws;

        /**
        *  VESchedulerMessageReceiverInOut message receiver
        */

        public class VESchedulerMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        VESchedulerSkeleton skel = (VESchedulerSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("getHostUsingName".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse getHostUsingNameResponse2 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostUsingNameResponse2 =
                                                   
                                                   
                                                         skel.getHostUsingName(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostUsingNameResponse2, false);
                                    } else 

            if("runVMCmd".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse runVMCmdResponse4 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               runVMCmdResponse4 =
                                                   
                                                   
                                                         skel.runVMCmd(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), runVMCmdResponse4, false);
                                    } else 

            if("cancelScheduledHostMaintenance".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse cancelScheduledHostMaintenanceResponse6 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelScheduledHostMaintenanceResponse6 =
                                                   
                                                   
                                                         skel.cancelScheduledHostMaintenance(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelScheduledHostMaintenanceResponse6, false);
                                    } else 

            if("setConfiguration".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse setConfigurationResponse8 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setConfigurationResponse8 =
                                                   
                                                   
                                                         skel.setConfiguration(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setConfigurationResponse8, false);
                                    } else 

            if("getVEInsCurSchedule".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse getVEInsCurScheduleResponse10 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVEInsCurScheduleResponse10 =
                                                   
                                                   
                                                         skel.getVEInsCurSchedule(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVEInsCurScheduleResponse10, false);
                                    } else 

            if("delHost".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse delHostResponse12 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               delHostResponse12 =
                                                   
                                                   
                                                         skel.delHost(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), delHostResponse12, false);
                                    } else 

            if("redistributeDevasEvenly".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse redistributeDevasEvenlyResponse14 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               redistributeDevasEvenlyResponse14 =
                                                   
                                                   
                                                         skel.redistributeDevasEvenly(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), redistributeDevasEvenlyResponse14, false);
                                    } else 

            if("getVEUnavailability".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse getVEUnavailabilityResponse16 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVEUnavailabilityResponse16 =
                                                   
                                                   
                                                         skel.getVEUnavailability(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVEUnavailabilityResponse16, false);
                                    } else 

            if("cancelScheduledVE".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse cancelScheduledVEResponse18 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelScheduledVEResponse18 =
                                                   
                                                   
                                                         skel.cancelScheduledVE(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelScheduledVEResponse18, false);
                                    } else 

            if("getStorageList".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse getStorageListResponse20 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getStorageListResponse20 =
                                                   
                                                   
                                                         skel.getStorageList(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getStorageListResponse20, false);
                                    } else 

            if("delStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse delStorageResponse22 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               delStorageResponse22 =
                                                   
                                                   
                                                         skel.delStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), delStorageResponse22, false);
                                    } else 

            if("getVEInsSchedule".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse getVEInsScheduleResponse24 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVEInsScheduleResponse24 =
                                                   
                                                   
                                                         skel.getVEInsSchedule(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVEInsScheduleResponse24, false);
                                    } else 

            if("setHostStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse setHostStorageResponse26 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setHostStorageResponse26 =
                                                   
                                                   
                                                         skel.setHostStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setHostStorageResponse26, false);
                                    } else 

            if("delVEIns".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse delVEInsResponse28 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               delVEInsResponse28 =
                                                   
                                                   
                                                         skel.delVEIns(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), delVEInsResponse28, false);
                                    } else 

            if("getHost".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse getHostResponse30 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostResponse30 =
                                                   
                                                   
                                                         skel.getHost(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostResponse30, false);
                                    } else 

            if("delKaseyaAccount".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse delKaseyaAccountResponse32 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               delKaseyaAccountResponse32 =
                                                   
                                                   
                                                         skel.delKaseyaAccount(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), delKaseyaAccountResponse32, false);
                                    } else 

            if("getHostStorageList".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse getHostStorageListResponse34 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostStorageListResponse34 =
                                                   
                                                   
                                                         skel.getHostStorageList(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostStorageListResponse34, false);
                                    } else 

            if("setHost".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse setHostResponse36 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setHostResponse36 =
                                                   
                                                   
                                                         skel.setHost(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setHostResponse36, false);
                                    } else 

            if("reserveResource".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse reserveResourceResponse38 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               reserveResourceResponse38 =
                                                   
                                                   
                                                         skel.reserveResource(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), reserveResourceResponse38, false);
                                    } else 

            if("scheduleHostMaintenance".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse scheduleHostMaintenanceResponse40 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               scheduleHostMaintenanceResponse40 =
                                                   
                                                   
                                                         skel.scheduleHostMaintenance(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), scheduleHostMaintenanceResponse40, false);
                                    } else 

            if("getVEInsIdUsingMac".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse getVEInsIdUsingMacResponse42 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVEInsIdUsingMacResponse42 =
                                                   
                                                   
                                                         skel.getVEInsIdUsingMac(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVEInsIdUsingMacResponse42, false);
                                    } else 

            if("getHostMaintenanceSchedule".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse getHostMaintenanceScheduleResponse44 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostMaintenanceScheduleResponse44 =
                                                   
                                                   
                                                         skel.getHostMaintenanceSchedule(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostMaintenanceScheduleResponse44, false);
                                    } else 

            if("modifyScheduledHostMaintenance".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse modifyScheduledHostMaintenanceResponse46 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               modifyScheduledHostMaintenanceResponse46 =
                                                   
                                                   
                                                         skel.modifyScheduledHostMaintenance(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), modifyScheduledHostMaintenanceResponse46, false);
                                    } else 

            if("addStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse addStorageResponse48 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addStorageResponse48 =
                                                   
                                                   
                                                         skel.addStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addStorageResponse48, false);
                                    } else 

            if("getEndDate4CurrentDevaIns".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse getEndDate4CurrentDevaInsResponse50 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getEndDate4CurrentDevaInsResponse50 =
                                                   
                                                   
                                                         skel.getEndDate4CurrentDevaIns(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getEndDate4CurrentDevaInsResponse50, false);
                                    } else 

            if("getHostStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse getHostStorageResponse52 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostStorageResponse52 =
                                                   
                                                   
                                                         skel.getHostStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostStorageResponse52, false);
                                    } else 

            if("delHostStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse delHostStorageResponse54 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               delHostStorageResponse54 =
                                                   
                                                   
                                                         skel.delHostStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), delHostStorageResponse54, false);
                                    } else 

            if("getDevaInsInfo".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse getDevaInsInfoResponse56 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getDevaInsInfoResponse56 =
                                                   
                                                   
                                                         skel.getDevaInsInfo(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getDevaInsInfoResponse56, false);
                                    } else 

            if("getHostMaintenanceUnavailability".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse getHostMaintenanceUnavailabilityResponse58 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostMaintenanceUnavailabilityResponse58 =
                                                   
                                                   
                                                         skel.getHostMaintenanceUnavailability(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostMaintenanceUnavailabilityResponse58, false);
                                    } else 

            if("getStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse getStorageResponse60 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getStorageResponse60 =
                                                   
                                                   
                                                         skel.getStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getStorageResponse60, false);
                                    } else 

            if("setStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse setStorageResponse62 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setStorageResponse62 =
                                                   
                                                   
                                                         skel.setStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setStorageResponse62, false);
                                    } else 

            if("destroyDevaIns".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse destroyDevaInsResponse64 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               destroyDevaInsResponse64 =
                                                   
                                                   
                                                         skel.destroyDevaIns(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), destroyDevaInsResponse64, false);
                                    } else 

            if("checkin".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse checkinResponse66 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               checkinResponse66 =
                                                   
                                                   
                                                         skel.checkin(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), checkinResponse66, false);
                                    } else 

            if("refreshVM".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse refreshVMResponse68 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               refreshVMResponse68 =
                                                   
                                                   
                                                         skel.refreshVM(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), refreshVMResponse68, false);
                                    } else 

            if("addHostStorage".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse addHostStorageResponse70 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addHostStorageResponse70 =
                                                   
                                                   
                                                         skel.addHostStorage(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addHostStorageResponse70, false);
                                    } else 

            if("scheduleVE".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse scheduleVEResponse72 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               scheduleVEResponse72 =
                                                   
                                                   
                                                         skel.scheduleVE(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), scheduleVEResponse72, false);
                                    } else 

            if("getVEInsScheduleBySchId".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse getVEInsScheduleBySchIdResponse74 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVEInsScheduleBySchIdResponse74 =
                                                   
                                                   
                                                         skel.getVEInsScheduleBySchId(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVEInsScheduleBySchIdResponse74, false);
                                    } else 

            if("disableKaseyaAccount".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse disableKaseyaAccountResponse76 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               disableKaseyaAccountResponse76 =
                                                   
                                                   
                                                         skel.disableKaseyaAccount(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), disableKaseyaAccountResponse76, false);
                                    } else 

            if("modifyScheduledVE".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse modifyScheduledVEResponse78 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               modifyScheduledVEResponse78 =
                                                   
                                                   
                                                         skel.modifyScheduledVE(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), modifyScheduledVEResponse78, false);
                                    } else 

            if("getVMInsInfo".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse getVMInsInfoResponse80 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVMInsInfoResponse80 =
                                                   
                                                   
                                                         skel.getVMInsInfo(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVMInsInfoResponse80, false);
                                    } else 

            if("getVEMacs".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse getVEMacsResponse82 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVEMacsResponse82 =
                                                   
                                                   
                                                         skel.getVEMacs(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVEMacsResponse82, false);
                                    } else 

            if("addHost".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse addHostResponse84 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addHostResponse84 =
                                                   
                                                   
                                                         skel.addHost(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addHostResponse84, false);
                                    } else 

            if("getConfiguration".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse getConfigurationResponse86 = null;
	                        getConfigurationResponse86 =
                                                     
                                                 skel.getConfiguration()
                                                ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getConfigurationResponse86, false);
                                    } else 

            if("delKaseyaAccounts".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse delKaseyaAccountsResponse88 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               delKaseyaAccountsResponse88 =
                                                   
                                                   
                                                         skel.delKaseyaAccounts(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), delKaseyaAccountsResponse88, false);
                                    } else 

            if("getHostList".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse getHostListResponse90 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostListResponse90 =
                                                   
                                                   
                                                         skel.getHostList(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostListResponse90, false);
                                    } else 

            if("getVEAvailability".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse getVEAvailabilityResponse92 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVEAvailabilityResponse92 =
                                                   
                                                   
                                                         skel.getVEAvailability(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVEAvailabilityResponse92, false);
                                    } else 

            if("getVMMac".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse getVMMacResponse94 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getVMMacResponse94 =
                                                   
                                                   
                                                         skel.getVMMac(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getVMMacResponse94, false);
                                    } else 

            if("getHostMaintenanceAvailability".equals(methodName)){
                
                edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse getHostMaintenanceAvailabilityResponse96 = null;
	                        edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest wrappedParam =
                                                             (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getHostMaintenanceAvailabilityResponse96 =
                                                   
                                                   
                                                         skel.getHostMaintenanceAvailability(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getHostMaintenanceAvailabilityResponse96, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse wrapgetHostUsingName(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse wraprunVMCmd(){
                                edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse wrapcancelScheduledHostMaintenance(){
                                edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse wrapsetConfiguration(){
                                edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse wrapgetVEInsCurSchedule(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse wrapdelHost(){
                                edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse wrapredistributeDevasEvenly(){
                                edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse wrapgetVEUnavailability(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse wrapcancelScheduledVE(){
                                edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse wrapgetStorageList(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse wrapdelStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse wrapgetVEInsSchedule(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse wrapsetHostStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse wrapdelVEIns(){
                                edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse wrapgetHost(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse wrapdelKaseyaAccount(){
                                edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse wrapgetHostStorageList(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse wrapsetHost(){
                                edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse wrapreserveResource(){
                                edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse wrapscheduleHostMaintenance(){
                                edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse wrapgetVEInsIdUsingMac(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse wrapgetHostMaintenanceSchedule(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse wrapmodifyScheduledHostMaintenance(){
                                edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse wrapaddStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse wrapgetEndDate4CurrentDevaIns(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse wrapgetHostStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse wrapdelHostStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse wrapgetDevaInsInfo(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse wrapgetHostMaintenanceUnavailability(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse wrapgetStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse wrapsetStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse wrapdestroyDevaIns(){
                                edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse wrapcheckin(){
                                edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse wraprefreshVM(){
                                edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse wrapaddHostStorage(){
                                edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse wrapscheduleVE(){
                                edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse wrapgetVEInsScheduleBySchId(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse wrapdisableKaseyaAccount(){
                                edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse wrapmodifyScheduledVE(){
                                edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse wrapgetVMInsInfo(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse wrapgetVEMacs(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse wrapaddHost(){
                                edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse wrapgetConfiguration(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse wrapdelKaseyaAccounts(){
                                edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse wrapgetHostList(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse wrapgetVEAvailability(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse wrapgetVMMac(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse wrapgetHostMaintenanceAvailability(){
                                edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse wrappedElement = new edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse();
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
        
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelHostRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVERequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetStorageListRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelVEInsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetHostRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.AddStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.CheckinRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.RefreshVMRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ScheduleVERequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVERequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.AddHostRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostListRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVMMacRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse.class.equals(type)){
                
                           return edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
    