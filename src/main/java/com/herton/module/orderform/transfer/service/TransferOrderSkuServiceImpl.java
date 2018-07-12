package com.herton.module.orderform.transfer.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.orderform.transfer.domain.TransferOrderSku;
import com.herton.module.orderform.transfer.dto.TransferOrderSkuDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TransferOrderSkuServiceImpl extends AbstractChildCrudService<TransferOrderSku, TransferOrderSkuDTO>
        implements TransferOrderSkuService {
}
