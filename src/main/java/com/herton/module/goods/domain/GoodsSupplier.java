package com.herton.module.goods.domain;

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
@ApiModel("商品供应商")
public class GoodsSupplier extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "供应商")
    @Column(length = 36)
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "最少数量")
    @Column(length = 11, scale = 2, precision = 13)
    private Double minimumCount;
    @ApiModelProperty(value = "单价")
    @Column(length = 11, scale = 2, precision = 13)
    private Double price;
}
