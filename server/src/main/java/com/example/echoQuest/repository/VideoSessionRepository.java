package com.example.echoQuest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.echoQuest.model.VideoChatSession;

public interface VideoSessionRepository extends JpaRepository<VideoChatSession, Long>{

    
}