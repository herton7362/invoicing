package com.herton.module.pos.orderform.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class PosOrderSku extends BaseEntity {
    @Column(length = 36)
    private String posOrderId;
    @Column(length = 36)
    private String goodsId;
    @Column(length = 36)
    private String skuId;
    @Column(length = 11, scale = 2, precision = 13)
    private Double count;
    @Column(length = 11, scale = 2, precision = 13)
    private Double price;
}
