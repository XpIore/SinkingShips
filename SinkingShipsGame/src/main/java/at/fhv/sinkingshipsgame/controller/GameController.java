package at.fhv.sinkingshipsgame.controller;

import at.fhv.common.dto.GameDTO;
import at.fhv.sinkingshipsgame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createGame() {
        return ResponseEntity.ok(gameService.createGame());
    }

    @PostMapping("/addPlayers")
    public ResponseEntity<GameDTO> addPlayers(
            @RequestParam Long gameId,
            @RequestParam Long playerOneId,
            @RequestParam Long playerTwoId) {
        return ResponseEntity.ok(gameService.setPlayers(gameId, playerOneId, playerTwoId));
    }

    @PostMapping("/updateMap")
    public ResponseEntity<GameDTO> updateMap(
            @RequestParam Long gameId,
            @RequestParam String map) {
        return ResponseEntity.ok(gameService.updateMap(gameId, map));
    }

    @GetMapping("/getOne")
    public ResponseEntity<GameDTO> getOneGame(@RequestParam Long gameId) {
        return ResponseEntity.ok(gameService.findGameById(gameId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GameDTO>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }
}
