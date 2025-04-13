package at.fhv.sinkingshipsplayer.services;

import at.fhv.common.dto.PlayerDTO;
import at.fhv.sinkingshipsplayer.entities.Player;
import at.fhv.sinkingshipsplayer.mapper.PlayerMapper;
import at.fhv.sinkingshipsplayer.repositories.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toDTO)
                .toList();
    }

    @Override
    public PlayerDTO findPlayerById(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            return PlayerMapper.toDTO(player.get());
        } else {
            throw new EntityNotFoundException("Player with id " + playerId + " not found");
        }
    }

    @Override
    public String addPlayer(String playerName) {
        Player player = new Player();
        player.setPlayerName(playerName);
        playerRepository.save(player);
        return "Player added: " + playerName;
    }
}
