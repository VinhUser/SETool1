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
import java.util.Optional;
import java.util.stream.Collectors;

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
    List<ResultDTO> resultDTOs = resultRepository.findAll().stream()
            .map(resultEntity -> {
                ResultDTO resultDTO = modelMapper.map(resultEntity, ResultDTO.class);

                try {
                    resultDTO.setMockTest(mockTestClient.getMockTest(resultEntity.getMock_test_id()));
                } catch (Exception e) {
                    // Handle exceptions if necessary
                }
                return resultDTO;
            })
            .collect(Collectors.toList());

    return resultDTOs;
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
    @Override
    public ResultDTO deleteResult(int id) {
        Optional<Result> resultOptional = resultRepository.findById(id);

        if (resultOptional.isPresent()) {
            Result deletedResult = resultOptional.get();
            resultRepository.deleteById(id);

            return createSuccessResponse(deletedResult);
        } else {
            return createNotFoundResponse(id);
        }
    }


    //create
    private ResultDTO createSuccessResponse(Result submissionTask) {
        ResultDTO response = new ResultDTO();
        response.setMessage("Project with ID " + submissionTask.getResult_id() + " has been deleted successfully.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }

    private ResultDTO createNotFoundResponse(int id) {
        ResultDTO response = new ResultDTO();
        response.setMessage("Project with ID " + id + " does not exist, so it cannot be deleted.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }
    @Override
    public Result updateResult(Result updatedResult, int id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        if (optionalResult.isPresent()) {
            Result existingResult = optionalResult.get();
            List<Result> resultList = resultRepository.findAll();

            for (Result result : resultList) {
                if (result.getMock_test_id() == updatedResult.getMock_test_id() && result.getResult_id() != id) {
                    throw new IllegalArgumentException("This Result is duplicated with Result ID " + result.getResult_id() + "!, Update fail!");
                }
            }

            existingResult.setComment(updatedResult.getComment());

            return resultRepository.save(existingResult);
        } else {
            throw new IllegalArgumentException("Result with ID " + id + " does not exist, so it cannot be updated.");
        }
    }









}
