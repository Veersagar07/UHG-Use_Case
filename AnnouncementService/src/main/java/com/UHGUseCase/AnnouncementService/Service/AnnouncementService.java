package com.UHGUseCase.AnnouncementService.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.ResponseEntity;

import com.UHGUseCase.AnnouncementService.Entity.AnnouncementEntity;

public interface AnnouncementService {
	ResponseEntity<String> startAnnouncement(String textArea, LocalDateTime startTime, LocalDateTime endTime);
	List<AnnouncementEntity> getAllAnnouncements();
	String getAnnouncementContent();
}
