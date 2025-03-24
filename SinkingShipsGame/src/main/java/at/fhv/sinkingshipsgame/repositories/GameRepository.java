package at.fhv.sinkingshipsgame.repositories;

import at.fhv.sinkingshipsgame.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
