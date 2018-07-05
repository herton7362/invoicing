package com.herton.module.goods.dto;

import com.herton.common.utils.StringUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.ParentField;
import com.herton.module.goods.domain.GoodsSupplier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("商品供应商")
public class GoodsSupplierDTO extends BaseDTO<GoodsSupplierDTO, GoodsSupplier> {
    @ParentField
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "供应商")
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "最少数量")
    private Double minimumCount;
    @ApiModelProperty(value = "单价")
    private Double price;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof GoodsSupplierDTO)) {
            return false;
        }
        GoodsSupplierDTO dto = (GoodsSupplierDTO) obj;
        if(StringUtils.isNotBlank(this.getBusinessRelatedUnitId()) && StringUtils.isNotBlank(this.getGoodsId())) {
            return this.getBusinessRelatedUnitId().equals(dto.getBusinessRelatedUnitId())
                    && this.getGoodsId().equals(dto.getGoodsId());
        }
        return super.equals(obj);
    }
}
