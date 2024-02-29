package com.UHGUseCase.UserPolicies.DTO;

import java.util.List;

import com.UHGUseCase.UserPolicies.Entity.PolicyClaim;

public class PolicyClaimResponse {
	private List<PolicyClaim> policyClaim;
	private List<PolicyDTO> policyDTOs;

	public PolicyClaimResponse() {
		super();
	}

	public PolicyClaimResponse(List<PolicyClaim> policyClaim, List<PolicyDTO> policyDTOs) {
		super();
		this.policyClaim = policyClaim;
		this.policyDTOs = policyDTOs;
	}

	public List<PolicyClaim> getPolicyClaim() {
		return policyClaim;
	}

	public void setPolicyClaim(List<PolicyClaim> policyClaim) {
		this.policyClaim = policyClaim;
	}

	public List<PolicyDTO> getPolicyDTOs() {
		return policyDTOs;
	}

	public void setPolicyDTOs(List<PolicyDTO> policyDTOs) {
		this.policyDTOs = policyDTOs;
	}

}
