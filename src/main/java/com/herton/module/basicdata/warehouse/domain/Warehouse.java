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
public class Warehouse extends BaseEntity {
    @Column(length = 50)
    private String name;
    @Column(length = 20)
    private String code;
    @Column(length = 20)
    private String shortname;
    @Column(length = 20)
    private String pinyin;
    @Column(length = 100)
    private String remark;
    @Column(length = 20)
    private String linkman;
    @Column(length = 20)
    private String telephone;
    @Column(length = 20)
    private String zipCode;
    @Column(length = 36)
    private String addressId;
    @Column(length = 500)
    private String shippingAddress;
}
