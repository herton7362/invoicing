package com.herton.module.orderform.deliver.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import com.herton.module.orderform.purchase.domain.PurchaseOrder;
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
public class DeliverOrder extends BaseEntity {
    @Column(length = 36)
    private String originOrderId;
    @Column(length = 36)
    private String originOrderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date deliveryDate;
    @Column(length = 36)
    private String warehouseId;
    @Column(length = 36)
    private String businessRelatedUnitId;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public enum OrderStatus {
        CANCEL("已取消"),
        DELIVERING("送货中"),
        COMPLETED("已完成");
        private String displayName;
        OrderStatus(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
