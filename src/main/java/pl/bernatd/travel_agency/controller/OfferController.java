package pl.bernatd.travel_agency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/offer")
public class OfferController {

    @GetMapping
    public ResponseEntity<List<String>> getAllOffers() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<String> getOffer(@PathVariable Long id) {
        return ResponseEntity.ok("Offer #" + id);
    }

    @PostMapping
    public ResponseEntity<Void> addOffer() {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateOffer(@PathVariable Long id) {
        return ResponseEntity.ok("Offer #" + id + " updated");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
