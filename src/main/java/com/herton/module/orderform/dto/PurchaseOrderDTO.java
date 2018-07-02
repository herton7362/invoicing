package com.herton.module.orderform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.common.utils.SpringUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.DTOConverter;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import com.herton.module.basicdata.businessrelatedunit.service.BusinessRelatedUnitService;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import com.herton.module.basicdata.warehouse.service.WarehouseService;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.service.PurchaseOrderSkuService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.*;

@Setter
@Getter
@ApiModel("采购订单")
public class PurchaseOrderDTO extends BaseDTO<PurchaseOrder> {
    @ApiModelProperty(value = "主键")
    private String id;
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
    @ApiModelProperty(value = "交货到")
    private Warehouse warehouse;
    @ApiModelProperty(value = "供应商")
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "供应商")
    private BusinessRelatedUnit businessRelatedUnit;
    @ApiModelProperty(value = "订单状态")
    private PurchaseOrder.OrderStatus status;
    @ApiModelProperty(value = "订单项目")
    private List<PurchaseOrderSkuDTO> items;

    @Override
    public PurchaseOrder convert(){
        PurchaseOrderDTOConverter purchaseOrderDTOConverter = new PurchaseOrderDTOConverter();
        return purchaseOrderDTOConverter.convert(this);
    }

    @Override
    public PurchaseOrderDTO convertFor(PurchaseOrder purchaseOrder){
        PurchaseOrderDTOConverter purchaseOrderDTOConverter = new PurchaseOrderDTOConverter();
        return purchaseOrderDTOConverter.reverse().convert(purchaseOrder);
    }

    @Component
    private static class PurchaseOrderDTOConverter extends DTOConverter<PurchaseOrderDTO, PurchaseOrder> {
        private PurchaseOrderSkuService purchaseOrderSkuService = SpringUtils.getBean(PurchaseOrderSkuService.class);
        private WarehouseService warehouseService = SpringUtils.getBean(WarehouseService.class);
        private BusinessRelatedUnitService businessRelatedUnitService = SpringUtils.getBean(BusinessRelatedUnitService.class);
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
            try {
                purchaseOrderDTO.setWarehouse(warehouseService.findOne(purchaseOrder.getWarehouseId()));
                purchaseOrderDTO.setBusinessRelatedUnit(businessRelatedUnitService.findOne(purchaseOrder.getBusinessRelatedUnitId()));
                Map<String, String> param = new HashMap<>();
                param.put("purchaseOrderId", purchaseOrderDTO.getId());
                List<PurchaseOrderSku> purchaseOrderSkuList = purchaseOrderSkuService.findAll(param);
                List<PurchaseOrderSkuDTO> purchaseOrderSkuDTOList = new ArrayList<>();
                purchaseOrderSkuList.forEach(purchaseOrderSku ->
                        purchaseOrderSkuDTOList.add(new PurchaseOrderSkuDTO().convertFor(purchaseOrderSku)));
                purchaseOrderDTO.setItems(purchaseOrderSkuDTOList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return purchaseOrderDTO;
        }
    }
}
