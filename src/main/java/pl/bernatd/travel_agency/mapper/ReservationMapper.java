package pl.bernatd.travel_agency.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Reservation;
import pl.bernatd.travel_agency.dto.ReservationDto;
import pl.bernatd.travel_agency.service.DbTravellerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationMapper {
    @Autowired
    private TravellerMapper mapper;

    public Reservation mapToReservation(final ReservationDto reservationDto) {
        return new Reservation(reservationDto.getId(),
                mapper.mapToTravellerList(reservationDto.getTravellers()),
                reservationDto.getPrice(),
                reservationDto.getCreated(),
                reservationDto.is_paid());
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return new ReservationDto(reservation.getId(),
                reservation.getOffer().getId(),
                mapper.mapToTravellerDtoList(reservation.getTravellers()),
                reservation.getPrice(),
                reservation.getCreated(),
                reservation.is_paid());
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservations) {
        if (reservations.isEmpty()) {
            return new ArrayList<>();
        } else {
            return reservations.stream()
                    .map(this::mapToReservationDto)
                    .collect(Collectors.toList());
        }
    }
}
