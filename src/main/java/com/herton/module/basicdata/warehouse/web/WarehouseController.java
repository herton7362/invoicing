package com.herton.module.basicdata.warehouse.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import com.herton.module.basicdata.warehouse.service.WarehouseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "仓库管理")
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController extends AbstractCrudController<Warehouse> {
    private final WarehouseService warehouseService;
    @Override
    protected CrudService<Warehouse> getService() {
        return warehouseService;
    }

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }
}
