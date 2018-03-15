package com.herton.module.basicdata.member.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("积分转换储值")
public class ExchangePointsToBalanceParam {
    @ApiModelProperty(value = "使用积分")
    private Integer points;
    @ApiModelProperty(value = "转化储值")
    private Double balance;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
