package com.herton.module.orderform.deliver.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.orderform.deliver.domain.DeliverOrder;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("送货单")
public class DeliverOrderDTO extends BaseDTO<DeliverOrderDTO, DeliverOrder> {
}
