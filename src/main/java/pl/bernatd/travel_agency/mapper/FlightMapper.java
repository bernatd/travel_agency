package pl.bernatd.travel_agency.mapper;

import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Flight;
import pl.bernatd.travel_agency.dto.FlightDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightMapper {

    public Flight mapToFlight(final FlightDto flightDto) {
        return new Flight(flightDto.getId(),
                flightDto.getCode(),
                flightDto.getAirline(),
                flightDto.getOrigin(),
                flightDto.getDestination(),
                flightDto.getCategory(),
                flightDto.getPrice());
    }

    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(flight.getId(),
                flight.getOffer().getId(),
                flight.getCode(),
                flight.getAirline(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getCategory(),
                flight.getPrice());
    }

    public List<FlightDto> mapToFlightDtoList(List<Flight> flights) {
        List<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight : flights) {
            flightDtos.add(new FlightDto(flight.getId(),
                    flight.getOffer().getId(),
                    flight.getCode(),
                    flight.getAirline(),
                    flight.getOrigin(),
                    flight.getDestination(),
                    flight.getCategory(),
                    flight.getPrice()));
        }
        return flightDtos;
    }
}
