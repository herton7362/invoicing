package com.herton.module.goods.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.goods.domain.GoodsSupplier;
import com.herton.module.goods.dto.GoodsSupplierDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsSupplierServiceImpl extends AbstractChildCrudService<GoodsSupplier, GoodsSupplierDTO>
        implements GoodsSupplierService {
}
