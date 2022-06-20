package pl.bernatd.travel_agency.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.bernatd.travel_agency.domain.Flight;
import pl.bernatd.travel_agency.exceptions.FlightNotFoundException;
import pl.bernatd.travel_agency.repository.FlightRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbFlightServiceTest {

    @InjectMocks
    private DbFlightService service;

    @Mock
    private FlightRepository repository;

    @Test
    void testGetAllFlights() {
        //Given
        when(repository.findAll()).thenReturn(List.of());
        //When
        List<Flight> flights = service.getAllFlights();
        //Then
        assertThat(flights).isNotNull();
        assertThat(flights.size()).isEqualTo(0);
    }

    @Test
    void testSaveFlight() {
        //Given
        Flight flight = new Flight(1L, "KL001", "KLM", "Amsterdam", "Warsaw",
                "Economy", new BigDecimal(3000));
        Flight savedFlight = new Flight(1L, "KL001", "KLM", "Amsterdam", "Warsaw",
                "Economy", new BigDecimal(3000));
        when(repository.save(flight)).thenReturn(savedFlight);
        //when
        Flight result = service.saveFlight(flight);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
        assertEquals("KL001", result.getCode());
        assertEquals("Economy", result.getCategory());
    }

    @Test
    void testGetFlight() throws FlightNotFoundException {
        //Given
        Flight flight = new Flight(1L, "KL001", "KLM", "Amsterdam", "Warsaw",
                "Economy", new BigDecimal(3000));
        when(repository.findById(1L)).thenReturn(Optional.of(flight));
        //When
        Flight result = service.getFlight(1L);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
        assertEquals("Warsaw", result.getDestination());
    }
}
