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
public class InvalidParamException extends BusinessException implements Serializable {
    public InvalidParamException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_ACCEPTABLE;
    }
}
