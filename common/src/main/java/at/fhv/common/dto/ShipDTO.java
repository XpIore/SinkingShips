package at.fhv.common.dto;

public record ShipDTO(Long id,
                      Long playerId,
                      Long gameId,
                      Integer shipXCoordinate,
                      Integer shipYCoordinate,
                      boolean hit) {

}
