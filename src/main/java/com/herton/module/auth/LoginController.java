package com.herton.module.auth;

import com.herton.common.AbstractLoginController;
import com.herton.common.AbstractLoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Api("登录相关")
@RestController
public class LoginController extends AbstractLoginController {
    @Autowired
    public LoginController(AbstractLoginService loginService) {
        super(loginService);
    }
}
