package com.example.echoQuest.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.echoQuest.model.User;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private static String secretKey = "the k3y h@h@";

  // Generate JWT Token
  public String generateToken(User user) {
    System.out.println(user.toString());
    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    return JWT.create()
        .withSubject(user.toString())
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
        .sign(algorithm);
  }

  public String generateToken(String email) {
    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    return JWT.create()
        .withSubject(email)
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
        .sign(algorithm);
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);
      JWTVerifier verifier = JWT.require(algorithm).build();
      DecodedJWT jwt = verifier.verify(token);

      // Token is valid
      System.out.println("Token is valid. Subject: " + jwt.getSubject());
      return jwt.getSubject();
    } catch (JWTVerificationException exception) {
      // Invalid token
      System.out.println("Invalid token: " + exception.getMessage());
      return "false";
    }
  }
}
