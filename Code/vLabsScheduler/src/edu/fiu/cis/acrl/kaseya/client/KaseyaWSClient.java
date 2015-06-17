package edu.fiu.cis.acrl.kaseya.client;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.httpclient.ConnectTimeoutException;

import kaseyaws.*;
import edu.fiu.cis.acrl.kaseya.tools.Settings;
import edu.fiu.cis.acrl.kaseya.tools.debug.DebugTools;
import edu.fiu.cis.acrl.kaseya.ws.KaseyaWSStub;

public class KaseyaWSClient {

	public static String ITSKFW 	= "ITS-KFW";
	public static String ITSKSDW 	= "ITS-KSDW";
	public static String ITSKSDW14 	= "ITS-KSDW-14";
	public static String FIUSP12 	= "FIU-SP12";
	
	// Debug level for this class
	private static int DEBUG_LEVEL = 1;
	
	private String sysUsername 		= "kaseya";
	private String sysPassword 		= "Start1234";
	private String hashingAlgorithm = "SHA-1";
	private String sysRole 			= "Master";
	private String sysScope 		= "Master";
	private String promoCode 		= ITSKFW;
	
	// SMS: Jan. 16, 2014
	// To avoid to many sessions open on the web services, I will not create 
	// a new session, unless sessionTimeOut has passed! 
	private BigDecimal sessionID = new BigDecimal(0);
	private Calendar sessionTimeStamp = Calendar.getInstance();
	private long sessionTimeOut = 600000; // 10 minutes or 600 seconds or 600000 miliseconds.
	
	public void setSysUsername(String sysUsername) {
		this.sysUsername = sysUsername;
	}

	public String getSysUsername() {
		return sysUsername;
	}

	public void setSysPassword(String sysPassword) {
		this.sysPassword = sysPassword;
	}

	public String getSysPassword() {
		return sysPassword;
	}

	public void sethHashingAlgorithm(String hashingAlgorithm) {
		this.hashingAlgorithm = hashingAlgorithm;
	}

	public String getHashingAlgorithm() {
		return hashingAlgorithm;
	}

	public void setSysRole(String sysRole) {
		this.sysRole = sysRole;
	}

	public String getSysRole() {
		return sysRole;
	}

	public void setSysScope(String sysScope) {
		this.sysScope = sysScope;
	}

	public String getSysScope() {
		return sysScope;
	}

	private Settings settings;
	private KaseyaWSStub kaseyaStub;
	private String targetEndPoint;
	
	
	/**
	 * Constructor is protected
	 * 
	 */
	protected KaseyaWSClient(String targetEndPoint) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - Constructor] Inside!");

		settings = Settings.instance();

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient] Settings!" + settings);

		this.targetEndPoint = targetEndPoint;
		
		try {

			kaseyaStub = new KaseyaWSStub(targetEndPoint);

		} 
		catch (Exception e) {

			e.printStackTrace();

		}
		
		this.sysUsername 		= settings.getKaseyaMasterUsername(); // "kaseya";
		this.sysPassword 		= settings.getKaseyaMasterPassword(); // "Start1234";
		this.hashingAlgorithm 	= "SHA-1";
		this.sysRole 			= "VSA-Core";
		this.sysScope 			= "scope";
		this.promoCode 			= ITSKFW;

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - Constructor] Ready to get out!");

	}

	/**
	 * A handle to the unique Singleton instance.
	 */
	// static private KaseyaWSClient _instance = null;
	static private Map<String,KaseyaWSClient> kaseyaWSClients = 
		new HashMap<String,KaseyaWSClient>();
	
	/**
	 * Masoud: 10/23/2013
	 * To avoid bleeding between partitions, I have decided to create a new
	 * instance for each time the instance function is called.
	 * @return a new instance of this class.
	 */
	static public KaseyaWSClient instance(
			String serverName, 
			int serverPort, 
			String sysUsername, 
			String sysPassword,
			String hashingAlgorithm,
			String sysRole,
			String sysScope,
			String promoCode) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Inside!");
		
		KaseyaWSClient kaseyaWSClient = 
			instance(serverName, 
					serverPort, 
					sysUsername, 
					sysPassword,
					hashingAlgorithm,
					sysRole,
					sysScope);
		kaseyaWSClient.setPromoCode(promoCode);
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Ready to get out!");
	
		return kaseyaWSClient;
		
	}
	
	/**
	 * Masoud: 10/23/2013
	 * To avoid bleeding between partitions, I have decided to create a new
	 * instance for each time the instance function is called.
	 * @return a new instance of this class.
	 */
	static public KaseyaWSClient instance(
			String serverName, 
			int serverPort, 
			String sysUsername, 
			String sysPassword,
			String hashingAlgorithm,
			String sysRole,
			String sysScope) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Inside!");
		
		KaseyaWSClient kaseyaWSClient = instance(serverName, serverPort);
		kaseyaWSClient.setSysUsername(sysUsername);
		kaseyaWSClient.setSysPassword(sysPassword);
		kaseyaWSClient.sethHashingAlgorithm(hashingAlgorithm);
		kaseyaWSClient.setSysRole(sysRole);
		kaseyaWSClient.setSysScope(sysScope);
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Ready to get out!");
	
		return kaseyaWSClient;
		
	}
	
	/**
	 * Masoud: 10/23/2013
	 * To avoid bleeding between partitions, I have decided to create a new
	 * instance for each time the instance function is called.
	 * @return a new instance of this class.
	 */
	static public KaseyaWSClient instance(String serverName, int serverPort) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Inside!");

		String targetEndPoint = 
			"http://" + serverName + ":" + serverPort + "/vsaWS/KaseyaWS.asmx";
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] " +
				"\n\tserverName: " + serverName +
				"\n\tserverPort: " + serverPort +
				"\n\ttargetEndPoint: " + targetEndPoint);

		KaseyaWSClient kaseyaWSClient = new KaseyaWSClient(targetEndPoint);
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Ready to get out!");

		return kaseyaWSClient;

	}

	/**
	 * @return The unique instance of this class.
	 */
	/*
	static public KaseyaWSClient instance(String serverName, int serverPort) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Inside!");

		String targetEndPoint = 
			"http://" + serverName + ":" + serverPort + "/vsaWS/KaseyaWS.asmx";
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] " +
				"\n\tserverName: " + serverName +
				"\n\tserverPort: " + serverPort +
				"\n\ttargetEndPoint: " + targetEndPoint);

		KaseyaWSClient kaseyaWSClient = null;
		
		if (kaseyaWSClients.containsKey(targetEndPoint)) {
			
			kaseyaWSClient = kaseyaWSClients.get(targetEndPoint);
			
		} else {
			
			kaseyaWSClient = new KaseyaWSClient(targetEndPoint);
			kaseyaWSClients.put(targetEndPoint, kaseyaWSClient);
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Ready to get out!");

		// return _instance;
		return kaseyaWSClient;

	}
	*/

	/**
	 * @return The unique instance of this class for .
	 */
	/*
	static public KaseyaWSClient instance() {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Inside!");

		if(null == _instance) {
			_instance = new KaseyaWSClient();
		}

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - instance] Ready to get out!");

		return _instance;

	}
*/
	public boolean refreshAdmin(
			String username,
			String password,
			String emailAddress,
			String firstName,
			String lastName) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] Inside!" +
			"\n\t username: " + username +
			"\n\t password: " + password +
			"\n\t emailAddress: " + emailAddress +
			"\n\t firstName: " + firstName +
			"\n\t lastName: " + lastName);

		Boolean retVal = true;

		Boolean delRetVal = deleteAdmin(username, password);
		if (!delRetVal) {
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"The previously created admin could not be deleted!");
		} else {
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
			"The previously created admin was deleted successfully!");
		}
		
		Boolean creRetVal = createAdmin(username, password, emailAddress, firstName, lastName);
		if (!creRetVal) {
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
			"The admin could not be created!");
		} else {				
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
			"The admin was created successfully!");
		}

		retVal = delRetVal && creRetVal;
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] Ready to get out!");

		return retVal;
		
	}

	public boolean refreshAdminOld(
			String username,
			String password,
			String emailAddress,
			String firstName,
			String lastName) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] Inside!");

		Boolean retVal = true;
		
		try {
			
			/*
	       	 * Phase 0: Enable the previously created admin
	       	 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"Phase 0: Enable the previously created admin");
			if (enableAdmin(username, password)) {
			
				/*
				 * Phase I: Destroy the previously create admin user 
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I: Destroy the previously create admin user");

				/*
				 * Phase I-A: Destroy whatever the admin user has created in the previous attempt
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Destroy whatever the admin user has created in the previous attempt");

				/*
				 * Phase I-A: First, login to KServer as the previously created admin user 
				 * and get the ip address of this machine.
				 */			
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"Phase I-A: First, login to KServer as the previously created admin user " +
						"and get the ip address of this machine.");
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"Phase I-A: username: " + username + " and password: " + password);
				sessionID = kaseyaAuthenticate(username, password);
				String ip = getIP();
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"sessionID: " + sessionID + " ip:" + ip);

				/*
				 * Phase I-A: Second, delete all agents created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Second, delete all agents created by the admin user");
				GetMachineListRequest getMachineListReq = new GetMachineListRequest();
				getMachineListReq.setSessionID(sessionID);
				getMachineListReq.setBrowserIP(ip);
				getMachineListReq.setMachineCollection("");
				getMachineListReq.setMachineGroup("");
				GetMachineList getMachineList = new GetMachineList();
				getMachineList.setReq(getMachineListReq);
				GetMachineListResponseE getMachineListRespE = 
					kaseyaStub.getMachineList(getMachineList);
				GetMachineListResponse getMachineListResp =
					getMachineListRespE.getGetMachineListResult();
				ArrayOfMachine arrayOfMachines = getMachineListResp.getMachines();
				Machine[] machines = null;
				if (arrayOfMachines != null)
					machines = arrayOfMachines.getMachine();
				if (machines != null) {
					for (int i=0; i<machines.length; i++) {
						BigDecimal agentGuid = machines[i].getAgentGuid();

						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"Deleting machines[" + i + "]: " +
								machines[i].getMachine_GroupID() + ", " +
								machines[i].getAgentGuid());
						DeleteAgentRequest deleteAgentReq = new DeleteAgentRequest();
						deleteAgentReq.setSessionID(sessionID);
						deleteAgentReq.setBrowserIP(ip);
						deleteAgentReq.setAgentGuid(agentGuid.toString());
						deleteAgentReq.setUninstallAgentFirst(false);
						DeleteAgent deleteAgent = new DeleteAgent();
						deleteAgent.setReq(deleteAgentReq);
						DeleteAgentResponseE deleteAgentRespE = 
							kaseyaStub.deleteAgent(deleteAgent);
						DeleteAgentResponse deleteAgentResp =
							deleteAgentRespE.getDeleteAgentResult();
						if (deleteAgentResp.getErrorMessage().length() > 0) {
							retVal = false;
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"Deleting machines error message: " + deleteAgentResp.getErrorMessage() + " " +
									"Error location: " + deleteAgentResp.getErrorLocation());	
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"sessionID: " + sessionID + " ip:" + ip);
						}					
					}
				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"No agent was found!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"Get machines list error message: " + getMachineListResp.getErrorMessage() + " " +
							"Error location: " + getMachineListResp.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}

				/*
				 * Phase I-A: Third, delete all install packages created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Third, delete all install packages created by the admin user");
				GetPackageURLsRequest getPackageURLsReq = new GetPackageURLsRequest();
				getPackageURLsReq.setSessionID(sessionID);
				getPackageURLsReq.setBrowserIP(ip);
				getPackageURLsReq.setGroupName("");
				GetPackageURLs getPackageURLs = new GetPackageURLs();
				getPackageURLs.setReq(getPackageURLsReq);
				GetPackageURLsResponseE getPackageURLsRespE = 
					kaseyaStub.getPackageURLs(getPackageURLs);
				GetPackageURLsResponse getPackageURLsResp =
					getPackageURLsRespE.getGetPackageURLsResult();
				ArrayOfPackage arrayOfPackage = getPackageURLsResp.getPackages();
				kaseyaws.Package[] packages = null;
				if (arrayOfPackage != null)
					packages = arrayOfPackage.getPackage();
				if (packages != null) {
					for (int i=0; i<packages.length; i++) {
						String packageURL = packages[i].getURL();
						String packageIdStr = packageURL.substring(packageURL.indexOf("?id=")+4);
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"Deleting package[" + i + "]: " +
								packageURL + ", " + packageIdStr);
						int packageId = Integer.parseInt(packageIdStr);

						DeletePackageRequest deletePackageReq = new DeletePackageRequest();
						deletePackageReq.setSessionID(sessionID);
						deletePackageReq.setBrowserIP(ip);
						deletePackageReq.setPackageId(packageId);
						DeleteAgentInstallPackage deleteAgentInstallPackage = new DeleteAgentInstallPackage();
						deleteAgentInstallPackage.setReq(deletePackageReq);
						DeleteAgentInstallPackageResponse deleteAgentInstallPackageResp = 
							kaseyaStub.deleteAgentInstallPackage(deleteAgentInstallPackage);
						DeletePackageResponse deletePackageResp =
							deleteAgentInstallPackageResp.getDeleteAgentInstallPackageResult();
						if (deletePackageResp.getErrorMessage().length() > 0) {
							retVal = false;
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"deletePackageResp error message: " + deletePackageResp.getErrorMessage() + " " +
									"Error location: " + deletePackageResp.getErrorLocation());	
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"sessionID: " + sessionID + " ip:" + ip);
						}					
					}
				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"No agent install package was found!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"getPackageURLsResp error message: " + getPackageURLsResp.getErrorMessage() + " " +
							"Error location: " + getPackageURLsResp.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}

				/*
				 * Phase I-A: Fourth, delete all machine groups created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Fourth, delete all machine groups created by the admin user");
				GetMachineGroupListRequest getMachineGroupListReq = new GetMachineGroupListRequest();
				getMachineGroupListReq.setSessionID(sessionID);
				getMachineGroupListReq.setBrowserIP(ip);
				GetMachineGroupList getMachineGroupList = new GetMachineGroupList();
				getMachineGroupList.setReq(getMachineGroupListReq);
				GetMachineGroupListResponseE getMachineGroupListRespE = 
					kaseyaStub.getMachineGroupList(getMachineGroupList);
				GetMachineGroupListResponse getMachineGroupListResp =
					getMachineGroupListRespE.getGetMachineGroupListResult();
				ArrayOfString arrayOfMachineGroup = getMachineGroupListResp.getMachineGroups();
				String[] machineGroups = null;
				if (arrayOfMachineGroup != null)
					machineGroups = arrayOfMachineGroup.getGroupName();
				if (machineGroups != null) {
					for (int i=0; i<machineGroups.length; i++) {
						String machineGroup = machineGroups[i];

						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"Deleting machineGroup[" + i + "]: " +
								machineGroups[i]);
						DeleteMachineGroupRequest deleteMachineGroupReq = new DeleteMachineGroupRequest();
						deleteMachineGroupReq.setSessionID(sessionID);
						deleteMachineGroupReq.setBrowserIP(ip);
						deleteMachineGroupReq.setGroupName(machineGroup);
						DeleteMachineGroup deleteMachineGroup = new DeleteMachineGroup();
						deleteMachineGroup.setReq(deleteMachineGroupReq);
						DeleteMachineGroupResponseE deleteMachineGroupRespE = 
							kaseyaStub.deleteMachineGroup(deleteMachineGroup);
						DeleteMachineGroupResponse deleteMachineGroupResp =
							deleteMachineGroupRespE.getDeleteMachineGroupResult();
						if (deleteMachineGroupResp.getErrorMessage().length() > 0) {
							retVal = false;
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"deleteMachineGroupResp error message: " + deleteMachineGroupResp.getErrorMessage() + " " +
									"Error location: " + deleteMachineGroupResp.getErrorLocation());	
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"sessionID: " + sessionID + " ip:" + ip);
						}					
					}
				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"No machine group was found!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"Get machines list error message: " + getMachineGroupListResp.getErrorMessage() + " " +
							"Error location: " + getMachineGroupListResp.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}

				/* 
				 * Phase I-A: Fifth, delete all organizations created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Fifth, delete all organizations created by the admin user");
				GetOrgsRequest getOrgsReq = new GetOrgsRequest();
				getOrgsReq.setSessionID(sessionID);
				GetOrgs getOrgs = new GetOrgs();
				getOrgs.setReq(getOrgsReq);
				GetOrgsResponseE getOrgsRespE = 
					kaseyaStub.getOrgs(getOrgs);
				GetOrgsResponse getOrgsResp =
					getOrgsRespE.getGetOrgsResult();
				ArrayOfOrg arrayOfOrgs = getOrgsResp.getOrgs();
				Org[] orgs = null;
				if (arrayOfOrgs != null)
					orgs = arrayOfOrgs.getOrg();
				if (orgs != null) {
					for (int i=0; i<orgs.length; i++) {
						String orgId = orgs[i].getOrgId();

						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"Deleting orgs[" + i + "]: " +
								orgs[i].getOrgId() + ", " + orgs[i].getOrgName());
						DeleteOrgRequest deleteOrgReq = new DeleteOrgRequest();
						deleteOrgReq.setSessionID(sessionID);
						deleteOrgReq.setBrowserIP(ip);
						deleteOrgReq.setOrgRef(orgs[i].getOrgRef());
						DeleteOrg deleteOrg = new DeleteOrg();
						deleteOrg.setReq(deleteOrgReq);
						DeleteOrgResponseE deleteOrgRespE = 
							kaseyaStub.deleteOrg(deleteOrg);
						DeleteOrgResponse deleteOrgResp =
							deleteOrgRespE.getDeleteOrgResult();
						if (deleteOrgResp.getErrorMessage().length() > 0) {
							retVal = false;
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"deleteOrgResp error message: " + deleteOrgResp.getErrorMessage() + " " +
									"Error location: " + deleteOrgResp.getErrorLocation());	
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"sessionID: " + sessionID + " ip:" + ip);
						}					
					}
				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"No org was found!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"getOrgsResp error message: " + getOrgsResp.getErrorMessage() + " " +
							"Error location: " + getOrgsResp.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}

				/*
				 * Phase I-A: Sixth, delete all admin users created by this admin user
				 */			
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Sixth, delete all admin users created by this admin user");
				// TODO 
				// There is no function to get the list of admin users that this admin user
				// has created. Therefore, we have asked the admin user to create admin users
				// following the specific pattern in the admin user name. If the admin user
				// does not follow this pattern exactly, the users that he created will not be
				// deleted!
				String[] usernames = {
						"newadmin-"+username, 
						"ksmith-"+username
				};
				for (String uname : usernames) {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"Deleting username: " + uname);
					DeleteAdminRequest deleteAdminRequest = new DeleteAdminRequest();
					deleteAdminRequest.setUserName(uname);
					deleteAdminRequest.setBrowserIP(ip);
					deleteAdminRequest.setSessionID(sessionID);
					DeleteAdmin deleteAdmin = new DeleteAdmin();	
					deleteAdmin.setReq(deleteAdminRequest);
					DeleteAdminResponseE deleteAdminResponseE = 
						kaseyaStub.deleteAdmin(deleteAdmin);
					DeleteAdminResponse deleteAdminResponse = 
						deleteAdminResponseE.getDeleteAdminResult();
					if (deleteAdminResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"deleteAdminResponse error message: " + deleteAdminResponse.getErrorMessage() + " " +
								"Error location: " + deleteAdminResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}					
				}

				/*
				 * Phase I-A: Seventh, delete all user roles created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Seventh, delete all user roles created by the admin user");
				GetRolesRequest getRolesReq = new GetRolesRequest();
				getRolesReq.setSessionID(sessionID);
				GetRoles getRoles = new GetRoles();
				getRoles.setReq(getRolesReq);
				GetRolesResponseE getRolesRespE = 
					kaseyaStub.getRoles(getRoles);
				GetRolesResponse getRolesResp =
					getRolesRespE.getGetRolesResult();
				ArrayOfRole arrayOfRole = getRolesResp.getRoles();
				Role[] roles = null;
				if (arrayOfRole != null)
					roles = arrayOfRole.getRole();
				if (roles != null) {
					for (int i=0; i<roles.length; i++) {
						String roleId = roles[i].getRoleID();
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"Deleting roles[" + i + "]: " +
								roleId);
						if (roleId.equals("SD Admin") || roleId.equals("role-"+username)) {
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"roles[" + i + "]: " + roleId + " will not be deleted at this point!");						
						} else {
							DeleteRoleRequest deleteRoleReq = new DeleteRoleRequest();
							deleteRoleReq.setSessionID(sessionID);
							deleteRoleReq.setBrowserIP(ip);
							deleteRoleReq.setRoleName(roleId);
							DeleteRole deleteRole = new DeleteRole();
							deleteRole.setReq(deleteRoleReq);
							DeleteRoleResponseE deleteRoleRespE = 
								kaseyaStub.deleteRole(deleteRole);
							DeleteRoleResponse deleteRoleResp =
								deleteRoleRespE.getDeleteRoleResult();
							if (deleteRoleResp.getErrorMessage().length() > 0) {
								retVal = false;
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
										"deleteRoleResp error message: " + deleteRoleResp.getErrorMessage() + " " +
										"Error location: " + deleteRoleResp.getErrorLocation());	
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
										"sessionID: " + sessionID + " ip:" + ip);
							}					
						}
					}
				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"No role was found!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"getRolesResp error message: " + getRolesResp.getErrorMessage() + " " +
							"Error location: " + getRolesResp.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}

				/*
				 * Phase I-A: Eight, delete all scopes created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-A: Eight, delete all scopes created by the admin user");
				GetScopesRequest getScopesReq = new GetScopesRequest();
				getScopesReq.setSessionID(sessionID);
				GetScopes getScopes = new GetScopes();
				getScopes.setReq(getScopesReq);
				GetScopesResponseE getScopesRespE = 
					kaseyaStub.getScopes(getScopes);
				GetScopesResponse getScopesResp =
					getScopesRespE.getGetScopesResult();
				ArrayOfScope arrayOfScope = getScopesResp.getScopes();
				Scope[] scopes = null;
				if (arrayOfScope != null)
					scopes = arrayOfScope.getScope();
				if (scopes != null) {
					for (int i=0; i<scopes.length; i++) {
						String scopeId = scopes[i].getScopeID();
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
								"Deleting scopes[" + i + "]: " +
								scopeId);
						if (scopeId.equals("scope-"+username)) {
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
									"scopes[" + i + "]: " + scopeId + " will not be deleted at this point!");						
						} else {
							DeleteScopeRequest deleteScopeReq = new DeleteScopeRequest();
							deleteScopeReq.setSessionID(sessionID);
							deleteScopeReq.setScopeName(scopeId);
							DeleteScope deleteScope = new DeleteScope();
							deleteScope.setReq(deleteScopeReq);
							DeleteScopeResponseE deleteScopeRespE = 
								kaseyaStub.deleteScope(deleteScope);
							DeleteScopeResponse deleteScopeResp =
								deleteScopeRespE.getDeleteScopeResult();
							if (deleteScopeResp.getErrorMessage().length() > 0) {
								retVal = false;
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
										"deleteScopeResp error message: " + deleteScopeResp.getErrorMessage() + " " +
										"Error location: " + deleteScopeResp.getErrorLocation());	
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
										"sessionID: " + sessionID + " ip:" + ip);
							}					
						}
					}
				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"No scope was found!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"getScopesResp error message: " + getScopesResp.getErrorMessage() + " " +
							"Error location: " + getScopesResp.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}

				/*
				 * Phase I-B: Destory the admin user created previously by Master admin
				 */

				/*
				 * Phase I-B: First, login to KServer as the Master admin
				 * and get the ip address of this machine.
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"Phase I-B: First, login to KServer as the Master admin " +
				"and get the ip address of this machine.");
				sessionID = kaseyaAuthenticate();
				ip = getIP();

				/*
				 * Phase I-B: Second, delete the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-B: Second, delete the admin user");
				DeleteAdminRequest deleteAdminRequest = new DeleteAdminRequest();			
				deleteAdminRequest.setUserName(username);
				deleteAdminRequest.setBrowserIP(ip);
				deleteAdminRequest.setSessionID(sessionID);
				DeleteAdmin deleteAdmin = new DeleteAdmin();	
				deleteAdmin.setReq(deleteAdminRequest);
				DeleteAdminResponseE deleteAdminResponseE = 
					kaseyaStub.deleteAdmin(deleteAdmin);
				DeleteAdminResponse deleteAdminResponse = 
					deleteAdminResponseE.getDeleteAdminResult();
				if (deleteAdminResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"deleteAdminResponse error message: " + deleteAdminResponse.getErrorMessage() + " " +
							"Error location: " + deleteAdminResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}					

				/*
				 * Phase I-B: Third, delete the user role 
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-B: Third, delete the user role");
				DeleteRoleRequest deleteRoleRequest = new DeleteRoleRequest();
				deleteRoleRequest.setRoleName("role-"+username);
				deleteRoleRequest.setSessionID(sessionID);
				DeleteRole deleteRole = new DeleteRole();
				deleteRole.setReq(deleteRoleRequest);
				DeleteRoleResponseE deleteRoleResponseE = 
					kaseyaStub.deleteRole(deleteRole);
				DeleteRoleResponse deleteRoleResponse = 
					deleteRoleResponseE.getDeleteRoleResult();
				if (deleteRoleResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"deleteRoleResponse error message: " + deleteRoleResponse.getErrorMessage() + " " +
							"Error location: " + deleteRoleResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}							

				/*
				 * Phase I-B: Fourth, delete the user scope 
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase I-B: Fourth, delete the user scope");
				DeleteScopeRequest deleteScopeRequest = new DeleteScopeRequest();
				deleteScopeRequest.setScopeName("scope-"+username);
				deleteScopeRequest.setSessionID(sessionID);
				DeleteScope deleteScope = new DeleteScope();
				deleteScope.setReq(deleteScopeRequest);
				DeleteScopeResponseE deleteScopeResponseE = 
					kaseyaStub.deleteScope(deleteScope);
				DeleteScopeResponse deleteScopeResponse = 
					deleteScopeResponseE.getDeleteScopeResult();
				if (deleteScopeResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"deleteScopeResponse error message: " + deleteScopeResponse.getErrorMessage() + " " +
							"Error location: " + deleteScopeResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}							
			} else {				
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"The admin user " + username + 
						"was not previously created in the system!");
			}
			
			/*
	       	 * Phase II: Create a new admin user
	       	 */
			
			/*
	       	 * Phase II: First, login to KServer as the Master admin
	       	 * and get the ip address of this machine.
	       	 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase II: First, login to KServer as the Master admin " +
				"and get the ip address of this machine.");
			sessionID = kaseyaAuthenticate();
			String ip = getIP();
			
			/*
	       	 * Phase II: Second, create a user role  
	       	 *     Role Name: role-<USERNAME>
	       	 *     Role Type: VSA Admin
	       	 */
			String userRoleId = "role-"+username;
			String userRoleType = "VSA Admin";
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
					"Phase II: Second, create a user role " + userRoleId + " " + userRoleType);
			CreateRoleRequest createRoleRequest = new CreateRoleRequest();
			createRoleRequest.setBrowserIP(ip);
			createRoleRequest.setSessionID(sessionID);
			createRoleRequest.setRoleName(userRoleId);
			createRoleRequest.setRoleType(userRoleType);
			createRoleRequest.setParentRoleName("");
			CreateRole createRole = new CreateRole();
			createRole.setReq(createRoleRequest);
			CreateRoleResponseE createRoleResponseE = 
				kaseyaStub.createRole(createRole);
			CreateRoleResponse createRoleResponse = 
				createRoleResponseE.getCreateRoleResult();
			if (createRoleResponse.getErrorMessage().length() > 0) {
				retVal = false;
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"createRoleResponse error message: " + createRoleResponse.getErrorMessage() + " " +
						"Error location: " + createRoleResponse.getErrorLocation());	
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"sessionID: " + sessionID + " ip:" + ip);
			}							
			
			/*
	       	 * Phase II: Third, create a scope
	       	 *     Scope Name: scope-<USERNAME>
	       	 */
			String userScopeId = "scope-"+username;
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase II: Third, create a scope " + userScopeId);
			AddScopeRequest addScopeRequest = new AddScopeRequest();
			addScopeRequest.setSessionID(sessionID);
			addScopeRequest.setScopeName(userScopeId);
			AddScope addScope = new AddScope();
			addScope.setReq(addScopeRequest);
			AddScopeResponseE addScopeResponseE = 
				kaseyaStub.addScope(addScope);
			AddScopeResponse addScopeResponse = 
				addScopeResponseE.getAddScopeResult();
			if (addScopeResponse.getErrorMessage().length() > 0) {
				retVal = false;
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"addScopeResponse error message: " + addScopeResponse.getErrorMessage() + " " +
						"Error location: " + addScopeResponse.getErrorLocation());	
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"sessionID: " + sessionID + " ip:" + ip);
			}							
			
			/*
	       	 * Phase II: Fourth, create an admin user
	       	 *     Initial Role: role-<USERNAME>
	       	 *     Initial Scope: scope-<USERNAME>
	       	 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
				"Phase II: Fourth, create an admin user " + username);
			CreateAdminRequest createAdminRequest = new CreateAdminRequest();
			createAdminRequest.setEmailAddr(emailAddress);
			createAdminRequest.setUserName(username);
			createAdminRequest.setSessionAdmin("");
			createAdminRequest.setRoleID(userRoleId);
			createAdminRequest.setScopeID(userScopeId);

			// Hash password with username and random number and submit the form
			String coveredPassword = null;
			coveredPassword = coverPass(password, username);
			createAdminRequest.setCoveredPassword(coveredPassword);
			createAdminRequest.setForceNewPassword(false);

			createAdminRequest.setFirstName(firstName);
			createAdminRequest.setLastName(lastName);
			createAdminRequest.setOnVacationFlag(false);
			createAdminRequest.setVacationStartDate(Calendar.getInstance());
			createAdminRequest.setVacationEndDate(Calendar.getInstance());
			createAdminRequest.setOnSickLeaveFlag(false);
			createAdminRequest.setSickLeaveStartDate(Calendar.getInstance());
			createAdminRequest.setSickLeaveEndDate(Calendar.getInstance());		       	
			createAdminRequest.setBrowserIP(ip);
			createAdminRequest.setSessionID(sessionID);

			CreateAdmin createAdmin = new CreateAdmin();	
			createAdmin.setReq(createAdminRequest);
			CreateAdminResponseE createAdminResponseE = 
				kaseyaStub.createAdmin(createAdmin);
			CreateAdminResponse createAdminResponse = 
				createAdminResponseE.getCreateAdminResult();
			if (createAdminResponse.getErrorMessage().length() > 0) {
				retVal = false;
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"createAdminResponse error message: " + createAdminResponse.getErrorMessage() + " " +
						"Error location: " + createAdminResponse.getErrorLocation());	
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] " +
						"sessionID: " + sessionID + " ip:" + ip);
			}							

		} catch(Exception e) {
			retVal = false;
			e.printStackTrace();	
		}	

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - refreshAdmin] Ready to get out!");

		return retVal;
		
	}
	
	/*
	public boolean createAdmin(
			String username,
			String password,
			String emailAddress,
			String firstName,
			String lastName) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] Inside!");

		Boolean retVal = false;
		
		try {
			
			BigDecimal sessionID = kaseyaAuthenticate();
			String ip = getIP();
			String userScope = "scope-" + username;
			String userRoleID = "VSA-Core";
			String userSessionAdmin = "";
			
			AddScopeRequest addScopeRequest = new AddScopeRequest();
			addScopeRequest.setScopeName(userScope);
			addScopeRequest.setSessionID(sessionID);
			AddScope addScope = new AddScope();
			addScope.setReq(addScopeRequest);
			AddScopeResponseE addScopeResponseE = 
				kaseyaStub.addScope(addScope);
			AddScopeResponse addScopeResponse = 
				addScopeResponseE.getAddScopeResult();
	       	DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] \n\t" +
	       			"getErrorLocation(): " + addScopeResponse.getErrorLocation() + " \n\t" +
	       			"getErrorMessage(): " + addScopeResponse.getErrorMessage() + " \n\t" +
	       			"getMethod(): " + addScopeResponse.getMethod());
			
	       	if (addScopeResponse.getErrorMessage().length() == 0) {
	       		
	       		CreateAdminRequest createAdminRequest = new CreateAdminRequest();

	       		createAdminRequest.setEmailAddr(emailAddress);
	       		createAdminRequest.setUserName(username);
	       		createAdminRequest.setSessionAdmin(userSessionAdmin);
	       		createAdminRequest.setRoleID(userRoleID);
	       		createAdminRequest.setScopeID(userScope);

	       		// Hash password with username and random number and submit the form
	       		String coveredPassword = coverPass(password, username);
	       		createAdminRequest.setCoveredPassword(coveredPassword);
	       		createAdminRequest.setForceNewPassword(false);

	       		createAdminRequest.setFirstName(firstName);
	       		createAdminRequest.setLastName(lastName);
	       		createAdminRequest.setOnVacationFlag(false);
	       		createAdminRequest.setVacationStartDate(Calendar.getInstance());
	       		createAdminRequest.setVacationEndDate(Calendar.getInstance());
	       		createAdminRequest.setOnSickLeaveFlag(false);
	       		createAdminRequest.setSickLeaveStartDate(Calendar.getInstance());
	       		createAdminRequest.setSickLeaveEndDate(Calendar.getInstance());		       	
	       		createAdminRequest.setBrowserIP(ip);
	       		createAdminRequest.setSessionID(sessionID);

	       		CreateAdmin createAdmin = new CreateAdmin();	
	       		createAdmin.setReq(createAdminRequest);
	       		CreateAdminResponseE createAdminResponseE = 
	       			kaseyaStub.createAdmin(createAdmin);
	       		CreateAdminResponse createAdminResponse = 
	       			createAdminResponseE.getCreateAdminResult();
	       		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] \n\t" +
	       				"getErrorLocation(): " + createAdminResponse.getErrorLocation() + " \n\t" +
	       				"getErrorMessage(): " + createAdminResponse.getErrorMessage() + " \n\t" +
	       				"getMethod(): " + createAdminResponse.getMethod());

	       		if (createAdminResponse.getErrorMessage().length() == 0)
	    	       	retVal = true;
	       		else {
	       			
	       			deleteAdmin(username, password);
	       			
	       		}

	       	}
	       	
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}	

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] Ready to get out!");

		return retVal;
		
	}
	*/
	
	private String[] userRoleId;
	private String[] userRoleType;
	private String[] userScopeId;
	private String[] deptName;
	private String[] parentDeptName;
	private String[][] naFirstName;
	private String[] naLastName;
	private String[][] naUserName;
	private String[] naRoleID;
	private String[][] naScopeID;
	private String[][] naDeptName;
	private String[] naPurpose;
				
	private void setUserVars(String username, String firstName, String lastName) {
		
		naFirstName = new String[][] {
				{"Ted", "Tim", "Tia", "Tod"},
				{"Tom", "Tru"},
				{"Cat", "Cay", "Con"},
				{firstName}};
		naLastName = new String[] {
				"Technician", 
				"Technician", 
				"Contact",
				lastName};

		userRoleId = new String [] {"SD-Technician-"+username, "Contact-"+username, "SD Admin"};
		userRoleType = new String [] {"Service Desk Technician", "Basic End User", "Service Desk Admin"};

		userScopeId = new String[] {
				"SD-Technician-"+username, 
				"scis-"+username,
				"mr-"+username,
				"gl-"+username,
				"cec-"+username};

		deptName = new String[] {
				"university_technology_services",
				"machine_room",
				"school_of_computing_and_information_sciences",
				"green_library",
				"college_of_computing_and_engineering"};
		parentDeptName = new String[] {
				"",
				"school_of_computing_and_information_sciences",
				"",
				"",
				""};

		naUserName = new String[][] {
				{	naFirstName[0][0].toLowerCase()+"-" + username, 
					naFirstName[0][1].toLowerCase()+"-" + username, 
					naFirstName[0][2].toLowerCase()+"-" + username, 
					naFirstName[0][3].toLowerCase()+"-" + username}, 
				{	naFirstName[1][0].toLowerCase()+"-" + username, 
					naFirstName[1][1].toLowerCase()+"-" + username}, 
				{	naFirstName[2][0].toLowerCase()+"-" + username, 
					naFirstName[2][1].toLowerCase()+"-" + username, 
					naFirstName[2][2].toLowerCase()+"-" + username}, 
				{username}};
		naRoleID  = new String[] {
				"SD-Technician-"+username, 
				"SD-Technician-"+username, 
				"Contact-"+username,
				sysRole};
		naScopeID = new String[][] {
				{"SD-Technician-"+username, "SD-Technician-"+username, "SD-Technician-"+username, "SD-Technician-"+username}, 
				{"SD-Technician-"+username, "SD-Technician-"+username}, 
				{"scis-"+username, "gl-"+username, "cec-"+username},
				{sysScope}};
		naDeptName = new String[][] {
				{"university_technology_services", "university_technology_services", "university_technology_services", "university_technology_services"},
				{"university_technology_services", "university_technology_services"},
				{"school_of_computing_and_information_sciences", "green_library", "college_of_computing_and_engineering"},
				{"university_technology_services"}};
		naPurpose = new String[] {
				"Tier 1 Support", 
				"Tier 2 Support", 
				"Contact Person",
				"Learing Kaseya Service Desk and Getting My Certificate!"};
	
	}
	
	public boolean createAdmin(
			String username,
			String password,
			String emailAddress,
			String firstName,
			String lastName) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] Inside!");

		Boolean retVal = true;
		
		try {
			
			// SMS: Added to support 7.0 on eFront
			String orgRef 		= "";
			String emailSuffix 	= "";
			if (promoCode.equals("KU-7") || promoCode.equals("KU-7-1D")) {
				orgRef 		= "ittc-" + username;
				emailSuffix = "@ittc.com";
			} else {
				orgRef 		= "fiu-" + username;
				emailSuffix = "@" + orgRef + ".edu";
			}
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"orgRef is " + orgRef + " and emailSuffix is " + emailSuffix + 
					" for the promoCode of " + promoCode);
			// String orgRef = "fiu-" + username;
			// String emailSuffix = "@" + orgRef + ".edu";
			// End addition

			/*
			 * First, login to KServer as the Master admin
			 * and get the ip address of this machine.
			 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"First, login to KServer as the Master admin " +
			"and get the ip address of this machine.");
			// When creating the first admin right after the partition is created, we may 
			// need to wait for a while until the partition is ready.
			// BigDecimal sessionID = kaseyaAuthenticate();
			BigDecimal zero = new BigDecimal(0);
			int attemptCounter = 0;
			int delay = 10000;
			int delayIncrement = 5000;
			int maxAttempt = 1;
			do {
				attemptCounter++;
				
				try {
					sessionID = kaseyaAuthenticate();
				} catch (ConnectTimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] sessionID: " + sessionID);

					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] ConnectTimeoutException occured!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] Ready to get out!");
					attemptCounter =  maxAttempt;
					break;
				}

				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] " +
						"username: " + sysUsername + " password: " + sysPassword +
						" attemptCounter: " + attemptCounter +
						" sessionID: " + sessionID);

				if (sessionID.equals(zero) && (attemptCounter < maxAttempt)) {
					delay += delayIncrement;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] " + 
							"sleeping for " + delay/1000 + " second waiting for the queue on KServer to respond!");
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} while (sessionID.equals(zero) && (attemptCounter < maxAttempt));

			String ip = getIP();

			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"sysRole: " + sysRole + " " +
					"sysScope: " + sysScope);

			// SMS: 2013-05-04
			// No more VSA-Core and kserver2
			/*
			if (!sysRole.equals("System")) {
				/ *
				 * Second, create a user role  
				 *     Role Name: role-<USERNAME>
				 *     Role Type: VSA Admin
				 * /
				String userRoleId = "role-"+username;
				String userRoleType = "VSA Admin";
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Second, create a user role " + userRoleId + " " + userRoleType);
				CreateRoleRequest createRoleRequest = new CreateRoleRequest();
				createRoleRequest.setBrowserIP(ip);
				createRoleRequest.setSessionID(sessionID);
				createRoleRequest.setRoleName(userRoleId);
				createRoleRequest.setRoleType(userRoleType);
				createRoleRequest.setParentRoleName("");
				CreateRole createRole = new CreateRole();
				createRole.setReq(createRoleRequest);
				CreateRoleResponseE createRoleResponseE = 
					kaseyaStub.createRole(createRole);
				CreateRoleResponse createRoleResponse = 
					createRoleResponseE.getCreateRoleResult();
				if (createRoleResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"createRoleResponse error message: " + createRoleResponse.getErrorMessage() + " " +
							"Error location: " + createRoleResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}							

				/ *
				 * Third, create a scope
				 *     Scope Name: scope-<USERNAME>
				 * /
				String userScopeId = "scope-"+username;
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Third, create a scope " + userScopeId);
				AddScopeRequest addScopeRequest = new AddScopeRequest();
				addScopeRequest.setSessionID(sessionID);
				addScopeRequest.setScopeName(userScopeId);
				AddScope addScope = new AddScope();
				addScope.setReq(addScopeRequest);
				AddScopeResponseE addScopeResponseE = 
					kaseyaStub.addScope(addScope);
				AddScopeResponse addScopeResponse = 
					addScopeResponseE.getAddScopeResult();
				if (addScopeResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"addScopeResponse error message: " + addScopeResponse.getErrorMessage() + " " +
							"Error location: " + addScopeResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}
				
				sysRole = "VSA-Core";
				sysScope = userScopeId;
			}
			*/
			
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"sysRole: " + sysRole + " " +
					"sysScope: " + sysScope);

			/*
			 * Fourth, create an admin user
			 *     Initial Role: role-<USERNAME>
			 *     Initial Scope: scope-<USERNAME>
			 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"Fourth, create an admin user " + username);
			CreateAdminRequest createAdminRequest = new CreateAdminRequest();
			// createAdminRequest.setEmailAddr(emailAddress);
			createAdminRequest.setEmailAddr(username+emailSuffix);
			createAdminRequest.setUserName(username);
			createAdminRequest.setSessionAdmin("");
			// createAdminRequest.setRoleID(userRoleId);
			createAdminRequest.setRoleID(sysRole);
			createAdminRequest.setScopeID(sysScope);

			// Hash password with username and random number and submit the form
			String coveredPassword = coverPass(password, username);
			createAdminRequest.setCoveredPassword(coveredPassword);
			createAdminRequest.setForceNewPassword(false);

			createAdminRequest.setFirstName(firstName);
			createAdminRequest.setLastName(lastName);
			createAdminRequest.setOnVacationFlag(false);
			createAdminRequest.setVacationStartDate(Calendar.getInstance());
			createAdminRequest.setVacationEndDate(Calendar.getInstance());
			createAdminRequest.setOnSickLeaveFlag(false);
			createAdminRequest.setSickLeaveStartDate(Calendar.getInstance());
			createAdminRequest.setSickLeaveEndDate(Calendar.getInstance());		       	
			createAdminRequest.setBrowserIP(ip);
			/*
			createAdminRequest.setSessionID(sessionID);

			CreateAdmin createAdmin = new CreateAdmin();	
			createAdmin.setReq(createAdminRequest);
			CreateAdminResponseE createAdminResponseE = 
				kaseyaStub.createAdmin(createAdmin);
			*/
			CreateAdminResponse createAdminResponse = null;
			CreateAdmin createAdmin = null;	
			CreateAdminResponseE createAdminResponseE = null; 
			
			attemptCounter = 0;
			delay = 10000;
			delayIncrement = 5000;
			maxAttempt = 1;
			do {
				attemptCounter++;
				
				try {
					sessionID = kaseyaAuthenticate();
				} catch (ConnectTimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] sessionID: " + sessionID);

					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] ConnectTimeoutException occured!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin()] Ready to get out!");
					attemptCounter =  maxAttempt;
					break;
				}
				createAdminRequest.setSessionID(sessionID);

				createAdmin = new CreateAdmin();	
				createAdmin.setReq(createAdminRequest);
				createAdminResponseE = 
					kaseyaStub.createAdmin(createAdmin);
//				CreateAdminResponse createAdminResponse = null;
				
				createAdminResponse = 
					createAdminResponseE.getCreateAdminResult();

				if ((createAdminResponse.getErrorMessage().length() > 0) && (attemptCounter < maxAttempt)) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"createAdminResponse error message: " + createAdminResponse.getErrorMessage() + " " +
							"Error location: " + createAdminResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
					
					delay += delayIncrement;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sleeping for " + delay/1000 + " second waiting for the queue on KServer to respond!");
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"createAdminResponse error message: " + createAdminResponse.getErrorMessage() + " " +
							"Error location: " + createAdminResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
					retVal = true;
				}

			} while ((createAdminResponse.getErrorMessage().length() > 0) && (attemptCounter < maxAttempt));


			/*
			 * Four and a half
			 * 	Authenticate using the new admin user
			 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"Four and a half, authenticate using the newly created admin user: " + username);
			sessionID = kaseyaAuthenticate(username, password);
			ip = getIP();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"The new seesion id is: " + sessionID);

			/*
			 * Fifth, prepare the environment based on promoCode
			 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
					"Fifth, prepare the environment based of the promoCode: " + promoCode);
			// SMS: To accommodate ITS-KSDW-14-1D
			// if (promoCode.equals(ITSKSDW) || (promoCode.equals(ITSKSDW14))) {
			if (promoCode.contains("KSDW")) {
				
				// Setting the user variables
				setUserVars(username, firstName, lastName);
				
				// Creating the roles
				// String[] userRoleId = {"SD-Technician-"+username, "Contact-"+username, "SD Admin"};
				// String[] userRoleType = {"Service Desk Technician", "Basic End User", "Service Desk Admin"};
				for (int i=0; i<2; i++) {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"Creating user role " + userRoleId[i] + " " + userRoleType[i]);
					CreateRoleRequest createRoleRequest = new CreateRoleRequest();
					createRoleRequest.setBrowserIP(ip);
					createRoleRequest.setSessionID(sessionID);
					createRoleRequest.setRoleName(userRoleId[i]);
					createRoleRequest.setRoleType(userRoleType[i]);
					createRoleRequest.setParentRoleName("");
					CreateRole createRole = new CreateRole();
					createRole.setReq(createRoleRequest);
					CreateRoleResponseE createRoleResponseE = 
						kaseyaStub.createRole(createRole);
					CreateRoleResponse createRoleResponse = 
						createRoleResponseE.getCreateRoleResult();
					if (createRoleResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"createRoleResponse error message: " + createRoleResponse.getErrorMessage() + " " +
								"Error location: " + createRoleResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}							
				}
				
				// Add all roles to username
				for (int i=0; i<3; i++) {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"Adding " + username + " to role " + userRoleId[i]);
					AddUserToRoleRequest addUserToRoleRequest = new AddUserToRoleRequest();
					addUserToRoleRequest.setRoleID(userRoleId[i]);
					addUserToRoleRequest.setUserName(username);
					addUserToRoleRequest.setSessionID(sessionID);
					
					AddUserToRole addUserToRole = new AddUserToRole();
					addUserToRole.setReq(addUserToRoleRequest);
					AddUserToRoleResponseE addUserToRoleResponseE =
						kaseyaStub.addUserToRole(addUserToRole);
					AddUserToRoleResponse addUserToRoleResponse = 
						addUserToRoleResponseE.getAddUserToRoleResult();
					if (addUserToRoleResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"addUserToRoleResponse error message: " + addUserToRoleResponse.getErrorMessage() + " " +
								"Error location: " + addUserToRoleResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}							
				}
				
				// Creating the scopes
				/*
				String[] userScopeId = {
						"SD-Technician-"+username, 
						"scis-"+username,
						"mr-"+username,
						"gl-"+username,
						"cec-"+username};
				*/
				for (int i=0; i<5; i++) {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"Creating scope " + userScopeId[i]);
					AddScopeRequest addScopeRequest = new AddScopeRequest();
					addScopeRequest.setSessionID(sessionID);
					addScopeRequest.setScopeName(userScopeId[i]);
					AddScope addScope = new AddScope();
					addScope.setReq(addScopeRequest);
					AddScopeResponseE addScopeResponseE = 
						kaseyaStub.addScope(addScope);
					AddScopeResponse addScopeResponse = 
						addScopeResponseE.getAddScopeResult();
					if (addScopeResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"addScopeResponse error message: " + addScopeResponse.getErrorMessage() + " " +
								"Error location: " + addScopeResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}
				}
				
				// Add all scopes to username
				for (int i=0; i<5; i++) {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"Adding " + username + " to scope " + userScopeId[i]);
					AddUserToScopeRequest addUserToScopeRequest = new AddUserToScopeRequest();
					addUserToScopeRequest.setScopeID(userScopeId[i]);
					addUserToScopeRequest.setUserName(username);
					addUserToScopeRequest.setSessionID(sessionID);
					
					AddUserToScope addUserToScope = new AddUserToScope();
					addUserToScope.setReq(addUserToScopeRequest);
					AddUserToScopeResponseE addUserToScopeResponseE =
						kaseyaStub.addUserToScope(addUserToScope);
					AddUserToScopeResponse addUserToScopeResponse = 
						addUserToScopeResponseE.getAddUserToScopeResult();
					if (addUserToScopeResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"addUserToScopeResponse error message: " + addUserToScopeResponse.getErrorMessage() + " " +
								"Error location: " + addUserToScopeResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}							
				}
				
				// Adding the organization
				// String orgRef = "FIU-" + username;
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Adding organization " + orgRef);
				AddOrgRequest addOrgRequest = 
					new AddOrgRequest();
				addOrgRequest.setOrgRef(orgRef);
				addOrgRequest.setOrgParentRef("");
				addOrgRequest.setOrgName("Florida Internationa University - " + username);
				addOrgRequest.setDefaultMgName("scis");
				addOrgRequest.setDefaultDeptName("school_of_computing_and_information_sciences");
				addOrgRequest.setOrgType("Internal");
				addOrgRequest.setAnnRevenue(9999);
				addOrgRequest.setNoEmps(4000);
				addOrgRequest.setAddr1("11200 SW 8th St.");
				addOrgRequest.setCity("Miami");
				addOrgRequest.setPostalCode("33199");
				addOrgRequest.setCountryRef("United States");
				addOrgRequest.setMethodOfContact("Email");
				addOrgRequest.setState("Florida");
				addOrgRequest.setWebsite("www.cis.fiu.edu");
				addOrgRequest.setBrowserIP(ip);
				addOrgRequest.setSessionID(sessionID);
				addOrgRequest.setPrimaryStaffFK(new BigDecimal(0));

				AddOrg addOrg = new AddOrg();	
				addOrg.setReq(addOrgRequest);
				kaseyaws.AddOrgResponseE addOrgResponseE = 
					kaseyaStub.addOrg(addOrg);
				AddOrgResponse addOrgResponse = 
					addOrgResponseE.getAddOrgResult();
				if (addOrgResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"addOrgResponse error message: " + addOrgResponse.getErrorMessage() + " " +
							"Error location: " + addOrgResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}							

				// Adding the org to scope
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Adding the org " + orgRef + " to scope " + userScopeId[0]);
				AddOrgToScopeRequest addOrgToScopeRequest = 
					new AddOrgToScopeRequest();
				addOrgToScopeRequest.setScopeID(userScopeId[0]);
				addOrgToScopeRequest.setCompanyID(orgRef);
				addOrgToScopeRequest.setSessionID(sessionID);

				AddOrgToScope addOrgToScope = new AddOrgToScope();	
				addOrgToScope.setReq(addOrgToScopeRequest);
				AddOrgToScopeResponseE addOrgToScopeResponseE = 
					kaseyaStub.addOrgToScope(addOrgToScope);
				AddOrgToScopeResponse addOrgToScopeResponse = 
					addOrgToScopeResponseE.getAddOrgToScopeResult();
				if (addOrgToScopeResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"addOrgToScopeResponse error message: " + addOrgToScopeResponse.getErrorMessage() + " " +
							"Error location: " + addOrgToScopeResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}							

				// Creating the machine groups
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Creating the machine groups");
				String[] machineGroup = {"scis", "mr", "gl", "cec"};
				for (int i=0; i<machineGroup.length; i++) {
					
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"Creating machine group " + machineGroup[i]);
					CreateMachineGroupRequest createMachineGroupRequest = 
						new CreateMachineGroupRequest();
					createMachineGroupRequest.setOrgName(orgRef);
					createMachineGroupRequest.setGroupName(machineGroup[i]);
					// createMachineGroupRequest.setParentName("");
					createMachineGroupRequest.setBrowserIP(ip);
					createMachineGroupRequest.setSessionID(sessionID);

					CreateMachineGroup createMachineGroup = new CreateMachineGroup();	
					createMachineGroup.setReq(createMachineGroupRequest);
					CreateMachineGroupResponseE createMachineGroupResponseE = 
						kaseyaStub.createMachineGroup(createMachineGroup);
					CreateMachineGroupResponse createMachineGroupResponse = 
						createMachineGroupResponseE.getCreateMachineGroupResult();
					if (createMachineGroupResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"createMachineGroupResponse error message: " + createMachineGroupResponse.getErrorMessage() + " " +
								"Error location: " + createMachineGroupResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}							
				}

				// Adding the machine groups to scopes
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Adding the machine groups to scopes!");
				for (int i=0; i<machineGroup.length; i++) {
					
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"Adding machine group " + machineGroup[i] + " to scope " + userScopeId[i+1]);
					AddMachGroupToScopeRequest addMachGroupToScopeRequest = 
						new AddMachGroupToScopeRequest();
					addMachGroupToScopeRequest.setGroupName(orgRef + "." + machineGroup[i]);
					addMachGroupToScopeRequest.setScopeName(userScopeId[i+1]);
					addMachGroupToScopeRequest.setSessionID(sessionID);

					AddMachGroupToScope addMachGroupToScope = new AddMachGroupToScope();	
					addMachGroupToScope.setReq(addMachGroupToScopeRequest);
					AddMachGroupToScopeResponseE addMachGroupToScopeResponseE = 
						kaseyaStub.addMachGroupToScope(addMachGroupToScope);
					AddMachGroupToScopeResponse addMachGroupToScopeResponse = 
						addMachGroupToScopeResponseE.getAddMachGroupToScopeResult();
					if (addMachGroupToScopeResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"addMachGroupToScopeResponse error message: " + addMachGroupToScopeResponse.getErrorMessage() + " " +
								"Error location: " + addMachGroupToScopeResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}							
				}

				// Adding the departments
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Adding departments to " + orgRef);
				/*
				String[] deptName = {
						"university_technology_services",
						"machine_room",
						"school_of_computing_and_information_sciences",
						"green_library",
						"college_of_computing_and_engineering"};
				String[] parentDeptName = {
						"",
						"school_of_computing_and_information_sciences",
						"",
						"",
						""};
				*/
				
				for (int i=0; i<5; i++) {
					AddOrgDepartmentRequest addOrgDepartmentRequest = 
						new AddOrgDepartmentRequest();
					addOrgDepartmentRequest.setOrgName(orgRef);
					addOrgDepartmentRequest.setDepartmentName(deptName[i]);
					addOrgDepartmentRequest.setParentName(parentDeptName[i]);
					addOrgDepartmentRequest.setManagerName("");
					addOrgDepartmentRequest.setSessionID(sessionID);

					AddOrgDepartment addOrgDepartment = new AddOrgDepartment();	
					addOrgDepartment.setReq(addOrgDepartmentRequest);
					AddOrgDepartmentResponseE addOrgDepartmentResponseE = 
						kaseyaStub.addOrgDepartment(addOrgDepartment);
					AddOrgDepartmentResponse addOrgDepartmentResponse = 
						addOrgDepartmentResponseE.getAddOrgDepartmentResult();
					if (addOrgDepartmentResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"addOrgDepartmentResponse error message: " + addOrgDepartmentResponse.getErrorMessage() + " " +
								"Error location: " + addOrgDepartmentResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}							
				}
				
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Adding staff members to " + orgRef);
				/*
				String[][] naUserName = {
						{"tier1-1-" + username, "tier1-2-" + username, "tier1-3-" + username, "tier1-4-" + username},
						{"tier2-1-" + username, "tier2-2-" + username},
						{"contact-scis-" + username, "contact-gl-" + username, "contact-cec-" + username},
						{username}};
				String[][] naUserName = {
						{	naFirstName[0][0].toLowerCase()+naLastName[0].toLowerCase()+"-" + username, 
							naFirstName[0][1].toLowerCase()+naLastName[0].toLowerCase()+"-" + username, 
							naFirstName[0][2].toLowerCase()+naLastName[0].toLowerCase()+"-" + username, 
							naFirstName[0][3].toLowerCase()+naLastName[0].toLowerCase()+"-" + username}, 
						{	naFirstName[1][0].toLowerCase()+naLastName[1].toLowerCase()+"-" + username, 
							naFirstName[1][1].toLowerCase()+naLastName[1].toLowerCase()+"-" + username}, 
						{	naFirstName[2][0].toLowerCase()+naLastName[2].toLowerCase()+"-" + username, 
							naFirstName[2][1].toLowerCase()+naLastName[2].toLowerCase()+"-" + username, 
							naFirstName[2][2].toLowerCase()+naLastName[2].toLowerCase()+"-" + username}, 
						{username}};
				*/
				/*
				String[][] naFirstName = {
						{"Jack", "Jill", "Jeff", "Jenn"},
						{"Ben", "Ken"},
						{"Tim", "Kim", "Jim"},
						{firstName}};
				String[] naLastName = {
						"Tier1", 
						"Tier2", 
						"Contact",
						lastName};
				String[][] naUserName = {
						{	naFirstName[0][0].toLowerCase()+"-" + username, 
							naFirstName[0][1].toLowerCase()+"-" + username, 
							naFirstName[0][2].toLowerCase()+"-" + username, 
							naFirstName[0][3].toLowerCase()+"-" + username}, 
						{	naFirstName[1][0].toLowerCase()+"-" + username, 
							naFirstName[1][1].toLowerCase()+"-" + username}, 
						{	naFirstName[2][0].toLowerCase()+"-" + username, 
							naFirstName[2][1].toLowerCase()+"-" + username, 
							naFirstName[2][2].toLowerCase()+"-" + username}, 
						{username}};
				String[] naRoleID  = {
						"SD-Technician-"+username, 
						"SD-Technician-"+username, 
						"Contact-"+username,
						sysRole};
				String[][] naScopeID = {
						{"SD-Technician-"+username, "SD-Technician-"+username, "SD-Technician-"+username, "SD-Technician-"+username}, 
						{"SD-Technician-"+username, "SD-Technician-"+username}, 
						{"scis-"+username, "gl-"+username, "cec-"+username},
						{sysScope}};
				String[][] naDeptName = {
						{"university_technology_services", "university_technology_services", "university_technology_services", "university_technology_services"},
						{"university_technology_services", "university_technology_services"},
						{"school_of_computing_and_information_sciences", "green_library", "college_of_computing_and_engineering"},
						{"university_technology_services"}};
				String[] naPurpose = {
						"Tier 1 Support", 
						"Tier 2 Support", 
						"Contact Person",
						"Learing Kaseya Service Desk and Getting My Certificate!"};
				*/
				
				// Creating users for Tier 1, Tier 2, and Contacts
				for (int i=0; i<3; i++) {
					for (int j=0; j<naFirstName[i].length; j++) {

						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"Creating user " + naUserName[i][j]);
						createAdminRequest = new CreateAdminRequest();
						// createAdminRequest.setEmailAddr(emailAddress);
						createAdminRequest.setEmailAddr(naUserName[i][j]+emailSuffix);
						createAdminRequest.setUserName(naUserName[i][j]);
						createAdminRequest.setSessionAdmin("");
						createAdminRequest.setRoleID(naRoleID[i]);
						createAdminRequest.setScopeID(naScopeID[i][j]);

						// Hash password with username and random number and submit the form
						coveredPassword = coverPass(password, naUserName[i][j]);
						createAdminRequest.setCoveredPassword(coveredPassword);
						createAdminRequest.setForceNewPassword(false);

						createAdminRequest.setFirstName(naFirstName[i][j]);
						createAdminRequest.setLastName(naLastName[i]);
						// createAdminRequest.setStaffMemberRef(orgRef);
						// createAdminRequest.setStaffDeptRef(orgRef+ "." + naDeptName[i][j]);
						createAdminRequest.setOnVacationFlag(false);
						createAdminRequest.setVacationStartDate(Calendar.getInstance());
						createAdminRequest.setVacationEndDate(Calendar.getInstance());
						createAdminRequest.setOnSickLeaveFlag(false);
						createAdminRequest.setSickLeaveStartDate(Calendar.getInstance());
						createAdminRequest.setSickLeaveEndDate(Calendar.getInstance());		       	
						createAdminRequest.setBrowserIP(ip);
						createAdminRequest.setSessionID(sessionID);
						
						createAdmin = new CreateAdmin();	
						createAdmin.setReq(createAdminRequest);
						createAdminResponseE = 
							kaseyaStub.createAdmin(createAdmin);
						createAdminResponse = 
							createAdminResponseE.getCreateAdminResult();
						if (createAdminResponse.getErrorMessage().length() > 0) {
							retVal = false;
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
									"createAdminResponse error message: " + createAdminResponse.getErrorMessage() + " " +
									"Error location: " + createAdminResponse.getErrorLocation());	
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
									"sessionID: " + sessionID + " ip:" + ip);
						}							
					}
				}
				
				// Adding the staff members
				for (int i=0; i<4; i++) {
					for (int j=0; j<naFirstName[i].length; j++) {

						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"Adding staff " + naUserName[i][j]);
						AddOrgDeptStaffRequest addOrgDeptStaffRequest = 
							new AddOrgDeptStaffRequest();
						addOrgDeptStaffRequest.setOrgRef(orgRef);
						addOrgDeptStaffRequest.setFullName(naFirstName[i][j] + " " + naLastName[i]);
						addOrgDeptStaffRequest.setDeptRef(orgRef + "." + naDeptName[i][j]);
						// addOrgDeptStaffRequest.setManagerRef("");
						// addOrgDeptStaffRequest.setEmailAddress(emailAddress);
						addOrgDeptStaffRequest.setEmailAddress(naUserName[i][j]+emailSuffix);
						addOrgDeptStaffRequest.setPhoneNumber("800-000-0000");
						addOrgDeptStaffRequest.setPurpose(naPurpose[i]);
						// addOrgDeptStaffRequest.setStatus(0);
						addOrgDeptStaffRequest.setTitle(naPurpose[i]);
						addOrgDeptStaffRequest.setUserName(naUserName[i][j]);
						addOrgDeptStaffRequest.setViewAllTicketsFlag(true);
						addOrgDeptStaffRequest.setSessionID(sessionID);
						
						AddOrgDeptStaff addOrgDeptStaff = new AddOrgDeptStaff();	
						addOrgDeptStaff.setReq(addOrgDeptStaffRequest);
						AddOrgDeptStaffResponseE addOrgDepartmentResponseE = 
							kaseyaStub.addOrgDeptStaff(addOrgDeptStaff);
						AddOrgDeptStaffResponse addOrgDeptStaffResponse = 
							addOrgDepartmentResponseE.getAddOrgDeptStaffResult();
						if (addOrgDeptStaffResponse.getErrorMessage().length() > 0) {
							retVal = false;
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
									"addOrgDeptStaffResponse error message: " + addOrgDeptStaffResponse.getErrorMessage() + " " +
									"Error location: " + addOrgDeptStaffResponse.getErrorLocation());	
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
									"sessionID: " + sessionID + " ip:" + ip);
						}							
					}
				}

				// Adding contact-scis to mr
				String tempUserName = naUserName[2][0];
				String tempScopeId = userScopeId[2];
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
						"Adding " + tempUserName + " to scope " + tempScopeId);
				AddUserToScopeRequest addUserToScopeRequest = new AddUserToScopeRequest();
				addUserToScopeRequest.setScopeID(tempScopeId);
				addUserToScopeRequest.setUserName(tempUserName);
				addUserToScopeRequest.setSessionID(sessionID);
				
				AddUserToScope addUserToScope = new AddUserToScope();
				addUserToScope.setReq(addUserToScopeRequest);
				AddUserToScopeResponseE addUserToScopeResponseE =
					kaseyaStub.addUserToScope(addUserToScope);
				AddUserToScopeResponse addUserToScopeResponse = 
					addUserToScopeResponseE.getAddUserToScopeResult();
				if (addUserToScopeResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"addUserToScopeResponse error message: " + addUserToScopeResponse.getErrorMessage() + " " +
							"Error location: " + addUserToScopeResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}							
				
				// Creating the agent install packages
				for (int i=0; i<=machineGroup.length; i++) {
				
					String agentInstallPackageName 	= "";
					String agentInstallPackageDesc 	= "";
					String groupName 				= "";
					if (i == 0) {						
						agentInstallPackageName = "DefaultPackage-" + username;
						agentInstallPackageDesc = "Default ackage for " + username + ".";
						// groupName = null;
						// groupName = orgRef;
						groupName = "root.unnamed";
					} else {
						agentInstallPackageName = "package4" + machineGroup[i-1] + "-" + username;
						agentInstallPackageDesc = "Package for " + machineGroup[i-1] + " for " + username + ".";
						groupName = machineGroup[i-1] + "." + orgRef;
						// groupName = orgRef + "." + machineGroup[i-1];
					}
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"Creating agent install package " + agentInstallPackageName);
					CreatePackageRequest createPackageRequest = 
						new CreatePackageRequest();
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"\n\nBefore setting createPackageRequest:" +
							"\n\tgetAgentType: " + createPackageRequest.getAgentType() +
							"\n\tgetPackageName: " + createPackageRequest.getPackageName() +
							"\n\tgetPackageDescription: " + createPackageRequest.getPackageDescription() +
							"\n\tgetGroupName: " + createPackageRequest.getGroupName() +
							"\n\tgetCommandLineSwitches: " + createPackageRequest.getCommandLineSwitches() +
							"\n\tgetDefaultAccount: " + createPackageRequest.getDefaultAccount() +
							"\n\tgetSessionID: " + createPackageRequest.getSessionID());
					createPackageRequest.setPackageName(agentInstallPackageName);
					createPackageRequest.setPackageDescription(agentInstallPackageDesc);
					// createPackageRequest.setCommandLineSwitches("/e /g=" + machineGroup[i-1] + "." + orgRef + " /c");
					// createPackageRequest.setCommandLineSwitches("");
					createPackageRequest.setAgentType(0);
					createPackageRequest.setDefaultAccount(new BigDecimal(0));
					createPackageRequest.setGroupName(groupName);
					createPackageRequest.setBrowserIP(ip);
					createPackageRequest.setSessionID(sessionID);
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
							"\n\nAfter setting createPackageRequest:" +
							"\n\tgetAgentType: " + createPackageRequest.getAgentType() +
							"\n\tgetPackageName: " + createPackageRequest.getPackageName() +
							"\n\tgetPackageDescription: " + createPackageRequest.getPackageDescription() +
							"\n\tgetGroupName: " + createPackageRequest.getGroupName() +
							"\n\tgetCommandLineSwitches: " + createPackageRequest.getCommandLineSwitches() +
							"\n\tgetDefaultAccount: " + createPackageRequest.getDefaultAccount() +
							"\n\tgetSessionID: " + createPackageRequest.getSessionID());

					CreateAgentInstallPackage createAgentInstallPackage = new CreateAgentInstallPackage();	
					createAgentInstallPackage.setReq(createPackageRequest);
					CreateAgentInstallPackageResponse createAgentInstallPackageResponse = 
						kaseyaStub.createAgentInstallPackage(createAgentInstallPackage);
					CreatePackageResponse createPackageResponse = 
						createAgentInstallPackageResponse.getCreateAgentInstallPackageResult();
					if (createPackageResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"createPackageResponse error message: " + createPackageResponse.getErrorMessage() + " " +
								"Error location: " + createPackageResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}							
				}
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}	

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createAdmin] Ready to get out!");

		return retVal;
		
	}
	

	/*
	public boolean deleteAdmin(
			String username) {
	
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] Inside!");

		boolean retVal = false;
		
		try {
			
			BigDecimal sessionID = kaseyaAuthenticate();
			String ip = getIP();
			String userScope = "scope-" + username;
			
	        DeleteAdminRequest deleteAdminRequest = new DeleteAdminRequest();
			
			deleteAdminRequest.setUserName(username);
			deleteAdminRequest.setBrowserIP(ip);
			deleteAdminRequest.setSessionID(sessionID);
			
			DeleteAdmin deleteAdmin = new DeleteAdmin();	
			deleteAdmin.setReq(deleteAdminRequest);
	       	DeleteAdminResponseE deleteAdminResponseE = 
	       		kaseyaStub.deleteAdmin(deleteAdmin);
	       	DeleteAdminResponse deleteAdminResponse = 
	       		deleteAdminResponseE.getDeleteAdminResult();
	       	DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] \n\t" +
	       			"getErrorLocation(): " + deleteAdminResponse.getErrorLocation() + " \n\t" +
	       			"getErrorMessage(): " + deleteAdminResponse.getErrorMessage() + " \n\t" +
	       			"getMethod(): " + deleteAdminResponse.getMethod());
	       	
	       	if (deleteAdminResponse.getErrorMessage().length() == 0) {
	       		
	       		DeleteScopeRequest deleteScopeRequest = new DeleteScopeRequest();
	       		deleteScopeRequest.setScopeName(userScope);
	       		deleteScopeRequest.setSessionID(sessionID);
	       		DeleteScope deleteScope = new DeleteScope();
	       		deleteScope.setReq(deleteScopeRequest);
	       		DeleteScopeResponseE deleteScopeResponseE = 
	       			kaseyaStub.deleteScope(deleteScope);
	       		DeleteScopeResponse deleteScopeResponse = 
	       			deleteScopeResponseE.getDeleteScopeResult();
	       		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] \n\t" +
	       				"getErrorLocation(): " + deleteScopeResponse.getErrorLocation() + " \n\t" +
	       				"getErrorMessage(): " + deleteScopeResponse.getErrorMessage() + " \n\t" +
	       				"getMethod(): " + deleteScopeResponse.getMethod());

	       		if (deleteScopeResponse.getErrorMessage().length() == 0)
	       			retVal = true;

	       	}
	       	
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}	

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] Ready to get out!");

		return retVal;
		
	}
	*/
	
	// Added by Masoud Sadjadi on Nov. 5, 2014
	private boolean createSpecialAdminOrMark4Deletion() {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] Inside!");

		boolean retVal = true;
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion]"
				+ "sysUsername is " + sysUsername + " and sysPassword is " + sysPassword);
		try {
			CreateAdminRequest createAdminRequest = new CreateAdminRequest();
			createAdminRequest.setEmailAddr(sysUsername);
			createAdminRequest.setUserName("support-"+sysUsername);
			createAdminRequest.setSessionAdmin("");
			// createAdminRequest.setRoleID(userRoleId);
			createAdminRequest.setRoleID(sysRole);
			createAdminRequest.setScopeID(sysScope);

			// Hash password with username and random number and submit the form
			String coveredPassword = coverPass(sysPassword, sysUsername);
			createAdminRequest.setCoveredPassword(coveredPassword);
			createAdminRequest.setForceNewPassword(false);

			createAdminRequest.setFirstName("Marked4Deletion");
			createAdminRequest.setLastName("ByeByeWorld");
			createAdminRequest.setOnVacationFlag(false);
			createAdminRequest.setVacationStartDate(Calendar.getInstance());
			createAdminRequest.setVacationEndDate(Calendar.getInstance());
			createAdminRequest.setOnSickLeaveFlag(false);
			createAdminRequest.setSickLeaveStartDate(Calendar.getInstance());
			createAdminRequest.setSickLeaveEndDate(Calendar.getInstance());		       	
			String ip = getIP();
			createAdminRequest.setBrowserIP(ip);
			/*
		createAdminRequest.setSessionID(sessionID);

		CreateAdmin createAdmin = new CreateAdmin();	
		createAdmin.setReq(createAdminRequest);
		CreateAdminResponseE createAdminResponseE = 
			kaseyaStub.createAdmin(createAdmin);
			 */
			CreateAdminResponse createAdminResponse = null;
			CreateAdmin createAdmin = null;	
			CreateAdminResponseE createAdminResponseE = null; 

			int attemptCounter = 0;
			int delay = 10000;
			int delayIncrement = 5000;
			int maxAttempt = 1;
			do {
				attemptCounter++;

				try {
					sessionID = kaseyaAuthenticate();
				} catch (ConnectTimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] sessionID: " + sessionID);

					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] ConnectTimeoutException occured!");
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] Ready to get out!");
					attemptCounter =  maxAttempt;
					break;
				} 

				createAdminRequest.setSessionID(sessionID);

				createAdmin = new CreateAdmin();	
				createAdmin.setReq(createAdminRequest);
				createAdminResponseE = 
						kaseyaStub.createAdmin(createAdmin);
				//			CreateAdminResponse createAdminResponse = null;

				createAdminResponse = 
						createAdminResponseE.getCreateAdminResult();

				if ((createAdminResponse.getErrorMessage().length() > 0) && (attemptCounter < maxAttempt)) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] " +
							"createAdminResponse error message: " + createAdminResponse.getErrorMessage() + " " +
							"Error location: " + createAdminResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] " +
							"sessionID: " + sessionID + " ip:" + ip);

					delay += delayIncrement;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] " +
							"sleeping for " + delay/1000 + " second waiting for the queue on KServer to respond!");
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] " +
							"createAdminResponse error message: " + createAdminResponse.getErrorMessage() + " " +
							"Error location: " + createAdminResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] " +
							"sessionID: " + sessionID + " ip:" + ip);
					retVal = true;
				}

			} while ((createAdminResponse.getErrorMessage().length() > 0) && (attemptCounter < maxAttempt));

		} catch(Exception e) {
			e.printStackTrace();
		}	
			
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - createSpecialAdminOrMark4Deletion] Ready to get out!");

		return retVal;
	}

	public boolean deleteAdmin(
			String username, 
			String password) {
	
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] Inside!");

		boolean retVal = true;
		
		try {
			
			// Added by Masoud Sadjadi on Nov. 5, 2014
			/*
			 * 0: Adding a marker user for the partition to be marked for deletion!
			 */
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
			"Phase I-0: Adding a marker user for the partition to be marked for deletion!");
			if (createSpecialAdminOrMark4Deletion()) {
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"Phase I-0: Adding the marker user was successful!");
			} else {
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"Phase I-0: Adding the marker user was NOT successful!");
			}

			if (enableAdmin(username, password)) {

				/*
				 * Destroy the previously create admin user 
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"Destroy the previously create admin user");

				/*
				 * A: Destroy whatever the admin user has created in the previous attempt
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"Phase I-A: Destroy whatever the admin user has created in the previous attempt");

				/*
				 * A: First, login to KServer as the previously created admin user 
				 * and get the ip address of this machine.
				 */			
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"A: First, login to KServer as the previously created admin user " +
				"and get the ip address of this machine.");
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"A: username: " + username + " and password: " + password);
				sessionID = kaseyaAuthenticate(username, password);
				String ip = getIP();
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"sessionID: " + sessionID + " ip:" + ip);

				/*
				 * Phase I-A: Second, delete all agents created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"A: Second, delete all agents created by the admin user");
				GetMachineListRequest getMachineListReq = new GetMachineListRequest();
				getMachineListReq.setSessionID(sessionID);
				getMachineListReq.setBrowserIP(ip);
				getMachineListReq.setMachineCollection("");
				getMachineListReq.setMachineGroup("");
				GetMachineList getMachineList = new GetMachineList();
				getMachineList.setReq(getMachineListReq);
				GetMachineListResponseE getMachineListRespE;
				try {
					getMachineListRespE = kaseyaStub.getMachineList(getMachineList);
					GetMachineListResponse getMachineListResp =
						getMachineListRespE.getGetMachineListResult();
					ArrayOfMachine arrayOfMachines = getMachineListResp.getMachines();
					Machine[] machines = null;
					if (arrayOfMachines != null)
						machines = arrayOfMachines.getMachine();
					if (machines != null) {
						for (int i=0; i<machines.length; i++) {
							BigDecimal agentGuid = machines[i].getAgentGuid();

							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"Deleting machines[" + i + "]: " +
									machines[i].getMachine_GroupID() + ", " +
									machines[i].getAgentGuid());
							DeleteAgentRequest deleteAgentReq = new DeleteAgentRequest();
							deleteAgentReq.setSessionID(sessionID);
							deleteAgentReq.setBrowserIP(ip);
							deleteAgentReq.setAgentGuid(agentGuid.toString());
							deleteAgentReq.setUninstallAgentFirst(false);
							DeleteAgent deleteAgent = new DeleteAgent();
							deleteAgent.setReq(deleteAgentReq);
							DeleteAgentResponseE deleteAgentRespE = null;
							try {
								deleteAgentRespE = kaseyaStub.deleteAgent(deleteAgent);
								DeleteAgentResponse deleteAgentResp =
									deleteAgentRespE.getDeleteAgentResult();
								if (deleteAgentResp.getErrorMessage().length() > 0) {
									retVal = false;
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"Deleting machines error message: " + deleteAgentResp.getErrorMessage() + " " +
											"Error location: " + deleteAgentResp.getErrorLocation());	
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"sessionID: " + sessionID + " ip:" + ip);
								}					
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} else {
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"No agent was found!");
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"Get machines list error message: " + getMachineListResp.getErrorMessage() + " " +
								"Error location: " + getMachineListResp.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				/*
				 * A: Third, delete all install packages created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"A: Third, delete all install packages created by the admin user");
				GetPackageURLsRequest getPackageURLsReq = new GetPackageURLsRequest();
				getPackageURLsReq.setSessionID(sessionID);
				getPackageURLsReq.setBrowserIP(ip);
				getPackageURLsReq.setGroupName("");
				GetPackageURLs getPackageURLs = new GetPackageURLs();
				getPackageURLs.setReq(getPackageURLsReq);
				GetPackageURLsResponseE getPackageURLsRespE;
				try {
					getPackageURLsRespE = kaseyaStub.getPackageURLs(getPackageURLs);
					GetPackageURLsResponse getPackageURLsResp =
						getPackageURLsRespE.getGetPackageURLsResult();
					ArrayOfPackage arrayOfPackage = getPackageURLsResp.getPackages();
					kaseyaws.Package[] packages = null;
					if (arrayOfPackage != null)
						packages = arrayOfPackage.getPackage();
					if (packages != null) {
						for (int i=0; i<packages.length; i++) {
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									i + " packages[i].getPackageName() " + packages[i].getPackageName());
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									i + " packages[i].getDescription() " + packages[i].getDescription());
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									i + " packages[i].getAgentType() " + packages[i].getAgentType());
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									i + " packages[i].getURL() " + packages[i].getURL());
							String packageURL = packages[i].getURL();
							String packageIdStr = packageURL.substring(packageURL.indexOf("?id=")+4);
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"Deleting package[" + i + "]: " +
									packageURL + ", " + packageIdStr);
							int packageId = Integer.parseInt(packageIdStr);

							DeletePackageRequest deletePackageReq = new DeletePackageRequest();
							deletePackageReq.setSessionID(sessionID);
							deletePackageReq.setBrowserIP(ip);
							deletePackageReq.setPackageId(packageId);
							DeleteAgentInstallPackage deleteAgentInstallPackage = new DeleteAgentInstallPackage();
							deleteAgentInstallPackage.setReq(deletePackageReq);
							DeleteAgentInstallPackageResponse deleteAgentInstallPackageResp = 
								kaseyaStub.deleteAgentInstallPackage(deleteAgentInstallPackage);
							DeletePackageResponse deletePackageResp =
								deleteAgentInstallPackageResp.getDeleteAgentInstallPackageResult();
							if (deletePackageResp.getErrorMessage().length() > 0) {
								retVal = false;
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"deletePackageResp error message: " + deletePackageResp.getErrorMessage() + " " +
										"Error location: " + deletePackageResp.getErrorLocation());	
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"sessionID: " + sessionID + " ip:" + ip);
							}					
						}
					} else {
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"No agent install package was found!");
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"getPackageURLsResp error message: " + getPackageURLsResp.getErrorMessage() + " " +
								"Error location: " + getPackageURLsResp.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * Phase I-A: Fourth, delete all machine groups created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"A: Fourth, delete all machine groups created by the admin user");
				GetMachineGroupListRequest getMachineGroupListReq = new GetMachineGroupListRequest();
				getMachineGroupListReq.setSessionID(sessionID);
				getMachineGroupListReq.setBrowserIP(ip);
				GetMachineGroupList getMachineGroupList = new GetMachineGroupList();
				getMachineGroupList.setReq(getMachineGroupListReq);
				GetMachineGroupListResponseE getMachineGroupListRespE;
				try {
					getMachineGroupListRespE = kaseyaStub.getMachineGroupList(getMachineGroupList);
					GetMachineGroupListResponse getMachineGroupListResp =
						getMachineGroupListRespE.getGetMachineGroupListResult();
					ArrayOfString arrayOfMachineGroup = getMachineGroupListResp.getMachineGroups();
					String[] machineGroups = null;
					if (arrayOfMachineGroup != null)
						machineGroups = arrayOfMachineGroup.getGroupName();
					if (machineGroups != null) {
						for (int i=0; i<machineGroups.length; i++) {
							String machineGroup = machineGroups[i];

							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"Deleting machineGroup[" + i + "]: " +
									machineGroups[i]);
							DeleteMachineGroupRequest deleteMachineGroupReq = new DeleteMachineGroupRequest();
							deleteMachineGroupReq.setSessionID(sessionID);
							deleteMachineGroupReq.setBrowserIP(ip);
							deleteMachineGroupReq.setGroupName(machineGroup);
							DeleteMachineGroup deleteMachineGroup = new DeleteMachineGroup();
							deleteMachineGroup.setReq(deleteMachineGroupReq);
							DeleteMachineGroupResponseE deleteMachineGroupRespE = 
								kaseyaStub.deleteMachineGroup(deleteMachineGroup);
							DeleteMachineGroupResponse deleteMachineGroupResp =
								deleteMachineGroupRespE.getDeleteMachineGroupResult();
							if (deleteMachineGroupResp.getErrorMessage().length() > 0) {
								retVal = false;
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"deleteMachineGroupResp error message: " + deleteMachineGroupResp.getErrorMessage() + " " +
										"Error location: " + deleteMachineGroupResp.getErrorLocation());	
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"sessionID: " + sessionID + " ip:" + ip);
							}					
						}
					} else {
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"No machine group was found!");
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"Get machines list error message: " + getMachineGroupListResp.getErrorMessage() + " " +
								"Error location: " + getMachineGroupListResp.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/* 
				 * Phase I-A: Fifth, delete all organizations created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"A: Fifth, delete all organizations created by the admin user");
				GetOrgsRequest getOrgsReq = new GetOrgsRequest();
				getOrgsReq.setSessionID(sessionID);
				GetOrgs getOrgs = new GetOrgs();
				getOrgs.setReq(getOrgsReq);
				GetOrgsResponseE getOrgsRespE;
				try {
					getOrgsRespE = kaseyaStub.getOrgs(getOrgs);
					GetOrgsResponse getOrgsResp =
						getOrgsRespE.getGetOrgsResult();
					ArrayOfOrg arrayOfOrgs = getOrgsResp.getOrgs();
					Org[] orgs = null;
					if (arrayOfOrgs != null)
						orgs = arrayOfOrgs.getOrg();
					if (orgs != null) {
						for (int i=0; i<orgs.length; i++) {
							String orgId = orgs[i].getOrgId();

							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"Deleting orgs[" + i + "]: " +
									orgs[i].getOrgId() + ", " + orgs[i].getOrgName());
							DeleteOrgRequest deleteOrgReq = new DeleteOrgRequest();
							deleteOrgReq.setSessionID(sessionID);
							deleteOrgReq.setBrowserIP(ip);
							deleteOrgReq.setOrgRef(orgs[i].getOrgRef());
							DeleteOrg deleteOrg = new DeleteOrg();
							deleteOrg.setReq(deleteOrgReq);
							DeleteOrgResponseE deleteOrgRespE = 
								kaseyaStub.deleteOrg(deleteOrg);
							DeleteOrgResponse deleteOrgResp =
								deleteOrgRespE.getDeleteOrgResult();
							if (deleteOrgResp.getErrorMessage().length() > 0) {
								retVal = false;
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"deleteOrgResp error message: " + deleteOrgResp.getErrorMessage() + " " +
										"Error location: " + deleteOrgResp.getErrorLocation());	
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"sessionID: " + sessionID + " ip:" + ip);
							}					
						}
					} else {
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"No org was found!");
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"getOrgsResp error message: " + getOrgsResp.getErrorMessage() + " " +
								"Error location: " + getOrgsResp.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * A: Sixth, delete all admin users created by this admin user
				 */			
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"A: Sixth, delete all admin users created by this admin user");
				// TODO 
				// There is no function to get the list of admin users that this admin user
				// has created. Therefore, we have asked the admin user to create admin users
				// following the specific pattern in the admin user name. If the admin user
				// does not follow this pattern exactly, the users that he created will not be
				// deleted!
				String[] usernames = {
						"newadmin-"+username, 
						"ksmith-"+username
				};
				for (String uname : usernames) {
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
							"Deleting username: " + uname);
					DeleteAdminRequest deleteAdminRequest = new DeleteAdminRequest();
					deleteAdminRequest.setUserName(uname);
					deleteAdminRequest.setBrowserIP(ip);
					deleteAdminRequest.setSessionID(sessionID);
					DeleteAdmin deleteAdmin = new DeleteAdmin();	
					deleteAdmin.setReq(deleteAdminRequest);
					DeleteAdminResponseE deleteAdminResponseE;
					try {
						deleteAdminResponseE = kaseyaStub.deleteAdmin(deleteAdmin);
						DeleteAdminResponse deleteAdminResponse = 
							deleteAdminResponseE.getDeleteAdminResult();
						if (deleteAdminResponse.getErrorMessage().length() > 0) {
							retVal = false;
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"deleteAdminResponse error message: " + deleteAdminResponse.getErrorMessage() + " " +
									"Error location: " + deleteAdminResponse.getErrorLocation());	
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"sessionID: " + sessionID + " ip:" + ip);
						}					
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"Clean up the specific admin users for the promoCode: " + promoCode);
				// SMS: To accommodate ITS-KSDW-14-1D
				// if (promoCode.equals(ITSKSDW) || (promoCode.equals(ITSKSDW14))) {
				if (promoCode.contains("KSDW")) {
					
					// Setting the user variables
					setUserVars(username, "", "");
					
					/*
					String[][] naUserName = {
							{"tier1-1-" + username, "tier1-2-" + username, "tier1-3-" + username, "tier1-4-" + username},
							{"tier2-1-" + username, "tier2-2-" + username},
							{"contact-scis-" + username, "contact-gl-" + username, "contact-cec-" + username}};
					*/
					
					for (int i=0; i<3; i++) {
						for (int j=0; j<naUserName[i].length; j++) {
							
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"Deleting username: " + naUserName[i][j]);
							DeleteAdminRequest deleteAdminRequest = new DeleteAdminRequest();
							deleteAdminRequest.setUserName(naUserName[i][j]);
							deleteAdminRequest.setBrowserIP(ip);
							deleteAdminRequest.setSessionID(sessionID);
							DeleteAdmin deleteAdmin = new DeleteAdmin();	
							deleteAdmin.setReq(deleteAdminRequest);
							DeleteAdminResponseE deleteAdminResponseE;
							try {
								deleteAdminResponseE = kaseyaStub.deleteAdmin(deleteAdmin);
								DeleteAdminResponse deleteAdminResponse = 
									deleteAdminResponseE.getDeleteAdminResult();
								if (deleteAdminResponse.getErrorMessage().length() > 0) {
									retVal = false;
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"deleteAdminResponse error message: " + deleteAdminResponse.getErrorMessage() + " " +
											"Error location: " + deleteAdminResponse.getErrorLocation());	
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"sessionID: " + sessionID + " ip:" + ip);
								}					
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				
				/*
				 * A: Seventh, delete all user roles created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"A: Seventh, delete all user roles created by the admin user");
				GetRolesRequest getRolesReq = new GetRolesRequest();
				getRolesReq.setSessionID(sessionID);
				GetRoles getRoles = new GetRoles();
				getRoles.setReq(getRolesReq);
				GetRolesResponseE getRolesRespE;
				try {
					getRolesRespE = kaseyaStub.getRoles(getRoles);
					GetRolesResponse getRolesResp =
						getRolesRespE.getGetRolesResult();
					ArrayOfRole arrayOfRole = getRolesResp.getRoles();
					Role[] roles = null;
					if (arrayOfRole != null)
						roles = arrayOfRole.getRole();
					if (roles != null) {
						for (int i=0; i<roles.length; i++) {
							String roleId = roles[i].getRoleID();
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"Deleting roles[" + i + "]: " +
									roleId);
							if (roleId.equals("SD Admin") || roleId.equals("role-"+username)) {
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"roles[" + i + "]: " + roleId + " will not be deleted at this point!");						
							} else {
								DeleteRoleRequest deleteRoleReq = new DeleteRoleRequest();
								deleteRoleReq.setSessionID(sessionID);
								deleteRoleReq.setBrowserIP(ip);
								deleteRoleReq.setRoleName(roleId);
								DeleteRole deleteRole = new DeleteRole();
								deleteRole.setReq(deleteRoleReq);
								DeleteRoleResponseE deleteRoleRespE = 
									kaseyaStub.deleteRole(deleteRole);
								DeleteRoleResponse deleteRoleResp =
									deleteRoleRespE.getDeleteRoleResult();
								if (deleteRoleResp.getErrorMessage().length() > 0) {
									retVal = false;
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"deleteRoleResp error message: " + deleteRoleResp.getErrorMessage() + " " +
											"Error location: " + deleteRoleResp.getErrorLocation());	
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"sessionID: " + sessionID + " ip:" + ip);
								}					
							}
						}
					} else {
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"No role was found!");
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"getRolesResp error message: " + getRolesResp.getErrorMessage() + " " +
								"Error location: " + getRolesResp.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * A: Eight, delete all scopes created by the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"A: Eight, delete all scopes created by the admin user");
				GetScopesRequest getScopesReq = new GetScopesRequest();
				getScopesReq.setSessionID(sessionID);
				GetScopes getScopes = new GetScopes();
				getScopes.setReq(getScopesReq);
				GetScopesResponseE getScopesRespE;
				try {
					getScopesRespE = kaseyaStub.getScopes(getScopes);
					GetScopesResponse getScopesResp =
						getScopesRespE.getGetScopesResult();
					ArrayOfScope arrayOfScope = getScopesResp.getScopes();
					Scope[] scopes = null;
					if (arrayOfScope != null)
						scopes = arrayOfScope.getScope();
					if (scopes != null) {
						for (int i=0; i<scopes.length; i++) {
							String scopeId = scopes[i].getScopeID();
							DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
									"Deleting scopes[" + i + "]: " +
									scopeId);
							if (scopeId.equals("scope-"+username)) {
								DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
										"scopes[" + i + "]: " + scopeId + " will not be deleted at this point!");						
							} else {
								DeleteScopeRequest deleteScopeReq = new DeleteScopeRequest();
								deleteScopeReq.setSessionID(sessionID);
								deleteScopeReq.setScopeName(scopeId);
								DeleteScope deleteScope = new DeleteScope();
								deleteScope.setReq(deleteScopeReq);
								DeleteScopeResponseE deleteScopeRespE = 
									kaseyaStub.deleteScope(deleteScope);
								DeleteScopeResponse deleteScopeResp =
									deleteScopeRespE.getDeleteScopeResult();
								if (deleteScopeResp.getErrorMessage().length() > 0) {
									retVal = false;
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"deleteScopeResp error message: " + deleteScopeResp.getErrorMessage() + " " +
											"Error location: " + deleteScopeResp.getErrorLocation());	
									DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
											"sessionID: " + sessionID + " ip:" + ip);
								}					
							}
						}
					} else {
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"No scope was found!");
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"getScopesResp error message: " + getScopesResp.getErrorMessage() + " " +
								"Error location: " + getScopesResp.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * B: Destory the admin user created previously by Master admin
				 */

				/*
				 * Phase I-B: First, login to KServer as the Master admin
				 * and get the ip address of this machine.
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
					"B: First, login to KServer as the Master admin " +
					"and get the ip address of this machine.");
				sessionID = kaseyaAuthenticate();
				ip = getIP();

				/*
				 * Phase I-B: Second, delete the admin user
				 */
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
					"B: Second, delete the admin user");
				DeleteAdminRequest deleteAdminRequest = new DeleteAdminRequest();			
				deleteAdminRequest.setUserName(username);
				deleteAdminRequest.setBrowserIP(ip);
				deleteAdminRequest.setSessionID(sessionID);
				DeleteAdmin deleteAdmin = new DeleteAdmin();	
				deleteAdmin.setReq(deleteAdminRequest);
				DeleteAdminResponseE deleteAdminResponseE;
				try {
					deleteAdminResponseE = kaseyaStub.deleteAdmin(deleteAdmin);
					DeleteAdminResponse deleteAdminResponse = 
						deleteAdminResponseE.getDeleteAdminResult();
					if (deleteAdminResponse.getErrorMessage().length() > 0) {
						retVal = false;
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"deleteAdminResponse error message: " + deleteAdminResponse.getErrorMessage() + " " +
								"Error location: " + deleteAdminResponse.getErrorLocation());	
						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
								"sessionID: " + sessionID + " ip:" + ip);
					}					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// SMS: 2013-05-04
				// No more VSA-Core and kserver2
				/*
				 * B: Third, delete the user role 
				 */
				/*
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
					"B: Third, delete the user role");
				DeleteRoleRequest deleteRoleRequest = new DeleteRoleRequest();
				deleteRoleRequest.setRoleName("role-"+username);
				deleteRoleRequest.setSessionID(sessionID);
				DeleteRole deleteRole = new DeleteRole();
				deleteRole.setReq(deleteRoleRequest);
				DeleteRoleResponseE deleteRoleResponseE = 
					kaseyaStub.deleteRole(deleteRole);
				DeleteRoleResponse deleteRoleResponse = 
					deleteRoleResponseE.getDeleteRoleResult();
				if (deleteRoleResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
							"deleteRoleResponse error message: " + deleteRoleResponse.getErrorMessage() + " " +
							"Error location: " + deleteRoleResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}							
				*/

				// SMS: 2013-05-04
				// No more VSA-Core and kserver2
				/*
				 * B: Fourth, delete the user scope 
				 */
				/*
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
				"B: Fourth, delete the user scope");
				DeleteScopeRequest deleteScopeRequest = new DeleteScopeRequest();
				deleteScopeRequest.setScopeName("scope-"+username);
				deleteScopeRequest.setSessionID(sessionID);
				DeleteScope deleteScope = new DeleteScope();
				deleteScope.setReq(deleteScopeRequest);
				DeleteScopeResponseE deleteScopeResponseE = 
					kaseyaStub.deleteScope(deleteScope);
				DeleteScopeResponse deleteScopeResponse = 
					deleteScopeResponseE.getDeleteScopeResult();
				if (deleteScopeResponse.getErrorMessage().length() > 0) {
					retVal = false;
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
							"deleteScopeResponse error message: " + deleteScopeResponse.getErrorMessage() + " " +
							"Error location: " + deleteScopeResponse.getErrorLocation());	
					DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
							"sessionID: " + sessionID + " ip:" + ip);
				}
				*/							
			} else {				
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] " +
						"The admin user " + username + 
				"was not previously created in the system!");
			}

		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}	

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - deleteAdmin] Ready to get out!");

		// SMS: 5/6/2013
		// TODO
		// Note that retVal maybe false because of not being able to delete the System user role and scope 
		// or the internal organization. Unless such situations are detected in the above code, and retVal
		// is not wrongly indicated as false, we assume that this method was successful.
		retVal = true;
		
		return retVal;
		
	}
	
	public boolean addAdminToMasterRole(
			String username, String password) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - addAdminToMasterRole] Inside!");

		boolean retVal = false;
		
		try {
			
			sessionID = kaseyaAuthenticate();
			
			AddUserToRoleRequest addUserToRoleRequest =
				new AddUserToRoleRequest();
			addUserToRoleRequest.setUserName(username);
			addUserToRoleRequest.setRoleID("Master");
			addUserToRoleRequest.setSessionID(sessionID);
			AddUserToRole addUserToRole = new AddUserToRole();
			addUserToRole.setReq(addUserToRoleRequest);
			AddUserToRoleResponseE addUserToRoleResponseE =
				kaseyaStub.addUserToRole(addUserToRole);
			AddUserToRoleResponse addUserToRoleResponse = 
				addUserToRoleResponseE.getAddUserToRoleResult();
	       	DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - addAdminToMasterRole] \n\t" +
	       			"getErrorLocation(): " + addUserToRoleResponse.getErrorLocation() + " \n\t" +
	       			"getErrorMessage(): " + addUserToRoleResponse.getErrorMessage() + " \n\t" +
	       			"getMethod(): " + addUserToRoleResponse.getMethod());
	       	
	       	if (addUserToRoleResponse.getErrorMessage().length() == 0)
	       		if (enableAdmin(username, password))
	       			retVal = true;
	       	
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - addAdminToMasterRole] Ready to get out!");

		return retVal;
		
	}

	public boolean removeAdminFromMasterRole(
			String username) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - removeAdminFromMasterRole] Inside!");

		boolean retVal = false;
			
		try {
			
			sessionID = kaseyaAuthenticate();
			
			RemoveUserFromRoleRequest removeUserFromRoleRequest =
				new RemoveUserFromRoleRequest();
			removeUserFromRoleRequest.setAdminName(username);
			removeUserFromRoleRequest.setRoleName("Master");
			removeUserFromRoleRequest.setSessionID(sessionID);
			removeUserFromRoleRequest.setBrowserIP(getIP());
			RemoveUserFromRole removeUserFromRole = new RemoveUserFromRole();
			removeUserFromRole.setReq(removeUserFromRoleRequest);
			RemoveUserFromRoleResponseE removeUserFromRoleResponseE =
				kaseyaStub.removeUserFromRole(removeUserFromRole);
			RemoveUserFromRoleResponse removeUserFromRoleResponse = 
				removeUserFromRoleResponseE.getRemoveUserFromRoleResult();
	       	DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - removeAdminFromMasterRole] \n\t" +
	       			"getErrorLocation(): " + removeUserFromRoleResponse.getErrorLocation() + " \n\t" +
	       			"getErrorMessage(): " + removeUserFromRoleResponse.getErrorMessage() + " \n\t" +
	       			"getMethod(): " + removeUserFromRoleResponse.getMethod());
	       	
	       	if (removeUserFromRoleResponse.getErrorMessage().length() == 0)
	       		if (disableAdmin(username))
	       			retVal = true;
	       	
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - removeAdminFromMasterRole] Ready to get out!");

		return retVal;
			
	}
	
	public boolean setAdminPassword(
			String username,
			String password) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - setAdminPassword] Inside!");

		boolean retVal = false;
			
		try {

			// Hash password with username and random number and submit the form
			String coveredPassword = coverPass(password, username);

			SetAdminPasswordRequest setAdminPasswordRequest =
				new SetAdminPasswordRequest();
			setAdminPasswordRequest.setAdminName(username);
			setAdminPasswordRequest.setPassword(coveredPassword);
			setAdminPasswordRequest.setForceNewPassword(false);
			setAdminPasswordRequest.setSessionID(kaseyaAuthenticate());
			setAdminPasswordRequest.setBrowserIP(getIP());
			SetAdminPassword setAdminPassword = new SetAdminPassword();
			setAdminPassword.setReq(setAdminPasswordRequest);
			SetAdminPasswordResponseE setAdminPasswordResponseE =
				kaseyaStub.setAdminPassword(setAdminPassword);
			SetAdminPasswordResponse setAdminPasswordResponse =
				setAdminPasswordResponseE.getSetAdminPasswordResult();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - setAdminPassword] \n\t" +
					"getErrorLocation(): " + setAdminPasswordResponse.getErrorLocation() + " \n\t" +
					"getErrorMessage(): " + setAdminPasswordResponse.getErrorMessage() + " \n\t" +
					"getMethod(): " + setAdminPasswordResponse.getMethod());

			String errorMessage = setAdminPasswordResponse.getErrorMessage();
			if ((errorMessage.length() == 0) || (errorMessage.contains("Password has not been changed.")))
	       		retVal = true;

		}
		catch (Exception e) {

			e.printStackTrace();

		}
	
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - setAdminPassword] Ready to get out!");

		return retVal;
			
	}
	
	public boolean resetPassword(
			String username,
			String password) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - resetPassword] Inside!");

		boolean retVal = false;
			
		try {

			// Hash password with username and random number and submit the form
			String coveredPassword = coverPass(password, username);

			ResetPasswordRequest resetPasswordRequest =
				new ResetPasswordRequest();
			resetPasswordRequest.setUserName(username);
			resetPasswordRequest.setCoveredPassword(coveredPassword);
			resetPasswordRequest.setForceNewPassword(false);
			resetPasswordRequest.setSessionID(kaseyaAuthenticate());
			ResetPassword resetPassword = new ResetPassword();
			resetPassword.setReq(resetPasswordRequest);
			ResetPasswordResponseE resetPasswordResponseE =
				kaseyaStub.resetPassword(resetPassword);
			ResetPasswordResponse resetPasswordResponse =
				resetPasswordResponseE.getResetPasswordResult();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - resetPassword] \n\t" +
					"getErrorLocation(): " + resetPasswordResponse.getErrorLocation() + " \n\t" +
					"getErrorMessage(): " + resetPasswordResponse.getErrorMessage() + " \n\t" +
					"getMethod(): " + resetPasswordResponse.getMethod());

	       	if (resetPasswordResponse.getErrorMessage().length() == 0)
	       		retVal = true;

		}
		catch (Exception e) {

			e.printStackTrace();

		}
	
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - resetPassword] Ready to get out!");

		return retVal;
			
	}
	
	public boolean enableAdmin(
			String username,
			String password) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] Inside!");

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] " +
				"username: " + username + " password: " + password);

		boolean retVal = false;
			
		try {

			EnableAdminRequest enableAdminRequest =
				new EnableAdminRequest();
			enableAdminRequest.setAdminName(username);
			enableAdminRequest.setBrowserIP(getIP());
			enableAdminRequest.setSessionID(kaseyaAuthenticate());
			EnableAdmin enableAdmin = new EnableAdmin();
			enableAdmin.setReq(enableAdminRequest);
			EnableAdminResponseE enableAdminResponseE =
				kaseyaStub.enableAdmin(enableAdmin);
			EnableAdminResponse enableAdminResponse =
				enableAdminResponseE.getEnableAdminResult();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] \n\t" +
					"getErrorLocation(): " + enableAdminResponse.getErrorLocation() + " \n\t" +
					"getErrorMessage(): " + enableAdminResponse.getErrorMessage() + " \n\t" +
					"getMethod(): " + enableAdminResponse.getMethod());

	       	if (enableAdminResponse.getErrorMessage().length() > 0) {
	       		
	    		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] " +
	    				"Error message length is bigger than zero!");
	       		retVal = false;
	       	
	       	} else {
	       	
				// if (!resetPassword(username, password)) {
	       		if (!setAdminPassword(username, password)) {
					
	       			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] " +
	       					"\n\tThe user does not exist on this server as its password could not be reset!" +
	       					"\n\ttargetEndPoint is " + targetEndPoint +
	       					"\n\tusername: " + username + " password: " + password);
	       			retVal = false;
	       			
				} else {
					
					sessionID = kaseyaAuthenticate(username, password);
					if (sessionID.doubleValue() == 0) {

						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] " +
								"\n\tThe user does not exist on this server!" +
								"\n\tsessionId: " + sessionID +
								"\n\ttargetEndPoint is " + targetEndPoint +
								"\n\tusername: " + username + " password: " + password);
						retVal = false;

					} else {

						DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] " +
								"\n\tThe user exists on this server and is enabled!" +
								"\n\tsessionId: " + sessionID +
								"\n\ttargetEndPoint is " + targetEndPoint +
								"username: " + username + " password: " + password);
						retVal = true;

					}
				}	       		
	       	}
		}
		catch (Exception e) {

			e.printStackTrace();

		}
	
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - enableAdmin] Ready to get out!");

		return retVal;
			
	}
	
	public boolean disableAdmin(
			String username) {
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - disableAdmin] Inside!");

		boolean retVal = false;

		try {

			DisableAdminRequest disableAdminRequest =
				new DisableAdminRequest();
			disableAdminRequest.setAdminName(username);
			disableAdminRequest.setBrowserIP(getIP());
			disableAdminRequest.setSessionID(kaseyaAuthenticate());
			DisableAdmin disableAdmin = new DisableAdmin();
			disableAdmin.setReq(disableAdminRequest);
			DisableAdminResponseE disableAdminResponseE =
				kaseyaStub.disableAdmin(disableAdmin);
			DisableAdminResponse disableAdminResponse =
				disableAdminResponseE.getDisableAdminResult();
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - disableAdmin] \n\t" +
					"getErrorLocation(): " + disableAdminResponse.getErrorLocation() + " \n\t" +
					"getErrorMessage(): " + disableAdminResponse.getErrorMessage() + " \n\t" +
					"getMethod(): " + disableAdminResponse.getMethod());

			if (disableAdminResponse.getErrorMessage().length() == 0)
	       		retVal = true;

		}
		catch (Exception e) {

			e.printStackTrace();

		}
	
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - disableAdmin] Ready to get out!");

		return retVal;
			
	}
	
	private String getIP() {

		String ip = null;

		try {

			InetAddress addr;
			addr = InetAddress.getLocalHost();
			byte[] ipAddr = addr.getAddress();
			ip = String.valueOf(ipAddr);

		} 
		catch (UnknownHostException e) {

			e.printStackTrace();

		}

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - getIP] ip: " + ip);

		return ip;

	}

	private BigDecimal kaseyaAuthenticate(
			String username,
			String password) throws Exception {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate] Inside!");
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate] " +
				"username: " + username + " and password: " + password + " hashingAlgorithm: " + hashingAlgorithm);

		// BigDecimal sessionID = new BigDecimal(0);
		BigDecimal zero = new BigDecimal(0);
		long timePassed = Calendar.getInstance().getTimeInMillis() - sessionTimeStamp.getTimeInMillis();
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate] " +
				"sessionID: " + sessionID + " " +
				"timePassed: " + timePassed + " miliseconds " +
				"now: " + Calendar.getInstance().getTimeInMillis() + " " +
				"sessionTimeStamp: " + sessionTimeStamp.getTimeInMillis() + " " +	 
				"sessionTimeOut: " + sessionTimeOut);
		if (sessionID.equals(zero) || 
			((!sessionID.equals(zero)) && (timePassed >= sessionTimeOut))) {
			
			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate] " +
					"Getting a new sessionID!");
			try {

				InetAddress addr = InetAddress.getLocalHost();
				byte[] ipAddr = addr.getAddress();
				String ip = String.valueOf(ipAddr);
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate] ip: " + ip);

				// Hash password with username and random number and submit the form
				password = coverPass(password, username);
				Random generator = new Random();
				String rand = String.valueOf(generator.nextInt());
				password = coverPass(password, rand);

				AuthenticationRequest authenticationReq = new AuthenticationRequest();
				authenticationReq.setUserName(username);
				authenticationReq.setCoveredPassword(password);
				authenticationReq.setRandomNumber(rand);
				authenticationReq.setBrowserIP(ip);
				authenticationReq.setHashingAlgorithm(hashingAlgorithm);

				Authenticate authenticateReq = new Authenticate();
				authenticateReq.setReq(authenticationReq);	
				AuthenticateResponse authenticateResp = 
					kaseyaStub.authenticate(authenticateReq);
				sessionID = authenticateResp.getAuthenticateResult().getSessionID();
				sessionTimeStamp = Calendar.getInstance();

			} catch(Exception e) {

				e.printStackTrace();

			}	

		}

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate] sessionID: " + sessionID);

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate] Ready to get out!");

		return sessionID;

	}

	private BigDecimal kaseyaAuthenticate() throws Exception {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] Inside!");

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] " +
				"username: " + sysUsername + " password: " + sysPassword);

		sessionID = kaseyaAuthenticate(sysUsername, sysPassword);
		/*
		BigDecimal zero = new BigDecimal(0);
		BigDecimal sessionID = new BigDecimal(0);
		int attemptCounter = 0;
		int delay = 10000;
		int delayIncrement = 5000;
		int maxAttempt = 5;
		do {
			attemptCounter++;
			
			try {
				sessionID = kaseyaAuthenticate(sysUsername, sysPassword);
			} catch (ConnectTimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] sessionID: " + sessionID);

				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] ConnectTimeoutException occured!");
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] Ready to get out!");
				return sessionID;
			}

			DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] " +
					"username: " + sysUsername + " password: " + sysPassword +
					" attemptCounter: " + attemptCounter +
					" sessionID: " + sessionID);

			if (sessionID.equals(zero)) {
				delay += delayIncrement;
				DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] " + 
						"sleeping for " + delay/1000 + " second waiting for the queue on KServer to respond!");
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (sessionID.equals(zero) && (attemptCounter < maxAttempt));
		*/

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] sessionID: " + sessionID);

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - kaseyaAuthenticate()] Ready to get out!");

		return sessionID;

	}

	private String coverPass(String thePass, String theName) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass] Inside!");

		String retVal = null;
		if (hashingAlgorithm.equals("SHA-1")) {
			retVal = coverPass1(thePass, theName);
			retVal = coverPass1old(thePass, theName);
		}
		else if (hashingAlgorithm.equals("SHA-256"))
			retVal = coverPass256(thePass, theName);
		
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass] " +
				"retVal: " + retVal);

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass] Ready to get out!");

		return retVal;

	}

	private String coverPass1old(String thePass, String theName) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass1old] Inside!");

		String retVal = null;
		
		thePass += theName; // concat the password and name to get more unique

		int a = 0x67452301;
		int b = 0xEFCDAB89;
		int c = 0x98BADCFE;
		int d = 0x10325476;
		int e = 0xC3D2E1F0;
		int[] w = new int[80];
		int nblk = ((thePass.length() + 8) >> 6) + 1;
		int[] x = new int[nblk * 16];
		int i = 0;
		int j = 0;

		for (i = 0; i < (nblk * 16); i++) 
			x[i] = 0;

		for (i = 0; i < thePass.length(); i++) 
			x[i >> 2] |= (int)thePass.charAt(i) << (24 - (i % 4) * 8);

		x[i >> 2] |= 0x80 << (24 - (i % 4) * 8);
		x[nblk * 16 - 1] = thePass.length() * 8;

		for (i = 0; i < x.length; i += 16) {

			int oldA = a;
			int oldB = b;
			int oldC = c;
			int oldD = d;
			int oldE = e;

			for (j = 0; j < 80; j++) {

				if (j < 16) 
					w[j] = x[i + j];
				else 
					w[j] = rol(w[j - 3] ^ w[j - 8] ^ w[j - 14] ^ w[j - 16], 1);

				int t = sum32(sum32(rol(a, 5), ft(j, b, c, d)), sum32(sum32(e, w[j]), kt(j)));
				e = d;
				d = c;
				c = rol(b, 30);
				b = a;
				a = t;

			}

			a = sum32(a, oldA);
			b = sum32(b, oldB);
			c = sum32(c, oldC);
			d = sum32(d, oldD);
			e = sum32(e, oldE);

		}

		retVal = numToHex(a) + numToHex(b) + numToHex(c) + numToHex(d) + numToHex(e);

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass1old] " +
				"retVal: " + retVal);

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass1old] Ready to get out!");

		return retVal;

	}

	private String  numToHex(int num) {  // convert to a hex string

		String hexStr = "";

		for (int i = 7; i >= 0; i--) 
			hexStr += "0123456789abcdef".charAt((num >> (i * 4)) & 0x0F);

		return hexStr;

	}

	private int ft(int t, int b, int c, int d) {

		if (t < 20) 
			return (b & c) | ((~b) & d);

		if (t < 40) 
			return b ^ c ^ d;

		if (t < 60) 
			return (b & c) | (b & d) | (c & d);

		return (b ^ c ^ d);

	}

	private int kt(int t) {

		if (t < 20) 
			return (0x5A827999);

		if (t < 40) 
			return (0x6ED9EBA1);

		if (t < 60) 
			return (0x8F1BBCDC);

		return (0xCA62C1D6);

	}

	private int sum32(int x, int y) {

		return ((x & 0x7FFFFFFF) + (y & 0x7FFFFFFF)) ^ (x & 0x80000000) ^ (y & 0x80000000);

	}

	private int rol(int theNum, int cnt) {

		return (theNum << cnt) | (theNum >>> (32 - cnt));

	}

	private String coverPass1(String thePass, String theName) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass1] Inside!");

		String retVal = null;
		
		String thePassName = thePass + theName; // concat the password and name to get more unique

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(thePassName.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format method 1
		// StringBuffer sb = new StringBuffer();
		// for (int i = 0; i < byteData.length; i++) {
		// 	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		// }

		// System.out.println("Hex format : " + sb.toString());

		//convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i=0;i<byteData.length;i++) {
			String hex=Integer.toHexString(0xff & byteData[i]);
			if(hex.length()==1) hexString.append('0');
			hexString.append(hex);
		}
		// System.out.println("Hex format : " + hexString.toString());

		retVal = hexString.toString();
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass1] " +
				"retVal: " + retVal);

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass1] Ready to get out!");

		return retVal;	
	}

	private String coverPass256(String thePass, String theName) {

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass256] Inside!");

		String retVal = null;
		
		String thePassName = thePass + theName; // concat the password and name to get more unique

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(thePassName.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format method 1
		// StringBuffer sb = new StringBuffer();
		// for (int i = 0; i < byteData.length; i++) {
		// 	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		// }

		// System.out.println("Hex format : " + sb.toString());

		//convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i=0;i<byteData.length;i++) {
			String hex=Integer.toHexString(0xff & byteData[i]);
			if(hex.length()==1) hexString.append('0');
			hexString.append(hex);
		}
		// System.out.println("Hex format : " + hexString.toString());

		retVal = hexString.toString();
		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass256] " +
				"retVal: " + retVal);

		DebugTools.println(DEBUG_LEVEL, "[KaseyaWSClient - coverPass256] Ready to get out!");

		return retVal;	
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoCode() {
		return promoCode;
	}

}
