package com.herton.module.orderform.purchase.dto;

import com.herton.common.utils.StringUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.Parent;
import com.herton.module.goods.domain.Goods;
import com.herton.module.orderform.purchase.domain.PurchaseOrderSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("采购订单商品")
public class PurchaseOrderSkuDTO extends BaseDTO<PurchaseOrderSkuDTO, PurchaseOrderSku> {
    @Parent
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

    @ApiModelProperty(value = "商品")
    private Goods goods;
    @ApiModelProperty(value = "规格")
    private String attributeName;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PurchaseOrderSkuDTO)) {
            return false;
        }
        PurchaseOrderSkuDTO dto = (PurchaseOrderSkuDTO) obj;
        if(StringUtils.isNotBlank(this.getSkuId())
                && StringUtils.isNotBlank(this.getGoodsId())) {
            return this.getSkuId().equals(dto.getSkuId())
                    && this.getGoodsId().equals(dto.getGoodsId());
        }
        return super.equals(obj);
    }
}
