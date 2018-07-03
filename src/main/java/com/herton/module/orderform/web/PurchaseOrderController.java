package com.herton.module.orderform.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.PageParam;
import com.herton.common.PageResult;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.dto.PurchaseOrderDTO;
import com.herton.module.orderform.service.PurchaseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "采购订单单管理")
@RestController
@RequestMapping("/api/purchaseOrder")
public class PurchaseOrderController extends AbstractCrudController<PurchaseOrder, PurchaseOrderDTO> {
}
