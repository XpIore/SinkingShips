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
                // Existing service routes
                .route("player-service", r -> r.path("/player/**")
                        .uri("lb://sinking-ships-player"))
                .route("game-service", r -> r.path("/game/**")
                        .uri("lb://sinking-ships-game"))
                .route("ship-service", r -> r.path("/ship/**")
                        .uri("lb://sinking-ships-ship"))
                // Updated Swagger JSON route
                .route(r -> r.path("/v3/api-docs/**")
                        .filters(f -> f.rewritePath("/v3/api-docs/(?<service>.*)", "/${service}/v3/api-docs"))
                        .uri("lb://sinking-ships-player")) // Target service (player, game, or ship)
                .build();
    }
}
