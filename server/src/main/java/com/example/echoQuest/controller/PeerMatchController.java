package com.example.echoQuest.controller;

import com.example.echoQuest.dto.PeerMatchDTO;
import com.example.echoQuest.model.Interview;
import com.example.echoQuest.model.PeerMatch;
import com.example.echoQuest.repository.InterviewRepository;
import com.example.echoQuest.service.PeerMatchService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peer_match")
public class PeerMatchController {

  @Autowired private InterviewRepository interviewRepository;

  @Autowired PeerMatchService peerMatchService;

  @GetMapping
  List<PeerMatch> getMatches() {
    return peerMatchService.getMatches();
  }

  @PostMapping
  PeerMatch addMatch(@RequestBody PeerMatchDTO peerMatchDTO) {
    Interview interview =
        interviewRepository
            .findById(peerMatchDTO.getInterview())
            .orElseThrow(() -> new RuntimeException("User not found"));

    PeerMatch peerMatch = new PeerMatch();

    peerMatch.setComplete(false);
    peerMatch.setTimeDate(peerMatchDTO.getTimeDate());
    peerMatch.setVideoChatSession(null);
    peerMatch.setFeedBack(null);


    if (peerMatch.getInterview() == null) {
      peerMatch.setInterview(new ArrayList<>());
    }
    peerMatch.getInterview().add(interview);

    return peerMatchService.addMatch(peerMatch);
  }
}
