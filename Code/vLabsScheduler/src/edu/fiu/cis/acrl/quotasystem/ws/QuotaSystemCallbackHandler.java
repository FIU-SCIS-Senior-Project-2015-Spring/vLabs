
/**
 * QuotaSystemCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package edu.fiu.cis.acrl.quotasystem.ws;

    /**
     *  QuotaSystemCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class QuotaSystemCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public QuotaSystemCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public QuotaSystemCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for addCreditType method
            * override this method for handling normal response from addCreditType operation
            */
           public void receiveResultaddCreditType(
                    edu.fiu.cis.acrl.quotasystem.ws.AddCreditTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addCreditType operation
           */
            public void receiveErroraddCreditType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentPeriodQuotaSummary method
            * override this method for handling normal response from getCurrentPeriodQuotaSummary operation
            */
           public void receiveResultgetCurrentPeriodQuotaSummary(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentPeriodQuotaSummary operation
           */
            public void receiveErrorgetCurrentPeriodQuotaSummary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricQuotaSummaryPerPeriods method
            * override this method for handling normal response from getHistoricQuotaSummaryPerPeriods operation
            */
           public void receiveResultgetHistoricQuotaSummaryPerPeriods(
                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerPeriodsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricQuotaSummaryPerPeriods operation
           */
            public void receiveErrorgetHistoricQuotaSummaryPerPeriods(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteCreditType method
            * override this method for handling normal response from deleteCreditType operation
            */
           public void receiveResultdeleteCreditType(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCreditType operation
           */
            public void receiveErrordeleteCreditType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentPeriodQuotaSummaryByCreditType method
            * override this method for handling normal response from getCurrentPeriodQuotaSummaryByCreditType operation
            */
           public void receiveResultgetCurrentPeriodQuotaSummaryByCreditType(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByCreditTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentPeriodQuotaSummaryByCreditType operation
           */
            public void receiveErrorgetCurrentPeriodQuotaSummaryByCreditType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCourses method
            * override this method for handling normal response from getCourses operation
            */
           public void receiveResultgetCourses(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCoursesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCourses operation
           */
            public void receiveErrorgetCourses(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAssignablePolicies method
            * override this method for handling normal response from getAssignablePolicies operation
            */
           public void receiveResultgetAssignablePolicies(
                    edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAssignablePolicies operation
           */
            public void receiveErrorgetAssignablePolicies(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enrollUser method
            * override this method for handling normal response from enrollUser operation
            */
           public void receiveResultenrollUser(
                    edu.fiu.cis.acrl.quotasystem.ws.EnrollUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enrollUser operation
           */
            public void receiveErrorenrollUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for syncUsersAndCourses method
            * override this method for handling normal response from syncUsersAndCourses operation
            */
           public void receiveResultsyncUsersAndCourses(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from syncUsersAndCourses operation
           */
            public void receiveErrorsyncUsersAndCourses(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyUser method
            * override this method for handling normal response from modifyUser operation
            */
           public void receiveResultmodifyUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyUser operation
           */
            public void receiveErrormodifyUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricQuotaSummaryByUserAndCreditType method
            * override this method for handling normal response from getHistoricQuotaSummaryByUserAndCreditType operation
            */
           public void receiveResultgetHistoricQuotaSummaryByUserAndCreditType(
                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserAndCreditTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricQuotaSummaryByUserAndCreditType operation
           */
            public void receiveErrorgetHistoricQuotaSummaryByUserAndCreditType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelQuotaAssignments method
            * override this method for handling normal response from cancelQuotaAssignments operation
            */
           public void receiveResultcancelQuotaAssignments(
                    edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelQuotaAssignments operation
           */
            public void receiveErrorcancelQuotaAssignments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCreditTypeById method
            * override this method for handling normal response from getCreditTypeById operation
            */
           public void receiveResultgetCreditTypeById(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypeByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCreditTypeById operation
           */
            public void receiveErrorgetCreditTypeById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyPolicy method
            * override this method for handling normal response from modifyPolicy operation
            */
           public void receiveResultmodifyPolicy(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyPolicy operation
           */
            public void receiveErrormodifyPolicy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteUser method
            * override this method for handling normal response from deleteUser operation
            */
           public void receiveResultdeleteUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteUser operation
           */
            public void receiveErrordeleteUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for scheduleAppointments method
            * override this method for handling normal response from scheduleAppointments operation
            */
           public void receiveResultscheduleAppointments(
                    edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from scheduleAppointments operation
           */
            public void receiveErrorscheduleAppointments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteCourse method
            * override this method for handling normal response from deleteCourse operation
            */
           public void receiveResultdeleteCourse(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCourse operation
           */
            public void receiveErrordeleteCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricQuotaSummary method
            * override this method for handling normal response from getHistoricQuotaSummary operation
            */
           public void receiveResultgetHistoricQuotaSummary(
                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricQuotaSummary operation
           */
            public void receiveErrorgetHistoricQuotaSummary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for doesUserHaveAvailableQuota method
            * override this method for handling normal response from doesUserHaveAvailableQuota operation
            */
           public void receiveResultdoesUserHaveAvailableQuota(
                    edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from doesUserHaveAvailableQuota operation
           */
            public void receiveErrordoesUserHaveAvailableQuota(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCreditTypesByCourse method
            * override this method for handling normal response from getCreditTypesByCourse operation
            */
           public void receiveResultgetCreditTypesByCourse(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByCourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCreditTypesByCourse operation
           */
            public void receiveErrorgetCreditTypesByCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentPeriodQuotaSummaryByUserAndCourse method
            * override this method for handling normal response from getCurrentPeriodQuotaSummaryByUserAndCourse operation
            */
           public void receiveResultgetCurrentPeriodQuotaSummaryByUserAndCourse(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserAndCourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentPeriodQuotaSummaryByUserAndCourse operation
           */
            public void receiveErrorgetCurrentPeriodQuotaSummaryByUserAndCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPolicies method
            * override this method for handling normal response from getPolicies operation
            */
           public void receiveResultgetPolicies(
                    edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPolicies operation
           */
            public void receiveErrorgetPolicies(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyCreditType method
            * override this method for handling normal response from modifyCreditType operation
            */
           public void receiveResultmodifyCreditType(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyCreditType operation
           */
            public void receiveErrormodifyCreditType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCreditTypesByUser method
            * override this method for handling normal response from getCreditTypesByUser operation
            */
           public void receiveResultgetCreditTypesByUser(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCreditTypesByUser operation
           */
            public void receiveErrorgetCreditTypesByUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentPeriodQuotaSummaryByUser method
            * override this method for handling normal response from getCurrentPeriodQuotaSummaryByUser operation
            */
           public void receiveResultgetCurrentPeriodQuotaSummaryByUser(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCurrentPeriodQuotaSummaryByUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentPeriodQuotaSummaryByUser operation
           */
            public void receiveErrorgetCurrentPeriodQuotaSummaryByUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyAppointment method
            * override this method for handling normal response from modifyAppointment operation
            */
           public void receiveResultmodifyAppointment(
                    edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyAppointment operation
           */
            public void receiveErrormodifyAppointment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsers method
            * override this method for handling normal response from getUsers operation
            */
           public void receiveResultgetUsers(
                    edu.fiu.cis.acrl.quotasystem.ws.GetUsersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsers operation
           */
            public void receiveErrorgetUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPolicyById method
            * override this method for handling normal response from getPolicyById operation
            */
           public void receiveResultgetPolicyById(
                    edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPolicyById operation
           */
            public void receiveErrorgetPolicyById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelAppointment method
            * override this method for handling normal response from cancelAppointment operation
            */
           public void receiveResultcancelAppointment(
                    edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelAppointment operation
           */
            public void receiveErrorcancelAppointment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCreditTypes method
            * override this method for handling normal response from getCreditTypes operation
            */
           public void receiveResultgetCreditTypes(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCreditTypes operation
           */
            public void receiveErrorgetCreditTypes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCreditTypesByPolicy method
            * override this method for handling normal response from getCreditTypesByPolicy operation
            */
           public void receiveResultgetCreditTypesByPolicy(
                    edu.fiu.cis.acrl.quotasystem.ws.GetCreditTypesByPolicyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCreditTypesByPolicy operation
           */
            public void receiveErrorgetCreditTypesByPolicy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPolicyByCreditType method
            * override this method for handling normal response from getPolicyByCreditType operation
            */
           public void receiveResultgetPolicyByCreditType(
                    edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByCreditTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPolicyByCreditType operation
           */
            public void receiveErrorgetPolicyByCreditType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addPolicy method
            * override this method for handling normal response from addPolicy operation
            */
           public void receiveResultaddPolicy(
                    edu.fiu.cis.acrl.quotasystem.ws.AddPolicyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addPolicy operation
           */
            public void receiveErroraddPolicy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelCourseQuota method
            * override this method for handling normal response from cancelCourseQuota operation
            */
           public void receiveResultcancelCourseQuota(
                    edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelCourseQuota operation
           */
            public void receiveErrorcancelCourseQuota(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAssignableCreditTypes method
            * override this method for handling normal response from getAssignableCreditTypes operation
            */
           public void receiveResultgetAssignableCreditTypes(
                    edu.fiu.cis.acrl.quotasystem.ws.GetAssignableCreditTypesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAssignableCreditTypes operation
           */
            public void receiveErrorgetAssignableCreditTypes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyCourseQuota method
            * override this method for handling normal response from modifyCourseQuota operation
            */
           public void receiveResultmodifyCourseQuota(
                    edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyCourseQuota operation
           */
            public void receiveErrormodifyCourseQuota(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for assignQuota method
            * override this method for handling normal response from assignQuota operation
            */
           public void receiveResultassignQuota(
                    edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from assignQuota operation
           */
            public void receiveErrorassignQuota(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for unenrollUser method
            * override this method for handling normal response from unenrollUser operation
            */
           public void receiveResultunenrollUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from unenrollUser operation
           */
            public void receiveErrorunenrollUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addCourse method
            * override this method for handling normal response from addCourse operation
            */
           public void receiveResultaddCourse(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addCourse operation
           */
            public void receiveErroraddCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelAllAppointments method
            * override this method for handling normal response from cancelAllAppointments operation
            */
           public void receiveResultcancelAllAppointments(
                    edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelAllAppointments operation
           */
            public void receiveErrorcancelAllAppointments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deletePolicy method
            * override this method for handling normal response from deletePolicy operation
            */
           public void receiveResultdeletePolicy(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deletePolicy operation
           */
            public void receiveErrordeletePolicy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsersByCourse method
            * override this method for handling normal response from getUsersByCourse operation
            */
           public void receiveResultgetUsersByCourse(
                    edu.fiu.cis.acrl.quotasystem.ws.GetUsersByCourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsersByCourse operation
           */
            public void receiveErrorgetUsersByCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyCourse method
            * override this method for handling normal response from modifyCourse operation
            */
           public void receiveResultmodifyCourse(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyCourse operation
           */
            public void receiveErrormodifyCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for assignQuotaToCourse method
            * override this method for handling normal response from assignQuotaToCourse operation
            */
           public void receiveResultassignQuotaToCourse(
                    edu.fiu.cis.acrl.quotasystem.ws.AssignQuotaToCourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from assignQuotaToCourse operation
           */
            public void receiveErrorassignQuotaToCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUser method
            * override this method for handling normal response from addUser operation
            */
           public void receiveResultaddUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUser operation
           */
            public void receiveErroraddUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricQuotaSummaryPerUsers method
            * override this method for handling normal response from getHistoricQuotaSummaryPerUsers operation
            */
           public void receiveResultgetHistoricQuotaSummaryPerUsers(
                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryPerUsersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricQuotaSummaryPerUsers operation
           */
            public void receiveErrorgetHistoricQuotaSummaryPerUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoricQuotaSummaryByUser method
            * override this method for handling normal response from getHistoricQuotaSummaryByUser operation
            */
           public void receiveResultgetHistoricQuotaSummaryByUser(
                    edu.fiu.cis.acrl.quotasystem.ws.GetHistoricQuotaSummaryByUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoricQuotaSummaryByUser operation
           */
            public void receiveErrorgetHistoricQuotaSummaryByUser(java.lang.Exception e) {
            }
                


    }
    