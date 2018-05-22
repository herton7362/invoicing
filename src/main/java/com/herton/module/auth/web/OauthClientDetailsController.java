package com.herton.module.auth.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.auth.domain.OauthClientDetails;
import com.herton.module.auth.service.OauthClientDetailsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "应用客户端管理")
@RestController
@RequestMapping("/api/oauthClient")
public class OauthClientDetailsController extends AbstractCrudController<OauthClientDetailsService, OauthClientDetails> {
}
