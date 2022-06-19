package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {
    private Long id;
    private Long offer_id;
    private String type;
    private String description;
    private BigDecimal price;
}
