package com.UHGUsecase.ContactUsService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UHGUsecase.ContactUsService.Entity.ContactUs;
import com.UHGUsecase.ContactUsService.Repository.ContactUsRepository;

@Service
public class ContactUsService {

	@Autowired
	private ContactUsRepository contactUsRepository;

	public List<ContactUs> getAllQueries() {
		return contactUsRepository.findAll();
	}

	public void addQuery(ContactUs query) {
		contactUsRepository.save(query);
	}

	public ResponseEntity<?> deleteQuery(Integer id) {
		contactUsRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

	public void querySolution(Integer id, String solution) {
		ContactUs query = contactUsRepository.findById(id).get();
		if (solution.equals("Reject")) {
			contactUsRepository.deleteById(id);
		} else {
			query.setSolution(solution);
			contactUsRepository.save(query);
		}
	}

}
