package com.herton.module.auth.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.domain.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RoleDTOConverter extends SimpleDTOConverter<RoleDTO, Role> {
    private final RoleRepository roleRepository;
    @Override
    protected RoleDTO doBackward(Role role) {
        RoleDTO roleDTO = super.doBackward(role);
        Map<String, String> param = new HashMap<>();
        param.put("roleId", role.getId());
        roleDTO.setStaffAccountMount(roleRepository.getStaffAccountMount(role.getId()));
        return super.doBackward(role);
    }

    @Autowired
    public RoleDTOConverter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
