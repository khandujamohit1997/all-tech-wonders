package com.khanduja.techwonders.exceptionhandling.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
