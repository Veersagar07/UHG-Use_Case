package com.UHGUseCase.UserPolicies.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UHGUseCase.UserPolicies.DTO.PolicyClaimDTO;
import com.UHGUseCase.UserPolicies.DTO.PolicyClaimResponse;
import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUseCase.UserPolicies.DTO.UserPolicyDTO;
import com.UHGUseCase.UserPolicies.Entity.PolicyClaim;
import com.UHGUseCase.UserPolicies.Entity.UserPolicies;
import com.UHGUseCase.UserPolicies.FeignClient.PolicyFeignClient;
import com.UHGUseCase.UserPolicies.Repo.PolicyClaimRepo;
import com.UHGUseCase.UserPolicies.Repo.UserPolicyRepo;

import jakarta.transaction.Transactional;

@Service
public class UserPoliciesServiceIMPL implements UserPoliciesService {

	@Autowired
	private PolicyFeignClient policyFeignClient;

	@Autowired
	private UserPolicyRepo userPolicyRepo;

	@Autowired
	private PolicyClaimRepo policyClaimRepo;


	@Override
	public ResponseEntity<String> optForPolicy(long userId, long policyId) {
		UserPolicies userPolicies = new UserPolicies();
		UserPolicies existingUserPOlicy=userPolicyRepo.findByUserIdAndPolicyId(userId, policyId);
		List<PolicyDTO> policyDTOList = policyFeignClient.findByPolicyId(policyId);
		if (existingUserPOlicy!=null) {
			return ResponseEntity.ok("Policy Already Opted");
		} else {
			if (!policyDTOList.isEmpty()) {
				PolicyDTO policyDTO = policyDTOList.get(0);
				if (policyDTO.getRenewalTerm().equalsIgnoreCase("Quarterly")) {
					userPolicies.setActive(true);
					userPolicies.setRenewalTerm(LocalDateTime.now().plusMonths(3));
					userPolicies.setEndDate(LocalDateTime.now().plusMonths(3).toLocalDate());
				} else if (policyDTO.getRenewalTerm().equalsIgnoreCase("HalfYearly")) {
					userPolicies.setActive(true);
					userPolicies.setRenewalTerm(LocalDateTime.now().plusMonths(6));
					userPolicies.setEndDate(LocalDateTime.now().plusMonths(6).toLocalDate());
				} else if (policyDTO.getRenewalTerm().equalsIgnoreCase("Yearly")) {
					userPolicies.setActive(true);
					userPolicies.setRenewalTerm(LocalDateTime.now().plusMonths(12));
					userPolicies.setEndDate(LocalDateTime.now().plusMonths(12).toLocalDate());
				}
			}

			userPolicies.setUserId(userId);
			userPolicies.setPolicyId(policyId);
			userPolicies.setStartDate(LocalDate.now().minusMonths(4));
			userPolicyRepo.save(userPolicies);
			return ResponseEntity.ok("Policy Added");
		}
	}

	@Override
	public List<PolicyDTO> getPolicyOfUser(long userId) {
		List<UserPolicies> userPolicies = userPolicyRepo.getPolicyByUserId(userId);
		List<PolicyDTO> policyData = new ArrayList<>();
		for (UserPolicies userPolicy : userPolicies) {
			long policyId = userPolicy.getPolicyId();
			List<PolicyDTO> policyDTOList = policyFeignClient.findByPolicyId(policyId);
			if (!policyDTOList.isEmpty()) {
				PolicyDTO policyDTO = policyDTOList.get(0);
				policyData.add(policyDTO);

			}

		}
		return policyData;
	}

	@Override
	public ResponseEntity<String> applyforClaim(long userId, long policyId, long totalAmount, String hospitalName) {
		PolicyClaim claim = new PolicyClaim();
		List<PolicyDTO> policyDTOList = policyFeignClient.findByPolicyId(policyId);
		if (!policyDTOList.isEmpty()) {
			PolicyDTO policyDTO = policyDTOList.get(0);
			LocalDate endDate = LocalDateTime.now().toLocalDate();
			LocalDate startDate = LocalDate.now().minusMonths(4);
			long duration = ChronoUnit.MONTHS.between(startDate, endDate);
			double TotalPremiumPaid = policyDTO.getPremiumAmount() * duration;
			double coPay = policyDTO.getCoPay();
			double coPayment = totalAmount * (coPay / 100);
			double claimAmount = totalAmount - coPayment;
			if (TotalPremiumPaid < totalAmount) {
				claim.setSettledAmount(TotalPremiumPaid - coPayment);
			} else {
				claim.setSettledAmount(claimAmount);
			}
			claim.setClaimDate(endDate);
			claim.setClaimStatus("Pending");
			claim.setTotalAmount(totalAmount);
			claim.setUserId(userId);
			claim.setPolicyId(policyId);
			claim.setHospitalName(hospitalName);
			policyClaimRepo.save(claim);
		}

		return ResponseEntity.ok("Claim Applied");
	}

	
	@Override
	@Transactional
	public PolicyClaimResponse getClaimDetails(long userId, long policyId) {
		List<PolicyClaim> policyClaimDetailsByUserId = policyClaimRepo.getPolicyClaimDetailsByUserId(userId);
		List<PolicyClaim> policyClaimData = new ArrayList<>();
		List<PolicyDTO> policyData = new ArrayList<>();
		List<PolicyDTO> policyDTOList = policyFeignClient.findByPolicyId(policyId);
		if (!policyDTOList.isEmpty()) {
			PolicyDTO policyDTO = policyDTOList.get(0);
			policyData.add(policyDTO);
		}
		for (PolicyClaim policyClaim : policyClaimDetailsByUserId) {
			if (policyClaim.getPolicyId() == policyId) {
				policyClaim.setClaimStatus("Approved");
				policyClaimData.add(policyClaim);
			}
		}

		PolicyClaimResponse response = new PolicyClaimResponse();
		response.setPolicyClaim(policyClaimData);
		response.setPolicyDTOs(policyDTOList);
		return response;
	}
	
}