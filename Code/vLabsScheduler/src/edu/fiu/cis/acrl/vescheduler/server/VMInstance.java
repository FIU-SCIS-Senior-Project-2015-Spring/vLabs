package edu.fiu.cis.acrl.vescheduler.server;

import java.util.Calendar;

import edu.fiu.cis.acrl.vescheduler.server.VEInstance.VEInsStatusType;

public class VMInstance {

	public enum VMInsStatusType { 
		NOT_PROVISIONED,
		PROVISIONING_AND_STARTING,
		RUNNING,
		PAUSING,
		PAUSED,
		STARTING,
		DESTROYED
	};

	private String id;
	private String veInsId;
	private String name;
	private String dir;
	private String domain;
	private String os;
	private String internalAddress;
	private int accessPort;
	private String macAddress;
	private VMInsStatusType status;
	private Calendar lastCheckin;
	private String appName;
	private String appDir;
	private boolean active;

	public VMInstance(
			String id,
			String veInsId,
			String name,
			String dir,
			String domain,
			String os,
			String internalAddress,
			int accessPort,
			String macAddress,
			VMInsStatusType status,
			Calendar lastCheckin,
			String appName,
			String appDir,
			boolean active) {

		this.id = id;
		this.veInsId = veInsId;
		this.name = name;
		this.dir = dir;
		this.domain = domain;
		this.os = os;
		this.internalAddress = internalAddress;
		this.accessPort = accessPort;
		this.macAddress = macAddress;
		this.status = status;
		this.lastCheckin = lastCheckin;
		this.appName = appName;
		this.appDir = appDir;
		this.active = active;
		
	}

	public static VMInsStatusType getStatus(String statusString) {

		VMInsStatusType status = null;
		
		if (statusString.equals("NOT_PROVISIONED"))
			status = VMInsStatusType.NOT_PROVISIONED;
		else if (statusString.equals("PROVISIONING_AND_STARTING"))
			status = VMInsStatusType.PROVISIONING_AND_STARTING;
		else if (statusString.equals("RUNNING"))
			status = VMInsStatusType.RUNNING;
		else if (statusString.equals("PAUSING"))
			status = VMInsStatusType.PAUSING;
		else if (statusString.equals("PAUSED"))
			status = VMInsStatusType.PAUSED;
		else if (statusString.equals("STARTING"))
			status = VMInsStatusType.STARTING;
		else if (statusString.equals("DESTROYED"))
			status = VMInsStatusType.DESTROYED;

		return status;
		
	}

	public static edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType convertStatus(
			VMInsStatusType status) {

		edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType retStatus = null;
		
		if (status == VMInsStatusType.NOT_PROVISIONED)
			retStatus = edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType.NOT_PROVISIONED;
		else if (status == VMInsStatusType.PROVISIONING_AND_STARTING)
			retStatus = edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType.PROVISIONING_AND_STARTING;
		else if (status == VMInsStatusType.RUNNING)
			retStatus = edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType.RUNNING;
		else if (status == VMInsStatusType.PAUSING)
			retStatus = edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType.PAUSING;
		else if (status == VMInsStatusType.PAUSED)
			retStatus = edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType.PAUSED;
		else if (status == VMInsStatusType.STARTING)
			retStatus = edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType.STARTING;
		else if (status == VMInsStatusType.DESTROYED)
			retStatus = edu.fiu.cis.acrl.vescheduler.ws.VmInsStatusType.DESTROYED;

		return retStatus;		
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setVeInsId(String veInsId) {
		this.veInsId = veInsId;
	}

	public String getVeInsId() {
		return veInsId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOs() {
		return os;
	}

	public void setInternalAddress(String internalAddress) {
		this.internalAddress = internalAddress;
	}

	public String getInternalAddress() {
		return internalAddress;
	}

	public void setAccessPort(int accessPort) {
		this.accessPort = accessPort;
	}

	public int getAccessPort() {
		return accessPort;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setStatus(VMInsStatusType status) {
		this.status = status;
	}

	public VMInsStatusType getStatus() {
		return status;
	}

	public void setLastCheckin(Calendar lastCheckin) {
		this.lastCheckin = lastCheckin;
	}

	public Calendar getLastCheckin() {
		return lastCheckin;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppDir(String appDir) {
		this.appDir = appDir;
	}

	public String getAppDir() {
		return appDir;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getDir() {
		return dir;
	}

}
