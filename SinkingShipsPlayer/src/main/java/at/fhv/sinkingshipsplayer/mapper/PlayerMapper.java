package at.fhv.sinkingshipsplayer.mapper;

import at.fhv.common.dto.PlayerDTO;
import at.fhv.sinkingshipsplayer.entities.Player;

public class PlayerMapper {

    public static PlayerDTO toDTO(Player player) {
        return new PlayerDTO(
                player.getId(),
                player.getPlayerName()
        );
    }

    public static Player toEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setPlayerName(dto.playerName());
        return player;
    }
}