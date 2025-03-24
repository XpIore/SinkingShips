package at.fhv.sinkingshipsgame.services;

import at.fhv.sinkingshipsgame.entities.Game;
import at.fhv.sinkingshipsgame.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameServiceImpl implements GameService {

   private final GameRepository gameRepository;

   @Autowired
   public GameServiceImpl(GameRepository gameRepository) {
       this.gameRepository = gameRepository;
   }

    @Override
    public Game findGameById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) {
            return game.get();
        } else {
            throw new EntityNotFoundException("Game with id " + id + " not found");
        }
    }

    @Override
    public String createGame() {
        Game game = new Game();
        gameRepository.save(game);
        return "A game with id " + game.getId() + " has been created";
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game setPlayers(Long gameId, Long playerOneId, Long playerTwoId) {
       Game game = gameRepository.findById(gameId)
               .orElseThrow(() -> new EntityNotFoundException("Game with id " + gameId + " not found"));

       game.setPlayerOneId(playerOneId);
       game.setPlayerTwoId(playerTwoId);
       return gameRepository.save(game);
    }

    @Override
    public Game updateMap(Long gameId, String map) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new EntityNotFoundException("Game with id " + gameId + " not found"));

        game.setMap(map);

        return gameRepository.save(game);
    }
}