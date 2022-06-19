package pl.bernatd.travel_agency.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bernatd.travel_agency.domain.Reservation;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAll();
}
