package com.herton.module.orderform.service;

import com.herton.common.AbstractCrudService;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.service.CodeNumberService;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.dto.PurchaseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PurchaseOrderServiceImpl extends AbstractCrudService<PurchaseOrder, PurchaseOrderDTO> implements PurchaseOrderService {
    private final CodeNumberService codeNumberService;

    @Override
    public PurchaseOrderDTO save(PurchaseOrderDTO purchaseOrderDTO) throws Exception {
        codeNumberService.generateNextCode(CodeNumber.BusinessType.JHD);
        purchaseOrderDTO.setOrderNumber(codeNumberService.getCodeByBusinessType(CodeNumber.BusinessType.JHD));
        return super.save(purchaseOrderDTO);
    }

    @Autowired
    public PurchaseOrderServiceImpl(
            CodeNumberService codeNumberService
    ) {
        this.codeNumberService = codeNumberService;
    }
}
