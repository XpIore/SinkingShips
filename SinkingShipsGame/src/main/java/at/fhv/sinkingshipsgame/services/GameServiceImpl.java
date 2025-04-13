package at.fhv.sinkingshipsgame.services;

import at.fhv.common.dto.GameDTO;
import at.fhv.sinkingshipsgame.entities.Game;
import at.fhv.sinkingshipsgame.mapper.GameMapper;
import at.fhv.sinkingshipsgame.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameDTO findGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game with id " + id + " not found"));
        return GameMapper.toDTO(game);
    }

    @Override
    public GameDTO setPlayers(Long gameId, Long playerOneId, Long playerTwoId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new EntityNotFoundException("Game with id " + gameId + " not found"));

        game.setPlayerOneId(playerOneId);
        game.setPlayerTwoId(playerTwoId);
        return GameMapper.toDTO(gameRepository.save(game));
    }

    @Override
    public GameDTO updateMap(Long gameId, String map) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new EntityNotFoundException("Game with id " + gameId + " not found"));

        game.setMap(map);
        return GameMapper.toDTO(gameRepository.save(game));
    }

    @Override
    public String createGame() {
        Game game = new Game();
        gameRepository.save(game);
        return "A game with id " + game.getId() + " has been created";
    }

    @Override
    public List<GameDTO> getAllGames() {
        return gameRepository.findAll()
                .stream()
                .map(GameMapper::toDTO)
                .toList();
    }
}
