package com.herton.module.auth.service;

import com.herton.common.CrudService;
import com.herton.module.auth.domain.OauthClientDetails;

public interface OauthClientDetailsService extends CrudService<OauthClientDetails> {
    OauthClientDetails findOneByClientId(String clientId) throws Exception;
}
