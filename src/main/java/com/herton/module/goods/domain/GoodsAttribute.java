package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ApiModel("商品属性")
public class GoodsAttribute extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "商品属性id")
    private String goodsTypeAttributeId;
    @ApiModelProperty(value = "商品属性值")
    private String goodsTypeAttributeValue;
}
