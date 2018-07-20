package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.auth.domain.*;
import com.herton.module.auth.dto.OauthClientDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class OauthClientDetailsServiceImpl extends AbstractCrudService<OauthClientDetails, OauthClientDetailsDTO> implements OauthClientDetailsService {
    private final AdminRepository adminRepository;
    private final ModuleRepository moduleRepository;
    private final RoleRepository roleRepository;

    @Override
    public OauthClientDetailsDTO save(OauthClientDetailsDTO oauthClientDetails) {
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
    private void initSuperAdmin(String clientId) {
        Admin admin = new Admin();
        admin.setName("超级管理员");
        admin.setLoginName("admin");
        admin.setClientId(clientId);
        List<Role> roles = new ArrayList<>();
        roles.add(initRole(clientId));
        admin.setRoles(roles);
        adminRepository.save(admin);
    }

    /**
     * 初始化超级管理员角色
     * @param clientId client id
     */
    private Role initRole(String clientId)  {
        Role role = new Role();
        role.setName("超级管理员");
        role.setClientId(clientId);
        role.setModules(initModule(clientId));
        return roleRepository.save(role);
    }

    private List<Module> initModule(String clientId) {
        List<Module> modules = new ArrayList<>();
        Module authModule = createModule("权限管理", "", clientId, null);
        modules.add(authModule);
        modules.add(createModule("管理员管理", "/admin/admin/list", clientId, authModule));
        modules.add(createModule("角色管理", "/admin/role/list", clientId, authModule));
        modules.add(createModule("模块管理", "/admin/module/list", clientId, authModule));
        return modules;
    }

    private Module createModule(String name, String url, String clientId, Module parent)  {
        Module module = new Module();
        module.setName(name);
        module.setType(Module.Type.MENU.name());
        module.setUrl(url);
        module.setClientId(clientId);
        module.setParent(parent);
        return moduleRepository.save(module);
    }

    @Override
    public OauthClientDetails findOneByClientId(String clientId) {
        return ((OauthClientDetailsRepository) pageRepository).findOneByClientId(clientId);
    }

    @Autowired
    public OauthClientDetailsServiceImpl(
            AdminRepository adminRepository,
            ModuleRepository moduleRepository,
            RoleRepository roleRepository
    ) {
        this.adminRepository = adminRepository;
        this.moduleRepository = moduleRepository;
        this.roleRepository = roleRepository;
    }
}
