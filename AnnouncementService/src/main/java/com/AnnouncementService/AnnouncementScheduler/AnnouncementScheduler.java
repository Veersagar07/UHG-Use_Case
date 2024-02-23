package com.AnnouncementService.AnnouncementScheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.AnnouncementService.Entity.AnnouncementEntity;
import com.AnnouncementService.Repository.AnnouncementRepository;

@Component
public class AnnouncementScheduler {

	@Autowired
	private AnnouncementRepository announcementRepository;
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
			Optional<AnnouncementEntity> optionalAnnouncement = announcementRepository
					.findById(activeAnnouncement.getAnnouncementId());
			if (optionalAnnouncement.isPresent()) {
				AnnouncementEntity announcement = optionalAnnouncement.get();
				LocalDateTime currentTime = LocalDateTime.now();
				int year = announcement.getEndTime().getYear();
				int month = announcement.getEndTime().getMonthValue();
				int dayOfTheMonth = announcement.getEndTime().getDayOfMonth();
				int hour = announcement.getEndTime().getHour();
				int minute = announcement.getEndTime().getMinute();
				int second = announcement.getEndTime().getSecond();

				LocalDateTime endTime = LocalDateTime.of(year, month, dayOfTheMonth, hour, minute, second);
				Duration duration = Duration.between(currentTime, endTime);
				long add = duration.toMinutes();
				LocalDateTime currentTimePlusExpirationTime = currentTime.plusMinutes(add);

				if ((announcement.getEndTime()).isBefore(currentTimePlusExpirationTime)) {
					System.out.println(announcement.getEndTime());
					System.out.println(announcement.getEndTime());
					activeAnnouncement = null;
					System.out.println("Out");
					announcementRepository.delete(announcement);
				}
			} else {
				activeAnnouncement = null;
			}
			LocalDateTime currentDateTime = LocalDateTime.now();
			List<AnnouncementEntity> expiredAnnouncement = announcementRepository.findByEndTimeBefore(currentDateTime);
			announcementRepository.deleteAll(expiredAnnouncement);

		}
	}

}
