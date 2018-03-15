package com.herton.module.basicdata.store.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.basicdata.store.domain.Store;
import com.herton.module.basicdata.store.domain.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StoreServiceImpl extends AbstractCrudService<Store> implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    protected PageRepository<Store> getRepository() {
        return storeRepository;
    }

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
}
