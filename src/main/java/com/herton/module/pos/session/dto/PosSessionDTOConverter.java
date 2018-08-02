package com.herton.module.pos.session.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.auth.domain.Admin;
import com.herton.module.auth.service.AdminService;
import com.herton.module.pos.session.domain.PosSession;
import org.springframework.stereotype.Component;

@Component
public class PosSessionDTOConverter extends SimpleDTOConverter<PosSessionDTO, PosSession> {
    private final AdminService adminService;

    @Override
    protected PosSessionDTO doBackward(PosSession posSession) {
        PosSessionDTO posSessionDTO = super.doBackward(posSession);
        posSessionDTO.setStatusName(posSession.getStatus().getDisplayName());
        Admin admin = adminService.findOneEntity(posSession.getAdminId());
        if(admin != null) {
            posSessionDTO.setAdminName(admin.getName());
        }
        return posSessionDTO;
    }

    public PosSessionDTOConverter(AdminService adminService) {
        this.adminService = adminService;
    }
}
