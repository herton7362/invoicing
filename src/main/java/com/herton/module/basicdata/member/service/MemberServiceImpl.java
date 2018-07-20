package com.herton.module.basicdata.member.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.NumberUtils;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.basicdata.member.domain.Member;
import com.herton.module.basicdata.member.domain.MemberCard;
import com.herton.module.basicdata.member.domain.MemberRepository;
import com.herton.module.basicdata.member.dto.MemberCardDTO;
import com.herton.module.basicdata.member.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class MemberServiceImpl extends AbstractCrudService<Member, MemberDTO> implements MemberService {
    private final MemberCardService memberCardService;

    @Override
    public MemberDTO save(MemberDTO member) {
        if(StringUtils.isBlank(member.getId())) {
            member.setCode(NumberUtils.manufactureTradeNumber());
        }
        return super.save(member);
    }

    @Override
    public Double getBalance(String id) {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员id不能为空");
        }
        return memberCardService.getMemberTotalBalance(id);
    }

    @Override
    public Integer getPoints(String id) {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员id不能为空");
        }
        return memberCardService.getMemberTotalPoints(id);
    }

    @Override
    public Integer getCardCount(String id) {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员id不能为空");
        }
        return memberCardService.getMemberCardCount(id);
    }

    @Autowired
    public MemberServiceImpl(
            MemberCardService memberCardService
    ) {
        this.memberCardService = memberCardService;
    }
}
