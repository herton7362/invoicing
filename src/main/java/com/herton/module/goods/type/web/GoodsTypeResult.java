package com.herton.module.goods.type.web;

import com.herton.module.goods.type.domain.GoodsAttribute;
import com.herton.module.goods.type.domain.GoodsType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品类别查询结果")
public class GoodsTypeResult extends GoodsType {
    @ApiModelProperty(value = "商品属性")
    private List<GoodsAttribute> goodsAttributes;

    public List<GoodsAttribute> getGoodsAttributes() {
        return goodsAttributes;
    }

    public void setGoodsAttributes(List<GoodsAttribute> goodsAttributes) {
        this.goodsAttributes = goodsAttributes;
    }
}
