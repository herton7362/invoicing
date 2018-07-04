package com.herton.module.goods.sku.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class GoodsSku extends BaseEntity {
    @Column(length = 36)
    private String goodsId;
    @Column(length = 200)
    private String barcode;
    @Column(length = 200)
    private String code;
    @Column(length = 2000)
    private String goodsAttributeIds;
    @Column(length = 11, scale = 2, precision = 13)
    private Double lastPurchasePrice;
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockNumber;
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockWarnNumber;
}
