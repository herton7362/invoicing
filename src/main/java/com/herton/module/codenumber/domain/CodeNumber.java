package com.herton.module.codenumber.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
@Setter
@Getter
@ApiModel("编号管理")
public class CodeNumber extends BaseEntity {
    @ApiModelProperty(value = "业务类型")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;
    @ApiModelProperty(value = "下一个编码")
    @Column(length = 20)
    private String nextCode;

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
