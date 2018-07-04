package com.herton.module.orderform.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.businessrelatedunit.service.BusinessRelatedUnitService;
import com.herton.module.basicdata.warehouse.service.WarehouseService;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.service.PurchaseOrderSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class PurchaseOrderDTOConverter extends SimpleDTOConverter<PurchaseOrderDTO, PurchaseOrder> {
    @Autowired
    private PurchaseOrderSkuService purchaseOrderSkuService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private BusinessRelatedUnitService businessRelatedUnitService;
    @Override
    protected PurchaseOrder doForward(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = super.doForward(purchaseOrderDTO);
        if(purchaseOrderDTO.getWarehouse() != null)
            purchaseOrder.setWarehouseId(purchaseOrderDTO.getWarehouse().getId());
        if(purchaseOrderDTO.getBusinessRelatedUnit() != null)
            purchaseOrder.setBusinessRelatedUnitId(purchaseOrderDTO.getBusinessRelatedUnit().getId());
        return purchaseOrder;
    }

    @Override
    protected PurchaseOrderDTO doBackward(PurchaseOrder purchaseOrder) {
        PurchaseOrderDTO purchaseOrderDTO = super.doBackward(purchaseOrder);
        try {
            purchaseOrderDTO.setWarehouse(warehouseService.findOne(purchaseOrder.getWarehouseId()));
            purchaseOrderDTO.setBusinessRelatedUnit(businessRelatedUnitService.findOne(purchaseOrder.getBusinessRelatedUnitId()));
            Map<String, String> param = new HashMap<>();
            param.put("purchaseOrderId", purchaseOrderDTO.getId());
            purchaseOrderDTO.setItems(purchaseOrderSkuService.findAll(param));
        } catch (Exception e) {
            log.error("订单管理DTO转换出现错误", e);
        }
        return purchaseOrderDTO;
    }
}
