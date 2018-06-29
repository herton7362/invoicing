package com.herton.module.basicdata.member.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Setter
@Getter
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
}
