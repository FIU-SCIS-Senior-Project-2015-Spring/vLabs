package edu.fiu.cis.acrl.quotasystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;



public class Policy implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private Boolean absolute;

	private Boolean active;

	private Boolean assignable;

	private Integer daysInPeriod;

	private String description;

	private Integer maximum;

	private Integer minimum;

	private String name;

	private Integer daysToRelStart;

	private Integer numberOfPeriods;


	private String policyType;


	private Integer quotaInPeriod;


	private Timestamp startDate;


	private Timestamp updateTs;


	private List<CreditType> creditTypes;

    public Policy() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAbsolute() {
		return this.absolute;
	}

	public void setAbsolute(Boolean absolute) {
		this.absolute = absolute;
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

	public Integer getDaysInPeriod() {
		return this.daysInPeriod;
	}

	public void setDaysInPeriod(Integer daysInPeriod) {
		this.daysInPeriod = daysInPeriod;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Integer getQuotaInPeriod() {
		return quotaInPeriod;
	}

	public void setQuotaInPeriod(Integer quotaInPeriod) {
		this.quotaInPeriod = quotaInPeriod;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfPeriods() {
		return this.numberOfPeriods;
	}

	public void setNumberOfPeriods(Integer numberOfPeriods) {
		this.numberOfPeriods = numberOfPeriods;
	}

	public String getPolicyType() {
		return this.policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
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

	public Integer getDaysToRelStart() {
		return daysToRelStart;
	}

	public void setDaysToRelStart(Integer daysToRelStart) {
		this.daysToRelStart = daysToRelStart;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", absolute=" + absolute + ", active="
				+ active + ", assignable=" + assignable + ", daysToRelStart="
				+ daysToRelStart + ", daysInPeriod=" + daysInPeriod
				+ ", description=" + description + ", maximum=" + maximum
				+ ", minimum=" + minimum + ", name=" + name
				+ ", numberOfPeriods=" + numberOfPeriods + ", policyType="
				+ policyType + ", quotaInPeriod=" + quotaInPeriod
				+ ", startDate=" + startDate + "]";
	}
}