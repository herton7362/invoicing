package com.herton.module.goods.property.web;

import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.domain.GoodsPropertyGroupProperty;
import com.herton.module.goods.property.domain.GoodsPropertyGroupPropertyValue;
import com.herton.module.goods.property.domain.GoodsPropertyValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品属性组")
public class GoodsPropertyGroupSaveParam extends GoodsPropertyGroup {
    @ApiModelProperty(value = "商品属性集合")
    private List<GoodsPropertyGroupPropertyParam> goodsPropertyGroupProperties;

    public List<GoodsPropertyGroupPropertyParam> getGoodsPropertyGroupProperties() {
        return goodsPropertyGroupProperties;
    }

    public void setGoodsPropertyGroupProperties(List<GoodsPropertyGroupPropertyParam> goodsPropertyGroupProperties) {
        this.goodsPropertyGroupProperties = goodsPropertyGroupProperties;
    }

    public static class GoodsPropertyGroupPropertyParam extends GoodsPropertyGroupProperty {
        private List<GoodsPropertyGroupPropertyValue> goodsPropertyGroupPropertyValues;

        public List<GoodsPropertyGroupPropertyValue> getGoodsPropertyGroupPropertyValues() {
            return goodsPropertyGroupPropertyValues;
        }

        public void setGoodsPropertyGroupPropertyValues(List<GoodsPropertyGroupPropertyValue> goodsPropertyGroupPropertyValues) {
            this.goodsPropertyGroupPropertyValues = goodsPropertyGroupPropertyValues;
        }
    }
}
