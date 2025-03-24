package at.fhv.sinkingshipscentral.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sinking Ships Gateway API")
                        .version("1.0")
                        .description("API documentation for the Sinking Ships microservices"));
    }

    @Bean
    public List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {
        return locator.getRouteDefinitions().collectList().block().stream()
                .filter(route -> route.getId().matches(".*-api-docs"))
                .map(route -> {
                    String name = route.getId().replace("-api-docs", "");
                    return GroupedOpenApi.builder()
                            .group(name)
                            .pathsToMatch("/" + name + "/**")
                            .build();
                })
                .collect(Collectors.toList());
    }
}
