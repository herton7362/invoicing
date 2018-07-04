package com.herton.module.goods.type.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.goods.type.domain.GoodsTypeAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("商品属性")
public class GoodsTypeAttributeDTO extends BaseDTO<GoodsTypeAttribute> {
    @ApiModelProperty(value = "商品类型id")
    private String goodsTypeId;
    @ApiModelProperty(value = "属性名称")
    private String name;
    @ApiModelProperty(value = "属性值，用逗号分隔")
    private String attrValues;
}
