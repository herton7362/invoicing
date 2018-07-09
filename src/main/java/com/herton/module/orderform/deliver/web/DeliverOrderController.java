package com.herton.module.orderform.deliver.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.orderform.deliver.domain.DeliverOrder;
import com.herton.module.orderform.deliver.dto.DeliverOrderDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("送货单管理")
@RestController
@RequestMapping("/api/deliverOrder")
public class DeliverOrderController extends AbstractCrudController<DeliverOrder, DeliverOrderDTO> {
}
