package com.UHGUseCase.TestimonialService.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.UHGUseCase.TestimonialService.DTO.PolicyDTO;
import com.UHGUseCase.TestimonialService.DTO.TestimonialDTO;
import com.UHGUseCase.TestimonialService.Entity.Testimonial;


public interface TestimonialService {
	ResponseEntity<String> addTestimonial(long userId, long policyId,TestimonialDTO testimonialDTO);
	List<Testimonial> getTestimonialsByPolicyId(long policyId);
	ResponseEntity<String> processTestimonial(long testimonialId, String action);
	List<Testimonial> getAllPendingTestimonials();
	 List<Testimonial> getApprovedTestimonial();
}
