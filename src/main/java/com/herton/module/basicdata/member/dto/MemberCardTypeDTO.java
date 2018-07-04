package com.herton.module.basicdata.member.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.member.domain.MemberCardType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Setter
@Getter
@Component
@ApiModel("会员卡类型")
public class MemberCardTypeDTO extends BaseDTO<MemberCardTypeDTO, MemberCardType> {
    @ApiModelProperty(value = "类型名称")
    private String name;
    @ApiModelProperty(value = "折扣")
    private Double discount;
    @ApiModelProperty(value = "备注")
    private String remark;
}
