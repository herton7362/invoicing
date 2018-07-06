package com.herton.module.orderform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.dto.BaseDTO;
import com.herton.dto.Children;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import com.herton.module.basicdata.businessrelatedunit.dto.BusinessRelatedUnitDTO;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import com.herton.module.basicdata.warehouse.dto.WarehouseDTO;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.service.PurchaseOrderSkuService;
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
@ApiModel("采购订单")
public class PurchaseOrderDTO extends BaseDTO<PurchaseOrderDTO, PurchaseOrder> {
    @ApiModelProperty(value = "订单号")
    private String orderNumber;
    @ApiModelProperty(value = "经手人")
    private String operator;
    @ApiModelProperty(value = "预定交货日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date deliveryDate;
    @ApiModelProperty(value = "摘要")
    private String summary;
    @ApiModelProperty(value = "附加说明")
    private String remark;
    @ApiModelProperty(value = "交货到仓库id")
    private String warehouseId;
    @ApiModelProperty(value = "交货到仓库")
    private WarehouseDTO warehouse;
    @ApiModelProperty(value = "供应商id")
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "供应商")
    private BusinessRelatedUnitDTO businessRelatedUnit;
    @ApiModelProperty(value = "订单状态")
    private PurchaseOrder.OrderStatus status;
    @Children(service = PurchaseOrderSkuService.class)
    @ApiModelProperty(value = "订单项目")
    private List<PurchaseOrderSkuDTO> items;
}
