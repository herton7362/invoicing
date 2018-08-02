package com.herton.module.orderform.purchase.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.orderform.purchase.domain.PurchaseOrder;
import com.herton.module.orderform.purchase.dto.PurchaseOrderDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(value = "采购订单管理")
@RestController
@RequestMapping("/api/purchaseOrder")
public class PurchaseOrderController extends AbstractCrudController<PurchaseOrder, PurchaseOrderDTO> {
}
