package at.fhv.sinkingshipscentral.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi playerApi() {
        return GroupedOpenApi.builder()
                .group("Player Service")
                .pathsToMatch("/player/**")
                .build();
    }

    @Bean
    public GroupedOpenApi gameApi() {
        return GroupedOpenApi.builder()
                .group("Game Service")
                .pathsToMatch("/game/**")
                .build();
    }

    @Bean
    public GroupedOpenApi shipApi() {
        return GroupedOpenApi.builder()
                .group("Ship Service")
                .pathsToMatch("/ship/**")
                .build();
    }
}