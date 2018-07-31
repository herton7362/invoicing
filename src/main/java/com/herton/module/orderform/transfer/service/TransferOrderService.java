package com.herton.module.orderform.transfer.service;

import com.herton.common.CrudService;
import com.herton.module.orderform.transfer.domain.TransferOrder;
import com.herton.module.orderform.transfer.dto.TransferOrderDTO;
import com.herton.module.orderform.purchase.dto.PurchaseOrderDTO;

public interface TransferOrderService extends CrudService<TransferOrder, TransferOrderDTO> {
    /**
     * 从采购订单生成送货单
     * @param purchaseOrderDTO 采购订单
     */
    void generateDeliverOrder(PurchaseOrderDTO purchaseOrderDTO);

    /**
     * 根据原始单据查询送货单
     * @param originOrderId 原始单据id
     * @return 送货单
     */
    TransferOrder findOneByOriginOrderId(String originOrderId);
}
