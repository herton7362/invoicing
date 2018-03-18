package com.herton.module.basicdata.businessrelatedunit.service;

import com.herton.common.CrudService;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import com.herton.module.basicdata.businessrelatedunit.web.EditReceivablePayableAmountParam;

public interface BusinessRelatedUnitService extends CrudService<BusinessRelatedUnit> {
    /**
     * 修改期初应收应付款
     * @param id 往来单位id
     * @param editReceivablePayableAmountParam 参数
     */
    void editReceivablePayableAmount(String id, EditReceivablePayableAmountParam editReceivablePayableAmountParam) throws Exception;
}
