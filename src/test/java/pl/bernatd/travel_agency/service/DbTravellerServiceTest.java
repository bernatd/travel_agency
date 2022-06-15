package pl.bernatd.travel_agency.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.bernatd.travel_agency.domain.Traveller;
import pl.bernatd.travel_agency.exceptions.TravellerNotFoundException;
import pl.bernatd.travel_agency.repository.TravellerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbTravellerServiceTest {

    @InjectMocks
    private DbTravellerService service;

    @Mock
    private TravellerRepository repository;

    @Test
    void testGetAllTravellers() {
        //Given
        when(repository.findAll()).thenReturn(List.of());
        //When
        List<Traveller> travellers = service.getAllTravellers();
        //Then
        assertThat(travellers).isNotNull();
        assertThat(travellers.size()).isEqualTo(0);
    }

    @Test
    void testSaveTraveller() {
        //Given
        Traveller traveller = new Traveller(1L, "first_name", "last_name",
                "addres", "phone", "email");
        Traveller savedTraveller = new Traveller(1L, "first_name", "last_name",
                "addres", "phone", "email");
        when(repository.save(traveller)).thenReturn(savedTraveller);
        //When
        Traveller result = service.saveTraveller(traveller);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
        assertEquals("first_name", result.getFirstName());
        assertEquals("last_name", result.getLastName());
        assertEquals("phone", result.getPhone_number());
    }

    @Test
    void testGetTraveller() throws TravellerNotFoundException {
        //Given
        Traveller traveller = new Traveller(1L, "first_name", "last_name",
                "address", "phone", "email");
        when(repository.findById(1L)).thenReturn(Optional.of(traveller));
        //When
        Traveller result = service.getTraveller(1L);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
    }
}
