package com.UHGUseCase.UserPolicies.Service;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Value("${spring.mail.username}")
	private String email;

	@Autowired
	private ThymeleafService thymeleafService;

	
	public void sendReminder(String emailto, String name) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			helper.setTo(emailto);

			Map<String, Object> variables = new HashMap<>();
			variables.put("Name", name);
			variables.put("email", emailto);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			variables.put("date", sdf.format(new Date()));
			helper.setSubject("Reminder to renew your policy");
			helper.setText(thymeleafService.createContent("PaymentReminderTemplate.html", variables), true);
			helper.setFrom(email);
			javaMailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
