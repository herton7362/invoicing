package com.herton.module.orderform.purchase.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class PurchaseOrderSku extends BaseEntity {
    @Column(length = 36)
    private String purchaseOrderId;
    @Column(length = 36)
    private String goodsId;
    @Column(length = 36)
    private String skuId;
    @Column(length = 11, scale = 2, precision = 13)
    private Double count;
    @Column(length = 11, scale = 2, precision = 13)
    private Double price;
    @Column(length = 11, scale = 2, precision = 13)
    private Double sumPrice;
    @Column(length = 200)
    private Double remark;
}
