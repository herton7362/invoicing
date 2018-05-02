package com.herton.common;

import com.herton.entity.BaseUser;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.auth.UserThread;
import com.herton.module.auth.domain.Admin;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 提供登录注册等服务
 */
public abstract class AbstractLoginController {
    private final AbstractLoginService loginService;
    /**
     * 发送短信验证码
     */
    @ApiOperation(value="发送短信验证码")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    public ResponseEntity<?> sendVerifyCode(@RequestParam(value = "mobile") String mobile) throws Exception {
        loginService.sendVerifyCode(mobile);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 根据手机号获取用户
     */
    @ApiOperation(value="根据手机号获取用户")
    @RequestMapping(value = "/user/mobile/{mobile}", method = RequestMethod.GET)
    public ResponseEntity<BaseUser> findUserByMobile(@PathVariable(value = "mobile") String mobile) throws Exception {
        return new ResponseEntity<>(loginService.findUserByMobile(mobile), HttpStatus.OK);
    }

    /**
     * 修改密码
     */
    @ApiOperation(value="修改密码")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "repassword", value = "确认密码", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/editPwd", method = RequestMethod.POST)
    public ResponseEntity<?> editPwd(
            @RequestParam(value = "mobile") String mobile,
            @RequestParam(value = "code") String code,
            @RequestParam(value = "password") String password
    ) throws Exception {
        loginService.editPwd(mobile, code, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 刷新token
     */
    @ApiOperation(value="刷新token")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "appId", value = "app_id", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "appSecret", value = "app_secret", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "refreshToken", value = "refresh_token", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/refresh/token", method = RequestMethod.GET)
    public ResponseEntity<TokenResult> refreshToken(
            @RequestHeader(value = "appId") String appId,
            @RequestHeader(value = "refreshToken") String refreshToken
    ) throws Exception {
        TokenResult tokenResult = new TokenResult();
        try {
            ResponseEntity<OAuth2AccessToken> responseEntity = loginService.refreshToken(appId, refreshToken);
            OAuth2AccessToken oAuth2AccessToken = responseEntity.getBody();
            tokenResult.setStatus(TokenResult.Status.ok);
            tokenResult.setAccessToken(oAuth2AccessToken.getValue());
            tokenResult.setRefreshToken(oAuth2AccessToken.getRefreshToken().getValue());
            tokenResult.setExpiresIn(oAuth2AccessToken.getExpiresIn());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidParamException(e.getMessage());
        }
        return new ResponseEntity<>(tokenResult, HttpStatus.OK);
    }

    /**
     * 登录
     */
    @ApiOperation(value="登录")
    @RequestMapping(value = "/admin/login", method = {RequestMethod.POST})
    public ResponseEntity<TokenResult> login(@RequestBody LoginParam loginParam) throws Exception {
        TokenResult tokenResult = new TokenResult();
        tokenResult.setType(loginParam.getType());
        try {
            ResponseEntity<OAuth2AccessToken> loginEntity = loginService.login(loginParam.getUsername(), loginParam.getPassword());
            OAuth2AccessToken oAuth2AccessToken = loginEntity.getBody();
            tokenResult.setStatus(TokenResult.Status.ok);
            tokenResult.setAccessToken(oAuth2AccessToken.getValue());
            tokenResult.setRefreshToken(oAuth2AccessToken.getRefreshToken().getValue());
            tokenResult.setExpiresIn(oAuth2AccessToken.getExpiresIn());
        } catch (Exception e) {
            tokenResult.setStatus(TokenResult.Status.error);
        }
        return new ResponseEntity<>(tokenResult, HttpStatus.OK);
    }

    /**
     * 注册
     */
    @ApiOperation(value="注册")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(
            @RequestParam(value = "mobile") String mobile,
            @RequestParam(value = "code") String code,
            @RequestParam(value = "password") String password
    ) throws Exception {
        loginService.register(mobile, code, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 验证码校验
     */
    @ApiOperation(value="验证码校验")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/verify/verifyCode", method = RequestMethod.GET)
    public ResponseEntity<Boolean> verifyVerifyCode(
            @RequestParam(value = "mobile") String mobile,
            @RequestParam(value = "code") String code
    ) throws Exception {
        return new ResponseEntity<>(loginService.verifyVerifyCode(mobile, code), HttpStatus.OK);
    }

    /**
     * 查询登录用户
     */
    @Deprecated
    @ApiOperation(value="查询登录用户")
    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public ResponseEntity<BaseUser> getOne() throws Exception {
        BaseUser user = UserThread.getInstance().get();
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 查询登录用户
     */
    @ApiOperation(value="查询登录用户")
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public ResponseEntity<BaseUser> currentUser() throws Exception {
        BaseUser user = UserThread.getInstance().get();
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiModel(value = "登录参数")
    public static class LoginParam {
        @ApiModelProperty(required = true, value = "账号")
        private String username;
        @ApiModelProperty(required = true, value = "密码")
        private String password;
        @ApiModelProperty(required = true, value = "登录方式 (account, mobile)")
        private String type;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @ApiModel(value = "登录结果")
    public static class TokenResult {
        @ApiModelProperty(value = "状态（ok，error）")
        @Enumerated(EnumType.STRING)
        private Status status;
        private String accessToken;
        private String refreshToken;
        private Integer expiresIn;
        @ApiModelProperty(required = true, value = "登录方式 (account, mobile)")
        private String type;

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public enum Status {
            ok,
            error
        }
    }

    public AbstractLoginController(AbstractLoginService loginService) {
        this.loginService = loginService;
    }
}
