package com.UHGUseCase.UserPolicies.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user-policies")
public class UserPolicies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private long userId;
	private long policyId;
	private boolean isActive;
	private LocalDateTime renewalTerm;
	private LocalDate startDate;
	private LocalDate endDate;

	public UserPolicies() {
		super();
	}

	public UserPolicies(Long id, long userId, long policyId, boolean isActive, LocalDateTime renewalTerm,LocalDate startDate,LocalDate endDate) {
		super();
		Id = id;
		this.userId = userId;
		this.policyId = policyId;
		this.isActive = isActive;
		this.renewalTerm = renewalTerm;
		this.startDate=startDate;
		this.endDate=endDate;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
	
}
