package com.herton.common;

import com.herton.entity.BaseUser;
import com.herton.exceptions.InvalidParamException;
import com.herton.kits.notification.Notification;
import com.herton.kits.notification.message.SmsVerifyCodeMessage;
import com.herton.module.auth.domain.Admin;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;

import java.security.Principal;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 提供登录、注册、找回密码、发送验证码等功能
 */
public abstract class AbstractLoginService {
    /**
     * 正则表达式：验证手机号
     */
    private static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    protected abstract Notification getNotification();

    protected abstract TokenEndpoint getTokenEndpoint();

    /**
     * 发送短信验证码
     *
     * @param mobile 手机号码
     */
    @Cacheable("verifyCode")
    public String sendVerifyCode(String mobile) throws Exception {
        if (!Pattern.matches(REGEX_MOBILE, mobile)) {
            throw new InvalidParamException(String.format("%s无效的手机号码", mobile));
        }
        BaseUser admin = new Admin();
        admin.setLoginName(mobile);
        admin.setMobile(mobile);
        String code = generateVerifyCode();
        SmsVerifyCodeMessage message = new SmsVerifyCodeMessage();
        message.setDestUser(admin);
        message.setVerifyCode(code);
        getNotification().send(message);
        return code;
    }

    /**
     * 修改密码
     *
     * @param mobile   手机号码
     * @param code     短信验证码
     * @param password 密码
     */
    public abstract void editPwd(String mobile, String code, String password) throws Exception;

    /**
     * 登录
     *
     * @param username  手机号码
     * @param password  密码
     * @return {@link OAuth2AccessToken} token
     */
    public abstract ResponseEntity<OAuth2AccessToken> login(String username, String password) throws Exception;

    /**
     * 注册
     *
     * @param mobile   手机号码
     * @param code     短信验证码
     * @param password 密码
     */
    public abstract void register(String mobile, String code, String password) throws Exception;

    /**
     * 根据手机号获取用户
     *
     * @param mobile 手机号
     * @return {@link BaseUser} 继承了此实体的用户
     */
    public abstract BaseUser findUserByMobile(String mobile) throws Exception;

    /**
     * 生成短信验证码
     *
     * @return 验证码
     */
    private String generateVerifyCode() throws Exception {
        Random r = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            code.append(r.nextInt(10));
        }
        return code.toString();
    }

    /**
     * 验证验证码是否正确
     *
     * @param mobile     手机号
     * @param verifyCode 验证码
     * @return 验证码是否正确
     */
    protected Boolean verifyVerifyCode(String mobile, String verifyCode) throws Exception {
        return verifyCode.equals(getVerifyCode(mobile));
    }

    /**
     * 根据手机号删除验证码
     *
     * @param mobile 手机号
     */
    @Cacheable("verifyCode")
    protected String getVerifyCode(String mobile) throws Exception {
        return null;
    }

    /**
     * 根据手机号删除验证码
     *
     * @param mobile 手机号
     */
    @CacheEvict("verifyCode")
    protected void clearVerifyCode(String mobile) throws Exception {
        return ;
    }

    /**
     * 刷新token
     *
     * @param appId        app_id
     * @param refreshToken refresh_token
     */
    public abstract ResponseEntity<OAuth2AccessToken> refreshToken(String appId, String refreshToken) throws Exception;

    /**
     * 获取token
     *
     * @param appId     应用id
     * @param appSecret secret
     * @return token
     */
    public ResponseEntity<OAuth2AccessToken> getAccessToken(String appId, String appSecret) throws Exception {
        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("client_id", appId);
        requestParameters.put("client_secret", appSecret);
        requestParameters.put("grant_type", "client_credentials");
        Principal principal = new UsernamePasswordAuthenticationToken(new User(appId, appSecret, Collections.emptyList()), null, null);
        return getTokenEndpoint().postAccessToken(principal, requestParameters);
    }
}

