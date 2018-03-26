package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品的商品属性")
public class GoodsGoodsProperty extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    @Column(length = 36)
    private String goodsId;
    @ApiModelProperty(value = "商品属性id")
    @Column(length = 36)
    private String goodsPropertyId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPropertyId() {
        return goodsPropertyId;
    }

    public void setGoodsPropertyId(String goodsPropertyId) {
        this.goodsPropertyId = goodsPropertyId;
    }
}
