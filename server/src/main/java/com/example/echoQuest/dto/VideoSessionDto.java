package com.example.echoQuest.dto;

import com.example.echoQuest.model.PeerMatch;
import lombok.*;

@Getter
@Setter
public class VideoSessionDto {
  private String duration;
  private String feedback; // about the connection perfomance
  private Long peerMatch;
}
