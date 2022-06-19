package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private Long id;
    private Long flight_id;
    private Long hotel_id;
    private Long insurance_id;
    private String place;
    private String description;
    private BigDecimal price;
    private LocalDate start_date;
    private LocalDate end_date;
}
