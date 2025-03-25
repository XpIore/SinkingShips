package at.fhv.common.dto;

public record GameDTO(Long id,
                      Long playerOneId,
                      Long playerTwoId,
                      String map) {
}
