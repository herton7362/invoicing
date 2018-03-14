package com.herton.module.member.service;

import com.herton.common.CrudService;
import com.herton.module.member.domain.Member;

public interface MemberService extends CrudService<Member> {
    /**
     * 获取账户储值余额
     * @param id 会员id
     * @return 储值余额
     */
    Double getBalance(String id) throws Exception;

    /**
     * 获取账户积分
     * @param id 会员id
     * @return 积分
     */
    Integer getPoints(String id) throws Exception;

    /**
     * 获取会员卡数量
     * @param id 会员id
     * @return 会员卡数量
     */
    Integer getCardCount(String id) throws Exception;

    /**
     * 启用
     * @param id 会员id
     */
    void enable(String id) throws Exception;

    /**
     * 停用
     * @param id 会员id
     */
    void disable(String id) throws Exception;
}
