package com.herton.module.orderform.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("采购订单商品")
public class PurchaseOrderSku extends BaseEntity {
    @ApiModelProperty(value = "采购订单 id")
    @Column(length = 36)
    private String purchaseOrderId;
    @ApiModelProperty(value = "商品 id")
    @Column(length = 36)
    private String goodsId;
    @ApiModelProperty(value = "sku id")
    @Column(length = 36)
    private String skuId;
    @ApiModelProperty(value = "数量")
    @Column(length = 11, scale = 2, precision = 13)
    private Double count;
    @ApiModelProperty(value = "单价")
    @Column(length = 11, scale = 2, precision = 13)
    private Double price;
    @ApiModelProperty(value = "金额")
    @Column(length = 11, scale = 2, precision = 13)
    private Double sumPrice;
    @ApiModelProperty(value = "备注")
    @Column(length = 200)
    private Double remark;

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Double getRemark() {
        return remark;
    }

    public void setRemark(Double remark) {
        this.remark = remark;
    }
}
