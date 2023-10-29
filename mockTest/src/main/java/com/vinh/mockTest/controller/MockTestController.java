package com.vinh.mockTest.controller;

import com.vinh.mockTest.controller.res.PagingResponse;
import com.vinh.mockTest.model.dto.MockTestDTO;
import com.vinh.mockTest.repository.MockTestRepository;
import com.vinh.mockTest.service.MockTestService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MockTestController {
    @Autowired
    private MockTestService mockTestService;
    @Autowired
    private MockTestRepository mockTestRepository;

    @GetMapping("/getsAll") //get all interview
    public ResponseEntity<PagingResponse<MockTestDTO>> getInterviewPagination(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(mockTestService.findAllMockTest(pageable));
    }
}
