
/**
 * VESchedulerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */

    package edu.fiu.cis.acrl.vescheduler.ws;

    /**
     *  VESchedulerCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class VESchedulerCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public VESchedulerCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public VESchedulerCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getHostUsingName method
            * override this method for handling normal response from getHostUsingName operation
            */
           public void receiveResultgetHostUsingName(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostUsingNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHostUsingName operation
           */
            public void receiveErrorgetHostUsingName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for runVMCmd method
            * override this method for handling normal response from runVMCmd operation
            */
           public void receiveResultrunVMCmd(
                    edu.fiu.cis.acrl.vescheduler.ws.RunVMCmdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from runVMCmd operation
           */
            public void receiveErrorrunVMCmd(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelScheduledHostMaintenance method
            * override this method for handling normal response from cancelScheduledHostMaintenance operation
            */
           public void receiveResultcancelScheduledHostMaintenance(
                    edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledHostMaintenanceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelScheduledHostMaintenance operation
           */
            public void receiveErrorcancelScheduledHostMaintenance(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setConfiguration method
            * override this method for handling normal response from setConfiguration operation
            */
           public void receiveResultsetConfiguration(
                    edu.fiu.cis.acrl.vescheduler.ws.SetConfigurationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setConfiguration operation
           */
            public void receiveErrorsetConfiguration(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVEInsCurSchedule method
            * override this method for handling normal response from getVEInsCurSchedule operation
            */
           public void receiveResultgetVEInsCurSchedule(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsCurScheduleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVEInsCurSchedule operation
           */
            public void receiveErrorgetVEInsCurSchedule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for delHost method
            * override this method for handling normal response from delHost operation
            */
           public void receiveResultdelHost(
                    edu.fiu.cis.acrl.vescheduler.ws.DelHostResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from delHost operation
           */
            public void receiveErrordelHost(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for redistributeDevasEvenly method
            * override this method for handling normal response from redistributeDevasEvenly operation
            */
           public void receiveResultredistributeDevasEvenly(
                    edu.fiu.cis.acrl.vescheduler.ws.RedistributeDevasEvenlyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from redistributeDevasEvenly operation
           */
            public void receiveErrorredistributeDevasEvenly(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVEUnavailability method
            * override this method for handling normal response from getVEUnavailability operation
            */
           public void receiveResultgetVEUnavailability(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVEUnavailabilityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVEUnavailability operation
           */
            public void receiveErrorgetVEUnavailability(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelScheduledVE method
            * override this method for handling normal response from cancelScheduledVE operation
            */
           public void receiveResultcancelScheduledVE(
                    edu.fiu.cis.acrl.vescheduler.ws.CancelScheduledVEResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelScheduledVE operation
           */
            public void receiveErrorcancelScheduledVE(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getStorageList method
            * override this method for handling normal response from getStorageList operation
            */
           public void receiveResultgetStorageList(
                    edu.fiu.cis.acrl.vescheduler.ws.GetStorageListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getStorageList operation
           */
            public void receiveErrorgetStorageList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for delStorage method
            * override this method for handling normal response from delStorage operation
            */
           public void receiveResultdelStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.DelStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from delStorage operation
           */
            public void receiveErrordelStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVEInsSchedule method
            * override this method for handling normal response from getVEInsSchedule operation
            */
           public void receiveResultgetVEInsSchedule(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVEInsSchedule operation
           */
            public void receiveErrorgetVEInsSchedule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setHostStorage method
            * override this method for handling normal response from setHostStorage operation
            */
           public void receiveResultsetHostStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.SetHostStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setHostStorage operation
           */
            public void receiveErrorsetHostStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for delVEIns method
            * override this method for handling normal response from delVEIns operation
            */
           public void receiveResultdelVEIns(
                    edu.fiu.cis.acrl.vescheduler.ws.DelVEInsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from delVEIns operation
           */
            public void receiveErrordelVEIns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHost method
            * override this method for handling normal response from getHost operation
            */
           public void receiveResultgetHost(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHost operation
           */
            public void receiveErrorgetHost(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for delKaseyaAccount method
            * override this method for handling normal response from delKaseyaAccount operation
            */
           public void receiveResultdelKaseyaAccount(
                    edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from delKaseyaAccount operation
           */
            public void receiveErrordelKaseyaAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHostStorageList method
            * override this method for handling normal response from getHostStorageList operation
            */
           public void receiveResultgetHostStorageList(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHostStorageList operation
           */
            public void receiveErrorgetHostStorageList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setHost method
            * override this method for handling normal response from setHost operation
            */
           public void receiveResultsetHost(
                    edu.fiu.cis.acrl.vescheduler.ws.SetHostResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setHost operation
           */
            public void receiveErrorsetHost(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reserveResource method
            * override this method for handling normal response from reserveResource operation
            */
           public void receiveResultreserveResource(
                    edu.fiu.cis.acrl.vescheduler.ws.ReserveResourceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reserveResource operation
           */
            public void receiveErrorreserveResource(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for scheduleHostMaintenance method
            * override this method for handling normal response from scheduleHostMaintenance operation
            */
           public void receiveResultscheduleHostMaintenance(
                    edu.fiu.cis.acrl.vescheduler.ws.ScheduleHostMaintenanceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from scheduleHostMaintenance operation
           */
            public void receiveErrorscheduleHostMaintenance(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVEInsIdUsingMac method
            * override this method for handling normal response from getVEInsIdUsingMac operation
            */
           public void receiveResultgetVEInsIdUsingMac(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsIdUsingMacResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVEInsIdUsingMac operation
           */
            public void receiveErrorgetVEInsIdUsingMac(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHostMaintenanceSchedule method
            * override this method for handling normal response from getHostMaintenanceSchedule operation
            */
           public void receiveResultgetHostMaintenanceSchedule(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceScheduleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHostMaintenanceSchedule operation
           */
            public void receiveErrorgetHostMaintenanceSchedule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyScheduledHostMaintenance method
            * override this method for handling normal response from modifyScheduledHostMaintenance operation
            */
           public void receiveResultmodifyScheduledHostMaintenance(
                    edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledHostMaintenanceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyScheduledHostMaintenance operation
           */
            public void receiveErrormodifyScheduledHostMaintenance(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addStorage method
            * override this method for handling normal response from addStorage operation
            */
           public void receiveResultaddStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.AddStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addStorage operation
           */
            public void receiveErroraddStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEndDate4CurrentDevaIns method
            * override this method for handling normal response from getEndDate4CurrentDevaIns operation
            */
           public void receiveResultgetEndDate4CurrentDevaIns(
                    edu.fiu.cis.acrl.vescheduler.ws.GetEndDate4CurrentDevaInsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEndDate4CurrentDevaIns operation
           */
            public void receiveErrorgetEndDate4CurrentDevaIns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHostStorage method
            * override this method for handling normal response from getHostStorage operation
            */
           public void receiveResultgetHostStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHostStorage operation
           */
            public void receiveErrorgetHostStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for delHostStorage method
            * override this method for handling normal response from delHostStorage operation
            */
           public void receiveResultdelHostStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.DelHostStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from delHostStorage operation
           */
            public void receiveErrordelHostStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDevaInsInfo method
            * override this method for handling normal response from getDevaInsInfo operation
            */
           public void receiveResultgetDevaInsInfo(
                    edu.fiu.cis.acrl.vescheduler.ws.GetDevaInsInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDevaInsInfo operation
           */
            public void receiveErrorgetDevaInsInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHostMaintenanceUnavailability method
            * override this method for handling normal response from getHostMaintenanceUnavailability operation
            */
           public void receiveResultgetHostMaintenanceUnavailability(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceUnavailabilityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHostMaintenanceUnavailability operation
           */
            public void receiveErrorgetHostMaintenanceUnavailability(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getStorage method
            * override this method for handling normal response from getStorage operation
            */
           public void receiveResultgetStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.GetStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getStorage operation
           */
            public void receiveErrorgetStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setStorage method
            * override this method for handling normal response from setStorage operation
            */
           public void receiveResultsetStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.SetStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setStorage operation
           */
            public void receiveErrorsetStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for destroyDevaIns method
            * override this method for handling normal response from destroyDevaIns operation
            */
           public void receiveResultdestroyDevaIns(
                    edu.fiu.cis.acrl.vescheduler.ws.DestroyDevaInsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from destroyDevaIns operation
           */
            public void receiveErrordestroyDevaIns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkin method
            * override this method for handling normal response from checkin operation
            */
           public void receiveResultcheckin(
                    edu.fiu.cis.acrl.vescheduler.ws.CheckinResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkin operation
           */
            public void receiveErrorcheckin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for refreshVM method
            * override this method for handling normal response from refreshVM operation
            */
           public void receiveResultrefreshVM(
                    edu.fiu.cis.acrl.vescheduler.ws.RefreshVMResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from refreshVM operation
           */
            public void receiveErrorrefreshVM(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addHostStorage method
            * override this method for handling normal response from addHostStorage operation
            */
           public void receiveResultaddHostStorage(
                    edu.fiu.cis.acrl.vescheduler.ws.AddHostStorageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addHostStorage operation
           */
            public void receiveErroraddHostStorage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for scheduleVE method
            * override this method for handling normal response from scheduleVE operation
            */
           public void receiveResultscheduleVE(
                    edu.fiu.cis.acrl.vescheduler.ws.ScheduleVEResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from scheduleVE operation
           */
            public void receiveErrorscheduleVE(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVEInsScheduleBySchId method
            * override this method for handling normal response from getVEInsScheduleBySchId operation
            */
           public void receiveResultgetVEInsScheduleBySchId(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVEInsScheduleBySchIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVEInsScheduleBySchId operation
           */
            public void receiveErrorgetVEInsScheduleBySchId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disableKaseyaAccount method
            * override this method for handling normal response from disableKaseyaAccount operation
            */
           public void receiveResultdisableKaseyaAccount(
                    edu.fiu.cis.acrl.vescheduler.ws.DisableKaseyaAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disableKaseyaAccount operation
           */
            public void receiveErrordisableKaseyaAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyScheduledVE method
            * override this method for handling normal response from modifyScheduledVE operation
            */
           public void receiveResultmodifyScheduledVE(
                    edu.fiu.cis.acrl.vescheduler.ws.ModifyScheduledVEResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyScheduledVE operation
           */
            public void receiveErrormodifyScheduledVE(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVMInsInfo method
            * override this method for handling normal response from getVMInsInfo operation
            */
           public void receiveResultgetVMInsInfo(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVMInsInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVMInsInfo operation
           */
            public void receiveErrorgetVMInsInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVEMacs method
            * override this method for handling normal response from getVEMacs operation
            */
           public void receiveResultgetVEMacs(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVEMacsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVEMacs operation
           */
            public void receiveErrorgetVEMacs(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addHost method
            * override this method for handling normal response from addHost operation
            */
           public void receiveResultaddHost(
                    edu.fiu.cis.acrl.vescheduler.ws.AddHostResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addHost operation
           */
            public void receiveErroraddHost(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getConfiguration method
            * override this method for handling normal response from getConfiguration operation
            */
           public void receiveResultgetConfiguration(
                    edu.fiu.cis.acrl.vescheduler.ws.GetConfigurationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getConfiguration operation
           */
            public void receiveErrorgetConfiguration(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for delKaseyaAccounts method
            * override this method for handling normal response from delKaseyaAccounts operation
            */
           public void receiveResultdelKaseyaAccounts(
                    edu.fiu.cis.acrl.vescheduler.ws.DelKaseyaAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from delKaseyaAccounts operation
           */
            public void receiveErrordelKaseyaAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHostList method
            * override this method for handling normal response from getHostList operation
            */
           public void receiveResultgetHostList(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHostList operation
           */
            public void receiveErrorgetHostList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVEAvailability method
            * override this method for handling normal response from getVEAvailability operation
            */
           public void receiveResultgetVEAvailability(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVEAvailabilityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVEAvailability operation
           */
            public void receiveErrorgetVEAvailability(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVMMac method
            * override this method for handling normal response from getVMMac operation
            */
           public void receiveResultgetVMMac(
                    edu.fiu.cis.acrl.vescheduler.ws.GetVMMacResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVMMac operation
           */
            public void receiveErrorgetVMMac(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHostMaintenanceAvailability method
            * override this method for handling normal response from getHostMaintenanceAvailability operation
            */
           public void receiveResultgetHostMaintenanceAvailability(
                    edu.fiu.cis.acrl.vescheduler.ws.GetHostMaintenanceAvailabilityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHostMaintenanceAvailability operation
           */
            public void receiveErrorgetHostMaintenanceAvailability(java.lang.Exception e) {
            }
                


    }
    