package at.fhv.sinkingshipscentral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SinkingShipsCentralApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkingShipsCentralApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for Player Service API Docs
                .route(r -> r.path("/v3/api-docs/player")
                        .filters(f -> f.rewritePath("/v3/api-docs/player", "/v3/api-docs"))
                        .uri("lb://sinking-ships-player"))
                // Route for Game Service API Docs
                .route(r -> r.path("/v3/api-docs/game")
                        .filters(f -> f.rewritePath("/v3/api-docs/game", "/v3/api-docs"))
                        .uri("lb://sinking-ships-game")) // Fix service name here
                // Route for Ship Service API Docs
                .route(r -> r.path("/v3/api-docs/ship")
                        .filters(f -> f.rewritePath("/v3/api-docs/ship", "/v3/api-docs"))
                        .uri("lb://sinking-ships-ship"))
                .build();
    }
}
