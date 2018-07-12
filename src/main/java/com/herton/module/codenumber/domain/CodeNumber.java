package com.herton.module.codenumber.domain;

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
public class CodeNumber extends BaseEntity {
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;
    @Column(length = 20)
    private String nextCode;

    public enum BusinessType {
        JHD("进货订单"),
        SHD("送货单");
        private String displayName;
        BusinessType(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
