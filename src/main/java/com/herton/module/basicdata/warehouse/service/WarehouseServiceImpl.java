package com.herton.module.basicdata.warehouse.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import com.herton.module.basicdata.warehouse.domain.WarehouseRepository;
import com.herton.module.basicdata.warehouse.dto.WarehouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class WarehouseServiceImpl extends AbstractCrudService<Warehouse, WarehouseDTO> implements WarehouseService {
}
