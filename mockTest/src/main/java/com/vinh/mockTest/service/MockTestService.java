package com.vinh.mockTest.service;

import com.vinh.mockTest.controller.res.PagingResponse;
import com.vinh.mockTest.model.MockTest;
import com.vinh.mockTest.model.dto.MockTestDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface MockTestService {
    MockTest saveMockTest(MockTest mockTest);

    List<MockTestDTO> findAllMockTest1();


    MockTestDTO findMockTestById(int id);


    MockTestDTO deleteMockTest(@PathVariable int id);

    MockTest updateMockTest(@RequestBody MockTest mockTest, @PathVariable int id);
}
