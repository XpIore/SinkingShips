package at.fhv.sinkingshipsship.controller;

import at.fhv.sinkingshipsship.entities.Ship;
import at.fhv.sinkingshipsship.services.ShipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Ship")
@RequestMapping("/Ship")
public class ShipController {

    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping("/create")
    public String createShip(Long gameId, Long playerId, Integer shipXCoordinate, Integer shipYCoordinate) {
        return shipService.createShip(gameId, playerId, shipXCoordinate, shipYCoordinate);
    }

    @GetMapping("/findByGame")
    public List<Ship> findShipsByGameId(Long gameId) {
        return shipService.findShipsByGameId(gameId);
    }
}
