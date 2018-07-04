package com.herton.module.orderform.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderSkuDTOConverter extends SimpleDTOConverter<PurchaseOrderSkuDTO, PurchaseOrderSku> {
}
