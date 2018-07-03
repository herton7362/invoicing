package com.herton.module.orderform.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageResult;
import com.herton.common.utils.CacheUtils;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.service.CodeNumberService;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.dto.PurchaseOrderDTO;
import com.herton.module.orderform.dto.PurchaseOrderSkuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class PurchaseOrderServiceImpl extends AbstractCrudService<PurchaseOrder, PurchaseOrderDTO> implements PurchaseOrderService {
    private final CacheUtils cache = CacheUtils.getInstance();
    private final PurchaseOrderSkuService purchaseOrderSkuService;
    private final CodeNumberService codeNumberService;

    @Override
    public PurchaseOrderDTO save(PurchaseOrderDTO purchaseOrderDTO) throws Exception {
        codeNumberService.generateNextCode(CodeNumber.BusinessType.JHD);
        purchaseOrderDTO.setOrderNumber(codeNumberService.getCodeByBusinessType(CodeNumber.BusinessType.JHD));
        PurchaseOrder purchaseOrder = pageRepository.save(purchaseOrderDTO.convert());
        final List<PurchaseOrderSkuDTO> purchaseOrderSkuDTOList =  purchaseOrderDTO.getItems();
        for (PurchaseOrderSkuDTO purchaseOrderSkuDTO : purchaseOrderSkuDTOList) {
            purchaseOrderSkuDTO.setPurchaseOrderId(purchaseOrderDTO.getId());
            purchaseOrderSkuService.save(purchaseOrderSkuDTO);
        }
        purchaseOrderDTO = purchaseOrderDTO.convertFor(purchaseOrder);
        cache.set(purchaseOrderDTO.getId(), purchaseOrderDTO);
        return purchaseOrderDTO;
    }

    @Autowired
    public PurchaseOrderServiceImpl(
            PurchaseOrderSkuService purchaseOrderSkuService,
            CodeNumberService codeNumberService
    ) {
        this.purchaseOrderSkuService = purchaseOrderSkuService;
        this.codeNumberService = codeNumberService;
    }
}
