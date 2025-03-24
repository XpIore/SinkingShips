package at.fhv.sinkingshipsship.controller;

import at.fhv.sinkingshipsship.entities.Ship;
import at.fhv.sinkingshipsship.services.ShipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Ship")
@RequestMapping("/ship")
public class ShipController {

    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping("/create")
    @Operation
    public String createShip(@RequestParam Long gameId, @RequestParam Long playerId, @RequestParam Integer shipXCoordinate, @RequestParam Integer shipYCoordinate) {
        return shipService.createShip(gameId, playerId, shipXCoordinate, shipYCoordinate);
    }

    @GetMapping("/findByGameId/{gameId}")
    @Operation
    public List<Ship> findShipsByGameId(@PathVariable Long gameId) {
        return shipService.findShipsByGameId(gameId);
    }
}
