package com.herton.config;

import com.herton.common.utils.NetworkUtils;
import com.herton.common.utils.SpringUtils;
import com.herton.common.utils.StringUtils;
import com.herton.config.CommonInterceptor;
import com.herton.entity.BaseUser;
import com.herton.module.auth.UserThread;
import com.herton.module.auth.domain.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtendedCommonInterceptor extends CommonInterceptor {
    private TokenStore tokenStore;
    @Override
    @SuppressWarnings("unchecked")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!super.preHandle(request, response, handler)) {
            return false;
        }
        return true;
    }
}
