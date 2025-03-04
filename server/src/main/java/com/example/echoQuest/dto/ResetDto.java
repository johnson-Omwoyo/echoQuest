package com.example.echoQuest.dto;

import lombok.*;

@Getter
@Setter
public class ResetDto {
  String email;

  public ResetDto() {}

  public ResetDto(String email) {
    this.email = email;
  }
}
