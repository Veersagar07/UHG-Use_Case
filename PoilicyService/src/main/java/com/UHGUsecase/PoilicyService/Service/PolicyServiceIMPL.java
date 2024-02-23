package com.UHGUsecase.PoilicyService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UHGUsecase.PoilicyService.Entity.Policy;
import com.UHGUsecase.PoilicyService.Repository.PolicyRepo;

@Service
public class PolicyServiceIMPL implements PolicyService {

	@Autowired
	private PolicyRepo policyRepo;

		
	@Override
	public String savePolicy(Policy policy) {
		Policy existingPolicyCheck =policyRepo.findByPolicyName(policy.getPolicyName());
		if (existingPolicyCheck == null) {
			policyRepo.save(policy);
			return "Policy added";
		} else {
			return "Already exists";
		}

	}

	@Override
	public Policy findByPolicyName(String policy_name) {
		return policyRepo.findByPolicyName(policy_name);
		
	}
	
	@Override
	public List<Policy> getAllPolicies() {
		return policyRepo.findAll();
	}
	
	@Override
	public void updatePolicy(Policy policy) {
		policyRepo.save(policy);
	}

	@Override
	public void deletePolicy(long id) {
		policyRepo.deleteById((int) id);
		
	}

	@Override
	public List<Policy> findByPolicyId(long policyId) {
		return policyRepo.findByPolicyId(policyId);
	}
	
	
	

}
