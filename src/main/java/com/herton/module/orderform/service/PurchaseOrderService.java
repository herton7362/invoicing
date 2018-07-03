package com.herton.module.orderform.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.dto.PurchaseOrderDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderService extends CrudService<PurchaseOrder, PurchaseOrderDTO> {
}
