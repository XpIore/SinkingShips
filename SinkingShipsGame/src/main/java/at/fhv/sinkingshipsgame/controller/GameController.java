package at.fhv.sinkingshipsgame.controller;

import at.fhv.sinkingshipsgame.entities.Game;
import at.fhv.sinkingshipsgame.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
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

    //Post Mappings
    @PostMapping("/create")
    @Operation
    public String createGame() {
        return gameService.createGame();
    }

    @PostMapping("/addPlayers")
    @Operation
    public String addPlayers(@RequestParam Long gameId, @RequestParam Long playerOneId, @RequestParam Long playerTwoId) {
        gameService.setPlayers(gameId, playerOneId, playerTwoId);
        return "Player one: " + playerOneId + ", and Player two: " + playerTwoId + ", have been added";
    }

    @PostMapping("/updateMap")
    @Operation
    public String updateMap(@RequestParam Long gameId, @RequestParam String map) {
        gameService.updateMap(gameId, map);
        return "Map updated";
    }

    //Get Mappings
    @GetMapping("/getOne")
    @Operation
    public Game getOneGame(@RequestParam Long gameId) {
        return gameService.findGameById(gameId);
    }

    @GetMapping("/getAll")
    @Operation
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }
}