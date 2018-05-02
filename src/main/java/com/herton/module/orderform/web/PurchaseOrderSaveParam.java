package com.herton.module.orderform.web;

import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("采购订单保存参数")
public class PurchaseOrderSaveParam extends PurchaseOrder {
    @ApiModelProperty(value = "订单商品")
    private List<PurchaseOrderSku> purchaseOrderSkus;

    public List<PurchaseOrderSku> getPurchaseOrderSkus() {
        return purchaseOrderSkus;
    }

    public void setPurchaseOrderSkus(List<PurchaseOrderSku> purchaseOrderSkus) {
        this.purchaseOrderSkus = purchaseOrderSkus;
    }
}
