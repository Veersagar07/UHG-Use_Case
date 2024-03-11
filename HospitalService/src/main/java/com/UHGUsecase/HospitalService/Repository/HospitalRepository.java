package com.UHGUsecase.HospitalService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UHGUsecase.HospitalService.Entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
	public List<Hospital> findByHospitalName(String hospitalName);
	public List<Hospital> findByCity(String city);
	public List<Hospital> findByPin(Long pin);
	
	public void deleteByHospitalId(Integer id);
}
