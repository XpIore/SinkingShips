package at.fhv.sinkingshipsship.mapper;

import at.fhv.common.dto.ShipDTO;
import at.fhv.sinkingshipsship.entities.Ship;

public class ShipMapper {

    public static ShipDTO toDTO(Ship ship) {
        return new ShipDTO(
                ship.getId(),
                ship.getPlayerId(),
                ship.getGameId(),
                ship.getShipXCoordinate(),
                ship.getShipYCoordinate(),
                ship.isHit()
        );
    }

    public static Ship toEntity(ShipDTO dto) {
        Ship ship = new Ship();
        ship.setPlayerId(dto.playerId());
        ship.setGameId(dto.gameId());
        ship.setShipXCoordinate(dto.shipXCoordinate());
        ship.setShipYCoordinate(dto.shipYCoordinate());
        ship.setHit(dto.hit());
        return ship;

    }
}
