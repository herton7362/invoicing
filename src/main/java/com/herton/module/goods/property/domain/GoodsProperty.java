package com.herton.module.goods.property.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品属性")
public class GoodsProperty extends BaseEntity {
    @ApiModelProperty(value = "类别id")
    @Column(length = 36)
    private String goodsPropertyTypeId;
    @ApiModelProperty(value = "名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "条码")
    @Column(length = 50)
    private String barcode;
    @ApiModelProperty(value = "备注")
    @Column(length = 50)
    private String remark;
    @ApiModelProperty(value = "分组id，多个用逗号隔开")
    @Column(length = 500)
    private String goodsPropertyCategoryId;

    public String getGoodsPropertyTypeId() {
        return goodsPropertyTypeId;
    }

    public void setGoodsPropertyTypeId(String goodsPropertyTypeId) {
        this.goodsPropertyTypeId = goodsPropertyTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGoodsPropertyCategoryId() {
        return goodsPropertyCategoryId;
    }

    public void setGoodsPropertyCategoryId(String goodsPropertyCategoryId) {
        this.goodsPropertyCategoryId = goodsPropertyCategoryId;
    }
}
