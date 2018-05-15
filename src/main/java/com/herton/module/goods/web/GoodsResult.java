package com.herton.module.goods.web;

import com.herton.module.goods.domain.*;
import com.herton.module.goods.sku.domain.GoodsSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品查询结果")
public class GoodsResult extends Goods {
    @ApiModelProperty(value = "基本商品价格")
    private GoodsPriceResult basicGoodsPrice;
    @ApiModelProperty(value = "辅助商品价格1")
    private GoodsPriceResult assistGoodsPrice1;
    @ApiModelProperty(value = "辅助商品价格2")
    private GoodsPriceResult assistGoodsPrice2;
    @ApiModelProperty(value = "商品封面图片")
    private GoodsImageResult goodsCoverImage;
    @ApiModelProperty(value = "商品附图1")
    private GoodsImageResult goodsAttached1Image;
    @ApiModelProperty(value = "商品附图2")
    private GoodsImageResult goodsAttached2Image;
    @ApiModelProperty(value = "商品附图3")
    private GoodsImageResult goodsAttached3Image;
    @ApiModelProperty(value = "商品附图4")
    private GoodsImageResult goodsAttached4Image;
    @ApiModelProperty(value = "商品属性")
    private List<GoodsAttribute> goodsAttributes;
    @ApiModelProperty(value = "商品sku")
    private List<GoodsSkuParam> goodsSkus;

    public GoodsPriceResult getBasicGoodsPrice() {
        return basicGoodsPrice;
    }

    public void setBasicGoodsPrice(GoodsPriceResult basicGoodsPrice) {
        this.basicGoodsPrice = basicGoodsPrice;
    }

    public GoodsPriceResult getAssistGoodsPrice1() {
        return assistGoodsPrice1;
    }

    public void setAssistGoodsPrice1(GoodsPriceResult assistGoodsPrice1) {
        this.assistGoodsPrice1 = assistGoodsPrice1;
    }

    public GoodsPriceResult getAssistGoodsPrice2() {
        return assistGoodsPrice2;
    }

    public void setAssistGoodsPrice2(GoodsPriceResult assistGoodsPrice2) {
        this.assistGoodsPrice2 = assistGoodsPrice2;
    }

    public GoodsImageResult getGoodsCoverImage() {
        return goodsCoverImage;
    }

    public void setGoodsCoverImage(GoodsImageResult goodsCoverImage) {
        this.goodsCoverImage = goodsCoverImage;
    }

    public GoodsImageResult getGoodsAttached1Image() {
        return goodsAttached1Image;
    }

    public void setGoodsAttached1Image(GoodsImageResult goodsAttached1Image) {
        this.goodsAttached1Image = goodsAttached1Image;
    }

    public GoodsImageResult getGoodsAttached2Image() {
        return goodsAttached2Image;
    }

    public void setGoodsAttached2Image(GoodsImageResult goodsAttached2Image) {
        this.goodsAttached2Image = goodsAttached2Image;
    }

    public GoodsImageResult getGoodsAttached3Image() {
        return goodsAttached3Image;
    }

    public void setGoodsAttached3Image(GoodsImageResult goodsAttached3Image) {
        this.goodsAttached3Image = goodsAttached3Image;
    }

    public GoodsImageResult getGoodsAttached4Image() {
        return goodsAttached4Image;
    }

    public void setGoodsAttached4Image(GoodsImageResult goodsAttached4Image) {
        this.goodsAttached4Image = goodsAttached4Image;
    }

    public List<GoodsAttribute> getGoodsAttributes() {
        return goodsAttributes;
    }

    public void setGoodsAttributes(List<GoodsAttribute> goodsAttributes) {
        this.goodsAttributes = goodsAttributes;
    }

    public List<GoodsSkuParam> getGoodsSkus() {
        return goodsSkus;
    }

    public void setGoodsSkus(List<GoodsSkuParam> goodsSkus) {
        this.goodsSkus = goodsSkus;
    }

    public static class GoodsPriceResult extends GoodsPrice {

    }

    public static class GoodsImageResult extends GoodsImage {

    }

    @ApiModel("商品sku")
    public static class GoodsSkuParam extends GoodsSku {
        @ApiModelProperty("商品属性值，用逗号分隔")
        private String goodsAttributeValues;

        public String getGoodsAttributeValues() {
            return goodsAttributeValues;
        }

        public void setGoodsAttributeValues(String goodsAttributeValues) {
            this.goodsAttributeValues = goodsAttributeValues;
        }
    }
}
