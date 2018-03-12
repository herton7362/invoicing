package com.herton.module.member.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.BusinessException;
import com.herton.module.member.domain.MemberCard;
import com.herton.module.member.domain.MemberCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class MemberCardServiceImpl extends AbstractCrudService<MemberCard> implements MemberCardService {
    private final MemberCardRepository memberCardRepository;
    @Override
    protected PageRepository<MemberCard> getRepository() {
        return memberCardRepository;
    }

    @Override
    public Double getMemberTotalBalance(String memberId) throws Exception {
        if(StringUtils.isBlank(memberId)) {
            throw new BusinessException("会员id不能为空");
        }
        Map<String, String[]> params = new HashMap<>();
        params.put("memberId", new String[]{memberId});
        BigDecimal result = new BigDecimal(0);
        List<MemberCard> memberCards = findAll(params);

        for (MemberCard memberCard : memberCards) {
            result = result.add(new BigDecimal(memberCard.getBalance()));
        }
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public Integer getMemberTotalPoints(String memberId) throws Exception {
        if(StringUtils.isBlank(memberId)) {
            throw new BusinessException("会员id不能为空");
        }
        Map<String, String[]> params = new HashMap<>();
        params.put("memberId", new String[]{memberId});
        Integer result = 0;
        List<MemberCard> memberCards = findAll(params);

        for (MemberCard memberCard : memberCards) {
            result += memberCard.getPoints();
        }
        return result;
    }

    @Override
    public Integer getMemberCardCount(String memberId) {
        Map<String, String[]> params = new HashMap<>();
        params.put("memberId", new String[]{memberId});
        return Long.valueOf(memberCardRepository.count(getSpecification(params))).intValue();
    }

    @Autowired
    public MemberCardServiceImpl(MemberCardRepository memberCardRepository) {
        this.memberCardRepository = memberCardRepository;
    }
}
