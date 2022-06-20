package pl.bernatd.travel_agency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.travel_agency.dto.HotelsApiDto;
import pl.bernatd.travel_agency.service.HotelService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/hotelsapi")
@RequiredArgsConstructor
public class HotelsApiController {

    private final HotelService service;

    @GetMapping(value = "{location}")
    public ResponseEntity<List<HotelsApiDto>> getHotels(@PathVariable String location) {
        return ResponseEntity.ok(service.fetchHotels(location, "us_Us", "USD"));
    }
}
