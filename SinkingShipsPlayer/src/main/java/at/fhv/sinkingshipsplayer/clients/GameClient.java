package at.fhv.sinkingshipsplayer.clients;

import at.fhv.common.dto.GameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "SinkingShipsGame")
public interface GameClient {

    @PostMapping("/game/create")
    String createGame();

    @PostMapping("/game/addPlayers")
    GameDTO addPlayers(@RequestParam Long gameId,
                       @RequestParam Long playerOneId,
                       @RequestParam Long playerTwoId);

    @PostMapping("/game/updateMap")
    GameDTO updateMap(@RequestParam Long gameId,
                      @RequestParam String map);

    @GetMapping("/game/getOne")
    GameDTO getOneGame(@RequestParam Long gameId);

    @GetMapping("/game/getAll")
    List<GameDTO> getAllGames();

}
