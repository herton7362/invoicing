package com.herton.module.orderform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.dto.BaseDTO;
import com.herton.dto.DTOConverter;
import com.herton.module.orderform.domain.PurchaseOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Setter
@Getter
@ApiModel("采购订单")
public class PurchaseOrderDTO extends BaseDTO<PurchaseOrder> {
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
    @ApiModelProperty(value = "交货到")
    private String warehouseId;
    @ApiModelProperty(value = "供应商")
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "订单状态")
    private PurchaseOrder.OrderStatus status;

    @Override
    public PurchaseOrder convert(){
        PurchaseOrderDTOConverter purchaseOrderDTOConverter = new PurchaseOrderDTOConverter();
        PurchaseOrder convert = purchaseOrderDTOConverter.convert(this);
        return convert;
    }

    @Override
    public PurchaseOrderDTO convertFor(PurchaseOrder purchaseOrder){
        PurchaseOrderDTOConverter purchaseOrderDTOConverter = new PurchaseOrderDTOConverter();
        PurchaseOrderDTO convert = purchaseOrderDTOConverter.reverse().convert(purchaseOrder);
        return convert;
    }

    private static class PurchaseOrderDTOConverter extends DTOConverter<PurchaseOrderDTO, PurchaseOrder> {
        @Override
        protected PurchaseOrder doForward(PurchaseOrderDTO purchaseOrderDTO) {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            BeanUtils.copyProperties(purchaseOrderDTO, purchaseOrder);
            return purchaseOrder;
        }

        @Override
        protected PurchaseOrderDTO doBackward(PurchaseOrder purchaseOrder) {
            PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
            BeanUtils.copyProperties(purchaseOrder, purchaseOrderDTO);
            return purchaseOrderDTO;
        }
    }
}
