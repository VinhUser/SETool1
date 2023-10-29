package com.vinh.result.controller;

import com.vinh.result.controller.res.PagingResponse;
import com.vinh.result.model.dto.ResultDTO;
import com.vinh.result.repository.ResultRepository;
import com.vinh.result.service.ResultService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ResultController {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    ResultService resultService;
    @GetMapping("/getsAll") //get all interview
    public ResponseEntity<PagingResponse<ResultDTO>> getInterviewPagination(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(resultService.findAllResult(pageable));
    }
}
