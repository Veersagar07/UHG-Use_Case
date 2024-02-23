package com.UHGUsecase.PoilicyService.Service;

import java.util.List;

import com.UHGUsecase.PoilicyService.Entity.Policy;

public interface PolicyService {

	Policy findByPolicyName(String policy_name);

	String savePolicy(Policy policy);

	List<Policy> getAllPolicies();

	void updatePolicy(Policy policy);

	void deletePolicy(long policyId);

	List<Policy> findByPolicyId(long policyId);	
}
