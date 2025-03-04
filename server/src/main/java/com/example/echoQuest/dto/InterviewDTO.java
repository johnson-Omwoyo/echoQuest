package com.example.echoQuest.dto;


import lombok.*;


@Getter
@Setter
public class InterviewDTO {
 private String interviewType; // technical ,behaviaral
  private String questions; // want this things to be ai generated
  private String timeDate;
  private String role; // interviewer interviewee both
  private Long user;
  private Long peerMatch;
    
}