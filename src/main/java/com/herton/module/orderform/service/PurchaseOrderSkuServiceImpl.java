package com.herton.module.orderform.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.domain.PurchaseOrderSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderSkuServiceImpl extends AbstractCrudService<PurchaseOrderSku> implements PurchaseOrderSkuService {
    private final PurchaseOrderSkuRepository purchaseOrderSkuRepository;
    @Override
    protected PageRepository<PurchaseOrderSku> getRepository() {
        return purchaseOrderSkuRepository;
    }

    @Autowired
    public PurchaseOrderSkuServiceImpl(PurchaseOrderSkuRepository purchaseOrderGoodsRepository) {
        this.purchaseOrderSkuRepository = purchaseOrderGoodsRepository;
    }
}
