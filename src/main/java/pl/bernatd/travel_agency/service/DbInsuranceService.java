package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Insurance;
import pl.bernatd.travel_agency.exceptions.InsuranceNotFoundException;
import pl.bernatd.travel_agency.repository.InsuranceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbInsuranceService {
    private InsuranceRepository repository;

    public List<Insurance> getAllInsuranceList() {
        return repository.findAll();
    }

    public Insurance saveInsurance(final Insurance insurance) {
        return repository.save(insurance);
    }

    public Insurance getInsurance(final Long id) throws InsuranceNotFoundException {
        return repository.findById(id).orElseThrow(InsuranceNotFoundException::new);
    }

    public void deleteInsurance(final Long id) {
        repository.deleteById(id);
    }
}
