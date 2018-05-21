package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsSupplier;
import com.herton.module.goods.domain.GoodsSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsSupplierServiceImpl extends AbstractCrudService<GoodsSupplier> implements GoodsSupplierService {
    private final GoodsSupplierRepository goodsSupplierRepository;
    @Override
    protected PageRepository<GoodsSupplier> getRepository() {
        return goodsSupplierRepository;
    }

    @Autowired
    public GoodsSupplierServiceImpl(GoodsSupplierRepository goodsSupplierRepository) {
        this.goodsSupplierRepository = goodsSupplierRepository;
    }
}
