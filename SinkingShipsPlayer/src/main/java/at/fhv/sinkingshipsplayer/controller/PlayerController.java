package at.fhv.sinkingshipsplayer.controller;

import at.fhv.sinkingshipsplayer.entities.Player;
import at.fhv.sinkingshipsplayer.services.PlayerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name ="Player")
@RequestMapping("/Player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //Post Mappings
    @PostMapping("/add")
    public String addPlayer(@RequestParam String playerName) {
        return playerService.addPlayer(playerName);
    }

    //Get Mappings
    @GetMapping("/getAll")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/getOne")
    public Player findPlayerById(@RequestParam Long playerId){
        return playerService.findPlayerById(playerId);
    }
}
