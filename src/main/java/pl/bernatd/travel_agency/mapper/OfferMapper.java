package pl.bernatd.travel_agency.mapper;

import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Offer;
import pl.bernatd.travel_agency.dto.OfferDto;
import pl.bernatd.travel_agency.service.DbOfferService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferMapper {

    private DbOfferService service;

    public Offer mapToOffer(final OfferDto offerDto) {
        return new Offer(offerDto.getId(),
                offerDto.getPlace(),
                offerDto.getDescription(),
                offerDto.getStart_date(),
                offerDto.getEnd_date());
    }

    public OfferDto mapToOfferDto(final Offer offer) {
        return new OfferDto(offer.getId(),
                offer.getFlight().getId(),
                offer.getHotel().getId(),
                offer.getInsurance().getId(),
                offer.getPlace(),
                offer.getDescription(),
                service.getOfferPrice(offer.getId()),
                offer.getStart_date(),
                offer.getEnd_date());
    }

    public List<OfferDto> mapToOfferDtoList(final List<Offer> offerList) {
        List<OfferDto> offerDtoList = new ArrayList<>();
        for (Offer offer : offerList) {
            offerDtoList.add(new OfferDto(offer.getId(),
                    offer.getFlight().getId(),
                    offer.getHotel().getId(),
                    offer.getInsurance().getId(),
                    offer.getPlace(),
                    offer.getDescription(),
                    service.getOfferPrice(offer.getId()),
                    offer.getStart_date(),
                    offer.getEnd_date()));
        }
        return offerDtoList;
    }
}
