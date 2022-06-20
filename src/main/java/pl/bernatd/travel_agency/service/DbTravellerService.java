package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Traveller;
import pl.bernatd.travel_agency.exceptions.TravellerNotFoundException;
import pl.bernatd.travel_agency.repository.TravellerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbTravellerService {
    @Autowired
    private TravellerRepository repository;

    public List<Traveller> getAllTravellers() {
        return repository.findAll();
    }

    public Traveller saveTraveller(final Traveller traveller) {
        return repository.save(traveller);
    }

    public Traveller getTraveller(final Long id) throws TravellerNotFoundException {
        return repository.findById(id).orElseThrow(TravellerNotFoundException::new);
    }

    public void deleteTraveller(final Long id) {
        repository.deleteById(id);
    }
}
