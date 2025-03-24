package at.fhv.sinkingshipsgame.services;

import at.fhv.sinkingshipsgame.entities.Game;

import java.util.List;

public interface GameService {
    Game findGameById(Long id);
    String createGame();
    List<Game> getAllGames();
    Game setPlayers(Long gameId, Long playerOneId, Long playerTwoId);
    Game updateMap(Long gameId, String map);

}