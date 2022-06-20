package pl.bernatd.travel_agency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.travel_agency.domain.Reservation;
import pl.bernatd.travel_agency.dto.ReservationDto;
import pl.bernatd.travel_agency.exceptions.ReservationNotFoundException;
import pl.bernatd.travel_agency.mapper.ReservationMapper;
import pl.bernatd.travel_agency.service.DbReservationService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private DbReservationService service;

    private ReservationMapper mapper;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        return ResponseEntity.ok(mapper.mapToReservationDtoList(service.getAllReservations()));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ReservationDto> getReservation(@PathVariable Long id) throws ReservationNotFoundException {
        return ResponseEntity.ok(mapper.mapToReservationDto(service.getReservation(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = mapper.mapToReservation(reservationDto);
        service.saveReservation(reservation);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ReservationDto> updateReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = mapper.mapToReservation(reservationDto);
        Reservation updatedReservation = service.saveReservation(reservation);
        return ResponseEntity.ok(mapper.mapToReservationDto(updatedReservation));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        service.deleteReservation(id);
        return ResponseEntity.ok().build();
    }
}
