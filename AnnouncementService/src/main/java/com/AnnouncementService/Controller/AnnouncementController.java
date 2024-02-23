package com.AnnouncementService.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AnnouncementService.AnnouncementDto.AnnouncementDto;
import com.AnnouncementService.Entity.AnnouncementEntity;
import com.AnnouncementService.Service.AnnouncementService;

@RestController
@RequestMapping("/api/test")
public class AnnouncementController {

	    @Autowired
	    private AnnouncementService announcementService;

	    private LocalDateTime endTime=LocalDateTime.now();
	    @CrossOrigin("*")
	    @GetMapping("/fetchAnn")
	    public ResponseEntity<String> getAnnouncementContent() {
	        String announcementContent = announcementService.getAnnouncementContent();
	        if (announcementContent != null) {
	            return new ResponseEntity<String>(announcementContent, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	        }
	    }


	    @CrossOrigin("*")
	    @GetMapping("/getallannou")
	    public List<AnnouncementEntity> getAllAnnouncements(){
	        return announcementService.getAllAnnouncements();
	    }

	    
	    @PostMapping("/admin/addAnn")
	    public ResponseEntity<String> startAnnouncement(@RequestBody AnnouncementDto announcementDto) {
	        String annoucementTextData = announcementDto.getAnnoucementTextData();
	        LocalDateTime startTime = announcementDto.getStartTime();
	        LocalDateTime endTime = announcementDto.getEndTime();
	        announcementService.startAnnouncement(annoucementTextData, startTime, endTime);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }
	    
	  

	    
	    @DeleteMapping("/expired")
	    public ResponseEntity<Void> deleteExpiredAnnouncements() {
	    announcementService.deleteExpiredAnnouncements(endTime);
	    return ResponseEntity.noContent().build();
	    }


}



 


