package com.herton.module.basicdata.member.domain;

import com.herton.entity.BaseUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Setter
@Getter
public class Member extends BaseUser {
    @Column(length = 20)
    private String code;
    @Column(length = 10)
    private String name;
    @Column(length = 50)
    private String licenseNumber;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private InputManner inputManner;
    @Column(length = 200)
    private String remark;

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
