package at.fhv.sinkingshipsgame.controller;

import at.fhv.sinkingshipsgame.entities.Game;
import at.fhv.sinkingshipsgame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String createGame() {
        return gameService.createGame();
    }

    @PostMapping("/addPlayers")
    public String addPlayers(Long gameId, Long playerOneId, Long playerTwoId) {
        gameService.setPlayers(gameId, playerOneId, playerTwoId);
        return "Player one: " + playerOneId + ", and Player two: " + playerTwoId + ", have been added";
    }

    @PostMapping("/updateMap")
    public String updateMap(Long gameId, String map) {
        gameService.updateMap(gameId, map);
        return "Map updated";
    }

    //Get Mappings
    @GetMapping("/getOne")
    public Game getOneGame(Long gameId) {
        return gameService.findGameById(gameId);
    }

    @GetMapping("/getAll")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }
}