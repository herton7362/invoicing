package com.herton.module.basicdata.member.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@ApiModel("会员卡")
public class MemberCard extends BaseEntity {
    @ApiModelProperty(value = "会员卡号")
    @Column(length = 20)
    private String cardNumber;
    @ApiModelProperty(value = "会员卡类型id")
    @Column(length = 36)
    private String memberCardTypeId;
    @ApiModelProperty(value = "会员id")
    @Column(length = 36)
    private String memberId;
    @ApiModelProperty(value = "储值余额")
    @Column(length = 11, precision = 13, scale = 2)
    private Double balance;
    @ApiModelProperty(value = "积分")
    @Column(length = 11)
    private Integer points;
    @ApiModelProperty(value = "折扣")
    @Column(length = 3, precision = 3, scale = 2)
    private Double discount;
    @ApiModelProperty(value = "过期日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date expireDate;
    @ApiModelProperty(value = "支付密码")
    private String password;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMemberCardTypeId() {
        return memberCardTypeId;
    }

    public void setMemberCardTypeId(String memberCardTypeId) {
        this.memberCardTypeId = memberCardTypeId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
