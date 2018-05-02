package com.herton.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="commonFilter",urlPatterns="/*")
public class CommonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        setHeaders((HttpServletRequest) request, (HttpServletResponse) response);
        //执行操作后必须doFilter
        chain.doFilter(request, response);
    }

    private void setHeaders(HttpServletRequest request, HttpServletResponse response) {
        String[] whiteList = {"https://www.herton.com", "http://localhost:8000"};
        String origin = request.getHeader("origin");
        boolean isValid = false;
        for( String ip : whiteList ) {
            if( origin != null && origin.equals(ip) ){
                isValid = true;
                break;
            }
        }
        String AccessControlAllowHeaders = "Origin, Content-Type, Accept, Authorization, Access-Control-Allow-Credentials, appId, refreshToken";
        response.setHeader("Access-Control-Allow-Origin", isValid? origin: "null");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", AccessControlAllowHeaders);
    }

    @Override
    public void destroy() {

    }
}
