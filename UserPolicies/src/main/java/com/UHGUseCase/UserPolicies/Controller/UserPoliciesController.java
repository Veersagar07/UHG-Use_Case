package com.UHGUseCase.UserPolicies.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UHGUseCase.UserPolicies.DTO.PolicyClaimResponse;
import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUseCase.UserPolicies.Entity.PolicyClaim;
import com.UHGUseCase.UserPolicies.PaymentScheduler.PaymentReminderScheduler;
import com.UHGUseCase.UserPolicies.Service.UserPoliciesService;

@RestController
@RequestMapping("/userPolicies")
public class UserPoliciesController {
	@Autowired
	private UserPoliciesService userPoliciesService;
	
	@Autowired
	private PaymentReminderScheduler scheduler;

	@PostMapping("/optForPolicy")
	public ResponseEntity<String> optForPolicy(@RequestParam long userId, @RequestParam long policyId) {
		ResponseEntity<String> response = userPoliciesService.optForPolicy(userId, policyId);
		return response;
	}

	@GetMapping("/getPolicyOfUser")
	public ResponseEntity<List<PolicyDTO>> getPolicyOfUser(@RequestParam long userId){
		List<PolicyDTO> policyOfUser = userPoliciesService.getPolicyOfUser(userId);
		return ResponseEntity.ok(policyOfUser);
	}
	
	@PostMapping("/applyForClaim")
	private ResponseEntity<String> applyforClaim(@RequestParam long userId,@RequestParam long policyId, @RequestParam long totalAmount,@RequestParam String hospitalName) {
		ResponseEntity<String> responseEntity= userPoliciesService.applyforClaim(userId,policyId,totalAmount,hospitalName);
		return responseEntity;
	}
	
	@GetMapping("/getClaimDetails")
	private PolicyClaimResponse getClaimDetails(@RequestParam long userId,@RequestParam long policyId){
		PolicyClaimResponse claimResponse = userPoliciesService.getClaimDetails(userId, policyId);
		return claimResponse;
		
	}
	
	@GetMapping("/getPreviousClaimDetails")
	private List<PolicyClaim> getPreviousClaimDetails(@RequestParam long userId){
		List<PolicyClaim> policyClaims=userPoliciesService.getPreviousClaimsDetails(userId);
		return policyClaims;
	}
	
	
	@Scheduled(cron = "* * * * * *")
	@GetMapping("/reminder")
	public void sendReminder(){
		scheduler.scheduleEmail();
	}
	
	@GetMapping("/getPendingClaims")
	private List<PolicyClaim> getPendingClaims(){
		return userPoliciesService.getPendingClaims();
	}
	
	@PostMapping("/processClaim")
	private ResponseEntity<String> processClaim(@RequestParam long userId,@RequestParam long policyId){
		 ResponseEntity<String> response = userPoliciesService.processClaim(userId, policyId);
		if(response!=null) {
			return response;
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
