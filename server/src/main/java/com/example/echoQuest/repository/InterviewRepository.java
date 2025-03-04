package com.example.echoQuest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.echoQuest.model.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    
}
