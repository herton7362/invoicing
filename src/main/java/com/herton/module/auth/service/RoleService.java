package com.herton.module.auth.service;

import com.herton.common.CrudService;
import com.herton.module.auth.domain.Role;

import java.util.List;

public interface RoleService extends CrudService<Role> {
    /**
     * 授权
     * @param roleId 角色id
     * @param moduleIds 授权的模块id
     */
    void authorize(String roleId, List<String> moduleIds) throws Exception;
}
