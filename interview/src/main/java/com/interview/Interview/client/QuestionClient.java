package com.interview.Interview.client;

import com.interview.Interview.model.records.QuestionRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Optional;

@HttpExchange
public interface QuestionClient {
    @GetExchange("/api/questions/displayQuestionById1/{id}")
    QuestionRecord getQuestionInfo(@PathVariable int id);
}
