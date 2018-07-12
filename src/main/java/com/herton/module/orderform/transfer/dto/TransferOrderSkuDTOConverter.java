package com.herton.module.orderform.transfer.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.orderform.transfer.domain.TransferOrderSku;
import org.springframework.stereotype.Component;

@Component
public class TransferOrderSkuDTOConverter extends SimpleDTOConverter<TransferOrderSkuDTO, TransferOrderSku> {
}
