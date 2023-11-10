package com.vinh.mockTest.service.impl;

import com.vinh.mockTest.client.ProjectClient;
import com.vinh.mockTest.controller.res.PagingResponse;
import com.vinh.mockTest.model.MockTest;
import com.vinh.mockTest.model.dto.MockTestDTO;
import com.vinh.mockTest.repository.MockTestRepository;
import com.vinh.mockTest.service.MockTestService;
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
import java.util.stream.Collectors;

@Slf4j
@Service
public class MockTestServiceImpl implements MockTestService {
    @Autowired
    MockTestRepository mockTestRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProjectClient projectClient;

    @Override
    public MockTest saveMockTest(MockTest mockTest) {
        return mockTestRepository.save(mockTest);
    }


    @Override
    public List<MockTestDTO> findAllMockTest1() {
        List<MockTestDTO> mockTestDTOs = mockTestRepository.findAll().stream()
                .map(mockTestEntity -> {
                    MockTestDTO mockTestDTO = modelMapper.map(mockTestEntity, MockTestDTO.class);

                    try {
                        mockTestDTO.setProject(projectClient.getProject(mockTestEntity.getProject_id()));
                    } catch (Exception e) {
                        // Xử lý ngoại lệ nếu cần thiết
                    }
                    return mockTestDTO;
                })
                .collect(Collectors.toList());

        return mockTestDTOs;
    }
    @Override
    public MockTestDTO findMockTestById(int id) {
        MockTest mockTest = mockTestRepository.findById(id).orElse(null);
        if (mockTest == null) {
            return null; // hoặc xử lý nếu không tìm thấy mock test
        }

        MockTestDTO mockTestDTO = modelMapper.map(mockTest, MockTestDTO.class);

        try {
            mockTestDTO.setProject(projectClient.getProject(mockTest.getProject_id()));
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu cần thiết
        }

        return mockTestDTO;
    }
    @Override
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
    @Override
    public MockTest updateMockTest(@RequestBody MockTest mockTest, @PathVariable int id) {
        Optional<MockTest> mockTestOptional = mockTestRepository.findById(id);
        if (mockTestOptional.isPresent()) {
            MockTest mockTest1 = mockTestOptional.get();
            List<MockTest> mockTestList = mockTestRepository.findAll();
            for (MockTest mockTest2 : mockTestList) {


                mockTest.setTest_name(mockTest.getTest_name());
                mockTest.setTest_description(mockTest.getTest_description());


                mockTestRepository.save(mockTest);

            }
        }
        return mockTest;
    }

}





