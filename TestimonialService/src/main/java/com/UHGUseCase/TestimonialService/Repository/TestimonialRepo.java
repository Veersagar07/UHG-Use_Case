package com.UHGUseCase.TestimonialService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UHGUseCase.TestimonialService.Entity.Testimonial;

public interface TestimonialRepo extends JpaRepository<Testimonial, Long> {
	@Query(value="SELECT * from `testimonials` where policy_id=?1",nativeQuery = true)
	 List<Testimonial> getTestimonialsByPolicyId(long policyId);
}
