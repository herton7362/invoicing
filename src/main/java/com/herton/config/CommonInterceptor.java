package com.herton.config;

import com.herton.common.utils.NetworkUtils;
import com.herton.common.utils.SpringUtils;
import com.herton.common.utils.StringUtils;
import com.herton.entity.BaseUser;
import com.herton.module.auth.UserThread;
import com.herton.module.auth.domain.AdminRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptor extends HandlerInterceptorAdapter {
    private AdminRepository adminRepository;
    private TokenStore tokenStore;
    @Override
    @SuppressWarnings("unchecked")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        adminRepository = SpringUtils.getBean(AdminRepository.class);
        tokenStore = SpringUtils.getBean(TokenStore.class);
        String authorization = request.getHeader("Authorization");
        String accessToken = null;
        if(StringUtils.isNotBlank(authorization)) {
            accessToken = authorization.split(" ")[1];
        }
        UserThread.getInstance().setAccessToken(accessToken);
        UserThread.getInstance().setIpAddress(NetworkUtils.getIpAddress(request));
        if(StringUtils.isNotBlank(accessToken)) {
            OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(accessToken);
            if(oAuth2Authentication != null) {
                Object principal = oAuth2Authentication.getPrincipal();

                if(principal instanceof User) {
                    User user = (User) principal;
                    UserThread.getInstance().setClientId(oAuth2Authentication.getOAuth2Request().getClientId());
                    BaseUser baseUser = adminRepository.findOneByLoginName(user.getUsername());
                    if(baseUser != null) {
                        baseUser.setPassword(null);
                        UserThread.getInstance().set(baseUser);
                    } else {
                        UserThread.getInstance().set(null);
                        UserThread.getInstance().setClientId(null);
                        UserThread.getInstance().setAccessToken(null);
                    }
                } else if(principal instanceof String) {
                    UserThread.getInstance().setClientId((String) principal);
                }
            } else {
                UserThread.getInstance().set(null);
                UserThread.getInstance().setClientId(null);
                UserThread.getInstance().setAccessToken(null);
            }
        } else {
            UserThread.getInstance().set(null);
            UserThread.getInstance().setClientId(null);
            UserThread.getInstance().setAccessToken(null);
        }
        return true;
    }
}
