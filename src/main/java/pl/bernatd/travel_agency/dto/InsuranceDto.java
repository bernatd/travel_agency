package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {
    private Long id;
    private String type;
    private String description;
}
