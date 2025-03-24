package at.fhv.sinkingshipsplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SinkingShipsPlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkingShipsPlayerApplication.class, args);
    }

}
