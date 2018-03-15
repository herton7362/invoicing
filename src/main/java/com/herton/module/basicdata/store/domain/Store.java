package com.herton.module.basicdata.store.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
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

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStartBusinessTime() {
        return startBusinessTime;
    }

    public void setStartBusinessTime(String startBusinessTime) {
        this.startBusinessTime = startBusinessTime;
    }

    public String getCloseBusinessTime() {
        return closeBusinessTime;
    }

    public void setCloseBusinessTime(String closeBusinessTime) {
        this.closeBusinessTime = closeBusinessTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(String storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
