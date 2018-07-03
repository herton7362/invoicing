package com.herton.module.basicdata.warehouse.dto;

import com.herton.dto.DTOConverter;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class WarehouseDTOConverter extends DTOConverter<WarehouseDTO, Warehouse> {
    @Override
    protected Warehouse doForward(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = new Warehouse();
        BeanUtils.copyProperties(warehouseDTO, warehouse);
        return warehouse;
    }

    @Override
    protected WarehouseDTO doBackward(Warehouse warehouse) {
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        BeanUtils.copyProperties(warehouse, warehouseDTO);
        return warehouseDTO;
    }
}
