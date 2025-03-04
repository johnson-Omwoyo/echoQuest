package com.example.echoQuest.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  @Autowired private JavaMailSender mailSender;

  public void sendEmail(String to, String subject, String name) {
    try {
      MimeMessage mimeMessage = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

      helper.setFrom(new InternetAddress("EchoQuest.com", "EchoQuest"));
      helper.setTo(to);
      helper.setSubject(subject);

      // Read the HTML template from the file and use its contents as the email body
      String htmlTemplate =
          new String(
              Files.readAllBytes(Paths.get("src/main/resources/templates/VerifyEmail.html")));

      // Optionally replace placeholders in the HTML template with dynamic content
      htmlTemplate =
          htmlTemplate
              .replace("{{year}}", "2025")
              .replace("{{name}}", name)
              .replace("{{email}}", to); // Example of dynamic content replacement

      helper.setText(htmlTemplate, true); // true means the email body is HTML content

      mailSender.send(mimeMessage);

    } catch (MessagingException | IOException e) {
      e.printStackTrace();
    }
  }

  public void resetEmail(String to, String subject, String name) {
    System.out.println("in here");
    try {
      MimeMessage mimeMessage = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

      helper.setFrom(new InternetAddress("EchoQuest.com", "EchoQuest"));
      helper.setTo(to);
      helper.setSubject(subject);

      // Read the HTML template from the file and use its contents as the email body
      String htmlTemplate =
          new String(
              Files.readAllBytes(Paths.get("src/main/resources/templates/ResetPassword.html")));

      // Optionally replace placeholders in the HTML template with dynamic content
      htmlTemplate =
          htmlTemplate
              .replace("{{year}}", "2025")
              .replace("{{name}}", name)
              .replace("{{email}}", to); // Example of dynamic content replacement

      helper.setText(htmlTemplate, true); // true means the email body is HTML content

      mailSender.send(mimeMessage);

    } catch (MessagingException | IOException e) {
      e.printStackTrace();
    }
  }
}
