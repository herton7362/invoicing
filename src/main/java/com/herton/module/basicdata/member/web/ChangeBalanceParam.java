package com.herton.module.basicdata.member.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("充值")
public class ChangeBalanceParam {
    @ApiModelProperty(value = "充值金额")
    private Double value;
    @ApiModelProperty(value = "赠送金额")
    private Double extra;
    @ApiModelProperty(value = "收款账户id")
    private String receiveAccountId;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getExtra() {
        return extra;
    }

    public void setExtra(Double extra) {
        this.extra = extra;
    }

    public String getReceiveAccountId() {
        return receiveAccountId;
    }

    public void setReceiveAccountId(String receiveAccountId) {
        this.receiveAccountId = receiveAccountId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
