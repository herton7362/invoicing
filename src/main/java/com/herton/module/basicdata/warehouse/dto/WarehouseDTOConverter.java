package com.herton.module.basicdata.warehouse.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class WarehouseDTOConverter extends SimpleDTOConverter<WarehouseDTO, Warehouse> {
}
