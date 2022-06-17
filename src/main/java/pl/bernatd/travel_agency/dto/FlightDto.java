package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private Long id;
    private String code;
    private String airline;
    private String origin;
    private String destination;
    private String category;
}
