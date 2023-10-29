package com.vinh.result.service.impl;

import com.vinh.result.client.MockTestClient;
import com.vinh.result.client.ProjectClient;
import com.vinh.result.controller.res.PagingResponse;
import com.vinh.result.model.Result;
import com.vinh.result.model.dto.ResultDTO;
import com.vinh.result.repository.ResultRepository;
import com.vinh.result.service.ResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProjectClient projectClient;
    @Autowired
    private MockTestClient mockTestClient;

    @Override
    public Result saveMockTest(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public PagingResponse<ResultDTO> findAllResult(Pageable pageable) {
        Page<ResultDTO> pageImpl = resultRepository.findAll(pageable).map(resultEntity -> {
            ResultDTO resultDTOImpl = modelMapper.map(resultEntity, ResultDTO.class);

            try {
                resultDTOImpl.setMockTest(mockTestClient.getMockTest(resultEntity.getMockTestId()));

            }catch (Exception e){

            }
            return resultDTOImpl;
        });
        return PagingResponse.<ResultDTO>builder()
                .page(pageImpl.getNumber())
                .size(pageImpl.getSize())
                .totalPage(pageImpl.getTotalPages())
                .totalItem(pageImpl.getTotalElements())
                .contends(pageImpl.getContent())
                .build();
    }
}
