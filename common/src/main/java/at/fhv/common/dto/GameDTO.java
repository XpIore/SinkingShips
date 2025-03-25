package at.fhv.common.dto;

public record GameDTO(Long playerOneId,
                      Long playerTwoId,
                      String map) {
}
