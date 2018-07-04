package com.herton.module.basicdata.member.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.member.domain.MemberCard;
import org.springframework.stereotype.Component;

@Component
public class MemberCardDTOConverter extends SimpleDTOConverter<MemberCardDTO, MemberCard> {
}
