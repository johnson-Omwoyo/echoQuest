package com.example.echoQuest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Entity
public class VideoChatSession {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String duration;
  private String feedback; // about the connection perfomance

  @OneToOne
  @JoinColumn(name = "peerMatch_id")
  private PeerMatch peerMatch;

  public VideoChatSession() {}

  public VideoChatSession(String duration, String feedback, PeerMatch peerMatch) {
    this.duration = duration;
    this.feedback = feedback;
    this.peerMatch = peerMatch;
  }
}
