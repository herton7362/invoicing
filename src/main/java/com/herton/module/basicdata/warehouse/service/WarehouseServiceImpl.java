package com.herton.module.basicdata.warehouse.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import com.herton.module.basicdata.warehouse.domain.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class WarehouseServiceImpl extends AbstractCrudService<Warehouse> implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
    @Override
    protected PageRepository<Warehouse> getRepository() {
        return warehouseRepository;
    }

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
}
