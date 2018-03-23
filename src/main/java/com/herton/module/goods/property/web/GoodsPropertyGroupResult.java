package com.herton.module.goods.property.web;

import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.domain.GoodsPropertyValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品属性组")
public class GoodsPropertyGroupResult extends GoodsPropertyGroup {
    @ApiModelProperty(value = "商品属性id集合")
    private List<String> goodsPropertyIds;
    @ApiModelProperty(value = "商品属性值id集合")
    private List<String> goodsPropertyValueIds;
    @ApiModelProperty(value = "商品属性集合")
    private List<GoodsPropertyResult> goodsPropertyResults;

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

    public List<GoodsPropertyResult> getGoodsPropertyResults() {
        return goodsPropertyResults;
    }

    public void setGoodsPropertyResults(List<GoodsPropertyResult> goodsPropertyResults) {
        this.goodsPropertyResults = goodsPropertyResults;
    }

    @ApiModel("商品属性")
    public static class GoodsPropertyResult extends GoodsProperty {
        private List<GoodsPropertyValueResult> goodsPropertyValueResults;

        public List<GoodsPropertyValueResult> getGoodsPropertyValueResults() {
            return goodsPropertyValueResults;
        }

        public void setGoodsPropertyValueResults(List<GoodsPropertyValueResult> goodsPropertyValueResults) {
            this.goodsPropertyValueResults = goodsPropertyValueResults;
        }
    }

    @ApiModel("商品属性值")
    public static class GoodsPropertyValueResult extends GoodsPropertyValue {

    }
}
