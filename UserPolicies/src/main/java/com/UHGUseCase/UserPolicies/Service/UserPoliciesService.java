package com.UHGUseCase.UserPolicies.Service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;


public interface UserPoliciesService {

	ResponseEntity<String> optForPolicy(long userId, long policyId);
	List<PolicyDTO> getPolicyOfUser(long userId);
}
