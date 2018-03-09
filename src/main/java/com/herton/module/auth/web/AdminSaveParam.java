package com.herton.module.auth.web;

import com.herton.module.auth.domain.Admin;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AdminSaveParam extends Admin {
    @ApiModelProperty("角色id")
    private List<String> roleIds;

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
