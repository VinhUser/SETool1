package com.vinh.result.service;

import com.vinh.result.controller.res.PagingResponse;
import com.vinh.result.model.Result;
import com.vinh.result.model.dto.ResultDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {
    Result saveMockTest(Result mockTest);
//    PagingResponse<ResultDTO> findAllResult(Pageable pageable);
    List <ResultDTO> findAllResults();

    ResultDTO findResultById(int id);

    ResultDTO deleteResult(int id);

    Result updateResult(Result updatedResult, int id);
}
