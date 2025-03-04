package com.example.echoQuest.dto;


import lombok.*;

@Getter
@Setter
public class PeerMatchDTO {
  private String timeDate;
  private boolean isComplete;
  private String feedBack;

  private Long interview;

  private Long videoChatSession;
}
