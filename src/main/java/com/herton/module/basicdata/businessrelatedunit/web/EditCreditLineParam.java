package com.herton.module.basicdata.businessrelatedunit.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("设置信用额度")
public class EditCreditLineParam {
    @ApiModelProperty(value = "启用信用额度管理")
    private Boolean creditLineEnable;
    @ApiModelProperty(value = "信用额度")
    private Double creditLine;

    public Boolean getCreditLineEnable() {
        return creditLineEnable;
    }

    public void setCreditLineEnable(Boolean creditLineEnable) {
        this.creditLineEnable = creditLineEnable;
    }

    public Double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Double creditLine) {
        this.creditLine = creditLine;
    }
}
