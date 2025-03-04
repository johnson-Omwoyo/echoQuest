package com.example.echoQuest.controller;

import com.example.echoQuest.handler.MyWebSocketHandler;
import com.example.echoQuest.model.User;
import com.example.echoQuest.repository.UserRepository;
import com.example.echoQuest.service.AuthService;
import com.example.echoQuest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnVerifyController {
  @Autowired AuthService authService;

  @Autowired UserService userService;

  @GetMapping("/sse")
  public String sendData(@RequestParam String email) {
    try {
      String message = authService.generateToken(email);
      User user =
          userService.getByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
      user.setActivated(true);
      userService.addUser(user);
      MyWebSocketHandler.sendMessageToClient(email, message);
      return "Data sent to the frontend via WebSocket";
    } catch (Exception e) {
      e.printStackTrace();
      return "Failed to send data";
    }
  }
}
