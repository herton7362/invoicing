package com.herton.module.basicdata.member.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.NumberUtils;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.basicdata.member.domain.Member;
import com.herton.module.basicdata.member.domain.MemberCard;
import com.herton.module.basicdata.member.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class MemberServiceImpl extends AbstractCrudService<Member> implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberCardService memberCardService;
    @Override
    protected PageRepository<Member> getRepository() {
        return memberRepository;
    }

    private Map<String, String[]> produceQueryParam(Map<String, String[]> param) throws Exception {
        Map<String, String[]> newParam = new HashMap<>();
        param.entrySet().forEach((stringEntry -> newParam.put(stringEntry.getKey(), stringEntry.getValue())));
        if(param.containsKey("cardNumber") && StringUtils.isNotBlank(param.get("cardNumber")[0])) {
            Map<String, String[]> paramTemp = new HashMap<>();
            paramTemp.put("cardNumber", param.get("cardNumber"));
            newParam.remove("cardNumber");
            List<MemberCard> memberCards = memberCardService.findAll(paramTemp);
            if(memberCards != null && !memberCards.isEmpty()) {
                List<String> ids = new ArrayList<>();
                for (MemberCard memberCard : memberCards) {
                    ids.add(memberCard.getMemberId());
                }
                newParam.put("id", ids.toArray(new String[]{}));
            }
        }
        return newParam;
    }

    @Override
    public Member save(Member member) throws Exception {
        if(StringUtils.isBlank(member.getId())) {
            member.setCode(NumberUtils.manufactureTradeNumber());
        }
        return super.save(member);
    }

    @Override
    public Double getBalance(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员id不能为空");
        }
        return memberCardService.getMemberTotalBalance(id);
    }

    @Override
    public Integer getPoints(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员id不能为空");
        }
        return memberCardService.getMemberTotalPoints(id);
    }

    @Override
    public Integer getCardCount(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员id不能为空");
        }
        return memberCardService.getMemberCardCount(id);
    }

    @Autowired
    public MemberServiceImpl(
            MemberRepository memberRepository,
            MemberCardService memberCardService
    ) {
        this.memberRepository = memberRepository;
        this.memberCardService = memberCardService;
    }
}
