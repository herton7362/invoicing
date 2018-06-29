package com.herton.module.auth.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * 模块
 * @author tang he
 * @since 1.0.0
 */
@Entity
@Setter
@Getter
@ApiModel("模块")
public class Module extends BaseEntity {
    @ApiModelProperty(value = "上级模块")
    @ManyToOne(fetch = FetchType.EAGER)
    private Module parent;
    @ApiModelProperty(value = "模块名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "功能代码")
    @Column(length = 100)
    private String code;
    @ApiModelProperty(value = "菜单请求路径")
    @Column(length = 500)
    private String url;
    @ApiModelProperty(value = "模块类型 MENU-菜单，FUNCTION-功能")
    @Column(length = 10)
    private String type;
    @ApiModelProperty(value = "模块名称路径存储树形结构路径")
    @Column(length = 500)
    private String naviNamePath;
    @ApiModelProperty(value = "模块id路径存储树形结构路径")
    @Column(length = 500)
    private String naviIdPath;
    @ApiModelProperty(value = "图标")
    @Column(length = 100)
    private String icon;

    public enum Type {
        MENU, FUNCTION
    }
}
