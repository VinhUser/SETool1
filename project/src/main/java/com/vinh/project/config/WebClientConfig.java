package com.vinh.project.config;

import com.vinh.project.client.GroupClient;
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
    private static final String URL_Group = "http://localhost:9006";   //get api
    @Bean
    public GroupClient groupClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder()
                                .baseUrl(URL_Group)
                                .defaultCookie("cookieKey", "cookieValue")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultUriVariables(Collections.singletonMap("url", URL_Group))
                                .build()))
                        .build();
        return httpServiceProxyFactory.createClient(GroupClient.class);
    }
}
