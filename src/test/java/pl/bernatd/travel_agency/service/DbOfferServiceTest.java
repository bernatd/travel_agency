package pl.bernatd.travel_agency.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.bernatd.travel_agency.domain.Offer;
import pl.bernatd.travel_agency.exceptions.OfferNotFoundException;
import pl.bernatd.travel_agency.repository.OfferRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbOfferServiceTest {

    @InjectMocks
    private DbOfferService service;

    @Mock
    private OfferRepository repository;

    @Test
    void testGetAllOffers() {
        //Given
        when(repository.findAll()).thenReturn(List.of());
        //When
        List<Offer> offers = service.getAllOffers();
        //Then
        assertThat(offers).isNotNull();
        assertThat(offers.size()).isEqualTo(0);
    }

    @Test
    void testSaveOffer() {
        //Given
        Offer offer = new Offer(1L, "place", "description",
                LocalDate.parse("2022-06-14"), LocalDate.parse("2022-08-07"));
        Offer savedOffer = new Offer(1L, "place", "description",
                LocalDate.parse("2022-06-14"), LocalDate.parse("2022-08-07"));
        when(repository.save(offer)).thenReturn(savedOffer);
        //when
        Offer result = service.saveOffer(offer);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
        assertEquals("place", result.getPlace());
        assertEquals(LocalDate.parse("2022-08-07"), result.getEnd_date());
    }

    @Test
    void testGetOffer() throws OfferNotFoundException {
        //Given
        Offer offer = new Offer(1L, "place", "description",
                LocalDate.parse("2022-06-14"), LocalDate.parse("2022-08-07"));
        when(repository.findById(1L)).thenReturn(Optional.of(offer));
        //When
        Offer result = service.getOffer(1L);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
        assertEquals("place", result.getPlace());
    }
}
