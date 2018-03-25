package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品售价")
public class GoodsPrice extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    @Column(length = 36)
    private String goodsId;
    @ApiModelProperty(value = "单位名称")
    @Column(length = 20)
    private String unitName;
    @ApiModelProperty(value = "单位关系")
    @Column(length = 11, scale = 2, precision = 13)
    private Double conversionRelationship;
    @ApiModelProperty(value = "是否为基本单位")
    private Boolean isBasic;
    @ApiModelProperty(value = "零售价")
    @Column(length = 11, scale = 2, precision = 13)
    private Double retailPrice;
    @ApiModelProperty(value = "预设售价1")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice1;
    @ApiModelProperty(value = "预设售价2")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice2;
    @ApiModelProperty(value = "预设售价3")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice3;
    @ApiModelProperty(value = "预设售价4")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice4;
    @ApiModelProperty(value = "预设售价5")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice5;
    @ApiModelProperty(value = "预设售价6")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice6;
    @ApiModelProperty(value = "预设售价7")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice7;
    @ApiModelProperty(value = "预设售价8")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice8;
    @ApiModelProperty(value = "预设售价9")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice9;
    @ApiModelProperty(value = "预设售价10")
    @Column(length = 11, scale = 2, precision = 13)
    private Double presetPrice10;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Double getConversionRelationship() {
        return conversionRelationship;
    }

    public void setConversionRelationship(Double conversionRelationship) {
        this.conversionRelationship = conversionRelationship;
    }

    public Boolean getIsBasic() {
        return this.isBasic;
    }

    public void setIsBasic(Boolean isBasic) {
        this.isBasic = isBasic;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getPresetPrice1() {
        return presetPrice1;
    }

    public void setPresetPrice1(Double presetPrice1) {
        this.presetPrice1 = presetPrice1;
    }

    public Double getPresetPrice2() {
        return presetPrice2;
    }

    public void setPresetPrice2(Double presetPrice2) {
        this.presetPrice2 = presetPrice2;
    }

    public Double getPresetPrice3() {
        return presetPrice3;
    }

    public void setPresetPrice3(Double presetPrice3) {
        this.presetPrice3 = presetPrice3;
    }

    public Double getPresetPrice4() {
        return presetPrice4;
    }

    public void setPresetPrice4(Double presetPrice4) {
        this.presetPrice4 = presetPrice4;
    }

    public Double getPresetPrice5() {
        return presetPrice5;
    }

    public void setPresetPrice5(Double presetPrice5) {
        this.presetPrice5 = presetPrice5;
    }

    public Double getPresetPrice6() {
        return presetPrice6;
    }

    public void setPresetPrice6(Double presetPrice6) {
        this.presetPrice6 = presetPrice6;
    }

    public Double getPresetPrice7() {
        return presetPrice7;
    }

    public void setPresetPrice7(Double presetPrice7) {
        this.presetPrice7 = presetPrice7;
    }

    public Double getPresetPrice8() {
        return presetPrice8;
    }

    public void setPresetPrice8(Double presetPrice8) {
        this.presetPrice8 = presetPrice8;
    }

    public Double getPresetPrice9() {
        return presetPrice9;
    }

    public void setPresetPrice9(Double presetPrice9) {
        this.presetPrice9 = presetPrice9;
    }

    public Double getPresetPrice10() {
        return presetPrice10;
    }

    public void setPresetPrice10(Double presetPrice10) {
        this.presetPrice10 = presetPrice10;
    }
}
