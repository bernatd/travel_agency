package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Offer;
import pl.bernatd.travel_agency.exceptions.OfferNotFoundException;
import pl.bernatd.travel_agency.repository.OfferRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbOfferService {
    @Autowired
    private OfferRepository repository;
    @Autowired
    private DbHotelService hotelService;

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

    public BigDecimal getOfferPrice(final Long id) {
        Optional<Offer> offer = repository.findById(id);
        BigDecimal result = offer.get().getHotel().getPrice().add(offer.get().getFlight().getPrice() )
                .add(offer.get().getInsurance().getPrice());
        return result;
    }

    public Offer changeRoomStandard(final Long id, final String standard) throws OfferNotFoundException {
        Offer offer = repository.findById(id).orElseThrow(OfferNotFoundException::new);
        offer.getHotel().setStandard(standard);
        return repository.save(offer);
    }

    public Offer changeFlightCategory(final Long id, final String category) throws OfferNotFoundException {
        Offer offer = repository.findById(id).orElseThrow(OfferNotFoundException::new);
        offer.getFlight().setCategory(category);
        return repository.save(offer);
    }

    public Offer changeInsuranceType(final Long id, final String type) throws OfferNotFoundException {
        Offer offer = repository.findById(id).orElseThrow(OfferNotFoundException::new);
        offer.getInsurance().setType(type);
        return repository.save(offer);
    }
}
