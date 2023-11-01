package com.vinh.project.client;

import com.vinh.project.model.record.GroupRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface GroupClient {
    @GetExchange("/api/group/{id}")
    GroupRecord getGroup(@PathVariable int id);
}
