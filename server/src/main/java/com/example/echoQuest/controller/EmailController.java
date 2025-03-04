package com.example.echoQuest.controller;

import com.example.echoQuest.dto.RegisterTokenDto;
import com.example.echoQuest.dto.ResetDto;
import com.example.echoQuest.model.User;
import com.example.echoQuest.service.AuthService;
import com.example.echoQuest.service.EmailService;
import com.example.echoQuest.service.UserService;
import jakarta.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
  @Autowired private EmailService emailService;

  @Autowired UserService userService;

  @PostMapping
  void sendEmail(@RequestBody RegisterTokenDto registerDto) {
    String name = registerDto.getName();
    String email = registerDto.getEmail();

    emailService.sendEmail(email, "Confirm Email", name);
  }

  @PostMapping("/reset_password")
  public void sendReset(@RequestBody ResetDto reset) {
    String email = reset.getEmail();
    Optional<User> user = userService.getByEmail(email);
    if (user.isPresent()) {
      String name = user.get().getName();
      user.get().setRequestResetPassword(true);
      userService.addUser(user.get());
      emailService.resetEmail(email, "Reset Password", name);
      return;
    }
    System.out.println(user);
  }
}
