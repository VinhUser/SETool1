package com.interview.Interview.service;

import com.interview.Interview.controller.res.PagingResponse;
import com.interview.Interview.model.Interview;
import com.interview.Interview.model.dto.InterviewDTO;
import org.springframework.data.domain.Pageable;

public interface InterviewService {
    Interview saveInterview(Interview interview);
    InterviewDTO findInterviewById(int id);
    Interview updateInterview(Interview interview,int id);
    PagingResponse<InterviewDTO> findAllInterview(Pageable pageable);
    String deleteInterview(int id);


}
