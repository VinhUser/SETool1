package com.vinh.submissionTest.client;

import com.vinh.submissionTest.model.record.TaskRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface TaskClient {
    @GetExchange("/api/task/{id}")
    TaskRecord getTask(@PathVariable int id);
}
