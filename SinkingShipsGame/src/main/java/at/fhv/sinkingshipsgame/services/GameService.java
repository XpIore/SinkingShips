package at.fhv.sinkingshipsgame.services;

import at.fhv.common.dto.GameDTO;
import at.fhv.sinkingshipsgame.entities.Game;

import java.util.List;

public interface GameService {
    GameDTO findGameById(Long id);
    String createGame();
    List<GameDTO> getAllGames();
    GameDTO setPlayers(Long gameId, Long playerOneId, Long playerTwoId);
    GameDTO updateMap(Long gameId, String map);

}