package edu.fiu.cis.acrl.quotasystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;



public class Course implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private String fullname;

	private String shortname;

	private Timestamp updateTs;


	private List<CreditType> creditTypes;

	
	private List<UserProfile> userProfiles;

    public Course() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Timestamp getUpdateTs() {
		return this.updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	public List<CreditType> getCreditTypes() {
		return this.creditTypes;
	}

	public void setCreditTypes(List<CreditType> creditTypes) {
		this.creditTypes = creditTypes;
	}
	
	public List<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", fullname=" + fullname + ", shortname="
				+ shortname + ", updateTs=" + updateTs + "]";
	}
	
	
	
}