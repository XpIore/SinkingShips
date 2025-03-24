package at.fhv.sinkingshipsship.services;

import at.fhv.sinkingshipsship.entities.Ship;

import java.util.List;

public interface ShipService {
    List<Ship> findShipsByGameId(Long gameId);
    String createShip(Long gameId, Long playerId, Integer shipXCoordinate, Integer shipYCoordinate);
    String guessShipPosition(Long gameId, Long enemyPlayerId, Integer shipXCoordinate, Integer shipYCoordinate);
}
