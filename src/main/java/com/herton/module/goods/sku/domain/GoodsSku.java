package com.herton.module.goods.sku.domain;

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
@ApiModel("商品最小库存单元")
public class GoodsSku extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    @Column(length = 36)
    private String goodsId;
    @ApiModelProperty(value = "条码")
    @Column(length = 200)
    private String barcode;
    @ApiModelProperty(value = "sku编号")
    @Column(length = 200)
    private String code;
    @ApiModelProperty(value = "属性值id（逗号分隔）")
    @Column(length = 2000)
    private String goodsAttributeIds;
    @ApiModelProperty(value = "上次进货价")
    @Column(length = 11, scale = 2, precision = 13)
    private Double lastPurchasePrice;
    @ApiModelProperty(value = "库存数量")
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockNumber;
    @ApiModelProperty(value = "库存预警值")
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockWarnNumber;
}
