package com.herton.module.auth.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.auth.domain.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("角色")
public class RoleDTO extends BaseDTO<RoleDTO, Role> {
    @ApiModelProperty(value = "角色名称")
    private String name;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "角色名称")
    private String remark;
    @ApiModelProperty(value = "已配置个账号数量")
    private Integer staffAccountMount;
}
