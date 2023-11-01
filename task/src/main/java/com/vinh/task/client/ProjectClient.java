package com.vinh.task.client;


import com.vinh.task.model.record.ProjectRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ProjectClient {
    @GetExchange("/api/project/{id}")
    ProjectRecord getProject(@PathVariable int id);
}
