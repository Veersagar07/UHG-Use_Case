package com.UHGUseCase.UserPolicies.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUseCase.UserPolicies.Entity.UserPolicies;
import com.UHGUseCase.UserPolicies.FeignClient.PolicyFeignClient;
import com.UHGUseCase.UserPolicies.FeignClient.UserFeignClient;
import com.UHGUseCase.UserPolicies.Repo.UserPolicyRepo;

@Service
public class UserPoliciesServiceIMPL implements UserPoliciesService {

	@Autowired
	private PolicyFeignClient policyFeignClient;
	
	@Autowired
	private UserPolicyRepo userPolicyRepo;

	@Override
	public ResponseEntity<String> optForPolicy(long userId, long policyId) {
		UserPolicies userPolicies = new UserPolicies();
		List<PolicyDTO> policyDTOList = policyFeignClient.findByPolicyId(policyId);
		if (!policyDTOList.isEmpty()) {
			PolicyDTO policyDTO = policyDTOList.get(0);
			if (policyDTO.getRenewalTerm().equalsIgnoreCase("Quarterly")) {
				userPolicies.setActive(true);
				userPolicies.setRenewalTerm(LocalDateTime.now().plusMonths(3));
			} else if (policyDTO.getRenewalTerm().equalsIgnoreCase("HalfYearly")) {
				userPolicies.setActive(true);
				userPolicies.setRenewalTerm(LocalDateTime.now().plusMonths(6));
			} else if (policyDTO.getRenewalTerm().equalsIgnoreCase("Yearly")) {
				userPolicies.setActive(true);
				userPolicies.setRenewalTerm(LocalDateTime.now().plusMonths(12));
			}
		}
		userPolicies.setUserId(userId);
		userPolicies.setPolicyId(policyId);
		userPolicyRepo.save(userPolicies);
		return ResponseEntity.ok("Policy Added");

	}
	
	@Override
	public List<PolicyDTO> getPolicyOfUser(long userId){
		List<UserPolicies> userPolicies = userPolicyRepo.getPolicyByUserId(userId);
		List<PolicyDTO> policyData=new ArrayList<>();
		for(UserPolicies userPolicy : userPolicies) {
			long policyId=userPolicy.getPolicyId();
			List<PolicyDTO> policyDTOList=policyFeignClient.findByPolicyId(policyId);
			if(!policyDTOList.isEmpty()) {
				PolicyDTO policyDTO = policyDTOList.get(0);
				PolicyDTO policyDTO2= new PolicyDTO(policyId,policyDTO.getPolicyName(),policyDTO.getPolicyCoverAmount(),policyDTO.getDescription(),policyDTO.getMinAge(),policyDTO.getMaxAge(),policyDTO.getRenewalTerm());
				policyData.add(policyDTO2);
			}
		}
		return policyData;
		
	}
}