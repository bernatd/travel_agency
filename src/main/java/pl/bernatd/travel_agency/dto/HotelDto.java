package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Long id;
    private Long offer_id;
    private String city;
    private String country;
    private String standard;
    private BigDecimal price;
}
