package com.herton.module.basicdata.businessrelatedunit.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Setter
@Getter
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
