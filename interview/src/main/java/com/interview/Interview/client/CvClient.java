package com.interview.Interview.client;


import com.interview.Interview.model.records.CvRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface CvClient {
    @GetExchange("/api/job/{id}")
    CvRecord getCvInfo(@PathVariable int id);
}
