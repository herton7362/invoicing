package com.herton.module.pos.orderform.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.pos.orderform.domain.PosOrder;
import com.herton.module.pos.orderform.dto.PosOrderDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "pos订单管理")
@RestController
@RequestMapping("/api/posOrder")
public class PosOrderController extends AbstractCrudController<PosOrder, PosOrderDTO> {
}
