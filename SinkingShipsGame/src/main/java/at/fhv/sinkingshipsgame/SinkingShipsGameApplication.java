package at.fhv.sinkingshipsgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SinkingShipsGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkingShipsGameApplication.class, args);
    }

}
