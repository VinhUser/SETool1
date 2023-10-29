package com.interview.Interview.client;

import com.interview.Interview.model.records.CvRecord;
import com.interview.Interview.model.records.PersonalRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
@HttpExchange
public interface PersonalClient {
        @GetExchange("/reccer/personal/byId/{userId}")
        PersonalRecord getPersonalInfo(@PathVariable int id);
}
