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
                .route("game-api-docs", r -> r.path("/v3/api-docs/game")
                        .filters(f -> f.rewritePath("/v3/api-docs/game", "/v3/api-docs"))
                        .uri("lb://SinkingShipsGame")) // Use service name from Eureka
                .route("player-api-docs", r -> r.path("/v3/api-docs/player")
                        .filters(f -> f.rewritePath("/v3/api-docs/player", "/v3/api-docs"))
                        .uri("lb://SinkingShipsPlayer"))
                .route("ship-api-docs", r -> r.path("/v3/api-docs/ship")
                        .filters(f -> f.rewritePath("/v3/api-docs/ship", "/v3/api-docs"))
                        .uri("lb://SinkingShipsShip"))
                .build();
    }
}
