package com.herton.module.orderform.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.service.PurchaseOrderSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "采购订单商品管理")
@RestController
@RequestMapping("/api/purchaseOrderSku")
public class PurchaseOrderSkuController extends AbstractCrudController<PurchaseOrderSku> {
}
