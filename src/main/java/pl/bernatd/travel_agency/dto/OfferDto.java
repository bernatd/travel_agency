package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private Long id;
    private String place;
    private String description;
    private double price;
    private LocalDate start_date;
    private LocalDate end_date;
}
