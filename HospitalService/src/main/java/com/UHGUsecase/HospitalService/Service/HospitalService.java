package com.UHGUsecase.HospitalService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UHGUsecase.HospitalService.Entity.Hospital;
import com.UHGUsecase.HospitalService.Repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;

	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public List<Hospital> getHospitals() {
		return hospitalRepository.findAll();
	}
	
	public List<Hospital> getHospitalsByName(String hospitalName) {
		return hospitalRepository.findByHospitalName(hospitalName);
	}
	
	public List<Hospital> getHospitalsByPin(Long pin) {
		return hospitalRepository.findByPin(pin);
	}
	
	public List<Hospital> getHospitalsByCity(String city) {
		return hospitalRepository.findByCity(city);
	}
	
	public ResponseEntity<?> deleteHospitalsById(Integer id) {
		hospitalRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}
}
