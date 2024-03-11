package com.UHGUseCase.AnnouncementService.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UHGUseCase.AnnouncementService.AnnouncementScheduler.AnnouncementScheduler;
import com.UHGUseCase.AnnouncementService.Entity.AnnouncementEntity;
import com.UHGUseCase.AnnouncementService.Repository.AnnouncementRepo;


@Service
public class AnnouncementServiceIMPL implements AnnouncementService {
	
	@Autowired
	private AnnouncementRepo announcementRepo;

	@Autowired
	private AnnouncementScheduler announcementScheduler;
	
	@Override
	public ResponseEntity<String> startAnnouncement(String textArea, LocalDateTime startTime, LocalDateTime endTime) {
		AnnouncementEntity announcement = new AnnouncementEntity(textArea,startTime,endTime);
		announcementRepo.save(announcement);
		announcementScheduler.scheduleAnnouncement(announcement);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@Override
	public String getAnnouncementContent() {
        if (announcementScheduler.isAnnouncementVisible()) {
            AnnouncementEntity activeAnnouncement = announcementScheduler.getActiveAnnouncement();
            return activeAnnouncement.getTextArea();
        } else {
            return null;
        }

}
	
	@Override
	public List<AnnouncementEntity> getAllAnnouncements() {
    	announcementScheduler.checkForExpiredAnnouncements();
        return announcementRepo.findAll();
    }
	
	

}
