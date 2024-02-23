package com.UHGUseCase.UserPolicies.DTO;

import java.time.LocalDateTime;


public class UserPolicyDTO {
	private long Id;
	private long userId;
	private long policyId;
	private boolean isActive;
	private LocalDateTime renewalTerm;

	public UserPolicyDTO() {
		super();
	}

	public UserPolicyDTO(long id, long userId, long policyId, boolean isActive, LocalDateTime renewalTerm) {
		super();
		Id = id;
		this.userId = userId;
		this.policyId = policyId;
		this.isActive = isActive;
		this.renewalTerm = renewalTerm;
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

}
