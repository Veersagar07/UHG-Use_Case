package com.UHGUseCase.AnnouncementService.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Announcement")
public class AnnouncementEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String textArea;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public AnnouncementEntity() {
		super();
	}

	public AnnouncementEntity(String textArea, LocalDateTime startDate, LocalDateTime endDate) {
		super();
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
