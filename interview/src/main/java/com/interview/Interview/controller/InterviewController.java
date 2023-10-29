package com.interview.Interview.controller;

import com.interview.Interview.controller.res.PagingResponse;
import com.interview.Interview.controller.res.ResponseObject;
import com.interview.Interview.model.Interview;
import com.interview.Interview.model.dto.InterviewDTO;
import com.interview.Interview.repository.InterviewRepository;
import com.interview.Interview.service.InterviewService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private InterviewRepository interviewRepository;

    @GetMapping("/get/Interview/{id}") //get interview by id
    public ResponseEntity<ResponseObject> getInterviewByID(@PathVariable int id) {
        if (interviewRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(true, "Get Interview Success", interviewService.findInterviewById(id)));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseObject(false, "ID Not Found", null));
    }


    @GetMapping("/getsAll") //get all interview
    public ResponseEntity<PagingResponse<InterviewDTO>> getInterviewPagination(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(interviewService.findAllInterview(pageable));
    }


    @PostMapping("/post/Interview") //create interview
    public ResponseEntity<ResponseObject> postInterview(@RequestBody Interview interview) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, "Add Success", interviewService.saveInterview(interview)));
    }


    @DeleteMapping("/delete/Interview/{id}") //delete interview
    public ResponseEntity<ResponseObject> deleteInterview(@PathVariable int id) {
        return interviewService.deleteInterview(id).equals("SUCCESS")
                ? ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(true, "Delete Success", null))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject(false, "Delete Fail, ID Not Found", null));
    }

    @PutMapping("/update/Interview/{id}") //update interview
    public ResponseEntity<ResponseObject> update(@RequestBody Interview interview, @PathVariable int id) {
        if (interview != null && interviewRepository.existsById(id)){
            interview.setId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(true, "Update Interview Success", interviewService.updateInterview(interview, id)));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseObject(false, "Update Interview Fail", null));
    }

}
