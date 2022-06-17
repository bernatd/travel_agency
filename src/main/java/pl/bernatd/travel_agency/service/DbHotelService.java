package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Hotel;
import pl.bernatd.travel_agency.exceptions.HotelNotFoundException;
import pl.bernatd.travel_agency.repository.HotelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbHotelService {
    private HotelRepository repository;

    public List<Hotel> getAllHotelList() {
        return repository.findAll();
    }

    public Hotel saveHotel(final Hotel hotel) {
        return repository.save(hotel);
    }

    public Hotel getHotel(final Long id) throws HotelNotFoundException {
        return repository.findById(id).orElseThrow(HotelNotFoundException::new);
    }

    public void deleteHotel(final Long id) {
        repository.deleteById(id);
    }
}
