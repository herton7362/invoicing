package com.herton.module.orderform.purchase.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.orderform.purchase.domain.PurchaseOrderSku;
import com.herton.module.orderform.purchase.dto.PurchaseOrderSkuDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderSkuServiceImpl extends AbstractChildCrudService<PurchaseOrderSku, PurchaseOrderSkuDTO>
        implements PurchaseOrderSkuService {
}
