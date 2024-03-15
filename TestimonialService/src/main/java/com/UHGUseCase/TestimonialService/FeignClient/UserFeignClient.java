package com.UHGUseCase.TestimonialService.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.UHGUseCase.TestimonialService.DTO.UserDTO;


@FeignClient(name = "User-Service", url = "http://localhost:9090/users")
public interface UserFeignClient {
	@GetMapping("/findByUser")
	public List<UserDTO> findByUserId(@RequestParam long userId);
}