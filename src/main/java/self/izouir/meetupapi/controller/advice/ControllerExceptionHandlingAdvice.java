package self.izouir.meetupapi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import self.izouir.meetupapi.dto.ErrorDto;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;

@RestControllerAdvice
public class ControllerExceptionHandlingAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleEntityNotFoundException(final EntityNotFoundException e) {
        return new ErrorDto(HttpStatus.NOT_FOUND.value(), e.getMessage(), new Timestamp(System.currentTimeMillis()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleIllegalArgumentException(final IllegalArgumentException e) {
        return new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage(), new Timestamp(System.currentTimeMillis()));
    }
}
