package pl.bernatd.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravellerDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String address;
    private String phone_number;
    private String email;
}
