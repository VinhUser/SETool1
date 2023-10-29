package com.vinh.mockTest.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface SubmissionClient {
    @GetExchange("/api/submission/{id}")
    SubmissionClient getSubmission(@PathVariable int id);
}
