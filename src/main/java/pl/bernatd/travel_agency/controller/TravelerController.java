package pl.bernatd.travel_agency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/traveller")
public class TravelerController {

    @GetMapping
    public ResponseEntity<List<String>> getAllTravellers() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<String> getTraveller(@PathVariable Long id) {
        return ResponseEntity.ok("Traveller" + id);
    }

    @PostMapping
    public ResponseEntity<Void> addUser() {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateTraveller(@PathVariable Long id) {
        return ResponseEntity.ok("traveller's data with " + id + "have been updated");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteTraveller(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
