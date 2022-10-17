package self.izouir.modsentesttask.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandlingAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundException> handleEntityNotFoundException(final EntityNotFoundException e) {
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<EntityExistsException> handleEntityExistsException(final EntityExistsException e) {
        return new ResponseEntity<>(e, HttpStatus.FOUND);
    }
}
