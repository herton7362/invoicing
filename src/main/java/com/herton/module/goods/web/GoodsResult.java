package com.herton.module.goods.web;

import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.sku.domain.GoodsSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品查询结果")
public class GoodsResult extends Goods {
    @ApiModelProperty(value = "商品属性")
    private List<GoodsAttribute> goodsAttributes;
    @ApiModelProperty(value = "商品sku")
    private List<GoodsSkuResult> goodsSkus;

    public List<GoodsAttribute> getGoodsAttributes() {
        return goodsAttributes;
    }

    public void setGoodsAttributes(List<GoodsAttribute> goodsAttributes) {
        this.goodsAttributes = goodsAttributes;
    }

    public List<GoodsSkuResult> getGoodsSkus() {
        return goodsSkus;
    }

    public void setGoodsSkus(List<GoodsSkuResult> goodsSkus) {
        this.goodsSkus = goodsSkus;
    }

    @ApiModel("商品sku")
    public static class GoodsSkuResult extends GoodsSku {
        @ApiModelProperty("商品属性值，用逗号分隔")
        private String goodsAttributes;

        public String getGoodsAttributes() {
            return goodsAttributes;
        }

        public void setGoodsAttributes(String goodsAttributes) {
            this.goodsAttributes = goodsAttributes;
        }
    }
}
