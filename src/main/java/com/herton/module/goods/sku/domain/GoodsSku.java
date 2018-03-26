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
    private String goodsPropertyValueIds;

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

    public String getGoodsPropertyValueIds() {
        return goodsPropertyValueIds;
    }

    public void setGoodsPropertyValueIds(String goodsPropertyValueIds) {
        this.goodsPropertyValueIds = goodsPropertyValueIds;
    }
}
