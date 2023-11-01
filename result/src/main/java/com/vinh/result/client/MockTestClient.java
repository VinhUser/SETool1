package com.vinh.result.client;

import com.vinh.result.model.record.MockTestRecord;
import com.vinh.result.model.record.ProjectRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface MockTestClient {
    @GetExchange("/api/get/{id}")
    MockTestRecord getMockTest(@PathVariable int id);

}
