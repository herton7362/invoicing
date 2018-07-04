package com.herton.module.basicdata.store.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.basicdata.store.domain.Store;
import com.herton.module.basicdata.store.domain.StoreRepository;
import com.herton.module.basicdata.store.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StoreServiceImpl extends AbstractCrudService<Store, StoreDTO> implements StoreService {
    private final CounterService counterService;

    @Override
    public Integer getCounterCount(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("门店id不能为空");
        }
        return counterService.getStoreCounterCount(id);
    }

    @Autowired
    public StoreServiceImpl(
            CounterService counterService
    ) {
        this.counterService = counterService;
    }
}
