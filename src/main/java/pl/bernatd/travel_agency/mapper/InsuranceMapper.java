package pl.bernatd.travel_agency.mapper;

import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Insurance;
import pl.bernatd.travel_agency.dto.InsuranceDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceMapper {
    public Insurance mapToInsurance(final InsuranceDto insuranceDto) {
        return new Insurance(insuranceDto.getId(),
                insuranceDto.getType(),
                insuranceDto.getDescription());
    }

    public InsuranceDto mapToInsuranceDto(final Insurance insurance) {
        return new InsuranceDto(insurance.getId(),
                insurance.getType(),
                insurance.getDescription());
    }

    public List<InsuranceDto> mapToInsuranceDtoList(final List<Insurance> insuranceList) {
        List<InsuranceDto> insuranceDtoList = new ArrayList<>();
        for (Insurance insurance : insuranceList) {
            insuranceDtoList.add(new InsuranceDto(insurance.getId(),
                    insurance.getType(),
                    insurance.getDescription()));
        }
        return insuranceDtoList;
    }
}
