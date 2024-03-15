package com.UHGUseCase.TestimonialService.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UHGUseCase.TestimonialService.DTO.PolicyDTO;
import com.UHGUseCase.TestimonialService.DTO.TestimonialDTO;
import com.UHGUseCase.TestimonialService.DTO.UserDTO;
import com.UHGUseCase.TestimonialService.Entity.Testimonial;
import com.UHGUseCase.TestimonialService.FeignClient.PolicyFeignClient;
import com.UHGUseCase.TestimonialService.FeignClient.UserFeignClient;
import com.UHGUseCase.TestimonialService.Repository.TestimonialRepo;

import jakarta.transaction.Transactional;

@Service
public class TestimonialServiceIMPL implements TestimonialService {

	@Autowired
	private TestimonialRepo testimonialRepo;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private PolicyFeignClient policyFeignClient;

	@Override
	public ResponseEntity<String> addTestimonial(long userId, long policyId, TestimonialDTO testimonialDTO) {
		
		Optional<Testimonial> existingTestimonial = testimonialRepo.getTestimonialsByUserIdAndPolicyId(userId,policyId);
		if(existingTestimonial.isPresent()) {
			return ResponseEntity.badRequest().body("Testimonial Already Exist");
		}
		Testimonial testimonial = new Testimonial();
		List<UserDTO> userDTO = userFeignClient.findByUserId(userId);
		for(UserDTO users:userDTO) {
			testimonial.setFirstName(users.getFirstName());
			System.out.println(users.getFirstName());
		}
		List<PolicyDTO> policyDTOList = policyFeignClient.findByPolicyId(policyId);
		if (!policyDTOList.isEmpty()) {
			PolicyDTO policyDTO = policyDTOList.get(0);
			testimonial.setPolicyName(policyDTO.getPolicyName());
		}
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
	@Transactional
	public ResponseEntity<String> processTestimonial(long testimonialId, String action) {
		Optional<Testimonial> fetchTestimonial = testimonialRepo.findById(testimonialId);
		if(fetchTestimonial.isPresent()) {
			Testimonial testimonial=fetchTestimonial.get();
			if("approve".equalsIgnoreCase(action)) {
				testimonial.setStatus("Approved");
			}
			else if("reject".equalsIgnoreCase(action)) {
				testimonial.setStatus("Rejected");
			}
			else {
				return ResponseEntity.badRequest().body("Invalid Action");
			}
			testimonialRepo.save(testimonial);
			return ResponseEntity.ok("Testimonial Processed");
		}
		else {
			return ResponseEntity.notFound().build();
		}
 	}

	@Override
	public List<Testimonial> getTestimonialsByPolicyId(long policyId) {
		List<Testimonial> testimonials = testimonialRepo.getTestimonialsByPolicyId(policyId);
		return testimonials;

	}
	
	
	@Override
	public List<Testimonial> getApprovedTestimonial(){
		List<Testimonial> getApprovedTestimonials = testimonialRepo.getApprovedTestimonials("Approved");
		return getApprovedTestimonials;
	}

	@Override
	public List<Testimonial> getAllPendingTestimonials() {
		List<Testimonial> getPendingTestimonials = testimonialRepo.getPendingTestimonials("Pending");
		return getPendingTestimonials;
	}

}
