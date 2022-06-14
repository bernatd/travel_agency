package pl.bernatd.travel_agency.mapper;

import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Traveller;
import pl.bernatd.travel_agency.dto.TravellerDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravellerMapper {

    public Traveller mapToTraveller(final TravellerDto travellerDto) {
        return new Traveller(travellerDto.getId(),
                travellerDto.getFirst_name(),
                travellerDto.getLast_name(),
                travellerDto.getAddress(),
                travellerDto.getPhone_number(),
                travellerDto.getEmail());
    }

    public TravellerDto mapToTravellerDto(final Traveller traveller) {
        return new TravellerDto(traveller.getId(),
                traveller.getFirstName(),
                traveller.getLastName(),
                traveller.getAddress(),
                traveller.getPhone_number(),
                traveller.getEmail());
    }

    public List<TravellerDto> mapToTravellerDtoList(final List<Traveller> travellers) {
        List<TravellerDto> travellerDtoList = new ArrayList<>();
        for (Traveller traveller : travellers) {
            travellerDtoList.add(new TravellerDto(
                    traveller.getId(),
                    traveller.getFirstName(),
                    traveller.getLastName(),
                    traveller.getAddress(),
                    traveller.getPhone_number(),
                    traveller.getEmail()
            ));
        }
        return travellerDtoList;
    }
}
