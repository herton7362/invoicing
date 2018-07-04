package com.herton.module.basicdata.cashbank.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Setter
@Getter
public class AccountingSubject extends BaseEntity{
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String code;
    @Column(length = 20)
    private String shortname;
    @Column(length = 20)
    private String pinyin;
    @Column(length = 200)
    private String remark;
    @Column(length = 11, precision = 13, scale = 2)
    private Double openingBalance = 0D;
    @Column(length = 11, precision = 13, scale = 2)
    private Double endingBalance = 0D;
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
