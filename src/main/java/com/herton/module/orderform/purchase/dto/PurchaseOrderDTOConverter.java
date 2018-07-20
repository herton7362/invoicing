package com.herton.module.orderform.purchase.dto;

import com.herton.common.utils.StringUtils;
import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.businessrelatedunit.service.BusinessRelatedUnitService;
import com.herton.module.basicdata.warehouse.service.WarehouseService;
import com.herton.module.orderform.purchase.domain.PurchaseOrder;
import com.herton.module.orderform.purchase.service.PurchaseOrderSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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
    protected PurchaseOrderDTO doBackward(PurchaseOrder purchaseOrder) {
        PurchaseOrderDTO purchaseOrderDTO = super.doBackward(purchaseOrder);
        if(StringUtils.isNotBlank(purchaseOrder.getWarehouseId())) {
            purchaseOrderDTO.setWarehouse(warehouseService.findOne(purchaseOrder.getWarehouseId()));
        }
        if(StringUtils.isNotBlank(purchaseOrder.getBusinessRelatedUnitId())) {
            purchaseOrderDTO.setBusinessRelatedUnit(businessRelatedUnitService.findOne(purchaseOrder.getBusinessRelatedUnitId()));
        }
        Map<String, String> param = new HashMap<>();
        param.put("purchaseOrderId", purchaseOrderDTO.getId());
        purchaseOrderDTO.setItems(purchaseOrderSkuService.findAll(param));
        purchaseOrderDTO.setSumPrice(purchaseOrderDTO
                .getItems()
                .stream()
                .map(item -> item.getSumPrice())
                .reduce(0D, (sum, item) -> sum + item));
        return purchaseOrderDTO;
    }
}
