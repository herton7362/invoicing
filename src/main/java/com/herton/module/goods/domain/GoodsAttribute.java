package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

@Entity
@ApiModel("商品属性")
public class GoodsAttribute extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "商品属性id")
    private String goodsTypeAttributeId;
    @ApiModelProperty(value = "商品属性值")
    private String goodsTypeAttributeValue;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTypeAttributeId() {
        return goodsTypeAttributeId;
    }

    public void setGoodsTypeAttributeId(String goodsTypeAttributeId) {
        this.goodsTypeAttributeId = goodsTypeAttributeId;
    }

    public String getGoodsTypeAttributeValue() {
        return goodsTypeAttributeValue;
    }

    public void setGoodsTypeAttributeValue(String goodsTypeAttributeValue) {
        this.goodsTypeAttributeValue = goodsTypeAttributeValue;
    }
}
