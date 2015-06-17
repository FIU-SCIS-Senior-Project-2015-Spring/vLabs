package edu.fiu.cis.acrl.vescheduler.server;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Tenant {

	private String veInsId;
	private String username;
	private String password;
	private int kserverId;
	private BigDecimal customerID;
	private String accountID;
	private String group;
	private String url;
	private Calendar endDate;
	private int agents;
	private int admins;
	
	public Tenant() {
		
	}

	public Tenant(
			String veInsId,
			String username,
			String password,
			int kserverId) {
		
		this.veInsId = veInsId;
		this.setUsername(username);
		this.setPassword(password);
		this.setKserverId(kserverId);
		
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setKserverId(int kserverId) {
		this.kserverId = kserverId;
	}

	public int getKserverId() {
		return kserverId;
	}
	
	public void setVeInsId(String veInsId) {
		this.veInsId = veInsId;
	}

	public String getVeInsId() {
		return veInsId;
	}

	public String toString() {
		
		Date endDateDate = null;
		if (endDate != null) 
			endDateDate = endDate.getTime();
		
		return
		"\nTenant:" +
		"\n\tveInsId:    " + veInsId +
		"\n\tkserverId:  " + kserverId +
		"\n\tcustomerID: " + customerID +
		"\n\taccountID:  " + accountID +
		"\n\tgroup:      " + group +
		"\n\turl:        " + url +
		"\n\tusername:   " + username +
		"\n\tpassword:   " + password +
		"\n\tendDate:    " + endDateDate +
		"\n\tagents:     " + agents +
		"\n\tadmins:     " + admins;
		
	}

	public void setCustomerID(BigDecimal customerID) {
		this.customerID = customerID;
	}

	public BigDecimal getCustomerID() {
		return customerID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroup() {
		return group;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setAgents(int agents) {
		this.agents = agents;
	}

	public int getAgents() {
		return agents;
	}

	public void setAdmins(int admins) {
		this.admins = admins;
	}

	public int getAdmins() {
		return admins;
	}
}
