package com.example.echoQuest.service;

import com.example.echoQuest.model.VideoChatSession;
import com.example.echoQuest.repository.VideoSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoSessionService {
  @Autowired private VideoSessionRepository videoSessionRepository;

  public VideoChatSession addChatSession(VideoChatSession videoChatSession) {
    return videoSessionRepository.save(videoChatSession);
  }
}
