package com.herton.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

abstract class ExceptionMessage  {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionMessage.class);

    private String message;
    private int status;
    private String error;
    private Long timestamp;

    abstract ModelAndView parse(Exception e);

    Map<String, Object> getMessage(Exception e) {
        timestamp = new Date().getTime();
        if(e instanceof BusinessException) {
            message = e.getMessage();
            status = ((BusinessException) e).getStatus().value();
            error = "Business Error";
        } else if(e instanceof InvalidParamException) {
            message = e.getMessage();
            status = ((InvalidParamException) e).getStatus().value();
            error = "Invalid Param Error";
        } else {
            message = "系统内部错误！";
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            error = "Internal Server Error";
            LOG.error("Exception throws:", e);
        }
        return toMap();
    }

    int getStatus() {
        return status;
    }

    private Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("status", status);
        result.put("error", error);
        result.put("timestamp", timestamp);
        return result;
    }
}
