package at.fhv.sinkingshipsgame.controller;

import at.fhv.sinkingshipsgame.entities.Game;
import at.fhv.sinkingshipsgame.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    // Post Mappings
    @PostMapping("/create")
    @Operation(summary = "Create a new game",
            responses = {@ApiResponse(responseCode = "200", description = "Game created successfully")})
    public ResponseEntity<String> createGame() {
        String response = gameService.createGame();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addPlayers")
    @Operation(summary = "Add players to an existing game",
            responses = {@ApiResponse(responseCode = "200", description = "Players added successfully")})
    public ResponseEntity<String> addPlayers(@RequestParam Long gameId,
                                             @RequestParam Long playerOneId,
                                             @RequestParam Long playerTwoId) {
        gameService.setPlayers(gameId, playerOneId, playerTwoId);
        String response = "Player one: " + playerOneId + ", and Player two: " + playerTwoId + ", have been added";
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateMap")
    @Operation(summary = "Update the game map",
            responses = {@ApiResponse(responseCode = "200", description = "Map updated successfully")})
    public ResponseEntity<String> updateMap(@RequestParam Long gameId,
                                            @RequestParam String map) {
        gameService.updateMap(gameId, map);
        return ResponseEntity.ok("Map updated");
    }

    // Get Mappings
    @GetMapping("/getOne")
    @Operation(summary = "Retrieve a single game",
            responses = {@ApiResponse(responseCode = "200", description = "Game retrieved successfully")})
    public ResponseEntity<Game> getOneGame(@RequestParam Long gameId) {
        Game game = gameService.findGameById(gameId);
        return ResponseEntity.ok(game);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Retrieve all games",
            responses = {@ApiResponse(responseCode = "200", description = "List of games retrieved successfully")})
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }
}
