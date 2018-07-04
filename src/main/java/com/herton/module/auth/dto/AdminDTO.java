package com.herton.module.auth.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.auth.domain.Admin;
import com.herton.module.auth.domain.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ApiModel(value = "管理员")
public class AdminDTO extends BaseDTO<Admin> {
    @ApiModelProperty(required = true, value = "姓名")
    private String name;
    @ApiModelProperty(required = true, value = "头像")
    private String avatar;
    @ApiModelProperty(required = true, value = "角色")
    private List<Role> roles;
    @ApiModelProperty(value = "角色Id")
    private List<String> roleIds;
    @ApiModelProperty(value = "登录名称")
    private String loginName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "用户类型", notes="MEMBER,ADMIN")
    private String userType;
}
