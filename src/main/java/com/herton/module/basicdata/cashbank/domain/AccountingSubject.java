package com.herton.module.basicdata.cashbank.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@ApiModel("会计科目")
public class AccountingSubject extends BaseEntity{
    @ApiModelProperty(value = "科目名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "科目编号")
    @Column(length = 50)
    private String code;
    @ApiModelProperty(value = "科目简名")
    @Column(length = 20)
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    @Column(length = 20)
    private String pinyin;
    @ApiModelProperty(value = "备注")
    @Column(length = 200)
    private String remark;
    @ApiModelProperty(value = "期初余额")
    @Column(length = 11, precision = 13, scale = 2)
    private Double openingBalance;
    @ApiModelProperty(value = "期末余额")
    @Column(length = 11, precision = 13, scale = 2)
    private Double endingBalance;
    @ApiModelProperty(value = "会计科目类型")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Type type;

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

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Double getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(Double endingBalance) {
        this.endingBalance = endingBalance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        CASH_BANK("现金银行"),
        EXPENDITURE("费用支出");
        private String displayName;
        Type(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
