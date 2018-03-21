package com.herton.module.goods.property.web;

import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("商品属性")
public class GoodsPropertyGroupSaveParam extends GoodsPropertyGroup {
    @ApiModelProperty(value = "商品属性id集合")
    private List<String> groupPropertyId;
    @ApiModelProperty(value = "商品属性值id集合")
    private List<String> groupPropertyValueId;

    public List<String> getGroupPropertyId() {
        return groupPropertyId;
    }

    public void setGroupPropertyId(List<String> groupPropertyId) {
        this.groupPropertyId = groupPropertyId;
    }

    public List<String> getGroupPropertyValueId() {
        return groupPropertyValueId;
    }

    public void setGroupPropertyValueId(List<String> groupPropertyValueId) {
        this.groupPropertyValueId = groupPropertyValueId;
    }
}
