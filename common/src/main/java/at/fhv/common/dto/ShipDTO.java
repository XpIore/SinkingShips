package at.fhv.common.dto;

public record ShipDTO(Long playerId,
                      Long gameId,
                      Integer shipXCoordinate,
                      Integer shipYCoordinate,
                      boolean hit) {

}
