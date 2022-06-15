package pl.bernatd.travel_agency.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.bernatd.travel_agency.domain.Offer;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TravellerNotFoundException.class)
    public ResponseEntity<Object> handleTravellerNotFoundException(TravellerNotFoundException exception) {
        return new ResponseEntity<>("Traveller with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsuranceNotFoundException.class)
    public ResponseEntity<Object> handleInsuranceNotFoundException(InsuranceNotFoundException exception) {
        return new ResponseEntity<>("Insurance with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OfferNotFoundException.class)
    public ResponseEntity<Object> handleOfferNotFoundException(OfferNotFoundException exception) {
        return new ResponseEntity<>("Offer with given id does not exist", HttpStatus.BAD_REQUEST);
    }
}
