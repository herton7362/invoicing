package com.herton.module.orderform.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.dto.PurchaseOrderSkuDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderSkuServiceImpl extends AbstractChildCrudService<PurchaseOrderSku, PurchaseOrderSkuDTO>
        implements PurchaseOrderSkuService {
}
