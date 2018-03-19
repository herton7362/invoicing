package com.herton.module.goods.property.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品属性组属性值")
public class GoodsPropertyGroupProperty extends BaseEntity {
    @ApiModelProperty(value = "属性组id")
    @Column(length = 36)
    private String goodsPropertyGroupId;
    @ApiModelProperty(value = "属性id")
    @Column(length = 36)
    private String goodsPropertyId;

    public String getGoodsPropertyGroupId() {
        return goodsPropertyGroupId;
    }

    public void setGoodsPropertyGroupId(String goodsPropertyGroupId) {
        this.goodsPropertyGroupId = goodsPropertyGroupId;
    }

    public String getGoodsPropertyId() {
        return goodsPropertyId;
    }

    public void setGoodsPropertyId(String goodsPropertyId) {
        this.goodsPropertyId = goodsPropertyId;
    }
}
