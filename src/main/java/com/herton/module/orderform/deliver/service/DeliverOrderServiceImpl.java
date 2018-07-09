package com.herton.module.orderform.deliver.service;

import com.herton.common.AbstractCrudService;
import com.herton.module.orderform.deliver.domain.DeliverOrder;
import com.herton.module.orderform.deliver.dto.DeliverOrderDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DeliverOrderServiceImpl extends AbstractCrudService<DeliverOrder, DeliverOrderDTO>
        implements DeliverOrderService {
}
