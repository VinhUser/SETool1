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
    public PagingResponse<MockTestDTO> findAllMockTest(Pageable pageable) {
        Page<MockTestDTO> pageImpl = mockTestRepository.findAll(pageable).map(mockTestEntity -> {
            MockTestDTO mockTestDTOImpl = modelMapper.map(mockTestEntity, MockTestDTO.class);

            try {
                mockTestDTOImpl.setProject(projectClient.getProject(mockTestEntity.getProjectId()));
            }catch (Exception e){

            }
            return mockTestDTOImpl;
        });
        return PagingResponse.<MockTestDTO>builder()
                .page(pageImpl.getNumber())
                .size(pageImpl.getSize())
                .totalPage(pageImpl.getTotalPages())
                .totalItem(pageImpl.getTotalElements())
                .contends(pageImpl.getContent())
                .build();
    }
}
