package com.herton.module.goods.type.web;

import com.herton.module.goods.type.domain.GoodsTypeAttribute;
import com.herton.module.goods.type.domain.GoodsType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品类别查询结果")
public class GoodsTypeResult extends GoodsType {
    @ApiModelProperty(value = "商品属性")
    private List<GoodsTypeAttribute> goodsTypeAttributes;

    public List<GoodsTypeAttribute> getGoodsTypeAttributes() {
        return goodsTypeAttributes;
    }

    public void setGoodsTypeAttributes(List<GoodsTypeAttribute> goodsTypeAttributes) {
        this.goodsTypeAttributes = goodsTypeAttributes;
    }
}
