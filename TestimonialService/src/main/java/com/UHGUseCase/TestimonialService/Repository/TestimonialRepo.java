package com.UHGUseCase.TestimonialService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UHGUseCase.TestimonialService.Entity.Testimonial;

public interface TestimonialRepo extends JpaRepository<Testimonial, Long> {
	@Query(value="SELECT * from `testimonials` where policy_id=?1",nativeQuery = true)
	 List<Testimonial> getTestimonialsByPolicyId(long policyId);
	
	@Query(value="SELECT * from `testimonials` where status=?1",nativeQuery = true)
	 List<Testimonial> getPendingTestimonials(String claimStatus);
	
	@Query(value="SELECT * from `testimonials` where status=?1",nativeQuery = true)
	 List<Testimonial> getApprovedTestimonials(String claimStatus);
	
	@Query(value="SELECT * FROM testimonials WHERE user_id = ?1 AND policy_id = ?2", nativeQuery = true)
	Optional<Testimonial> getTestimonialsByUserIdAndPolicyId(long userId, long policyId);
}
