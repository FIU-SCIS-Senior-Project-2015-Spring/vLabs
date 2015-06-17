/*
 * Main interface for the QS Web Service Subsystem
 * This is the interface that receives all the requests and delegates their processing to the QuotaSystem singelton
 */
package edu.fiu.cis.acrl.quotasystem.ws;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.engine.ServiceLifeCycle;

import edu.fiu.cis.acrl.quotasystem.server.*;
import edu.fiu.cis.acrl.quotasystem.ws.CourseNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicateCourseFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicateCreditTypeFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicatePolicyFault;
import edu.fiu.cis.acrl.quotasystem.ws.DuplicateUserFault;
import edu.fiu.cis.acrl.quotasystem.ws.EnrollmentNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault;
import edu.fiu.cis.acrl.quotasystem.ws.PolicyNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault;

public class QuotaSystemSkeleton implements ServiceLifeCycle {

	//QuotaSystem singleton, it contains all the business logic and access to the storage layer
	private QuotaSystem quotasystem = null;

	public QuotaSystemSkeleton() {
		quotasystem = QuotaSystem.instance();
	}

//***********************************************************
//					Policy Management
//***********************************************************

	/*
	 * Add a policy to the Quota System.
	 * @param addPolicyRequest this object is defined in the wsdl and it contains a complete policy
	 * @return addPolicyResponse
	 * @exception InvalidDataFault raised if any parameter inside addPolicyRequest is wrong
	 * @exception DuplicatePolicyFault raised if the policy being added has the same name as one that already exists
	 */
	public AddPolicyResponse addPolicy(AddPolicyRequest addPolicyRequest)
			throws InvalidDataFault, DuplicatePolicyFault {
		return quotasystem.addPolicy(addPolicyRequest);
	}

	/*
	 * Modify a policy in the Quota System. This method will modify the policy whose id matches the one in modifyPolicyRequest
	 * @param modifyPolicyRequest policy to be modified
	 * @return void
	 * @exception PolicyNotFoundFault raised if no policy was found with the id in the modifyPolicyRequest object
	 * @exception InvalidDataFault raised if any parameter inside modifyPolicyRequest is wrong
	 * @exception DuplicatePolicyFault raised if the policy being modified has the same name as one that already exists
	 */
	public void modifyPolicy(ModifyPolicyRequest modifyPolicyRequest)
			throws PolicyNotFoundFault, InvalidDataFault, DuplicatePolicyFault {
		quotasystem.modifyPolicy(modifyPolicyRequest);
	}

	/*
	 * Delete a policy in the Quota System. This method will delete the policy whose id matches the one in modifyPolicyRequest. A policy can only be deleted if it is inactive.
	 * @param deletePolicyRequest policy to be deleted
	 * @return void
	 * @exception PolicyNotFoundFault raised if no policy was found with the id in the deletePolicyRequest object
	 */
	public void deletePolicy(DeletePolicyRequest deletePolicyRequest)
			throws PolicyNotFoundFault {
		quotasystem.deletePolicy(deletePolicyRequest);
	}

	/*
	 * Returns all the policies in the QuotaSystem where assignable==true
	 * @return GetAssignablePoliciesResponse array of assignable policies
	 */
	public GetAssignablePoliciesResponse getAssignablePolicies(
			edu.fiu.cis.acrl.quotasystem.ws.GetAssignablePoliciesRequest getAssignablePoliciesRequest		
	) {
		return quotasystem.getAssignablePolicies(getAssignablePoliciesRequest);
	}

	/*
	 * Returns all the policies in the QuotaSystem
	 * @return GetPoliciesResponse array of policies
	 */
	public GetPoliciesResponse getPolicies(
            edu.fiu.cis.acrl.quotasystem.ws.GetPoliciesRequest getPoliciesRequest		
	) {
		return quotasystem.getPolicies(getPoliciesRequest);
	}

	/*
	 * Get the policy that is assigned to the credit type inside getPolicyByCreditTypeRequest
	 * @param getPolicyByCreditTypeRequest credit type id
	 * @return GetPolicyByCreditTypeResponse policy that is assigned to the received credit type
	 * @exception CreditTypeNotFoundFault raised if no credit type was found with the specified id
	 */
	public GetPolicyByCreditTypeResponse getPolicyByCreditType(
			GetPolicyByCreditTypeRequest getPolicyByCreditTypeRequest)
			throws CreditTypeNotFoundFault {
		return quotasystem.getPolicyByCreditType(getPolicyByCreditTypeRequest);
	}

    public edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdResponse getPolicyById
    (
    edu.fiu.cis.acrl.quotasystem.ws.GetPolicyByIdRequest getPolicyByIdRequest
    )
	{
	  return quotasystem.getPolicyById(getPolicyByIdRequest);
	}

//***********************************************************
//					Credit Type Management
//***********************************************************

	/*
	 * Add new Credit Type into the system
	 * @param addCreditTypeResponse
	 * @exception InvalidDataFault raised if any parameter is wrong
	 * @exception DuplicateCreditTypeFault raised if the credit type being added has the same name as one that already exists
	 */
	public AddCreditTypeResponse addCreditType(AddCreditTypeRequest addCreditTypeRequest)
			throws InvalidDataFault, DuplicateCreditTypeFault {
		return quotasystem.addCreditType(addCreditTypeRequest);
	}

	/*
	 * Modify an existing Credit Type
	 * @param modifyCreditTypeRequest
	 * @exception CreditTypeNotFoundFault raised if the desired credit type is not found
	 * @exception InvalidDataFault raised if any parameter is wrong
	 * @exception DuplicateCreditTypeFault raised if the credit type being modified has the same name as one that already exists
	 */
	public void modifyCreditType(ModifyCreditTypeRequest modifyCreditTypeRequest)
			throws CreditTypeNotFoundFault, InvalidDataFault, DuplicateCreditTypeFault {
		quotasystem.modifyCreditType(modifyCreditTypeRequest);
	}

	/*
	 * Delete a creidt type
	 * @param deleteCreditTypeRequest id of the credit type to delete. This credit type needs to be inactive and not be in use.
	 * @exception CreditTypeNotFoundFault
	 * @exception InvalidDataFault
	 */
	public void deleteCreditType(DeleteCreditTypeRequest deleteCreditTypeRequest)
			throws CreditTypeNotFoundFault, InvalidDataFault {
		quotasystem.deleteCreditType(deleteCreditTypeRequest);
	}

	/*
	 * Returns a credit type that matches the id provided in the parameter
	 * @param getCreditTypeByIdRequest credit type id
	 * @return GetCreditTypeByIdResponse
	 * @exception CreditTypeNotFoundFault raised if the is no credit type with the requested id
	 */
	public GetCreditTypeByIdResponse getCreditTypeById(GetCreditTypeByIdRequest getCreditTypeByIdRequest)
			throws CreditTypeNotFoundFault {
		return quotasystem.getCreditTypeById(getCreditTypeByIdRequest);
	}

	/*
	 * Returns all credit types
	 * @return GetCreditTypesResponse array of credit types
	 */
	public GetCreditTypesResponse getCreditTypes() {
		return quotasystem.getCreditTypes();
	}

	/*
	 * Returns all the Credit Types that are assigned to the specified course
	 * @param getCreditTypesByCourseRequest
	 * @return GetCreditTypesByCourseResponse
	 * @exception CourseNotFoundFault
	 */
	public GetCreditTypesByCourseResponse getCreditTypesByCourse(
			GetCreditTypesByCourseRequest GetCreditTypesByCourseRequest)
			throws CourseNotFoundFault {
		return quotasystem.getCreditTypesByCourse(GetCreditTypesByCourseRequest);
	}

	/*
	 * Returns all the Credit Types that have the specified policy assigned
	 * @param getCreditTypesByPolicyRequest
	 * @return GetCreditTypesByPolicyResponse
	 * @exception PolicyNotFoundFault
	 */
	public GetCreditTypesByPolicyResponse getCreditTypesByPolicy(
			GetCreditTypesByPolicyRequest getCreditTypesByPolicyRequest)
			throws PolicyNotFoundFault {
		return quotasystem.getCreditTypesByPolicy(getCreditTypesByPolicyRequest);
	}

	/*
	 * Return all the Credit Types for the specified user
	 * @param getCreditTypesByUserRequest
	 * @return GetCreditTypesByUserResponse
	 * @exception UserNotFoundFault
	 */
	public GetCreditTypesByUserResponse getCreditTypesByUser(GetCreditTypesByUserRequest getCreditTypesByUserRequest)
			throws UserNotFoundFault{
		return quotasystem.getCreditTypesByUser(getCreditTypesByUserRequest);
	}

	/*
	 * Returns all the assignable credit types
	 * @return GetAssignableCreditTypesResponse array of credit types
	 */
	public GetAssignableCreditTypesResponse getAssignableCreditTypes() {
		return quotasystem.getAssignableCreditTypes();
	}

	/*
	 * Retrieve all courses
	 * @return GetCoursesResponse array of courses
	 */
	public GetCoursesResponse getCourses() {
		return quotasystem.getCourses();
	}

//***********************************************************
//						Quota Management
//***********************************************************

	/*
	 * Assigns the desired quota amount to the specified user
	 * @param assignQuotaRequest object that contains credit type, amount, user
	 * @return AssignQuotaResponse response
	 * @exception CreditTypeNotFoundFault
	 * @exception UserNotFoundFault
	 * @exception InvalidDataFault
	 */
	public AssignQuotaResponse assignQuota(AssignQuotaRequest assignQuotaRequest)
			throws CreditTypeNotFoundFault, UserNotFoundFault, InvalidDataFault {
		return quotasystem.assignQuota(assignQuotaRequest);
	}
	
    public edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsResponse cancelQuotaAssignments
    (
    edu.fiu.cis.acrl.quotasystem.ws.CancelQuotaAssignmentsRequest cancelQuotaAssignmentsRequest
    )
	throws CreditTypeNotFoundFault,UserNotFoundFault,InvalidDataFault{
    	return quotasystem.cancelQuotaAssignments(cancelQuotaAssignmentsRequest);
	}

	/*
	 * Assigns the desired quota amount to all the users in the specified course
	 * @param assignQuotaToCourseRequest object that contains credit type, amount, course
	 * @return AssignQuotaToCourseResponse reponse
	 * @exception CreditTypeNotFoundFault
	 * @exception CourseNotFoundFault
	 * @exception InvalidDataFault
	 */
	public AssignQuotaToCourseResponse assignQuotaToCourse(AssignQuotaToCourseRequest assignQuotaToCourseRequest)
			throws CreditTypeNotFoundFault, CourseNotFoundFault, InvalidDataFault {
		return quotasystem.assignQuotaToCourse(assignQuotaToCourseRequest);
	}


	/*
	 * Updates the quota amount from all the users in the specified course
	 * @param ModifyCourseQuotaRequest object
	 * @return ModifyCourseQuotaResponse object
	 * @exception CreditTypeNotFoundFault
	 * @exception CourseNotFoundFault
	 * @exception InvalidDataFault
	 */
    public  edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaResponse modifyCourseQuota
    (
    edu.fiu.cis.acrl.quotasystem.ws.ModifyCourseQuotaRequest modifyCourseQuotaRequest
    )
    throws CreditTypeNotFoundFault,CourseNotFoundFault,InvalidDataFault{
		return quotasystem.modifyCourseQuota(modifyCourseQuotaRequest);

	}

	/*
	 * Cancels the quota to all the users in the specified course
	 * @param CancelCourseQuotaRequest object
	 * @return CancelCourseQuotaResponse object
	 * @exception CreditTypeNotFoundFault
	 * @exception CourseNotFoundFault
	 * @exception InvalidDataFault
	 */
	public edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaResponse cancelCourseQuota
	(
	edu.fiu.cis.acrl.quotasystem.ws.CancelCourseQuotaRequest cancelCourseQuotaRequest
	)
	throws CreditTypeNotFoundFault,CourseNotFoundFault,InvalidDataFault{
		return quotasystem.cancelCourseQuota(cancelCourseQuotaRequest);
	}

    //***********************************************************
    //	Scheduler
    //***********************************************************


    /*
     * Allocates the required quota for a user appointment
     * @param scheduleAppointmentsRequest
     * @exception CreditTypenotFoundFault
     * @exception UserNotFoundFault
     * @exception InvalidDataFault
     */
    public edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsResponse scheduleAppointments
    (
    edu.fiu.cis.acrl.quotasystem.ws.ScheduleAppointmentsRequest scheduleAppointmentsRequest
    )
    throws CreditTypeNotFoundFault,UserNotFoundFault,InvalidDataFault{
    	return quotasystem.scheduleAppointments(scheduleAppointmentsRequest);
    }

    /*
     * Modifies previously allocated quota for a user appointment
     * @param modifyAppointmentRequest
     * @exception CreditTypenotFoundFault
     * @exception UserNotFoundFault
     * @exception InvalidDataFault
     */
    public edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentResponse modifyAppointment
    (
    edu.fiu.cis.acrl.quotasystem.ws.ModifyAppointmentRequest modifyAppointmentRequest
    )
    throws CreditTypeNotFoundFault,UserNotFoundFault,InvalidDataFault{
    	return quotasystem.modifyAppointment(modifyAppointmentRequest);
    }

    /*
     * Releases previously allocated quota for a user appointment
     * @param cancelAppointmentRequest
     * @exception InvalidDataFault
     */
    public edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentResponse cancelAppointment
    (
    	edu.fiu.cis.acrl.quotasystem.ws.CancelAppointmentRequest cancelAppointmentRequest
    )
    throws InvalidDataFault{
    	return quotasystem.cancelAppointment(cancelAppointmentRequest);
    }

    /*
     * Releases previously allocated quota for a set of user appointments with the same affiliation id
     * @param cancelAllAppointmentsRequest
     * @exception InvalidDataFault
     */
    public edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsResponse cancelAllAppointments
    (
    		edu.fiu.cis.acrl.quotasystem.ws.CancelAllAppointmentsRequest cancelAllAppointmentsRequest
    )
    throws InvalidDataFault{
    	return quotasystem.cancelAllAppointments(cancelAllAppointmentsRequest);
    }

    /*
     * Checks whether the user has available quota for any resource of a given course
     * @param doesUserHaveAvailableQuotaRequest
     * @exception CourseNotFoundFault
     * @exception UserNotFoundFault
     */
    public edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaResponse doesUserHaveAvailableQuota
    (
    edu.fiu.cis.acrl.quotasystem.ws.DoesUserHaveAvailableQuotaRequest doesUserHaveAvailableQuotaRequest
    )
    throws CourseNotFoundFault,UserNotFoundFault{
    	return quotasystem.doesUserHaveAvailableQuota(doesUserHaveAvailableQuotaRequest);
    }


//***********************************************************
//					Report Management
//***********************************************************

	/*
	 * Returns an array of the current period quota summary for all the credit types in a course
	 * @param getCurrentPreiodQuotaSummaryRequest
	 * @return GetCurrentPreiodQuotaSummaryResponse
	 */
	public GetCurrentPeriodQuotaSummaryResponse getCurrentPeriodQuotaSummary(
			GetCurrentPeriodQuotaSummaryRequest getCurrentPeriodQuotaSummaryRequest) {
		return quotasystem.getCurrentPeriodQuotaSummary(getCurrentPeriodQuotaSummaryRequest);
	}

	/*
	 * Returns an array of the current period quota summary per period for a specified credit type
	 * @param getCurrentPreiodQuotaSummaryByCreditTypeRequest
	 * @return GetCurrentPreiodQuotaSummaryByCreditTypeResponse
	 * @exception CreditTypeNotFoundFault
	 */
	public GetCurrentPeriodQuotaSummaryByCreditTypeResponse getCurrentPeriodQuotaSummaryByCreditType(
			GetCurrentPeriodQuotaSummaryByCreditTypeRequest getCurrentPeriodQuotaSummaryByCreditTypeRequest)
			throws CreditTypeNotFoundFault {
		return quotasystem.getCurrentPeriodQuotaSummaryByCreditType(getCurrentPeriodQuotaSummaryByCreditTypeRequest);
	}
	
	/*
	 * Returns an array of the current period quota summary per credit type for a specified user id
	 * @param getCurrentPeriodQuotaSummaryByUserRequest
	 * @return GetCurrentPeriodQuotaSummaryByUserResponse
	 */
	public GetCurrentPeriodQuotaSummaryByUserResponse getCurrentPeriodQuotaSummaryByUser(
			GetCurrentPeriodQuotaSummaryByUserRequest getCurrentPeriodQuotaSummaryByUserRequest){
		return quotasystem.getCurrentPeriodQuotaSummaryByUser(getCurrentPeriodQuotaSummaryByUserRequest);
	}

	/*
	 * Returns an array of the current period quota summary per credit type for a specified userId and courseId
	 * @param getCurrentPeriodQuotaSummaryByUserAndCourseRequest
	 * @return GetCurrentPeriodQuotaSummaryByUserAndCourseResponse
	 */
	public GetCurrentPeriodQuotaSummaryByUserAndCourseResponse getCurrentPeriodQuotaSummaryByUserAndCourse(
			GetCurrentPeriodQuotaSummaryByUserAndCourseRequest getCurrentPeriodQuotaSummaryByUserAndCourseRequest){
		return quotasystem.getCurrentPeriodQuotaSummaryByUserAndCourse(getCurrentPeriodQuotaSummaryByUserAndCourseRequest);
	}
	
	/*
	 * Returns an array of the historic quota summary for all the credit types in a course
	 * @param getHistoricQuotaSummaryRequest
	 * @return GetHistoricQuotaSummaryResponse
	 */
	public GetHistoricQuotaSummaryResponse getHistoricQuotaSummary(
			GetHistoricQuotaSummaryRequest getHistoricQuotaSummaryRequest) {
		return quotasystem.getHistoricQuotaSummary(getHistoricQuotaSummaryRequest);
	}

	/*
	 * Returns an array of the historic quota summary for all periods from a given user
	 * @param getHistoricQuotaSummaryPerPeriodsRequest
	 * @return GetHistoricQuotaSummaryPerPeriodsResponse
	 * @exception CrediTypeNotFoundFault
	 * @exception UserNotFoundFault
	 * @exception InvalidDataFault
	 */
	public GetHistoricQuotaSummaryPerPeriodsResponse getHistoricQuotaSummaryPerPeriods(
			GetHistoricQuotaSummaryPerPeriodsRequest getHistoricQuotaSummaryPerPeriodsRequest)
			throws CreditTypeNotFoundFault, UserNotFoundFault, InvalidDataFault {
		return quotasystem.getHistoricQuotaSummaryPerPeriods(getHistoricQuotaSummaryPerPeriodsRequest);
	}

	/*
	 * Returns an array of the historic quota summary for all users from a given period
	 * @param getHistoricQuotaSummaryPerUsersRequest
	 * @return GetHistoricQuotaSummaryPerUsersResponse
	 * @exception CrediTypeNotFoundFault
	 * @exception InvalidDataFault
	 */
	public GetHistoricQuotaSummaryPerUsersResponse getHistoricQuotaSummaryPerUsers(
			GetHistoricQuotaSummaryPerUsersRequest getHistoricQuotaSummaryPerUsersRequest)
			throws CreditTypeNotFoundFault, InvalidDataFault {
		return quotasystem.getHistoricQuotaSummaryPerUsers(getHistoricQuotaSummaryPerUsersRequest);
	}
	
    public GetHistoricQuotaSummaryByUserResponse getHistoricQuotaSummaryByUser(
    		GetHistoricQuotaSummaryByUserRequest getHistoricQuotaSummaryByUserRequest)
        	throws CourseNotFoundFault,UserNotFoundFault{
    	return quotasystem.getHistoricQuotaSummaryByUser(getHistoricQuotaSummaryByUserRequest);
    }
             
    public GetHistoricQuotaSummaryByUserAndCreditTypeResponse getHistoricQuotaSummaryByUserAndCreditType(
    		GetHistoricQuotaSummaryByUserAndCreditTypeRequest getHistoricQuotaSummaryByUserAndCreditTypeRequest)
    		throws CreditTypeNotFoundFault,UserNotFoundFault{
    	return quotasystem.getHistoricQuotaSummaryByUserAndCreditType(getHistoricQuotaSummaryByUserAndCreditTypeRequest);
    }

//***********************************************************
//				         Moodle
//***********************************************************

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void addCourse(AddCourseRequest addCourseRequest)
			throws DuplicateCourseFault, InvalidDataFault {
		quotasystem.addCourse(addCourseRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void addUser(AddUserRequest addUserRequest)
			throws InvalidDataFault, DuplicateUserFault {
		quotasystem.addUser(addUserRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void modifyCourse(ModifyCourseRequest modifyCourseRequest)
			throws DuplicateCourseFault, CourseNotFoundFault, InvalidDataFault {
		quotasystem.modifyCourse(modifyCourseRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void modifyUser(ModifyUserRequest modifyUserRequest)
			throws UserNotFoundFault, InvalidDataFault, DuplicateUserFault {
		quotasystem.modifyUser(modifyUserRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void deleteCourse(DeleteCourseRequest deleteCourseRequest)
			throws CourseNotFoundFault {
		quotasystem.deleteCourse(deleteCourseRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void deleteUser(DeleteUserRequest deleteUserRequest)
			throws UserNotFoundFault {
		quotasystem.deleteUser(deleteUserRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public EnrollUserResponse enrollUser(EnrollUserRequest enrollUserRequest)
			throws CourseNotFoundFault, UserNotFoundFault {
		return quotasystem.enrollUser(enrollUserRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void unenrollUser(UnenrollUserRequest unenrollUserRequest)
			throws EnrollmentNotFoundFault, CourseNotFoundFault, UserNotFoundFault {
		quotasystem.unenrollUser(unenrollUserRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public GetUsersResponse getUsers() {
		return quotasystem.getUsers();
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public GetUsersByCourseResponse getUsersByCourse(GetUsersByCourseRequest getUsersByCourseRequest)
			throws CourseNotFoundFault {
		return quotasystem.getUsersByCourse(getUsersByCourseRequest);
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	public void syncUsersAndCourses(SyncUsersAndCoursesRequest syncUsersAndCoursesRequest) {
		quotasystem.syncUsersAndCourses(syncUsersAndCoursesRequest);
	}

//***********************************************************
//    						Inherited
//***********************************************************

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	@Override
	public void shutDown(ConfigurationContext arg0, AxisService arg1) {
		quotasystem.shutDown();
	}

	/* TODO
	 * @param
	 * @return
	 * @exception
	 */
	@Override
	public void startUp(ConfigurationContext arg0, AxisService arg1) {
		quotasystem.startUp();
	}
}
