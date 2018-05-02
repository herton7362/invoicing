package com.herton.module.orderform.web;

import com.herton.module.goods.sku.web.GoodsSkuResult;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("采购订单结果")
public class PurchaseOrderResult extends PurchaseOrder {
    @ApiModelProperty(value = "采购订单的sku")
    private List<PurchaseOrderSkuResult> skus;

    public List<PurchaseOrderSkuResult> getSkus() {
        return skus;
    }

    public void setSkus(List<PurchaseOrderSkuResult> skus) {
        this.skus = skus;
    }

    @ApiModel("采购订单sku结果")
    public static class PurchaseOrderSkuResult extends PurchaseOrderSku {
        @ApiModelProperty(value = "商品")
        private GoodsSkuResult goodsSku;

        public GoodsSkuResult getGoodsSku() {
            return goodsSku;
        }

        public void setGoodsSku(GoodsSkuResult goodsSku) {
            this.goodsSku = goodsSku;
        }
    }
}
