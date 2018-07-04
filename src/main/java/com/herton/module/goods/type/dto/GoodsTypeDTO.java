package com.herton.module.goods.type.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.goods.type.domain.GoodsType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ApiModel("商品类型")
public class GoodsTypeDTO extends BaseDTO<GoodsTypeDTO, GoodsType> {
    @ApiModelProperty(value = "类型名称")
    private String name;

    @ApiModelProperty(value = "商品属性")
    private List<GoodsTypeAttributeDTO> goodsTypeAttributes;
}
