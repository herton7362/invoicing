package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.domain.RoleRepository;
import com.herton.module.auth.web.RoleResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new InvalidParamException("roleId is required");
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

    @Override
    public PageResult<RoleResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<Role> page = super.findAll(pageRequest, param);
        PageResult<RoleResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<RoleResult> findAllTranslated(Map<String, ?> param) throws Exception {
        return translateResults(super.findAll(param));
    }

    private List<RoleResult> translateResults(List<Role> roles) throws Exception {
        List<RoleResult> roleResults = new ArrayList<>();
        for (Role role : roles) {
            roleResults.add(this.translateResult(role));
        }
        return roleResults;
    }

    private RoleResult translateResult(Role role) throws Exception {
        RoleResult roleResult = new RoleResult();
        BeanUtils.copyProperties(role, roleResult);
        Map<String, String> param = new HashMap<>();
        param.put("roleId", role.getId());
        roleResult.setStaffAccountMount(roleRepository.getStaffAccountMount(role.getId()));
        return roleResult;
    }

    @Override
    public void delete(String id) throws Exception {
        this.checkUsed(id);
        super.delete(id);
    }

    @Override
    public void delete(Iterable<? extends Role> roles) throws Exception {
        for (Role role : roles) {
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
            RoleRepository roleRepository,
            ModuleService moduleService
    ) {
        this.roleRepository = roleRepository;
        this.moduleService = moduleService;
    }
}
