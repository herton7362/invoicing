package com.herton.module.orderform.transfer.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.service.CodeNumberService;
import com.herton.module.orderform.purchase.dto.PurchaseOrderSkuDTO;
import com.herton.module.orderform.transfer.domain.QTransferOrder;
import com.herton.module.orderform.transfer.domain.TransferOrder;
import com.herton.module.orderform.transfer.dto.TransferOrderDTO;
import com.herton.module.orderform.purchase.dto.PurchaseOrderDTO;
import com.herton.module.orderform.transfer.dto.TransferOrderSkuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class TransferOrderServiceImpl extends AbstractCrudService<TransferOrder, TransferOrderDTO>
        implements TransferOrderService {
    private final CodeNumberService codeNumberService;
    @Override
    public void generateDeliverOrder(PurchaseOrderDTO purchaseOrderDTO) {
        if(StringUtils.isBlank(purchaseOrderDTO.getBusinessRelatedUnitId())) {
            throw new InvalidParamException("供应商id不能为空");
        }
        if(purchaseOrderDTO.getBookTransferDate() == null) {
            throw new InvalidParamException("预订交货日期不能为空");
        }
        if(StringUtils.isBlank(purchaseOrderDTO.getWarehouseId())) {
            throw new InvalidParamException("交货仓库id不能为空");
        }
        TransferOrderDTO transferOrderDTO = new TransferOrderDTO();
        codeNumberService.generateNextCode(CodeNumber.BusinessType.SHD);
        transferOrderDTO.setOrderNumber(codeNumberService.getCodeByBusinessType(CodeNumber.BusinessType.SHD));
        transferOrderDTO.setBusinessRelatedUnitId(purchaseOrderDTO.getBusinessRelatedUnitId());
        transferOrderDTO.setOriginOrderId(purchaseOrderDTO.getId());
        transferOrderDTO.setOriginOrderNumber(purchaseOrderDTO.getOrderNumber());
        transferOrderDTO.setStatus(TransferOrder.OrderStatus.DELIVERING);
        transferOrderDTO.setWarehouseId(purchaseOrderDTO.getWarehouseId());

        List<PurchaseOrderSkuDTO> purchaseOrderSkuDTOS = purchaseOrderDTO.getItems();
        if(purchaseOrderSkuDTOS == null || purchaseOrderSkuDTOS.isEmpty()) {
            throw new InvalidParamException("采购订单条目不能为空");
        }
        List<TransferOrderSkuDTO> transferOrderSkuDTOS = new ArrayList<>();
        TransferOrderSkuDTO transferOrderSkuDTO;
        for (PurchaseOrderSkuDTO purchaseOrderSkuDTO : purchaseOrderSkuDTOS) {
            transferOrderSkuDTO = new TransferOrderSkuDTO();
            transferOrderSkuDTO.setGoodsId(purchaseOrderSkuDTO.getGoodsId());
            transferOrderSkuDTO.setSkuId(purchaseOrderSkuDTO.getSkuId());
            transferOrderSkuDTO.setNeedTransferCount(purchaseOrderSkuDTO.getCount());
            transferOrderSkuDTO.setTransferredCount(0D);
            transferOrderSkuDTOS.add(transferOrderSkuDTO);
        }
        transferOrderDTO.setItems(transferOrderSkuDTOS);
        super.save(transferOrderDTO);
    }

    @Override
    public TransferOrder findOneByOriginOrderId(String originOrderId) {
        if(StringUtils.isBlank(originOrderId)) {
            return null;
        }
        QTransferOrder qTransferOrder = QTransferOrder.transferOrder;
        TransferOrder transferOrder = this.queryFactory
                .selectFrom(qTransferOrder).where(qTransferOrder.originOrderId.eq(originOrderId)).fetchFirst();
        return transferOrder;
    }

    @Autowired
    public TransferOrderServiceImpl(CodeNumberService codeNumberService) {
        this.codeNumberService = codeNumberService;
    }
}
