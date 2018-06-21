package com.herton.module.orderform.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.service.CodeNumberService;
import com.herton.module.goods.service.GoodsService;
import com.herton.module.goods.sku.service.GoodsSkuService;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.domain.PurchaseOrderRepository;
import com.herton.module.orderform.domain.PurchaseOrderSku;
import com.herton.module.orderform.web.PurchaseOrderResult;
import com.herton.module.orderform.web.PurchaseOrderSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class PurchaseOrderServiceImpl extends AbstractCrudService<PurchaseOrder> implements PurchaseOrderService {
    private final PurchaseOrderSkuService purchaseOrderSkuService;
    private final CodeNumberService codeNumberService;
    private final GoodsSkuService goodsSkuService;

    @Override
    public void save(PurchaseOrderSaveParam purchaseOrderSaveParam) throws Exception {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(purchaseOrderSaveParam, purchaseOrder);
        codeNumberService.generateNextCode(CodeNumber.BusinessType.JHD);
        purchaseOrder.setOrderNumber(codeNumberService.getCodeByBusinessType(CodeNumber.BusinessType.JHD));

        super.save(purchaseOrder);
        final List<PurchaseOrderSku> purchaseOrderSkus =  purchaseOrderSaveParam.getPurchaseOrderSkus();
        for (PurchaseOrderSku orderSkus : purchaseOrderSkus) {
            orderSkus.setPurchaseOrderId(purchaseOrder.getId());
            purchaseOrderSkuService.save(orderSkus);
        }
    }

    @Override
    public PageResult<PurchaseOrderResult> findAllTranslated(PageRequest pageRequest, Map<String, String[]> param) throws Exception {
        PageResult<PurchaseOrder> page = super.findAll(pageRequest, param);
        PageResult<PurchaseOrderResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<PurchaseOrderResult> findAllTranslated(Map<String, String[]> param) throws Exception {
        return translateResults(super.findAll(param));
    }

    private PurchaseOrderResult translateResult(PurchaseOrder purchaseOrder) throws Exception {
        PurchaseOrderResult purchaseOrderResult = new PurchaseOrderResult();
        BeanUtils.copyProperties(purchaseOrder, purchaseOrderResult);
        Map<String, String> param = new HashMap<>();
        param.put("purchaseOrderId", purchaseOrder.getId());
        List<PurchaseOrderSku> purchaseOrderSkus = purchaseOrderSkuService.findAll(param);
        List<PurchaseOrderResult.PurchaseOrderSkuResult> purchaseOrderSkuResults = new ArrayList<>();
        PurchaseOrderResult.PurchaseOrderSkuResult purchaseOrderSkuResult;
        for (PurchaseOrderSku purchaseOrderSku : purchaseOrderSkus) {
            purchaseOrderSkuResult = new PurchaseOrderResult.PurchaseOrderSkuResult();
            BeanUtils.copyProperties(purchaseOrderSku, purchaseOrderSkuResult);
            purchaseOrderSkuResult.setGoodsSku(goodsSkuService.findOneTranslated(purchaseOrderSku.getSkuId()));
            purchaseOrderSkuResults.add(purchaseOrderSkuResult);
        }
        purchaseOrderResult.setSkus(purchaseOrderSkuResults);
        return purchaseOrderResult;
    }

    private List<PurchaseOrderResult> translateResults(List<PurchaseOrder> purchaseOrders) throws Exception {
        List<PurchaseOrderResult> purchaseOrderResults = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            purchaseOrderResults.add(this.translateResult(purchaseOrder));
        }
        return purchaseOrderResults;
    }

    @Autowired
    public PurchaseOrderServiceImpl(
            PurchaseOrderSkuService purchaseOrderSkuService,
            CodeNumberService codeNumberService,
            GoodsSkuService goodsSkuService
    ) {
        this.purchaseOrderSkuService = purchaseOrderSkuService;
        this.codeNumberService = codeNumberService;
        this.goodsSkuService = goodsSkuService;
    }
}
