package com.herton.module.auth.web;

import com.herton.common.AbstractReadController;
import com.herton.common.CrudService;
import com.herton.module.auth.domain.OauthClientDetails;
import com.herton.module.auth.service.OauthClientDetailsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "游客应用客户端管理接口，无权限过滤")
@RestController
@RequestMapping("/oauthClient")
public class GuestOauthClientDetailsController extends AbstractReadController<OauthClientDetails> {
    private final OauthClientDetailsService oauthClientDetailsService;
    @Override
    protected CrudService<OauthClientDetails> getService() {
        return oauthClientDetailsService;
    }

    @Autowired
    public GuestOauthClientDetailsController(OauthClientDetailsService oauthClientDetailsService) {
        this.oauthClientDetailsService = oauthClientDetailsService;
    }
}
