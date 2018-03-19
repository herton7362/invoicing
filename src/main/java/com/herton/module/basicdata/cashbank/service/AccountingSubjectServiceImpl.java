package com.herton.module.basicdata.cashbank.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.BusinessException;
import com.herton.module.basicdata.cashbank.domain.AccountingSubject;
import com.herton.module.basicdata.cashbank.domain.AccountingSubjectRepository;
import com.herton.module.basicdata.cashbank.web.EditOpeningBalanceParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@Transactional
public class AccountingSubjectServiceImpl extends AbstractCrudService<AccountingSubject> implements AccountingSubjectService {
    private final AccountingSubjectRepository accountingSubjectRepository;
    @Override
    protected PageRepository<AccountingSubject> getRepository() {
        return accountingSubjectRepository;
    }

    @Override
    public void editOpeningBalance(String id, EditOpeningBalanceParam editOpeningBalanceParam) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new BusinessException("科目id不能为空");
        }
        AccountingSubject accountingSubject = findOne(id);
        BigDecimal value = new BigDecimal(editOpeningBalanceParam.getOpeningBalance()).subtract(new BigDecimal(accountingSubject.getOpeningBalance()));
        accountingSubject.setOpeningBalance(editOpeningBalanceParam.getOpeningBalance());
        accountingSubject.setEndingBalance(new BigDecimal(accountingSubject.getEndingBalance()).add(value).doubleValue());
        accountingSubjectRepository.save(accountingSubject);
    }

    @Autowired
    public AccountingSubjectServiceImpl(AccountingSubjectRepository accountingSubjectRepository) {
        this.accountingSubjectRepository = accountingSubjectRepository;
    }
}
