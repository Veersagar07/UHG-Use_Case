package com.UHGUseCase.UserPolicies.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUseCase.UserPolicies.Service.UserPoliciesService;

@RestController
@RequestMapping("/userPolicies")
public class UserPoliciesController {
	@Autowired
	private UserPoliciesService userPoliciesService;

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
}
