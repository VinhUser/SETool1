package com.vinh.mockTest.service;

import com.vinh.mockTest.controller.res.PagingResponse;
import com.vinh.mockTest.model.MockTest;
import com.vinh.mockTest.model.dto.MockTestDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MockTestService {
    MockTest saveMockTest(MockTest mockTest);
    PagingResponse<MockTestDTO> findAllMockTest(Pageable pageable);
    List<MockTestDTO> findAllMockTest1();


    MockTestDTO findMockTestById(int id);


}
