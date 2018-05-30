package com.herton.module.goods.service;

import com.herton.common.CrudService;
import com.herton.module.goods.domain.GoodsSupplier;

import java.util.List;

public interface GoodsSupplierService extends CrudService<GoodsSupplier> {
    void save(Boolean isCreate, String goodsId, List<GoodsSupplier> goodsSuppliers) throws Exception;
}
