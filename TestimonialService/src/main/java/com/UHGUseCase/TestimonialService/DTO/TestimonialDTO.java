package com.UHGUseCase.TestimonialService.DTO;

import java.time.LocalDateTime;

public class TestimonialDTO {
	private Long Id;
	private long userId;
	private long policyId;
	private String feedback;
	private Integer rating;
	private String status;
	private LocalDateTime date;
	public TestimonialDTO() {
		super();
	}
	
	public TestimonialDTO(Long id, long userId, long policyId, String feedback, Integer rating, String status,
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
