package com.herton.module.basicdata.member.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.member.domain.MemberCardType;
import org.springframework.stereotype.Component;

@Component
public class MemberCardTypeDTOConverter extends SimpleDTOConverter<MemberCardTypeDTO, MemberCardType> {
}
