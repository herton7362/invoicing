package com.herton.module.orderform.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.domain.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderServiceImpl extends AbstractCrudService<PurchaseOrder> implements PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;
    @Override
    protected PageRepository<PurchaseOrder> getRepository() {
        return purchaseOrderRepository;
    }

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }
}
