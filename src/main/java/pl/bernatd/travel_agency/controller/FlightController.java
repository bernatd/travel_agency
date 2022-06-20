package pl.bernatd.travel_agency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.travel_agency.domain.Flight;
import pl.bernatd.travel_agency.dto.FlightDto;
import pl.bernatd.travel_agency.exceptions.FlightNotFoundException;
import pl.bernatd.travel_agency.mapper.FlightMapper;
import pl.bernatd.travel_agency.service.DbFlightService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/v1/flight")
@RequiredArgsConstructor
public class FlightController {
    private DbFlightService service;
    private FlightMapper mapper;

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<Flight> flightDtoList = service.getAllFlights();
        return ResponseEntity.ok(mapper.mapToFlightDtoList(flightDtoList));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<FlightDto> getFlight(@PathVariable Long id) throws FlightNotFoundException {
        return ResponseEntity.ok(mapper.mapToFlightDto(service.getFlight(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFlight(@RequestBody FlightDto flightDto) {
        Flight flight = mapper.mapToFlight(flightDto);
        service.saveFlight(flight);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<FlightDto> updateFlight(@RequestBody FlightDto flightDto) {
        Flight flight = mapper.mapToFlight(flightDto);
        Flight updatedFlight = service.saveFlight(flight);
        return ResponseEntity.ok(mapper.mapToFlightDto(updatedFlight));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        service.deleteFlight(id);
        return ResponseEntity.ok().build();
    }
}
