package com.herton.module.orderform.transfer.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class TransferOrderSku extends BaseEntity {
    @Column(length = 36)
    private String transferOrderId;
    @Column(length = 36)
    private String goodsId;
    @Column(length = 36)
    private String skuId;
    @Column(length = 11, scale = 2, precision = 13)
    private Double needTransferCount;
    @Column(length = 11, scale = 2, precision = 13)
    private Double transferredCount;
}
