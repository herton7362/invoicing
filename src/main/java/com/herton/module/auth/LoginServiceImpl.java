package com.herton.module.auth;

import com.herton.common.AbstractLoginService;
import com.herton.common.utils.StringUtils;
import com.herton.entity.BaseUser;
import com.herton.exceptions.InvalidParamException;
import com.herton.kits.Kits;
import com.herton.kits.notification.Notification;
import com.herton.module.auth.domain.OauthClientDetails;
import com.herton.module.auth.service.OauthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class LoginServiceImpl extends AbstractLoginService {
    private final Kits kits;
    private final TokenEndpoint tokenEndpoint;
    private final OauthClientDetailsService oauthClientDetailsService;

    @Override
    protected Notification getNotification() {
        return kits.notification();
    }

    @Override
    protected TokenEndpoint getTokenEndpoint() {
        return tokenEndpoint;
    }

    @Override
    public void editPwd(String mobile, String code, String password) throws Exception {
    }

    @Override
    public ResponseEntity<OAuth2AccessToken> login(String username, String password) throws Exception {
        if(StringUtils.isBlank(username)) {
            throw new InvalidParamException("请输入用户名");
        }
        if(StringUtils.isBlank(password)) {
            throw new InvalidParamException("请输入密码");
        }
        String[] usernameAndClientId = username.split("@");
        if(usernameAndClientId.length == 1) {
            throw new InvalidParamException("请使用 xxx@xxx 的方式作为用户名登录");
        }
        username = usernameAndClientId[0];
        String appId = usernameAndClientId[1];
        OauthClientDetails oauthClientDetails = oauthClientDetailsService.findOneByClientId(appId);
        if(oauthClientDetails == null) {
            throw new InvalidParamException("商户【" + appId + "】不存在");
        }
        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("client_id", appId);
        requestParameters.put("client_secret", oauthClientDetails.getClientSecret());
        requestParameters.put("grant_type", "password");
        requestParameters.put("username", username);
        requestParameters.put("password", password);
        Principal principal = new UsernamePasswordAuthenticationToken(new User(appId, oauthClientDetails.getClientSecret(), Collections.emptyList()), null, null);
        return getTokenEndpoint().postAccessToken(principal, requestParameters);
    }

    /**
     * 刷新token
     *
     * @param appId        app_id
     * @param refreshToken refresh_token
     */
    public ResponseEntity<OAuth2AccessToken> refreshToken(String appId, String refreshToken) throws Exception {
        Map<String, String> requestParameters = new HashMap<>();
        OauthClientDetails oauthClientDetails = oauthClientDetailsService.findOneByClientId(appId);
        if(oauthClientDetails == null) {
            throw new InvalidParamException("商户【" + appId + "】不存在");
        }
        requestParameters.put("client_id", appId);
        requestParameters.put("client_secret", oauthClientDetails.getClientSecret());
        requestParameters.put("grant_type", "refresh_token");
        requestParameters.put("refresh_token", refreshToken);
        Principal principal = new UsernamePasswordAuthenticationToken(new User(appId, oauthClientDetails.getClientSecret(), Collections.emptyList()), null, null);
        return getTokenEndpoint().postAccessToken(principal, requestParameters);
    }

    @Override
    public void register(String mobile, String code, String password) throws Exception {
    }

    @Override
    public BaseUser findUserByMobile(String mobile) throws Exception {
        return null;
    }

    @Autowired
    public LoginServiceImpl(
            Kits kits,
            TokenEndpoint tokenEndpoint,
            OauthClientDetailsService oauthClientDetailsService
    ) {
        this.kits = kits;
        this.tokenEndpoint = tokenEndpoint;
        this.oauthClientDetailsService = oauthClientDetailsService;
    }
}
