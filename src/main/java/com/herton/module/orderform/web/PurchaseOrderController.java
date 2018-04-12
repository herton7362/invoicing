package com.herton.module.orderform.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderController extends AbstractCrudController<PurchaseOrder> {
    private final PurchaseOrderService purchaseOrderService;
    @Override
    protected CrudService<PurchaseOrder> getService() {
        return purchaseOrderService;
    }

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }
}
