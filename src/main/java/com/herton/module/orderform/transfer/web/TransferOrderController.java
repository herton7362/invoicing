package com.herton.module.orderform.transfer.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.orderform.transfer.domain.TransferOrder;
import com.herton.module.orderform.transfer.dto.TransferOrderDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("送货单管理")
@RestController
@RequestMapping("/api/transferOrder")
public class TransferOrderController extends AbstractCrudController<TransferOrder, TransferOrderDTO> {
}
