package at.fhv.sinkingshipsgame.controller;

import at.fhv.common.dto.GameDTO;
import at.fhv.sinkingshipsgame.entities.Game;
import at.fhv.sinkingshipsgame.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Post Mappings
    @PostMapping("/create")
    @Operation(summary = "Create a new game")
    public ResponseEntity<String> createGame() {
        String response = gameService.createGame();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addPlayers")
    @Operation(summary = "Add players to an existing game")
    public ResponseEntity<GameDTO> addPlayers(
            @RequestParam Long gameId,
            @RequestParam Long playerOneId,
            @RequestParam Long playerTwoId) {
        Game game = gameService.setPlayers(gameId, playerOneId, playerTwoId);
        return ResponseEntity.ok(convertToDTO(game));
    }

    @PostMapping("/updateMap")
    @Operation(summary = "Update the game map")
    public ResponseEntity<GameDTO> updateMap(
            @RequestParam Long gameId,
            @RequestParam String map) {
        Game game = gameService.updateMap(gameId, map);
        return ResponseEntity.ok(convertToDTO(game));
    }

    // Get Mappings
    @GetMapping("/getOne")
    @Operation(summary = "Retrieve a single game")
    public ResponseEntity<GameDTO> getOneGame(@RequestParam Long gameId) {
        Game game = gameService.findGameById(gameId);
        return ResponseEntity.ok(convertToDTO(game));
    }

    @GetMapping("/getAll")
    @Operation(summary = "Retrieve all games")
    public ResponseEntity<List<GameDTO>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        List<GameDTO> gameDTOs = games.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(gameDTOs);
    }

    private GameDTO convertToDTO(Game game) {
        return new GameDTO(
                game.getId(),
                game.getPlayerOneId(),
                game.getPlayerTwoId(),
                game.getMap()
        );
    }
}
