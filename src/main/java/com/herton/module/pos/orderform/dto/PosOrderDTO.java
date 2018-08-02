package com.herton.module.pos.orderform.dto;

import com.herton.dto.BaseDTO;
import com.herton.dto.Children;
import com.herton.module.pos.orderform.domain.PosOrder;
import com.herton.module.pos.orderform.service.PosOrderSkuService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ApiModel("pos订单")
public class PosOrderDTO extends BaseDTO<PosOrderDTO, PosOrder> {
    @ApiModelProperty("订单号")
    private String orderNumber;
    @ApiModelProperty("操作员id")
    private String operator;
    @ApiModelProperty("会话id")
    private String posSessionId;
    @ApiModelProperty("状态")
    private PosOrder.OrderStatus status;

    @ApiModelProperty("条目")
    @Children(service = PosOrderSkuService.class)
    private List<PosOrderSkuDTO> items;
}
