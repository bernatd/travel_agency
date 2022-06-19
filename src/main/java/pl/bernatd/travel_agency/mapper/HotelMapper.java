package pl.bernatd.travel_agency.mapper;

import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Hotel;
import pl.bernatd.travel_agency.dto.HotelDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelMapper {
    public Hotel mapToHotel(final HotelDto hotelDto) {
        return new Hotel(hotelDto.getId(),
                hotelDto.getCity(),
                hotelDto.getCountry(),
                hotelDto.getStandard(),
                hotelDto.getPrice());
    }

    public HotelDto mapToHotelDto(final Hotel hotel) {
        return new HotelDto(hotel.getId(),
                hotel.getOffer().getId(),
                hotel.getCity(),
                hotel.getCountry(),
                hotel.getStandard(),
                hotel.getPrice());
    }

    public List<HotelDto> mapToHotelDtoList (List<Hotel> hotels) {
        List<HotelDto> hotelDtos = new ArrayList<>();
        for (Hotel hotel : hotels) {
            hotelDtos.add(new HotelDto(hotel.getId(),
                    hotel.getOffer().getId(),
                    hotel.getCity(),
                    hotel.getCountry(),
                    hotel.getStandard(),
                    hotel.getPrice()));
        }
        return hotelDtos;
    }
}
