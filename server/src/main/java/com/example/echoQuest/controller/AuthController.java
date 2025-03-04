package com.example.echoQuest.controller;

import com.example.echoQuest.dto.LoginDto;
import com.example.echoQuest.dto.NewPasswordDto;
import com.example.echoQuest.model.User;
import com.example.echoQuest.repository.UserRepository;
import com.example.echoQuest.service.AuthService;
import com.example.echoQuest.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {
  @Autowired UserRepository userRepository;

  @Autowired AuthService authService;

  @Autowired PasswordEncoder passwordEncoder;

  @PostMapping("/login")
  ResponseEntity<?> login(@RequestBody LoginDto loginDto) {

    Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
    if (user.isPresent()) {

      if (passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword())) {
        if (user.get().isActivated() == false) {
          return new ResponseEntity<>(user.get(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(
            authService.generateToken(user.get().getEmail()), HttpStatus.OK);
      }
      return new ResponseEntity<>("bad password", HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>("bad email", HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/reset_password")
  ResponseEntity<?> resetPassword(@RequestBody NewPasswordDto newPassword) {
    System.out.println("resetting");
    Optional<User> user = userRepository.findByEmail(newPassword.getEmail());
    if (user.isPresent() && user.get().isRequestResetPassword()) {
      String hashedPassword = passwordEncoder.encode(newPassword.getPassword());
      user.get().setPassword(hashedPassword);
      user.get().setRequestResetPassword(false);
      userRepository.save(user.get());
      return new ResponseEntity<>("Changed Password", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Not allowed", HttpStatus.UNAUTHORIZED);
    }
  }
}
