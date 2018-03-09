package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.exceptions.BusinessException;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.domain.RoleRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class RoleServiceImpl extends AbstractCrudService<Role> implements RoleService {
    private final RoleRepository roleRepository;
    private final ModuleService moduleService;
    @Override
    protected PageRepository<Role> getRepository() {
        return roleRepository;
    }

    @Override
    public void authorize(String roleId, List<String> moduleIds) throws Exception {
        if(StringUtils.isBlank(roleId)) {
            throw new BusinessException("roleId is required");
        }
        Role role = roleRepository.findOne(roleId);
        List<Module> modules = new ArrayList<>(moduleIds.size());
        moduleIds.forEach(moduleId -> {
            try {
                modules.add(moduleService.findOne(moduleId));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        role.setModules(modules);
        roleRepository.save(role);
    }

    @Autowired
    public RoleServiceImpl(
            RoleRepository roleRepository,
            ModuleService moduleService
    ) {
        this.roleRepository = roleRepository;
        this.moduleService = moduleService;
    }
}
