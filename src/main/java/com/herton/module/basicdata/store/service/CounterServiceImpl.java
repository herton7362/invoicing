package com.herton.module.basicdata.store.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.BusinessException;
import com.herton.module.basicdata.store.domain.Counter;
import com.herton.module.basicdata.store.domain.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class CounterServiceImpl extends AbstractCrudService<Counter> implements CounterService {
    private final CounterRepository counterRepository;
    @Override
    protected PageRepository<Counter> getRepository() {
        return counterRepository;
    }

    @Autowired
    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public Integer getStoreCounterCount(String storeId) throws Exception {
        if(StringUtils.isBlank(storeId)) {
            throw new BusinessException("门店id不能为空");
        }
        Map<String, String[]> params = new HashMap<>();
        params.put("storeId", new String[]{storeId});
        return Long.valueOf(counterRepository.count(getSpecification(params))).intValue();
    }
}
