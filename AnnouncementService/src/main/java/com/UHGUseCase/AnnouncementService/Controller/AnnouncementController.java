package com.UHGUseCase.AnnouncementService.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UHGUseCase.AnnouncementService.DTO.AnnouncementDTO;
import com.UHGUseCase.AnnouncementService.Entity.AnnouncementEntity;
import com.UHGUseCase.AnnouncementService.Service.AnnouncementService;


@RestController
@RequestMapping("/Announcements")
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@PostMapping("/addAnnouncement")
    public ResponseEntity<String> startAnnouncement(@RequestBody AnnouncementDTO announcementDto) {
        String textArea = announcementDto.getTextArea();
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusDays(2);
        ResponseEntity<String> response = announcementService.startAnnouncement(textArea,startTime,endTime);
        return response;
    }
	
	
	@GetMapping("/fetchAnn")
    public ResponseEntity<String> getAnnouncementContent() {
        String announcementContent = announcementService.getAnnouncementContent();
        if (announcementContent != null) {
            return new ResponseEntity<String>(announcementContent, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
	
	@GetMapping("/getallannou")
    public List<AnnouncementEntity> getAllAnnouncements(){
        return announcementService.getAllAnnouncements();
    }
	
	
	
	
}
