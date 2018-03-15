package com.herton.module.basicdata.store.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.store.domain.Store;
import com.herton.module.basicdata.store.service.StoreService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "门店管理")
@RestController
@RequestMapping("/api/store")
public class StoreController extends AbstractCrudController<Store> {
    private final StoreService storeService;
    @Override
    protected CrudService<Store> getService() {
        return storeService;
    }

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
}
