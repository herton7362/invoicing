package com.herton.module.basicdata.member.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("变更积分")
public class ChangePointsParam {
    @ApiModelProperty(value = "变更积分")
    private Integer value;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
