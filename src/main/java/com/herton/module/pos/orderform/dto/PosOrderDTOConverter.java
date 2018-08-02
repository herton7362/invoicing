package com.herton.module.pos.orderform.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.pos.orderform.domain.PosOrder;
import org.springframework.stereotype.Component;

@Component
public class PosOrderDTOConverter extends SimpleDTOConverter<PosOrderDTO, PosOrder> {
}
