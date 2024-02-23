package com.UHGUsecase.PoilicyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PoilicyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoilicyServiceApplication.class, args);
	}

}
