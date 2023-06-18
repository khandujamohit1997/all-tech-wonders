package com.khanduja.techwonders.exceptionhandling.config;

import com.khanduja.techwonders.exceptionhandling.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage(), exception.getHttpStatus().value(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    // Handle other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
