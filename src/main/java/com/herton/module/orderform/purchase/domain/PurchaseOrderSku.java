package com.herton.module.orderform.purchase.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
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
}
