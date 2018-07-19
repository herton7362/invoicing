package com.herton.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

abstract class BusinessException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 6807228021289834441L;
    private static final Logger LOG = LoggerFactory.getLogger(BusinessException.class);
    private BusinessException() {}
    BusinessException(String message) {
        super(message);
        LOG.warn(message);
    }

    public abstract HttpStatus getStatus();
}
