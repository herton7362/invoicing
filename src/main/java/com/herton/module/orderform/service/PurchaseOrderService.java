package com.herton.module.orderform.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.orderform.domain.PurchaseOrder;
import com.herton.module.orderform.dto.PurchaseOrderDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderService extends CrudService<PurchaseOrder> {
    /**
     * 保存采购订单
     * @param purchaseOrderDTO 参数
     */
    void save(PurchaseOrderDTO purchaseOrderDTO) throws Exception;
    /**
     * 分页查询，并且转译结果
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link PurchaseOrderDTO} spring boot 分页类
     */
    PageResult<PurchaseOrderDTO> findAllTranslated(PageRequest pageRequest, Map<String, String[]> param) throws Exception;

    /**
     * 查询，并且转译结果
     * @param param 查询条件
     * @return {@link PurchaseOrderDTO} spring boot 分页类
     */
    List<PurchaseOrderDTO> findAllTranslated(Map<String, String[]> param) throws Exception;
}
