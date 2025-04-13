package at.fhv.sinkingshipsplayer.services;

import at.fhv.common.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    List<PlayerDTO> getAllPlayers();
    String addPlayer(String playerName);
    PlayerDTO findPlayerById(Long playerId);
}
