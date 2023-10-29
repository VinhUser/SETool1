package com.interview.Interview.service.impl;

import com.interview.Interview.client.CvClient;
import com.interview.Interview.client.QuestionClient;
import com.interview.Interview.controller.res.PagingResponse;
import com.interview.Interview.model.Interview;
import com.interview.Interview.model.dto.InterviewDTO;
import com.interview.Interview.model.records.QuestionRecord;
import com.interview.Interview.repository.InterviewRepository;
import com.interview.Interview.service.InterviewService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    InterviewRepository interviewRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuestionClient questionClient;
    @Autowired
    private CvClient cvClient;


    @Override
    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public InterviewDTO findInterviewById(int id) {
        Interview interview = interviewRepository.findById(id).orElse(null);
        InterviewDTO interviewDTO = null;
        if (interview != null) {
            interviewDTO = modelMapper.map(interviewRepository.findById(id), InterviewDTO.class);
            try {
                interviewDTO.setCv(cvClient.getCvInfo(interview.getCv_id()));
                interviewDTO.setQuestion(questionClient.getQuestionInfo(interview.getQuestion_id()));

                QuestionRecord q = questionClient.getQuestionInfo(interview.getQuestion_id());
            } catch (Exception e) {
            }
        }
        return interviewDTO;
    }


    @Override
    public Interview updateInterview(@RequestBody Interview interview, @PathVariable int id) {
        Optional<Interview> optionalInterview = interviewRepository.findById(id);
        if (optionalInterview.isPresent()) {
            Interview interview1 = optionalInterview.get();
            List<Interview> interviewList = interviewRepository.findAll();
            for (Interview interview2 : interviewList) {
                if (interview1.getId() != id) {
                    throw new IllegalArgumentException("This Interview is duplicated with " + interview2.getId() + "!, Update fail!");
                }else {
                    interview.setId(interview1.getId());
                    interview.setFeedback(interview.getFeedback());
                    interview.setGrade(interview.getGrade());
                    interview.setStatus(interview.getStatus());
                    interview.setCv_id(interview.getCv_id());
                    interview.setDate_feedback(interview.getDate_feedback());
                    interview.setQuestion_id(interview.getQuestion_id());
                    interview.setTime_interview(interview.getTime_interview());

                    interviewRepository.save(interview);
                }
            }
        }
        return interview;
    }


    @Override
    public PagingResponse<InterviewDTO> findAllInterview(Pageable pageable) {
        Page<InterviewDTO> pageImpl = interviewRepository.findAll(pageable).map(interviewEntity -> {
            InterviewDTO interviewDTOImpl = modelMapper.map(interviewEntity, InterviewDTO.class);

            try {
                interviewDTOImpl.setCv(cvClient.getCvInfo(interviewEntity.getCv_id()));
                interviewDTOImpl.setQuestion(questionClient.getQuestionInfo(interviewEntity.getQuestion_id()));
            }catch (Exception e){

            }
            return interviewDTOImpl;
        });
        return PagingResponse.<InterviewDTO>builder()
                .page(pageImpl.getNumber())
                .size(pageImpl.getSize())
                .totalPage(pageImpl.getTotalPages())
                .totalItem(pageImpl.getTotalElements())
                .contends(pageImpl.getContent())
                .build();
    }

    @Override
    public String deleteInterview(int id) {
        String message = "FAIL";
        if (interviewRepository.existsById(id)) {
            interviewRepository.deleteById(id);
            message = "SUCCESS";
        }
        return message;
    }
}
