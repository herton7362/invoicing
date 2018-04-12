package com.herton.module.orderform.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@ApiModel("采购订单")
public class PurchaseOrder extends BaseEntity {
    @ApiModelProperty(value = "经手人")
    @Column(length = 36)
    private String operator;
    @ApiModelProperty(value = "数据创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date deliveryDate;
    @ApiModelProperty(value = "摘要")
    @Column(length = 500)
    private String summary;
    @ApiModelProperty(value = "附加说明")
    @Column(length = 500)
    private String remark;
    @ApiModelProperty(value = "仓库id")
    @Column(length = 36)
    private String warehouseId;
    @ApiModelProperty(value = "供应商id")
    @Column(length = 36)
    private String businessRelatedUnitId;

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
}
