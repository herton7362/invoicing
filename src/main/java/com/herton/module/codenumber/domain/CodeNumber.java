package com.herton.module.codenumber.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
@ApiModel("编号管理")
public class CodeNumber extends BaseEntity {
    @ApiModelProperty(value = "业务类型")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;
    @ApiModelProperty(value = "下一个编码")
    @Column(length = 20)
    private String nextCode;

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getNextCode() {
        return nextCode;
    }

    public void setNextCode(String nextCode) {
        this.nextCode = nextCode;
    }

    public enum BusinessType {
        JHD("进货订单");
        private String displayName;
        BusinessType(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}