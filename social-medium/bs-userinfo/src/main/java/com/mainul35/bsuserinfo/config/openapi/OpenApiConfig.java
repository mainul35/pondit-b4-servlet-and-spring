package com.mainul35.bsuserinfo.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi userInfoApi() {
        return GroupedOpenApi.builder()
                .group("User Info")
                .pathsToMatch("/users", "/users/create", "/users/search")
                .build();
    }

    @Bean
    public GroupedOpenApi connectionsApi() {
        return GroupedOpenApi.builder()
                .group("User Connections")
                .pathsToMatch("/users/{userId}/connections/**")
                .build();
    }
}