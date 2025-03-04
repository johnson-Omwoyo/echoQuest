package com.example.echoQuest.controller;

import com.example.echoQuest.dto.VideoSessionDto;
import com.example.echoQuest.model.PeerMatch;
import com.example.echoQuest.model.VideoChatSession;
import com.example.echoQuest.repository.PeerMatchRepository;
import com.example.echoQuest.service.VideoSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class VideoSessionController {
  @Autowired VideoSessionService videoSessionService;

  @Autowired PeerMatchRepository peerMatchRepository;

  @PostMapping
  VideoChatSession addChatSession(@RequestBody VideoSessionDto videoSessionDto) {

    VideoChatSession videoChatSession = new VideoChatSession();
    PeerMatch peerMatch =
        peerMatchRepository
            .findById(videoSessionDto.getPeerMatch())
            .orElseThrow(() -> new RuntimeException("peer match not found"));

    videoChatSession.setDuration(videoSessionDto.getDuration());
    videoChatSession.setFeedback(videoSessionDto.getFeedback());
    videoChatSession.setPeerMatch(peerMatch);
    return videoSessionService.addChatSession(videoChatSession);
  }
}
