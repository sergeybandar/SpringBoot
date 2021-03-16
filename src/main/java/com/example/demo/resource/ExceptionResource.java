package com.example.demo.resource;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.PetNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ExceptionResource extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<String> petNotFoundHandler(PetNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> orderNotFoundHandler(OrderNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundHandler(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> mapErr = new HashMap<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            mapErr.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(mapErr, HttpStatus.BAD_REQUEST);
    }
}
