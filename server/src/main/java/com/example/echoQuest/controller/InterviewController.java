package com.example.echoQuest.controller;

import com.example.echoQuest.dto.InterviewDTO;
import com.example.echoQuest.model.Interview;
import com.example.echoQuest.model.PeerMatch;
import com.example.echoQuest.model.User;
import com.example.echoQuest.repository.UserRepository;
import com.example.echoQuest.service.InterviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interview")
public class InterviewController {
  @Autowired private InterviewService interviewService;

  @Autowired private UserRepository userRepository;

  @GetMapping
  public List<Interview> getInterviews() {
    return interviewService.getInterviews();
  }

  @PostMapping
  public Interview addInterview(@RequestBody InterviewDTO interviewDTO) {
    User user =
        userRepository
            .findById(interviewDTO.getUser())
            .orElseThrow(() -> new RuntimeException("User not found"));

    // peerMatchRepository
    //     .findById(interviewDTO.getPeerMatch())
    //     .orElseThrow(() -> new RuntimeException("peerMatch not found"));

    Interview interview = new Interview();
    interview.setInterviewType(interviewDTO.getInterviewType());
    interview.setPeerMatch(null);
    interview.setQuestions(interviewDTO.getQuestions());
    interview.setRole(interviewDTO.getRole());
    interview.setTimeDate(interviewDTO.getTimeDate());
    interview.setUser(user);

    return interviewService.addInterview(interview);
  }
}
