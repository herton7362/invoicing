package com.herton.module.goods.web;

import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.domain.GoodsImage;
import com.herton.module.goods.domain.GoodsPrice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品保存")
public class GoodsSaveParam extends Goods {
    @ApiModelProperty(value = "基本商品价格")
    private GoodsPriceParam basicGoodsPriceParam;
    @ApiModelProperty(value = "辅助商品价格1")
    private GoodsPriceParam assistGoodsPriceParam1;
    @ApiModelProperty(value = "辅助商品价格2")
    private GoodsPriceParam assistGoodsPriceParam2;
    @ApiModelProperty(value = "商品图片")
    private List<GoodsImageParam> goodsImageParams;

    public static class GoodsPriceParam extends GoodsPrice {

    }

    public static class GoodsImageParam extends GoodsImage {

    }

    public GoodsPriceParam getBasicGoodsPriceParam() {
        return basicGoodsPriceParam;
    }

    public void setBasicGoodsPriceParam(GoodsPriceParam basicGoodsPriceParam) {
        this.basicGoodsPriceParam = basicGoodsPriceParam;
    }

    public GoodsPriceParam getAssistGoodsPriceParam1() {
        return assistGoodsPriceParam1;
    }

    public void setAssistGoodsPriceParam1(GoodsPriceParam assistGoodsPriceParam1) {
        this.assistGoodsPriceParam1 = assistGoodsPriceParam1;
    }

    public GoodsPriceParam getAssistGoodsPriceParam2() {
        return assistGoodsPriceParam2;
    }

    public void setAssistGoodsPriceParam2(GoodsPriceParam assistGoodsPriceParam2) {
        this.assistGoodsPriceParam2 = assistGoodsPriceParam2;
    }

    public List<GoodsImageParam> getGoodsImageParams() {
        return goodsImageParams;
    }

    public void setGoodsImageParams(List<GoodsImageParam> goodsImageParams) {
        this.goodsImageParams = goodsImageParams;
    }
}
