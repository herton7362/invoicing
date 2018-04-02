package com.herton.module.auth.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.web.RoleResult;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface RoleService extends CrudService<Role> {
    /**
     * 授权
     * @param roleId 角色id
     * @param moduleIds 授权的模块id
     */
    void authorize(String roleId, List<String> moduleIds) throws Exception;

    /**
     * 分页查询，并且转译结果
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link RoleResult} spring boot 分页类
     */
    PageResult<RoleResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception;

    /**
     * 查询，并且转译结果
     * @param param 查询条件
     * @return {@link RoleResult} spring boot 分页类
     */
    List<RoleResult> findAllTranslated(Map<String, ?> param) throws Exception;
}
