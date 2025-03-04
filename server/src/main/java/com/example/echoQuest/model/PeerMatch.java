package com.example.echoQuest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PeerMatch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  private String timeDate;
  private boolean isComplete;
  private String feedBack;

  @OneToMany(mappedBy = "peerMatch")
  private List<Interview> interview;

  @OneToOne(mappedBy = "peerMatch")
  private VideoChatSession videoChatSession;

  public PeerMatch() {}

  public PeerMatch(
      String timeDate,
      boolean isComplete,
      String feedBack,
      List<Interview> interview,
      VideoChatSession videoChatSession) {
    this.timeDate = timeDate;
    this.isComplete = isComplete;
    this.feedBack = feedBack;
    this.interview = interview;
    this.videoChatSession = videoChatSession;
  }
}
