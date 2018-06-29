package com.herton.module.goods.type.domain;

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
@ApiModel("商品属性")
public class GoodsTypeAttribute extends BaseEntity {
    @ApiModelProperty(value = "商品类型id")
    @Column(length = 36)
    private String goodsTypeId;
    @ApiModelProperty(value = "属性名称")
    @Column(length = 100)
    private String name;
    @ApiModelProperty(value = "属性值，用逗号分隔")
    @Column(length = 500)
    private String attrValues;
}
