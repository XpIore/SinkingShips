package at.fhv.sinkingshipsship.repositories;

import at.fhv.sinkingshipsship.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Integer> {
    List<Ship> findByGameId(Long gameId);
}
