package com.herton.module.orderform.transfer.dto;

import com.herton.dto.BaseDTO;
import com.herton.dto.Parent;
import com.herton.module.orderform.transfer.domain.TransferOrderSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("送货sku")
public class TransferOrderSkuDTO extends BaseDTO<TransferOrderSkuDTO,TransferOrderSku> {
    @Parent
    @ApiModelProperty(value = "送货单id")
    private String transferOrderId;
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "sku id")
    private String skuId;
    @ApiModelProperty(value = "待配送数量")
    private Double needTransferCount;
    @ApiModelProperty(value = "已配送数量")
    private Double transferredCount;
}
