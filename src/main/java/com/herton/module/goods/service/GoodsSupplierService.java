package com.herton.module.goods.service;

import com.herton.common.CrudService;
import com.herton.module.goods.domain.GoodsSupplier;
import com.herton.module.goods.dto.GoodsSupplierDTO;

import java.util.List;

public interface GoodsSupplierService extends CrudService<GoodsSupplier, GoodsSupplierDTO> {
    void save(Boolean isCreate, String goodsId, List<GoodsSupplierDTO> goodsSuppliers) throws Exception;
}
