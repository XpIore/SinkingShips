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
                .route(r -> r.path("/v3/api-docs/**")
                        .filters(f -> f.rewritePath("/v3/api-docs/(?<service>.*)", "/${service}/v3/api-docs"))
                        .uri("lb://sinking-ships-player")) // Replace with dynamic routing (see notes below)
                .build();
    }
}
