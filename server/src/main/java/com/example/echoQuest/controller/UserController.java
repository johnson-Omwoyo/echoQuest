package com.example.echoQuest.controller;

import com.example.echoQuest.dto.UserDTO;
import com.example.echoQuest.model.User;
import com.example.echoQuest.security.SecurityConfig;
import com.example.echoQuest.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired private UserService userService;

  @Autowired private PasswordEncoder passwordEncoder;

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public ResponseEntity<?> addUser(@Validated @RequestBody UserDTO userDto) {
    String hashedPassword = passwordEncoder.encode(userDto.getPassword());
    User user = new User();
    user.setEmail(userDto.getEmail());
    user.setInterviews(userDto.getInterviews());
    user.setName(userDto.getName());
    user.setPhone(userDto.getPhone());
    user.setRole(userDto.getRole());
    user.setPassword(hashedPassword);
    user.setUserName(userDto.getUserName());

    return userService.addUser(user);
  }
}
