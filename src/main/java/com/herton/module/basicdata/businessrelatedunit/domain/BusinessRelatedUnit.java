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
public class BusinessRelatedUnit extends BaseEntity{
    @Column(length = 100)
    private String name;
    @Column(length = 20)
    private String code;
    @Column(length = 20)
    private String shortname;
    @Column(length = 50)
    private String pinyin;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(length = 50)
    private String taxNumber;
    @Column(length = 3)
    private Integer taxRate;
    @Column(length = 20)
    private String linkman;
    @Column(length = 20)
    private String telephone;
    @Column(length = 20)
    private String mobile;
    @Column(length = 100)
    private String email;
    @Column(length = 20)
    private String priceLevel;
    @Column(length = 500)
    private String detailAddress;
    @Column(length = 200)
    private String depositBank;
    @Column(length = 50)
    private String bankAccount;
    @Column(length = 200)
    private String remark;
    @Column(length = 11, precision = 13, scale = 2)
    private Double openingPayableAmount = 0D;
    @Column(length = 11, precision = 13, scale = 2)
    private Double openingReceivableAmount = 0D;
    @Column(length = 11, precision = 13, scale = 2)
    private Double nowPayableAmount = 0D;
    @Column(length = 11, precision = 13, scale = 2)
    private Double nowReceivableAmount = 0D;
    @Column(length = 11, precision = 13, scale = 2)
    private Double creditLine;
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
