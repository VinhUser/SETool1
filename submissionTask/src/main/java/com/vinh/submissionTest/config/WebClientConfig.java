package com.vinh.submissionTest.config;

import com.vinh.submissionTest.client.ProjectClient;
import com.vinh.submissionTest.client.TaskClient;
import com.vinh.submissionTest.client.UserClient;
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
    private static final String URL_Project = "http://localhost:9001";

    private static final String URL_Task = "http://localhost:9005";//get api
    private static final String URL_User = "http://localhost:9007";
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

    @Bean
    public TaskClient taskClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder()
                                .baseUrl(URL_Task)
                                .defaultCookie("cookieKey", "cookieValue")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultUriVariables(Collections.singletonMap("url", URL_Task))
                                .build()))
                        .build();
        return httpServiceProxyFactory.createClient(TaskClient.class);
    }
    @Bean
    public UserClient userClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder()
                                .baseUrl(URL_User)
                                .defaultCookie("cookieKey", "cookieValue")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultUriVariables(Collections.singletonMap("url", URL_User))
                                .build()))
                        .build();
        return httpServiceProxyFactory.createClient(UserClient.class);
    }
}
