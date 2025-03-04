package com.example.echoQuest;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EchoQuestApplication {

  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();
    System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));
    System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
    System.setProperty("SECURITY_USER_PASSWORD", dotenv.get("SECURITY_USER_PASSWORD"));
    System.setProperty("SECURITY_USER_NAME", dotenv.get("SECURITY_USER_NAME"));
    SpringApplication.run(EchoQuestApplication.class, args);
  }
}
