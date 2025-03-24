package at.fhv.sinkingshipsplayer.services;

import at.fhv.sinkingshipsplayer.entities.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();
    String addPlayer(String playerName);
    Player findPlayerById(Long playerId);
}
