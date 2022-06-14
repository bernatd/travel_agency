package pl.bernatd.travel_agency.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TravellerNotFoundException.class)
    public ResponseEntity<Object> handleTravellerNotFoundException(TravellerNotFoundException exception) {
        return new ResponseEntity<>("Traveller with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsuranceNotFoundException.class)
    public ResponseEntity<Object> handleInsuranceNotFoundException(InsuranceNotFoundException exception) {
        return new ResponseEntity<>("Insurance with gicen id does not exist", HttpStatus.BAD_REQUEST);
    }
}
