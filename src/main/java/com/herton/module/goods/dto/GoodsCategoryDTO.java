package com.herton.module.goods.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.goods.domain.GoodsCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("商品分类")
public class GoodsCategoryDTO extends BaseDTO<GoodsCategory> {
    @ApiModelProperty(value = "上级分类id")
    private String parentId;
    @ApiModelProperty(value = "名称")
    private String name;
}
