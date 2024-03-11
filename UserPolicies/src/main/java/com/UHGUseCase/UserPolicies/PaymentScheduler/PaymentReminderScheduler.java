package com.UHGUseCase.UserPolicies.PaymentScheduler;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUseCase.UserPolicies.DTO.UserDTO;
import com.UHGUseCase.UserPolicies.DTO.UserPolicyDTO;
import com.UHGUseCase.UserPolicies.Entity.UserPolicies;
import com.UHGUseCase.UserPolicies.FeignClient.PolicyFeignClient;
import com.UHGUseCase.UserPolicies.FeignClient.UserFeignClient;
import com.UHGUseCase.UserPolicies.Service.EmailService;
import com.UHGUseCase.UserPolicies.Service.UserPoliciesService;

import ch.qos.logback.classic.Logger;

@Component
public class PaymentReminderScheduler {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private UserPoliciesService userPoliciesService;
	
	@Autowired
	private EmailService emailService;
		
	@Scheduled(fixedDelay = 60000)//, timeUnit = TimeUnit.HOURS)
    public void scheduleEmail() {		
		List<UserDTO> userList = userFeignClient.getAllUser();
		List<UserPolicies> policyList=userPoliciesService.getAllUserPolicies();
		
		for(UserDTO user:userList) {
			for (UserPolicies userPolicy:policyList) {
				LocalDate currentTime= LocalDate.now();
				LocalDate expiredTime= userPolicy.getEndDate();
				if(currentTime.isAfter(expiredTime)) {
					emailService.sendReminder(user.getEmail(), user.getFirstName());
				}
			}
		}
	}
}
