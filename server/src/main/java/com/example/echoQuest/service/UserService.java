package com.example.echoQuest.service;

import com.example.echoQuest.model.User;
import com.example.echoQuest.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired AuthService authService;

  @Autowired private UserRepository userRepository;

  public ResponseEntity<?> addUser(User user) {

    userRepository.save(user);

    return new ResponseEntity<>(user.getEmail(), HttpStatus.OK);
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUser(Long id) {
    return userRepository.findById(id);
  }

  public Optional<User> getByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
