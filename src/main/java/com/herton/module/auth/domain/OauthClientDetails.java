package com.herton.module.auth.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class OauthClientDetails extends BaseEntity {
    @Column(length = 50)
    private String name;
    @Column(length = 128, unique = true)
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
