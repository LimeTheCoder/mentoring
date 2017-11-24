package com.limethecoder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
