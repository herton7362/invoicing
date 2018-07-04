package com.herton.module.auth.service;

import com.herton.common.CrudService;
import com.herton.module.auth.domain.OauthClientDetails;
import com.herton.module.auth.dto.OauthClientDetailsDTO;

public interface OauthClientDetailsService extends CrudService<OauthClientDetails, OauthClientDetailsDTO> {
    OauthClientDetails findOneByClientId(String clientId) throws Exception;
}
