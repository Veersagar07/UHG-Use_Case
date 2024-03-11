package com.UHGUsecase.HospitalService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UHGUsecase.HospitalService.Entity.Hospital;
import com.UHGUsecase.HospitalService.Service.HospitalService;

@CrossOrigin("*")
@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/getAllHospitals")
	public List<Hospital> getAllHospitals(){
		return hospitalService.getHospitals();
	}
	
	@GetMapping("/name")
	public List<Hospital> getAllHospitalsByName(@RequestParam String name){
		return hospitalService.getHospitalsByName(name);
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Hospital>> getAllHospitalsByCity(@RequestBody String city){
		return ResponseEntity.ok(hospitalService.getHospitalsByName(city));
	}
	
	@GetMapping("/{pin}")
	public ResponseEntity<List<Hospital>> getAllHospitalsByPin(@RequestBody Long pin){
		return ResponseEntity.ok(hospitalService.getHospitalsByPin(pin));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addHospital(@RequestBody Hospital hospital){
		hospitalService.addHospital(hospital);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> deleteHospital(@PathVariable("id") Integer id){
		hospitalService.deleteHospitalsById(id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
//		return "Delete by id called";
	}


}
