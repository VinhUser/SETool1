package com.vinh.result.controller;

import com.vinh.result.controller.res.PagingResponse;
import com.vinh.result.model.Result;
import com.vinh.result.model.dto.ResultDTO;
import com.vinh.result.repository.ResultRepository;
import com.vinh.result.service.ResultService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    ResultService resultService;
    @GetMapping("/getsAll") //get all interview
    public List<ResultDTO> findAllResults(){
        return resultService.findAllResults();
    }

    @GetMapping("/displayQuestionById1/{id}")
    public Result result(@PathVariable int id){
        return resultRepository.findById(id).orElse(null);
    }
}
