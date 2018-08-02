package com.herton.module.pos.orderform.dto;

import com.herton.dto.BaseDTO;
import com.herton.dto.Parent;
import com.herton.module.pos.orderform.domain.PosOrderSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ApiModel("pos订单sku")
public class PosOrderSkuDTO extends BaseDTO<PosOrderSkuDTO, PosOrderSku> {
    @Parent
    @ApiModelProperty("pos订单id")
    private String posOrderId;
    @ApiModelProperty("商品id")
    private String goodsId;
    @ApiModelProperty("sku id")
    private String skuId;
    @ApiModelProperty("数量")
    private Double count;
    @ApiModelProperty("单价")
    private Double price;
}
