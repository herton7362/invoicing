package com.herton.module.goods.sku.web;

import com.herton.module.goods.property.domain.GoodsPropertyValue;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.web.GoodsResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品sku查询结果")
public class GoodsSkuResult extends GoodsSku {
    @ApiModelProperty(value = "商品")
    private GoodsResult goods;
    @ApiModelProperty(value = "属性值")
    private List<GoodsPropertyValue> goodsPropertyValues;

    public GoodsResult getGoods() {
        return goods;
    }

    public void setGoods(GoodsResult goods) {
        this.goods = goods;
    }

    public List<GoodsPropertyValue> getGoodsPropertyValues() {
        return goodsPropertyValues;
    }

    public void setGoodsPropertyValues(List<GoodsPropertyValue> goodsPropertyValues) {
        this.goodsPropertyValues = goodsPropertyValues;
    }
}
