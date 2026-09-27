package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendBillWithAttachment(String toEmail, byte[] pdfBytes) {

		try {

			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(toEmail);
			helper.setSubject("Your ShopMate Invoice");
			helper.setText("Thank you for shopping with us! Please find attached invoice.");

			helper.addAttachment("ShopMate_Bill.pdf", new ByteArrayResource(pdfBytes));

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
