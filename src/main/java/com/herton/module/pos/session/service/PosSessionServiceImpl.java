package com.herton.module.pos.session.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.service.CodeNumberService;
import com.herton.module.pos.session.domain.PosSession;
import com.herton.module.pos.session.domain.QPosSession;
import com.herton.module.pos.session.dto.PosSessionDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@Transactional
public class PosSessionServiceImpl extends AbstractChildCrudService<PosSession, PosSessionDTO> implements PosSessionService {
    private final CodeNumberService codeNumberService;

    @Override
    public PosSessionDTO open(String adminId) {
        if(StringUtils.isBlank(adminId)) {
            throw new InvalidParamException("管理员id不能为空");
        }
        PosSessionDTO posSession = getOngoingSession(adminId);

        if(posSession == null) {
            posSession = new PosSessionDTO()
                    .setAdminId(adminId)
                    .setSessionId(codeNumberService.getCodeByBusinessType(CodeNumber.BusinessType.PHH))
                    .setStartDate(new Date())
                    .setStatus(PosSession.Status.ONGOING);
            posSession = super.save(posSession);
        }
        return posSession;
    }

    @Override
    public PosSessionDTO close(String id) {
        PosSessionDTO posSession = super.findOne(id);
        if(posSession == null) {
            throw new InvalidParamException("会话未找到");
        }
        return super.save(posSession.setStatus(PosSession.Status.CONFIRMED));
    }

    public PosSessionDTO getOngoingSession(String adminId) {
        QPosSession qPosSession = QPosSession.posSession;
        PosSession posSession = queryFactory.selectFrom(qPosSession).where(qPosSession.adminId.eq(adminId)
                .and(qPosSession.logicallyDeleted.eq(false)
                        .and(qPosSession.status.eq(PosSession.Status.ONGOING)))).fetchFirst();
        if(posSession != null) {
            return baseDTO.convertFor(posSession);
        }
        return null;
    }

    public PosSessionServiceImpl(CodeNumberService codeNumberService) {
        this.codeNumberService = codeNumberService;
    }
}
