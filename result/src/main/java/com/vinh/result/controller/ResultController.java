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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    ResultService resultService;
    @GetMapping("/result") //get all interview
    public List<ResultDTO> findAllResults(){
        return resultService.findAllResults();
    }

    @GetMapping("/result/{id}")
    public ResultDTO findResultById(@PathVariable int id){
        return resultService.findResultById(id);
    }
    @PostMapping("/result")
    public Result resultTask(@RequestBody Result submissionTask) {
        return resultRepository.save(submissionTask);
    }
    @DeleteMapping("/result/{id}")
    public ResultDTO deleteResult(@PathVariable int id){
        return resultService.deleteResult(id);
    }
    @PutMapping("/result/{id}")
    public Result updateResult(@RequestBody Result result, @PathVariable int id){
        return resultService.updateResult(result, id);
    }
}
