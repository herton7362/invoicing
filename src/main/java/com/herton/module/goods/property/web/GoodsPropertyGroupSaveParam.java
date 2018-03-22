package com.herton.module.goods.property.web;

import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品属性组")
public class GoodsPropertyGroupSaveParam extends GoodsPropertyGroup {
    @ApiModelProperty(value = "商品属性id集合")
    private List<String> goodsPropertyIds;
    @ApiModelProperty(value = "商品属性值id集合")
    private List<String> goodsPropertyValueIds;

    public List<String> getGoodsPropertyIds() {
        return goodsPropertyIds;
    }

    public void setGoodsPropertyIds(List<String> goodsPropertyIds) {
        this.goodsPropertyIds = goodsPropertyIds;
    }

    public List<String> getGoodsPropertyValueIds() {
        return goodsPropertyValueIds;
    }

    public void setGoodsPropertyValueIds(List<String> goodsPropertyValueIds) {
        this.goodsPropertyValueIds = goodsPropertyValueIds;
    }
}
