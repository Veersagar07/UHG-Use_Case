package com.AnnouncementService.AnnouncementDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AnnouncementDto {
	private int announcementId;
	private String annoucementTextData;
	private LocalDateTime startTime;
    private LocalDateTime endTime;
	public AnnouncementDto(String annoucementTextData, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.annoucementTextData = annoucementTextData;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "AnnouncementDto [annoucementTextData=" + annoucementTextData + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
    

}
