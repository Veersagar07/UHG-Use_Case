package com.UHGUseCase.UserPolicies.Service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.UHGUseCase.UserPolicies.DTO.PolicyClaimDTO;
import com.UHGUseCase.UserPolicies.DTO.PolicyClaimResponse;
import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;


public interface UserPoliciesService {

	ResponseEntity<String> optForPolicy(long userId, long policyId);
	List<PolicyDTO> getPolicyOfUser(long userId);
	ResponseEntity<String> applyforClaim(long userId, long policyId, long totalAmount,String hospitalName);
	PolicyClaimResponse getClaimDetails(long userId,long policyId);
}
