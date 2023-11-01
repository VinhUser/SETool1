package com.vinh.result.service.impl;

import com.vinh.result.client.MockTestClient;
import com.vinh.result.client.ProjectClient;
import com.vinh.result.controller.res.PagingResponse;
import com.vinh.result.model.Result;
import com.vinh.result.model.dto.ResultDTO;
import com.vinh.result.model.record.MockTestRecord;
import com.vinh.result.model.record.ProjectRecord;
import com.vinh.result.repository.ResultRepository;
import com.vinh.result.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//    @Override
//    public PagingResponse<ResultDTO> findAllResult(Pageable pageable) {
//        Page<ResultDTO> pageImpl = resultRepository.findAll(pageable).map(resultEntity -> {
//            ResultDTO resultDTOImpl = modelMapper.map(resultEntity, ResultDTO.class);
//
//            try {
//                resultDTOImpl.setMockTest(mockTestClient.getMockTest(resultEntity.getMoock_test_id()));
//
//            }catch (Exception e){
//
//            }
//            return resultDTOImpl;
//        });
//        return PagingResponse.<ResultDTO>builder()
//                .page(pageImpl.getNumber())
//                .size(pageImpl.getSize())
//                .totalPage(pageImpl.getTotalPages())
//                .totalItem(pageImpl.getTotalElements())
//                .contends(pageImpl.getContent())
//                .build();
//    }
@Override
public List<ResultDTO> findAllResults() {
    List<ResultDTO> resultDTOs = new ArrayList<>();
    List<Result> results = resultRepository.findAll(); // Lấy danh sách kết quả từ cơ sở dữ liệu

    for (Result result : results) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResultId(result.getResult_id());
        resultDTO.setComment(result.getComment());

        // Tạo một đối tượng MockTestRecord và ProjectRecord dựa trên dữ liệu từ cơ sở dữ liệu
        MockTestRecord mockTestRecord = new MockTestRecord();
        mockTestRecord.setTest_name(result.getMockTest().getTest_name()); // Sử dụng phương thức getter từ đối tượng MockTest
        mockTestRecord.setTest_description(result.getMockTest().getTest_description()); // Sử dụng phương thức getter từ đối tượng MockTest

        ProjectRecord projectRecord = new ProjectRecord();
        projectRecord.setProject_id(result.getMockTest().getProject().getProject_id()); // Sử dụng phương thức getter từ đối tượng Project
        projectRecord.setProject_name(result.getMockTest().getProject().getProject_name()); // Sử dụng phương thức getter từ đối tượng Project
        projectRecord.setProject_description(result.getMockTest().getProject().getProject_description()); // Sử dụng phương thức getter từ đối tượng Project

        // Thiết lập project trong mockTestRecord
        mockTestRecord.setProject(projectRecord);

        // Thiết lập mockTest trong resultDTO
        resultDTO.setMockTest(mockTestRecord);

        resultDTOs.add(resultDTO);
    }

    return resultDTOs;
}
//    @Override
//    public ResultDTO findResultById(int id) {
//        Result result = resultRepository.findById(id).orElse(null);
//        if (result == null) {
//            return null; // hoặc xử lý nếu không tìm thấy kết quả
//        }
//
//        ResultDTO resultDTO = modelMapper.map(result, ResultDTO.class);
//
//        try {
//            resultDTO.setMockTest(mockTestClient.getMockTest(result.getMoock_test_id()));
//            if (resultDTO.getMockTest() != null) {
//                try {
//                    resultDTO.getMockTest().getProject(projectClient.getProject(resultDTO.getMockTest().project()));
//                } catch (Exception e) {
//                    // Xử lý ngoại lệ nếu cần thiết
//                }
//            }
//        } catch (Exception e) {
//            // Xử lý ngoại lệ nếu cần thiết
//        }
//
//        return resultDTO;
//    }

}
