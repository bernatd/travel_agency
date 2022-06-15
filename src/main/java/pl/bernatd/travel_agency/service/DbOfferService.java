package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Offer;
import pl.bernatd.travel_agency.exceptions.OfferNotFoundException;
import pl.bernatd.travel_agency.repository.OfferRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbOfferService {
    private OfferRepository repository;

    public List<Offer> getAllOffers() {
        return repository.findAll();
    }

    public Offer saveOffer(final Offer offer) {
        return repository.save(offer);
    }

    public Offer getOffer(final Long id) throws OfferNotFoundException {
        return repository.findById(id).orElseThrow(OfferNotFoundException::new);
    }

    public void deleteOffer(final Long id) {
        repository.deleteById(id);
    }
}
