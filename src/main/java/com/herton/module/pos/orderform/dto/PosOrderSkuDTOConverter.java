package com.herton.module.pos.orderform.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.pos.orderform.domain.PosOrderSku;
import org.springframework.stereotype.Component;

@Component
public class PosOrderSkuDTOConverter extends SimpleDTOConverter<PosOrderSkuDTO, PosOrderSku> {
}
