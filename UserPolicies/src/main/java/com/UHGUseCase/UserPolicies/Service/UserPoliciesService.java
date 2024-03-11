package com.UHGUseCase.UserPolicies.Service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.UHGUseCase.UserPolicies.DTO.PolicyClaimDTO;
import com.UHGUseCase.UserPolicies.DTO.PolicyClaimResponse;
import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUseCase.UserPolicies.Entity.PolicyClaim;
import com.UHGUseCase.UserPolicies.Entity.UserPolicies;


public interface UserPoliciesService {

	ResponseEntity<String> optForPolicy(long userId, long policyId);
	List<PolicyDTO> getPolicyOfUser(long userId);
	ResponseEntity<String> applyforClaim(long userId, long policyId, long totalAmount,String hospitalName);
	PolicyClaimResponse getClaimDetails(long userId,long policyId);
	List<PolicyClaim> getPreviousClaimsDetails(long userId);
	List<UserPolicies> getAllUserPolicies();
	List<PolicyClaim> getPendingClaims();
	ResponseEntity<String>  processClaim(long userId, long policyId, String action);
}
