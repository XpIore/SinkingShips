package at.fhv.sinkingshipsgame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GAME")
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="PLAYER_ONE_ID")
    private Long PlayerOneId;

    @Column(name="PLAYER_TWO_ID")
    private Long PlayerTwoId;

    @Column(name="MAP")
    private String Map;
}
