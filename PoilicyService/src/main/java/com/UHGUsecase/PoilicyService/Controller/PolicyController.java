package com.UHGUsecase.PoilicyService.Controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.UHGUsecase.PoilicyService.DTO.PolicyDTO;
import com.UHGUsecase.PoilicyService.Entity.Policy;
import com.UHGUsecase.PoilicyService.Exception.PolicyException;
import com.UHGUsecase.PoilicyService.Service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@PostMapping("/addPolicy")
	public String addPolicy(@RequestBody PolicyDTO policyDTO) {
		Policy policiesByName = policyService.findByPolicyName(policyDTO.getPolicyName());
		if (policiesByName != null) {
			return "Policy already exist";
		}
		Policy policy = new Policy(policyDTO.getPolicyName(), policyDTO.getPolicyCoverAmount(),
				policyDTO.getDescription(), policyDTO.getMinAge(), policyDTO.getMaxAge(), policyDTO.getRenewalTerm(),policyDTO.getCoPay(),policyDTO.getPremiumAmount());
		return policyService.savePolicy(policy);
	}

	@GetMapping("/getAllPolicyPlans")
	public List<Policy> getAllPolicyPlans() {
		if (policyService.getAllPolicies().isEmpty()) {
			throw new PolicyException("Empty. Please add some policies");
		}
		return policyService.getAllPolicies();
	}

	@GetMapping("/findByPoliceName")
	public Policy findByPolicyName(@RequestParam String policy_name) throws Exception {
		return policyService.findByPolicyName(policy_name);
	}
	
	@GetMapping("/findByPolicyId")
	public List<Policy> findByPolicyId(@RequestParam long policyId) {
		return policyService.findByPolicyId(policyId);
	}

	@PutMapping("/updatePolicy")
	public void updatePolicy(@RequestBody Policy policy) {

		if (policy.getPolicyId() != 0) {
			policyService.updatePolicy(policy);
		} else {
			throw new PolicyException("Unable to update");

		}
	}
	
	@DeleteMapping("/deletePolicy")
	public void deletePolicy(@RequestParam long policyId)
	{
		policyService.deletePolicy(policyId);
	}
	
	
	@GetMapping("/findAll")
	public List<Policy> getAllPolicies(){
		return policyService.findAll();
	}
	
	@GetMapping("/generatePdf")
	public ResponseEntity<InputStreamResource> generatePdf(@RequestParam long policyId) {
		List<Policy> policies=policyService.findByPolicyId(policyId);
		if(!policies.isEmpty()) {
		ByteArrayInputStream pdfStream=policyService.generatePolicyPdf(policies.get(0));
		HttpHeaders headers=new HttpHeaders();
		headers.add(headers.CONTENT_DISPOSITION,"inline: filename=policy.pdf");
		return ResponseEntity.
				ok().
				headers(headers).
				contentType(MediaType.APPLICATION_PDF).
				body(new InputStreamResource(pdfStream));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
