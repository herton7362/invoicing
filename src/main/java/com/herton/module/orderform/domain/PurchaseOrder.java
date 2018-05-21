package com.herton.module.orderform.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
@ApiModel("采购订单")
public class PurchaseOrder extends BaseEntity {
    @ApiModelProperty(value = "订单号")
    @Column(length = 36)
    private String orderNumber;
    @ApiModelProperty(value = "经手人")
    @Column(length = 36)
    private String operator;
    @ApiModelProperty(value = "预定交货日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date deliveryDate;
    @ApiModelProperty(value = "摘要")
    @Column(length = 500)
    private String summary;
    @ApiModelProperty(value = "附加说明")
    @Column(length = 500)
    private String remark;
    @ApiModelProperty(value = "交货到")
    @Column(length = 36)
    private String warehouseId;
    @ApiModelProperty(value = "供应商")
    @Column(length = 36)
    private String businessRelatedUnitId;
    @ApiModelProperty(value = "订单状态")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getBusinessRelatedUnitId() {
        return businessRelatedUnitId;
    }

    public void setBusinessRelatedUnitId(String businessRelatedUnitId) {
        this.businessRelatedUnitId = businessRelatedUnitId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

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
