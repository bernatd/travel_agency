package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Flight;
import pl.bernatd.travel_agency.exceptions.FlightNotFoundException;
import pl.bernatd.travel_agency.repository.FlightRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbFlightService {
    private FlightRepository repository;

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight saveFlight(final Flight flight) {
        return repository.save(flight);
    }

    public Flight getFlight(Long id) throws FlightNotFoundException {
        return repository.findById(id).orElseThrow(FlightNotFoundException::new);
    }

    public void deleteFlight(Long id) {
        repository.deleteById(id);
    }
}
