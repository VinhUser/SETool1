package com.interview.Interview.config;

import com.interview.Interview.client.CvClient;
import com.interview.Interview.client.PersonalClient;
import com.interview.Interview.client.QuestionClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Collections;

@Configuration
public class WebClientConfig {

    private static final String URL_CV = "http://localhost:9111";   //get api
    private static final String URL_Question = "http://localhost:9314"; //get api

    //get date form CV service
    @Bean
    public CvClient cvClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder()
                                .baseUrl(URL_CV)
                                .defaultCookie("cookieKey", "cookieValue")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultUriVariables(Collections.singletonMap("url", URL_CV))
                                .build()))
                        .build();
        return httpServiceProxyFactory.createClient(CvClient.class);
    }
    //get date form question service
    @Bean
    public QuestionClient questionClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder()
                                .baseUrl(URL_Question)
                                .defaultCookie("cookieKey", "cookieValue")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultUriVariables(Collections.singletonMap("url", URL_Question))
                                .build()))
                        .build();
        return httpServiceProxyFactory.createClient(QuestionClient.class);
    }
    //get date form personal service



}
