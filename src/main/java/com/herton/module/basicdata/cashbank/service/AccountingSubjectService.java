package com.herton.module.basicdata.cashbank.service;

import com.herton.common.CrudService;
import com.herton.module.basicdata.cashbank.domain.AccountingSubject;
import com.herton.module.basicdata.cashbank.web.EditOpeningBalanceParam;

public interface AccountingSubjectService extends CrudService<AccountingSubject> {
    /**
     * 修改期初余额
     * @param id 会计科目id
     * @param editOpeningBalanceParam 参数
     */
    void editOpeningBalance(String id, EditOpeningBalanceParam editOpeningBalanceParam) throws Exception;
}
