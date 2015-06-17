package edu.fiu.cis.acrl.kaseya.tenant.client;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.kaseya.hosted.webservices.AccountType;
import com.kaseya.hosted.webservices.CreateTrialAccount;
import com.kaseya.hosted.webservices.CreateTrialAccountResponse;
import com.kaseya.hosted.webservices.PromoCodeRequest;
import com.kaseya.hosted.webservices.PromoCodeResponse;
import com.kaseya.hosted.webservices.TrialRequest;
import com.kaseya.hosted.webservices.TrialResponse;
import com.kaseya.hosted.webservices.TrialType;
import com.kaseya.hosted.webservices.ValidatePromoCode;
import com.kaseya.hosted.webservices.ValidatePromoCodeResponse;

import edu.fiu.cis.acrl.kaseya.tenant.tools.Settings;
import edu.fiu.cis.acrl.kaseya.tenant.tools.debug.DebugTools;
import edu.fiu.cis.acrl.kaseya.tenant.ws.TrialWSStub;

public class KaseyaTenant {

	// Debug level for this class
	private static int DEBUG_LEVEL = 1;
	
	private Settings settings;
	private TrialWSStub kaseyaTenantStub;
	private String targetEndPoint;
	
	/**
	 * Constructor is protected
	 * 
	 */
	protected KaseyaTenant(String targetEndPoint) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - Constructor] Inside!");

		this.targetEndPoint = targetEndPoint;
		
		try {

			kaseyaTenantStub = new TrialWSStub(targetEndPoint);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - Constructor] Ready to get out!");

	}

	/**
	 * 
	 */
	public int validatePromoCode(String promoCode) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - validatePromoCode] Inside!");
		int serviceID = -1;
		
		try {
			ValidatePromoCode validatePromoCodeReq = new ValidatePromoCode();
			PromoCodeRequest promoCodeReq = new PromoCodeRequest();
			promoCodeReq.setPromoCode(promoCode);
			validatePromoCodeReq.setRequest(promoCodeReq);
			ValidatePromoCodeResponse validatePromoCodeResp = 
				kaseyaTenantStub.validatePromoCode(validatePromoCodeReq);
			PromoCodeResponse promoCodeResp =
				validatePromoCodeResp.getValidatePromoCodeResult();
			if (promoCodeResp.getErrorMessage().length() > 0) {
				// Invalid promo code! 
				DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - validatePromoCode] " +
						"Error Message: " + promoCodeResp.getErrorMessage());
				serviceID = -1; 
			} else {
				// valid promo code
				serviceID = promoCodeResp.getServiceID();
			}
			
			DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - validatePromoCode] " +
					"serviceID: " + serviceID);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - validatePromoCode] Ready to get out!");
		return serviceID;
		
	}

	/**
	 * 
	 */
	public TenantAccount creatAccount(TrialRequest tenantAccountReq) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - creatAccount] Inside!");
		TenantAccount tenant = null;

		try {

			CreateTrialAccount tenantAccount = new CreateTrialAccount();
			tenantAccount.setRequest(tenantAccountReq);
			CreateTrialAccountResponse createTrialAccountResp = 
				kaseyaTenantStub.createTrialAccount(tenantAccount);
			TrialResponse trialResp = createTrialAccountResp.getCreateTrialAccountResult();
			if (trialResp.getErrorMessage().length() > 0) {
				// Account was not created!
				DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - creatAccount] " +
						"ErrorMessage: " + trialResp.getErrorMessage());
			} else {
				// Account successfully created!
				DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - creatAccount] " +
						"Account was successfully created!");

				DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - creatAccount] " +
						"Before > trialResp.getCustomerID(): " + trialResp.getCustomerID());

				tenant = new TenantAccount();
				tenant.setAccountID(trialResp.getAccountID());
				tenant.setAdmins(trialResp.getAdmins());
				tenant.setAgents(trialResp.getAgents());
				tenant.setCustomerID(new BigDecimal(trialResp.getCustomerID().doubleValue()));
				tenant.setEndDate(trialResp.getEndDate());
				tenant.setGroup(trialResp.getGroup());
				tenant.setPassword(trialResp.getPassword());
				tenant.setUrl(trialResp.getUrl());
				tenant.setUsername(trialResp.getUsername());

				DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - creatAccount] " +
						tenant.toSrting());
				DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - creatAccount] " +
						"After > trialResp.getCustomerID(): " + trialResp.getCustomerID());
						
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - creatAccount] Ready to get out!");
		return tenant;
	}
	
	/**
	 * A handle to the unique Singleton instance.
	 */
	// static private KaseyaTenant _instance = null;
	static private Map<String,KaseyaTenant> KaseyaTenants = 
		new HashMap<String,KaseyaTenant>();

	/**
	 * Masoud: 10/23/2013
	 * To avoid bleeding between partitions, I have decided to create a new
	 * instance for each time the instance function is called.
	 * @return a new instance of this class.
	 */
	static public KaseyaTenant instance(String targetEndPoint) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] Inside!" +
				"targetEndPoint: " + targetEndPoint);
		
		String realTargetEndPoint = (targetEndPoint == "") ? null : targetEndPoint;
		if (realTargetEndPoint == null) {
			
			Settings settings = Settings.instance();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant] Settings!" + settings);
			realTargetEndPoint = settings.getKaseyaTenantEPR();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] " +
					"settings.getKaseyaTenantEPR(): " + settings.getKaseyaTenantEPR());
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] " +
				"realTargetEndPoint: " + realTargetEndPoint);

		KaseyaTenant KaseyaTenant = new KaseyaTenant(realTargetEndPoint);
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] Ready to get out!");

		return KaseyaTenant;

	}

	/**
	 * @return The unique instance of this class.
	 */
	/*
	static public KaseyaTenant instance(String targetEndPoint) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] Inside!" +
				"targetEndPoint: " + targetEndPoint);
		
		String realTargetEndPoint = (targetEndPoint == "") ? null : targetEndPoint;
		if (realTargetEndPoint == null) {
			
			Settings settings = Settings.instance();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant] Settings!" + settings);
			realTargetEndPoint = settings.getKaseyaTenantEPR();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] " +
					"settings.getKaseyaTenantEPR(): " + settings.getKaseyaTenantEPR());
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] " +
				"realTargetEndPoint: " + realTargetEndPoint);

		KaseyaTenant KaseyaTenant = null;
		
		if (KaseyaTenants.containsKey(realTargetEndPoint)) {
			
			KaseyaTenant = KaseyaTenants.get(realTargetEndPoint);
			
		} else {
			
			KaseyaTenant = new KaseyaTenant(realTargetEndPoint);
			KaseyaTenants.put(realTargetEndPoint, KaseyaTenant);
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] Ready to get out!");

		return KaseyaTenant;

	}
	*/

	/**
	 * @return The unique instance of this class for .
	 */
	/*
	static public KaseyaTenant instance() {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] Inside!");

		if(null == _instance) {
			_instance = new KaseyaTenant();
		}

		DebugTools.println(DEBUG_LEVEL, "[KaseyaTenant - instance] Ready to get out!");

		return _instance;

	}
*/

}
