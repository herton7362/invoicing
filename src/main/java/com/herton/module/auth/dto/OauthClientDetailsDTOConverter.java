package com.herton.module.auth.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.auth.domain.OauthClientDetails;
import org.springframework.stereotype.Component;

@Component
public class OauthClientDetailsDTOConverter extends SimpleDTOConverter<OauthClientDetailsDTO, OauthClientDetails> {
}
