package com.UHGUseCase.TestimonialService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.UHGUseCase.TestimonialService.DTO.TestimonialDTO;
import com.UHGUseCase.TestimonialService.Entity.Testimonial;
import com.UHGUseCase.TestimonialService.Service.TestimonialService;

@RestController
@RequestMapping("/Testimonial")
public class TestimonialController {

	@Autowired
	private TestimonialService testimonialService;

	@PostMapping("/addTestimonial")
	public ResponseEntity<String> addTestimonial(@RequestParam long userId, @RequestParam long policyId,
			@RequestBody TestimonialDTO testimonialDTO) {
		ResponseEntity<String> response=testimonialService.addTestimonial(userId, policyId, testimonialDTO);
		return response;
	}
	
	
	@GetMapping("/getTestimonial")
	public List<Testimonial> getTestimonial(@RequestParam long policyId){
		return testimonialService.getTestimonialsByPolicyId(policyId);
	}
}
