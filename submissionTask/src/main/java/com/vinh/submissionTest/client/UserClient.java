package com.vinh.submissionTest.client;

import com.vinh.submissionTest.model.record.UserRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface UserClient {
    @GetExchange("/api//user/{id}")
    UserRecord getUser(@PathVariable int id);
}
