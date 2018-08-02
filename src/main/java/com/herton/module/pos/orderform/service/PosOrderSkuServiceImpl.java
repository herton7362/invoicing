package com.herton.module.pos.orderform.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.pos.orderform.domain.PosOrderSku;
import com.herton.module.pos.orderform.dto.PosOrderSkuDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PosOrderSkuServiceImpl extends AbstractChildCrudService<PosOrderSku, PosOrderSkuDTO>
        implements PosOrderSkuService {
}
