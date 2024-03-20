package com.UHGUsecase.ContactUsService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UHGUsecase.ContactUsService.Entity.ContactUs;
import com.UHGUsecase.ContactUsService.Service.ContactUsService;

@CrossOrigin("*")
@RestController
@RequestMapping("Queries")
public class ContactUsController {

	@Autowired
	private ContactUsService contactUsService;

	@GetMapping("/allQueries")
	public ResponseEntity<List<ContactUs>> getAllQueries() {
		return ResponseEntity.ok(contactUsService.getAllQueries());
	}

	@PostMapping("/addQuery")
	public ResponseEntity<Void> addNewEnquiry(@RequestBody ContactUs query) {
		contactUsService.addQuery(query);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("id/{id}")
	public ResponseEntity<?> deleteQuery(@PathVariable("id") Integer id) {
		contactUsService.deleteQuery(id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("solution")
	public ResponseEntity<Void> querySol(@RequestParam Integer id, @RequestParam String solution){
		contactUsService.querySolution(id, solution);
		return ResponseEntity.ok().build();
	}

}
