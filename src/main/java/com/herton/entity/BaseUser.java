package com.herton.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * 基础用户对象
 * @author tang he
 * @since 1.0.0
 */
@Setter
@Getter
@MappedSuperclass
public abstract class BaseUser extends BaseEntity {
    @ApiModelProperty(value = "登录名称")
    private String loginName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "用户类型", notes="MEMBER,ADMIN")
    private String userType;

    public enum UserType {
        MEMBER,ADMIN
    }
}
