package com.herton.module.member.domain;

import com.herton.entity.BaseUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@ApiModel("会员")
public class Member extends BaseUser {
    @ApiModelProperty(value = "会员编号")
    @Column(length = 20)
    private String code;
    @ApiModelProperty(value = "会员名")
    @Column(length = 10)
    private String name;
    @ApiModelProperty(value = "证件号码")
    @Column(length = 50)
    private String licenseNumber;
    @ApiModelProperty(value = "录入方式")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private InputManner inputManner;
    @ApiModelProperty(value = "备注")
    @Column(length = 200)
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public InputManner getInputManner() {
        return inputManner;
    }

    public void setInputManner(InputManner inputManner) {
        this.inputManner = inputManner;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public enum InputManner {
        ARTIFICIAL("手动录入"),
        EXCEL_IMPORT("excel导入");
        private String displayName;
        InputManner(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
