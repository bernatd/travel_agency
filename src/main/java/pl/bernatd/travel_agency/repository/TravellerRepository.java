package pl.bernatd.travel_agency.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bernatd.travel_agency.domain.Traveller;

import java.util.List;

@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Long> {
    List<Traveller> findAll();
//    Traveller save(Traveller traveller);
}
