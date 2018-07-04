package com.herton.module.goods.dto;

import com.herton.dto.BaseDTO;
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
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "供应商")
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "最少数量")
    private Double minimumCount;
    @ApiModelProperty(value = "单价")
    private Double price;
}
