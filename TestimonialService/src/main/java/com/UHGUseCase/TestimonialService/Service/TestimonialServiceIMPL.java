package com.UHGUseCase.TestimonialService.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UHGUseCase.TestimonialService.DTO.PolicyDTO;
import com.UHGUseCase.TestimonialService.DTO.TestimonialDTO;
import com.UHGUseCase.TestimonialService.Entity.Testimonial;
import com.UHGUseCase.TestimonialService.FeignClient.PolicyFeignClient;
import com.UHGUseCase.TestimonialService.Repository.TestimonialRepo;


@Service
public class TestimonialServiceIMPL implements TestimonialService {

	@Autowired
	private TestimonialRepo testimonialRepo;
	


	@Override
	public ResponseEntity<String> addTestimonial(long userId, long policyId, TestimonialDTO testimonialDTO) {
		Testimonial testimonial = new Testimonial();
		testimonial.setUserId(userId);
		testimonial.setPolicyId(policyId);
		testimonial.setDate(LocalDateTime.now());
		testimonial.setFeedback(testimonialDTO.getFeedback());
		testimonial.setRating(testimonialDTO.getRating());
		testimonial.setStatus("Pending");
		testimonialRepo.save(testimonial);
		return ResponseEntity.ok("Testimonial Added");
	}
	
	
	
	@Override
	public List<Testimonial> getTestimonialsByPolicyId(long policyId){
		List<Testimonial> testimonials = testimonialRepo.getTestimonialsByPolicyId(policyId);
		return testimonials;
		
	}

}
