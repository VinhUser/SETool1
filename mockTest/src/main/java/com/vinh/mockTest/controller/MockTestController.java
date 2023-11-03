package com.vinh.mockTest.controller;

import com.vinh.mockTest.controller.res.PagingResponse;
import com.vinh.mockTest.model.MockTest;
import com.vinh.mockTest.model.dto.MockTestDTO;
import com.vinh.mockTest.repository.MockTestRepository;
import com.vinh.mockTest.service.MockTestService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MockTestController {
    @Autowired
    private MockTestService mockTestService;
    @Autowired
    private MockTestRepository mockTestRepository;

    @GetMapping("/mockTest/{id}") //get mocktest
    public MockTestDTO mockTest(@PathVariable int id){
        return mockTestService.findMockTestById(id);
    }
    @GetMapping("/mockTest")
    public List<MockTestDTO> getAllMockTests() {
        return mockTestService.findAllMockTest1();
    }
    @PostMapping("/mockTest") //create mocktest
    public MockTest postMocktest(@RequestBody MockTest mockTest) {
        return mockTestRepository.save(mockTest);
    }
    @DeleteMapping("/mockTest/{id}")
    public MockTestDTO deleteMockTest(@PathVariable int id){
        return mockTestService.deleteMockTest(id);
    }
    @PutMapping("/mockTest/{id}")
    public MockTest updateMockTest(@RequestBody MockTest mockTest, @PathVariable int id){
        return mockTestService.updateMockTest(mockTest, id);
    }

}
