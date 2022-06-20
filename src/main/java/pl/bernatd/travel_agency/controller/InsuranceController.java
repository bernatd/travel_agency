package pl.bernatd.travel_agency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.travel_agency.domain.Insurance;
import pl.bernatd.travel_agency.dto.InsuranceDto;
import pl.bernatd.travel_agency.exceptions.InsuranceNotFoundException;
import pl.bernatd.travel_agency.mapper.InsuranceMapper;
import pl.bernatd.travel_agency.service.DbInsuranceService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/v1/insurance")
@RequiredArgsConstructor
public class InsuranceController {
    private DbInsuranceService service;
    private InsuranceMapper mapper;

    @GetMapping
    public ResponseEntity<List<InsuranceDto>> getAllInsurance() {
        List<Insurance> insuranceList = service.getAllInsuranceList();
        return ResponseEntity.ok(mapper.mapToInsuranceDtoList(insuranceList));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<InsuranceDto> getInsurance(@PathVariable Long id) throws InsuranceNotFoundException {
        return ResponseEntity.ok(mapper.mapToInsuranceDto(service.getInsurance(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addInsurance(@RequestBody InsuranceDto insuranceDto) {
        Insurance insurance = mapper.mapToInsurance(insuranceDto);
        service.saveInsurance(insurance);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<InsuranceDto> updateInsurance(@PathVariable InsuranceDto insuranceDto) {
        Insurance insurance = mapper.mapToInsurance(insuranceDto);
        Insurance updatedInsurance = service.saveInsurance(insurance);
        return ResponseEntity.ok(mapper.mapToInsuranceDto(updatedInsurance));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable Long id) {
        service.deleteInsurance(id);
        return ResponseEntity.ok().build();
    }
}
