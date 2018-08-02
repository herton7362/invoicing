package com.herton.module.pos.orderform.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class PosOrder extends BaseEntity {
    @Column(length = 36)
    private String orderNumber;
    @Column(length = 36)
    private String operator;
    @Column(length = 36)
    private String posSessionId;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public enum OrderStatus {
        NEW("新建"),
        PAYED("已支付");
        private String displayName;
        OrderStatus(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
