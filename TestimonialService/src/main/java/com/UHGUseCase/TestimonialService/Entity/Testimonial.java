package com.UHGUseCase.TestimonialService.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "testimonials")
public class Testimonial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private long userId;
	private long policyId;
	private String feedback;
	private Integer rating;
	private String status;
	private LocalDateTime date;

	public Testimonial() {
		super();
	}

	public Testimonial(Long id, long userId, long policyId, String feedback, Integer rating, String status,
			LocalDateTime date) {
		super();
		Id = id;
		this.userId = userId;
		this.policyId = policyId;
		this.feedback = feedback;
		this.rating = rating;
		this.status = status;
		this.date = date;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feeback) {
		this.feedback = feeback;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
