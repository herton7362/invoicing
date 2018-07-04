package com.herton.module.orderform.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.domain.PurchaseOrderSkuRepository;
import com.herton.module.orderform.dto.PurchaseOrderSkuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderSkuServiceImpl extends AbstractCrudService<PurchaseOrderSku, PurchaseOrderSkuDTO>
        implements PurchaseOrderSkuService {
}
