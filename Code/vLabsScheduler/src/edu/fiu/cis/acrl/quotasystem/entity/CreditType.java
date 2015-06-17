package edu.fiu.cis.acrl.quotasystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


public class CreditType implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private Boolean active;

	private Boolean assignable;

	private String name;

	private String resource;


	private Timestamp updateTs;

	
	private Course course;

	private Policy policy;

	
	private List<UserAssignedQuota> userAssignedQuotas;

    public CreditType() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getAssignable() {
		return this.assignable;
	}

	public void setAssignable(Boolean assignable) {
		this.assignable = assignable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public Timestamp getUpdateTs() {
		return this.updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Policy getPolicy() {
		return this.policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	public List<UserAssignedQuota> getUserAssignedQuotas() {
		return this.userAssignedQuotas;
	}

	public void setUserAssignedQuotas(List<UserAssignedQuota> userAssignedQuotas) {
		this.userAssignedQuotas = userAssignedQuotas;
	}

	@Override
	public String toString() {
		return "CreditType [id=" + id + ", active=" + active + ", assignable="
				+ assignable + ", name=" + name + ", resource=" + resource
				+ ", updateTs=" + updateTs + ", course=" + course + ", policy="
				+ policy + ", userAssignedQuotas=" + userAssignedQuotas + "]";
	}
	
	
	
}