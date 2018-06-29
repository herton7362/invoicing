package com.herton.module.basicdata.store.domain;

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
@ApiModel("门店")
public class Store extends BaseEntity {
    @ApiModelProperty(value = "门店名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "门店编码")
    @Column(length = 50)
    private String code;
    @ApiModelProperty(value = "仓库id")
    @Column(length = 36)
    private String warehouseId;
    @ApiModelProperty(value = "开始营业时间")
    @Column(length = 8)
    private String startBusinessTime;
    @ApiModelProperty(value = "关闭营业时间")
    @Column(length = 8)
    private String closeBusinessTime;
    @ApiModelProperty(value = "门店介绍")
    @Column(length = 200)
    private String description;
    @ApiModelProperty(value = "店长id")
    @Column(length = 36)
    private String storeManagerId;
    @ApiModelProperty(value = "门店地址id")
    @Column(length = 36)
    private String addressId;
    @ApiModelProperty(value = "邮编")
    @Column(length = 20)
    private String zipCode;
    @ApiModelProperty(value = "详细地址")
    @Column(length = 400)
    private String detailAddress;
    @ApiModelProperty(value = "联系人")
    @Column(length = 20)
    private String linkman;
    @ApiModelProperty(value = "手机")
    @Column(length = 20)
    private String mobile;
    @ApiModelProperty(value = "固定电话")
    @Column(length = 20)
    private String telephone;
    @ApiModelProperty(value = "传真")
    @Column(length = 20)
    private String fax;
    @ApiModelProperty(value = "备注")
    @Column(length = 200)
    private String remark;
}
