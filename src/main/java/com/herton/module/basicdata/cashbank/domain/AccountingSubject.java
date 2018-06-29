package com.herton.module.basicdata.cashbank.domain;

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
    private Double openingBalance = 0D;
    @ApiModelProperty(value = "期末余额")
    @Column(length = 11, precision = 13, scale = 2)
    private Double endingBalance = 0D;
    @ApiModelProperty(value = "会计科目类型")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Type type;

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
