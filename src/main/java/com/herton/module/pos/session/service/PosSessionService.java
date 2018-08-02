package com.herton.module.pos.session.service;

import com.herton.common.CrudService;
import com.herton.module.pos.session.domain.PosSession;
import com.herton.module.pos.session.dto.PosSessionDTO;

public interface PosSessionService extends CrudService<PosSession, PosSessionDTO> {
    /**
     * 打开会话
     * @param adminId 管理员id
     * @return 会话
     */
    PosSessionDTO open(String adminId);

    /**
     * 关闭会话
     * @param id 会话id
     * @return 会话
     */
    PosSessionDTO close(String id);

    /**
     * 获取进行中的会话
     * @param adminId 管理员id
     * @return 会话
     */
    PosSessionDTO getOngoingSession(String adminId);


}
