package com.herton.module.basicdata.member.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.member.domain.MemberCard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Setter
@Getter
@Component
@ApiModel("会员卡")
public class MemberCardDTO extends BaseDTO<MemberCard> {
    @ApiModelProperty(value = "会员卡号")
    private String cardNumber;
    @ApiModelProperty(value = "会员卡类型id")
    private String memberCardTypeId;
    @ApiModelProperty(value = "会员id")
    private String memberId;
    @ApiModelProperty(value = "储值余额")
    private Double balance;
    @ApiModelProperty(value = "积分")
    private Integer points;
    @ApiModelProperty(value = "折扣")
    private Double discount;
    @ApiModelProperty(value = "过期日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date expireDate;
    @ApiModelProperty(value = "支付密码")
    private String password;
}
