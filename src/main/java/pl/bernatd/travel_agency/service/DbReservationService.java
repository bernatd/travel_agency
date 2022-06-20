package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Reservation;
import pl.bernatd.travel_agency.exceptions.ReservationNotFoundException;
import pl.bernatd.travel_agency.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Reservation saveReservation(final Reservation reservation) {
        return repository.save(reservation);
    }

    public Reservation getReservation(final Long id) throws ReservationNotFoundException {
        return repository.findById(id).orElseThrow(ReservationNotFoundException::new);
    }

    public void deleteReservation(final Long id) {
        repository.deleteById(id);
    }
}
