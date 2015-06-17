package edu.fiu.cis.acrl.quotasystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;



public class UserProfile implements Serializable, Comparable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String email;

	private Object type;

	private Timestamp updateTs;

	private String username;

	private List<UserAssignedQuota> userAssignedQuotas;

	private List<Course> courses;

    public UserProfile() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object getType() {
		return this.type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public Timestamp getUpdateTs() {
		return this.updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserAssignedQuota> getUserAssignedQuotas() {
		return this.userAssignedQuotas;
	}

	public void setUserAssignedQuotas(List<UserAssignedQuota> userAssignedQuotas) {
		this.userAssignedQuotas = userAssignedQuotas;
	}
	
	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", email=" + email + ", type=" + type
				+ ", username=" + username + "]";
	}
	public List<CreditType> getCreditTypes(){
		List<CreditType> creditTypes = new ArrayList<CreditType>();
		
		for(UserAssignedQuota uaq:userAssignedQuotas){
			if(!(creditTypes.contains(uaq.getCreditType())))
				creditTypes.add(uaq.getCreditType());			
		}		
				
		return creditTypes;
	}
	
	public List<CreditType> getCreditTypesByCourse(List<Course> courses){
		
		List<CreditType> creditTypes = new ArrayList<CreditType>();

		for(Course c:courses){
			
			for(UserAssignedQuota uaq:userAssignedQuotas){
				
				if(uaq.getCreditType().getCourse().getId().equals(c.getId()))
					creditTypes.add(uaq.getCreditType());			
			}			
		}
	
		
		HashSet<CreditType> hs = new HashSet<CreditType>();
		hs.addAll(creditTypes);
		creditTypes.clear();
		creditTypes.addAll(hs);
				
		return creditTypes;
	}
	
	
	public List<UserAssignedQuota> getUserAssignedQuotasByCreditType(CreditType creditType){
		List<UserAssignedQuota> assignedQuota = new ArrayList<UserAssignedQuota>();
		
		for(UserAssignedQuota uaq:userAssignedQuotas){
			if(uaq.getCreditType().getId().equals(creditType.getId())){
				assignedQuota.add(uaq);
			}
			
		}		

		return assignedQuota;
		
	}

	@Override
	public int compareTo(Object o) {
		if(this.getId().equals(((UserProfile)o).getId()) &&
				this.getUsername().equals(((UserProfile)o).getUsername()) &&
						this.getEmail().equals(((UserProfile)o).getEmail())){
			return 0;
		}else{
			return 1;			
		}

	}
	
}