package pl.bernatd.travel_agency.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.travel_agency.domain.Traveller;
import pl.bernatd.travel_agency.dto.TravellerDto;
import pl.bernatd.travel_agency.exceptions.TravellerNotFoundException;
import pl.bernatd.travel_agency.mapper.TravellerMapper;
import pl.bernatd.travel_agency.service.DbTravellerService;

import java.util.List;

@RestController
@RequestMapping("/v1/traveller")
public class TravelerController {
    private DbTravellerService service;
    private TravellerMapper mapper;

    @GetMapping
    public ResponseEntity<List<TravellerDto>> getAllTravellers() {
        List<Traveller> travellers = service.getAllTravellers();
        return ResponseEntity.ok(mapper.mapToTravellerDtoList(travellers));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TravellerDto> getTraveller(@PathVariable Long id) throws TravellerNotFoundException {
        return ResponseEntity.ok(mapper.mapToTravellerDto(service.getTraveller(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addTraveller(@RequestBody TravellerDto travellerDto) {
        Traveller traveller = mapper.mapToTraveller(travellerDto);
        service.saveTraveller(traveller);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TravellerDto> updateTraveller(@RequestBody TravellerDto travellerDto) {
        Traveller traveller = mapper.mapToTraveller(travellerDto);
        Traveller updatedTraveller = service.saveTraveller(traveller);
        return ResponseEntity.ok(mapper.mapToTravellerDto(updatedTraveller));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteTraveller(@PathVariable Long id) {
        service.deleteTraveller(id);
        return ResponseEntity.ok().build();
    }
}
