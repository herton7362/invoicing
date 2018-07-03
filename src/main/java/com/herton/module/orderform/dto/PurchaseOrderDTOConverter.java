package com.herton.module.orderform.dto;

import com.herton.dto.DTOConverter;
import com.herton.module.basicdata.businessrelatedunit.service.BusinessRelatedUnitService;
import com.herton.module.basicdata.warehouse.service.WarehouseService;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.service.PurchaseOrderSkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PurchaseOrderDTOConverter extends DTOConverter<PurchaseOrderDTO, PurchaseOrder> {
    @Autowired
    private PurchaseOrderSkuService purchaseOrderSkuService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private BusinessRelatedUnitService businessRelatedUnitService;
    @Override
    protected PurchaseOrder doForward(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(purchaseOrderDTO, purchaseOrder);
        if(purchaseOrderDTO.getWarehouse() != null)
            purchaseOrder.setWarehouseId(purchaseOrderDTO.getWarehouse().getId());
        if(purchaseOrderDTO.getBusinessRelatedUnit() != null)
            purchaseOrder.setBusinessRelatedUnitId(purchaseOrderDTO.getBusinessRelatedUnit().getId());
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
