package com.dustin;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * 	寄信範例
 * 	1.register JavaMailSender use java config (WebConfig.java) or application.properties
 * 	2.@Autowired JavaMailSender and run the service like below
 * 
 * ex:
 * use application.properties:
 * spring.mail.default-encoding=UTF-8
 * spring.mail.host=172.16.9.21
 * spring.mail.port=25
 * spring.mail.properties.mail.smtp.auth=false
 * spring.mail.properties.mail.smtp.ehlo=false
 * spring.mail.properties.mail.debug=false
 * 
 * @author dustinxie
 *
 */
@SpringBootTest
class SpringFunctionApplicationTests {

	@Autowired
	public JavaMailSender emailSender;

	@Test
	void contextLoads() {

	}

//	@Test
//	void sendMailTest() {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo("dustin@universalec.com");
//		message.setSubject("test");
//		message.setText("test 寄送發票");
//		message.setFrom("dustin@universalec.com");
//		emailSender.send(message);
//	}
//
//	@Test
//	void sendMailWithAttachementTest() throws MessagingException {
//		MimeMessage message = emailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		helper.setTo("dustin@universalec.com");
//		helper.setSubject("test");
//		helper.setText("test 寄送發票");
//		helper.setFrom("dustin@universalec.com");
//		FileSystemResource file = new FileSystemResource(new File("app.log"));
//		helper.addAttachment("attachment_app.log", file);
//		emailSender.send(message);
//	}

}
