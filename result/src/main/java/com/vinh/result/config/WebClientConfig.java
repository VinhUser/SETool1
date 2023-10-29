package com.vinh.mockTest.config;

import com.vinh.mockTest.client.ProjectClient;
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
    private static final String URL_Project = "http://localhost:9001";   //get api
    @Bean
    public ProjectClient projectClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder()
                                .baseUrl(URL_Project)
                                .defaultCookie("cookieKey", "cookieValue")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultUriVariables(Collections.singletonMap("url", URL_Project))
                                .build()))
                        .build();
        return httpServiceProxyFactory.createClient(ProjectClient.class);
    }
}
