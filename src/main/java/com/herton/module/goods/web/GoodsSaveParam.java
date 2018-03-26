package com.herton.module.goods.web;

import com.herton.module.goods.domain.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品保存")
public class GoodsSaveParam extends Goods {
    @ApiModelProperty(value = "基本商品价格")
    private GoodsPriceParam basicGoodsPrice;
    @ApiModelProperty(value = "辅助商品价格1")
    private GoodsPriceParam assistGoodsPrice1;
    @ApiModelProperty(value = "辅助商品价格2")
    private GoodsPriceParam assistGoodsPrice2;
    @ApiModelProperty(value = "商品封面图片")
    private GoodsImageParam goodsCoverImage;
    @ApiModelProperty(value = "商品附图1")
    private GoodsImageParam goodsAttached1Image;
    @ApiModelProperty(value = "商品附图2")
    private GoodsImageParam goodsAttached2Image;
    @ApiModelProperty(value = "商品附图3")
    private GoodsImageParam goodsAttached3Image;
    @ApiModelProperty(value = "商品附图4")
    private GoodsImageParam goodsAttached4Image;
    @ApiModelProperty(value = "商品属性集合")
    private List<GoodsGoodsPropertyParam> goodsGoodsProperties;

    public GoodsPriceParam getBasicGoodsPrice() {
        return basicGoodsPrice;
    }

    public void setBasicGoodsPrice(GoodsPriceParam basicGoodsPrice) {
        this.basicGoodsPrice = basicGoodsPrice;
    }

    public GoodsPriceParam getAssistGoodsPrice1() {
        return assistGoodsPrice1;
    }

    public void setAssistGoodsPrice1(GoodsPriceParam assistGoodsPrice1) {
        this.assistGoodsPrice1 = assistGoodsPrice1;
    }

    public GoodsPriceParam getAssistGoodsPrice2() {
        return assistGoodsPrice2;
    }

    public void setAssistGoodsPrice2(GoodsPriceParam assistGoodsPrice2) {
        this.assistGoodsPrice2 = assistGoodsPrice2;
    }

    public GoodsImageParam getGoodsCoverImage() {
        return goodsCoverImage;
    }

    public void setGoodsCoverImage(GoodsImageParam goodsCoverImage) {
        this.goodsCoverImage = goodsCoverImage;
    }

    public GoodsImageParam getGoodsAttached1Image() {
        return goodsAttached1Image;
    }

    public void setGoodsAttached1Image(GoodsImageParam goodsAttached1Image) {
        this.goodsAttached1Image = goodsAttached1Image;
    }

    public GoodsImageParam getGoodsAttached2Image() {
        return goodsAttached2Image;
    }

    public void setGoodsAttached2Image(GoodsImageParam goodsAttached2Image) {
        this.goodsAttached2Image = goodsAttached2Image;
    }

    public GoodsImageParam getGoodsAttached3Image() {
        return goodsAttached3Image;
    }

    public void setGoodsAttached3Image(GoodsImageParam goodsAttached3Image) {
        this.goodsAttached3Image = goodsAttached3Image;
    }

    public GoodsImageParam getGoodsAttached4Image() {
        return goodsAttached4Image;
    }

    public void setGoodsAttached4Image(GoodsImageParam goodsAttached4Image) {
        this.goodsAttached4Image = goodsAttached4Image;
    }

    public List<GoodsGoodsPropertyParam> getGoodsGoodsProperties() {
        return goodsGoodsProperties;
    }

    public void setGoodsGoodsProperties(List<GoodsGoodsPropertyParam> goodsGoodsProperties) {
        this.goodsGoodsProperties = goodsGoodsProperties;
    }

    public static class GoodsPriceParam extends GoodsPrice {

    }

    public static class GoodsImageParam extends GoodsImage {

    }

    public static class GoodsGoodsPropertyParam extends GoodsGoodsProperty {
        @ApiModelProperty(value = "商品属性值id集合")
        private List<GoodsGoodsPropertyValue> goodsGoodsPropertyValues;

        public List<GoodsGoodsPropertyValue> getGoodsGoodsPropertyValues() {
            return goodsGoodsPropertyValues;
        }

        public void setGoodsGoodsPropertyValues(List<GoodsGoodsPropertyValue> goodsGoodsPropertyValues) {
            this.goodsGoodsPropertyValues = goodsGoodsPropertyValues;
        }
    }
}
