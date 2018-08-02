package com.herton.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class UnauthorizedException extends RuntimeException implements Serializable {
    private UnauthorizedException() {}
    public UnauthorizedException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
