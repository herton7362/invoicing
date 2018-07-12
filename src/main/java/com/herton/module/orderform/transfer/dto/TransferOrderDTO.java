package com.herton.module.orderform.transfer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.dto.BaseDTO;
import com.herton.dto.Children;
import com.herton.module.orderform.transfer.domain.TransferOrder;
import com.herton.module.orderform.transfer.service.TransferOrderSkuService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Component
@ApiModel("送货单")
public class TransferOrderDTO extends BaseDTO<TransferOrderDTO, TransferOrder> {
    @ApiModelProperty(value = "订单号")
    private String orderNumber;
    @ApiModelProperty(value = "原始单据id")
    private String originOrderId;
    @ApiModelProperty(value = "原始单据号")
    private String originOrderNumber;
    @ApiModelProperty(value = "交货日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date transferredDate;
    @ApiModelProperty(value = "交货到仓库id")
    private String warehouseId;
    @ApiModelProperty(value = "供应商id")
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "订单状态")
    private TransferOrder.OrderStatus status;
    @Children(service = TransferOrderSkuService.class)
    @ApiModelProperty(value = "订单项目")
    private List<TransferOrderSkuDTO> items;
}
