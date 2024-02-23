package com.UHGUseCase.UserPolicies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserPoliciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPoliciesApplication.class, args);
	}

}
