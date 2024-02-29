package com.UHGUseCase.UserPolicies.DTO;

import java.sql.Date;
import java.time.LocalDateTime;


public class UserPolicyDTO {
	private long Id;
	private long userId;
	private long policyId;
	private boolean isActive;
	private LocalDateTime renewalTerm;
	private Date startDate;
	private Date endDate;
	
	public UserPolicyDTO() {
		super();
	}
	public UserPolicyDTO(long id, long userId, long policyId, boolean isActive, LocalDateTime renewalTerm,
			Date startDate, Date endDate) {
		super();
		Id = id;
		this.userId = userId;
		this.policyId = policyId;
		this.isActive = isActive;
		this.renewalTerm = renewalTerm;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getRenewalTerm() {
		return renewalTerm;
	}

	public void setRenewalTerm(LocalDateTime renewalTerm) {
		this.renewalTerm = renewalTerm;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
