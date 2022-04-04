package com.org.serai.order.restadvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomServieException.class})
    public ResponseEntity<ErrorDetails> handleOrderNotFoundException(CustomServieException orderNotFoundException) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), orderNotFoundException.getMessage(), "Not Found");
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDetails> handleGlobalException(CustomServieException e) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), "Invalid Request");
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleUserException(UsernameNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), "Invalid User");
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

   /* @Override
    public ResponseEntity<Object> handleNoHandlerFoundException(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Invalid endpoint", "Invalid Request");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/


}
