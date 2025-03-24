package at.fhv.sinkingshipsship.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SHIP")
@NoArgsConstructor
@AllArgsConstructor
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PLAYER_ID")
    private Long playerId;

    @Column(name = "GAME_ID")
    private Long gameId;

    @Column(name = "SHIP_X_COORDINATE")
    private Integer shipXCoordinate;

    @Column(name = "SHIP_Y_COORDINATE")
    private Integer shipYCoordinate;

    @Column(name = "HIT")
    private boolean hit;

    //lombok issues
    public Long getId() {
        return id;
    }
}
