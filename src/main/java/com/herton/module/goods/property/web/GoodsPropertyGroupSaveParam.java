package com.herton.module.goods.property.web;

import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品属性")
public class GoodsPropertyGroupSaveParam extends GoodsPropertyGroup {
    @ApiModelProperty(value = "商品属性id集合")
    private List<String> groupPropertyIds;
    @ApiModelProperty(value = "商品属性值id集合")
    private List<String> groupPropertyValueIds;

    public List<String> getGroupPropertyIds() {
        return groupPropertyIds;
    }

    public void setGroupPropertyIds(List<String> groupPropertyIds) {
        this.groupPropertyIds = groupPropertyIds;
    }

    public List<String> getGroupPropertyValueIds() {
        return groupPropertyValueIds;
    }

    public void setGroupPropertyValueIds(List<String> groupPropertyValueIds) {
        this.groupPropertyValueIds = groupPropertyValueIds;
    }
}
