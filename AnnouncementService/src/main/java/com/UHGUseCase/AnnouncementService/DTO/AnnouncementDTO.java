package com.UHGUseCase.AnnouncementService.DTO;

import java.time.LocalDateTime;

public class AnnouncementDTO {
	private long Id;
	private String textArea;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	public AnnouncementDTO() {
		super();
	}
	public AnnouncementDTO(long id, String textArea, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		Id = id;
		this.textArea = textArea;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getTextArea() {
		return textArea;
	}
	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	

}
