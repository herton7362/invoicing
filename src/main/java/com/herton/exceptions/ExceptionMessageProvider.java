package com.herton.exceptions;

import javax.servlet.http.HttpServletRequest;

class ExceptionMessageProvider {
    private ExceptionMessageProvider() {}
    static ExceptionMessage getExceptionMessage(HttpServletRequest request) {
        return new RestExceptionMessage();
    }
    private static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }
}
