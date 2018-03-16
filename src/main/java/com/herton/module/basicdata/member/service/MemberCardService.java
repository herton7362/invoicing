package com.herton.module.basicdata.member.service;

import com.herton.common.CrudService;
import com.herton.module.basicdata.member.domain.MemberCard;
import com.herton.module.basicdata.member.web.ChangePointsParam;
import com.herton.module.basicdata.member.web.ChangeBalanceParam;
import com.herton.module.basicdata.member.web.ExchangePointsToBalanceParam;

public interface MemberCardService extends CrudService<MemberCard> {
    /**
     * 获取会员总余额
     * @param memberId 会员id
     * @return 会员总余额
     */
    Double getMemberTotalBalance(String memberId) throws Exception;

    /**
     * 获取会员总积分
     * @param memberId 会员id
     * @return 会员总积分
     */
    Integer getMemberTotalPoints(String memberId) throws Exception;

    /**
     * 获取会员的会员卡数量
     * @param memberId 会员id
     * @return 会员的会员卡数量
     */
    Integer getMemberCardCount(String memberId) throws Exception;

    /**
     * 启用
     * @param id 会员卡id
     */
    void enable(String id) throws Exception;

    /**
     * 停用
     * @param id 会员卡id
     */
    void disable(String id) throws Exception;

    /**
     * 充值
     * @param id 会员卡id
     * @param changeBalanceParam 充值参数
     */
    void changeBalance(String id, ChangeBalanceParam changeBalanceParam) throws Exception;

    /**
     * 变更积分
     * @param id 会员卡id
     * @param changePointsParam 变更积分参数
     */
    void changePoints(String id, ChangePointsParam changePointsParam) throws Exception;

    /**
     * 积分转换储值
     * @param id 会员卡id
     * @param exchangePointsToBalanceParam 积分转换储值参数
     */
    void exchangePointsToBalance(String id, ExchangePointsToBalanceParam exchangePointsToBalanceParam) throws Exception;
}
