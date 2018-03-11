package com.herton.module.member.service;

import com.herton.common.CrudService;
import com.herton.module.member.domain.MemberCard;

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
}
