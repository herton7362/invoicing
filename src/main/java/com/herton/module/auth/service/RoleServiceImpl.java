package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.domain.RoleRepository;
import com.herton.module.auth.dto.RoleDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class RoleServiceImpl extends AbstractCrudService<Role, RoleDTO> implements RoleService {
    private final ModuleService moduleService;
    private final RoleRepository roleRepository;

    @Override
    public void authorize(String roleId, List<String> moduleIds) throws Exception {
        if(StringUtils.isBlank(roleId)) {
            throw new InvalidParamException("roleId is required");
        }
        Role role = roleRepository.findOne(roleId);
        List<Module> modules = new ArrayList<>(moduleIds.size());
        moduleIds.forEach(moduleId -> {
            try {
                modules.add(moduleService.findOne(moduleId).convert());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        role.setModules(modules);
        roleRepository.save(role);
    }

    @Override
    public void delete(String id) throws Exception {
        this.checkUsed(id);
        super.delete(id);
    }

    @Override
    public void delete(Iterable<? extends RoleDTO> roles) throws Exception {
        for (RoleDTO role : roles) {
            this.checkUsed(role.getId());
        }
        super.delete(roles);
    }

    private void checkUsed(String id) throws Exception {
        int count = roleRepository.getStaffAccountMount(id);
        if(count > 0) {
            throw new InvalidParamException("有员工归属于当前角色，请先删除员工");
        }
    }

    @Autowired
    public RoleServiceImpl(
            ModuleService moduleService,
            RoleRepository roleRepository
    ) {
        this.moduleService = moduleService;
        this.roleRepository = roleRepository;
    }
}
