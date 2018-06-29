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
}
