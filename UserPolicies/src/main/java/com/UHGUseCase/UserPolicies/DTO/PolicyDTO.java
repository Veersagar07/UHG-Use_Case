package com.UHGUseCase.UserPolicies.DTO;

import org.springframework.stereotype.Component;

@Component
public class PolicyDTO {
	private long policyId;
	private String policyName;
	private Long policyCoverAmount;
	private String description;
	private int minAge;
	private int maxAge;
	private String renewalTerm;
	private long coPay;
	private long premiumAmount;
	public long getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(long premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public PolicyDTO() {
		super();
	}
	
	public PolicyDTO(long policyId, String policyName, Long policyCoverAmount, String description, int minAge,
			int maxAge, String renewalTerm, long coPay , long premiumAmount) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyCoverAmount = policyCoverAmount;
		this.description = description;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.renewalTerm = renewalTerm;
		this.coPay = coPay;
		this.premiumAmount=premiumAmount;
	}

	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public Long getPolicyCoverAmount() {
		return policyCoverAmount;
	}
	public void setPolicyCoverAmount(Long policyCoverAmount) {
		this.policyCoverAmount = policyCoverAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public String getRenewalTerm() {
		return renewalTerm;
	}
	public void setRenewalTerm(String renewalTerm) {
		this.renewalTerm = renewalTerm;
	}

	public long getCoPay() {
		return coPay;
	}

	public void setCoPay(long coPay) {
		this.coPay = coPay;
	}
	
	
}
