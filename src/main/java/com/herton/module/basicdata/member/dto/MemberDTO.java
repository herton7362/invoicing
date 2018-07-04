package com.herton.module.basicdata.member.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.member.domain.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Component
@ApiModel("会员")
public class MemberDTO extends BaseDTO<Member> {
    @ApiModelProperty(value = "会员编号")
    private String code;
    @ApiModelProperty(value = "会员名")
    private String name;
    @ApiModelProperty(value = "证件号码")
    private String licenseNumber;
    @ApiModelProperty(value = "录入方式")
    @Enumerated(EnumType.STRING)
    private Member.InputManner inputManner;
    @ApiModelProperty(value = "备注")
    private String remark;
}
