package com.herton.module.auth.web;

import com.herton.module.auth.domain.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色查询结果")
public class RoleResult extends Role {
    @ApiModelProperty(value = "已配置个账号数量")
    private Integer staffAccountMount;

    public Integer getStaffAccountMount() {
        return staffAccountMount;
    }

    public void setStaffAccountMount(Integer staffAccountMount) {
        this.staffAccountMount = staffAccountMount;
    }
}
