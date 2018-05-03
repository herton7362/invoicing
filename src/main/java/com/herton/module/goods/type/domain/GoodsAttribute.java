package com.herton.module.goods.type.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品属性")
public class GoodsAttribute extends BaseEntity {
    @ApiModelProperty(value = "商品类型id")
    @Column(length = 36)
    private String goodsTypeId;
    @ApiModelProperty(value = "属性名称")
    @Column(length = 100)
    private String name;
    @ApiModelProperty(value = "属性值，用逗号分隔")
    @Column(length = 500)
    private String attrValues;

    public String getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(String goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(String attrValues) {
        this.attrValues = attrValues;
    }
}
