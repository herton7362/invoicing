package com.herton.module.goods.type.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class GoodsTypeAttribute extends BaseEntity {
    @Column(length = 36)
    private String goodsTypeId;
    @Column(length = 100)
    private String name;
    @Column(length = 500)
    private String attrValues;
}
