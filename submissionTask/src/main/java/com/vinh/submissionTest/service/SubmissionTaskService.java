package com.vinh.submissionTest.service;

import com.vinh.submissionTest.model.dto.SubmissionTaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubmissionTaskService {
    List<SubmissionTaskDTO> findAllTask();

    SubmissionTaskDTO findSubmissionTaskById(int id);

    SubmissionTaskDTO deleteSubmissionTask(int id);
}
