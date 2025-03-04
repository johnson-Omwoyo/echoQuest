package com.example.echoQuest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.echoQuest.model.Interview;
import com.example.echoQuest.repository.InterviewRepository;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    public List<Interview> getInterviews() {
        return interviewRepository.findAll();
    }
    
    public Interview addInterview(Interview interview) {
        return interviewRepository.save(interview);
    }
    
}