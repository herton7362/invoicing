package com.herton.module.goods.property.web;

import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.domain.GoodsPropertyCategory;
import com.herton.module.goods.property.domain.GoodsPropertyValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品属性")
public class GoodsPropertyResult extends GoodsProperty {
    @ApiModelProperty(value = "商品属性值集合")
    List<GoodsPropertyValue> goodsPropertyValues;
    @ApiModelProperty(value = "商品属性分类集合")
    List<GoodsPropertyCategory> goodsPropertyCategories;

    public List<GoodsPropertyValue> getGoodsPropertyValues() {
        return goodsPropertyValues;
    }

    public void setGoodsPropertyValues(List<GoodsPropertyValue> goodsPropertyValues) {
        this.goodsPropertyValues = goodsPropertyValues;
    }

    public List<GoodsPropertyCategory> getGoodsPropertyCategories() {
        return goodsPropertyCategories;
    }

    public void setGoodsPropertyCategories(List<GoodsPropertyCategory> goodsPropertyCategories) {
        this.goodsPropertyCategories = goodsPropertyCategories;
    }
}
