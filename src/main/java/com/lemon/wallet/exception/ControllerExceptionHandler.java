package com.lemon.wallet.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Error> handleError(ApiException exception) {
        return ResponseEntity.status(400).body(new Error(exception.getMessage()));
    }

}
