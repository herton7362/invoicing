package com.herton.module.orderform.transfer.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.orderform.transfer.domain.TransferOrder;
import org.springframework.stereotype.Component;

@Component
public class TransferOrderDTOConverter extends SimpleDTOConverter<TransferOrderDTO, TransferOrder> {
}
