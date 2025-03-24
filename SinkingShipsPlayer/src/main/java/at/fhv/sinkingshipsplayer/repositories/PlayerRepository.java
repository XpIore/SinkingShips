package at.fhv.sinkingshipsplayer.repositories;

import at.fhv.sinkingshipsplayer.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
