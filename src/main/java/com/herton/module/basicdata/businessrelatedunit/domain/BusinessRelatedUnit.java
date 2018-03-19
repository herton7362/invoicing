package com.herton.module.basicdata.businessrelatedunit.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@ApiModel("往来单位")
public class BusinessRelatedUnit extends BaseEntity{
    @ApiModelProperty(value = "单位名称")
    @Column(length = 100)
    private String name;
    @ApiModelProperty(value = "单位编号")
    @Column(length = 20)
    private String code;
    @ApiModelProperty(value = "简名")
    @Column(length = 20)
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    @Column(length = 50)
    private String pinyin;
    @ApiModelProperty(value = "类型")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Type type;
    @ApiModelProperty(value = "税号")
    @Column(length = 50)
    private String taxNumber;
    @ApiModelProperty(value = "税率（%）")
    @Column(length = 3)
    private Integer taxRate;
    @ApiModelProperty(value = "联系人")
    @Column(length = 20)
    private String linkman;
    @ApiModelProperty(value = "电话")
    @Column(length = 20)
    private String telephone;
    @ApiModelProperty(value = "手机")
    @Column(length = 20)
    private String mobile;
    @ApiModelProperty(value = "电子邮件")
    @Column(length = 100)
    private String email;
    @ApiModelProperty(value = "价格等级")
    @Column(length = 20)
    private String priceLevel;
    @ApiModelProperty(value = "地址")
    @Column(length = 500)
    private String detailAddress;
    @ApiModelProperty(value = "开户银行")
    @Column(length = 200)
    private String depositBank;
    @ApiModelProperty(value = "银行账号")
    @Column(length = 50)
    private String bankAccount;
    @ApiModelProperty(value = "备注")
    @Column(length = 200)
    private String remark;
    @ApiModelProperty(value = "期初应付款")
    @Column(length = 11, precision = 13, scale = 2)
    private Double openingPayableAmount = 0D;
    @ApiModelProperty(value = "期初应收款")
    @Column(length = 11, precision = 13, scale = 2)
    private Double openingReceivableAmount = 0D;
    @ApiModelProperty(value = "当前应付款")
    @Column(length = 11, precision = 13, scale = 2)
    private Double nowPayableAmount = 0D;
    @ApiModelProperty(value = "当前应收款")
    @Column(length = 11, precision = 13, scale = 2)
    private Double nowReceivableAmount = 0D;
    @ApiModelProperty(value = "信用额度")
    @Column(length = 11, precision = 13, scale = 2)
    private Double creditLine;
    @ApiModelProperty(value = "信用额度启用状态")
    private Boolean creditLineEnable = false;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getOpeningPayableAmount() {
        return openingPayableAmount;
    }

    public void setOpeningPayableAmount(Double openingPayableAmount) {
        this.openingPayableAmount = openingPayableAmount;
    }

    public Double getOpeningReceivableAmount() {
        return openingReceivableAmount;
    }

    public void setOpeningReceivableAmount(Double openingReceivableAmount) {
        this.openingReceivableAmount = openingReceivableAmount;
    }

    public Double getNowPayableAmount() {
        return nowPayableAmount;
    }

    public void setNowPayableAmount(Double nowPayableAmount) {
        this.nowPayableAmount = nowPayableAmount;
    }

    public Double getNowReceivableAmount() {
        return nowReceivableAmount;
    }

    public void setNowReceivableAmount(Double nowReceivableAmount) {
        this.nowReceivableAmount = nowReceivableAmount;
    }

    public Double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Double creditLine) {
        this.creditLine = creditLine;
    }

    public Boolean getCreditLineEnable() {
        return creditLineEnable;
    }

    public void setCreditLineEnable(Boolean creditLineEnable) {
        this.creditLineEnable = creditLineEnable;
    }

    public enum Type {
        VENDOR("供货商"),
        CUSTOMER("客户");
        private String displayName;
        Type(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
