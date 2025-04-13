package at.fhv.sinkingshipsgame.mapper;

import at.fhv.common.dto.GameDTO;
import at.fhv.sinkingshipsgame.entities.Game;

public class GameMapper {

    public static GameDTO toDTO(Game game) {
        return new GameDTO(
                game.getId(),
                game.getPlayerOneId(),
                game.getPlayerTwoId(),
                game.getMap()
        );
    }

    public static Game toEntity(GameDTO dto) {
        Game game = new Game();
        game.setPlayerOneId(dto.playerOneId());
        game.setPlayerTwoId(dto.playerTwoId());
        game.setMap(dto.map());
        return game;
    }
}