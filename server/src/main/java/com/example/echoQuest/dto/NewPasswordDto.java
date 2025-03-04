package com.example.echoQuest.dto;

import lombok.*;

@Getter
@Setter
public class NewPasswordDto {
  String password;
  String email;

  public NewPasswordDto() {}

  public NewPasswordDto(String password, String email) {
    this.password = password;
    this.email = email;
  }
}
