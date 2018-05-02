package com.herton.module.basicdata.businessrelatedunit.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnitRepository;
import com.herton.module.basicdata.businessrelatedunit.web.EditCreditLineParam;
import com.herton.module.basicdata.businessrelatedunit.web.EditReceivablePayableAmountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@Transactional
public class BusinessRelatedUnitServiceImpl extends AbstractCrudService<BusinessRelatedUnit> implements BusinessRelatedUnitService {
    private final BusinessRelatedUnitRepository businessRelatedUnitRepository;
    @Override
    protected PageRepository<BusinessRelatedUnit> getRepository() {
        return businessRelatedUnitRepository;
    }

    @Override
    public void editReceivablePayableAmount(String id, EditReceivablePayableAmountParam editReceivablePayableAmountParam) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("单位id不能为空");
        }
        BusinessRelatedUnit businessRelatedUnit = findOne(id);
        BigDecimal value = new BigDecimal(editReceivablePayableAmountParam.getOpeningReceivableAmount())
                .subtract(new BigDecimal(businessRelatedUnit.getOpeningReceivableAmount()));
        businessRelatedUnit.setOpeningReceivableAmount(editReceivablePayableAmountParam.getOpeningReceivableAmount());
        businessRelatedUnit.setNowReceivableAmount(new BigDecimal(businessRelatedUnit.getNowReceivableAmount()).add(value).doubleValue());
        value = new BigDecimal(editReceivablePayableAmountParam.getOpeningPayableAmount())
                .subtract(new BigDecimal(businessRelatedUnit.getOpeningPayableAmount()));
        businessRelatedUnit.setOpeningPayableAmount(editReceivablePayableAmountParam.getOpeningPayableAmount());
        businessRelatedUnit.setNowPayableAmount(new BigDecimal(businessRelatedUnit.getNowPayableAmount()).add(value).doubleValue());
        businessRelatedUnitRepository.save(businessRelatedUnit);
    }

    @Override
    public void editCreditLine(String id, EditCreditLineParam editCreditLineParam) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("单位id不能为空");
        }
        BusinessRelatedUnit businessRelatedUnit = findOne(id);
        if(editCreditLineParam.getCreditLineEnable() && businessRelatedUnit.getNowReceivableAmount() > editCreditLineParam.getCreditLine()) {
            throw new InvalidParamException("信用额度不能小于单位的应收账款" + businessRelatedUnit.getNowReceivableAmount());
        }
        businessRelatedUnit.setCreditLineEnable(editCreditLineParam.getCreditLineEnable());
        businessRelatedUnit.setCreditLine(editCreditLineParam.getCreditLine());
        businessRelatedUnitRepository.save(businessRelatedUnit);
    }

    @Autowired
    public BusinessRelatedUnitServiceImpl(BusinessRelatedUnitRepository businessRelatedUnitRepository) {
        this.businessRelatedUnitRepository = businessRelatedUnitRepository;
    }
}
