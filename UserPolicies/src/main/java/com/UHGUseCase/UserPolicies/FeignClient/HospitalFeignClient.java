package com.UHGUseCase.UserPolicies.FeignClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.UHGUseCase.UserPolicies.DTO.HospitalDTO;

@FeignClient(name = "Hospital-Service", url = "http://localhost:9096/hospital")
public interface HospitalFeignClient {
	
	@GetMapping("/getAllHospitals")
	public List<HospitalDTO> getAllHospitals();
}
