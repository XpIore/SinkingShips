package at.fhv.sinkingshipsship.clients;

import at.fhv.common.dto.PlayerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "SinkingShipsPlayer")
public interface PlayerClient {

    @PostMapping("/player/add")
    String addPlayer(@RequestParam String playerName);

    @GetMapping("/player/getOne")
    PlayerDTO findPlayerById(@RequestParam Long playerId);

    @GetMapping("/player/getAll")
    List<PlayerDTO> getAllPlayers();
}
