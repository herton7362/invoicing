package com.herton.module.basicdata.member.service;

import com.herton.common.CrudService;
import com.herton.module.basicdata.member.domain.Member;
import com.herton.module.basicdata.member.dto.MemberDTO;

public interface MemberService extends CrudService<Member, MemberDTO> {
    /**
     * 获取账户储值余额
     * @param id 会员id
     * @return 储值余额
     */
    Double getBalance(String id);

    /**
     * 获取账户积分
     * @param id 会员id
     * @return 积分
     */
    Integer getPoints(String id);

    /**
     * 获取会员卡数量
     * @param id 会员id
     * @return 会员卡数量
     */
    Integer getCardCount(String id);

    /**
     * 启用
     * @param id 会员id
     */
    void enable(String id);

    /**
     * 停用
     * @param id 会员id
     */
    void disable(String id);
}
