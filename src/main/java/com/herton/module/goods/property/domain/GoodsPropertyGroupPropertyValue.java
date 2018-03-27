package com.herton.module.goods.property.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品属性组关联属性值")
public class GoodsPropertyGroupPropertyValue extends BaseEntity {
    @ApiModelProperty(value = "属性组id")
    @Column(length = 36)
    private String goodsPropertyGroupId;
    @ApiModelProperty(value = "属性组关联属性id")
    @Column(length = 36)
    private String goodsPropertyGroupPropertyId;
    @ApiModelProperty(value = "属性值id")
    @Column(length = 36)
    private String goodsPropertyValueId;

    public String getGoodsPropertyGroupId() {
        return goodsPropertyGroupId;
    }

    public void setGoodsPropertyGroupId(String goodsPropertyGroupId) {
        this.goodsPropertyGroupId = goodsPropertyGroupId;
    }

    public String getGoodsPropertyGroupPropertyId() {
        return goodsPropertyGroupPropertyId;
    }

    public void setGoodsPropertyGroupPropertyId(String goodsPropertyGroupPropertyId) {
        this.goodsPropertyGroupPropertyId = goodsPropertyGroupPropertyId;
    }

    public String getGoodsPropertyValueId() {
        return goodsPropertyValueId;
    }

    public void setGoodsPropertyValueId(String goodsPropertyValueId) {
        this.goodsPropertyValueId = goodsPropertyValueId;
    }
}
