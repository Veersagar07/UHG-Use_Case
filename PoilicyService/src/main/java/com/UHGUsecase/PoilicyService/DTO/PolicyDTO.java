package com.UHGUsecase.PoilicyService.DTO;


public class PolicyDTO {
	private Integer policyId;
	private String policyName;
	private Long policyCoverAmount;
	private String description;
	private int minAge;
	private int maxAge;
	private String renewalTerm;
	public PolicyDTO( String policyName, Long policyCoverAmount,
			String description, int minAge, int maxAge, String renewalTerm) {
		super();
		this.policyName = policyName;
		this.policyCoverAmount = policyCoverAmount;
		this.description = description;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.renewalTerm = renewalTerm;
	}
	public PolicyDTO() {
		super();
	}
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
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
	
	
}
