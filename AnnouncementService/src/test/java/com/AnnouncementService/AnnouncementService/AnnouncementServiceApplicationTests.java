package com.AnnouncementService.AnnouncementService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.AnnouncementService.AnnouncementDto.AnnouncementDto;
import com.AnnouncementService.Controller.AnnouncementController;
import com.AnnouncementService.Entity.AnnouncementEntity;
import com.AnnouncementService.Service.AnnouncementService;

@SpringBootTest
class AnnouncementServiceApplicationTests {

	  @Mock
	    private AnnouncementService announcementService;

	    @InjectMocks
	    private AnnouncementController announcementController;	    
	    
	    @Test
	    void testGetAnnouncementContent_ReturnsNoContent() {
	    	
	        when(announcementService.getAnnouncementContent()).thenReturn(null);
	        ResponseEntity<String> response = announcementController.getAnnouncementContent();
	        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	        verify(announcementService, times(1)).getAnnouncementContent();
	    }
	    
	    @Test
	    void testGetAllAnnouncements_ReturnsAllAnnouncements() {
	        AnnouncementEntity announcement1 = new AnnouncementEntity();
	        AnnouncementEntity announcement2 = new AnnouncementEntity();
	        List<AnnouncementEntity> announcements = Arrays.asList(announcement1, announcement2);
	        when(announcementService.getAllAnnouncements()).thenReturn(announcements);
	        List<AnnouncementEntity> response = announcementController.getAllAnnouncements();
	        assertEquals(announcements, response);
	        verify(announcementService, times(1)).getAllAnnouncements();
	    }
	    
	    
	    @Test
	    void testStartAnnouncement_ReturnsCreatedStatus() {
	        AnnouncementDto announcementDto = new AnnouncementDto(
	                "Test announcement",
	                LocalDateTime.now(),
	                LocalDateTime.now().plusHours(1)
	        );

	        ResponseEntity<String> response = announcementController.startAnnouncement(announcementDto);
	        System.out.println(response);
	        assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        verify(announcementService, times(1)).startAnnouncement(
	                announcementDto.getAnnoucementTextData(),
	                announcementDto.getStartTime(),
	                announcementDto.getEndTime()
	        );
	    }

	    
	    @Test
	    void testDeleteExpiredAnnouncements_ReturnsNoContent() {
	        ResponseEntity<Void> response = announcementController.deleteExpiredAnnouncements();
	        System.out.println(response.getStatusCode());
	        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	    }
}
