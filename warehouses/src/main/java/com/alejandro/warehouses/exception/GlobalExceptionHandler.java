package com.alejandro.warehouses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ErroDetails> resourceNotFoundException(ResourceNotFoundException exception){
      ErroDetails error = new ErroDetails(exception.getMessage());

      return new ResponseEntity<ErroDetails>(error, HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<?> globalExceptionHandler(Exception exception){
      ErroDetails error = new ErroDetails(exception.getMessage());

      return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
