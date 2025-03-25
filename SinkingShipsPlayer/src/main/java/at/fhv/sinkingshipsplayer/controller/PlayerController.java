package at.fhv.sinkingshipsplayer.controller;

import at.fhv.common.dto.PlayerDTO;
import at.fhv.sinkingshipsplayer.entities.Player;
import at.fhv.sinkingshipsplayer.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name ="Player")
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //Post Mappings
    @PostMapping("/add")
    @Operation
    public String addPlayer(@RequestParam String playerName) {
        return playerService.addPlayer(playerName);
    }

    //Get Mappings
    @GetMapping("/getAll")
    @Operation
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return players.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PlayerDTO convertToDTO(Player player) {
        return new PlayerDTO(player.getId(), player.getPlayerName());
    }

    @GetMapping("/getOne")
    @Operation
    public PlayerDTO findPlayerById(@RequestParam Long playerId){
        Player player = playerService.findPlayerById(playerId);
        return new PlayerDTO(player.getId(), player.getPlayerName());
    }
}
