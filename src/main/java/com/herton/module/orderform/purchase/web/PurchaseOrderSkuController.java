package com.herton.module.orderform.purchase.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.orderform.purchase.domain.PurchaseOrderSku;
import com.herton.module.orderform.purchase.dto.PurchaseOrderSkuDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "采购订单商品管理")
@RestController
@RequestMapping("/api/purchaseOrderSku")
public class PurchaseOrderSkuController extends AbstractCrudController<PurchaseOrderSku, PurchaseOrderSkuDTO> {
}
