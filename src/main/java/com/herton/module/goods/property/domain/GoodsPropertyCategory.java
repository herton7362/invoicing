package com.herton.module.goods.property.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品属性类别")
public class GoodsPropertyCategory extends BaseEntity{
    @ApiModelProperty(value = "属性id")
    @Column(length = 36)
    private String goodsPropertyId;
    @ApiModelProperty(value = "名称")
    @Column(length = 50)
    private String name;

    public String getGoodsPropertyId() {
        return goodsPropertyId;
    }

    public void setGoodsPropertyId(String goodsPropertyId) {
        this.goodsPropertyId = goodsPropertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
