package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class GoodsSupplier extends BaseEntity {
    private String goodsId;
    @Column(length = 36)
    private String businessRelatedUnitId;
    @Column(length = 11, scale = 2, precision = 13)
    private Double minimumCount;
    @Column(length = 11, scale = 2, precision = 13)
    private Double price;
}
