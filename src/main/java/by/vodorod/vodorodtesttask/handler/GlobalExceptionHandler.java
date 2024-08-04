package by.vodorod.vodorodtesttask.handler;

import by.vodorod.vodorodtesttask.exception.DomainNotFoundException;
import by.vodorod.vodorodtesttask.response.ExceptionResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleException(ConstraintViolationException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                        ExceptionResponse
                                .builder()
                                .errorDescription("Duplicate values")
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(DomainNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(DomainNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ExceptionResponse
                                .builder()
                                .errorDescription("Entity not found")
                                .error(e.getLocalizedMessage())
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ExceptionResponse
                                .builder()
                                .errorDescription("Internal server error")
                                .error(e.getLocalizedMessage())
                                .build()
                );
    }
}
