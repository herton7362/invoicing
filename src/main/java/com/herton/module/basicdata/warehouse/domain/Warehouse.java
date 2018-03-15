package com.herton.module.basicdata.warehouse.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
