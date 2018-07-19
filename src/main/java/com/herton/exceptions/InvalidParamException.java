package com.herton.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Base Exception
 *
 * @author tang he
 * @since 1.0.0
 */
public class InvalidParamException extends RuntimeException implements Serializable {
    private InvalidParamException() {}
    public InvalidParamException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
