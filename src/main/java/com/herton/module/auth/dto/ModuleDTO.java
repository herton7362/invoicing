package com.herton.module.auth.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.auth.domain.Module;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("模块")
public class ModuleDTO extends BaseDTO<ModuleDTO, Module> {
    @ApiModelProperty(value = "上级模块")
    private Module parent;
    @ApiModelProperty(value = "模块名称")
    private String name;
    @ApiModelProperty(value = "功能代码")
    private String code;
    @ApiModelProperty(value = "菜单请求路径")
    private String url;
    @ApiModelProperty(value = "模块类型 MENU-菜单，FUNCTION-功能")
    private String type;
    @ApiModelProperty(value = "模块名称路径存储树形结构路径")
    private String naviNamePath;
    @ApiModelProperty(value = "模块id路径存储树形结构路径")
    private String naviIdPath;
    @ApiModelProperty(value = "图标")
    private String icon;
}
