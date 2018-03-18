package com.herton.module.basicdata.businessrelatedunit.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("修改期初应收应付款")
public class EditReceivablePayableAmountParam {
    @ApiModelProperty(value = "期初应收款")
    private Double openingReceivableAmount;
    @ApiModelProperty(value = "期初应付款")
    private Double openingPayableAmount;

    public Double getOpeningReceivableAmount() {
        return openingReceivableAmount;
    }

    public void setOpeningReceivableAmount(Double openingReceivableAmount) {
        this.openingReceivableAmount = openingReceivableAmount;
    }

    public Double getOpeningPayableAmount() {
        return openingPayableAmount;
    }

    public void setOpeningPayableAmount(Double openingPayableAmount) {
        this.openingPayableAmount = openingPayableAmount;
    }
}
