package com.herton.module.basicdata.cashbank.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("修改期初金额")
public class EditOpeningBalanceParam {
    @ApiModelProperty(value = "金额")
    public Double openingBalance;

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }
}
