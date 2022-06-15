package pl.bernatd.travel_agency.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.travel_agency.domain.Offer;
import pl.bernatd.travel_agency.dto.OfferDto;
import pl.bernatd.travel_agency.exceptions.OfferNotFoundException;
import pl.bernatd.travel_agency.mapper.OfferMapper;
import pl.bernatd.travel_agency.service.DbOfferService;

import java.util.List;

@RestController
@RequestMapping("/v1/offer")
public class OfferController {
    private DbOfferService service;
    private OfferMapper mapper;

    @GetMapping
    public ResponseEntity<List<OfferDto>> getAllOffers() {
        List<Offer> offers = service.getAllOffers();
        return ResponseEntity.ok(mapper.mapToOfferDtoList(offers));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OfferDto> getOffer(@PathVariable Long id) throws OfferNotFoundException {
        return ResponseEntity.ok(mapper.mapToOfferDto(service.getOffer(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addOffer(@RequestBody OfferDto offerDto) {
        Offer offer = mapper.mapToOffer(offerDto);
        service.saveOffer(offer);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<OfferDto> updateOffer(@RequestBody OfferDto offerDto) {
        Offer offer = mapper.mapToOffer(offerDto);
        Offer updatedOffer = service.saveOffer(offer);
        return ResponseEntity.ok(mapper.mapToOfferDto(updatedOffer));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        service.deleteOffer(id);
        return ResponseEntity.ok().build();
    }
}
