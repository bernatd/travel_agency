package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private Long id;
    private Long offer_id;
    private String code;
    private String airline;
    private String origin;
    private String destination;
    private String category;
    private BigDecimal price;
}
