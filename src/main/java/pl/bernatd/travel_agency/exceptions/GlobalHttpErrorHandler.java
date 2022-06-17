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
        return new ResponseEntity<>("Insurance with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OfferNotFoundException.class)
    public ResponseEntity<Object> handleOfferNotFoundException(OfferNotFoundException exception) {
        return new ResponseEntity<>("Offer with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException exception) {
        return new ResponseEntity<>("Hotel with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<Object> handleFlightNotFoundException(FlightNotFoundException exception) {
        return new ResponseEntity<>("Flight with given id does not exist", HttpStatus.BAD_REQUEST);
    }
}
