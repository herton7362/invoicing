package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.auth.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class OauthClientDetailsServiceImpl extends AbstractCrudService<OauthClientDetailsRepository, OauthClientDetails> implements OauthClientDetailsService {
    private final AdminService adminService;
    private final ModuleService moduleService;
    private final RoleService roleService;

    @Override
    public OauthClientDetails save(OauthClientDetails oauthClientDetails) throws Exception {
        if(StringUtils.isBlank(oauthClientDetails.getClientId())) {
            throw new InvalidParamException("client id is null");
        }
        if(StringUtils.isBlank(oauthClientDetails.getClientSecret())) {
            throw new InvalidParamException("client secret is null");
        }
        if(StringUtils.isBlank(oauthClientDetails.getId())) {
            initSuperAdmin(oauthClientDetails.getClientId());
        }
        return super.save(oauthClientDetails);
    }

    /**
     * 初始化超级管理员
     * @param clientId client id
     */
    private void initSuperAdmin(String clientId) throws Exception {
        Admin admin = new Admin();
        admin.setName("超级管理员");
        admin.setLoginName("admin");
        admin.setClientId(clientId);
        List<Role> roles = new ArrayList<>();
        roles.add(initRole(clientId));
        admin.setRoles(roles);
        adminService.save(admin);
    }

    /**
     * 初始化超级管理员角色
     * @param clientId client id
     */
    private Role initRole(String clientId)  throws Exception {
        Role role = new Role();
        role.setName("超级管理员");
        role.setClientId(clientId);
        role.setModules(initModule(clientId));
        return roleService.save(role);
    }

    private List<Module> initModule(String clientId) throws Exception {
        List<Module> modules = new ArrayList<>();
        Module authModule = createModule("权限管理", "", clientId, null);
        modules.add(authModule);
        modules.add(createModule("管理员管理", "/admin/admin/list", clientId, authModule));
        modules.add(createModule("角色管理", "/admin/role/list", clientId, authModule));
        modules.add(createModule("模块管理", "/admin/module/list", clientId, authModule));
        return modules;
    }

    private Module createModule(String name, String url, String clientId, Module parent)  throws Exception {
        Module module = new Module();
        module.setName(name);
        module.setType(Module.Type.MENU.name());
        module.setUrl(url);
        module.setClientId(clientId);
        module.setParent(parent);
        return moduleService.save(module);
    }

    @Override
    public OauthClientDetails findOneByClientId(String clientId) throws Exception {
        return ((OauthClientDetailsRepository) pageRepository).findOneByClientId(clientId);
    }

    @Autowired
    public OauthClientDetailsServiceImpl(
            AdminService adminService,
            ModuleService moduleService,
            RoleService roleService
    ) {
        this.adminService = adminService;
        this.moduleService = moduleService;
        this.roleService = roleService;
    }
}
