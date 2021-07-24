package com.example.soomgo.exception;

import com.example.soomgo.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(SoomgoException.class)
  public ResponseEntity<Object> handleConflict(SoomgoException ex, WebRequest request) {
    log.error(ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder().errorMessage(ex.getMessage()).build());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
    log.error(ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder().errorMessage(ex.getMessage()).build());
  }
}
