package com.herton.module.orderform.deliver.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.orderform.deliver.domain.DeliverOrder;
import org.springframework.stereotype.Component;

@Component
public class DeliverOrderDTOConverter extends SimpleDTOConverter<DeliverOrderDTO, DeliverOrder> {
}
