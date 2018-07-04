package com.herton.module.auth.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.auth.domain.Admin;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDTOConverter extends SimpleDTOConverter<AdminDTO, Admin> {
    private final RoleService roleService;
    @Override
    protected Admin doForward(AdminDTO adminDTO) {
        Admin admin = super.doForward(adminDTO);
        List<String> ids = adminDTO.getRoleIds();
        List<Role> roles = new ArrayList<>();
        ids.forEach(id -> {
            try {
                roles.add((Role) roleService.findOne(id).convert());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        admin.setRoles(roles);
        return admin;
    }

    @Override
    protected AdminDTO doBackward(Admin admin) {
        AdminDTO adminDTO = super.doBackward(admin);
        List<Role> roles = admin.getRoles();
        List<String> ids = new ArrayList<>();
        if(roles != null) {
            roles.forEach(role -> ids.add(role.getId()));
        }
        adminDTO.setRoleIds(ids);
        return adminDTO;
    }

    @Autowired
    public AdminDTOConverter(RoleService roleService) {
        this.roleService = roleService;
    }
}
