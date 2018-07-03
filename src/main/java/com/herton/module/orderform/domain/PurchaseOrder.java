package com.herton.module.orderform.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PurchaseOrder extends BaseEntity {
    @Column(length = 36)
    private String orderNumber;
    @Column(length = 36)
    private String operator;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date deliveryDate;
    @Column(length = 500)
    private String summary;
    @Column(length = 500)
    private String remark;
    @Column(length = 36)
    private String warehouseId;
    @Column(length = 36)
    private String businessRelatedUnitId;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public enum OrderStatus {
        CANCEL("已取消"),
        DRAFT("草稿"),
        NORMAL("正常");
        private String displayName;
        OrderStatus(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
