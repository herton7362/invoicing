package com.herton.module.goods.property.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品属性组")
public class GoodsPropertyGroup extends BaseEntity {
    @ApiModelProperty(value = "名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "备注")
    @Column(length = 50)
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
