package com.herton.module.member.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.common.utils.NumberUtils;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.BusinessException;
import com.herton.module.member.domain.Member;
import com.herton.module.member.domain.MemberCard;
import com.herton.module.member.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<Member> findAll(Map<String, String[]> param) throws Exception {
        if(param.containsKey("cardNumber")) {
            Map<String, String[]> paramTemp = new HashMap<>();
            param.put("cardNumber", param.get("cardNumber"));
            param.remove("cardNumber");
            List<MemberCard> memberCards = memberCardService.findAll(paramTemp);
            if(memberCards != null && !memberCards.isEmpty()) {
                List<String> ids = new ArrayList<>();
                for (MemberCard memberCard : memberCards) {
                    ids.add(memberCard.getMemberId());
                }
                param.put("id", ids.toArray(new String[]{}));
            }
        }
        return super.findAll(param);
    }

    @Override
    public PageResult<Member> findAll(PageRequest pageRequest, Map<String, String[]> param) throws Exception {
        return super.findAll(pageRequest, param);
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
            throw new BusinessException("会员id不能为空");
        }
        return memberCardService.getMemberTotalBalance(id);
    }

    @Override
    public Integer getPoints(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new BusinessException("会员id不能为空");
        }
        return memberCardService.getMemberTotalPoints(id);
    }

    @Override
    public Integer getCardCount(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new BusinessException("会员id不能为空");
        }
        return memberCardService.getMemberCardCount(id);
    }

    @Override
    public void enable(String id) throws Exception {
        Member member = memberRepository.findOne(id);
        if(!member.getLogicallyDeleted()) {
            return;
        }
        member.setLogicallyDeleted(false);
        memberRepository.save(member);
    }

    @Override
    public void disable(String id) {
        Member member = memberRepository.findOne(id);
        if(member.getLogicallyDeleted()) {
            return;
        }
        member.setLogicallyDeleted(true);
        memberRepository.save(member);
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
