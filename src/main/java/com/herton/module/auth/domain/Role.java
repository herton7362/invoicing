package com.herton.module.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * 角色
 * @author tang he
 * @since 1.0.0
 */
@Entity
@Setter
@Getter
@ApiModel("角色")
public class Role extends BaseEntity {
    @ApiModelProperty(value = "角色名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "图标")
    @Column(length = 50)
    private String icon;
    @ApiModelProperty(value = "角色名称")
    @Column(length = 200)
    private String remark;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name="role_modules",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="module_id")})
    @Where(clause="logically_deleted=0")
    private List<Module> modules;
}
