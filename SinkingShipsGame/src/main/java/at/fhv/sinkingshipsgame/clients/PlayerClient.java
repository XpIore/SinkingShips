package at.fhv.sinkingshipsgame.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SinkingShipsPlayer")
public interface PlayerClient {

    @PostMapping("/player/add")
    String addPlayer(@RequestParam String playerName);

    Player findPlayerById(@RequestParam Long playerId);

    @GetMapping("/player/getAll")
    List<Player> getAllPlayers();
}
