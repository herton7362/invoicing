package com.herton.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ForbiddenException extends RuntimeException implements Serializable {
    private ForbiddenException() {}
    public ForbiddenException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
