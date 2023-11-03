package com.vinh.result.service.impl;

import com.vinh.result.client.MockTestClient;
import com.vinh.result.client.ProjectClient;
import com.vinh.result.model.Result;
import com.vinh.result.model.dto.ResultDTO;
import com.vinh.result.repository.ResultRepository;
import com.vinh.result.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
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
public List<ResultDTO> findAllResults() {
        return null;
}
    @Override
    public ResultDTO findResultById(int id) {
        Result result = resultRepository.findById(id).orElse(null);
        if (result == null) {
            return null; // hoặc xử lý nếu không tìm thấy kết quả
        }

        ResultDTO resultDTO = modelMapper.map(result, ResultDTO.class);

        try {
            resultDTO.setMockTest(mockTestClient.getMockTest(result.getMock_test_id()));

        } catch (Exception e) {
            // Xử lý ngoại lệ nếu cần thiết
        }

        return resultDTO;
    }

}
