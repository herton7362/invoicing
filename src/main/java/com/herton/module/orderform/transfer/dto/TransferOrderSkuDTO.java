package com.herton.module.orderform.transfer.dto;

import com.herton.common.utils.StringUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.Parent;
import com.herton.module.goods.domain.Goods;
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

    @ApiModelProperty(value = "商品")
    private Goods goods;
    @ApiModelProperty(value = "规格")
    private String attributeName;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TransferOrderSkuDTO)) {
            return false;
        }
        TransferOrderSkuDTO dto = (TransferOrderSkuDTO) obj;
        if(StringUtils.isNotBlank(this.getSkuId())
                && StringUtils.isNotBlank(this.getGoodsId())) {
            return this.getSkuId().equals(dto.getSkuId())
                    && this.getGoodsId().equals(dto.getGoodsId());
        }
        return super.equals(obj);
    }
}
