package com.herton.module.goods.sku.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGoodsAttributeIds() {
        return goodsAttributeIds;
    }

    public void setGoodsAttributeIds(String goodsAttributeIds) {
        this.goodsAttributeIds = goodsAttributeIds;
    }

    public Double getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public void setLastPurchasePrice(Double lastPurchasePrice) {
        this.lastPurchasePrice = lastPurchasePrice;
    }

    public Double getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Double stockNumber) {
        this.stockNumber = stockNumber;
    }
}
