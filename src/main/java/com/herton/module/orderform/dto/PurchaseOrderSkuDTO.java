package com.herton.module.orderform.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseOrderSkuDTO extends BaseDTO<PurchaseOrderSku> {
    @Override
    public PurchaseOrderSku convert() {
        return null;
    }

    @Override
    public BaseDTO convertFor(PurchaseOrderSku purchaseOrderSku) {
        return null;
    }
}
