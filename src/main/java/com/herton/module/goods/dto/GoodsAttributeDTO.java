package com.herton.module.goods.dto;

import com.herton.common.utils.StringUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.Parent;
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
public class GoodsAttributeDTO extends BaseDTO<GoodsAttributeDTO, GoodsAttribute> {
    @Parent
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "商品属性id")
    private String goodsTypeAttributeId;
    @ApiModelProperty(value = "商品属性值")
    private String goodsTypeAttributeValue;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof GoodsAttributeDTO)) {
            return false;
        }
        GoodsAttributeDTO dto = (GoodsAttributeDTO) obj;
        if(StringUtils.isNotBlank(this.getGoodsTypeAttributeId())
                && StringUtils.isNotBlank(this.getGoodsTypeAttributeValue())
                && StringUtils.isNotBlank(this.getGoodsId())) {
            return this.getGoodsTypeAttributeId().equals(dto.getGoodsTypeAttributeId())
                    && this.getGoodsTypeAttributeValue().equals(dto.getGoodsTypeAttributeValue())
                    && this.getGoodsId().equals(dto.getGoodsId());
        }
        return super.equals(obj);
    }
}
