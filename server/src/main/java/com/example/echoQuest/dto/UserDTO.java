package com.example.echoQuest.dto;

import com.example.echoQuest.model.Interview;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

  @NotBlank(message = "Cant be empty")
  private String name;

 
  private String userName;

  @NotBlank(message = "email Missing")
  private String email;

  private String phone;

  @NotBlank(message = "role Missing")
  private String role;

  @NotBlank(message = "password Missing")
  private String password;

  private List<Interview> interviews;
}
