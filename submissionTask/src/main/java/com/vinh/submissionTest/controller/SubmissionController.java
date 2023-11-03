package com.vinh.submissionTest.controller;


import com.vinh.submissionTest.model.SubmissionTask;
import com.vinh.submissionTest.model.dto.SubmissionTaskDTO;
import com.vinh.submissionTest.repository.SubmissionRepository;
import com.vinh.submissionTest.service.SubmissionTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubmissionController {
    @Autowired
    SubmissionTaskService submissionTaskService;
    @Autowired
    SubmissionRepository submissionRepository;
    @GetMapping("/submissionTask")
    public List<SubmissionTaskDTO> findAllTask(){
        return submissionTaskService.findAllTask();
    }
    @GetMapping("/submissionTask/{id}")
    public SubmissionTaskDTO findSubmissionTaskById(int id){
        return submissionTaskService.findSubmissionTaskById(id);
    }
    @PostMapping("/submissionTask")
    public SubmissionTask submissionTask(@RequestBody SubmissionTask submissionTask) {
        return submissionRepository.save(submissionTask);
    }

}
