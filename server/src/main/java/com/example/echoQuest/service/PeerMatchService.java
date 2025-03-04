package com.example.echoQuest.service;

import com.example.echoQuest.model.PeerMatch;
import com.example.echoQuest.repository.PeerMatchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeerMatchService {
  @Autowired PeerMatchRepository peerMatchRepository;

  public PeerMatch addMatch(PeerMatch peerMatch) {
    return peerMatchRepository.save(peerMatch);
  }

  public List<PeerMatch> getMatches() {
    return peerMatchRepository.findAll();
  }
}
