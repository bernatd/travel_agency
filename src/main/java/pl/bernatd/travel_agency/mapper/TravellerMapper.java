package pl.bernatd.travel_agency.mapper;

import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Traveller;
import pl.bernatd.travel_agency.dto.TravellerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                traveller.getReservation().getId(),
                traveller.getFirstName(),
                traveller.getLastName(),
                traveller.getAddress(),
                traveller.getPhone_number(),
                traveller.getEmail());
    }

    public List<TravellerDto> mapToTravellerDtoList(final List<Traveller> travellers) {
        if (travellers.isEmpty()) {
            return new ArrayList<>();
        } else {
            return travellers.stream()
                    .map(this::mapToTravellerDto)
                    .collect(Collectors.toList());
        }
    }

    public List<Traveller> mapToTravellerList(final List<TravellerDto> travellerDtoList) {
        if (travellerDtoList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return travellerDtoList.stream()
                    .map(this::mapToTraveller)
                    .collect(Collectors.toList());
        }
    }
}
