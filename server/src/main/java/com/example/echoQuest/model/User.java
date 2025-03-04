package com.example.echoQuest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "users", indexes = @Index(name = "idx_email_phone", columnList = "email, phone"))
@Getter
@Setter
@ToString(exclude = "password")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  private String name;

  @Column(unique = true)
  private String userName;

  @Column(unique = true)
  private String email;

  @Column(unique = true)
  private String phone;

  private boolean activated = false;
  private String password;
  private boolean requestResetPassword = false;
  private String role; // interviwer interviwee both

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Interview> interviews;

  public User() {}

  public User(
      String name,
      String userName,
      String email,
      String phone,
      String password,
      String role,
      List<Interview> interviews,
      boolean activated,boolean requestResetPassword) {

    this.name = name;
    this.userName = userName;
    this.email = email;
    this.phone = phone;
    this.role = role;
    this.interviews = interviews;
    this.password = password;
    this.activated = activated;
    this.requestResetPassword = requestResetPassword;
  }
}
