package com.UHGUseCase.AnnouncementService.AnnouncementScheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.UHGUseCase.AnnouncementService.Entity.AnnouncementEntity;
import com.UHGUseCase.AnnouncementService.Repository.AnnouncementRepo;

@Component
public class AnnouncementScheduler {
	@Autowired
	private AnnouncementRepo announcementRepo;

	private AnnouncementEntity activeAnnouncement;

	public AnnouncementEntity getActiveAnnouncement() {
		return activeAnnouncement;
	}

	public void scheduleAnnouncement(AnnouncementEntity announcement) {
		activeAnnouncement = announcement;
	}

	public boolean isAnnouncementVisible() {
		return activeAnnouncement != null;
	}

	@Scheduled(fixedDelay = 60000)
	public void checkForExpiredAnnouncements() {
		if (activeAnnouncement != null) {
			Optional<AnnouncementEntity> optionalAnnouncement = announcementRepo.findById(activeAnnouncement.getId());
			if (optionalAnnouncement.isPresent()) {
				AnnouncementEntity announcement = optionalAnnouncement.get();
				LocalDateTime currentTime = LocalDateTime.now();
				LocalDateTime endTime = announcement.getEndDate();
				if (endTime.isBefore(currentTime)) {
					activeAnnouncement = null;
					announcementRepo.delete(announcement);
				}
			} else {
				activeAnnouncement = null;
			}
			LocalDateTime currentDateTime = LocalDateTime.now();
			List<AnnouncementEntity> expiredAnnouncement = announcementRepo.findByEndDateBefore(currentDateTime);
			announcementRepo.deleteAll(expiredAnnouncement);
		}
	}
}
