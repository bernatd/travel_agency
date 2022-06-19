package pl.bernatd.travel_agency.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.bernatd.travel_agency.domain.Insurance;
import pl.bernatd.travel_agency.exceptions.InsuranceNotFoundException;
import pl.bernatd.travel_agency.repository.InsuranceRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbInsuranceServiceTest {

    @InjectMocks
    private DbInsuranceService service;

    @Mock
    private InsuranceRepository repository;

    @Test
    void testGetAllInsurances() {
        //Given
        when(repository.findAll()).thenReturn(List.of());
        //When
        List<Insurance> insuranceList = service.getAllInsuranceList();
        //Then
        assertThat(insuranceList).isNotNull();
        assertThat(insuranceList.size()).isEqualTo(0);
    }

    @Test
    void testSaveInsurance() {
        //Given
        Insurance insurance = new Insurance(1L, "type", "description", new BigDecimal(55));
        Insurance savedInsurance = new Insurance(1L, "type", "description", new BigDecimal(55));
        when(repository.save(insurance)).thenReturn(savedInsurance);
        //When
        Insurance result = service.saveInsurance(insurance);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
        assertEquals("type", result.getType());
        assertEquals("description", result.getDescription());
    }

    @Test
    void testGetInsurance() throws InsuranceNotFoundException {
        //Given
        Insurance insurance = new Insurance(1L, "type", "description", new BigDecimal(55));
        when(repository.findById(1L)).thenReturn(Optional.of(insurance));
        //When
        Insurance result = service.getInsurance(1L);
        //Then
        assertThat(result).isNotNull();
        assertEquals(1L, result.getId());
    }
}
