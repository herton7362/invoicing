package com.herton.module.auth.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.auth.domain.OauthClientDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class OauthClientDetailsDTO extends BaseDTO<OauthClientDetails> {
    private String name;
    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoapprove;
}
