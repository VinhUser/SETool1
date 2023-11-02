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

    @GetMapping("/getsAll") //get all mocktest
    public ResponseEntity<PagingResponse<MockTestDTO>> getInterviewPagination(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(mockTestService.findAllMockTest(pageable));
    }
    @GetMapping("/get/{id}") //get mocktest
    public MockTestDTO mockTest(@PathVariable int id){
        return mockTestService.findMockTestById(id);
    }
    @GetMapping("/getAll")
    public List<MockTestDTO> getAllMockTests() {
        return mockTestService.findAllMockTest1();
    }
    @PostMapping("/post") //create mocktest
    public MockTest postMocktest(@RequestBody MockTest mockTest) {
        return mockTestRepository.save(mockTest);
    }
    @DeleteMapping("delete/{id}")
    public MockTestDTO deleteMockTest(@PathVariable int id) {
        Optional<MockTest> mockTestOptional = mockTestRepository.findById(id);

        if (mockTestOptional.isPresent()) {
            MockTest deletedMockTest = mockTestOptional.get();
            mockTestRepository.deleteById(id);

            return createSuccessResponse(deletedMockTest);
        } else {
            return createNotFoundResponse(id);
        }
    }

    private MockTestDTO createSuccessResponse(MockTest deletedMockTest) {
        MockTestDTO response = new MockTestDTO();
        response.setMessage("MockTest with ID " + deletedMockTest.getMoock_test_id() + " has been deleted successfully.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }

    private MockTestDTO createNotFoundResponse(int id) {
        MockTestDTO response = new MockTestDTO();
        response.setMessage("MockTest with ID " + id + " does not exist, so it cannot be deleted.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }

}
