package com.herton.module.pos.session.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import com.herton.module.orderform.purchase.domain.PurchaseOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class PosSession extends BaseEntity {
    @Column(length = 100)
    private String SessionId;
    @Column(length = 36)
    private String adminId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date endDate;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ONGOING("进行中"),
        CONFIRMED("已确认");
        private String displayName;
        Status(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
