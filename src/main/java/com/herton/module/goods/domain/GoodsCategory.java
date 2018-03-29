package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品分类")
public class GoodsCategory extends BaseEntity {
    @ApiModelProperty(value = "上级分类id")
    @Column(length = 36)
    private String parentId;
    @ApiModelProperty(value = "名称")
    @Column(length = 50)
    private String name;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
