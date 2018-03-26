package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品的商品属性的属性值")
public class GoodsGoodsPropertyValue extends BaseEntity {
    @ApiModelProperty(value = "商品的商品属性id")
    @Column(length = 36)
    private String goodsGoodsPropertyId;
    @ApiModelProperty(value = "商品属性值id")
    @Column(length = 36)
    private String goodsPropertyValueId;

    public String getGoodsGoodsPropertyId() {
        return goodsGoodsPropertyId;
    }

    public void setGoodsGoodsPropertyId(String goodsGoodsPropertyId) {
        this.goodsGoodsPropertyId = goodsGoodsPropertyId;
    }

    public String getGoodsPropertyValueId() {
        return goodsPropertyValueId;
    }

    public void setGoodsPropertyValueId(String goodsPropertyValueId) {
        this.goodsPropertyValueId = goodsPropertyValueId;
    }
}
