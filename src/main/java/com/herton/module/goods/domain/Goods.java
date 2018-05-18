package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品")
public class Goods extends BaseEntity {
    @ApiModelProperty(value = "分类id")
    @Column(length = 36)
    private String goodsCategoryId;
    @ApiModelProperty(value = "条码")
    @Column(length = 200)
    private String barcode;
    @ApiModelProperty(value = "名称")
    @Column(length = 200)
    private String name;
    @ApiModelProperty(value = "编号")
    @Column(length = 50)
    private String code;
    @ApiModelProperty(value = "简名")
    @Column(length = 50)
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    @Column(length = 50)
    private String pinyin;
    @ApiModelProperty(value = "品牌id")
    @Column(length = 36)
    private String brandId;
    @ApiModelProperty(value = "商品类型id")
    @Column(length = 36)
    private String goodsTypeId;
    @ApiModelProperty(value = "产地")
    @Column(length = 50)
    private String madeAddress;
    @ApiModelProperty(value = "商品封面图片")
    private String coverImageId;
    @ApiModelProperty(value = "规格")
    @Column(length = 100)
    private String standard;
    @ApiModelProperty(value = "型号")
    @Column(length = 100)
    private String model;
    @ApiModelProperty(value = "零售价格")
    @Column(length = 11, scale = 2, precision = 13)
    private Double retailPrice;
    @ApiModelProperty(value = "重量")
    @Column(length = 11, scale = 2, precision = 13)
    private Double weight;
    @ApiModelProperty(value = "长度")
    @Column(length = 11, scale = 2, precision = 13)
    private Double length;
    @ApiModelProperty(value = "宽度")
    @Column(length = 11, scale = 2, precision = 13)
    private Double width;
    @ApiModelProperty(value = "高度")
    @Column(length = 11, scale = 2, precision = 13)
    private Double height;
    @ApiModelProperty(value = "参考成本价（基本单位）")
    @Column(length = 11, scale = 2, precision = 13)
    private Double costPrice;
    @ApiModelProperty(value = "库存数量")
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockNumber;
    @ApiModelProperty(value = "库存预警值")
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockWarnNumber;
    @ApiModelProperty(value = "备注")
    @Column(length = 200)
    private String remark;

    public String getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(String goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(String goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getMadeAddress() {
        return madeAddress;
    }

    public void setMadeAddress(String madeAddress) {
        this.madeAddress = madeAddress;
    }

    public String getCoverImageId() {
        return coverImageId;
    }

    public void setCoverImageId(String coverImageId) {
        this.coverImageId = coverImageId;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Double stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Double getStockWarnNumber() {
        return stockWarnNumber;
    }

    public void setStockWarnNumber(Double stockWarnNumber) {
        this.stockWarnNumber = stockWarnNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
