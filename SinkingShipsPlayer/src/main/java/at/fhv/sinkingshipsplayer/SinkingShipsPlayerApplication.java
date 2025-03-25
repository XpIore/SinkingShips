package at.fhv.sinkingshipsplayer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Player Service API", version = "1.0"))
@EnableFeignClients
public class SinkingShipsPlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkingShipsPlayerApplication.class, args);
    }

}
