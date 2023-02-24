package it.unimol.gelid.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<String> handleElementNotFoundException(ElementNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(ElementAlreadyExistException.class)
    public ResponseEntity<String> handleElementAlreadyExistException(ElementAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage() + "already exist");
    }

}
