package com.herton.module.basicdata.member.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.basicdata.member.domain.MemberCard;
import com.herton.module.basicdata.member.domain.MemberCardRepository;
import com.herton.module.basicdata.member.dto.MemberCardDTO;
import com.herton.module.basicdata.member.web.ChangePointsParam;
import com.herton.module.basicdata.member.web.ChangeBalanceParam;
import com.herton.module.basicdata.member.web.ExchangePointsToBalanceParam;
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
public class MemberCardServiceImpl extends AbstractCrudService<MemberCard, MemberCardDTO> implements MemberCardService {

    @Override
    public Double getMemberTotalBalance(String memberId) throws Exception {
        if(StringUtils.isBlank(memberId)) {
            throw new InvalidParamException("会员id不能为空");
        }
        Map<String, String[]> params = new HashMap<>();
        params.put("memberId", new String[]{memberId});
        BigDecimal result = new BigDecimal(0);
        List<MemberCardDTO> memberCards = findAll(params);

        for (MemberCardDTO memberCard : memberCards) {
            result = result.add(new BigDecimal(memberCard.getBalance()));
        }
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public Integer getMemberTotalPoints(String memberId) throws Exception {
        if(StringUtils.isBlank(memberId)) {
            throw new InvalidParamException("会员id不能为空");
        }
        Map<String, String[]> params = new HashMap<>();
        params.put("memberId", new String[]{memberId});
        Integer result = 0;
        List<MemberCardDTO> memberCards = findAll(params);

        for (MemberCardDTO memberCard : memberCards) {
            result += memberCard.getPoints();
        }
        return result;
    }

    @Override
    public Integer getMemberCardCount(String memberId) throws Exception {
        if(StringUtils.isBlank(memberId)) {
            throw new InvalidParamException("会员id不能为空");
        }
        Map<String, String[]> params = new HashMap<>();
        params.put("memberId", new String[]{memberId});
        return Long.valueOf(pageRepository.count(getSpecification(params))).intValue();
    }

    @Override
    public void enable(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员卡id不能为空");
        }
        MemberCard memberCard = pageRepository.findOne(id);
        if(!memberCard.getLogicallyDeleted()) {
            return;
        }
        memberCard.setLogicallyDeleted(false);
        pageRepository.save(memberCard);
    }

    @Override
    public void disable(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员卡id不能为空");
        }
        MemberCard memberCard = pageRepository.findOne(id);
        if(memberCard.getLogicallyDeleted()) {
            return;
        }
        memberCard.setLogicallyDeleted(true);
        pageRepository.save(memberCard);
    }

    @Override
    public void changeBalance(String id, ChangeBalanceParam changeBalanceParam) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员卡id不能为空");
        }
        if(changeBalanceParam.getValue() == null) {
            throw new InvalidParamException("充值金额不能为空");
        }
        if(changeBalanceParam.getValue() == 0) {
            throw new InvalidParamException("充值金额不能为0");
        }
        if(StringUtils.isBlank(changeBalanceParam.getReceiveAccountId())) {
            throw new InvalidParamException("收款账户id不能为空");
        }
        MemberCard memberCard = pageRepository.findOne(id);
        memberCard.setBalance(new BigDecimal(memberCard.getBalance())
                .add(new BigDecimal(changeBalanceParam.getValue()))
                .add(new BigDecimal(changeBalanceParam.getExtra())).doubleValue());
        pageRepository.save(memberCard);
        // TODO 增加收款单
    }

    @Override
    public void changePoints(String id, ChangePointsParam changePointsParam) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员卡id不能为空");
        }
        if(changePointsParam.getValue() == null) {
            throw new InvalidParamException("变更积分不能为空");
        }
        if(changePointsParam.getValue() == 0) {
            throw new InvalidParamException("变更积分不能为0");
        }
        if(StringUtils.isBlank(changePointsParam.getRemark())) {
            throw new InvalidParamException("调整原因不能为空");
        }
        MemberCard memberCard = pageRepository.findOne(id);
        memberCard.setPoints(memberCard.getPoints() + changePointsParam.getValue());
        pageRepository.save(memberCard);
        // TODO 增加积分变更明细
    }

    @Override
    public void exchangePointsToBalance(String id, ExchangePointsToBalanceParam exchangePointsToBalanceParam) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("会员卡id不能为空");
        }
        if(exchangePointsToBalanceParam.getPoints() == null) {
            throw new InvalidParamException("兑换积分不能为空");
        }
        if(exchangePointsToBalanceParam.getPoints() == 0) {
            throw new InvalidParamException("兑换积分不能为0");
        }
        if(exchangePointsToBalanceParam.getBalance() == null) {
            throw new InvalidParamException("转化储值不能为空");
        }
        if(exchangePointsToBalanceParam.getBalance() == 0) {
            throw new InvalidParamException("转化储值不能为0");
        }
        MemberCard memberCard = pageRepository.findOne(id);
        memberCard.setPoints(memberCard.getPoints() - exchangePointsToBalanceParam.getPoints());
        memberCard.setBalance(new BigDecimal(memberCard.getBalance())
                .add(new BigDecimal(exchangePointsToBalanceParam.getBalance())).doubleValue());
        pageRepository.save(memberCard);
    }
}
