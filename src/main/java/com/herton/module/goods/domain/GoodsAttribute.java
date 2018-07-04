package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class GoodsAttribute extends BaseEntity {
    private String goodsId;
    private String goodsTypeAttributeId;
    private String goodsTypeAttributeValue;
}
