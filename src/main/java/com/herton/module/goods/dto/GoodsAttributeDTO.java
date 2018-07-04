package com.herton.module.goods.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.goods.domain.GoodsAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("商品属性")
public class GoodsAttributeDTO extends BaseDTO<GoodsAttribute> {
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "商品属性id")
    private String goodsTypeAttributeId;
    @ApiModelProperty(value = "商品属性值")
    private String goodsTypeAttributeValue;
}
