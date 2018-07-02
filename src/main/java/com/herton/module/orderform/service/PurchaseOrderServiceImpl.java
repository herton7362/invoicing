package com.herton.module.orderform.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageResult;
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
public class PurchaseOrderServiceImpl extends AbstractCrudService<PurchaseOrder> implements PurchaseOrderService {
    private final PurchaseOrderSkuService purchaseOrderSkuService;
    private final CodeNumberService codeNumberService;

    @Override
    public void save(PurchaseOrderDTO purchaseOrderDTO) throws Exception {
        PurchaseOrder purchaseOrder = purchaseOrderDTO.convert();
        codeNumberService.generateNextCode(CodeNumber.BusinessType.JHD);
        purchaseOrder.setOrderNumber(codeNumberService.getCodeByBusinessType(CodeNumber.BusinessType.JHD));

        super.save(purchaseOrder);
        final List<PurchaseOrderSkuDTO> purchaseOrderSkuDTOList =  purchaseOrderDTO.getItems();
        for (PurchaseOrderSkuDTO purchaseOrderSkuDTO : purchaseOrderSkuDTOList) {
            purchaseOrderSkuDTO.setPurchaseOrderId(purchaseOrder.getId());
            purchaseOrderSkuService.save(purchaseOrderSkuDTO.convert());
        }
    }

    @Override
    public PageResult<PurchaseOrderDTO> findAllTranslated(PageRequest pageRequest, Map<String, String[]> param) throws Exception {
        PageResult<PurchaseOrder> page = super.findAll(pageRequest, param);
        PageResult<PurchaseOrderDTO> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<PurchaseOrderDTO> findAllTranslated(Map<String, String[]> param) throws Exception {
        return translateResults(super.findAll(param));
    }

    private List<PurchaseOrderDTO> translateResults(List<PurchaseOrder> purchaseOrders) throws Exception {
        List<PurchaseOrderDTO> purchaseOrderResults = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            purchaseOrderResults.add(new PurchaseOrderDTO().convertFor(purchaseOrder));
        }
        return purchaseOrderResults;
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
