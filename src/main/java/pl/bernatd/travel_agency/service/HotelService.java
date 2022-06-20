package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.dto.HotelsApiDto;
import pl.bernatd.travel_agency.hotels.client.HotelsClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    @Autowired
    private final HotelsClient client;

    public List<HotelsApiDto> fetchHotels(String place, String locale, String currency ) {
        return client.getHotels(place, locale, currency);
    }
}
