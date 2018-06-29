package com.herton.module.basicdata.warehouse.domain;

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
@ApiModel("仓库")
public class Warehouse extends BaseEntity {
    @ApiModelProperty(value = "仓库名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "仓库编号")
    @Column(length = 20)
    private String code;
    @ApiModelProperty(value = "仓库简名")
    @Column(length = 20)
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    @Column(length = 20)
    private String pinyin;
    @ApiModelProperty(value = "备注")
    @Column(length = 100)
    private String remark;
    @ApiModelProperty(value = "联系人")
    @Column(length = 20)
    private String linkman;
    @ApiModelProperty(value = "联系电话")
    @Column(length = 20)
    private String telephone;
    @ApiModelProperty(value = "邮政编码")
    @Column(length = 20)
    private String zipCode;
    @ApiModelProperty(value = "地址")
    @Column(length = 36)
    private String addressId;
    @ApiModelProperty(value = "发货地址")
    @Column(length = 500)
    private String shippingAddress;
}
