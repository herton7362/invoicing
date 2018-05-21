package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品供应商")
public class GoodsSupplier extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "供应商")
    @Column(length = 36)
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "最少数量")
    @Column(length = 11, scale = 2, precision = 13)
    private Double minimumCount;
    @ApiModelProperty(value = "单价")
    @Column(length = 11, scale = 2, precision = 13)
    private Double price;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBusinessRelatedUnitId() {
        return businessRelatedUnitId;
    }

    public void setBusinessRelatedUnitId(String businessRelatedUnitId) {
        this.businessRelatedUnitId = businessRelatedUnitId;
    }

    public Double getMinimumCount() {
        return minimumCount;
    }

    public void setMinimumCount(Double minimumCount) {
        this.minimumCount = minimumCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
