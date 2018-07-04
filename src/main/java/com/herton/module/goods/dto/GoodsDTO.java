package com.herton.module.goods.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.sku.dto.GoodsSkuDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ApiModel("商品")
public class GoodsDTO extends BaseDTO<GoodsDTO, Goods> {
    @ApiModelProperty(value = "分类id")
    private String goodsCategoryId;
    @ApiModelProperty(value = "条码")
    private String barcode;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "编号")
    private String code;
    @ApiModelProperty(value = "简名")
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    private String pinyin;
    @ApiModelProperty(value = "品牌id")
    private String brandId;
    @ApiModelProperty(value = "商品类型id")
    private String goodsTypeId;
    @ApiModelProperty(value = "产地")
    private String madeAddress;
    @ApiModelProperty(value = "商品封面图片")
    private String coverImageId;
    @ApiModelProperty(value = "规格")
    private String standard;
    @ApiModelProperty(value = "型号")
    private String model;
    @ApiModelProperty(value = "零售价格")
    private Double retailPrice;
    @ApiModelProperty(value = "重量")
    private Double weight;
    @ApiModelProperty(value = "长度")
    private Double length;
    @ApiModelProperty(value = "宽度")
    private Double width;
    @ApiModelProperty(value = "高度")
    private Double height;
    @ApiModelProperty(value = "参考成本价（基本单位）")
    private Double costPrice;
    @ApiModelProperty(value = "库存数量")
    private Double stockNumber;
    @ApiModelProperty(value = "库存预警值")
    private Double stockWarnNumber;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "商品属性")
    private List<GoodsAttributeDTO> goodsAttributes;
    @ApiModelProperty(value = "商品sku")
    private List<GoodsSkuDTO> goodsSkus;
    @ApiModelProperty(value = "商品供应商")
    private List<GoodsSupplierDTO> goodsSuppliers;
}
