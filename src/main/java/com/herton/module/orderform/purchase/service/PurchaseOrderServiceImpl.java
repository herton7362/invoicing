package com.herton.module.orderform.purchase.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.service.CodeNumberService;
import com.herton.module.orderform.purchase.domain.PurchaseOrder;
import com.herton.module.orderform.purchase.dto.PurchaseOrderDTO;
import com.herton.module.orderform.transfer.service.TransferOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderServiceImpl extends AbstractCrudService<PurchaseOrder, PurchaseOrderDTO> implements PurchaseOrderService {
    private final CodeNumberService codeNumberService;
    private final TransferOrderService transferOrderService;

    @Override
    public PurchaseOrderDTO save(PurchaseOrderDTO purchaseOrderDTO) throws Exception {
        if(StringUtils.isBlank(purchaseOrderDTO.getBusinessRelatedUnitId())) {
            throw new InvalidParamException("供应商id不能为空");
        }
        if(purchaseOrderDTO.getBookTransferDate() == null) {
            throw new InvalidParamException("预订交货日期不能为空");
        }
        if(StringUtils.isBlank(purchaseOrderDTO.getWarehouseId())) {
            throw new InvalidParamException("交货仓库id不能为空");
        }
        codeNumberService.generateNextCode(CodeNumber.BusinessType.JHD);
        purchaseOrderDTO.setOrderNumber(codeNumberService.getCodeByBusinessType(CodeNumber.BusinessType.JHD));
        // 确认订单生成配送单
        if(purchaseOrderDTO.getStatus() == PurchaseOrder.OrderStatus.CONFIRMED) {
            transferOrderService.generateDeliverOrder(purchaseOrderDTO);
        }
        return super.save(purchaseOrderDTO);
    }

    @Autowired
    public PurchaseOrderServiceImpl(
            CodeNumberService codeNumberService,
            TransferOrderService transferOrderService
    ) {
        this.codeNumberService = codeNumberService;
        this.transferOrderService = transferOrderService;
    }
}
