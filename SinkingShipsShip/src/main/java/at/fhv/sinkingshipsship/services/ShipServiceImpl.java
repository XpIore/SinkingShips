package at.fhv.sinkingshipsship.services;

import at.fhv.sinkingshipsship.entities.Ship;
import at.fhv.sinkingshipsship.repositories.ShipRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;

    @Autowired
    public ShipServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    @Override
    public List<Ship> findShipsByGameId(Long gameId) {
        return shipRepository.findByGameId(gameId);
    }

    @Override
    public String createShip(Long gameId, Long playerId, Integer shipXCoordinate, Integer shipYCoordinate) {
        Ship ship = new Ship();
        ship.setGameId(gameId);
        ship.setPlayerId(playerId);
        ship.setShipXCoordinate(shipXCoordinate);
        ship.setShipYCoordinate(shipYCoordinate);
        shipRepository.save(ship);
        return "A ship with id " + ship.getId() + " has been created";
    }

    @Override
    public String guessShipPosition(Long gameId, Long enemyPlayerId, Integer shipXCoordinate, Integer shipYCoordinate) {
        return "";
    }
}
