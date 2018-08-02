package com.herton.module.pos.orderform.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.pos.orderform.domain.PosOrder;
import com.herton.module.pos.orderform.dto.PosOrderDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PosOrderServiceImpl extends AbstractChildCrudService<PosOrder, PosOrderDTO> implements PosOrderService {
}
