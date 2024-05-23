package com.good.food.adapter.inbound.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.good.food.domain.exceptions.BussinessValidationException;
import com.good.food.domain.exceptions.NotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public HttpEntity<Object> handleNotFoundException(final NotFoundException ex){
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(ex.getMessage(), httpHeaders, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(IllegalArgumentException.class)
  public HttpEntity<Object> handleIllegalArgumentException(final IllegalArgumentException ex){
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(ex.getMessage(), httpHeaders, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(BussinessValidationException.class)
  public HttpEntity<Object> handleIllegalArgumentException(final BussinessValidationException ex){
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(ex.getMessage(), httpHeaders, HttpStatus.BAD_REQUEST );
  }  
  
}
