package com.herton.module.basicdata.cashbank.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.basicdata.cashbank.domain.AccountingSubject;
import com.herton.module.basicdata.cashbank.domain.AccountingSubjectRepository;
import com.herton.module.basicdata.cashbank.dto.AccountingSubjectDTO;
import com.herton.module.basicdata.cashbank.web.EditOpeningBalanceParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@Transactional
public class AccountingSubjectServiceImpl extends AbstractCrudService<AccountingSubject, AccountingSubjectDTO> implements AccountingSubjectService {

    @Override
    public void editOpeningBalance(String id, EditOpeningBalanceParam editOpeningBalanceParam) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("科目id不能为空");
        }
        AccountingSubjectDTO accountingSubject = findOne(id);
        BigDecimal value = new BigDecimal(editOpeningBalanceParam.getOpeningBalance()).subtract(new BigDecimal(accountingSubject.getOpeningBalance()));
        accountingSubject.setOpeningBalance(editOpeningBalanceParam.getOpeningBalance());
        accountingSubject.setEndingBalance(new BigDecimal(accountingSubject.getEndingBalance()).add(value).doubleValue());
        super.save(accountingSubject);
    }
}
