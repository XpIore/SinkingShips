package at.fhv.sinkingshipsplayer.clients;

import at.fhv.common.dto.ShipDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "SinkingShipsShip")
public interface ShipClient {

    @PostMapping("/ship/create")
    String createShip(@RequestParam Long gameId,
                      @RequestParam Long playerId,
                      @RequestParam Integer shipXCoordinate,
                      @RequestParam Integer shipYCoordinate);

    @GetMapping("/ship/findByGameId/{gameId}")
    List<ShipDTO> findShipsByGameId(@PathVariable Long gameId);
}
