package pl.bernatd.travel_agency.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bernatd.travel_agency.domain.Insurance;

import java.util.List;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
    List<Insurance> findAll();
}
