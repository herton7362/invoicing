package com.herton.module.orderform.dto;

import com.herton.dto.BaseDTO;
import com.herton.dto.DTOConverter;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Setter
@Getter
public class PurchaseOrderSkuDTO extends BaseDTO<PurchaseOrderSku> {
    @ApiModelProperty(value = "采购订单 id")
    private String purchaseOrderId;
    @ApiModelProperty(value = "商品 id")
    private String goodsId;
    @ApiModelProperty(value = "sku id")
    private String skuId;
    @ApiModelProperty(value = "数量")
    private Double count;
    @ApiModelProperty(value = "单价")
    private Double price;
    @ApiModelProperty(value = "金额")
    private Double sumPrice;
    @ApiModelProperty(value = "备注")
    private Double remark;
    @Override
    public PurchaseOrderSku convert() {
        PurchaseOrderSkuDTOConverter purchaseOrderSkuDTOConverter = new PurchaseOrderSkuDTOConverter();
        return purchaseOrderSkuDTOConverter.convert(this);
    }

    @Override
    public PurchaseOrderSkuDTO convertFor(PurchaseOrderSku purchaseOrderSku) {
        PurchaseOrderSkuDTOConverter purchaseOrderSkuDTOConverter = new PurchaseOrderSkuDTOConverter();
        return purchaseOrderSkuDTOConverter.reverse().convert(purchaseOrderSku);
    }

    @Component
    private static class PurchaseOrderSkuDTOConverter extends DTOConverter<PurchaseOrderSkuDTO, PurchaseOrderSku> {
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
}
