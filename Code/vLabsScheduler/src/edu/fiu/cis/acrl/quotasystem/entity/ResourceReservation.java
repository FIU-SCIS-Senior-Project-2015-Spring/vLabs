package edu.fiu.cis.acrl.quotasystem.entity;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.MessageContext;

import edu.fiu.cis.acrl.quotasystem.ws.CreditTypeNotFoundFault;
import edu.fiu.cis.acrl.quotasystem.ws.InvalidDataFault;
import edu.fiu.cis.acrl.quotasystem.ws.PolicyType;
import edu.fiu.cis.acrl.quotasystem.ws.QuotaAssignment;
import edu.fiu.cis.acrl.quotasystem.ws.UserNotFoundFault;
import edu.fiu.cis.acrl.tools.debug.DebugTools;
import edu.fiu.cis.acrl.virtuallabs.ws.GetUserDefaultTimeZoneIdRequest;
import edu.fiu.cis.acrl.virtuallabs.ws.GetUserDefaultTimeZoneIdResponse;
import edu.fiu.cis.acrl.virtuallabs.ws.ReserveResourceRequest;
import edu.fiu.cis.acrl.virtuallabs.ws.ReserveResourceResponse;
import edu.fiu.cis.acrl.virtuallabs.ws.VirtualLabsStub;

final public class ResourceReservation {

	// Debug level for this class
	private static int DEBUG_LEVEL = 3;
	
	String virtualLabsEPR;
	VirtualLabsStub stub;


	public ResourceReservation(String virtualLabsEPR) {
		super();
		this.virtualLabsEPR = virtualLabsEPR;
		try {
			stub = new VirtualLabsStub(virtualLabsEPR);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}

	public  boolean reserve(
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType,
			Timestamp startDateTs, Timestamp endDateTs,
			float quotaRequestedInMinutes) {
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] reserve Inside!");
		ReserveResourceResponse response = new ReserveResourceResponse();

		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.setTime(startDateTs);
		endDate.setTime(endDateTs);

		ReserveResourceRequest request = new ReserveResourceRequest();
		request.setCourse(creditType.getCourse().getFullname());
		request.setQuota(((int) quotaRequestedInMinutes) );
		request.setResourceType(creditType.getResource());
		request.setStart(startDate);
		request.setEnd(endDate);
		request.setCancel(false);

		try {
			response = stub.reserveResource(request);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] reserve out!");
		return response.getSuccess();

	}

	public  boolean cancel(
			edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType,
			Timestamp startDateTs, Timestamp endDateTs,
			float quotaRequestedInMinutes) {
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] cancel Inside!");
		ReserveResourceResponse response = new ReserveResourceResponse();

		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] credit type: "+creditType.getName());
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] quotaRequestedInMinutes: "+quotaRequestedInMinutes);

		
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.setTime(startDateTs);
		endDate.setTime(endDateTs);

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] startDate: "+startDate.getTime().toString());
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] endDate: "+endDate.getTime().toString());
		
		ReserveResourceRequest request = new ReserveResourceRequest();
		request.setCourse(creditType.getCourse().getFullname());
		request.setQuota(((int) quotaRequestedInMinutes) );
		request.setResourceType(creditType.getResource());
		request.setStart(startDate);
		request.setEnd(endDate);
		request.setCancel(true);
		


		try {
			response = stub.reserveResource(request);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] cancel out!");
		return response.getSuccess();
	}

	public void cancelAssignments(
			List<edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment> assignments){
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] cancelAssignments Inside!");
		
		for(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment:assignments){

			if(assignment.isActive()){			
				// Get assignment values
				edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignment.getCreditType();
				float quantity = assignment.getQuantity();
	
				//Prepare request parameters
				
				// Depending on policy absolute status, set the respective start date
				Timestamp startDateTs = new Timestamp(System.currentTimeMillis());
				Timestamp periodStartDateTs = new Timestamp(System.currentTimeMillis());
				Timestamp periodEndDateTs = new Timestamp(System.currentTimeMillis());
				edu.fiu.cis.acrl.quotasystem.entity.Policy policy = creditType.getPolicy();

				if (policy.getAbsolute()) {
					startDateTs = policy.getStartDate();
				} else {
					Calendar startDate = Calendar.getInstance();
					startDate.setTime(startDateTs);
					startDate.add(Calendar.DAY_OF_MONTH, policy.getDaysToRelStart());
					startDateTs.setTime(startDate.getTimeInMillis());

				}
				
				periodStartDateTs.setTime(startDateTs.getTime());

				// Calculate quota for each period
				float quotaRequestedInMinutes = quantity* policy.getQuotaInPeriod();
				if (quotaRequestedInMinutes < policy.getMinimum()){
					quotaRequestedInMinutes = policy.getMinimum();
				}		
				
				// Calculate the number of periods to do the cancellation
				float numberOfPeriods = (quantity * policy.getQuotaInPeriod() * policy.getNumberOfPeriods()) / quotaRequestedInMinutes;


				for (int i = 1; i <= numberOfPeriods; i++) {
					Calendar endDate = Calendar.getInstance();
					endDate.setTime(periodStartDateTs);
					
					if(policy.getPolicyType().equals(PolicyType.NOEXPIRATION)){
						try {
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							endDate.setTime(df.parse("31/12/9999"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}else{
						endDate.add(Calendar.DAY_OF_MONTH, policy.getDaysInPeriod());	
					}
					
					periodEndDateTs.setTime(endDate.getTimeInMillis());					
					Calendar start = Calendar.getInstance();
					start.setTime(periodStartDateTs);
					Calendar today = Calendar.getInstance();
					
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] credit type: "+creditType.getName());
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] quotaRequestedInMinutes: "+quotaRequestedInMinutes);
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] periodStartDate: "+periodStartDateTs.toString());
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] periodEndDate: "+periodEndDateTs.toString());
					
					
					if((today.after(start)||today.equals(start)) && today.before(endDate)){
						periodStartDateTs.setTime(today.getTimeInMillis());
						// Cancel quota reservation in ve scheduler
						cancel(creditType, periodStartDateTs, periodEndDateTs,
								quotaRequestedInMinutes);
								periodStartDateTs.setTime(periodEndDateTs.getTime());
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] currentPeriod ");
					}else if(today.before(start)){
						// Cancel quota reservation in ve scheduler
						cancel(creditType, periodStartDateTs, periodEndDateTs,
								quotaRequestedInMinutes);
								periodStartDateTs.setTime(periodEndDateTs.getTime());
								DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] next period ");
						
					}	
					periodStartDateTs.setTime(periodEndDateTs.getTime());
	
				}
			}
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] cancelAssignments out!");
	}



	public  void cancelAssignment(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment, int usersCount) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] cancelAssignment Inside!");
		edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignment
				.getCreditType();
		float quantity = assignment.getQuantity();

		//Prepare request parameters
		
		// Depending on policy absolute status, set the respective start date
		Timestamp startDateTs = new Timestamp(System.currentTimeMillis());
		Timestamp periodStartDateTs = new Timestamp(System.currentTimeMillis());
		Timestamp periodEndDateTs = new Timestamp(System.currentTimeMillis());
		edu.fiu.cis.acrl.quotasystem.entity.Policy policy = creditType.getPolicy();

		if (policy.getAbsolute()) {
			startDateTs = policy.getStartDate();
		} else {
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(startDateTs);
			startDate.add(Calendar.DAY_OF_MONTH, policy.getDaysToRelStart());
			startDateTs.setTime(startDate.getTimeInMillis());

		}
		
		periodStartDateTs.setTime(startDateTs.getTime());

		// Calculate quota for each period
		float quotaRequestedInMinutes = quantity* policy.getQuotaInPeriod();
		if (quotaRequestedInMinutes < policy.getMinimum()){
			quotaRequestedInMinutes = policy.getMinimum();
		}		
		
		// Calculate the number of periods to do the cancellation
		float numberOfPeriods = (quantity * policy.getQuotaInPeriod() * policy.getNumberOfPeriods()) / quotaRequestedInMinutes;


		for (int i = 1; i <= numberOfPeriods; i++) {
			
			Calendar endDate = Calendar.getInstance();
			endDate.setTime(periodStartDateTs);

			
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] policy type: "+policy.getPolicyType().toString());
			
			if(policy.getPolicyType().toString().equals(PolicyType._NOEXPIRATION)){
				try {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					endDate.setTime(df.parse("31/12/9999"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				endDate.add(Calendar.DAY_OF_MONTH, policy.getDaysInPeriod());	
			}
			
			periodEndDateTs.setTime(endDate.getTimeInMillis());
			Calendar start = Calendar.getInstance();
			start.setTime(periodStartDateTs);
			Calendar today = Calendar.getInstance();
			
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] credit type: "+creditType.getName());
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] quotaRequestedInMinutes: "+quotaRequestedInMinutes*usersCount);
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] periodStartDate: "+periodStartDateTs.toString());
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] periodEndDate: "+periodEndDateTs.toString());
			
			
			if((today.after(start)||today.equals(start)) && today.before(endDate)){
				periodStartDateTs.setTime(today.getTimeInMillis());
				// Cancel quota reservation in ve scheduler
				cancel(creditType, periodStartDateTs, periodEndDateTs,
						quotaRequestedInMinutes*usersCount);
						periodStartDateTs.setTime(periodEndDateTs.getTime());
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] currentPeriod ");
			}else if(today.before(start)){
				// Cancel quota reservation in ve scheduler
				cancel(creditType, periodStartDateTs, periodEndDateTs,
						quotaRequestedInMinutes*usersCount);
						periodStartDateTs.setTime(periodEndDateTs.getTime());
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] next period ");
				
			}

		}
	
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] cancelAssignment out!");
	}

	public  boolean reserveAssignment(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment, int usersCount) {
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] reserveAssignment Inside!");
		
		boolean response = true;

		edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignment.getCreditType();
		float quantity = assignment.getQuantity();

		//Initialize flag to check the success in each period
		boolean reservationSuccess = true;

		//Prepare request parameters
		
		// Depending on policy absolute status, set the respective start date
		Timestamp startDateTs = new Timestamp(System.currentTimeMillis());
		Timestamp periodStartDateTs = new Timestamp(System.currentTimeMillis());
		Timestamp periodEndDateTs = new Timestamp(System.currentTimeMillis());
		edu.fiu.cis.acrl.quotasystem.entity.Policy policy = creditType.getPolicy();

		if (policy.getAbsolute()) {
			startDateTs = policy.getStartDate();
		} else {
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(startDateTs);
			startDate.add(Calendar.DAY_OF_MONTH, policy.getDaysToRelStart());
			startDateTs.setTime(startDate.getTimeInMillis());

		}
		
		periodStartDateTs.setTime(startDateTs.getTime());

		// Calculate quota for each period
		float quotaRequestedInMinutes = quantity* policy.getQuotaInPeriod();
		if (quotaRequestedInMinutes < policy.getMinimum()){
			quotaRequestedInMinutes = policy.getMinimum();
		}		
		
		// Calculate the number of periods to do the reservation
		float numberOfPeriods = (quantity * policy.getQuotaInPeriod() * policy.getNumberOfPeriods()) / quotaRequestedInMinutes;

		//Initialize counter of periods which have had a succesful reservation
		int successPeriods = 1;

		for (int i = 1; i <= numberOfPeriods; i++) {
			successPeriods = i;
			
			//Calculate endDate for each period
			Calendar endDate = Calendar.getInstance();
			endDate.setTime(periodStartDateTs);
			
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] policy type: "+policy.getPolicyType().toString());
			
			if(policy.getPolicyType().toString().equals(PolicyType._NOEXPIRATION)){
				try {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					endDate.setTime(df.parse("31/12/9999"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				endDate.add(Calendar.DAY_OF_MONTH, policy.getDaysInPeriod());	
			}
			
			periodEndDateTs.setTime(endDate.getTimeInMillis());
			

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] credit type: "+creditType.getName());
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] quotaRequestedInMinutes: "+quotaRequestedInMinutes*usersCount);
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] periodStartDate: "+periodStartDateTs.toString());
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] periodEndDate: "+periodEndDateTs.toString());
			
			// Reserve quota in ve scheduler
			boolean success = reserve(creditType, periodStartDateTs,periodEndDateTs,quotaRequestedInMinutes*usersCount);

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] reservation for period no "+i+" is "+success);
			
			// If reservation failed, set flag to false and stop checking for next periods
			if (!success) {
				reservationSuccess = false;
				break;
			}
			
			//Set startDate for next period
			periodStartDateTs.setTime(periodEndDateTs.getTime());

		}

		// If reservation flag is false, cancel reservations of all succesful periods
		if (!reservationSuccess) {
			
			//reset periodStartDate
			periodStartDateTs.setTime(startDateTs.getTime());
			
			for (int i = 1; i <= successPeriods; i++) {
				
				//Calculate endDate for each period
				Calendar endDate = Calendar.getInstance();
				endDate.setTime(periodStartDateTs);
				if(policy.getPolicyType().equals(PolicyType.NOEXPIRATION)){
					try {
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						endDate.setTime(df.parse("31/12/9999"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}else{
					endDate.add(Calendar.DAY_OF_MONTH, policy.getDaysInPeriod());	
				}
				periodEndDateTs.setTime(endDate.getTimeInMillis());
				
				cancel(creditType, periodStartDateTs, periodEndDateTs,quotaRequestedInMinutes);
				
				//Set startDate for next period
				periodStartDateTs.setTime(periodEndDateTs.getTime());

			}

		}

		response = reservationSuccess;
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] reserveAssignment out!");
		return response;
	}
	
	public TimeZone getUserTimeZoneId(UserProfile user){
		
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] getUserTimeZoneId inside!");
		GetUserDefaultTimeZoneIdRequest request = new GetUserDefaultTimeZoneIdRequest();
		request.setRequestingUser(user.getUsername());
		request.setUserName(user.getUsername());		
		GetUserDefaultTimeZoneIdResponse response;
		TimeZone timeZone = null;
		try {
			response = stub.getUserDefaultTimeZoneId(request);
			String timeZoneId = response.getTimeZoneId();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] timezoneid: "+timeZoneId);
			timeZone = TimeZone.getTimeZone(timeZoneId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - ResourceReservation] getUserTimeZoneId out!");
		return timeZone;
		
	}

}
