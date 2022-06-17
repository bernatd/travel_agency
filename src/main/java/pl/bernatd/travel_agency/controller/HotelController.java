package pl.bernatd.travel_agency.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.travel_agency.domain.Hotel;
import pl.bernatd.travel_agency.dto.HotelDto;
import pl.bernatd.travel_agency.exceptions.HotelNotFoundException;
import pl.bernatd.travel_agency.mapper.HotelMapper;
import pl.bernatd.travel_agency.service.DbHotelService;

import java.util.List;

@RestController
@RequestMapping("/v1/hotel")
public class HotelController {
    private DbHotelService service;
    private HotelMapper mapper;

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        List<Hotel> hotelDtoList = service.getAllHotelList();
        return ResponseEntity.ok(mapper.mapToHotelDtoList(hotelDtoList));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable Long id) throws HotelNotFoundException {
        return ResponseEntity.ok(mapper.mapToHotelDto(service.getHotel(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addHotel(@RequestBody HotelDto hotelDto) {
        Hotel hotel = mapper.mapToHotel(hotelDto);
        service.saveHotel(hotel);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<HotelDto> updateHotel(@RequestBody HotelDto hotelDto) {
        Hotel hotel = mapper.mapToHotel(hotelDto);
        Hotel updatedHotel = service.saveHotel(hotel);
        return ResponseEntity.ok(mapper.mapToHotelDto(updatedHotel));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        service.deleteHotel(id);
        return ResponseEntity.ok().build();
    }
}
