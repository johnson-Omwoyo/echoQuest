package com.example.echoQuest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**") // Allow all endpoints
        .allowedOrigins(
            "https://v3bqh38b-5173.uks1.devtunnels.ms",
            "http://localhost:5173") // Allow these origins
        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Allow these HTTP methods
        .allowedHeaders("*") // Allow any headers
        .allowCredentials(true); // Allow credentials like cookies
  }
}
