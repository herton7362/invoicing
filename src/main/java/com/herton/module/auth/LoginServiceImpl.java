package com.herton.module.auth;

import com.herton.common.AbstractLoginService;
import com.herton.entity.BaseUser;
import com.herton.exceptions.BusinessException;
import com.herton.kits.Kits;
import com.herton.kits.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class LoginServiceImpl extends AbstractLoginService {
    private final Kits kits;
    private final TokenEndpoint tokenEndpoint;

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
    public void register(String mobile, String code, String password) throws Exception {
    }

    @Override
    public BaseUser findUserByMobile(String mobile) throws Exception {
        return null;
    }

    @Autowired
    public LoginServiceImpl(
            Kits kits,
            TokenEndpoint tokenEndpoint
    ) {
        this.kits = kits;
        this.tokenEndpoint = tokenEndpoint;
    }
}
