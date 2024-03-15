package com.UHGUseCase.TestimonialService.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.UHGUseCase.TestimonialService.DTO.PolicyDTO;


@FeignClient(name = "Policy-Service", url = "http://localhost:9091/policy")
public interface PolicyFeignClient {
	@GetMapping("/findByPolicyId")
	public List<PolicyDTO> findByPolicyId(@RequestParam long policyId);
}
