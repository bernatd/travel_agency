package pl.bernatd.travel_agency.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bernatd.travel_agency.domain.Flight;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findAll();
}
