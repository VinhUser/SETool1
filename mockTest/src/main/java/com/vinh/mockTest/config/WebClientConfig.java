package com.vinh.moockTest.config;

import com.vinh.moockTest.client.SubmissionClient;
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
    private static final String URL_Submission = "http://localhost:9004";   //get api
    @Bean
    public SubmissionClient submissionClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder()
                                .baseUrl(URL_Submission)
                                .defaultCookie("cookieKey", "cookieValue")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultUriVariables(Collections.singletonMap("url", URL_Submission))
                                .build()))
                        .build();
        return httpServiceProxyFactory.createClient(SubmissionClient.class);
    }
}
