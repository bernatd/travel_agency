package pl.bernatd.travel_agency.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bernatd.travel_agency.domain.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
}
