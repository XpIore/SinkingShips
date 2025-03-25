package at.fhv.sinkingshipsship.controller;

import at.fhv.common.dto.ShipDTO;
import at.fhv.sinkingshipsship.entities.Ship;
import at.fhv.sinkingshipsship.services.ShipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ShipDTO> findShipsByGameId(@PathVariable Long gameId) {
        List<Ship> ships = shipService.findShipsByGameId(gameId);
        return ships.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ShipDTO convertToDTO(Ship ship) {
        return new ShipDTO(ship.getId(),
                ship.getPlayerId(),
                ship.getGameId(),
                ship.getShipXCoordinate(),
                ship.getShipYCoordinate(),
                ship.isHit());
    }
}
