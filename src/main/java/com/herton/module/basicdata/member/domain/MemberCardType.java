package com.herton.module.basicdata.member.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ApiModel("会员卡类型")
public class MemberCardType extends BaseEntity {
    @ApiModelProperty(value = "类型名称")
    @Column(length = 10)
    private String name;
    @ApiModelProperty(value = "折扣")
    @Column(length = 3, precision = 3, scale = 2)
    private Double discount;
    @ApiModelProperty(value = "备注")
    @Column(length = 100)
    private String remark;
}
