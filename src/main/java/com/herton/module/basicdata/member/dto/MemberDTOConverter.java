package com.herton.module.basicdata.member.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberDTOConverter extends SimpleDTOConverter<MemberDTO, Member> {
}
