package com.herton.module.auth.domain;

import com.herton.entity.BaseUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 管理员
 * @author tang he
 * @since 1.0.0
 */
@Entity
@Setter
@Getter
@ApiModel(value = "管理员")
public class Admin extends BaseUser {
    @ApiModelProperty(required = true, value = "姓名")
    @Column(length = 20)
    private String name;
    @ApiModelProperty(required = true, value = "头像")
    @Column(length = 200)
    private String avatar;
    @ApiModelProperty(required = true, value = "角色")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="admin_roles",joinColumns={@JoinColumn(name="admin_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
    private List<Role> roles;
}
