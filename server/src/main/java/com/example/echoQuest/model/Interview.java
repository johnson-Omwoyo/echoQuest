package com.example.echoQuest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Interview {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  private String interviewType; // technical ,behaviaral
  private String questions; // want this things to be ai generated
  private String timeDate;
  private String role; // interviewer interviewee both
  private boolean matched;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User user;

  @ManyToOne
  @JoinColumn(name = "peerMatch_id")
  private PeerMatch peerMatch;

  public Interview() {}

  public Interview(
      String interviewType,
      String questions,
      String timeDate,
      String role,
      User user,
      PeerMatch peerMatch) {

    this.interviewType = interviewType;
    this.questions = questions;
    this.timeDate = timeDate;
    this.role = role;
    this.user = user;
    this.peerMatch = peerMatch;
  }
}

/*{
  "interviewType": "Technical",
  "questions": "Explain the differences between multithreading and multiprocessing. How would you handle concurrency issues in a web application? What is the importance of deadlock prevention in a distributed system?",
  "timeDate": "2025-03-12T14:30:00",
  "role": "Interviewer",
  "user": 1,
  "peerMatch": 1

}
 */
