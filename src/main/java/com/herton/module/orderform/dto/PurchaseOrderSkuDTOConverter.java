package com.herton.module.orderform.dto;

import com.herton.dto.DTOConverter;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderSkuDTOConverter extends DTOConverter<PurchaseOrderSkuDTO, PurchaseOrderSku> {
    @Override
    protected PurchaseOrderSku doForward(PurchaseOrderSkuDTO purchaseOrderSkuDTO) {
        PurchaseOrderSku purchaseOrderSku = new PurchaseOrderSku();
        BeanUtils.copyProperties(purchaseOrderSkuDTO, purchaseOrderSku);
        return purchaseOrderSku;
    }

    @Override
    protected PurchaseOrderSkuDTO doBackward(PurchaseOrderSku purchaseOrderSku) {
        PurchaseOrderSkuDTO purchaseOrderSkuDTO = new PurchaseOrderSkuDTO();
        BeanUtils.copyProperties(purchaseOrderSku, purchaseOrderSkuDTO);
        return purchaseOrderSkuDTO;
    }
}
