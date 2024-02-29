package com.UHGUseCase.UserService.Service;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String email;
	
	@Autowired
	private ThymeleafServiceIMPL thymeleafService;
	
	public void sendRegistrationSuccessEmail(String emailto, String name) {
		try {
			MimeMessage message= javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(
					message,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name()
					);
			helper.setTo(emailto);
			Map<String, Object> variables = new HashMap<>();
            variables.put("Name", name);
            variables.put("email", emailto);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            variables.put("date", sdf.format(new Date()));
            helper.setSubject("Registeration Successful");
            helper.setText(thymeleafService.createContent("mail-template.html", variables), true);
            helper.setFrom(email);
			javaMailSender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
